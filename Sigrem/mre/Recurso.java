package mre;

import java.util.LinkedList;

public class Recurso {
	
	private String codigoRecurso;
	
	private String fechaEmision;
	
	private String escritoRecibido;
	
	private String escritoPresentado;
	
	private String estado;
	
	private String abogado;
	
	private String descripcion;
	
	private String codigoMulta;
	
	public Recurso(String codrecurso,LinkedList datos) 
	{
		codigoRecurso=codrecurso;
		fechaEmision=(String)datos.get(0);
		escritoRecibido=(String)datos.get(1);
		escritoPresentado=(String)datos.get(2);
		estado=(String)datos.get(3);
		abogado=(String)datos.get(4);
		descripcion=(String)datos.get(5);		
		codigoMulta=(String)datos.get(6);
	}

	public String dameCodigo()
	{
		return codigoRecurso;
	}

	public String dameFechaEmision()
	{
		return fechaEmision;
	}
	
	public String dameEscritoRecibido()
	{
		return escritoRecibido;
	}
	
	public String dameEscritoPresentado()
	{
		return escritoPresentado;
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
	
	public String dameCodigoMulta()
	{
		return codigoMulta;
	}
	
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigoRecurso);
		datos.add(fechaEmision);
		datos.add(escritoRecibido);
		datos.add(escritoPresentado);
		datos.add(estado);
		datos.add(abogado);
		datos.add(descripcion);
		datos.add(codigoMulta);
		return datos;
	}
	
	public void ponFechaEmision(String fem)
	{
		this.fechaEmision=fem;
	}
	
	public void ponEscritoRecibido(String erec)
	{
		this.escritoRecibido=erec;
	}
	
	public void ponEscritoPresentado(String epre)
	{
		this.escritoPresentado=epre;
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
