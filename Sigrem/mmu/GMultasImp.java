package mmu;

import java.util.LinkedList;
import java.util.Vector;
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
		String[] claves=new String[3];
		claves[0]=null;
		claves[1]=(String)datos.get(0);
		claves[2]=(String)datos.get(1);		
		if (consultarMultaExpediente(false,(String)claves[1])==null) 
			if (consultarMultaBoletin(false,(String)claves[2])==null)
			{	claves[0]=new String(codigoMulta);
				Multa nuevamulta=new Multa(claves[0],datos);
				listaMultas.insertar(claves,nuevamulta);
				String codigoantiguo=codigoMulta;
				incrementaCodigo();
				datos.addFirst(codigoantiguo);
				vista.actualizaVistaCaja(1,'m','a',datos);
				vista.actualizaVista(1,3,null);
			}
			else
			{	vista.actualizaVistaMensaje("Ya existe una multa con ese número de boletín- Imposible crear la multa");}
		else
		{	vista.actualizaVistaMensaje("Ya existe una multa con ese número de expediente- Imposible crear la multa");}
		return claves[0];
	}
	
	public void eliminarMulta(boolean actualizar,String codigo)
	{
		boolean eliminado=listaMultas.eliminar(codigo,0);
		if (eliminado) 
		{	LinkedList datos=new LinkedList();
			datos.add(codigo);
			if (actualizar)
			{	vista.actualizaVistaCaja(1,'m','e',datos);
				vista.actualizaVista(1,3,null);
			}
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
			vista.actualizaVistaCaja(1,'m','m',datos);
			vista.actualizaVista(1,3,null);
		}
	}

	public String consultarMultaCodigo(String codigo)
	{
		Vector busqueda=listaMultas.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar la multa "+codigo+". No se ha encontrado");
			return null;
		}
		else 
		{	Multa multa=(Multa)busqueda.get(0);
			return multa.dameCodigoContrato();			
		}
	}

	public String consultarMultaExpediente(boolean actualizar,String expediente)
	{
		Vector busqueda=listaMultas.buscar(expediente,1);
		if (busqueda.size()==0)
		{	if (actualizar) vista.actualizaVistaMensaje("Error al buscar la multa con expediente "+expediente+". No se ha encontrado");
			return null;
		}
		else 
		{	Multa multa=(Multa)busqueda.get(0);
			return multa.dameCodigoContrato();			
		}
	}

	public String consultarMultaBoletin(boolean actualizar,String boletin)
	{
		Vector busqueda=listaMultas.buscar(boletin,2);
		if (busqueda.size()==0)
		{	if (actualizar) vista.actualizaVistaMensaje("Error al buscar la multa con boletín "+boletin+". No se ha encontrado");
			return null;
		}
		else 
		{	Multa multa=(Multa)busqueda.get(0);
			return multa.dameCodigoContrato();			
		}
	}
	
	public void consultarListaMultas(LinkedList lista)
	{
		for (int i=0;i<lista.size();i++)
		{	String codigo=(String)lista.get(i);
			Vector busqueda=listaMultas.buscar(codigo,0);
			if (busqueda.size()==0)
			{	vista.actualizaVistaMensaje("Error al buscar la multa "+codigo+". No se ha encontrado");}
			else 
			{	Multa multa=(Multa)busqueda.get(0);
				vista.actualizaVistaCaja(1,'m','a',multa.dameListaDatos());
			}
		}
		vista.actualizaVista(1,3,null);
	}
	
	public void eliminaListaMultas(boolean actualizar,LinkedList lista)
	{
		for (int i=0;i<lista.size();i++)
		{	String codigo=(String)lista.get(i);
			boolean eliminado=listaMultas.eliminar(codigo,0);
			if (!eliminado)  
			{	vista.actualizaVistaMensaje("Error al eliminar la multa "+codigo+". No se ha encontrado");}
		}
		if (actualizar) vista.actualizaVista(1,3,null);
	}
	
	public void asociaMultaRecurso(String codmulta,String codrecurso)
	{
		Vector busqueda=listaMultas.buscar(codmulta,0);
		Multa multa=(Multa)busqueda.get(0);
		multa.añadeRecurso(codrecurso);
	}
	
	public void eliminarRecurso(String codmulta,String codrecurso)
	{
		Vector busqueda=listaMultas.buscar(codmulta,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar la multa "+codmulta+". No se ha encontrado");}
		else 
		{	Multa multa=(Multa)busqueda.get(0);
			multa.eliminaRecurso(codrecurso);
		}
	}
	
	public LinkedList dameListaRecursosMulta(String codigo)
	{
		Vector busqueda=listaMultas.buscar(codigo,0);
		Multa multa=(Multa)busqueda.get(0);
		return multa.dameListaRecursos();
	}
}
