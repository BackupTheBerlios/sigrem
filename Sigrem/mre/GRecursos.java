package mre;

import java.util.LinkedList;

import med.EstructuraDatos;

public interface GRecursos 
{
	//Requisito 4.1
	public String añadirRecurso(LinkedList datos);
	//Requisito 4.2
	public void eliminarRecurso(String codrecurso,String codmulta);
	//Requisito 4.3
	public String modificarRecurso(String codigo,LinkedList datos);
	//Requisito 4.4
	public String consultarRecursoCodigo(String codigo);
	
	public void consultarListaRecursos(int panel,LinkedList listaRecursos);
	
	public void eliminarListaRecursos(LinkedList listaRecursos);
	
	public String consultarAbogadoRecurso(String codrecurso);
	
	public void meteRecurso(Recurso recurso);
	
	public EstructuraDatos dameEstructuraRecursos(); 
	
	public String dameCodigo();
}
