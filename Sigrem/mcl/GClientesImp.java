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
		vista.actualizaVista(1,2,datos);
		return codigoantiguo;
	}
	
	public void asociaClienteContrato(int clave,String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,clave);
		Cliente cliente=(Cliente)busqueda[0];
		cliente.añadeContrato(codcontrato);
	}
	
	public void eliminarCliente(String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codcliente+". No se ha encontrado");}
		else 
			if (busqueda[0]!=null)
			{	Cliente cliente=(Cliente)busqueda[0];
				cliente.eliminaContrato(codcontrato);
				if (cliente.getNumeroContratos()==0)
				{	boolean eliminado=listaclientes.eliminar(codcliente,0);
					if (eliminado) 
					{	vista.actualizaVistaMensaje("El cliente "+codcliente+" ha sido eliminado al no tener contratos asociados");}
					else vista.actualizaVistaMensaje("Error al eliminar el cliente "+codcliente+". No se ha encontrado");
				}
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
				cliente.setDireccion((String)datos.get(2));
				cliente.setCp((String)datos.get(3));
				cliente.setPoblacion((String)datos.get(4));
				cliente.setProvincia((String)datos.get(5));
				cliente.setTelefono1((String)datos.get(6));
				cliente.setTelefono2((String)datos.get(7));
				cliente.setMovil((String)datos.get(8));
				cliente.setEmail((String)datos.get(9));
				cliente.setFax((String)datos.get(10));
				vista.actualizaVista(1,2,cliente.getListaDatos());				
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
	}
	
	public void consultarClienteCodigo(boolean modificar,String codigo)
	{
		Object[] busqueda=listaclientes.buscar(codigo,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
		else 
			if (busqueda[0]!=null)
			{	Cliente cliente=(Cliente)busqueda[0];
				if (modificar)
				{	LinkedList datos=new LinkedList();
					datos.add(cliente.getNombre());
					datos.add(cliente.getDni());
					datos.add(cliente.getDireccion());
					datos.add(cliente.getCp());
					datos.add(cliente.getPoblacion());
					datos.add(cliente.getProvincia());
					datos.add(cliente.getTelefono1());
					datos.add(cliente.getTelefono2());
					datos.add(cliente.getMovil());
					datos.add(cliente.getEmail());
					datos.add(cliente.getFax());
					vista.actualizaVistaDatos(1,datos,true);
				}
				else
				{	vista.actualizaVista(1,2,cliente.getListaDatos());}
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el cliente "+codigo+". No se ha encontrado");}
	}
	
	public void consultarClienteNombre(String nombre)
	{
		
	}
	
	public void consultarClienteDni(String dni)
	{
		
	}
}