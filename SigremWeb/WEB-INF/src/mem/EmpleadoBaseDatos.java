package mem;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoBaseDatos 
{

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
				empleado.ponCodigo(rs.getString("codigo"));
				empleado.ponNombre(rs.getString("nombre"));
				empleado.ponDni(rs.getString("dni"));
				empleado.ponDireccion(rs.getString("direccion"));
				empleado.ponCp(rs.getString("cp"));
				empleado.ponPoblacion(rs.getString("poclacion"));
				empleado.ponProvincia(rs.getString("provincia"));
				empleado.ponTelefono1(rs.getString("telefono1"));
				empleado.ponTelefono2(rs.getString("telefono2"));
				empleado.ponMovil(rs.getString("movil"));
				empleado.ponEmail(rs.getString("email"));
				empleado.ponFax(rs.getString("fax"));
				empleado.ponNomina(rs.getString("nomina"));
				empleado.ponPerfil(rs.getString("perfil"));
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
				empleado.ponCodigo(rs.getString("codigo"));
				empleado.ponNombre(rs.getString("nombre"));
				empleado.ponDni(rs.getString("dni"));
				empleado.ponDireccion(rs.getString("direccion"));
				empleado.ponCp(rs.getString("cp"));
				empleado.ponPoblacion(rs.getString("poclacion"));
				empleado.ponProvincia(rs.getString("provincia"));
				empleado.ponTelefono1(rs.getString("telefono1"));
				empleado.ponTelefono2(rs.getString("telefono2"));
				empleado.ponMovil(rs.getString("movil"));
				empleado.ponEmail(rs.getString("email"));
				empleado.ponFax(rs.getString("fax"));
				empleado.ponNomina(rs.getString("nomina"));
				empleado.ponPerfil(rs.getString("perfil"));
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
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			StringBuffer sqlString =new StringBuffer("insert into empleados ");
			sqlString.append("values (\""+empleado.dameCodigo()+ "\", ");
			sqlString.append("\"" +empleado.damePerfil()+ "\", ");
			sqlString.append("\""+empleado.dameDni()+ "\", ");
			sqlString.append("\""+empleado.dameNombre()+ "\", ");
			sqlString.append("\""+empleado.dameDireccion()+ "\", ");
			sqlString.append("\""+empleado.dameCp()+ "\", ");
			sqlString.append("\""+empleado.damePoblacion()+ "\", ");
			sqlString.append("\""+empleado.dameProvincia()+ "\", ");
			sqlString.append("\""+empleado.dameTelefono1()+ "\", ");
			sqlString.append("\""+empleado.dameTelefono2()+ "\", ");
			sqlString.append("\""+empleado.dameMovil()+ "\", ");
			sqlString.append("\""+empleado.dameEmail()+ "\", ");
			sqlString.append("\""+empleado.dameFax()+ "\", ");
			sqlString.append("\""+empleado.dameNomina()+ "\")");
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
	
	public static void modificaEmpleado(Empleado empleado, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try 
		{	conn = dataSource.getConnection();
      		stmt = conn.createStatement();
      		StringBuffer sqlString=new StringBuffer("update empleados ");
      		sqlString.append("set direccion='"+ empleado.dameDireccion()+ "', ");
      		sqlString.append("cp="+ empleado.dameCp()+ ", ");
      		sqlString.append("poblacion='"+ empleado.damePoblacion() + "', ");
      		sqlString.append("provincia='"+ empleado.dameProvincia() + "', ");
      		sqlString.append("telefono1='"+ empleado.dameTelefono1() + "', ");
      		sqlString.append("telefono2="+ empleado.dameTelefono2()+ "', ");
      		sqlString.append("movil="+ empleado.dameMovil()+ "', ");
      		sqlString.append("email="+ empleado.dameEmail()+ "', ");
      		sqlString.append("fax="+ empleado.dameFax()+ "', ");
      		sqlString.append("nomina="+ empleado.dameNomina());
      		sqlString.append(" where codigo='"+ empleado.dameCodigo()+ "'");
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