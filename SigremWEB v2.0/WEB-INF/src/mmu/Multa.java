package mmu;

public class Multa 
{
	protected String codigoMulta;
	
	protected String expediente;
	
	protected String boletin;
	
	protected String fechaDenuncia;
	
	protected String infraccion;
	
	protected String descripcion;
	
	protected String codigoContrato;
	
	public String getCodigoMulta()
	{
		return codigoMulta;
	}
	
	public String getExpediente()
	{
	 	return expediente;
	}
	
	public String getBoletin()
	{
	 	return boletin;
	}
	
	public String getInfraccion()
	{
	 	return infraccion;
	}
	
	public String getDescripcion()
	{
	 	return descripcion;
	}
		
	public String getCodigoContrato()
	{
		return codigoContrato;
	}
	
	public String getFechaDenuncia()
	{
		return fechaDenuncia;
	}
	
	public void setCodigoContrato(String cont)
	{
		codigoContrato=cont;
	}
	public void setCodigoMulta(String cont)
	{
		codigoMulta=cont;
	}
	public void setExpediente(String exp)
	{
		expediente=exp;
	}
	public void setBoletin(String bol)
	{
		boletin=bol;
	}
	public void setFechaDenuncia(String fecha)
	{
		fechaDenuncia=fecha;
	}
	public void setInfraccion(String infrac)
	{
		infraccion=infrac;
	}
	public void setDescripcion(String descrip)
	{
		descripcion=descrip;		
	}
}