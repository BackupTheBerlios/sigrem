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
	
	public Sigrem(String[] codigos)
	{
		vista=new InterfazGrafica(this);
		factoria=new FactoriaImp();
		codcontrato=codigos[0];
		codcliente=codigos[1];
		codmulta=codigos[2];
		codrecurso=codigos[3];
		codempleado=codigos[4];
		gclientes=factoria.generaGCliente(vista,codcliente);
		gcontratos=factoria.generaGContratos(vista,codcontrato);
		gmultas=factoria.generaGMultas(vista,codmulta);
		grecursos=factoria.generaGRecursos(vista,codrecurso);
		gempleados=factoria.generaGEmpleados(vista,codempleado);
		geconomia=factoria.generaGEconomia(vista,gempleados,gcontratos);		
	}
	
	public void activa()
	{
		vista.activa();		
	}
	
	public void añadirContrato(LinkedList datoscontrato,LinkedList datoscliente)
	{
		String clientenuevo=gclientes.añadirCliente(datoscliente);
		datoscontrato.addFirst(clientenuevo);
		String contratonuevo=gcontratos.añadirContrato(datoscontrato);
		gclientes.asociaClienteContrato(clientenuevo,contratonuevo);
		vista.actualizaVista(1,3,null);
	}
	
	public void añadirContratoACliente(LinkedList datoscontrato,String codcliente)
	{
		datoscontrato.addFirst(codcliente);
		String contratonuevo=gcontratos.añadirContrato(datoscontrato);
		gclientes.asociaClienteContrato(codcliente,contratonuevo);
		vista.actualizaVista(1,3,null);
	}
	
	public void eliminarContrato(boolean borrar,boolean actualizar,String codcontrato)
	{
		String codcliente=gcontratos.modificarFechaBaja(codcontrato);
		if (codcliente!=null) 
		{	LinkedList listamultas=gcontratos.dameListaMultasContrato(0,codcontrato);
			gmultas.eliminaListaMultas(listamultas);
			gcontratos.eliminarContrato(borrar,codcontrato);
			gclientes.eliminarCliente(actualizar,codcliente,codcontrato);			
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
	
	public void consultarContratoMatricula(String matricula)
	{
		String codcliente=gcontratos.consultarContratoMatricula(matricula);
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
		gcontratos.asociaContratoMulta(codcontrato,codmulta);
	}
	
	public void eliminarMulta(String codmulta,String codcontrato)
	{
		gmultas.eliminarMulta(codmulta);
		gcontratos.eliminarMulta(codcontrato,codmulta);
	}
	
	public void modificarMulta(String codigo,LinkedList datos)
	{
		gmultas.modificarMulta(codigo,datos);
	}
	
	public void consultarMultaCodigo(String codigo)
	{
		String codcontrato=gmultas.consultarMultaCodigo(codigo);
		consultarContratoCodigo(false,true,codcontrato);		
	}
	
	public void consultarMultaExpediente(String codigo)
	{
		String codcontrato=gmultas.consultarMultaExpediente(codigo);
		consultarContratoCodigo(false,true,codcontrato);		
	}
	
	public void consultarMultaBoletin(String codigo)
	{
		String codcontrato=gmultas.consultarMultaBoletin(codigo);
		consultarContratoCodigo(false,true,codcontrato);		
	}
}
