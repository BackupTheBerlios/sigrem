package mem;

import java.util.LinkedList;
//import mre.*;

public class Abogado extends Empleado 
{
	private LinkedList listaRecursos;
	
	public Abogado(String codigoEmpleado, String perfilEmpleado,LinkedList datosEmpleado) 
	{
		super(codigoEmpleado, perfilEmpleado, datosEmpleado);
		listaRecursos = new LinkedList();
	}
	public void añadirRecurso(String nuevoRecurso)
	{
		listaRecursos.add(nuevoRecurso);
	}
	public void eliminarRecurso(String codigoRecurso)
	{
		int i=0;
		boolean esta=false;
		while ((!esta) && (i<listaRecursos.size()))
		{	esta=codigoRecurso.equals((String)listaRecursos.get(i));
			i++;			
		}
		if (esta)listaRecursos.remove(i-1);
	}
	public LinkedList dameListaRecursos()
	{
		return listaRecursos;
	}
}

