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
	}
	
	public void almacenaClientesXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("clientes.txt")));
			escritor.println("<xml version=\"1.0\" encoding=\"UTF-8 standalone=\"yes\">");
			escritor.println("<!DOCTYPE listaClientes>");
			EstructuraDatos clientes=gclientes.dameListaClientes();
			escritor.println("<listaClientes>");
			escritor.println("</tactivos>");
			Vector clientesActivos=clientes.dameIndice(0).dameElementos();
			for(int i=0;i<clientesActivos.size();i++){
				Cliente clienteActual=(Cliente)clientesActivos.get(i);
				escribirCliente(escritor,clienteActual);
			}
			escritor.println("<//activos>");
			escritor.println("</teliminados>");
			Vector clientesEliminados=clientes.dameEliminados();
			for(int i=0;i<clientesEliminados.size();i++){
				Cliente clienteActual=(Cliente)clientesEliminados.get(i);
				escribirCliente(escritor,clienteActual);
			}
			escritor.println("<//eliminados>");
			escritor.println("<//listaClientes>");
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	void escribirCliente(PrintWriter escritor, Cliente actual){
		escritor.println("/t/t<cliente>");
		escritor.println("/t/t/t<codigo>"+actual.dameCodigo()+"<//codigo>");
		escritor.println("/t/t/t<nombre>"+actual.dameNombre()+"<//nombre>");
		escritor.println("/t/t/t<dni>"+actual.dameDni()+"<//dni>");
		escritor.println("/t/t/t<direccion>"+actual.dameDireccion()+"<//direccion>");
		escritor.println("/t/t/t<cp>"+actual.dameCp()+"<//cp>");
		escritor.println("/t/t/t<poblacion"+actual.damePoblacion()+"<//poblacion>");
		escritor.println("/t/t/t<provincia>"+actual.dameProvincia()+"<//provincia>");
		escritor.println("/t/t/t<telefono1>"+actual.dameCodigo()+"<//telefono1>");
		escritor.println("/t/t/t<telefono2>"+actual.dameNombre()+"<//telefono2>");
		escritor.println("/t/t/t<movil>"+actual.dameDni()+"<//movil>");
		escritor.println("/t/t/t<email>"+actual.dameDireccion()+"<//email>");
		escritor.println("/t/t/t<fax>"+actual.dameCp()+"<//fax>");
		escritor.println("/t/t/t<listacodigoscontratos>");
		LinkedList codigoscontratos=actual.dameListaContratos();
		for (int i=0;i<codigoscontratos.size();i++){
	 		escritor.println("/t/t/t/t<codigocontrato>"+(String) codigoscontratos.get(i)+"<//codigocontrato>");
	 	}
		escritor.println("/t/t/t<//listacodigoscontratos>");
		
		escritor.println("/t/t<//cliente>");
	
	 }
	 
	 public boolean cargarClientesXML() throws IOException{
		BufferedReader lector=new BufferedReader(new FileReader("clientes.txt"));
		String lineaActual;
		lineaActual=lector.readLine();
		if (!lineaActual.equals("<xml version=\"1.0\" encoding=\"UTF-8 standalone=\"yes\">")){
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
	
	public void almacenaContratosXML(){}
	void escribirContrato(PrintWriter escritor, Cliente actual){}
	public boolean cargarContratosXML() throws IOException{
		return true;
	}
	LinkedList leerContrato(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
	public void almacenaMultasXML(){}
	void escribirMulta(PrintWriter escritor, Multa actual){}
	public boolean cargarMultasXML() throws IOException{	
		return true;
	}
	LinkedList leerMulta(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
	public void almacenaRecursosXML(){}
	void escribirRecurso(PrintWriter escritor, Recurso actual){}
	public boolean cargarRecursosXML() throws IOException{
		return true;
	}
	LinkedList leerRecurso(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
}
