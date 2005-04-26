package mcl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;

public class ListaClientesAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws IOException, ServletException 
	{
	    String target = new String("success");
	    ArrayList clientes = null;
	    clientes = ClienteBaseDatos.dameClientes(getDataSource(request));
	    request.setAttribute("clientes", clientes);
	    //actualizar la vista con el objetivo apropiado
	    return (mapping.findForward(target));
	  }	
}
