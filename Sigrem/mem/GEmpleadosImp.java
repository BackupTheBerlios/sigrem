package mem;

import java.util.LinkedList;
import java.util.Vector;
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
	public String a�adirEmpleado(String perfil,LinkedList datosEmpleado)
	{
		Empleado nuevoEmpleado=null;
		if (perfil.equals("Abogado"))
		{	nuevoEmpleado=new Abogado(codigoEmpleado,perfil,datosEmpleado);}
		else if (perfil.equals("Administrativo"))
		{	nuevoEmpleado=new Administrativo(codigoEmpleado,perfil,datosEmpleado);}
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
	// M�todo para eliminar un empleado del sistema
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
	// M�todo para modificar un empleado en el sistema
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
			datosPanel1.add(empleado.damePerfil());
			datosPanel1.add(empleado.dameNomina());
			vista.actualizaVista(2,1,datosPanel1);
			vista.actualizaVista(2,2,datosEmpleado);
		}
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
			{	vista.actualizaVistaDatos(2,empleado.dameListaDatos(),true);}
			else
			{	LinkedList datosPanel2=empleado.dameListaDatos();
				datosPanel2.remove(0);
				LinkedList datosPanel1=new LinkedList();
				datosPanel1.add(empleado.dameCodigo());
				datosPanel1.add(empleado.damePerfil());
				datosPanel1.add(empleado.dameNomina());
				vista.actualizaVista(2,1,datosPanel1);
				vista.actualizaVista(2,2,datosPanel2);				
			}
		}
	}
	// M�todo para consultar un empleado dado su Nombre
	public void consultarEmpleadoNombre(String nombre)
	{
		Vector busqueda=listaEmpleados.buscar(nombre,1);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+nombre+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);		
			LinkedList datosPanel2=empleado.dameListaDatos();
			datosPanel2.remove(0);
			LinkedList datosPanel1=new LinkedList();
			datosPanel1.add(empleado.dameCodigo());
			datosPanel1.add(empleado.damePerfil());
			datosPanel1.add(empleado.dameNomina());
			vista.actualizaVista(2,1,datosPanel1);
			vista.actualizaVista(2,2,datosPanel2);				
		}
	}
	// M�todo para consultar un empleado dado su DNI
	public void consultarEmpleadoDni(String dni)
	{
		Vector busqueda=listaEmpleados.buscar(dni,2);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado con DNI "+dni+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);		
			LinkedList datosPanel2=empleado.dameListaDatos();
			datosPanel2.remove(0);
			LinkedList datosPanel1=new LinkedList();
			datosPanel1.add(empleado.dameCodigo());
			datosPanel1.add(empleado.damePerfil());
			datosPanel1.add(empleado.dameNomina());
			vista.actualizaVista(2,1,datosPanel1);
			vista.actualizaVista(2,2,datosPanel2);				
		}
	}
	
	// M�todo para obtener la lista de empleados
	public EstructuraDatos dameListaEmpleados()
	{
		return listaEmpleados;
	}
	
	public void consultarListaAbogados()
	{
		Vector listaAbogados=new Vector();
		listaAbogados.add("Sin asignar");
		for (int i=0;i<listaEmpleados.dameTama�o();i++)
		{	Empleado empleado=(Empleado)listaEmpleados.dameIndice(0).dameElementos().get(i);
			if (empleado.damePerfil().equals("Abogado"))
			{	listaAbogados.add(empleado.dameCodigo());}
			vista.actualizaVistaAbogados(listaAbogados);
		}
	}

}
