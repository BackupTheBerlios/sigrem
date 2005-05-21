package mmu;

import mre.RecursoBaseDatos;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MultaBaseDatos 
{
	public static String asignaCodigo(DataSource dataSource) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Multa empleado = null;
		String codigo=null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(codigoMulta) as codigo from multas");
			if (rs.next())
			{	codigo=rs.getString("codigo");
				if (codigo!=null)
				{	String numero=codigo.substring(0,4);
					int num=Integer.valueOf(codigo.substring(4)).intValue();
					numero=numero+(num+1);
					codigo=numero;
				}
				else
				{	codigo="MU000";}
			}
		}
		finally 
		{	if ( rs != null ) {
				rs.close();
      		}	
      		if ( stmt != null ) {
      			stmt.close();
      		}
      		if ( conn != null ) {
      			conn.close();
      		}
		}
		return codigo;		
	}
		
	public static Multa dameMulta(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Multa multa = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from multas where codigoMulta=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	multa=new Multa();
				multa.setCodigoMulta(rs.getString("codigoMulta"));
				multa.setExpediente(rs.getString("expediente"));
				multa.setBoletin(rs.getString("boletin"));
				multa.setFechaDenuncia(rs.getString("fechaDenuncia"));
				multa.setInfraccion(rs.getString("infraccion"));
				multa.setCodigoContrato(rs.getString("codigoContrato"));
				multa.setDescripcion(rs.getString("descripcion"));
			}
			else 
			{	throw new Exception("Empleado " + codigo + " no encontrado");}
		}
		finally 
		{	if ( rs != null ) {
				rs.close();
      		}	
      		if ( stmt != null ) {
      			stmt.close();
      		}
      		if ( conn != null ) {
      			conn.close();
      		}
		}
		return multa;
	}
	
	public static ArrayList dameMultas(String codigo, DataSource dataSource) 
	{
		Multa empleado = null;
	    ArrayList empleados = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from multas where codigoContrato=\'"+ codigo + "'");
			while (rs.next()) 
			{	Multa multa=new Multa();
				multa.setCodigoMulta(rs.getString("codigoMulta"));
				multa.setExpediente(rs.getString("expediente"));
				multa.setBoletin(rs.getString("boletin"));
				multa.setFechaDenuncia(rs.getString("fechaDenuncia"));
				multa.setInfraccion(rs.getString("infraccion"));
				multa.setCodigoContrato(rs.getString("codigoContrato"));
				multa.setDescripcion(rs.getString("descripcion"));
				empleados.add(multa);
			}
		}	
	    catch ( SQLException e ) 
		{	System.err.println(e.getMessage());
		}
	    finally 
		{	if ( rs != null ){
			try{	
				rs.close();}
				catch ( SQLException sqle ) 
				{	System.err.println(sqle.getMessage());}
				rs = null;
			}
			if ( stmt != null ) {
				try {
					stmt.close();
				}
				catch ( SQLException sqle ) {
					System.err.println(sqle.getMessage());
				}
				stmt = null;
			}
			if ( conn != null ) {
				try {
					conn.close();
				}
				catch ( SQLException sqle ) {
					System.err.println(sqle.getMessage());
				}
				conn = null;
			}
		}
	    return empleados;
	}
	
	public static void eliminaMulta(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString=new StringBuffer("delete from multas where codigoMulta='" + codigo + "'");
			stmt.execute(sqlString.toString());
			rs = stmt.executeQuery("select codigoRecurso from recursos where codigoMulta=\'"+ codigo + "'");
			while (rs.next())
			{	RecursoBaseDatos.eliminaRecurso(rs.getString("codigoRecurso"),dataSource);}
		}
		finally {
			if ( rs != null ) {
				rs.close();
			}
			if ( stmt != null ) {
				stmt.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}

	public static void insertaMulta(Multa multa, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into multas ");
			sqlString.append("values (\""+multa.getCodigoMulta()+ "\", ");
			sqlString.append("\"" +multa.getExpediente()+ "\", ");
			sqlString.append("\""+multa.getBoletin()+ "\", ");
			sqlString.append("\""+multa.getFechaDenuncia()+ "\", ");
			sqlString.append("\""+multa.getInfraccion()+ "\", ");
			sqlString.append("\""+multa.getDescripcion()+ "\", ");
			sqlString.append("\""+multa.getCodigoContrato()+ "\")");
			stmt.execute(sqlString.toString());
		}
		finally {
			if ( stmt != null ) {
				stmt.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}
	
	public static void modificaMulta(Multa multa, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update multas ");
      		sqlString.append("set fechaDenuncia='"+ multa.getFechaDenuncia()+ "', ");
      		sqlString.append("infraccion='"+ multa.getInfraccion()+ "', ");
      		sqlString.append("descripcion='"+ multa.getDescripcion() + "'");
      		sqlString.append(" where codigoMulta='"+ multa.getCodigoMulta()+ "'");
      		stmt.execute(sqlString.toString());
		}
		finally {
			if ( rs != null ) {
				rs.close();
			}
			if ( stmt != null ) {
				stmt.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}
}