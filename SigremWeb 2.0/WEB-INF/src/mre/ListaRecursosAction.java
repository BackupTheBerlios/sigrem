package mre;

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

public class ListaRecursosAction extends Action
{
	public ActionForward execute(ActionMapping mapping,
		    ActionForm form,
		    HttpServletRequest request,
		    HttpServletResponse response) throws IOException, ServletException 
	{
		String target = new String("success");
		HttpSession sesion=request.getSession();
		String codigoConsulta=request.getParameter("codigomu");
		String codigoSesion=(String)sesion.getAttribute("codigomu");
		ArrayList recursos=null;
		if ((codigoConsulta==null) || (codigoConsulta.equals("")))
		{
			 recursos=RecursoBaseDatos.dameRecursos(codigoSesion,getDataSource(request));
		}
		else
		{	sesion.setAttribute("codigomu",codigoConsulta);
			recursos=RecursoBaseDatos.dameRecursos(codigoConsulta,getDataSource(request));
		}
	    request.setAttribute("recursos", recursos);
	    //actualizar la vista con el objetivo apropiado
	    return (mapping.findForward(target));
	  }	
}