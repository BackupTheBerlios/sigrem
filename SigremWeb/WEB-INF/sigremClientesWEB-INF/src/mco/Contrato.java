package mco;

public class Contrato 
{
	protected String codigo;
	protected String matricula;
	protected String fechaAlta;
	protected String fechaBaja;
	
	public String getCodigo(){return codigo;}
	public String getMatricula(){return matricula;}
	public String getFechaAlta(){return fechaAlta;}
	public String getFechaBaja(){return fechaBaja;}
	
	public void setCodigo(String cod){this.codigo = cod;}
	public void setMatricula(String nom){this.matricula = nom;}
	public void setFechaAlta(String fechaAlta){this.fechaAlta = fechaAlta;}
	public void setFechaBaja(String dir){this.fechaBaja = dir;}
}
