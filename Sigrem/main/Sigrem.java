package main;

import interfaz.InterfazGrafica;
import mcl.*;
import mco.*;
import mmu.*;
import mre.*;
import mec.*;
import mem.*;

public class Sigrem 
{
	private InterfazGrafica vista;
	
	private GClientes gclientes;
	
	private GContratos gcontratos;
	
	private GMultas gmultas;
	
	private GEmpleados gempleados;
	
	private GRecursos grecursos;
	
	private GEconomia geconomia;
	
	public Sigrem()
	{
		vista=new InterfazGrafica(this);
//		gclientes=new GClientesImp(vista);
//		gcontratos=new GContratosImp(vista);
//		gmultas=new GMultasImp(vista);
//		gempleados=new GEmpleadosImp(vista);
//		grecursos=new GRecursosImp(vista);		
	}
	
	public void activa()
	{
		vista.activa();		
	}
	
	public void añadirContrato(String[] datoscontrato,String[] datoscliente)
	{
		//añadir cliene
		//añadir contrato
	}
	
	public void añadirCliente(String[] datos)
	{
	//	gclientes.añadir(datos);
	}
}
