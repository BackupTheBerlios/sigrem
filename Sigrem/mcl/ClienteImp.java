/*
 * Created on 13-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mcl;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClienteImp implements Cliente{
	Integer codigo;
	String dni;
	String nombre;
	  
	public ClienteImp(Integer cod, String d, String nom) {
		codigo=cod;
	    dni=d;
	    nombre=nom;
	}

	public Integer dameCodigo(){
		return codigo;
	}

	
	public String dameNombre(){
		return nombre;
	}

	public String dameDni(){
		return dni;
	}
	  
	//LO DE ABAJO NO ES NECESARIO PORQUE PARA CUALQUIER 
	//CAMBIO SE CREA UN NUEVO CLIENTE
	
	  /*
	  public boolean cambiaCodigo(Integer cod){
	    if (lista.tieneCodigo(cod)){
	      System.out.println("La lista ya tiene un cliente con ese codigo");
	      return false;
	    }else{
	      codigo=cod;
	      return true;
	    }
	  }

	  public boolean cambiaDni(Integer d){
	    if (lista.tieneDni(d)){
	      System.out.println("La lista ya tiene un cliente con ese codigo");
	      return false;
	    }else{
	      dni=d;
	      return true;
	    }
	  }

	  public boolean cambiaNombre(String nom){
	    nombre=nom;
	    return true;
	  }
	*/

}
