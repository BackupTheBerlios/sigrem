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
public interface GClientes {
	//Requisito 1.1
	public void añadirCliente(Cliente cliente, Integer codigo,String matricula);
	//Requisito 1.2
	public void eliminarCliente(Integer codigo);
	//Requisito 1.3
	public void modificarCliente(Integer codigo);
	//Requisito 1.4
	public void consultarCliente(Integer codigo);
	//Requisito 1.5
	public void consultarClienteNombre(String nombre);
	//Requisito 1.6
	public void consultarClienteDni(String dni);	
}
