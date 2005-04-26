package mco;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContratoBaseDatos 
{

	public static ArrayList dameContrato(String codigoCliente, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Contrato contrato = null;
	  	ArrayList contratos = new ArrayList();
		
		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from contratos where codigoCliente=\'"+ codigoCliente + "';");
			while ( rs.next() ) 
			{	contrato=new Contrato();
				contrato.setCodigo(rs.getString("codigoContrato"));
				contrato.setMatricula(rs.getString("matricula"));
				contrato.setFechaAlta(rs.getString("fechaAlta"));
				contrato.setFechaBaja(rs.getString("fechaBaja"));

				contratos.add(contrato);
			}
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
		return contratos;
	}
}
