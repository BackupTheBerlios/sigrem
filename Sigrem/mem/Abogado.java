/*
 * Created on 22-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mem;

import java.util.LinkedList;
import mre.*;

/**
 * @author sergio
 *
 */
public class Abogado extends Empleado {

	/**
	 * @param codigoEmpleado
	 * @param listaEmpleados
	 */
	
	private LinkedList listaRecursos;
	
	public Abogado(String codigoEmpleado, LinkedList listaEmpleados) {
		super(codigoEmpleado, listaEmpleados);
		
		listaRecursos = new LinkedList();
	}
	public void añadirRecurso(Recurso nuevoRecurso){
		listaRecursos.add(nuevoRecurso);
	}
	public void eliminarRecurso(String codigoRecurso){
		
		if(listaRecursos.remove(codigoRecurso))
			System.out.println("Recurso encontrado y eliminado");
		else
			System.out.println("Este recurso no lo lleva este abogado");
	}
}

