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
	
	private int ultMesFac;
	
	private int ultMesGas;
	
	private int ultMesBal;
	
	private int [] facturacion;
	
	private int [] gastos;
	
	private int [] balance;
		
	private int cuotaContrato;
	
	public GEconomiaImp(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos,String ultimoMesFac,String ultimoMesGas,String ultimoMesBal,String facturacion,String gastos,String balance)
	{
		this.vista=vista;
		this.gempleados=gempleados;
		this.gcontratos=gcontratos;		
		this.ultMesFac=Integer.valueOf(ultimoMesFac).intValue();
		this.ultMesGas=Integer.valueOf(ultimoMesGas).intValue();
		this.ultMesBal=Integer.valueOf(ultimoMesBal).intValue();
		this.facturacion=stringAVector(facturacion);
		this.gastos=stringAVector(gastos);
		this.balance=stringAVector(balance);
		this.cuotaContrato=33;
	}
		
	public void facturacion(int nFacturacion)
	{
		calculaVector(facturacion,ultMesFac,nFacturacion);
		String tipo="facturacion";
		String sUltMesFac=""+ultMesFac;
		LinkedList datos=new LinkedList();
		datos.add(tipo);
		datos.add(facturacion);
		datos.add(sUltMesFac);
		vista.actualizaVista(3,1,datos);
	}
	
	public void gastos(int nGastos)
	{
		calculaVector(gastos,ultMesGas,nGastos);
		String tipo="gastos";
		String sUltMesGas=""+ultMesGas;
		LinkedList datos=new LinkedList();
		datos.add(tipo);
		datos.add(gastos);
		datos.add(sUltMesGas);
		vista.actualizaVista(3,1,datos);
	}

	public void balance(int nBalance)
	{
		calculaVector(balance,ultMesBal,nBalance);
		String tipo="balance";
		String sUltMesBal=""+ultMesBal;
		LinkedList datos=new LinkedList();
		datos.add(tipo);
		datos.add(balance);
		datos.add(sUltMesBal);
		vista.actualizaVista(3,1,datos);				
	}
	
	public int dameCuotaContrato()
	{
		return cuotaContrato;
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
		{
			signo=s.charAt(i);
			i=i+1;
			while (s.charAt(i)!=',')
			{
				numero=numero+s.charAt(i);
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
	
	public void calculaVector(int [] vect,int uMes,int uVal)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=uMes)
		{
			int dif;
			if(uMes<mesActual)	dif=mesActual-uMes;
			else	dif=uMes-mesActual;
			int i=0;
			int j=0;
			while (i<12)
			{
				vect[j]=vect[j+dif];
				i=i+dif;
				j=j+1;										   
			}
			for(int k=j;k<11;k++)
			{
				vect[k]=0;
			}
			uMes=mesActual;
		}
		vect[11]=uVal;		
	}
}
