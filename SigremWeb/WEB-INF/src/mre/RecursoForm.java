package mre;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionErrors;
//import org.apache.struts.action.ActionError;

public class RecursoForm extends ActionForm
{
	protected String codigoRecurso;
	
	protected String fechaEmision;
	
	protected String escritoRecibido;
	
	protected String escritoPresentado;
	
	protected String estado;
	
	protected String abogado;
	
	protected String descripcion;
	
	protected String codigoMulta;
	
	public String getCodigoRecurso()
	{
		return codigoRecurso;
	}
	
	public String getFechaEmision()
	{
		return fechaEmision;
	}
	
	public String getEscritoRecibido()
	{
		return escritoRecibido;
	}
	
	public String getEscritoPresentado()
	{
		return escritoPresentado;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public String getAbogado()
	{
		return abogado;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public String getCodigoMulta()
	{
		return codigoMulta;
	}
	
	public void setCodigoRecurso(String cod)
	{
		this.codigoRecurso=cod;
	}
	
	public void setCodigoMulta(String cod)
	{
		this.codigoMulta=cod;
	}
	
	public void setFechaEmision(String fem)
	{
		this.fechaEmision=fem;
	}
	
	public void setEscritoRecibido(String erec)
	{
		this.escritoRecibido=erec;
	}
	
	public void setEscritoPresentado(String epre)
	{
		this.escritoPresentado=epre;
	}
	
	public void setEstado(String est)
	{
		this.estado=est;
	}
	
	public void setDescripcion(String descrip)
	{
		this.descripcion=descrip;
	}	
		
	public void setAbogado(String abo)
	{
		this.abogado=abo;
	}
	
	//Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.codigoRecurso="";
	    this.fechaEmision="";
	    this.escritoPresentado="";
	    this.escritoRecibido="";
	    this.estado="";
	    this.codigoMulta="";
	    this.abogado="";
	    this.descripcion="";
	}
/*
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) 
	{
		;
	}*/
}