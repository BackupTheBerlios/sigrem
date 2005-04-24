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

public class ModificaRecursoAction extends Action
{
	protected void modificarRecurso(RecursoForm form, HttpServletRequest request) throws Exception 
	{
		Recurso recurso = new Recurso();
		recurso.setCodigoRecurso(form.getCodigoRecurso());
		recurso.setFechaEmision(form.getFechaEmision());
		recurso.setEscritoPresentado(form.getEscritoPresentado());
		recurso.setEscritoRecibido(form.getEscritoRecibido());
		recurso.setEstado(form.getEstado());
		recurso.setDescripcion(form.getDescripcion());
		recurso.setCodigoMulta(form.getCodigoMulta());
		recurso.setAbogado(form.getAbogado());
		RecursoBaseDatos.modificaRecurso(recurso, getDataSource(request));
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
		{	modificarRecurso((RecursoForm) form, request);}
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
