package mcl;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBaseDatos 
{
	public static String asignaCodigo(DataSource dataSource) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Cliente empleado = null;
		String codigo=null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select max(codigo) as codigo from clientes");
			if (rs.next())
			{	codigo=rs.getString("codigo");
				if (codigo!=null)
				{	String numero=codigo.substring(0,4);
					int num=Integer.valueOf(codigo.substring(4)).intValue();
					numero=numero+(num+1);
					codigo=numero;
				}
				else
				{	codigo="CL000";}
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
		
	public static Cliente dameCliente(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Cliente empleado = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from clientes where codigo=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	empleado=new Cliente();
				empleado.setCodigo(rs.getString("codigo"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setDni(rs.getString("dni"));
				empleado.setDireccion(rs.getString("direccion"));
				empleado.setCp(rs.getString("cp"));
				empleado.setPoblacion(rs.getString("poblacion"));
				empleado.setProvincia(rs.getString("provincia"));
				empleado.setTelefono1(rs.getString("telefono1"));
				empleado.setTelefono2(rs.getString("telefono2"));
				empleado.setMovil(rs.getString("movil"));
				empleado.setEmail(rs.getString("email"));
				empleado.setFax(rs.getString("fax"));
			}
			else 
			{	throw new Exception("Cliente " + codigo + " no encontrado");}
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
		return empleado;
	}
	
	public static ArrayList dameClientes(DataSource dataSource) 
	{
		Cliente empleado = null;
	    ArrayList empleados = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from clientes");
			while (rs.next()) 
			{	empleado = new Cliente();
				empleado.setCodigo(rs.getString("codigo"));
				empleado.setNombre(rs.getString("nombre"));
				empleado.setDni(rs.getString("dni"));
				empleado.setDireccion(rs.getString("direccion"));
				empleado.setCp(rs.getString("cp"));
				empleado.setPoblacion(rs.getString("poblacion"));
				empleado.setProvincia(rs.getString("provincia"));
				empleado.setTelefono1(rs.getString("telefono1"));
				empleado.setTelefono2(rs.getString("telefono2"));
				empleado.setMovil(rs.getString("movil"));
				empleado.setEmail(rs.getString("email"));
				empleado.setFax(rs.getString("fax"));
				empleados.add(empleado);
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
	
	public static void eliminaCliente(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString=new StringBuffer("delete from clientes where codigo='" + codigo + "'");
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

	public static void insertaCliente(Cliente cliente, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into clientes ");
			sqlString.append("values (\""+cliente.getCodigo()+ "\", ");
			sqlString.append("\""+cliente.getDni()+ "\", ");
			sqlString.append("\""+cliente.getNombre()+ "\", ");
			sqlString.append("\""+cliente.getDireccion()+ "\", ");
			sqlString.append("\""+cliente.getCp()+ "\", ");
			sqlString.append("\""+cliente.getPoblacion()+ "\", ");
			sqlString.append("\""+cliente.getProvincia()+ "\", ");
			sqlString.append("\""+cliente.getTelefono1()+ "\", ");
			sqlString.append("\""+cliente.getTelefono2()+ "\", ");
			sqlString.append("\""+cliente.getMovil()+ "\", ");
			sqlString.append("\""+cliente.getEmail()+ "\", ");
			sqlString.append("\""+cliente.getFax()+ "\")");
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
	
	public static void modificaCliente(Cliente cliente, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update clientes ");
      		sqlString.append("set direccion='"+ cliente.getDireccion()+ "', ");
      		sqlString.append("cp='"+ cliente.getCp()+ "', ");
      		sqlString.append("poblacion='"+ cliente.getPoblacion() + "', ");
      		sqlString.append("provincia='"+ cliente.getProvincia() + "', ");
      		sqlString.append("telefono1='"+ cliente.getTelefono1() + "', ");
      		sqlString.append("telefono2='"+ cliente.getTelefono2()+ "', ");
      		sqlString.append("movil='"+ cliente.getMovil()+ "', ");
      		sqlString.append("email='"+ cliente.getEmail()+ "', ");
      		sqlString.append("fax='"+ cliente.getFax()+ "'");
      		sqlString.append(" where codigo='"+ cliente.getCodigo()+ "'");
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