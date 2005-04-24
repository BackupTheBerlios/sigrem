package mre;

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

public class InsertaRecursoAction extends Action
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
		{	Recurso recurso = new Recurso();
		    RecursoForm recursoForm = (RecursoForm) form;
		    String codigo=RecursoBaseDatos.asignaCodigo(getDataSource(request));
		    recurso.setCodigoRecurso(codigo);
		    recurso.setFechaEmision(recursoForm.getFechaEmision());
			recurso.setEscritoPresentado(recursoForm.getEscritoPresentado());
			recurso.setEscritoRecibido(recursoForm.getEscritoRecibido());
			recurso.setEstado(recursoForm.getEstado());
			recurso.setDescripcion(recursoForm.getDescripcion());
			recurso.setCodigoMulta(recursoForm.getCodigoMulta());
			recurso.setAbogado(recursoForm.getAbogado());
		    RecursoBaseDatos.insertaRecurso(recurso, getDataSource(request));
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