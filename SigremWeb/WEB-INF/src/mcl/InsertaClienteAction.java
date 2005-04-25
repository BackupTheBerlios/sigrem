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

public class InsertaClienteAction extends Action
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
		{	Cliente cliente = new Cliente();
		    ClienteForm clienteForm = (ClienteForm) form;
		    String codigo=ClienteBaseDatos.asignaCodigo(getDataSource(request));
		    cliente.setCodigo(codigo);
		    cliente.setNombre(clienteForm.getNombre());
		    cliente.setDni(clienteForm.getDni());
		    cliente.setDireccion(clienteForm.getDireccion());
		    cliente.setCp(clienteForm.getCp());
		    cliente.setPoblacion(clienteForm.getPoblacion());
		    cliente.setProvincia(clienteForm.getProvincia());
		    cliente.setTelefono1(clienteForm.getTelefono1());
		    cliente.setTelefono2(clienteForm.getTelefono2());
		    cliente.setMovil(clienteForm.getMovil());
		    cliente.setEmail(clienteForm.getEmail());
		    cliente.setFax(clienteForm.getFax());
		    ClienteBaseDatos.insertaCliente(cliente, getDataSource(request));
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