package main;

import interfaz.InterfazGrafica;
//import mcl.GClientesImp;
//import mco.GContratosImp;
//import mmu.GMultasImp;
//import mre.GRecursosImp;
//import mec.GEconomicaImp;

public class Sigrem 
{
	private InterfazGrafica vista;
	
	private ModuloGestion gclientes;
	
	private ModuloGestion gcontratos;
	
	private ModuloGestion gmultas;
	
	private ModuloGestion gempleados;
	
	private ModuloGestion grecursos;
	
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
		gclientes.añadir(datos);
	}
}
