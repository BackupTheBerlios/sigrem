package mem;

import java.util.LinkedList;

public interface GEmpleados
{
	// M�todo para a�adir un empleado al sistema
	public String a�adirEmpleado(LinkedList listaEmpleados);
	// M�todo para eliminar un empleado del sistema
	public void eliminarEmpleado(String codigoEmpleado);
	// M�todo para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList listaEmpleados);
	// M�todo para consultar un empleado dado su C�digo de Empleado
	public void consultarEmpleadoCodigo(boolean modificar,String codigo);
	// M�todo para consultar un empleado dado su Nombre
	public void consultarEmpleadoNombre(String nombre);
	// M�todo para consultar un empleado dado su DNI
	public void consultarEmpleadoDni(String dni);
}
