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
	public GClientes generaGCliente(InterfazGrafica vista,String codigo)
	{
		return new GClientesImp(vista,codigo);
	}
	
	public GContratos generaGContratos(InterfazGrafica vista,String codigo)
	{
		return new GContratosImp(vista,codigo);
	}
	
	public GMultas generaGMultas(InterfazGrafica vista,String codigo)
	{
		return new GMultasImp(vista,codigo);
	}
	
	public GRecursos generaGRecursos(InterfazGrafica vista,String codigo)
	{
		return new GRecursosImp(vista,codigo);
	}
	
	public GEmpleados generaGEmpleados(InterfazGrafica vista,String codigo)
	{
		return new GEmpleadosImp(vista,codigo);
	}
	
	public GEconomia generaGEconomia(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos,String ultimoMesFac,String ultimoMesGas,String ultimoMesBal,String facturacion,String gastos,String balance)
	{
		return new GEconomiaImp(vista,gempleados,gcontratos,ultimoMesFac,ultimoMesGas,ultimoMesBal,facturacion,gastos,balance);		
	}
}
