package mco;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.util.ArrayList;

public class ListaContratosClienteAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		HttpSession sesion=request.getSession();
		String codigo=(String)sesion.getAttribute("usuario");
	    ArrayList contratos=ContratoBaseDatos.dameContratosCliente(codigo,getDataSource(request));
	    request.setAttribute("contratos", contratos);
	    //actualizar la vista con el objetivo apropiado
	    return (mapping.findForward(target));
	  }	
}
