package mre;

import java.util.LinkedList;

public interface GRecursos 
{
	//Requisito 4.1
	public String aņadirRecurso(LinkedList datos);
	//Requisito 4.2
	public void eliminarRecurso(String codrecurso,String codmulta);
	//Requisito 4.3
	public void modificarRecurso(String codigo,LinkedList datos);
	//Requisito 4.4
	public String consultarRecursoCodigo(String codigo);
	
	public void consultarListaRecursos(int panel,LinkedList listaRecursos);
	
	public void eliminarListaRecursos(LinkedList listaRecursos);
	
	public String consultarAbogadoRecurso(String codrecurso);
}
