package mec;

import java.util.Calendar;
import mco.*;
import mem.*;
import interfaz.InterfazGrafica;

public class GEconomiaImp implements GEconomia  
{
	private InterfazGrafica vista;
	
	private GEmpleados gempleados;
	
	private GContratos gcontratos;
	
	private int ultimomes;
	
	private int [] facturacion;
	
	private int [] gastos;
	
	private int [] balance;
		
	private int cuotaContrato;
	
	public GEconomiaImp(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos,String ultimomes,String facturacion,String gastos,String balance)
	{
		this.vista=vista;
		this.gempleados=gempleados;
		this.gcontratos=gcontratos;
		
		int nultimomes=Integer.valueOf(ultimomes).intValue();
		this.ultimomes=nultimomes;
		this.facturacion=new int[12];
		this.gastos=new int[12];
		this.balance=new int[12];
		
		//Pasamos del String al vector
		int num=0;
		int i=0;
		int n=0;
		String numero="";
		char signo;
		while ((i<facturacion.length())&&(n<12))
		{
			signo=facturacion.charAt(i);
			i=i+1;
			while (facturacion.charAt(i)!=',')
			{
				numero=numero+facturacion.charAt(i);
				i=i+1;
			}
			num=Integer.valueOf(numero).intValue();
			i=i+1;
			if (signo=='-')	num=num*(-1);
			this.facturacion[n]=num;
			numero="";
			n=n+1;
		}
		
		//Pasamos del String al vector
		num=0;
		i=0;
		n=0;
		numero="";
		while ((i<gastos.length())&&(n<12))
		{
			signo=gastos.charAt(i);
			i=i+1;
			while (gastos.charAt(i)!=',')
			{
				numero=numero+gastos.charAt(i);
				i=i+1;
			}
			num=Integer.valueOf(numero).intValue();
			i=i+1;
			if (signo=='-')	num=num*(-1);
			this.gastos[n]=num;
			numero="";
			n=n+1;
		}
		
		//Pasamos del String al vector
		num=0;
		i=0;
		n=0;
		numero="";
		while ((i<balance.length())&&(n<12))
		{
			signo=balance.charAt(i);
			i=i+1;
			while (balance.charAt(i)!=',')
			{
				numero=numero+balance.charAt(i);
				i=i+1;
			}
			num=Integer.valueOf(numero).intValue();
			i=i+1;
			if (signo=='-')	num=num*(-1);
			this.balance[n]=num;
			numero="";
			n=n+1;
		}
		
		this.cuotaContrato=33;
	}
	
	public void gastos(int [] vGastos, int nGastos, int ultMes)
	{
		Calendar hoy=Calendar.getInstance();
		int i=hoy.get(Calendar.YEAR);
		if 
		//gempleados.dameListaEmpleados();
		//para cada empleado mirar su nomina
		//sumar todas las nominas		
	}

	public void facturacion()
	{
		int nCon=gcontratos.dameListaContratos().dameTamaño();
		int fac=nCon*cuotaContrato;
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual==ultimomes)
		{
			//facturacion[11]=fac;
		}
		//gcontratos.dameListaContratos();
		//en funcion de las mulras y los recursos de cada contrato se cancula su valor
		//sumar todos los valores de los contratos
	}
	
	public void balance()
	{
		//facturacion-gastos
	}
}
