package mec;

import java.util.Calendar;
import javax.swing.JOptionPane;
import mco.*;
import mem.*;
import interfaz.InterfazGrafica;

public class GEconomiaImp implements GEconomia  
{
	private InterfazGrafica vista;
	
	private GEmpleados gempleados;
	
	private GContratos gcontratos;
		
	private int cuotaContrato;
	
	public GEconomiaImp(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos,String ultimomes,String facturacion,String gastos,String balance)
	{
		this.vista=vista;
		this.gempleados=gempleados;
		this.gcontratos=gcontratos;
		this.cuotaContrato=33;
	}
	
	public void gastos()
	{
		int nEmp=gempleados.dameListaEmpleados().dameTamaņo();
		for(int i=0;i<nEmp;i++)
		{
			
		}
		//gempleados.dameListaEmpleados();
		//para cada empleado mirar su nomina
		//sumar todas las nominas		
	}

	public void facturacion()
	{
		int nCon=gcontratos.dameListaContratos().dameTamaņo();
		int fac=nCon*cuotaContrato;
		
		//gcontratos.dameListaContratos();
		//en funcion de las mulras y los recursos de cada contrato se cancula su valor
		//sumar todos los valores de los contratos
	}
	
	public void balance()
	{
		//facturacion-gastos
	}
}
