package mco;

import med.*;
import interfaz.*;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class GContratosImp implements GContratos
{
	private EstructuraDatos listacontratos;
	
	private InterfazGrafica vista;
	
	private String codcontrato;
	
	private void incrementaCodigo()
	{
		String numero=codcontrato.substring(0,4);
		Character car=null;
		int num=car.digit(codcontrato.charAt(4),10);
		for (int i=5;i<codcontrato.length();i++)
		{	num=(num*10)+car.digit(codcontrato.charAt(i),10);}
		numero=numero+(num+1);
		codcontrato=numero;
	}
  
	public GContratosImp(InterfazGrafica vista,String codigo) 
	{
		codcontrato=codigo;
		listacontratos=new EstructuraDatosImp(2);
		this.vista=vista;
	}
	
	public String aņadirContrato(LinkedList datos)
	{
		Contrato nuevocontrato=new Contrato(codcontrato,datos);
		String[] claves=new String[2];
		claves[0]=codcontrato;
		claves[1]=(String)datos.get(1);
		listacontratos.insertar(claves,nuevocontrato);
		String codigoantiguo=codcontrato;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		vista.actualizaVista(1,1,datos);
		return codigoantiguo;
	}
	
	public void eliminarContrato(boolean borrar, String codigo)
	{
		boolean eliminado=listacontratos.eliminar(codigo,0);
		if (eliminado) 
		{	vista.actualizaVistaMensaje("       Contrato "+codigo+" eliminado correctamente");
			if (borrar)
			{	vista.actualizaVista(1,1,null);
				vista.actualizaVista(1,2,null);				
			}
		}
		else vista.actualizaVistaMensaje("Error al eliminar el contrato "+codigo+". No se ha encontrado");
	}
	
	public void modificarContrato(String codigo,LinkedList datos)
	{
		vista.actualizaVista(1,1,datos);				
	}
	
	public String modificarFechaBaja(String codigo)
	{
		Vector busqueda=listacontratos.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
			return null;			
		}
		else 
		{	Contrato contrato=(Contrato)busqueda.get(0);
			Date hoy=new Date();
			SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
			contrato.ponFechaBaja(formato.format(hoy));
			return contrato.dameCodigoCliente();
		}
	}
	
	public String consultarContratoCodigo(boolean modificar,String codigo)
	{
		Vector busqueda=listacontratos.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
			return null;			
		}
		else 
		{	Contrato contrato=(Contrato)busqueda.get(0);
			if (modificar)
			{	LinkedList datos=new LinkedList();
				datos.add(contrato.dameCodigoContrato());
				datos.add(contrato.dameCodigoCliente());
				datos.add(contrato.dameMatricula());
				datos.add(contrato.dameFechaAlta());
				vista.actualizaVistaDatos(1,datos,false);
			}
			else
			{	vista.actualizaVista(1,1,contrato.dameListaDatos());}
				return contrato.dameCodigoCliente();
			}
	}
	
	public String consultarContratoMatricula(String matricula)
	{
		Vector busqueda=listacontratos.buscar(matricula,1);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+matricula+". No se ha encontrado");
			return null;			
		}
		else 
		{	Contrato contrato=(Contrato)busqueda.get(0);
			vista.actualizaVista(1,1,contrato.dameListaDatos());
			return contrato.dameCodigoCliente();
		}
	}
}