package main;

import interfaz.InterfazGrafica;
import mcl.*;
import mco.*;
import mmu.*;
import mre.*;
import mec.*;
import mem.*;
import java.util.LinkedList;

public class Sigrem 
{
	private InterfazGrafica vista;
	
	private Factoria factoria;
	
	private GClientes gclientes;
	
	private GContratos gcontratos;
	
	private GMultas gmultas;
	
	private GEmpleados gempleados;
	
	private GRecursos grecursos;
	
	private GEconomia geconomia;
	
	private String codcontrato;
	
	private String codcliente;
	
	private String codmulta;
	
	private String codrecurso;
	
	private String codempleado;
	
	private String ultimomes;
	
	private String facturacion;
	
	private String gastos;
	
	private String balance;
	
	public Sigrem(String[] codigos)
	{
		vista=new InterfazGrafica(this);
		factoria=new FactoriaImp();
		codcontrato=codigos[0];
		codcliente=codigos[1];
		codmulta=codigos[2];
		codrecurso=codigos[3];
		codempleado=codigos[4];
		ultimomes=codigos[5];
		facturacion=codigos[6];
		gastos=codigos[7];
		balance=codigos[8];
		gclientes=factoria.generaGCliente(vista,codcliente);
		gcontratos=factoria.generaGContratos(vista,codcontrato);
		gmultas=factoria.generaGMultas(vista,codmulta);
		grecursos=factoria.generaGRecursos(vista,codrecurso);
		gempleados=factoria.generaGEmpleados(vista,codempleado);
		geconomia=factoria.generaGEconomia(vista,gempleados,gcontratos,ultimomes,facturacion,gastos,balance);		
	}
	
	public void activa()
	{
		vista.activa();		
	}
	
	public void añadirContrato(LinkedList datosContrato,LinkedList datosCliente)
	{
		if (gcontratos.consultarContratoMatricula(false,(String)datosContrato.get(0))==null)
		{	String codigoClienteNuevo=gclientes.añadirCliente(datosCliente);
			if (codigoClienteNuevo!=null)
			{	añadirContratoACliente(datosContrato,codigoClienteNuevo);
				vista.actualizaVista(1,3,null);
			}
		}
	}
	
	public void añadirContratoACliente(LinkedList datosContrato,String codigoCliente)
	{
		datosContrato.addFirst(codigoCliente);
		String codigoContratoNuevo=gcontratos.añadirContrato(datosContrato);
		if (codigoContratoNuevo!=null)
		{	gclientes.asociaClienteContrato(codigoCliente,codigoContratoNuevo);
			vista.actualizaVista(1,3,null);
		}		
	}
	
