package mmu;

import java.util.LinkedList;

import interfaz.InterfazGrafica;
import med.*;

public class GMultasImp implements GMultas 
{
	private String codigoMulta;
	
	private EstructuraDatos listaMultas;
	
	private InterfazGrafica vista; 
	  
	public GMultasImp(InterfazGrafica vista,String codigo) 
	{
		this.codigoMulta=codigo;
		this.listaMultas=new EstructuraDatosImp(3);
	    this.vista=vista;
	}
	
	private void incrementaCodigo()
	{
		String numero=codigoMulta.substring(0,3);
		Character car=null;
		int num=car.digit(codigoMulta.charAt(3),10);
		for (int i=4;i<codigoMulta.length();i++)
		{	num=(num*10)+car.digit(codigoMulta.charAt(i),10);}
		numero=numero+(num+1);
		codigoMulta=numero;
	}
		
	//clave0=codigo  clave1=expediente  clave2=boletin
	public String añadirMulta(LinkedList datos)
	{
		Multa nuevamulta=new Multa(codigoMulta,datos);
		String[] claves=new String[3];
		claves[0]=codigoMulta;
		claves[1]=(String)datos.get(0);
		claves[2]=(String)datos.get(1);		
		listaMultas.insertar(claves,nuevamulta);
		String codigoantiguo=codigoMulta;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		LinkedList datosmultas=new LinkedList();
		datosmultas.add(datos);
		vista.actualizaVistaCajaMultas(false,datos);
		vista.actualizaVista(1,3,null);
		return codigoantiguo;
	}
	
	public void eliminarMulta(String codigo)
	{
		boolean eliminado=listaMultas.eliminar(codigo,0);
		if (eliminado) 
		{	LinkedList datos=new LinkedList();
			datos.add(codigo);
			vista.actualizaVistaCajaMultas(true,datos);
			vista.actualizaVista(1,3,null);
		}
		else vista.actualizaVistaMensaje("Error al eliminar la multa "+codigo+". No se ha encontrado");
	
	}

	public void modificarMulta(String codigo)
	{
		
	}

	public void consultarMultaCodigo(String codigo)
	{
		
	}

	public void consultarMultaExpediente(String expediente)
	{
		
	}

	public void consultarMultaBoletin(String boletin)
	{
		
	}
}
