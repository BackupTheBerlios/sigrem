package mcl;

import java.util.LinkedList;

import interfaz.InterfazGrafica;
import med.*;

public class GClientesImp implements GClientes
{
	private EstructuraDatos listaclientes;
	  
	private InterfazGrafica vista; 
	
	private String codcliente;
	 
	private void incrementaCodigo()
	{
		String numero=codcliente.substring(0,4);
		Character car=null;
		int num=car.digit(codcliente.charAt(4),10);
		for (int i=5;i<codcliente.length();i++)
		{	num=(num*10)+car.digit(codcliente.charAt(i),10);}
		numero=numero+(num+1);
		codcliente=numero;
	}
	
	public GClientesImp(InterfazGrafica vista,String codigo) 
	{
		this.listaclientes=new EstructuraDatosImp(3);
	    this.vista=vista;
	    this.codcliente=codigo;
	}
	
	//clave0=codigo	clave1=nombre clave2=dni
	public String añadirCliente(LinkedList datos)
	{
		Cliente nuevocliente=new Cliente(codcliente,datos);
		String[] claves=new String[3];
		claves[0]=codcliente;
		claves[1]=(String)datos.get(0);
		claves[2]=(String)datos.get(1);
		listaclientes.insertar(claves,nuevocliente);
		String codigoantiguo=codcliente;
		incrementaCodigo();
		return codigoantiguo;
	}
	
	public void asociaClienteContrato(String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,0);
		Cliente cliente=(Cliente)busqueda[0];
		cliente.añadeContrato(codcontrato);
		vista.actualizaVista(1,2,cliente.dameListaDatos());
	}
	
	public void eliminarCliente(boolean actualizar,String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codcliente+". No se ha encontrado");}
		else 
			if (busqueda[0]!=null)
			{	Cliente cliente=(Cliente)busqueda[0];
				cliente.eliminaContrato(codcontrato);
				if (cliente.dameNumeroContratos()==0)
				{	boolean eliminado=listaclientes.eliminar(codcliente,0);
					if (eliminado) 
					{	vista.actualizaVistaMensaje("El cliente "+codcliente+" ha sido eliminado al no tener contratos asociados");}
					else vista.actualizaVistaMensaje("Error al eliminar el cliente "+codcliente+". No se ha encontrado");
				}
				else
					if (actualizar) vista.actualizaVista(1,2,cliente.dameListaDatos());
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codcliente+". No se ha encontrado");}
	}
	
	public void modificarCliente(String codigo,LinkedList datos)
	{
		Object[] busqueda=listaclientes.buscar(codigo,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
		else 
			if (busqueda[0]!=null)
			{	Cliente cliente=(Cliente)busqueda[0];
				cliente.ponDireccion((String)datos.get(2));
				cliente.ponCp((String)datos.get(3));
				cliente.ponPoblacion((String)datos.get(4));
				cliente.ponProvincia((String)datos.get(5));
				cliente.ponTelefono1((String)datos.get(6));
				cliente.ponTelefono2((String)datos.get(7));
				cliente.ponMovil((String)datos.get(8));
				cliente.ponEmail((String)datos.get(9));
				cliente.ponFax((String)datos.get(10));
				vista.actualizaVista(1,2,cliente.dameListaDatos());				
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
	}
	
	public String consultarClienteCodigo(boolean modificar,boolean actualizar,String codigo)
	{
		Object[] busqueda=listaclientes.buscar(codigo,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");
			return null;
		}
		else 
			if (busqueda[0]!=null)
			{	Cliente cliente=(Cliente)busqueda[0];
				if (modificar)
				{	LinkedList datos=new LinkedList();
					datos.add(cliente.dameNombre());
					datos.add(cliente.dameDni());
					datos.add(cliente.dameDireccion());
					datos.add(cliente.dameCp());
					datos.add(cliente.damePoblacion());
					datos.add(cliente.dameProvincia());
					datos.add(cliente.dameTelefono1());
					datos.add(cliente.dameTelefono2());
					datos.add(cliente.dameMovil());
					datos.add(cliente.dameEmail());
					datos.add(cliente.dameFax());
					vista.actualizaVistaDatos(1,datos,true);
				}
				else
				{	if (actualizar)	vista.actualizaVista(1,2,cliente.dameListaDatos());}
				return (String)cliente.dameListaContratos().getFirst();
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");
				return null;
			}
	}
	
	public void consultarClienteNombre(String nombre)
	{
		
	}
	
	public void consultarClienteDni(String dni)
	{
		
	}
}