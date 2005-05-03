package mem;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoBaseDatos 
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
			rs = stmt.executeQuery("select max(codigo) as codigo from empleados");
			if (rs.next())
			{	codigo=rs.getString("codigo");
				if (codigo!=null)
				{	String numero=codigo.substring(0,4);
					int num=Integer.valueOf(codigo.substring(4)).intValue();
					numero=numero+(num+1);
					codigo=numero;
				}
				else
				{	codigo="EM000";}
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
		
	public static Empleado dameEmpleado(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Empleado empleado = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empleados where codigo=\'"+ codigo + "'");
			if ( rs.next() ) 
			{	empleado=new Empleado();
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
				empleado.setNomina(rs.getString("nomina"));
				empleado.setPerfil(rs.getString("perfil"));
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
		return empleado;
	}
	
	public static Empleado dameEmpleadoDni(String dni, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Empleado empleado = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select codigo,nombre from empleados where dni=\'"+ dni + "'");
			if ( rs.next() ) 
			{	empleado=new Empleado();
				empleado.setCodigo(rs.getString("codigo"));
				empleado.setNombre(rs.getString("nombre"));
			}
			else 
			{	throw new Exception("Empleado " + dni + " no encontrado");}
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
	
	public static ArrayList dameEmpleados(DataSource dataSource) 
	{
		Empleado empleado = null;
	    ArrayList empleados = new ArrayList();
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from empleados");
			while (rs.next()) 
			{	empleado = new Empleado();
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
				empleado.setNomina(rs.getString("nomina"));
				empleado.setPerfil(rs.getString("perfil"));
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
	
	public static void eliminaEmpleado(String codigo, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString=new StringBuffer("delete from empleados where codigo='" + codigo + "'");
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

	public static void insertaEmpleado(Empleado empleado, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into empleados ");
			sqlString.append("values (\""+empleado.getCodigo()+ "\", ");
			sqlString.append("\"" +empleado.getPerfil()+ "\", ");
			sqlString.append("\""+empleado.getDni()+ "\", ");
			sqlString.append("\""+empleado.getNombre()+ "\", ");
			sqlString.append("\""+empleado.getDireccion()+ "\", ");
			sqlString.append("\""+empleado.getCp()+ "\", ");
			sqlString.append("\""+empleado.getPoblacion()+ "\", ");
			sqlString.append("\""+empleado.getProvincia()+ "\", ");
			sqlString.append("\""+empleado.getTelefono1()+ "\", ");
			sqlString.append("\""+empleado.getTelefono2()+ "\", ");
			sqlString.append("\""+empleado.getMovil()+ "\", ");
			sqlString.append("\""+empleado.getEmail()+ "\", ");
			sqlString.append("\""+empleado.getFax()+ "\", ");
			sqlString.append("\""+empleado.getNomina()+ "\")");
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
	
	public static void modificaEmpleado(Empleado empleado, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update empleados ");
      		sqlString.append("set direccion='"+ empleado.getDireccion()+ "', ");
      		sqlString.append("cp='"+ empleado.getCp()+ "', ");
      		sqlString.append("poblacion='"+ empleado.getPoblacion() + "', ");
      		sqlString.append("provincia='"+ empleado.getProvincia() + "', ");
      		sqlString.append("telefono1='"+ empleado.getTelefono1() + "', ");
      		sqlString.append("telefono2='"+ empleado.getTelefono2()+ "', ");
      		sqlString.append("movil='"+ empleado.getMovil()+ "', ");
      		sqlString.append("email='"+ empleado.getEmail()+ "', ");
      		sqlString.append("fax='"+ empleado.getFax()+ "', ");
      		sqlString.append("nomina='"+ empleado.getNomina()+"'");
      		sqlString.append(" where codigo='"+ empleado.getCodigo()+ "'");
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
	
	public static int calcularGastos(DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int nominas=0;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		rs=stmt.executeQuery("select sum(nomina) as nomina from empleados");
      		if (rs.next())
      		{	nominas=rs.getInt("nomina");}
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
		return nominas;
	}
}