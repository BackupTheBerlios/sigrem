package mem;

import java.util.LinkedList;
import java.util.Vector;

import mcl.Cliente;
import mco.Contrato;
import med.*;
import mmu.Multa;
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
	
	// Método para calcular automáticamente el código del empleado
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
	
	// Método para añadir un empleado al sistema 
	// (clave0=codigo, clave1=nombre, clave2=dni)
	public String añadirEmpleado(String perfil,LinkedList datosEmpleado)
	{
		Empleado nuevoEmpleado=null;
		if (perfil.equals("Abogado"))
		{	nuevoEmpleado=new Abogado(codigoEmpleado,datosEmpleado);}
		else if (perfil.equals("Administrativo"))
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
		datosPanel1.add(perfil);
		datosPanel1.add(datosEmpleado.get(11));
		LinkedList datosPanel2=new LinkedList();
		for (int i=0;i<11;i++) datosPanel2.add(datosEmpleado.get(i));
		vista.actualizaVista(2,1,datosPanel1);
		vista.actualizaVista(2,2,datosPanel2);
		return codigoAntiguo;
	}
	// Método para eliminar un empleado del sistema
	public void eliminarEmpleado(boolean borrar,String codigoEmpleado)
	{
		boolean eliminado=listaEmpleados.eliminar(codigoEmpleado,0);
		if (eliminado) 
		{	vista.actualizaVistaMensaje("       Empleado "+codigoEmpleado+" despedido correctamente");
			if (borrar)
			{	vista.actualizaVista(2,1,null);
				vista.actualizaVista(2,2,null);
				vista.actualizaVista(2,3,null);
			}
		}
		else vista.actualizaVistaMensaje("Error al eliminar el empleado "+codigoEmpleado+". No se ha encontrado");
	}
	// Método para modificar un empleado en el sistema
	public void modificarEmpleado(String codigoEmpleado, LinkedList datosEmpleado) 
	{
		Vector busqueda=listaEmpleados.buscar(codigoEmpleado,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codigoEmpleado+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);
			empleado.ponDireccion((String)datosEmpleado.get(2));
			empleado.ponCp((String)datosEmpleado.get(3));
			empleado.ponPoblacion((String)datosEmpleado.get(4));
			empleado.ponProvincia((String)datosEmpleado.get(5));
			empleado.ponTelefono1((String)datosEmpleado.get(6));
			empleado.ponTelefono2((String)datosEmpleado.get(7));
			empleado.ponMovil((String)datosEmpleado.get(8));
			empleado.ponEmail((String)datosEmpleado.get(9));
			empleado.ponFax((String)datosEmpleado.get(10));
			empleado.ponNomina((String)datosEmpleado.get(11));
			LinkedList datosPanel1=new LinkedList();
			datosPanel1.add(empleado.dameCodigo());
			String nombre=(empleado.getClass()).getName();
			datosPanel1.add(nombre.substring(4));
			datosPanel1.add(datosEmpleado.get(11));
			vista.actualizaVista(2,1,datosPanel1);
			vista.actualizaVista(2,2,datosEmpleado);
		}
	}
	// Método para consultar un empleado dado su Código de Empleado
	public void consultarEmpleadoCodigo(boolean modificar,String codigo)
	{
		Vector busqueda=listaEmpleados.buscar(codigo,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codigo+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);		
			if (modificar)
			{	vista.actualizaVistaDatos(2,empleado.dameListaDatos(),true);}
			else
			{//	vista.actualizaVista(1,1,contrato.dameListaDatos());
				
			}
		}
	}
	// Método para consultar un empleado dado su Nombre
	public void consultarEmpleadoNombre(String nombre)
	{
	}
	// Método para consultar un empleado dado su DNI
	public void consultarEmpleadoDni(String dni)
	{
		
	}

}
