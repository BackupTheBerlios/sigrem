package mre;

import java.util.LinkedList;

public class Recurso {
	
	private String codigorecurso;
	
	private String fechaemision;
	
	private String escritorecibido;
	
	private String escritopresentado;
	
	private String estado;
	
	private String abogado;
	
	private String descripcion;
	
	public Recurso(String codrecurso,LinkedList datos) 
	{
		codigorecurso=codrecurso;
		fechaemision=(String)datos.get(0);
		escritorecibido=(String)datos.get(1);
		escritopresentado=(String)datos.get(2);
		estado=(String)datos.get(3);
		abogado=(String)datos.get(4);
		descripcion=(String)datos.get(5);		
	}

	public String dameCodigo()
	{
		return codigorecurso;
	}

	public String dameFechaEmision()
	{
		return fechaemision;
	}
	
	public String dameEscritoRecibido()
	{
		return escritorecibido;
	}
	
	public String dameEscritoPresentado()
	{
		return escritopresentado;
	}
	
	public String dameEstado()
	{
		return estado;
	}
	
	public String dameAbogado()
	{
		return abogado;
	}
	
	public String dameDescripcion()
	{
		return descripcion;
	}
	
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigorecurso);
		datos.add(fechaemision);
		datos.add(escritorecibido);
		datos.add(escritopresentado);
		datos.add(estado);
		datos.add(abogado);
		datos.add(descripcion);
		return datos;
	}
	
	public void ponFechaEmision(String fem)
	{
		this.fechaemision=fem;
	}
	
	public void ponEscritoRecibido(String erec)
	{
		this.escritorecibido=erec;
	}
	
	public void ponEscritoPresentado(String epre)
	{
		this.escritopresentado=epre;
	}
	
	public void ponEstado(String est)
	{
		this.estado=est;
	}
	
	public void ponAbogado(String abo)
	{
		this.abogado=abo;
	}	
}
