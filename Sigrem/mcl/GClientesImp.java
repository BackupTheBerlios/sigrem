package mcl;

import java.util.LinkedList;
import java.util.Vector;
import interfaz.InterfazGrafica;
import med.*;

public class GClientesImp implements GClientes
{
	private EstructuraDatos listaClientes;
	  
	private InterfazGrafica vista; 
	
	private String codigoCliente;
	 
	public GClientesImp(InterfazGrafica vista,String codigo) 
	{
		this.listaClientes=new EstructuraDatosImp(3);
	    this.vista=vista;
	    this.codigoCliente=codigo;
	}
	
	private void incrementaCodigo()
	{
		String numero=codigoCliente.substring(0,4);
		Character car=null;
		int num=car.digit(codigoCliente.charAt(4),10);
		for (int i=5;i<codigoCliente.length();i++)
		{	num=(num*10)+car.digit(codigoCliente.charAt(i),10);}
		numero=numero+(num+1);
		codigoCliente=numero;
	}
	
	//clave0=codigo	clave1=nombre clave2=dni
	public String añadirCliente(LinkedList datos)
	{	String[] claves=new String[3];
		claves[0]=null;
		claves[1]=(String)datos.get(0);
		claves[2]=(String)datos.get(1);
		if (!listaClientes.esta(claves[2],2)){
			claves[0]=new String(codigoCliente);
			Cliente nuevocliente=new Cliente(claves[0],datos);
			listaClientes.insertar(claves,nuevocliente);
			incrementaCodigo();
			vista.actualizaVistaMensaje("Nuevo cliente insertado correctamente");
		}else{
			//como el dni es clave solo habra uno en la posicion 0
			Cliente clienteExistente=(Cliente)listaClientes.buscar(claves[2],2).get(0);
			if (clienteExistente.dameNombre().equals(claves[1])){
				claves[0]=clienteExistente.dameCodigo();
				vista.actualizaVistaMensaje("El cliente ya existia y se le asociara el contrato");
			}else{
				vista.actualizaVistaMensaje("El cliente ya existe pero no coinciden los datos-Inserción de cliente y contrato imposible");
			}
			
		}
		return claves[0];
	}
	
	public void asociaClienteContrato(String codcliente,String codcontrato)
	{
		Vector busqueda=listaClientes.buscar(codcliente,0);
		Cliente cliente=(Cliente)busqueda.get(0);
		cliente.añadeContrato(codcontrato);
		vista.actualizaVista(1,2,cliente.dameListaDatos());
	}
	
	public void eliminarCliente(boolean actualizar,String codcliente,String codcontrato)
	{
		Vector busqueda=listaClientes.buscar(codcliente,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codcliente+". No se ha encontrado");}
		else 
		{	Cliente cliente=(Cliente)busqueda.get(0);
			cliente.eliminaContrato(codcontrato);
			if (cliente.dameNumeroContratos()==0)
			{	boolean eliminado=listaClientes.eliminar(codcliente,0);
				if (eliminado) 
				{	vista.actualizaVistaMensaje("El cliente "+codcliente+" ha sido eliminado al no tener contratos asociados");}
				else vista.actualizaVistaMensaje("Error al eliminar el cliente "+codcliente+". No se ha encontrado");
			}
			else
				if (actualizar) vista.actualizaVista(1,2,cliente.dameListaDatos());
		}
	}
	
	public void modificarCliente(String codigo,LinkedList datos)
	{
		Vector busqueda=listaClientes.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
		else 
		{	Cliente cliente=(Cliente)busqueda.get(0);
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
	}
	
	public String consultarClienteCodigo(boolean modificar,boolean actualizar,String codigo)
	{
		Vector busqueda=listaClientes.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");
			return null;
		}
		else 
		{	Cliente cliente=(Cliente)busqueda.get(0);
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
	}
	
	public String consultarClienteNombre(String nombre)
	{
		Vector busqueda=listaClientes.buscar(nombre,1);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente con nombre "+nombre+". No se ha encontrado");
			return null;			
		}
		else 
		{	if (busqueda.size()==1)
			{	Cliente cliente=(Cliente)busqueda.get(0);
				vista.actualizaVista(1,2,cliente.dameListaDatos());
				return (String)cliente.dameListaContratos().getFirst();			
			}
			else
			{	Vector dnis=new Vector();
				for (int i=0;i<busqueda.size();i++)
				{	Cliente cliente=(Cliente)busqueda.get(i);
					dnis.add(cliente.dameDni());
				}
				vista.actualizaVistaConsulta(1,nombre,dnis);
				return null;
			}
		}
	}
	
	public String consultarClienteDni(String dni)
	{
		Vector busqueda=listaClientes.buscar(dni,2);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente con dni "+dni+". No se ha encontrado");
			return null;			
		}
		else 
		{	Cliente cliente=(Cliente)busqueda.get(0);
			vista.actualizaVista(1,2,cliente.dameListaDatos());
			return (String)cliente.dameListaContratos().getFirst();
		}
	}
}