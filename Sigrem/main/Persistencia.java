package main;

import mec.*;
import mem.*;
import mmu.*;
import mre.*;
import mco.*;
import mcl.*;

public class Persistencia 
{
	private GClientes gclientes;
	
	private GContratos gcontratos;
	
	private GMultas gmultas;
	
	private GEmpleados gempleados;
	
	private GRecursos grecursos;
	
	private GEconomia geconomia;
	
	public Persistencia(GContratos cont,GClientes cli,GEmpleados emp,GMultas mul,
						GRecursos rec,GEconomia eco)
	{
		gcontratos=cont;
		gclientes=cli;
		gmultas=mul;
		grecursos=rec;
		gempleados=emp;
		geconomia=eco;		
	}
}
