package mco;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class ContratoForm extends ActionForm
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
	//Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.codigoContrato="";
	    this.fechaAlta="";
	    this.fechaBaja="";
	    this.codigoCliente="";
	    this.matricula="";
	}

	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) 
	{
		ActionErrors errors=new ActionErrors();
	    if ( (matricula == null) || (matricula.length() == 0) ) {

	      errors.add("matricula", new ActionError("errors.matricula.required"));
	    }
	    return errors;
	  }
}