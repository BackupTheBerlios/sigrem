package mmu;

import java.util.LinkedList;

public interface GMultas 
{
	//Requisito 3.1
	public String añadirMulta(LinkedList datos);
	//Requisito 3.2
	public void eliminarMulta(boolean actualizarVista,String codigo);
	//Requisito 3.3
	public void modificarMulta(String codigo,LinkedList datos);
	//Requisito 3.4
	public String consultarMultaCodigo(String codigo);
	//Requisito 3.5
	public String consultarMultaExpediente(boolean actualizarVista,String expediente);
	//Requisito 3.6
	public String consultarMultaBoletin(boolean actualizarVista,String boletin);

	public void consultarListaMultas(LinkedList lista);
	
	public void eliminaListaMultas(boolean actualizar,LinkedList lista);
	
	public void asociaMultaRecurso(String codmulta,String codrecurso);
	
	public void eliminarRecurso(String codmulta,String codrecurso);
	
	public LinkedList dameListaRecursosMulta(String codigo);
}
