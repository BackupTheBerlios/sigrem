package mem;

import java.util.LinkedList;

import med.EstructuraDatos;

public interface GEmpleados
{
	//Requisito 6.1
	public String añadirEmpleado(String perfil,LinkedList datosEmpleado);
	//Requisito 6.2
	public void eliminarEmpleado(boolean borrar,String codigoEmpleado);
	//Requisito 6.3
	public void modificarEmpleado(String codigoEmpleado, LinkedList datosEmpleado);
	//Requisito 6.4
	public String consultarEmpleadoCodigo(boolean modificar,String codigo);
	//Requisito 6.5
	public String consultarEmpleadoNombre(String nombre);
	//Requisito 6.6
	public String consultarEmpleadoDni(String dni);
	
	public void meteEmpleado(Empleado empleado);
	
	public EstructuraDatos dameEstructuraEmpleados();
	
	public String dameCodigo();
	
	public void asociaAbogadoRecurso(String codrecurso,String codempleado);
	
	public void eliminarRecursoAbogado(String codrecurso,String codempleado);
	
	public void consultarListaAbogados();
	
	public LinkedList dameListaRecursosEmpleado(int clave,String codigo);
}
