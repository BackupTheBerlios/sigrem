package mre;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecursoBaseDatos 
{

	public static ArrayList dameRecurso(String codigoMulta, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Recurso recurso = null;
		ArrayList recursos = new ArrayList();

		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from recursos,asignadoRecursoEmpleado where codigoMulta='"+ 							codigoMulta + "' and 		recursos.codigoRecurso=asignadoRecursoEmpleado.codigoRecurso;");
			if ( rs.next() ) 
			{	recurso=new Recurso();
				recurso.setCodigo(rs.getString("codigoRecurso"));
				recurso.setFechaEmision(rs.getString("fechaEmision"));
				recurso.setEscritoRecibido(rs.getString("escritoRecibido"));
				recurso.setEscritoPresentado(rs.getString("escritoPresentado"));
				recurso.setEstado(rs.getString("estado"));
				recurso.setAbogado(rs.getString("codigoEmpleado"));
				recurso.setDescripcion(rs.getString("descripcion"));

				recursos.add(recurso);
			}
			else 
			{	throw new Exception("Recurso " + codigoMulta + " no encontrado");}
		}
		catch ( SQLException e ){
			System.err.println(e.getMessage());
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
		return recursos;
	}
}
