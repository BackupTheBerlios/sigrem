package main;

import interfaz.InterfazGrafica;
import mcl.*;
import mco.*;
import mmu.*;
import mre.*;
import mec.*;
import mem.*;

public interface Factoria 
{
	public GClientes generaGCliente(InterfazGrafica vista);
	public GContratos generaGContratos(InterfazGrafica vista);
	public GMultas generaGMultas(InterfazGrafica vista);
	public GRecursos generaGRecursos(InterfazGrafica vista);
	public GEmpleados generaGEmpleados(InterfazGrafica vista);
	public GEconomia generaGEconomia(InterfazGrafica vista);	
}
