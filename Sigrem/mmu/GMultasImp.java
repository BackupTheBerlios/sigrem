package mmu;

import java.util.LinkedList;
import java.util.Vector;

import interfaz.InterfazGrafica;
import mco.Contrato;
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
		vista.actualizaVistaCajaMultas('a',datos);
		vista.actualizaVista(1,3,null);
		return codigoantiguo;
	}
	
	public void eliminarMulta(String codigo)
	{
		boolean eliminado=listaMultas.eliminar(codigo,0);
		if (eliminado) 
		{	LinkedList datos=new LinkedList();
			datos.add(codigo);
			vista.actualizaVistaCajaMultas('e',datos);
			vista.actualizaVista(1,3,null);
		}
		else vista.actualizaVistaMensaje("Error al eliminar la multa "+codigo+". No se ha encontrado");
	
	}

	public void modificarMulta(String codigo,LinkedList datos)
	{
		Vector busqueda=listaMultas.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar la multa "+codigo+". No se ha encontrado");}
		else 
		{	Multa multa=(Multa)busqueda.get(0);
			multa.ponFechaDenuncia((String)datos.get(3));
			multa.ponInfraccion((String)datos.get(4));
			multa.ponDescripcion((String)datos.get(5));
			System.out.println((String)datos.get(0));
			System.out.println((String)datos.get(3));
			System.out.println((String)datos.get(4));
			System.out.println((String)datos.get(5));
			vista.actualizaVistaCajaMultas('m',datos);
			vista.actualizaVista(1,3,null);
		}
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
