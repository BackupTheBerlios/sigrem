package mmu;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MultaBaseDatos 
{

	public static ArrayList dameMulta(String codigoContrato, DataSource dataSource) throws Exception 
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		Multa multa = null;
	  	ArrayList multas = new ArrayList();

		try 
		{	conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from multas where codigoContrato=\'"+ codigoContrato + "';");
			while ( rs.next() ) 
			{	multa=new Multa();
				multa.setCodigo(rs.getString("codigoMulta"));
				multa.setExpediente(rs.getString("expediente"));
				multa.setBoletin(rs.getString("boletin"));
				multa.setFechaDenuncia(rs.getString("fechaDenuncia"));
				multa.setInfraccion(rs.getString("infraccion"));
				multa.setDescripcion(rs.getString("descripcion"));

				multas.add(multa);
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
		return multas;
	}
}
