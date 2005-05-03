package mmu;

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

public class ModificaMultaAction extends Action
{
	protected void modificarMulta(MultaForm form, HttpServletRequest request) throws Exception 
	{
		Multa multa = new Multa();
		multa.setCodigoMulta(form.getCodigoMulta());
		multa.setExpediente(form.getExpediente());
		multa.setBoletin(form.getBoletin());
		multa.setFechaDenuncia(form.getFechaDenuncia());
		multa.setInfraccion(form.getInfraccion());
		multa.setDescripcion(form.getDescripcion());
		multa.setCodigoContrato(form.getCodigoContrato());
		MultaBaseDatos.modificaMulta(multa, getDataSource(request));
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
		{	modificarMulta((MultaForm) form, request);}
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
