package mmu;

import java.util.LinkedList;

public interface GMultas 
{
	//Requisito 3.1
	public String añadirMulta(LinkedList datos);
	//Requisito 3.2
	public void eliminarMulta(String codigo);
	//Requisito 3.3
	public void modificarMulta(String codigo);
	//Requisito 3.4
	public void consultarMultaCodigo(String codigo);
	//Requisito 3.5
	public void consultarMultaExpediente(String expediente);
	//Requisito 3.6
	public void consultarMultaBoletin(String boletin);
}
