package bean;

public class Requisito implements java.io.Serializable
{
	private String funcion;
	
	private String descripcion;
	
	private	String entrada;
	
	private String salida;
	
	private String destino;
	
	private String origen;
	
	private String necesita;
	
	private String precondicion;
	
	private String postcondicion;
	
	private String efectos;
	
	public Requisito(){}
		
	public void setFuncion(String valor)
	{
		this.funcion=valor;
	}
	public void setDescripcion(String valor)
	{
		this.descripcion=valor;
	}
	public void setEntrada(String valor)
	{
		this.entrada=valor;
	}
	public void setSalida(String valor)
	{
		this.salida=valor;
	}
	public void setDestino(String valor)
	{
		this.destino=valor;
	}
	public void setOrigen(String valor)
	{
		this.origen=valor;
	}
	public void setNecesita(String valor)
	{
		this.necesita=valor;
	}
	public void setPrecondicion(String valor)
	{
		this.precondicion=valor;
	}
	public void setPostcondicion(String valor)
	{
		this.postcondicion=valor;
	}
	public void setEfectos(String valor)
	{
		this.efectos=valor;
	}
	
	public String getFuncion()
	{
		return funcion;	
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public String getEntrada()
	{
		return entrada;
	}
	public String getSalida()
	{
		return salida;
	}
	public String getDestino()
	{
		return destino;
	}
	public String getOrigen()
	{
		return origen;
	}
	public String getNecesita()
	{
		return necesita;
	}
	public String getPrecondicion()
	{
		return precondicion;
	}
	public String getPostcondicion()
	{
		return postcondicion;
	}
	public String getEfectos()
	{
		return efectos;
	}
}