	public void eliminarContrato(boolean borrar,boolean actualizar,String codcontrato)
	{
		String codcliente=gcontratos.modificarFechaBaja(codcontrato);
		if (codcliente!=null) 
		{	LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codcontrato);
			for (int i=0;i<listamultas.size();i++)
			{	LinkedList listaRecursos=gmultas.dameListaRecursosMulta((String)listamultas.get(i));
				eliminarAsociacionRecursos(listaRecursos);
				grecursos.eliminarListaRecursos(listaRecursos);				
			}
			gmultas.eliminaListaMultas(actualizar,listamultas);
			gcontratos.eliminarContrato(borrar,codcontrato);
			gclientes.eliminarCliente(actualizar,codcliente,codcontrato);			
		}
	}
	
	public void eliminarAsociacionRecursos(LinkedList listaRecursos)
	{
		for (int i=0;i<listaRecursos.size();i++)
		{	String codrecurso=(String)listaRecursos.get(i);
			String codabogado=grecursos.consultarAbogadoRecurso(codrecurso);
			if ((codabogado!=null) && (!codempleado.equals("Sin asignar")))
			{	gempleados.eliminarRecursoAbogado(codrecurso,codabogado);}			
		}
	}
	
	public void consultarContratoCodigo(boolean modificar,boolean actualizar,String codigo)
	{
		String codcliente=gcontratos.consultarContratoCodigo(modificar,codigo);
		if (codcliente!=null)
		{	gclientes.consultarClienteCodigo(modificar,actualizar,codcliente);
			if (!modificar) 
			{	LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codigo);
				gmultas.consultarListaMultas(listamultas);
			}
		}
	}	
	
	public void consultarContratoMatricula(boolean actualizar,String matricula)
	{
		String codcliente=gcontratos.consultarContratoMatricula(actualizar,matricula);
		if (codcliente!=null) 
		{	gclientes.consultarClienteCodigo(false,true,codcliente);
			LinkedList listamultas=gcontratos.dameListaMultasContrato(1,matricula);
			gmultas.consultarListaMultas(listamultas);
		}
	}	
	
	public void consultarClienteCodigo(boolean modificar,boolean actualizar,String codigo)
	{
		String codcontrato=gclientes.consultarClienteCodigo(modificar,actualizar,codigo);
		if (codcontrato!=null) 
		{	gcontratos.consultarContratoCodigo(modificar,codcontrato);
			LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codcontrato);
			gmultas.consultarListaMultas(listamultas);
		}
	}
	
	public void consultarClienteDni(String dni)
	{
		String codcontrato=gclientes.consultarClienteDni(dni);
		if (codcontrato!=null) 
		{	gcontratos.consultarContratoCodigo(false,codcontrato);
			LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codcontrato);
			gmultas.consultarListaMultas(listamultas);
		}
	}
	
	public void consultarClienteNombre(String nombre)
	{
		String codcontrato=gclientes.consultarClienteNombre(nombre);
		if (codcontrato!=null) 
		{	gcontratos.consultarContratoCodigo(false,codcontrato);
			LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codcontrato);
			gmultas.consultarListaMultas(listamultas);
		}
	}
	
	public void modificarCliente(String codcliente,LinkedList datos)
	{
		gclientes.modificarCliente(codcliente,datos);
	}
	
	public void modificarContrato(String codcontrato,LinkedList datos)
	{
		gcontratos.modificarContrato(codcontrato,datos);
	}
	
	public void añadirMulta(String codcontrato,LinkedList datos)
	{
		String codmulta=gmultas.añadirMulta(datos);
		if (codmulta!=null){
			gcontratos.asociaContratoMulta(codcontrato,codmulta);
		}
	}
	
	public void eliminarMulta(boolean actualizar,String codmulta,String codcontrato)
	{
		LinkedList listaRecursos=gmultas.dameListaRecursosMulta(codmulta);
		grecursos.eliminarListaRecursos(listaRecursos);
		gmultas.eliminarMulta(actualizar,codmulta);
		gcontratos.eliminarMulta(codcontrato,codmulta);		
	}
	
	public void modificarMulta(String codigo,LinkedList datos)
	{
		gmultas.modificarMulta(codigo,datos);
	}
	
	public void consultarMultaCodigo(String codigo)
	{
		String codcontrato=gmultas.consultarMultaCodigo(codigo);
		if (codcontrato!=null) consultarContratoCodigo(false,true,codcontrato);		
	}
	
	public void consultarMultaExpediente(String codigo)
	{
		String codcontrato=gmultas.consultarMultaExpediente(true,codigo);
		if (codcontrato!=null) consultarContratoCodigo(false,true,codcontrato);		
	}
	
	public void consultarMultaBoletin(String codigo)
	{
		String codcontrato=gmultas.consultarMultaBoletin(true,codigo);
		if (codcontrato!=null) consultarContratoCodigo(false,true,codcontrato);		
	}
	
	public void añadirRecurso(String codmulta,LinkedList datos)
	{
		String codrecurso=grecursos.añadirRecurso(datos);
		gmultas.asociaMultaRecurso(codmulta,codrecurso);
		gempleados.asociaAbogadoRecurso(codrecurso,(String)datos.get(5));
	}
	
	public void eliminarRecurso(String codrecurso,String codmulta,String codempleado)
	{
		grecursos.eliminarRecurso(codrecurso,codmulta);
		gmultas.eliminarRecurso(codmulta,codrecurso);
		if (!codempleado.equals("Sin asignar"))
			gempleados.eliminarRecursoAbogado(codrecurso,codempleado);
	}
	
	public void modificarRecurso(String codigo,LinkedList datos)
	{
		grecursos.modificarRecurso(codigo,datos);
	}
	
	public void consultarListaRecursos(String codigo)
	{
		LinkedList listarecursos=gmultas.dameListaRecursosMulta(codigo);
		grecursos.consultarListaRecursos(listarecursos);
	}
	
	public void consultarRecursoCodigo(String codigo)
	{
		String codmulta=grecursos.consultarRecursoCodigo(codigo);
		if (codmulta!=null)
		{	consultarMultaCodigo(codmulta);}
	}
	
	public void contratarEmpleado(String perfil,LinkedList datos)
	{
		gempleados.añadirEmpleado(perfil,datos);
	}
	
	public void despedirEmpleado(boolean borrar,String codigo)
	{
		gempleados.eliminarEmpleado(borrar,codigo);
	}
	
	public void consultarEmpleadoCodigo(boolean modificar,String codigo)
	{
		gempleados.consultarEmpleadoCodigo(modificar,codigo);
	}
	public void consultarEmpleadoNombre(String nombre)
	{
		gempleados.consultarEmpleadoNombre(nombre);
	}
	public void consultarEmpleadoDni(String dni)
	{
		gempleados.consultarEmpleadoDni(dni);
	}	
	public void modificarEmpleado(String codigo,LinkedList datos)
	{
		gempleados.modificarEmpleado(codigo,datos);
	}
	
	public void consultarListaAbogados()
	{
		gempleados.consultarListaAbogados();
	}
}
