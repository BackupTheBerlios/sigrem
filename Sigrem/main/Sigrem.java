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
	
	private Persistencia persistencia;
	
	private Factoria factoria;
	
	private GClientes gclientes;
	
	private GContratos gcontratos;
	
	private GMultas gmultas;
	
	private GEmpleados gempleados;
	
	private GRecursos grecursos;
	
	private GEconomia geconomia;
	
	public Sigrem(String[] codigos)
	{
		vista=new InterfazGrafica(this);
		factoria=new FactoriaImp();
		String codcontrato=codigos[0];
		String codcliente=codigos[1];
		String codmulta=codigos[2];
		String codrecurso=codigos[3];
		String codempleado=codigos[4];		
		String ultimoMesFac=codigos[5];
		String ultimoMesGas=codigos[6];
		String ultimoMesBal=codigos[7];
		String facturacion=codigos[8];
		String gastos=codigos[9];
		String balance=codigos[10];		
		gclientes=factoria.generaGCliente(vista,codcliente);
		gcontratos=factoria.generaGContratos(vista,codcontrato);
		gmultas=factoria.generaGMultas(vista,codmulta);
		grecursos=factoria.generaGRecursos(vista,codrecurso);
		gempleados=factoria.generaGEmpleados(vista,codempleado);
		geconomia=factoria.generaGEconomia(vista,gempleados,gcontratos,ultimoMesFac,ultimoMesGas,ultimoMesBal,facturacion,gastos,balance);
		persistencia=new Persistencia(gcontratos,gclientes,gempleados,gmultas,grecursos,geconomia);
	}
	
	public void activa()
	{
		vista.activa();
		//persistencia.cargarXML();
	}
	
	public void desactiva()
	{	System.out.println("Finalizando....");
		persistencia.almacenarXML();
		persistencia.almacenarConfigIni();
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
		{	gclientes.asociaClienteContrato(true,codigoCliente,codigoContratoNuevo);
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
			if ((codabogado!=null) && (!codabogado.equals("Sin asignar")))
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
		String codempleado=(String)datos.get(5);
		if (!codempleado.equals("Sin asignar"))
			gempleados.asociaAbogadoRecurso(codempleado,codrecurso);
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
		String antiguoCodEmpleado=grecursos.modificarRecurso(codigo,datos);
		if (!antiguoCodEmpleado.equals("Sin asignar"))
		{	gempleados.eliminarRecursoAbogado(codigo,antiguoCodEmpleado);
			consultarAbogadoRemotamente(antiguoCodEmpleado);
		}
		String codempleado=(String)datos.get(5);
		if (!codempleado.equals("Sin asignar"))
			gempleados.asociaAbogadoRecurso(codempleado,codigo);
		
	}
	
	public void consultarListaRecursos(String codigo)
	{
		LinkedList listarecursos=gmultas.dameListaRecursosMulta(codigo);
		grecursos.consultarListaRecursos(1,listarecursos);
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
		String codempleado=gempleados.consultarEmpleadoCodigo(modificar,codigo);
		if (codempleado!=null)
		{	LinkedList listaRecursos=gempleados.dameListaRecursosEmpleado(0,codigo);
			if (listaRecursos!=null)
			{	grecursos.consultarListaRecursos(2,listaRecursos);}
		}
	}
	public void consultarEmpleadoNombre(String nombre)
	{
		String codempleado=gempleados.consultarEmpleadoNombre(nombre);
		if (codempleado!=null)
		{	LinkedList listaRecursos=gempleados.dameListaRecursosEmpleado(1,nombre);
			if (listaRecursos!=null)
			{	grecursos.consultarListaRecursos(2,listaRecursos);}
		}
	}
	public void consultarEmpleadoDni(String dni)
	{
		String codempleado=gempleados.consultarEmpleadoDni(dni);
		if (codempleado!=null)
		{	LinkedList listaRecursos=gempleados.dameListaRecursosEmpleado(2,dni);
			if (listaRecursos!=null)
			{	grecursos.consultarListaRecursos(2,listaRecursos);}
		}
	}	
	public void modificarEmpleado(String codigo,LinkedList datos)
	{
		gempleados.modificarEmpleado(codigo,datos);
	}
	
	public void consultarListaAbogados()
	{
		gempleados.consultarListaAbogados();
	}
	
	public void consultarAbogadoRemotamente(String codigo)
	{
		vista.actualizarVistaConsultaAbogado(codigo);
	}
	
	public void calculaFacturacion(int grafica)
	{
		int fac=geconomia.dameCuotaContrato()*gcontratos.dameEstructuraContratos().dameTamaño();
		geconomia.facturacion(fac,grafica);
	}
	
	public void calculaGastos(int grafica)
	{
		int gas=0;
		for(int i=0;i<gempleados.dameEstructuraEmpleados().dameTamaño();i++)
		{	gas=gas+Integer.valueOf(((Empleado)gempleados.dameEstructuraEmpleados().dameIndice(0).dameElementos().get(i)).dameNomina()).intValue();}
		geconomia.gastos(-gas,grafica);
	}
	
	public void calculaBalance(int grafica)
	{
		int fac=geconomia.dameCuotaContrato()*gcontratos.dameEstructuraContratos().dameTamaño();
		int gas=0;
		for(int i=0;i<gempleados.dameEstructuraEmpleados().dameTamaño();i++)
		{	gas=gas+Integer.valueOf(((Empleado)gempleados.dameEstructuraEmpleados().dameIndice(0).dameElementos().get(i)).dameNomina()).intValue();}
		int bal=fac-gas;
		geconomia.balance(bal,grafica);				
	}
}
