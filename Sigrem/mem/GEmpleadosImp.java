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
	
	public GEmpleadosImp(InterfazGrafica vista, String codigoEmpleado)
	{
		this.listaEmpleados = new EstructuraDatosImp(3);
		this.vista = vista;
		this.codigoEmpleado = codigoEmpleado;
	}
	
	private void incrementaCodigo()
	{
		String numero = codigoEmpleado.substring(0,3);
		int num=Integer.valueOf(codigoEmpleado.substring(3)).intValue();
		numero = numero + (num+1);
		codigoEmpleado = numero;
	}
	
	// (clave0=codigo, clave1=nombre, clave2=dni)
	public String añadirEmpleado(String perfil,LinkedList datosEmpleado)
	{	String codigo=this.dameCodigo();
		String nombre=(String)datosEmpleado.get(0);
		String dni=(String)datosEmpleado.get(1);
		
		Empleado nuevoEmpleado=null;
		if (perfil.equals("Abogado"))
		{	nuevoEmpleado=new Abogado(codigoEmpleado,perfil,datosEmpleado);}
		else if (perfil.equals("Administrativo"))
		{	nuevoEmpleado=new Administrativo(codigoEmpleado,perfil,datosEmpleado);}
			if (!listaEmpleados.esta(dni,2))
		{	meteEmpleado(nuevoEmpleado);
			incrementaCodigo();
			LinkedList datosPanel1=new LinkedList();
			datosPanel1.add(codigo);
			datosPanel1.add(perfil);
			datosPanel1.add(datosEmpleado.get(11));
			LinkedList datosPanel2=new LinkedList();
			for (int i=0;i<11;i++) datosPanel2.add(datosEmpleado.get(i));
			vista.actualizaVista(2,1,datosPanel1);
			vista.actualizaVista(2,2,datosPanel2);
			vista.actualizaVista(2,3,null);
			return codigo;
		}
		else
		{	vista.actualizaVistaMensaje("Error al contratar al empleado "+codigoEmpleado+". DNI repetido");
			return null;
		}	
	}
	
	public void meteEmpleado(Empleado empleado){
		String[] claves = new String[3];
		claves[0]=empleado.dameCodigo();
		claves[1]=empleado.dameNombre();
		claves[2]=empleado.dameDni();
		this.dameEstructuraEmpleados().insertar(claves,empleado);
	}

	public void eliminarEmpleado(boolean borrar,String codigoEmpleado)
	{
		Vector busqueda=listaEmpleados.buscar(codigoEmpleado,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codigoEmpleado+". No se ha encontrado");}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);
			boolean eliminar=true;
			if (empleado.damePerfil().equals("Abogado"))
			{	Abogado abogado=(Abogado)empleado;
				if (abogado.dameListaRecursos().size()>0)
				{	vista.actualizaVistaMensaje("No se puede despedir al abogado "+codigoEmpleado+" mientras tenga recursos asignados");
					eliminar=false;
				}
				else
				{	eliminar=true;}
			}
			if (eliminar)
			{	boolean eliminado=listaEmpleados.eliminar(codigoEmpleado,0);
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
		}
	}

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
				vista.actualizaVista(2,3,null);
			}
		}
	}

	public void consultarEmpleadoNombre(String nombre)
	{
		Vector busqueda=listaEmpleados.buscar(nombre,1);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+nombre+". No se ha encontrado");}
		else 
		{	if (busqueda.size()==1)
			{	Empleado empleado=(Empleado)busqueda.get(0);		
				LinkedList datosPanel2=empleado.dameListaDatos();
				datosPanel2.remove(0);
				LinkedList datosPanel1=new LinkedList();
				datosPanel1.add(empleado.dameCodigo());
				datosPanel1.add(empleado.damePerfil());
				datosPanel1.add(empleado.dameNomina());
				vista.actualizaVista(2,1,datosPanel1);
				vista.actualizaVista(2,2,datosPanel2);	
				vista.actualizaVista(2,3,null);		
			}
			else
			{	Vector dnis=new Vector();
				for (int i=0;i<busqueda.size();i++)
				{	Empleado empleado=(Empleado)busqueda.get(i);
					dnis.add(empleado.dameDni());
				}
				vista.actualizaVistaConsulta(2,nombre,dnis);
			}
		}
	}

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
			vista.actualizaVista(2,3,null);	
		}
	}
	
	public EstructuraDatos dameEstructuraEmpleados()
	{
		return listaEmpleados;
	}
	
	public void consultarListaAbogados()
	{
		Vector listaAbogados=new Vector();
		listaAbogados.add("Sin asignar");
		for (int i=0;i<listaEmpleados.dameTamaño();i++)
		{	Empleado empleado=(Empleado)listaEmpleados.dameIndice(0).dameElementos().get(i);
			if (empleado.damePerfil().equals("Abogado"))
			{	listaAbogados.add(empleado.dameCodigo());}
			vista.actualizaVistaAbogados(listaAbogados);
		}
	}
	
	public void asociaAbogadoRecurso(String codempleado,String codrecurso)
	{
		Vector busqueda=listaEmpleados.buscar(codempleado,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codempleado+". No se ha encontrado");}
		else 
		{	Abogado empleado=(Abogado)busqueda.get(0);
			empleado.añadirRecurso(codrecurso);			
		}
	}
	
	public void eliminarRecursoAbogado(String codrecurso,String codempleado)
	{
		Vector busqueda=listaEmpleados.buscar(codempleado,0);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codempleado+". No se ha encontrado");}
		else 
		{	Abogado empleado=(Abogado)busqueda.get(0);
			empleado.eliminarRecurso(codrecurso);			
		}
	}
	
	public LinkedList dameListaRecursosEmpleado(int clave,String codigo)
	{
		Vector busqueda=listaEmpleados.buscar(codigo,clave);
		if (busqueda.size()==0)
		{	vista.actualizaVistaMensaje("Error al buscar el empleado "+codigo+". No se ha encontrado");
			return null;
		}
		else 
		{	Empleado empleado=(Empleado)busqueda.get(0);
			if (empleado.damePerfil().equals("Abogado"))
			{	Abogado abogado=(Abogado)empleado;
				return abogado.dameListaRecursos();
			}
			else
				return null;			
		}
	}
	
	public String dameCodigo()
	{
		return this.codigoEmpleado;
	}
}
