package mem;

import java.util.LinkedList;
import java.util.Vector;

import mcl.Cliente;
import mco.Contrato;
import med.*;
import interfaz.*;

public class GEmpleadosImp implements GEmpleados 
{
	private EstructuraDatos listaEmpleados;
	
	private InterfazGrafica vista;
	
	private String codigoEmpleado;
	
	// Constructor de la clase	
	public GEmpleadosImp(InterfazGrafica vista, String codigoEmpleado)
	{
		this.listaEmpleados = new EstructuraDatosImp(3);
		this.vista = vista;
		this.codigoEmpleado = codigoEmpleado;
	}
	
	// M�todo para calcular autom�ticamente el c�digo del empleado
	private void incrementaCodigo()
	{
		String numero = codigoEmpleado.substring(0,3);
		Character car = null;
		int num = car.digit(codigoEmpleado.charAt(3), 10);
		for (int i=4;i<codigoEmpleado.length(); i++){
			num = (num*10)+car.digit(codigoEmpleado.charAt(i), 10);
		}
		numero = numero + (num+1);
		codigoEmpleado = numero;
	}
	
	// M�todo para a�adir un empleado al sistema 
	// (clave0=codigo, clave1=nombre, clave2=dni)
	public String a�adirEmpleado(LinkedList datosEmpleado)
	{
		Empleado nuevoEmpleado=null;
		if (((String)datosEmpleado.get(0)).equals("Abogado"))
		{	nuevoEmpleado=new Abogado(codigoEmpleado,datosEmpleado);}
		else if (((String)datosEmpleado.get(0)).equals("Administrativo"))
		{	nuevoEmpleado=new Administrativo(codigoEmpleado,datosEmpleado);}
		String[] claves = new String[3];
		claves[0] = codigoEmpleado;
		claves[1] = (String)datosEmpleado.get(0);
		claves[2] = (String)datosEmpleado.get(1);
		listaEmpleados.insertar(claves, nuevoEmpleado);
		String codigoAntiguo = codigoEmpleado;
		incrementaCodigo();
		LinkedList datosPanel1=new LinkedList();
		datosPanel1.add(codigoAntiguo);
		datosPanel1.add(datosEmpleado.get(0));
		datosPanel1.add(datosEmpleado.get(12));
		LinkedList datosPanel2=new LinkedList();
		for (int i=1;i<12;i++) datosPanel2.add(datosEmpleado.get(i));
		vista.actualizaVista(2, 1, datosPanel1);
		vista.actualizaVista(2, 2, datosPanel2);
		return codigoAntiguo;
	}
	// M�todo para eliminar un empleado del sistema
	public void eliminarEmpleado(String codigoEmpleado)
	{
		boolean eliminado=listaEmpleados.eliminar(codigoEmpleado,0);
		if (eliminado) 
		{	vista.actualizaVistaMensaje("       Empleado "+codigoEmpleado+" despedido correctamente");
			vista.actualizaVista(2,1,null);
			vista.actualizaVista(2,2,null);
			vista.actualizaVista(2,3,null);
		}
		else vista.actualizaVistaMensaje("Error al eliminar el empleado "+codigoEmpleado+". No se ha encontrado");
	
	}
	// M�todo para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList datosEmpleado) 
	{
		
	
	}
	// M�todo para consultar un empleado dado su C�digo de Empleado
	public void consultarEmpleadoCodigo(boolean modificar,String codigo)
	{
		Vector busqueda=listaEmpleados.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codigo+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);
			if (modificar)
			{	LinkedList datos=empleado.dameListaDatos();
				Class clase=empleado.getClass();				
				datos.addFirst(clase.getName());
				vista.actualizaVistaDatos(2,empleado.dameListaDatos(),false);
			}
			else
			{	vista.actualizaVista(1,1,contrato.dameListaDatos());}
		}
	}
	// M�todo para consultar un empleado dado su Nombre
	public void consultarEmpleadoNombre(String nombre)
	{
	}
	// M�todo para consultar un empleado dado su DNI
	public void consultarEmpleadoDni(String dni)
	{
		
	}

}
