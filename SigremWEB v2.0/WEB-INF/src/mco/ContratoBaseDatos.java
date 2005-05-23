package mco;

import mmu.MultaBaseDatos;
import mcl.ClienteBaseDatos;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContratoBaseDatos 
{
	public static String asignaCodigo(DataSource dataSource) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Contrato empleado = null;
		String codigo=null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(codigoContrato) as codigo from contratos");
			if (rs.next())
			{	codigo=rs.getString("codigo");
				if (codigo!=null)
				{	String numero=codigo.substring(0,4);
					int num=Integer.valueOf(codigo.substring(4)).intValue();
					numero=numero+(num+1);
					codigo=numero;
				}
				else
				{	codigo="CO000";}
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
		
	public static Contrato dameContrato(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Contrato contrato = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from contratos where codigoContrato=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	contrato=new Contrato();
				contrato.setCodigoContrato(rs.getString("codigoContrato"));
				contrato.setFechaAlta(rs.getString("fechaAlta"));
				contrato.setFechaBaja(rs.getString("fechaBaja"));
				contrato.setMatricula(rs.getString("matricula"));
				contrato.setCodigoCliente(rs.getString("codigoCliente"));
			}
			else 
			{	throw new Exception("Contrato " + codigo + " no encontrado");}
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
		return contrato;
	}
	
	public static ArrayList dameContratos(DataSource dataSource) 
	{
		Contrato contrato = null;
	    ArrayList contratos = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from contratos");
			while (rs.next()) 
			{	contrato=new Contrato();
				contrato.setCodigoContrato(rs.getString("codigoContrato"));
				contrato.setFechaAlta(rs.getString("fechaAlta"));
				contrato.setFechaBaja(rs.getString("fechaBaja"));
				contrato.setMatricula(rs.getString("matricula"));
				contrato.setCodigoCliente(rs.getString("codigoCliente"));
				contratos.add(contrato);
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
	    return contratos;
	}
	
	public static ArrayList dameContratosCliente(String codigo,DataSource dataSource) 
	{
		Contrato contrato = null;
	    ArrayList contratos = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from contratos where codigoCliente=\'"+ codigo + "'");
			while (rs.next()) 
			{	contrato=new Contrato();
				contrato.setCodigoContrato(rs.getString("codigoContrato"));
				contrato.setFechaAlta(rs.getString("fechaAlta"));
				contrato.setFechaBaja(rs.getString("fechaBaja"));
				contrato.setMatricula(rs.getString("matricula"));
				contrato.setCodigoCliente(rs.getString("codigoCliente"));
				contratos.add(contrato);
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
	    return contratos;
	}
	
	public static void eliminaContrato(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt2 = conn.createStatement();
			rs2=stmt2.executeQuery("select codigoCliente from contratos where codigoContrato=\'"+ codigo + "'");
			StringBuffer sqlString=new StringBuffer("delete from contratos where codigoContrato='" + codigo + "'");
			stmt.execute(sqlString.toString());
			String cliente=rs2.getString("codigoCliente");
			rs = stmt.executeQuery("select codigoMulta from multas where codigoContrato=\'"+ codigo + "'");
			while (rs.next())
			{	MultaBaseDatos.eliminaMulta(rs.getString("codigoMulta"),dataSource);}
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

	public static void insertaContrato(Contrato contrato, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into contratos ");
			sqlString.append("values (\""+contrato.getCodigoContrato()+ "\", ");
			sqlString.append("\"" +contrato.getMatricula()+ "\", ");
			sqlString.append("\""+contrato.getFechaAlta()+ "\", ");
			sqlString.append("\""+contrato.getFechaBaja()+ "\", ");
			sqlString.append("\""+contrato.getCodigoCliente()+ "\")");
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
	
	public static void modificaContrato(Contrato contrato, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update contratos ");
      		sqlString.append("set fechaAlta='"+ contrato.getFechaAlta()+ "', ");
      		sqlString.append("fechaBaja='"+ contrato.getFechaBaja()+ "'");
      		sqlString.append(" where codigoContrato='"+ contrato.getCodigoContrato()+ "'");
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
	
	public static int calcularFacturacion(DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int facturacion=0;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		rs=stmt.executeQuery("select count(*) as numcontratos from contratos");
      		if (rs.next())
      		{	facturacion=rs.getInt("numcontratos")*150;}
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
		return facturacion;
	}
}