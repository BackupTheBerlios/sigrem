/*
 * Created on 22-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mem;

import java.util.LinkedList;
import med.*;
import interfaz.*;

/**
 * @author sergio
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class GEmpleadosImp implements GEmpleados {

	private EstructuraDatos listaEmpleados;
	
	private InterfazGrafica vista;
	
	private String codigoEmpleado;
	
	// Método para calcular automáticamente el código del empleado
	private void incrementaCodigo(){
		String numero = codigoEmpleado.substring(0,3);
		Character car = null;
		int num = car.digit(codigoEmpleado.charAt(3), 10);
		for (int i=4;i<codigoEmpleado.length(); i++){
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
	
	// Método para añadir un empleado al sistema 
	// (clave0=codigo, clave1=nombre, clave2=dni)
	public String añadirEmpleado(LinkedList datosEmpleado){
		
		// Dependiendo de la elección que haya hecho el ususario en la GUI
		// se construye un Abogado o un Administrativo
		Empleado nuevoEmpleado = new Abogado(codigoEmpleado, datosEmpleado);
		
		String[] claves = new String[3];
		claves[0] = codigoEmpleado;
		claves[1] = (String)datosEmpleado.get(0);
		claves[2] = (String)datosEmpleado.get(1);
		
		listaEmpleados.insertar(claves, nuevoEmpleado);
		
		String codigoAntiguo = codigoEmpleado;
		
		incrementaCodigo();
		
		vista.actualizaVista(1, 2, datosEmpleado);
		
		return codigoAntiguo;
	}
	// Método para eliminar un empleado del sistema
	public void eliminarEmpleado(String codigoEmpleado){
		Object[] busqueda = listaEmpleados.buscar(codigoEmpleado, 0);
		if (busqueda.length == 0){
			vista.actualizaVistaMensaje("Error al buscar el empleado"+
										codigoEmpleado+". No se ha encontrado");
		}
		else if (busqueda[0] != null){
			Empleado empleado = (Empleado)busqueda[0];
			
			boolean haSidoEliminado = listaEmpleados.eliminar(codigoEmpleado, 0);
			
			if(haSidoEliminado){
				vista.actualizaVistaMensaje("Empleado "+codigoEmpleado+" eliminado");
			}
			else{
				vista.actualizaVistaMensaje("Se produjo un error en la eliminación del empleado "+codigoEmpleado);
			}
			
		}
	}
	// Método para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList datosEmpleado) {
		
		Object[] busqueda = listaEmpleados.buscar(codigoEmpleado, 0);
		
		if (busqueda[0] == null){
			vista.actualizaVistaMensaje("Se produjo un error en la búsqueda del empleado "+codigoEmpleado);
		}
		else if(busqueda[0] != null){
			Empleado empleado = (Empleado)busqueda[0];
			empleado.ponDireccion((String)datosEmpleado.get(2));
			empleado.ponCp((String)datosEmpleado.get(3));
			empleado.ponPoblacion((String)datosEmpleado.get(4));
			empleado.ponProvincia((String)datosEmpleado.get(5));
			empleado.ponTelefono1((String)datosEmpleado.get(6));
			empleado.ponTelefono2((String)datosEmpleado.get(7));
			empleado.ponMovil((String)datosEmpleado.get(8));
			empleado.ponEmail((String)datosEmpleado.get(9));
			empleado.ponFax((String)datosEmpleado.get(10));
			
			vista.actualizaVista(1, 2, empleado.dameListaDatos());
			
		}
	}
	// Método para consultar un empleado dado su Código de Empleado
	public void consultarEmpleadoPorCodigo(String codigo){
		
		Object[] busqueda = listaEmpleados.buscar(codigo, 0);
		
		if(busqueda.length == 0){
			vista.actualizaVistaMensaje("Se produjo un error en la búsqueda del empleado cuyo código es "+codigo);
		}
		else if(busqueda[0] != null){
			Empleado empleado = (Empleado)busqueda[0];
	/*		
			LinkedList datosEmpleado = new LinkedList();
			datosEmpleado.add(empleado.dameNombre());
			datosEmpleado.add(empleado.dameDni());
			datosEmpleado.add(empleado.dameDireccion());
			datosEmpleado.add(empleado.dameCp());
			datosEmpleado.add(empleado.damePoblacion());
			datosEmpleado.add(empleado.dameProvincia());
			datosEmpleado.add(empleado.dameTelefono1());
			datosEmpleado.add(empleado.dameTelefono2());
			datosEmpleado.add(empleado.dameMovil());
			datosEmpleado.add(empleado.dameEmail());
			datosEmpleado.add(empleado.dameFax());
	*/		
			// Esto del true no se pa qué es pero supongo que sera algo relacionado con el MODIFICAR que había
			//vista.actualizaVistaDatos(1, datosEmpleado, true);
			// Esto es lo que se hacía cuando no se estaba modificando
			vista.actualizaVista(1, 2, empleado.dameListaDatos());
		}
		else
			vista.actualizaVistaMensaje("El empleado no se encuentra en el sistema");
	}
	// Método para consultar un empleado dado su Nombre
	public void consultarEmpleadoPorNombre(String nombre){
		
		Object[] busqueda = listaEmpleados.buscar(nombre, 1);
		
		if(busqueda.length == 0){
			vista.actualizaVistaMensaje("Se produjo un error en la búsqueda del empleado cuyo nombre es "+nombre);
		}
		else if(busqueda[0] != null){
			Empleado empleado = (Empleado)busqueda[0];

			vista.actualizaVista(1, 2, empleado.dameListaDatos());
		}
		else
			vista.actualizaVistaMensaje("El empleado no se encuentra en el sistema");
	}
	// Método para consultar un empleado dado su DNI
	public void consultarEmpleadoPorDni(String dni){
		
		Object[] busqueda = listaEmpleados.buscar(dni, 2);
		
		if(busqueda.length == 0){
			vista.actualizaVistaMensaje("Se produjo un error en la búsqueda del empleado cuyo DNI "+dni);
		}
		else if(busqueda[0] != null){
			Empleado empleado = (Empleado)busqueda[0];

			vista.actualizaVista(1, 2, empleado.dameListaDatos());
		}
		else
			vista.actualizaVistaMensaje("El empleado no se encuentra en el sistema");
	}

}
