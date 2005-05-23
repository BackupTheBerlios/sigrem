package mco;

import mcl.*;

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

public class InsertaContratoAction extends Action
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
		{	ContratoForm contratoForm = (ContratoForm) form;
	    	Cliente cliente = new Cliente();
			String codigocl=ClienteBaseDatos.asignaCodigo(getDataSource(request));
			cliente.setCodigo(codigocl);
			cliente.setNombre(contratoForm.getNombre());
			cliente.setDni(contratoForm.getDni());
			cliente.setDireccion(contratoForm.getDireccion());
			cliente.setCp(contratoForm.getCp());
			cliente.setPoblacion(contratoForm.getPoblacion());
			cliente.setProvincia(contratoForm.getPoblacion());
			cliente.setTelefono1(contratoForm.getTelefono1());
			cliente.setTelefono2(contratoForm.getTelefono2());
			cliente.setMovil(contratoForm.getMovil());
			cliente.setEmail(contratoForm.getEmail());
			cliente.setFax(contratoForm.getFax());
			ClienteBaseDatos.insertaCliente(cliente, getDataSource(request));
	    	Contrato contrato = new Contrato();
	    	String codigoco=ContratoBaseDatos.asignaCodigo(getDataSource(request));
		    contrato.setCodigoContrato(codigoco);
		    contrato.setMatricula(contratoForm.getMatricula());
		    contrato.setFechaAlta(contratoForm.getFechaAlta());
		    contrato.setFechaBaja(contratoForm.getFechaBaja());
		    contrato.setCodigoCliente(codigocl);
			ContratoBaseDatos.insertaContrato(contrato, getDataSource(request));			
		}
		catch ( Exception e ) 
		{	target = new String("");
		    ActionErrors errors = new ActionErrors();
		    if ( !errors.isEmpty() ) 
		    {	saveErrors(request, errors);}
		}
		//actualizar la vista con el objetivo apropiado
		return (mapping.findForward(target));
	}	
}