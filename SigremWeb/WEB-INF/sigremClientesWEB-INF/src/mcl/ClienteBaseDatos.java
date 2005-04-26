package mcl;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteBaseDatos 
{
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
}
