package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mcl.Cliente;
import mcl.ClienteBaseDatos;

import mem.EmpleadoBaseDatos;
import mem.Empleado;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class AltaUsuarioAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response)throws IOException, ServletException 
	{
	    String target = new String("success");
	    if ( isCancelled(request) ) 
	    {	return (mapping.findForward("success"));}
	    try 
		{	Usuario usuario = new Usuario();
		    UsuarioForm usuarioForm = (UsuarioForm) form;
		    String nombre=usuarioForm.getNombreUsuario();
		    String perfil=usuarioForm.getTipoUsuario();
		    usuario.setNombreUsuario(nombre);
		    usuario.setPassword(usuarioForm.getPassword());
		    usuario.setTipoUsuario(perfil);
		    if (perfil.equals("Cliente"))
		    {	Cliente cliente=ClienteBaseDatos.dameClienteDni(nombre,getDataSource(request));	
		    	if (cliente!=null)
		    	{	UsuarioBaseDatos.insertaUsuario(usuario, getDataSource(request));}
		    	else
		    	{	target = new String("error");
			    	ActionErrors errors = new ActionErrors();
			    	errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.login.unknown"));
			    	if ( !errors.isEmpty() ) 
			    	{	saveErrors(request, errors);}		    		
		    	}
		    }
		    else if (perfil.equals("Empleado"))
		    {  	Empleado empleado=EmpleadoBaseDatos.dameEmpleadoDni(nombre,getDataSource(request));	
	    		if (empleado!=null)
	    		{	UsuarioBaseDatos.insertaUsuario(usuario, getDataSource(request));}
	    		else
	    		{	target = new String("error");
		    		ActionErrors errors = new ActionErrors();
		    		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.login.unknown"));
		    		if ( !errors.isEmpty() ) 
		    		{	saveErrors(request, errors);}		    		
	    		}
		    }
		}
		catch ( Exception e ) 
		{	target = new String("error");
		    ActionErrors errors = new ActionErrors();
		    errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.database.error", e.getMessage()));
		    if ( !errors.isEmpty() ) 
		    {	saveErrors(request, errors);}
		}
		//actualizar la vista con el objetivo apropiado
		return (mapping.findForward(target));
	}
}
