package mcl;

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

public class DameClienteAction extends Action 
{
	protected ActionForm construirClienteForm(String codigo, HttpServletRequest request) throws Exception 
	{
		ClienteForm form = null;
		Cliente cliente = ClienteBaseDatos.dameCliente(codigo, getDataSource(request));
		if ( cliente != null ) 
		{	form = new ClienteForm();
			form.setCodigo(cliente.getCodigo());
			form.setNombre(cliente.getNombre());
			form.setDni(cliente.getDni());
			form.setDireccion(cliente.getDireccion());
			form.setCp(cliente.getCp());
			form.setPoblacion(cliente.getPoblacion());
			form.setProvincia(cliente.getProvincia());
			form.setTelefono1(cliente.getTelefono1());
			form.setTelefono2(cliente.getTelefono2());
			form.setMovil(cliente.getMovil());
			form.setEmail(cliente.getEmail());
			form.setFax(cliente.getFax());
		}
		else 
		{	throw new Exception("Cliente " + codigo + " no encontrado");}
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
		{	form = construirClienteForm(request.getParameter("codigo"), request);
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
