package mem;

import java.util.LinkedList;

public interface GEmpleados 
{
	// De momento es copia de clientes. Voy a probar y a adaptarlo a empleados
	
	// Método para añadir un empleado al sistema
	public String añadirEmpleado(LinkedList listaEmpleados);
	// Método para eliminar un empleado del sistema
	public void eliminarEmpleado(String codigoEmpleado);
	// Método para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList listaEmpleados);
	// Método para consultar un empleado dado su Código de Empleado
	public void consultarEmpleadoPorCodigo(String codigo);
	// Método para consultar un empleado dado su Nombre
	public void consultarEmpleadoPorNombre(String nombre);
	// Método para consultar un empleado dado su DNI
	public void consultarEmpleadoPorDni(String dni);
}
