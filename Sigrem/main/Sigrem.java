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
//		gmultas=factoria.generaGMultas(vista,codmultas);
//		grecursos=factoria.generaGRecursos(vista,codrecursos);
//		gempleados=factoria.generaGEmpleados(vista,codempleados);
//		geconomia=factoria.generaGEconomia(vista);		
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
		gclientes.asociaClienteContrato(0,clientenuevo,contratonuevo);
	}
	
	public void añadirContratoACliente(LinkedList datoscontrato,String dnicliente)
	{
		datoscontrato.addFirst(dnicliente);
		String contratonuevo=gcontratos.añadirContrato(datoscontrato);
		gclientes.asociaClienteContrato(2,dnicliente,contratonuevo);
	}
	
	public void eliminarContrato(boolean borrar,String codcontrato)
	{
		String codcliente=gcontratos.modificarFechaBaja(codcontrato);
		if (codcliente!=null) 
		{	gcontratos.eliminarContrato(borrar,codcontrato);
			gclientes.eliminarCliente(codcliente,codcontrato);		
		}
	}
	
	public void consultarContratoCodigo(boolean modificar,String codigo)
	{
		String codcliente=gcontratos.consultarContratoCodigo(modificar,codigo);
		if (codcliente!=null) gclientes.consultarClienteCodigo(modificar,codcliente);
	}	
	
	public void consultarContratoMatricula(String matricula)
	{
		String codcliente=gcontratos.consultarContratoMatricula(matricula);
		if (codcliente!=null) gclientes.consultarClienteCodigo(false,codcliente);
	}	
	
	public void modificarCliente(String codcliente,LinkedList datos)
	{
		gclientes.modificarCliente(codcliente,datos);
	}
	
	public void modificarContrato(String codcontrato,LinkedList datos)
	{
		gcontratos.modificarContrato(codcontrato,datos);
	}
}
