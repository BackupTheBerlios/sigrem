package mec;

import java.util.Calendar;
import java.util.LinkedList;
import mco.*;
import mem.*;
import interfaz.InterfazGrafica;

public class GEconomiaImp implements GEconomia  
{
	private InterfazGrafica vista;
	
	private GEmpleados gempleados;
	
	private GContratos gcontratos;
	
	private int ultimoMesFac;
	
	private int ultimoMesGas;
	
	private int ultimoMesBal;
	
	private int[] facturacion;
	
	private int[] gastos;
	
	private int[] balance;
		
	private int cuotaContrato;
	
	public GEconomiaImp(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos,String ultimoMesFac,String ultimoMesGas,String ultimoMesBal,String fac,String gas,String bal)
	{
		this.vista=vista;
		this.gempleados=gempleados;
		this.gcontratos=gcontratos;		
		this.ultimoMesFac=Integer.valueOf(ultimoMesFac).intValue();
		this.ultimoMesGas=Integer.valueOf(ultimoMesGas).intValue();
		this.ultimoMesBal=Integer.valueOf(ultimoMesBal).intValue();
		this.facturacion=stringAVector(fac);
		this.gastos=stringAVector(gas);
		this.balance=stringAVector(bal);
		this.cuotaContrato=150;	
	}
	
	public int [] stringAVector (String s) 
	{
		int [] vect=new int[12];
		int num=0;
		int i=0;
		int n=0;
		String numero="";
		char signo;
		while ((i<s.length())&&(n<12))
		{	signo=s.charAt(i);
			i=i+1;
			while (s.charAt(i)!=',')
			{	numero=numero+s.charAt(i);
				i=i+1;
			}
			num=Integer.valueOf(numero).intValue();
			i=i+1;
			if (signo=='-')	num=num*(-1);
			vect[n]=num;
			numero="";
			n=n+1;
		}
		return vect;
	}
	
	public void facturacion(int valor,int grafica)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultimoMesFac)
		{	int desplazamiento=0;
			if (mesActual>ultimoMesFac)
			{	desplazamiento=mesActual-ultimoMesFac;}
			else if (mesActual<ultimoMesFac)
			{	desplazamiento=ultimoMesFac-mesActual;}
			for (int i=0;i<desplazamiento;i++)
			{	for (int j=0;j<11;j++)
				{						
					facturacion[j]=facturacion[j+1];				
				}
				facturacion[11]=0;			
			}
		}
		facturacion[11]=valor;
		ultimoMesFac=mesActual;
		LinkedList datos=new LinkedList();
		datos.add(new String("facturacion"));
		datos.add(facturacion);
		String nuevoUltimoMes=""+ultimoMesFac;
		datos.add(nuevoUltimoMes);
		if (grafica==0)	vista.actualizaVista(3,1,datos);
		else if (grafica==1)	vista.actualizaVista(3,3,datos);;
	}
	
	public void gastos(int valor,int grafica)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultimoMesGas)
		{
			int desplazamiento=0;
			if (mesActual>ultimoMesGas)
			{	desplazamiento=mesActual-ultimoMesGas;}
			else if (mesActual<ultimoMesGas)
			{	desplazamiento=ultimoMesGas-mesActual;}
			for (int i=0;i<desplazamiento;i++)
			{	for (int j=0;j<11;j++)
				{	
					gastos[j]=gastos[j+1];				
				}
				gastos[11]=0;			
			}
		}
		gastos[11]=valor;
		ultimoMesGas=mesActual;
		LinkedList datos=new LinkedList();
		datos.add(new String("gastos"));
		datos.add(gastos);
		String nuevoUltimoMes=""+ultimoMesGas;
		datos.add(nuevoUltimoMes);
		if (grafica==0)	vista.actualizaVista(3,1,datos);
		else if (grafica==1)	vista.actualizaVista(3,3,datos);;
	}

	public void balance(int valor,int grafica)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultimoMesBal)
		{
			int desplazamiento=0;
			if (mesActual>ultimoMesBal)
			{	desplazamiento=mesActual-ultimoMesBal;}
			else if (mesActual<ultimoMesBal)
			{	desplazamiento=ultimoMesBal-mesActual;}
			for (int i=0;i<desplazamiento;i++)
			{	for (int j=0;j<11;j++)
				{
					balance[j]=balance[j+1];				
				}
				balance[11]=0;			
			}
		}
		balance[11]=valor;
		ultimoMesBal=mesActual;
		LinkedList datos=new LinkedList();
		datos.add(new String("balance"));
		datos.add(balance);
		String nuevoUltimoMes=""+ultimoMesBal;
		datos.add(nuevoUltimoMes);
		if (grafica==0)	vista.actualizaVista(3,1,datos);
		else if (grafica==1)	vista.actualizaVista(3,3,datos);;
	}
	
	public int dameCuotaContrato()
	{
		return cuotaContrato;
	}
	
	public int dameUltimaMesFac()
	{
		return this.ultimoMesFac;
	}
	
	public int dameUltimaMesGas()
	{
		return this.ultimoMesGas;
	}
	
	public int dameUltimaMesBal()
	{
		return this.ultimoMesBal;
	}
	
	public int[] dameVectorFacturacion()
	{
		return this.facturacion;
	}
	
	public int[] dameVectorGastos()
	{
		return this.gastos;
	}
	
	public int[] dameVectorBalance()
	{
		return this.balance;
	}
}
