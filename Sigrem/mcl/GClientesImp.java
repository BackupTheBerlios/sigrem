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
		claves[1]=(String)datos.get(1);
		claves[2]=(String)datos.get(2);
		listaclientes.insertar(claves,nuevocliente);
		String codigoantiguo=codcliente;
		incrementaCodigo();
		vista.actualizaVista(1,2,datos);
		return codigoantiguo;
	}
	
	public void asociaClienteContrato(String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,0);
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
	
	public void modificarCliente(String codigo)
	{
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
		
	
/*	public boolean añadir(Integer codigo,String nombre, String dni)
	{
		//falta añadir todos los parametros de contrato
		Cliente nuevo=new ClienteImp(codigo,nombre,dni);
		Comparable[] claves=null;
		claves[0]= nuevo.dameCodigo();
		claves[1]= nuevo.dameNombre();
		claves[2]=nuevo.dameDni();
		//controla que no exista ese codigo y que no exista ese dni
		 if (consultarCodigo((Integer)claves[0])==null && consultarClienteDni((String)claves[2])==null){
	   		clientes.insertar(claves,nuevo);
	   		//vista.actualizaClientes();
			//falta saber como se comunica con la interfaz
	  	   return true;
	  	   }
	    return false;
	  }

	public boolean eliminar(Integer codigo)
	{
		boolean eliminado=clientes.eliminar(codigo,0);
	  	if (eliminado) {
	  		//vista.actualizaClientes();
			//falta saber como se comunica con la interfaz
	  	}
	  	return eliminado;
	}
	
	public boolean modificarCliente(Integer codigoAntiguo, Integer codigoNuevo,String nombreNuevo, String dniNuevo)
	{
//		falta añadir todos los parametros de contrato
		Cliente nuevo=new ClienteImp(codigoNuevo,nombreNuevo,dniNuevo);
		Cliente antiguo=this.consultarClienteCodigo(codigoAntiguo);
	  	if (antiguo!=null){
	  		String nombreAntiguo=antiguo.dameNombre();
	  		String dniAntiguo=antiguo.dameDni();
	  		//controla TODAS las posibles combinaciones de cambios de indice de codigo y dni no permitidas
	  		if (codigoNuevo!=codigoAntiguo){
	  			if (dniNuevo!=dniAntiguo){
	  				if (consultarCodigo(codigoNuevo)==null && this.consultarClienteDni(dniNuevo)==null){
	  					clientes.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);  	
	  		  			clientes.cambiarClaveDeIndice(dniAntiguo,dniNuevo,2);
	  				}else return false;
	  			}else{
	  				if (this.consultarClienteCodigo(codigoNuevo)==null){
	  					clientes.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);
	  				}else return false;
	  			}
	  		}else{
	  			if (dniNuevo!=dniAntiguo){
	  				if (this.consultarClienteDni(dniNuevo)==null){
	  					clientes.cambiarClaveDeIndice(dniAntiguo,dniNuevo,2);
	  				}else return false;
	  			}
	  		}
	  		clientes.cambiarClaveDeIndice(nombreAntiguo,nombreNuevo,1);
	  		//vista.actualizaContratos();
			//falta saber como se comunica con la interfaz
		  	return true;
	  	}
	  	return false;
	}
	  

	public Cliente consultarClienteCodigo(Integer codigo)
	{
	  return (Cliente) this.clientes.buscar(codigo,0);
	}

	public Cliente consultarClienteNombre(String nombre)
	{
	  return (Cliente) this.clientes.buscar(nombre,1);
	}

	public Cliente consultarClienteDni(String dni)
	{
	  return (Cliente) this.clientes.buscar(dni,2);
	}*/
}