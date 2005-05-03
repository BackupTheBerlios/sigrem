package mcl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;

public class ModificaClienteAction extends Action
{
	protected void modificarCliente(ClienteForm form, HttpServletRequest request) throws Exception 
	{
		Cliente cliente = new Cliente();
		cliente.setCodigo(form.getCodigo());
		cliente.setNombre(form.getNombre());
		cliente.setDni(form.getDni());
		cliente.setDireccion(form.getDireccion());
		cliente.setCp(form.getCp());
		cliente.setPoblacion(form.getPoblacion());
		cliente.setProvincia(form.getProvincia());
		cliente.setTelefono1(form.getTelefono1());
		cliente.setTelefono2(form.getTelefono2());
		cliente.setMovil(form.getMovil());
		cliente.setEmail(form.getEmail());
		cliente.setFax(form.getFax());
		ClienteBaseDatos.modificaCliente(cliente, getDataSource(request));
	}

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		if ( isCancelled(request) ) 
		{	return (mapping.findForward("success"));}
		try 
		{	modificarCliente((ClienteForm) form, request);}
		catch ( Exception e ) 
		{	target = new String("error");
			ActionErrors errors = new ActionErrors();
			errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.database.error",e.getMessage()));
			if ( !errors.isEmpty() ) 
			{	saveErrors(request, errors);}
		}
		//actualizar la vista con el objetivo apropiado
		return (mapping.findForward(target));
	}
}
