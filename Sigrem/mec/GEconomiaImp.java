package mec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
	
	public int [] dameVectorFacturacion() 
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		int j=mesActual;
		int [] vFac=null;
		try
		{
			BufferedReader entrada=new BufferedReader(new FileReader("configsig.ini"));
			String linea=entrada.readLine();
			char c=linea.charAt(0);
			while(c!='f')
			{
				linea=entrada.readLine();
				c=linea.charAt(0);				
			}
			for (int k=0;k<12;k++)
			{
				int pos=linea.indexOf('=');
				String fac=linea.substring(pos+1);
				Character car = null;
				int nFac = car.digit(fac.charAt(0), 10);
				for (int i=4;i<fac.length(); i++)
				{
					nFac = (nFac*10)+car.digit(fac.charAt(i), 10);
				}		
				if (j==11)	j=0;
				else	j=j+1;
				vFac[k]=nFac;				
			}
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
		return vFac;
	}
	
	public int [] dameVectorGastos() 
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		int j=mesActual;
		int [] vGas=null;
		try
		{
			BufferedReader entrada=new BufferedReader(new FileReader("configsig.ini"));
			String linea=entrada.readLine();
			char c=linea.charAt(0);
			while(c!='f')
			{
				linea=entrada.readLine();
				c=linea.charAt(0);				
			}
			for (int k=0;k<12;k++)
			{
				int pos=linea.indexOf('=');
				String gas=linea.substring(pos+1);
				Character car = null;
				int nGas = car.digit(gas.charAt(0), 10);
				for (int i=4;i<gas.length(); i++)
				{
					nGas = (nGas*10)+car.digit(gas.charAt(i), 10);
				}		
				if (j==11)	j=0;
				else	j=j+1;
				vGas[k]=nGas;				
			}
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
		return vGas;
	}
	
	public int [] dameVectorBalance() 
	{
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		int j=mesActual;
		int [] vBal=null;
		try
		{
			BufferedReader entrada=new BufferedReader(new FileReader("configsig.ini"));
			String linea=entrada.readLine();
			char c=linea.charAt(0);
			while(c!='f')
			{
				linea=entrada.readLine();
				c=linea.charAt(0);				
			}
			for (int k=0;k<12;k++)
			{
				int pos=linea.indexOf('=');
				String bal=linea.substring(pos+1);
				Character car = null;
				int nBal = car.digit(bal.charAt(0), 10);
				for (int i=4;i<bal.length(); i++)
				{
					nBal = (nBal*10)+car.digit(bal.charAt(i), 10);
				}		
				if (j==11)	j=0;
				else	j=j+1;
				vBal[k]=nBal;				
			}
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
		return vBal;
	}
	
	public String [] dameVectorMeses() 
	{
		String [] meses={"ENE","FEB","MAR","ABR","MAY","JUN","JUL","AGO","SEP","OCT","NOV","DIC"};
		Calendar hoy=Calendar.getInstance();
		int mesActual=hoy.get(Calendar.MONTH);
		int j=mesActual;
		String [] vMes=null;
		for (int i=0;i<12;i++)
		{
			if (j==11)	j=0;
			else	j=j+1;
			vMes[i]=meses[j];				
		}
		return vMes;
	}
	
	public GEconomiaImp(InterfazGrafica vista,GEmpleados gempleados,GContratos gcontratos)
	{
		this.vista=vista;
		this.gempleados=gempleados;
		this.gcontratos=gcontratos;
		this.cuotaContrato=33;
	}

	
	
	public void gastos()
	{
		int nEmp=gempleados.dameListaEmpleados().dameTamaño();
		int gas=nEmp*cuotaContrato;
		/*try
		{
			PrintWriter ficheroSal=new PrintWriter(new BufferedWriter(new FileWriter("configsig.ini")));
			ficheroSal.println("-"+gas);
			ficheroSal.close();
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
		*/
		//para cada empleado mirar su nomina
		//sumar todas las nominas		
	}

	public void facturacion()
	{
		//gcontratos.dameListaContratos();
		//en funcion de las mulras y los recursos de cada contrato se cancula su valor
		//sumar todos los valores de los contratos
	}
	
	public void balance()
	{
		//facturacion-gastos
	}
}
