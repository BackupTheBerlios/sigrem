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

public class InsertaEmpleadoAction extends Action
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
		{	Empleado empleado = new Empleado();
		    EmpleadoForm empleadoForm = (EmpleadoForm) form;
		    String codigo=EmpleadoBaseDatos.asignaCodigo(getDataSource(request));
		    empleado.setCodigo(codigo);
			empleado.setNombre(empleadoForm.getNombre());
			empleado.setDni(empleadoForm.getDni());
			empleado.setDireccion(empleadoForm.getDireccion());
			empleado.setCp(empleadoForm.getCp());
			empleado.setPoblacion(empleadoForm.getPoblacion());
			empleado.setProvincia(empleadoForm.getProvincia());
			empleado.setTelefono1(empleadoForm.getTelefono1());
			empleado.setTelefono2(empleadoForm.getTelefono2());
			empleado.setMovil(empleadoForm.getMovil());
			empleado.setEmail(empleadoForm.getEmail());
			empleado.setFax(empleadoForm.getFax());
			empleado.setNomina(empleadoForm.getNomina());
			empleado.setPerfil(empleadoForm.getPerfil());
		    EmpleadoBaseDatos.insertaEmpleado(empleado, getDataSource(request));
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