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
		for (int i=0;i<12;i++)
			System.out.print(facturacion[i]+",");
		for (int i=0;i<12;i++)
			System.out.print(gastos[i]+",");
		for (int i=0;i<12;i++)
			System.out.print(balance[i]+",");
		this.cuotaContrato=33;
	}
	
	public void facturacion(int fact)
	{
	/*	Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual>ultimoMesFac)
		
		desplazarVectorFacturacion();
		calculaVector(facturacion,ultMesFac,nFacturacion);
		for (int i=0;i<12;i++)
			System.out.println(facturacion[i]);
		String tipo="facturacion";
		String sUltMesFac=""+ultMesFac;
		LinkedList datos=new LinkedList();
		datos.add(tipo);
		datos.add(facturacion);
		datos.add(sUltMesFac);
		vista.actualizaVista(3,1,datos);*/
	}
	
	public void gastos(int valor)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		int desplazamiento=0;
		if (mesActual>ultimoMesGas)
		{	desplazamiento=mesActual-ultimoMesGas;}
		else if (mesActual<ultimoMesGas)
		{	desplazamiento=12-ultimoMesGas+mesActual;}
		for (int i=0;i<=desplazamiento;i++)
		{	for (int j=0;j<11;j++)
			{	gastos[i]=gastos[i+1];}
			gastos[11]=0;			
		}
		gastos[11]=valor;
		ultimoMesGas=mesActual;
		LinkedList datos=new LinkedList();
		datos.add(new String("gastos"));
		datos.add(gastos);
		String nuevoUltimoMes=""+ultimoMesGas;
		datos.add(nuevoUltimoMes);
		vista.actualizaVista(3,1,datos);
	}

	public void balance(int nBalance)
	{
/*		calculaVector(balance,ultMesBal,nBalance);
		String tipo="balance";
		String sUltMesBal=""+ultMesBal;
		LinkedList datos=new LinkedList();
		datos.add(tipo);
		datos.add(balance);
		datos.add(sUltMesBal);
		vista.actualizaVista(3,1,datos);				
*/	}
	
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
			{	vect[j]=vect[j+dif];
				i=i+dif;
				j=j+1;										   
			}
			for(int k=j;k<11;k++)
			{	vect[k]=0;}
			uMes=mesActual;
		}
		vect[11]=uVal;	
	}
}
