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

public class DameMultaAction extends Action 
{
	protected ActionForm construirEmpleadoForm(String codigo, HttpServletRequest request) throws Exception 
	{
		MultaForm form = null;
		Multa multa = MultaBaseDatos.dameMulta(codigo, getDataSource(request));
		if ( multa != null ) 
		{	form = new MultaForm();
			form.setCodigoMulta(multa.getCodigoMulta());
			form.setExpediente(multa.getExpediente());
			form.setBoletin(multa.getBoletin());
			form.setFechaDenuncia(multa.getFechaDenuncia());
			form.setInfraccion(multa.getInfraccion());
			form.setDescripcion(multa.getDescripcion());
			form.setCodigoContrato(multa.getCodigoContrato());
		}
		else 
		{	throw new Exception("Multa " + codigo + " no encontrada");}
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
		{	form = construirEmpleadoForm(request.getParameter("codigo"), request);
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
