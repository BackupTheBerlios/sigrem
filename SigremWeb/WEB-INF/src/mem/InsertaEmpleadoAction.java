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
		    
		    //al códgio hay que ponerle un valor correcto
		    empleado.ponCodigo(empleadoForm.dameNombre()+"algo");
			empleado.ponNombre(empleadoForm.dameNombre());
			empleado.ponDni(empleadoForm.dameDni());
			empleado.ponDireccion(empleadoForm.dameDireccion());
			empleado.ponCp(empleadoForm.dameCp());
			empleado.ponPoblacion(empleadoForm.damePoblacion());
			empleado.ponProvincia(empleadoForm.dameProvincia());
			empleado.ponTelefono1(empleadoForm.dameTelefono1());
			empleado.ponTelefono2(empleadoForm.dameTelefono2());
			empleado.ponMovil(empleadoForm.dameMovil());
			empleado.ponEmail(empleadoForm.dameEmail());
			empleado.ponFax(empleadoForm.dameFax());
			empleado.ponNomina(empleadoForm.dameNomina());
			empleado.ponPerfil(empleadoForm.damePerfil());
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