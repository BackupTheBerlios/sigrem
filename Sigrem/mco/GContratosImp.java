package mco;

import med.*;
import interfaz.*;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class GContratosImp implements GContratos
{
	private EstructuraDatos listaContratos;
	
	private InterfazGrafica vista;
	
	private String codigoContrato;
	
	public GContratosImp(InterfazGrafica vista,String codigo) 
	{
		codigoContrato=codigo;
		listaContratos=new EstructuraDatosImp(2);
		this.vista=vista;
	}
	
	private void incrementaCodigo()
	{
		String numero=codigoContrato.substring(0,4);
		Character car=null;
		int num=car.digit(codigoContrato.charAt(4),10);
		for (int i=5;i<codigoContrato.length();i++)
		{	num=(num*10)+car.digit(codigoContrato.charAt(i),10);}
		numero=numero+(num+1);
		codigoContrato=numero;
	}
  
	public String añadirContrato(LinkedList datos)
	{
		String[] claves=new String[2];
		claves[0]=null;
		claves[1]=(String)datos.get(1);
		if (!listaContratos.esta(claves[1],1))
		{	Contrato nuevoContrato=new Contrato(codigoContrato,datos);
			claves[0]=new String(nuevoContrato.dameCodigoContrato());
			listaContratos.insertar(claves,nuevoContrato);
			incrementaCodigo();
			datos.addFirst(claves[0]);
			vista.actualizaVistaMensaje("El contrato ha sido creado correctamente");
			vista.actualizaVista(1,1,datos);
		}
		else
		{	vista.actualizaVistaMensaje("La matricula del contrato que se quiere crear ya existe-Imposible crear contrato");}
		return claves[0];
	}
	
	public void eliminarContrato(boolean borrar, String codigo)
	{
		boolean eliminado=listaContratos.eliminar(codigo,0);
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
		Vector busqueda=listaContratos.buscar(codigo,0);
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
		Vector busqueda=listaContratos.buscar(codigo,0);
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
	
	public String consultarContratoMatricula(boolean actualizar,String matricula)
	{
		Vector busqueda=listaContratos.buscar(matricula,1);
		if (busqueda.size()==0)
		{	if (actualizar) vista.actualizaVistaMensaje("Error al buscar el contrato con matrícula "+matricula+". No se ha encontrado");
			return null;			
		}
		else 
		{	Contrato contrato=(Contrato)busqueda.get(0);
			if (actualizar) vista.actualizaVista(1,1,contrato.dameListaDatos());
			else vista.actualizaVistaMensaje("La matricula del contrato que se quiere crear ya existe- Imposible crear contrato");
			return contrato.dameCodigoCliente();
		}
	}
	
	public void asociaContratoMulta(String codcontrato,String codmulta)
	{
		Vector busqueda=listaContratos.buscar(codcontrato,0);
		Contrato contrato=(Contrato)busqueda.get(0);
		contrato.añadeMulta(codmulta);
	}
	
	public void eliminarMulta(String codcontrato,String codmulta)
	{
		Vector busqueda=listaContratos.buscar(codcontrato,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codcontrato+". No se ha encontrado");}
		else 
		{	Contrato contrato=(Contrato)busqueda.get(0);
			contrato.eliminaMulta(codmulta);
		}
	}
	
	public LinkedList dameListaMultasContrato(int clave,String codigo)
	{
		Vector busqueda=listaContratos.buscar(codigo,clave);
		Contrato contrato=(Contrato)busqueda.get(0);
		return contrato.dameListaMultas();
	}
	
	public EstructuraDatos dameListaContratos()
	{
		return listaContratos;
	}
}