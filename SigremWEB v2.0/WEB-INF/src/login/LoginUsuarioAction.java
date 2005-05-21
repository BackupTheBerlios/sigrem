package login;

import mcl.ClienteBaseDatos;
import mcl.Cliente;
import mem.EmpleadoBaseDatos;
import mem.Empleado;
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

public class LoginUsuarioAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		if ( isCancelled(request) ) 
		{	return (mapping.findForward(target));}
		try 
		{	HttpSession sesion=request.getSession();
			UsuarioForm usuarioForm=(UsuarioForm)form;
			String nombre=usuarioForm.getNombreUsuario();
			String password=usuarioForm.getPassword();
			Usuario usuario=UsuarioBaseDatos.dameUsuario(nombre,getDataSource(request));
			if ((usuario!=null) && (usuario.getPassword().equals(password)))
			{	if (usuario.getTipoUsuario().equals("Administrador"))
				{	target = new String("root");}
				else if (usuario.getTipoUsuario().equals("Cliente"))
				{	Cliente cliente=ClienteBaseDatos.dameClienteDni(nombre,getDataSource(request));
					if (cliente!=null)
					{	sesion.setAttribute("usuario",cliente.getCodigo());
						sesion.setAttribute("nombreusuario",cliente.getNombre());
						target = new String("cliente");
					}
					else
					{	target = new String("error");
						ActionErrors errors = new ActionErrors();
						errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.login.unknown"));
						if ( !errors.isEmpty() ) 
						{	saveErrors(request, errors);}
					}
				}
				else if (usuario.getTipoUsuario().equals("Empleado"))
				{	Empleado empleado=EmpleadoBaseDatos.dameEmpleadoDni(nombre,getDataSource(request));
					if (empleado!=null)
					{	sesion.setAttribute("usuario",empleado.getCodigo());
						sesion.setAttribute("nombreusuario",empleado.getNombre());
						target = new String("empleado");
					}
					else
					{	target = new String("error");
						ActionErrors errors = new ActionErrors();
						errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.login.unknown"));
						if ( !errors.isEmpty() ) 
						{	saveErrors(request, errors);}
					}
				}				
				if ( "request".equals(mapping.getScope()) ) 
				{	request.setAttribute(mapping.getAttribute(), form);}
				else 
				{	HttpSession session = request.getSession();
					session.setAttribute(mapping.getAttribute(), form);
				}
			}
			else
			{	target = new String("error");
				ActionErrors errors = new ActionErrors();
				errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("errors.login.unknown"));
				if ( !errors.isEmpty() ) 
				{	saveErrors(request, errors);}
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
