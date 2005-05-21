package mem;

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

public class DameEmpleadoAction extends Action 
{
	protected ActionForm construirEmpleadoForm(String codigo, HttpServletRequest request) throws Exception 
	{
		EmpleadoForm form = null;
		Empleado empleado = EmpleadoBaseDatos.dameEmpleado(codigo, getDataSource(request));
		if ( empleado != null ) 
		{	form = new EmpleadoForm();
			form.setCodigo(empleado.getCodigo());
			form.setNombre(empleado.getNombre());
			form.setDni(empleado.getDni());
			form.setDireccion(empleado.getDireccion());
			form.setCp(empleado.getCp());
			form.setPoblacion(empleado.getPoblacion());
			form.setProvincia(empleado.getProvincia());
			form.setTelefono1(empleado.getTelefono1());
			form.setTelefono2(empleado.getTelefono2());
			form.setMovil(empleado.getMovil());
			form.setEmail(empleado.getEmail());
			form.setFax(empleado.getFax());
			form.setNomina(empleado.getNomina());
			form.setPerfil(empleado.getPerfil());
		}
		else 
		{	throw new Exception("Empleado " + codigo + " no encontrado");}
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
