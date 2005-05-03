package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class DameUsuarioAction extends Action 
{
	protected ActionForm construirUsuarioForm(String nombre, HttpServletRequest request) throws Exception 
	{
		UsuarioForm form = null;
		Usuario usuario = UsuarioBaseDatos.dameUsuario(nombre, getDataSource(request));
		if ( usuario != null ) 
		{	form = new UsuarioForm();
			form.setNombreUsuario(usuario.getNombreUsuario());
			form.setPassword(usuario.getPassword());
			form.setTipoUsuario(usuario.getTipoUsuario());
		}
		else 
		{	throw new Exception("Usuario " + nombre + " no encontrada");}
		return form;
	}

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		if ( isCancelled(request) ) 
		{	return (mapping.findForward(target));}
		try 
		{	form = construirUsuarioForm(request.getParameter("nombre"), request);
			if ( "request".equals(mapping.getScope()) ) 
			{	request.setAttribute(mapping.getAttribute(), form);}
			else 
			{	HttpSession session = request.getSession();
				session.setAttribute(mapping.getAttribute(), form);
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
