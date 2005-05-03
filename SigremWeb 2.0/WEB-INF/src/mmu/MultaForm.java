package mmu;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class MultaForm extends ActionForm
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
	
	//Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.codigoMulta="";
	    this.expediente="";
	    this.boletin="";
	    this.descripcion="";
	    this.infraccion="";
	    this.fechaDenuncia="";
	    this.codigoContrato="";
	}

	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) 
	{
		ActionErrors errors=new ActionErrors();
	    if ( (expediente == null) || (expediente.length() == 0) ) {

	      errors.add("expediente", new ActionError("errors.expediente.required"));
	    }
	    if ( (boletin == null) || (boletin.length() == 0) ) {

	      errors.add("dni", new ActionError("errors.boletin.required"));
	    }
	    return errors;
	  }
}