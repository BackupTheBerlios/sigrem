/*
 * Created on 19-abr-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mem;

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

public class ModificaEmpleadoAction extends Action
{
	protected void modificarEmpleado(EmpleadoForm form, HttpServletRequest request) throws Exception 
	{
		Empleado empleado = new Empleado();
		empleado.ponCodigo(form.dameNombre()+"algo");
		empleado.ponNombre(form.dameNombre());
		empleado.ponDni(form.dameDni());
		empleado.ponDireccion(form.dameDireccion());
		empleado.ponCp(form.dameCp());
		empleado.ponPoblacion(form.damePoblacion());
		empleado.ponProvincia(form.dameProvincia());
		empleado.ponTelefono1(form.dameTelefono1());
		empleado.ponTelefono2(form.dameTelefono2());
		empleado.ponMovil(form.dameMovil());
		empleado.ponEmail(form.dameEmail());
		empleado.ponFax(form.dameFax());
		empleado.ponNomina(form.dameNomina());
		empleado.ponPerfil(form.damePerfil());
		EmpleadoBaseDatos.modificaEmpleado(empleado, getDataSource(request));
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
		{	modificarEmpleado((EmpleadoForm) form, request);}
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
