package mmu;

public class Multa 
{
	protected String codigo;
	protected String expediente;
	protected String boletin;
	protected String fechaDenuncia;
	protected String infraccion;
	protected String descripcion;
	
	public String getCodigo(){return codigo;}
	public String getExpediente(){return expediente;}
	public String getBoletin(){return boletin;}
	public String getFechaDenuncia(){return fechaDenuncia;}
	public String getInfraccion(){return infraccion;}
	public String getDescripcion(){return descripcion;}
	
	public void setCodigo(String cod){this.codigo = cod;}
	public void setExpediente(String exp){this.expediente = exp;}
	public void setBoletin(String bol){this.boletin = bol;}
	public void setFechaDenuncia(String fecha){this.fechaDenuncia = fecha;}
	public void setInfraccion(String inf){this.infraccion = inf;}
	public void setDescripcion(String des){this.descripcion = des;}
}
