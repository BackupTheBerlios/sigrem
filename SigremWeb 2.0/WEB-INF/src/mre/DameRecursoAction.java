package mre;

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

public class DameRecursoAction extends Action 
{
	protected ActionForm construirRecursoForm(String codigo, HttpServletRequest request) throws Exception 
	{
		RecursoForm form = null;
		Recurso recurso = RecursoBaseDatos.dameRecurso(codigo, getDataSource(request));
		if ( recurso != null ) 
		{	form = new RecursoForm();
			form.setCodigoRecurso(recurso.getCodigoRecurso());
			form.setFechaEmision(recurso.getFechaEmision());
			form.setEscritoRecibido(recurso.getEscritoRecibido());
			form.setEscritoPresentado(recurso.getEscritoPresentado());
			form.setDescripcion(recurso.getDescripcion());
			form.setEstado(recurso.getEstado());
			form.setAbogado(recurso.getAbogado());
			form.setCodigoMulta(recurso.getCodigoMulta());
		}
		else 
		{	throw new Exception("Recurso " + codigo + " no encontrado");}
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
		{	form = construirRecursoForm(request.getParameter("codigo"), request);
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
