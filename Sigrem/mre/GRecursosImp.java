package mre;

import interfaz.InterfazGrafica;
import java.util.LinkedList;
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

	public void modificarRecurso(String codigo)
	{
		
	}

	public void consultarRecursoCodigo(String codigo)
	{
		
	}

}
