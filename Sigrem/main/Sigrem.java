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
	
	public Sigrem()
	{
		vista=new InterfazGrafica(this);
		factoria=new FactoriaImp();
		gclientes=factoria.generaGCliente(vista);
		gcontratos=factoria.generaGContratos(vista);
		gmultas=factoria.generaGMultas(vista);
		grecursos=factoria.generaGRecursos(vista);
		gempleados=factoria.generaGEmpleados(vista);
		geconomia=factoria.generaGEconomia(vista);		
	}
	
	public void activa()
	{
		vista.activa();		
	}
	
	public void añadirContrato(LinkedList datoscontrato,LinkedList datoscliente)
	{
		String clientenuevo=gclientes.añadirCliente(datoscliente);
		datoscontrato.add(clientenuevo);
		String contratonuevo=gcontratos.añadirContrato(datoscontrato);
	}
	
	public void añadirCliente(String[] datos)
	{
	//	gclientes.añadir(datos);
	}
}
