package mec;

import java.util.Calendar;
//import java.util.LinkedList;

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
		int nUltimoMesFac=Integer.valueOf(ultimoMesFac).intValue();
		this.ultMesFac=nUltimoMesFac;
		System.out.println("this.ultimoMesFac"+this.ultMesFac);
		int nUltimoMesGas=Integer.valueOf(ultimoMesGas).intValue();
		this.ultMesGas=nUltimoMesGas;
		System.out.println("this.ultimoMesGas"+this.ultMesGas);
		int nUltimoMesBal=Integer.valueOf(ultimoMesBal).intValue();
		this.ultMesBal=nUltimoMesBal;
		System.out.println("this.ultimoMesBal"+this.ultMesBal);
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
			System.out.println("this.facturacion["+n+"] "+this.facturacion[n]);
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
			System.out.println("this.gastos["+n+"] "+this.gastos[n]);
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
			System.out.println("this.balance["+n+"] "+this.balance[n]);
			numero="";
			n=n+1;
		}		
		this.cuotaContrato=33;
	}
	
	public void facturacion(int nFacturacion)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultMesFac)
		{
			int dif;
			int [] f=new int[12];
			if(ultMesFac<mesActual)	dif=mesActual-ultMesFac;
			else	dif=ultMesFac-mesActual;
			System.out.println("ultMesFac "+ultMesFac);
			System.out.println("mesActual "+mesActual);
			System.out.println("dif "+dif);
			for(int i=11;i>=dif;i--)
			{						
				f[i]=facturacion[i-dif];
				System.out.println("f["+i+"] "+f[i]);
			}
			for(int i=(12-dif);i<12;i++)
			{				
				f[i-(12-dif)]=facturacion[i];
				System.out.println("f["+(i-(12-dif))+"] "+f[i-(12-dif)]);
			}	
			for(int i=0;i<dif;i++)
			{
				f[11-i]=0;
			}
			facturacion=f;
			ultMesFac=mesActual;
		}
		facturacion[11]=nFacturacion;
		vista.actualizaVistaFacturacion(facturacion,ultMesFac);
	}
	
	public void gastos(int [] vGastos,int nGastos)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultMesGas)
		{
			int dif;
			int [] g=new int[12];
			if(ultMesGas<mesActual)	dif=mesActual-ultMesGas;
			else	dif=ultMesGas-mesActual;
			for(int i=11;i>=dif;i--)
			{						
				g[i]=gastos[i-dif];
				System.out.println("g["+i+"] "+g[i]);
			}
			for(int i=(12-dif);i<12;i++)
			{				
				g[i-(12-dif)]=gastos[i];
				System.out.println("g["+(i-(12-dif))+"] "+g[i-(12-dif)]);
			}
			for(int i=0;i<dif;i++)
			{
				g[11-i]=0;
			}
			gastos=g;
			ultMesGas=mesActual;
		}
		gastos[11]=nGastos;
		vista.actualizaVistaGastos(gastos,ultMesGas);
		vGastos=gastos;
	}

	public void balance(int nFacturacion,int nGastos,int nBalance)
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		if (mesActual!=ultMesBal)
		{
			int difFac;
			int difGas;
			int difBal;
			int [] f=new int[12];
			int [] g=new int[12];
			int [] b=new int[12];
			if(ultMesFac<mesActual) difFac=mesActual-ultMesFac;
			else	difFac=ultMesFac-mesActual;
			if(ultMesGas<mesActual) difGas=mesActual-ultMesGas;
			else	difGas=ultMesGas-mesActual;
			if(ultMesBal<mesActual) difBal=mesActual-ultMesBal;
			else	difBal=ultMesBal-mesActual;
			for(int i=11;i>=difFac;i--)
			{						
				f[i]=facturacion[i-difFac];
				System.out.println("f["+i+"] "+f[i]);
			}
			for(int i=(12-difFac);i<12;i++)
			{				
				f[i-(12-difFac)]=facturacion[i];
				System.out.println("f["+(i-(12-difFac))+"] "+f[i-(12-difFac)]);
			}			
			for(int i=0;i<difFac;i++)
			{
				f[11-i]=0;
			}			
			for(int i=11;i>=difGas;i--)
			{		
				
				f[i]=gastos[i-difGas];
				System.out.println("g["+i+"] "+g[i]);
			}
			for(int i=(12-difGas);i<12;i++)
			{				
				f[i-(12-difGas)]=gastos[i];
				System.out.println("g["+(i-(12-difGas))+"] "+g[i-(12-difGas)]);
			}			
			for(int i=0;i<difGas;i++)
			{
				g[11-i]=0;
			}			
			for(int i=11;i>=difBal;i--)
			{		
				f[i]=balance[i-difBal];
				System.out.println("b["+i+"] "+b[i]);
			}
			for(int i=(12-difBal);i<12;i++)
			{				
				f[i-(12-difBal)]=balance[i];
				System.out.println("b["+(i-(12-difBal))+"] "+b[i-(12-difBal)]);
			}			
			for(int i=0;i<difBal;i++)
			{
				b[11-i]=0;
			}			
			facturacion=f;
			gastos=g;
			balance=b;
			ultMesFac=mesActual;
			ultMesGas=mesActual;
			ultMesBal=mesActual;
		}
		facturacion[11]=nFacturacion;
		gastos[11]=nGastos;
		balance[11]=nBalance;
		/*String sMesActual=""+mesActual;
		LinkedList datos=new LinkedList();
		datos.add(facturacion);
		datos.add(gastos);
		datos.add(balance);
		datos.add(sMesActual);
		vista.actualizaVista(3,1,datos);*/
		vista.actualizaVistaBalance(facturacion,gastos,balance,ultMesFac,ultMesGas,ultMesBal);				
	}
	
	public int dameCuotaContrato()
	{
		return cuotaContrato;
	}
}
