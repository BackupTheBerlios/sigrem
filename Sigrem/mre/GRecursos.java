package mre;

import java.util.LinkedList;

public interface GRecursos 
{
	//Requisito 4.1
	public String añadirRecurso(LinkedList datos);
	//Requisito 4.2
	public void eliminarRecurso(String codrecurso,String codmulta);
	//Requisito 4.3
	public void modificarRecurso(String codigo);
	//Requisito 4.4
	public void consultarRecursoCodigo(String codigo);
}
