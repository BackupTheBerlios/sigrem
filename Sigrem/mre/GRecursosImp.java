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
		this.listaRecursos=new EstructuraDatosImp(3);
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
		return null;
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
