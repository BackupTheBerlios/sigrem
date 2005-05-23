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
	    	String codigoco=ContratoBaseDatos.asignaCodigo(getDataSource(request));
		    contrato.setCodigoContrato(codigoco);
		    contrato.setMatricula(contratoForm.getMatricula());
		    contrato.setFechaAlta(contratoForm.getFechaAlta());
		    contrato.setFechaBaja(contratoForm.getFechaBaja());
		    contrato.setCodigoCliente(codigocl);
			ContratoBaseDatos.insertaContrato(contrato, getDataSource(request));			
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