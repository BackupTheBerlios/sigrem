import main.Sigrem;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;

public class ClasePrincipal 
{
	private static Sigrem controlador;
	
	private static String codcontrato;
	
	private static String codcliente;
	
	private static String codmulta;
	
	private static String codrecurso;
	
	private static String codempleado;
	
	private static String ultimoMesFac;
	
	private static String ultimoMesGas;
	
	private static String ultimoMesBal;
	
	private static String facturacion;
	
	private static String gastos;
	
	private static String balance;
	
	private static void leerFicheroConfig()
	{
		try
		{	BufferedReader entrada=new BufferedReader(new FileReader("configsig.ini"));
			String cod=entrada.readLine();
			int pos=cod.indexOf('=');
			codcontrato=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			codcliente=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			codmulta=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			codrecurso=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			codempleado=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			ultimoMesFac=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			ultimoMesGas=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			ultimoMesBal=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			facturacion=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			gastos=cod.substring(pos+1);
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			balance=cod.substring(pos+1);			
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
	}
	
	public static void main(String[] args) 
	{
		System.out.println("El programa Sigrem ha comenzado");
		leerFicheroConfig();
		String[] codigos=new String[11];
		codigos[0]=codcontrato;
		codigos[1]=codcliente;
		codigos[2]=codmulta;
		codigos[3]=codrecurso;
		codigos[4]=codempleado;
		codigos[5]=ultimoMesFac;
		codigos[6]=ultimoMesGas;
		codigos[7]=ultimoMesBal;
		codigos[8]=facturacion;
		codigos[9]=gastos;
		codigos[10]=balance;
		controlador=new Sigrem(codigos);
		controlador.activa();
	}
}
