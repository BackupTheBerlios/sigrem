package mcl;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class ClienteForm extends ActionForm
{
	protected String codigo;
	protected String dni;
	protected String nombre;
	protected String direccion;
	protected String cp;
	protected String poblacion;
	protected String provincia;
	protected String telefono1;
	protected String telefono2;
	protected String movil;
	protected String email;
	protected String fax;
	
	public String getCodigo(){return codigo;}
	public String getNombre(){return nombre;}
	public String getDni(){return dni;}
	public String getDireccion(){return direccion;}
	public String getCp(){return cp;}
	public String getPoblacion(){return poblacion;}
	public String getProvincia(){return provincia;}
	public String getTelefono1(){return telefono1;}
	public String getTelefono2(){return telefono2;}
	public String getMovil(){return movil;}
	public String getEmail(){return email;}
	public String getFax(){return fax;}
	
	public void setCodigo(String cod){this.codigo = cod;}
	public void setNombre(String nom){this.nombre = nom;}
	public void setDni(String dni){this.dni = dni;}
	public void setDireccion(String dir){this.direccion = dir;}
	public void setCp(String cp){this.cp = cp;}
	public void setPoblacion(String pob){this.poblacion = pob;}
	public void setProvincia(String pro){this.provincia = pro;}
	public void setTelefono1(String tel){this.telefono1 = tel;}
	public void setTelefono2(String tel){this.telefono2 = tel;}
	public void setMovil(String mov){this.movil = mov;}
	public void setEmail(String email){this.email = email;}
	public void setFax(String fax){this.fax = fax;}
	
	//Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.codigo="";
	    this.dni="";
	    this.nombre="";
	    this.direccion="";
	    this.cp="";
	    this.poblacion="";
	    this.provincia="";
	    this.telefono1="";
	    this.telefono2="";
	    this.movil="";
	    this.email="";
	    this.fax="";
	}

	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) 
	{
		ActionErrors errors=new ActionErrors();
	    if ( (dni == null) || (dni.length() == 0) ) {

	      errors.add("dni", new ActionError("errors.dni.required"));
	    }
	    if ( (nombre == null) || (nombre.length() == 0) ) {

	      errors.add("nombre", new ActionError("errors.nombre.required"));
	    }
	    return errors;
	  }
}