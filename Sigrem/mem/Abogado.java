package mem;

import java.util.LinkedList;
import mre.*;

public class Abogado extends Empleado {
	
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

