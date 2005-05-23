package login;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioBaseDatos 
{
	public static Usuario dameUsuario(String nombre, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from usuarios where nombre=\'"+ nombre + "'");
			if ( rs.next() ) 
			{	usuario=new Usuario();
				usuario.setPassword(rs.getString("password"));
				usuario.setNombreUsuario(rs.getString("nombre"));
				usuario.setTipoUsuario(rs.getString("tipo"));
			}
			else 
			{	throw new Exception("Usuario " + nombre + " no encontrado");}
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
		return usuario;
	}
	
	public static ArrayList dameUsuarios(DataSource dataSource) 
	{
		Usuario usuario = null;
	    ArrayList usuarios = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from usuarios");
			while (rs.next()) 
			{	usuario = new Usuario();
				usuario.setPassword(rs.getString("password"));				
				usuario.setNombreUsuario(rs.getString("nombre"));
				usuario.setTipoUsuario(rs.getString("tipo"));
				usuarios.add(usuario);
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
	    return usuarios;
	}
	
	public static void eliminaUsuario(String nombre, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString=new StringBuffer("delete from usuarios where nombre='" + nombe + "'");
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

	public static void insertaUsuario(Usuario usuario, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into usuarios ");
			sqlString.append("values (\""+usuario.getNombreUsuario()+ "\", ");
			sqlString.append("\"" +usuario.getPassword()+ "\", ");
			sqlString.append("\""+usuario.getTipoUsuario()+ "\")");
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
	
	public static void modificaUsuario(Usuario usuario, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update usuarios ");
      		sqlString.append("set password='"+ usuario.getPassword()+ "'");
      		sqlString.append(" where nombre='"+ usuario.getNombreUsuario()+ "'");
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
