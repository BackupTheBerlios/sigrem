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
	public GClientes generaGCliente(InterfazGrafica vista,String codigo);
	public GContratos generaGContratos(InterfazGrafica vista,String codigo);
	public GMultas generaGMultas(InterfazGrafica vista,String codigo);
	public GRecursos generaGRecursos(InterfazGrafica vista,String codigo);
	public GEmpleados generaGEmpleados(InterfazGrafica vista,String codigo);
	public GEconomia generaGEconomia(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos);	
}
