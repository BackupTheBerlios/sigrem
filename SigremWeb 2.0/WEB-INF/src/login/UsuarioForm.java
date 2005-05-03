package login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UsuarioForm extends ActionForm
{
	protected String nombreUsuario;
	
	protected String password;
	
	protected String passwordRepe;
	
	protected String tipoUsuario;
	
	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public String getPassword()
	{
		return password;
	}
	public String getPasswordRepe()
	{
		return passwordRepe;
	}
	public String getTipoUsuario()
	{
		return tipoUsuario;
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	public void setPasswordRepe(String pass)
	{
		this.passwordRepe=pass;
	}
	public void setNombreUsuario(String nombre)
	{
		this.nombreUsuario=nombre;
	}
	public void setTipoUsuario(String tipo)
	{
		this.tipoUsuario=tipo;
	}
	
	//	Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.nombreUsuario="";
	    this.password="";
	    this.passwordRepe="";
	    this.tipoUsuario="";
	}

	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) 
	{
		ActionErrors errors=new ActionErrors();
		if ( (nombreUsuario == null) || (nombreUsuario.length() == 0) ) {

			errors.add("nombreusuario", new ActionError("errors.nombreusuario.required"));
		}
		if ( (password == null) || (password.length() == 0) ) {

	      errors.add("password", new ActionError("errors.password.required"));
	    }
	    if ( (tipoUsuario == null) || (tipoUsuario.length() == 0) ) {

	    	errors.add("tipousuario", new ActionError("errors.tipousuario.required"));
	    }
	    if ( (passwordRepe == null) || (passwordRepe.length() == 0) ) {

		    errors.add("passwordrepe", new ActionError("errors.passwordrepe.required"));
		}
	    if (!password.equals(passwordRepe)){
		
	    	errors.add("passworddistinto", new ActionError("errors.password.distinto"));			
		}
	    return errors;
	}
}