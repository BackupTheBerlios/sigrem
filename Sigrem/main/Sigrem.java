package main;

import interfaz.InterfazGrafica;
import mcl.GClientesImp;
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
	
	public Sigrem(InterfazGrafica vista)
	{
		this.vista=vista;
		gclientes=new GClientesImp(vista);
//		gcontratos=new GContratosImp(vista);
//		gmultas=new GMultasImp(vista);
//		gempleados=new GEmpleadosImp(vista);
//		grecursos=new GRecursosImp(vista);		
	}
}
