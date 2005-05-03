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

import java.util.ArrayList;

public class ListaMultasAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		HttpSession sesion=request.getSession();
		String codigoConsulta=request.getParameter("codigoco");
		String codigoSesion=(String)sesion.getAttribute("codigoco");
		ArrayList multas=null;
		if ((codigoConsulta==null) || (codigoConsulta.equals("")))
		{
			 multas=MultaBaseDatos.dameMultas(codigoSesion,getDataSource(request));
		}
		else
		{	sesion.setAttribute("codigoco",codigoConsulta);
			multas=MultaBaseDatos.dameMultas(codigoConsulta,getDataSource(request));
		}
		request.setAttribute("multas", multas);
	    //actualizar la vista con el objetivo apropiado
	    return (mapping.findForward(target));
	  }	
}