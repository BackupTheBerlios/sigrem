package mmu;

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

public class InsertaMultaAction extends Action
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
		{	Multa multa = new Multa();
		    MultaForm multaForm = (MultaForm) form;
		    String codigo=MultaBaseDatos.asignaCodigo(getDataSource(request));
		    multa.setCodigoMulta(codigo);
		    multa.setExpediente(multaForm.getExpediente());
		    multa.setBoletin(multaForm.getBoletin());
		    multa.setFechaDenuncia(multaForm.getFechaDenuncia());
		    multa.setInfraccion(multaForm.getInfraccion());
		    multa.setDescripcion(multaForm.getDescripcion());
		    HttpSession sesion=request.getSession();
		    multa.setCodigoContrato((String)sesion.getAttribute("codigoco"));
			MultaBaseDatos.insertaMulta(multa, getDataSource(request));
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