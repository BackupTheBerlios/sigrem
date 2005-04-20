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
		empleado.setCodigo(form.getNombre()+"algo");
		empleado.setNombre(form.getNombre());
		empleado.setDni(form.getDni());
		empleado.setDireccion(form.getDireccion());
		empleado.setCp(form.getCp());
		empleado.setPoblacion(form.getPoblacion());
		empleado.setProvincia(form.getProvincia());
		empleado.setTelefono1(form.getTelefono1());
		empleado.setTelefono2(form.getTelefono2());
		empleado.setMovil(form.getMovil());
		empleado.setEmail(form.getEmail());
		empleado.setFax(form.getFax());
		empleado.setNomina(form.getNomina());
		empleado.setPerfil(form.getPerfil());
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
