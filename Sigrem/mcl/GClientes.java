package mcl;

import java.util.LinkedList;

public interface GClientes 
{
	//Requisito 1.1
	public String añadirCliente(LinkedList datos);
	//Requisito 1.2
	public void eliminarCliente(String codigo);
	//Requisito 1.3
	public void modificarCliente(String codigo);
	//Requisito 1.4
	public void consultarClienteCodigo(String codigo);
	//Requisito 1.5
	public void consultarClienteNombre(String nombre);
	//Requisito 1.6
	public void consultarClienteDni(String dni);	
	
	public void asociaClienteContrato(String codcliente,String codcontrato);
}
