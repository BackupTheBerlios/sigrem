package mcl;

import java.util.LinkedList;

import med.EstructuraDatos;

public interface GClientes 
{
	//Requisito 1.1
	public String añadirCliente(LinkedList datos);
	//Requisito 1.2
	public void eliminarCliente(boolean actualizar,String codcliente,String codcontrato);
	//Requisito 1.3
	public void modificarCliente(String codigo,LinkedList datos);
	//Requisito 1.4
	public String consultarClienteCodigo(boolean modificar,boolean actualizar,String codigo);
	//Requisito 1.5
	public String consultarClienteNombre(String nombre);
	//Requisito 1.6
	public String consultarClienteDni(String dni);	
	
	public void meteCliente(Cliente cliente);
	
	public void asociaClienteContrato(String codcliente,String codcontrato);
	
	public EstructuraDatos dameEstructuraClientes();
	
	public String dameCodigo();
}

