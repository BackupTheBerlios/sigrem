package mcl;

import login.UsuarioBaseDatos;
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
		Cliente cliente = null;
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
		Cliente cliente = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from clientes where codigo=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	cliente=new Cliente();
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDni(rs.getString("dni"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setCp(rs.getString("cp"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setProvincia(rs.getString("provincia"));
				cliente.setTelefono1(rs.getString("telefono1"));
				cliente.setTelefono2(rs.getString("telefono2"));
				cliente.setMovil(rs.getString("movil"));
				cliente.setEmail(rs.getString("email"));
				cliente.setFax(rs.getString("fax"));
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
		return cliente;
	}
	
	public static Cliente dameClienteDni(String dni, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select codigo,nombre from clientes where dni=\'"+ dni + "'");
			if ( rs.next() ) 
			{	cliente=new Cliente();
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNombre(rs.getString("nombre"));
			}
			else 
			{	throw new Exception("Cliente " + dni + " no encontrado");}
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
		return cliente;
	}
	
	public static ArrayList dameClientes(DataSource dataSource) 
	{
		Cliente cliente = null;
	    ArrayList clientes = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from clientes");
			while (rs.next()) 
			{	cliente = new Cliente();
				cliente.setCodigo(rs.getString("codigo"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDni(rs.getString("dni"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setCp(rs.getString("cp"));
				cliente.setPoblacion(rs.getString("poblacion"));
				cliente.setProvincia(rs.getString("provincia"));
				cliente.setTelefono1(rs.getString("telefono1"));
				cliente.setTelefono2(rs.getString("telefono2"));
				cliente.setMovil(rs.getString("movil"));
				cliente.setEmail(rs.getString("email"));
				cliente.setFax(rs.getString("fax"));
				clientes.add(cliente);
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
	    return clientes;
	}
	
	public static void eliminaCliente(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select dni from clientes where codigo=\'"+ codigo + "'");
			if (rs.next())
			{	UsuarioBaseDatos.eliminaUsuario(rs.getString("dni"), dataSource);
				StringBuffer sqlString=new StringBuffer("delete from clientes where codigo='" + codigo + "'");
				stmt.execute(sqlString.toString());
			}
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