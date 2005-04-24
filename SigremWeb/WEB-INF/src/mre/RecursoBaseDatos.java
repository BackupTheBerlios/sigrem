package mre;

import javax.sql.DataSource;

import mem.Empleado;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecursoBaseDatos 
{
	public static String asignaCodigo(DataSource dataSource) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Empleado empleado = null;
		String codigo=null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(codigoRecurso) as codigo from recursos");
			if (rs.next())
			{	codigo=rs.getString("codigo");
				if (codigo!=null)
				{	String numero=codigo.substring(0,4);
					int num=Integer.valueOf(codigo.substring(4)).intValue();
					numero=numero+(num+1);
					codigo=numero;
				}
				else
				{	codigo="RE000";}
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
	
	
	public static Recurso dameRecurso(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		Recurso recurso = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			rs = stmt.executeQuery("select * from recursos where codigoRecurso=\'"+ codigo + "'");
			rs2 = stmt2.executeQuery("select codigoEmpleado from asignadorecursoempleado where codigoRecurso=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	recurso=new Recurso();
				recurso.setCodigoRecurso(rs.getString("codigoRecurso"));
				recurso.setFechaEmision(rs.getString("fechaEmision"));
				recurso.setEscritoPresentado(rs.getString("escritoPresentado"));
				recurso.setEscritoRecibido(rs.getString("escritoRecibido"));
				recurso.setEstado(rs.getString("estado"));
				recurso.setCodigoMulta(rs.getString("codigoMulta"));
				recurso.setDescripcion(rs.getString("descripcion"));
				if (rs2.next())
				{	recurso.setAbogado(rs2.getString("codigoEmpleado"));}
				else
				{	recurso.setAbogado("Sin asignar");}
			}
			else 
			{	throw new Exception("Recurso " + codigo + " no encontrado");}
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
      		if ( rs2 != null ) {
				rs2.close();
      		}
		}
		return recurso;
	}
	
	public static ArrayList dameRecursos(DataSource dataSource) 
	{
		Recurso recurso = null;
	    ArrayList recursos = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    Statement stmt2 = null;
	    ResultSet rs = null;
	    ResultSet rs2 = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			rs = stmt.executeQuery("select * from recursos");
			while (rs.next()) 
			{	recurso = new Recurso();
				String codigoR=rs.getString("codigoRecurso");
				recurso.setCodigoRecurso(codigoR);
				recurso.setFechaEmision(rs.getString("fechaEmision"));
				recurso.setEscritoPresentado(rs.getString("escritoPresentado"));
				recurso.setEscritoRecibido(rs.getString("escritoRecibido"));
				recurso.setEstado(rs.getString("estado"));
				recurso.setCodigoMulta(rs.getString("codigoMulta"));
				recurso.setDescripcion(rs.getString("descripcion"));
				rs2=stmt2.executeQuery("select codigoEmpleado from asignadorecursoempleado where codigoRecurso='"+codigoR+"'");
				if (rs2.next())
				{	String codigoE=rs2.getString("codigoEmpleado");
					recurso.setAbogado(codigoE);					
				}
				else
				{	recurso.setAbogado("Sin asignar");}
				recursos.add(recurso);
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
	    return recursos;
	}
	
	public static void eliminaRecurso(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString=new StringBuffer("delete from recursos where codigoRecurso='" + codigo + "'");
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

	public static void insertaRecurso(Recurso recurso, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;
		Statement stmt3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			stmt3 = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into recursos ");
			sqlString.append("values (\""+recurso.getCodigoRecurso()+ "\", ");
			sqlString.append("\"" +recurso.getFechaEmision()+ "\", ");
			sqlString.append("\""+recurso.getEscritoRecibido()+ "\", ");
			sqlString.append("\""+recurso.getEscritoPresentado()+ "\", ");
			sqlString.append("\""+recurso.getEstado()+ "\", ");
			sqlString.append("\""+recurso.getDescripcion()+ "\", ");
			sqlString.append("\""+recurso.getCodigoMulta()+ "\")");
			stmt.execute(sqlString.toString());
			rs2=stmt2.executeQuery("select codigo from empleados where codigo='"+recurso.getAbogado()+"'");
      		if (rs2.next())
      		{	sqlString=new StringBuffer("insert into asignadorecursoempleado ");
      			sqlString.append("values (\""+recurso.getCodigoRecurso()+ "\", ");
      			sqlString.append("\""+recurso.getAbogado()+ "\")");
      			stmt3.execute(sqlString.toString());
      		}
		}
		finally {
			if ( rs != null ) {
				rs.close();
			}
			if ( rs2 != null ) {
				rs2.close();
			}
			if ( stmt != null ) {
				stmt.close();
			}
			if ( stmt2 != null ) {
				stmt2.close();
			}
			if ( stmt3 != null ) {
				stmt3.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}
	
	public static void modificaRecurso(Recurso recurso, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt1 = null;
		Statement stmt2 = null;
		Statement stmt3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt1 = conn.createStatement();
      		stmt2 = conn.createStatement();
      		stmt3 = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update recursos ");
      		sqlString.append("set fechaEmision='"+ recurso.getFechaEmision()+ "', ");
      		sqlString.append("escritoRecibido='"+ recurso.getEscritoRecibido()+ "', ");
      		sqlString.append("escritoPresentado='"+ recurso.getEscritoPresentado() + "', ");
      		sqlString.append("estado='"+ recurso.getEstado() + "', ");
      		sqlString.append("descripcion='"+ recurso.getDescripcion() + "'");
      		sqlString.append(" where codigoRecurso='"+ recurso.getCodigoRecurso()+ "'");
      		stmt1.execute(sqlString.toString());
      		rs2=stmt2.executeQuery("select codigo from empleados where codigo='"+recurso.getAbogado()+"'");
      		if (rs2.next())
      		{	sqlString=new StringBuffer("insert into asignadorecursoempleado ");
      			sqlString.append("values (\""+recurso.getCodigoRecurso()+ "\", ");
      			sqlString.append("\""+recurso.getAbogado()+ "\")");
      			stmt3.execute(sqlString.toString());
      		}
		}
		finally {
			if ( rs != null ) {
				rs.close();
			}
			if ( rs2 != null ) {
				rs2.close();
			}
			if ( stmt1 != null ) {
				stmt1.close();
			}
			if ( stmt2 != null ) {
				stmt2.close();
			}
			if ( stmt3 != null ) {
				stmt3.close();
			}
			if ( conn != null ) {
				conn.close();
			}
		}
	}
}