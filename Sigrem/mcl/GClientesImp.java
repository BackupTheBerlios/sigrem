/*
 * Created on 13-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mcl;

import interfaz.InterfazGrafica;
import med.EstructuraDatos;
import med.ListaConIndices;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
class Sigrem{
	  }

public class GClientesImp {
	  EstructuraDatos clientes;
	  Sigrem controlador;
	  InterfazGrafica vista; 
	 
	  public GClientesImp(Sigrem con, InterfazGrafica vis) {
	    clientes=new ListaConIndices(3);
	    controlador=con;
	    vista=vis;
	  }

	  public boolean a�adirCliente(Integer codigo,String nombre, String dni){
	    //falta a�adir todos los parametros de contrato
	  	Cliente nuevo=new ClienteImp(codigo,nombre,dni);
	  	Comparable[] claves=null;
	    claves[0]= nuevo.dameCodigo();
	    claves[1]= nuevo.dameNombre();
	    claves[2]=nuevo.dameDni();
	    //controla que no exista ese codigo y que no exista ese dni
	    if (consultarClienteCodigo((Integer)claves[0])==null && consultarClienteDni((String)claves[2])==null){
	    	clientes.insertar(claves,nuevo);
	    	//vista.actualizaClientes();
			//falta saber como se comunica con la interfaz
	  	   	return true;
	    }
	    return false;
	  }

	  public boolean eliminarCliente(Integer codigo){
	    boolean eliminado=clientes.eliminar(codigo,0);
	  	if (eliminado) {
	  		//vista.actualizaClientes();
			//falta saber como se comunica con la interfaz
	  	}
	  	return eliminado; 
	    
	  }

	  public boolean modificarCliente(Integer codigoAntiguo, Integer codigoNuevo,String nombreNuevo, String dniNuevo){
	  	 //falta a�adir todos los parametros de contrato
	  	Cliente nuevo=new ClienteImp(codigoNuevo,nombreNuevo,dniNuevo);
	  	Cliente antiguo=this.consultarClienteCodigo(codigoAntiguo);
	  	if (antiguo!=null){
	  		String nombreAntiguo=antiguo.dameNombre();
	  		String dniAntiguo=antiguo.dameDni();
	  		//controla TODAS las posibles combinaciones de cambios de indice de codigo y dni no permitidas
	  		if (codigoNuevo!=codigoAntiguo){
	  			if (dniNuevo!=dniAntiguo){
	  				if (consultarClienteCodigo(codigoNuevo)==null && this.consultarClienteDni(dniNuevo)==null){
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

	  public Cliente consultarClienteCodigo(Integer codigo){
	    return (Cliente) this.clientes.buscar(codigo,0);
	  }

	  public Cliente consultarClienteNombre(String nombre){
	    return (Cliente) this.clientes.buscar(nombre,1);

	  }

	  public Cliente consultarClienteDni(String dni){
	    return (Cliente) this.clientes.buscar(dni,2);

	  }

	  
	}