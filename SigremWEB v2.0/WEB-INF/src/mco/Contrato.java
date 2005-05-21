package mco;

public class Contrato 
{
	protected String codigoContrato;
	
	protected String matricula;
	
	protected String fechaAlta;
	
	protected String fechaBaja;
	
	protected String codigoCliente;
	
	public String getCodigoContrato()
	{
		return codigoContrato;
	}
	public String getMatricula()
	{
		return matricula;
	}
	public String getFechaAlta()
	{
		return fechaAlta;
	}
	public String getFechaBaja()
	{
		return fechaBaja;
	}
	public String getCodigoCliente()
	{
		return codigoCliente;
	}
	
	public void setCodigoContrato(String cod)
	{
		this.codigoContrato=cod;
	}
	public void setCodigoCliente(String cod)
	{
		this.codigoCliente=cod;
	}
	public void setFechaAlta(String fecha)
	{
		this.fechaAlta=fecha;
	}
	
	public void setFechaBaja(String fecha)
	{
		this.fechaBaja=fecha;
	}
	public void setMatricula(String mat)
	{
		this.matricula=mat;
	}
}