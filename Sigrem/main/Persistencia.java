package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JOptionPane;

import mec.*;
import med.EstructuraDatos;
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
		//this.cargarXML();				
	}
	
	public void almacenarXML(){
		almacenarClientesXML();
		almacenarContratosXML();
		almacenarMultasXML();
		almacenarRecursosXML();
	}
	
	public void cargarXML(){
		try {
			cargarClientesXML();
			System.out.println("La carga de clientes se ha realizado correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cargarContratosXML();	
			System.out.println("La carga de contratos se ha realizado correctamente");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			cargarMultasXML();
			System.out.println("La carga de multas se ha realizado correctamente");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {	
			cargarRecursosXML();
			System.out.println("La carga de recursos se ha realizado correctamente");
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	public void almacenarClientesXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("clientes.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			escritor.println("<!DOCTYPE listaClientes>");
			EstructuraDatos clientes=gclientes.dameListaClientes();
			escritor.println("<listaClientes>");
			String tab="\t";
			escritor.println(tab+"<activos>");
			Vector clientesActivos=clientes.dameIndice(0).dameElementos();
			tab=tab.concat("\t");
			for(int i=0;i<clientesActivos.size();i++){
				Cliente clienteActual=(Cliente)clientesActivos.get(i);
				escribirCliente(escritor,clienteActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</activos>");
			escritor.println(tab+"<eliminados>");
			Vector clientesEliminados=clientes.dameEliminados();
			tab=tab.concat("\t");
			for(int i=0;i<clientesEliminados.size();i++){
				Cliente clienteActual=(Cliente)clientesEliminados.get(i);
				escribirCliente(escritor,clienteActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</eliminados>");
			escritor.println("</listaClientes>");
			escritor.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	void escribirCliente(PrintWriter escritor, Cliente actual, String tab){
		escritor.println(tab+"<cliente>");
		tab=tab.concat("\t");
		escritor.println(tab+"<codigo>"+actual.dameCodigo()+"</codigo>");
		escritor.println(tab+"<nombre>"+actual.dameNombre()+"</nombre>");
		escritor.println(tab+"<dni>"+actual.dameDni()+"</dni>");
		escritor.println(tab+"<direccion>"+actual.dameDireccion()+"</direccion>");
		escritor.println(tab+"<cp>"+actual.dameCp()+"</cp>");
		escritor.println(tab+"<poblacion>"+actual.damePoblacion()+"</poblacion>");
		escritor.println(tab+"<provincia>"+actual.dameProvincia()+"</provincia>");
		escritor.println(tab+"<telefono1>"+actual.dameTelefono1()+"</telefono1>");
		escritor.println(tab+"<telefono2>"+actual.dameTelefono2()+"</telefono2>");
		escritor.println(tab+"<movil>"+actual.dameMovil()+"</movil>");
		escritor.println(tab+"<email>"+actual.dameEmail()+"</email>");
		escritor.println(tab+"<fax>"+actual.dameFax()+"</fax>");
		escritor.println(tab+"<listacodigoscontratos>");
		LinkedList codigoscontratos=actual.dameListaContratos();
		tab=tab.concat("\t");
		for (int i=0;i<codigoscontratos.size();i++){
	 		escritor.println(tab+"<codigocontrato>"+(String) codigoscontratos.get(i)+"</codigocontrato>");
	 	}
		tab=tab.substring(1);
		escritor.println(tab+"</listacodigoscontratos>");
		tab=tab.substring(1);
		escritor.println(tab+"</cliente>");
	}
	 
	 public boolean cargarClientesXML() throws IOException{
		BufferedReader lector=new BufferedReader(new FileReader("clientes.xml"));
		String lineaActual;
		lineaActual=lector.readLine();
		if (!lineaActual.equals("<¿xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
			System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.equals("<!DOCTYPE listaClientes>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.equals("<listaClientes>")){
					System.out.println("No hay etiqueta listaClientes");
				}else{
					lineaActual=lector.readLine();
					if (!lineaActual.equals("</tactivos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.equals("<//activos>")){
							LinkedList datosCliente=leerCliente(lineaActual,lector);
							Vector contratosAsociados=(Vector)datosCliente.removeLast();
							gclientes.añadirCliente(datosCliente);
							for (int i=0;i<contratosAsociados.size();i++){
								gclientes.asociaClienteContrato((String)datosCliente.getFirst(),(String)contratosAsociados.get(i));
							}
							lineaActual=lector.readLine();
						}
						if (!lineaActual.equals("</teliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.equals("<//eliminados>")){
								LinkedList datosCliente=leerCliente(lineaActual,lector);
								Vector contratosAsociados=(Vector)datosCliente.removeLast();
								gclientes.añadirCliente(datosCliente);
								for (int i=0;i<contratosAsociados.size();i++){
									gclientes.asociaClienteContrato((String)datosCliente.getFirst(),(String)contratosAsociados.get(i));
								}
								//gclientes.eliminarCliente(false,datosCliente.g)
								//falta eliminar los clientes eliminados, se podría hacer en casacada eliminando exclusivamente los contratos
								lineaActual=lector.readLine();				
							}
							lineaActual=lector.readLine();
							if (!lineaActual.equals("<//listaClientes>")){
								System.out.println("No hay cierre de etiqueta listaClientes");
							}else{
								lineaActual=lector.readLine();
								//devuelve null cuando esta vacio? o salta excepcion?
								if (lineaActual!=null){
									System.out.println("Existen datos al final del archivo");
								}else{
									return true;
								}
							}
						}
						
					}
				}
			}
		}
	 	return false;		
		
	}
 
	LinkedList leerCliente(String linea, BufferedReader lector) throws IOException{
		if (!linea.equals("/t/t<cliente>")){
			System.out.println("No se ha encontado un cliente");
		}else{
			LinkedList datosCliente=new LinkedList();
			int inicio;
			int fin;
			//cuidado con los limites!!!
			//que pasa cuando no se encuentran???
			
			inicio=linea.lastIndexOf("/t/t/t<codigo>");
			fin=linea.indexOf("<//codigo>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<nombre>");
			fin=linea.indexOf("<//nombre>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<dni>");
			fin=linea.indexOf("<//dni>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<direccion>");
			fin=linea.indexOf("<//direccion>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<cp>");
			fin=linea.indexOf("<//cp>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<poblacion>");
			fin=linea.indexOf("<//poblacion")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<provincia>");
			fin=linea.indexOf("<//provincia>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<telefono1>");
			fin=linea.indexOf("<//telefono1>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<telefono2>");
			fin=linea.indexOf("<//telefono2>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<movil>");
			fin=linea.indexOf("<//movil")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<email>");
			fin=linea.indexOf("<//email>")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
			
			inicio=linea.lastIndexOf("/t/t/t<fax>");
			fin=linea.indexOf("<//fax")-1;
			datosCliente.add(linea.substring(inicio,fin));	
			linea=lector.readLine();
				
			if (!linea.equals("/t/t/t<listacodigoscontratos>")){
				System.out.println("No se ha encontado la lista de contratos del cliente");
			}else{
				Vector listaCodigosContrato=new Vector();
				linea=lector.readLine();
				while (!linea.equals("<//listacodigoscontratos>")){
					inicio=linea.lastIndexOf("/t/t/t/t<codigocontrato>");
					fin=linea.indexOf("<//codigocontrato>")-1;
					listaCodigosContrato.add(linea.substring(inicio,fin));	
					linea=lector.readLine();
				}
				datosCliente.add(listaCodigosContrato);
				linea=lector.readLine();
				if (!linea.equals("/t/t<clientes>")){
					System.out.println("No se ha encontado la etiqueta que cierra cliente");
				}else{
					return datosCliente;
				}
			}
		}
		return null;	
		
	}
	
	public void almacenarContratosXML(){}
	void escribirContrato(PrintWriter escritor, Cliente actual){}
	public boolean cargarContratosXML() throws IOException{
		return true;
	}
	LinkedList leerContrato(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
	public void almacenarMultasXML(){}
	void escribirMulta(PrintWriter escritor, Multa actual){}
	public boolean cargarMultasXML() throws IOException{	
		return true;
	}
	LinkedList leerMulta(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
	public void almacenarRecursosXML(){}
	void escribirRecurso(PrintWriter escritor, Recurso actual){}
	public boolean cargarRecursosXML() throws IOException{
		return true;
	}
	LinkedList leerRecurso(String linea, BufferedReader lector) throws IOException{
		return null;
	}
	
	
	// Persistencia del Historial Económico
	public LinkedList dameHistorial()
	{
		return cargarHistorial();
	}
	
	public void almacenarHistorial()
	{
		
	}
	
	public LinkedList cargarHistorial()
	{
		LinkedList historial=new LinkedList();
		try
		{
			BufferedReader entrada=new BufferedReader(new FileReader("confighis.ini"));
			String cod=entrada.readLine();
			int pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			historial.add(cod.substring(pos+1));
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de historial","Sigrem",-1);
			System.out.println(ex);
		}
		return historial;
	}
	
	// Persistencia del Fichero de Configuración inicial
	public LinkedList dameConfigIni()
	{
		return cargarConfigIni();
	}
	
	public void almacenarConfigIni()
	{
		
	}
	
	public LinkedList cargarConfigIni()
	{
		LinkedList configIni=new LinkedList();
		try
		{
			BufferedReader entrada=new BufferedReader(new FileReader("configsig.ini"));
			String cod=entrada.readLine();
			int pos=cod.indexOf('=');
			configIni.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			configIni.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			configIni.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			configIni.add(cod.substring(pos+1));
			cod=entrada.readLine();
			pos=cod.indexOf('=');
			configIni.add(cod.substring(pos+1));
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar el fichero de configuración","Sigrem",-1);
			System.out.println(ex);
		}
		return configIni;
	}

		
}
