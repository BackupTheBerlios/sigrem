package mcl;

import java.util.LinkedList;
import interfaz.InterfazGrafica;
import med.*;

public class GClientesImp implements GClientes
{
	private EstructuraDatos listaclientes;
	  
	private InterfazGrafica vista; 
	
	private String codcliente;
	 
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
		//incrementar codigo en 1
		String[] claves=new String[3];
		claves[0]=codcliente;
		claves[1]=(String)datos.get(1);
		claves[2]=(String)datos.get(2);
		listaclientes.insertar(claves,nuevocliente);
		//vista.actualizaVista(1,datos);
		return codcliente;
	}
	
	public void asociaClienteContrato(String codcliente,String codcontrato)
	{
		Object[] busqueda=listaclientes.buscar(codcliente,0);
		Cliente cliente=(Cliente)busqueda[0];
		System.out.println(cliente.getDni());
		cliente.añadeContrato(codcontrato);
	}
	
	public void eliminarCliente(String codigo)
	{
		
	}
	
	public void modificarCliente(String codigo)
	{
		//recuperar los datos en el orden adecuado y crear el cliente
		//insertar el cliente en la lista
		//vista.actualizaVista(1,datos);
	}
	
	public void consultarClienteCodigo(String codigo)
	{

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