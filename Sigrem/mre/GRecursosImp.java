package mre;

import interfaz.InterfazGrafica;
import java.util.LinkedList;
import java.util.Vector;
import med.*;

public class GRecursosImp implements GRecursos 
{
	private String codigoRecurso;
	
	private EstructuraDatos listaRecursos;
	
	private InterfazGrafica vista; 
	  
	public GRecursosImp(InterfazGrafica vista,String codigo) 
	{
		this.codigoRecurso=codigo;
		this.listaRecursos=new EstructuraDatosImp(1);
	    this.vista=vista;
	}
	
	private void incrementaCodigo()
	{
		String numero=codigoRecurso.substring(0,3);
		Character car=null;
		int num=car.digit(codigoRecurso.charAt(3),10);
		for (int i=4;i<codigoRecurso.length();i++)
		{	num=(num*10)+car.digit(codigoRecurso.charAt(i),10);}
		numero=numero+(num+1);
		codigoRecurso=numero;
	}
		
	public String añadirRecurso(LinkedList datos)
	{
		Recurso nuevorecurso=new Recurso(codigoRecurso,datos);
		String[] claves=new String[1];
		claves[0]=codigoRecurso;
		listaRecursos.insertar(claves,nuevorecurso);
		String codigoantiguo=codigoRecurso;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		vista.actualizaVistaCaja('r','a',datos);
		vista.actualizaVista(1,4,datos);
		return codigoantiguo;
	}
	
	public void eliminarRecurso(String codrecurso,String codmulta)
	{
		boolean eliminado=listaRecursos.eliminar(codrecurso,0);
		if (eliminado) 
		{	LinkedList datos=new LinkedList();
			datos.add(codrecurso);
			datos.add(codmulta);
			vista.actualizaVistaCaja('r','e',datos);
			vista.actualizaVista(1,4,datos);
		}
		else vista.actualizaVistaMensaje("Error al eliminar el recurso "+codrecurso+". No se ha encontrado");
	}

	public void modificarRecurso(String codigo,LinkedList datos)
	{
		Vector busqueda=listaRecursos.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el recurso "+codigo+". No se ha encontrado");}
		else 
		{	Recurso recurso=(Recurso)busqueda.get(0);
			recurso.ponEscritoRecibido((String)datos.get(1));
			recurso.ponEscritoPresentado((String)datos.get(2));
			recurso.ponEstado((String)datos.get(3));
			recurso.ponDescripcion((String)datos.get(5));
			datos.add(recurso.dameCodigoMulta());
			vista.actualizaVistaCaja('r','m',datos);
			vista.actualizaVista(1,4,datos);
		}
	}

	public String consultarRecursoCodigo(String codigo)
	{
		Vector busqueda=listaRecursos.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el recurso "+codigo+". No se ha encontrado");
			return null;
		}
		else 
		{	Recurso recurso=(Recurso)busqueda.get(0);
			String codmulta=recurso.dameCodigoMulta();
			vista.muestraPanelRecursos(codmulta);
			return codmulta;
		}
	}
	
	public void consultarListaRecursos(LinkedList lista)
	{
		for (int i=0;i<lista.size();i++)
		{	String codigo=(String)lista.get(i);
			Vector busqueda=listaRecursos.buscar(codigo,0);
			if (busqueda.size()==0)
			{	vista.actualizaVistaMensaje("Error al buscar el recurso "+codigo+". No se ha encontrado");}
			else 
			{	Recurso recurso=(Recurso)busqueda.get(0);
				vista.actualizaVistaCaja('r','a',recurso.dameListaDatos());
			}
		}
	}

	public void eliminarListaRecursos(LinkedList lista)
	{
		for (int i=0;i<lista.size();i++)
		{	String codigo=(String)lista.get(i);
			boolean eliminado=listaRecursos.eliminar(codigo,0);
			if (!eliminado)  
			{	vista.actualizaVistaMensaje("Error al eliminar el recurso "+codigo+". No se ha encontrado");}
		}
	}
}
