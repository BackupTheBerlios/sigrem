package mem;

import java.util.LinkedList;

public interface GEmpleados
{
	// Método para añadir un empleado al sistema
	public String añadirEmpleado(String perfil,LinkedList datosEmpleado);
	// Método para eliminar un empleado del sistema
	public void eliminarEmpleado(boolean borrar,String codigoEmpleado);
	// Método para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList datosEmpleado);
	// Método para consultar un empleado dado su Código de Empleado
	public void consultarEmpleadoCodigo(boolean modificar,String codigo);
	// Método para consultar un empleado dado su Nombre
	public void consultarEmpleadoNombre(String nombre);
	// Método para consultar un empleado dado su DNI
	public void consultarEmpleadoDni(String dni);
}
