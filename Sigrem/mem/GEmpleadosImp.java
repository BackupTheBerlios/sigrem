package mem;

import java.util.LinkedList;
import med.*;
import interfaz.*;

public class GEmpleadosImp implements GEmpleados{
	
	private EstructuraDatos listaEmpleados;
	
	private InterfazGrafica vista;
	
	private String codigoEmpleado;
	
	// M�todo para calcular autom�ticamente el c�digo del empleado
	private void incrementaCodigo(){
		String numero = codigoEmpleado.substring(0,4);
		Character car = null;
		int num = car.digit(codigoEmpleado.charAt(4), 10);
		for (int i=5;i<codigoEmpleado.length(); i++){
			num = (num*10)+car.digit(codigoEmpleado.charAt(i), 10);
		}
		numero = numero + (num+1);
		codigoEmpleado = numero;
	}
	// Constructor de la clase
	public GEmpleadosImp(InterfazGrafica vista, String codigoEmpleado){
		this.listaEmpleados = new EstructuraDatosImp(3);
		this.vista = vista;
		this.codigoEmpleado = codigoEmpleado;
	}
	
	// M�todo para a�adir un empleado al sistema 
	// (clave0=codigo, clave1=nombre, clave2=dni)
	public String a�adirEmpleado(LinkedList listaEmpleados){
		Empleado nuevoEmpleado = new Empleado(codigoEmpleado, listaEmpleados);
		String[] claves = new String[3];
		claves[0] = codigoEmpleado;
		claves[1] = (String)listaEmpleados.get(0);
		claves[2] = (String)listaEmpleados.get(1);
		
		listaEmpleados.insertar(claves, nuevoEmpleado);
		String codigoAntiguo = codigoEmpleado;
		incrementaCodigo();
		vista.actualiza(1, 2, listaEmpleados);
		
		return codigoAntiguo;
	}
	// M�todo para eliminar un empleado del sistema
	public void eliminarEmpleado(String codigoEmpleado){}
	// M�todo para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList listaEmpleados) {}
	// M�todo para consultar un empleado dado su C�digo de Empleado
	public void consultarEmpleadoPorCodigo(String codigo){}
	// M�todo para consultar un empleado dado su Nombre
	public void consultarEmpleadoPorNombre(String nombre){}
	// M�todo para consultar un empleado dado su DNI
	public void consultarEmpleadoPorDni(String dni){}
}