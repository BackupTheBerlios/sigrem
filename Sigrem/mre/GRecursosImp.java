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
		System.out.println(datos.get(0));
		System.out.println(datos.get(1));
		System.out.println(datos.get(2));
		System.out.println(datos.get(3));
		System.out.println(datos.get(4));
		System.out.println(datos.get(5));
		String[] claves=new String[1];
		claves[0]=codigoRecurso;
		listaRecursos.insertar(claves,nuevorecurso);
		String codigoantiguo=codigoRecurso;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		System.out.println(datos.get(0));
		System.out.println(datos.get(1));
		System.out.println(datos.get(2));
		System.out.println(datos.get(3));
		System.out.println(datos.get(4));
		System.out.println(datos.get(5));
		System.out.println(datos.get(6));
		System.out.println(datos.get(7));
		vista.actualizaVistaCaja('r','a',datos);
		vista.actualizaVista(1,4,datos);
		return codigoantiguo;
	}
	
	public void eliminarRecurso(String codigo)
	{
		
	}

	public void modificarRecurso(String codigo)
	{
		
	}

	public void consultarRecursoCodigo(String codigo)
	{
		
	}

}
