package mre;

public class Recurso 
{
	protected String codigo;
	protected String fechaEmision;
	protected String escritoRecibido;
	protected String escritoPresentado;
	protected String estado;
	protected String abogado;
	protected String descripcion;
	
	public String getCodigo(){return codigo;}
	public String getFechaEmision(){return fechaEmision;}
	public String getEscritoRecibido(){return escritoRecibido;}
	public String getEscritoPresentado(){return escritoPresentado;}
	public String getEstado(){return estado;}
	public String getAbogado(){return abogado;}
	public String getDescripcion(){return descripcion;}
	
	public void setCodigo(String cod){this.codigo = cod;}
	public void setFechaEmision(String exp){this.fechaEmision = exp;}
	public void setEscritoRecibido(String bol){this.escritoRecibido = bol;}
	public void setEscritoPresentado(String fecha){this.escritoPresentado = fecha;}
	public void setEstado(String inf){this.estado = inf;}
	public void setAbogado(String abo){this.abogado = abo;}
	public void setDescripcion(String des){this.descripcion = des;}
}
