package main;

import interfaz.InterfazGrafica;
import mcl.*;
import mco.*;
import mec.*;
import mem.*;
import mmu.*;
import mre.*;

public class FactoriaImp implements Factoria
{
	public GClientes generaGCliente(InterfazGrafica vista)
	{
		return new GClientesImp(vista);
	}
	
	public GContratos generaGContratos(InterfazGrafica vista)
	{
		return new GContratosImp(vista);
	}
	
	public GMultas generaGMultas(InterfazGrafica vista)
	{
		return new GMultasImp(vista);
	}
	
	public GRecursos generaGRecursos(InterfazGrafica vista)
	{
		return new GRecursosImp(vista);
	}
	
	public GEmpleados generaGEmpleados(InterfazGrafica vista)
	{
		return new GEmpleadosImp(vista);
	}
	
	public GEconomia generaGEconomia(InterfazGrafica vista)
	{
		return new GEconomiaImp(vista);		
	}
}
