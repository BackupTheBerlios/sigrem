package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
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
	
	String dameInteriorEtiquetas(String tab, String linea, String etiqueta1, String etiqueta2){
		String interior=null;
		if (!linea.startsWith(tab+etiqueta1)){
			System.out.println("La linea no empieza por el tabulador y esa etiqueta: "+tab+etiqueta1);
		}else{
			int numeroPrincipio=etiqueta1.length()+tab.length();
			int numeroFin=linea.indexOf(etiqueta2);
			if (numeroFin==-1){
				System.out.println("La linea no tiene cierre de etiqueta: "+etiqueta2);
			}else{
				if (!linea.endsWith(etiqueta2)){
					System.out.println("Existen datos despues de la etiqueta: "+etiqueta2);
				}
				interior=linea.substring(numeroPrincipio,numeroFin);
			}
		}
		return interior;
	}
	
	
	public Persistencia(GContratos cont,GClientes cli,GEmpleados emp,GMultas mul,GRecursos rec,GEconomia eco){
		gcontratos=cont;
		gclientes=cli;
		gmultas=mul;
		grecursos=rec;
		gempleados=emp;
		geconomia=eco;
		if (!cargarXML()){
			System.out.println("La carga de XML no ha sido correcta");				
		}else{
			System.out.println("Iniciando......");
		}
	}
	
	public void almacenarXML(){
		almacenarClientesXML();
		almacenarContratosXML();
		almacenarMultasXML();
		almacenarRecursosXML();
		almacenarEmpleadosXML();
			
	}
	
	public boolean cargarXML(){
		boolean bienCargado=true;
		boolean iniciando=true;
		try {
			cargarClientesXML();
			iniciando=false;
			System.out.println("La carga de clientes se ha realizado correctamente");
		} catch (FileNotFoundException e1){
			System.out.println("No existe el archivo clientes.txt");		
		}catch (IOException e0) {
			System.out.println("Algun dato de gclientes es erroneo IOException e0");	
			bienCargado=false;
		}
		try {
			cargarContratosXML();	
			iniciando=false;
			System.out.println("La carga de contratos se ha realizado correctamente");
		} catch (FileNotFoundException e1){
			System.out.println("No existe el archivo contratos.txt");
		} catch (IOException e1) {
			System.out.println("Algun dato de gcontratos es erroneo");
			bienCargado=false;
		}
		try {
			cargarMultasXML();	
			iniciando=false;
			System.out.println("La carga de multas se ha realizado correctamente");
		} catch (FileNotFoundException e1){
			System.out.println("No existe el archivo multas.txt");
		} catch (IOException e1) {
			System.out.println("Algun dato de gmultas es erroneo");
			bienCargado=false;
		}try {
			cargarRecursosXML();	
			iniciando=false;
			System.out.println("La carga de recursos se ha realizado correctamente");
		} catch (FileNotFoundException e1){
			System.out.println("No existe el archivo recursos.txt");
		} catch (IOException e1) {
			System.out.println("Algun dato de grecursos es erroneo");
			bienCargado=false;
		}try {
			cargarEmpleadosXML();	
			iniciando=false;
			System.out.println("La carga de empleados se ha realizado correctamente");
		} catch (FileNotFoundException e1){
			System.out.println("No existe el archivo empleados.txt");
		} catch (IOException e1) {
			System.out.println("Algun dato de gempleados es erroneo");
			bienCargado=false;
		}
		if (iniciando){
			System.out.println("No existen los archivos de datos,se creara una estructura nueva");
		}
		return bienCargado;
	}
	
	
	public void almacenarClientesXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("clientes.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			//System.out.println("Primera linea del archivo XML creada");
			escritor.println("<!DOCTYPE listaClientes>");
			EstructuraDatos clientes=gclientes.dameEstructuraClientes();
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
		String tab="";
		lineaActual=lector.readLine();
		if (!lineaActual.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
			System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.startsWith("<!DOCTYPE listaClientes>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.startsWith("<listaClientes>")){
					System.out.println("No hay etiqueta listaClientes");
				}else{
					tab=tab.concat("\t");
					lineaActual=lector.readLine();
					if (!lineaActual.startsWith(tab+"<activos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.startsWith(tab+"</activos>")){
							tab=tab.concat("\t");
							LinkedList datosCliente=leerCliente(lineaActual,lector,tab);
							//sacamos los contratos y el codigo de ese cliente de la LinkedList 
							Vector contratosAsociados=(Vector)datosCliente.removeLast();
							String codigoCliente=(String)datosCliente.removeFirst();
							Cliente nuevoCliente=new Cliente(codigoCliente,datosCliente);
							gclientes.meteCliente(nuevoCliente);
							for (int i=0;i<contratosAsociados.size();i++){
								gclientes.asociaClienteContrato(false,codigoCliente,(String)contratosAsociados.get(i));
							}
							lineaActual=lector.readLine();
							tab=tab.substring(1);
						}
						lineaActual=lector.readLine();
						if (!lineaActual.startsWith(tab+"<eliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.startsWith(tab+"</eliminados>")){
								tab=tab.concat("\t");
								LinkedList datosCliente=leerCliente(lineaActual,lector,tab);
								Vector contratosAsociados=(Vector)datosCliente.removeLast();
								String codigoCliente=(String)datosCliente.removeFirst();
								Cliente nuevoCliente=new Cliente(codigoCliente,datosCliente);
								gclientes.dameEstructuraClientes().insertarAEliminados(nuevoCliente);
								lineaActual=lector.readLine();
								tab=tab.substring(1);
							}
							lineaActual=lector.readLine();
							if (!lineaActual.startsWith("</listaClientes>")){
								System.out.println("No hay cierre de etiqueta listaClientes");
							}else{
								lineaActual=lector.readLine();
								if(lineaActual!=null){
									System.out.println("Existen datos despues de la ultima etiqueta </listaClientes>");
								}else return true;
							/*catch (IOException e) {
									return true;	
								}*/
							}
						}
						
					}
				}
			}
		}
	 	return false;		
		
	}
 
	LinkedList leerCliente(String linea, BufferedReader lector,String tab) throws IOException{
		if (!linea.equals(tab+"<cliente>")){
			System.out.println("No se ha encontado un cliente");
		}else{
			LinkedList datosCliente=new LinkedList();
			String principio;
			String fin;
			String interior;
			
			tab=tab.concat("\t");
			linea=lector.readLine();
			
			principio="<codigo>";
			fin ="</codigo>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<nombre>";
			fin ="</nombre>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<dni>";
			fin ="</dni>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			
			principio="<direccion>";
			fin ="</direccion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<cp>";
			fin ="</cp>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<poblacion>";
			fin ="</poblacion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<provincia>";
			fin ="</provincia>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<telefono1>";
			fin ="</telefono1>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<telefono2>";
			fin ="</telefono2>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<movil>";
			fin ="</movil>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<email>";
			fin ="</email>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
			
			principio="<fax>";
			fin ="</fax>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosCliente.add(interior);	
			linea=lector.readLine();
				
			if (linea.indexOf(tab+"<listacodigoscontratos>")!=0){
				System.out.println("No se ha encontado la lista de contratos del cliente");
			}else{
				Vector listaCodigosContrato=new Vector();
				linea=lector.readLine();
				while (linea.indexOf(tab+"</listacodigoscontratos>")!=0){
					tab=tab.concat("\t");
					principio="<codigocontrato>";
					fin ="</codigocontrato>";
					interior=dameInteriorEtiquetas(tab,linea,principio,fin);
					listaCodigosContrato.add(interior);	
					linea=lector.readLine();
					tab=tab.substring(1);
				}
				datosCliente.add(listaCodigosContrato);
				linea=lector.readLine();
				tab=tab.substring(1);
				if (!linea.equals(tab+"</cliente>")){
					System.out.println("No se ha encontrado la etiqueta que cierra cliente");
				}else{
					return datosCliente;
				}
			}
		}
		return null;	
		
	}
	
	public void almacenarContratosXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("contratos.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			escritor.println("<!DOCTYPE listaContratos>");
			EstructuraDatos contratos=gcontratos.dameEstructuraContratos();
			escritor.println("<listaContratos>");
			String tab="\t";
			escritor.println(tab+"<activos>");
			Vector contratosActivos=contratos.dameIndice(0).dameElementos();
			tab=tab.concat("\t");
			for(int i=0;i<contratosActivos.size();i++){
				Contrato contratoActual=(Contrato)contratosActivos.get(i);
				escribirContrato(escritor,contratoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</activos>");
			escritor.println(tab+"<eliminados>");
			Vector contratosEliminados=contratos.dameEliminados();
			tab=tab.concat("\t");
			for(int i=0;i<contratosEliminados.size();i++){
				Contrato contratoActual=(Contrato)contratosEliminados.get(i);
				escribirContrato(escritor,contratoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</eliminados>");
			escritor.println("</listaContratos>");
			escritor.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	void escribirContrato(PrintWriter escritor, Contrato actual,String tab){
		escritor.println(tab+"<contrato>");
		tab=tab.concat("\t");
		escritor.println(tab+"<codigo>"+actual.dameCodigoContrato()+"</codigo>");
		escritor.println(tab+"<codigocliente>"+actual.dameCodigoCliente()+"</codigocliente>");
		escritor.println(tab+"<matricula>"+actual.dameMatricula()+"</matricula>");
		escritor.println(tab+"<fechaAlta>"+actual.dameFechaAlta()+"</fechaAlta>");
		escritor.println(tab+"<fechaBaja>"+actual.dameFechaBaja()+"</fechaBaja>");
		escritor.println(tab+"<listacodigosmultas>");
		LinkedList codigosmultas=actual.dameListaMultas();
		tab=tab.concat("\t");
		for (int i=0;i<codigosmultas.size();i++){
	 		escritor.println(tab+"<codigomulta>"+(String) codigosmultas.get(i)+"</codigomulta>");
	 	}
		tab=tab.substring(1);
		escritor.println(tab+"</listacodigosmultas>");
		tab=tab.substring(1);
		escritor.println(tab+"</contrato>");
	}
	
	public boolean cargarContratosXML() throws IOException{
		BufferedReader lector=new BufferedReader(new FileReader("contratos.xml"));
		String lineaActual;
		String tab="";
		lineaActual=lector.readLine();
		if (!lineaActual.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
		System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.startsWith("<!DOCTYPE listaContratos>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.startsWith("<listaContratos>")){
					System.out.println("No hay etiqueta listaContratos");
				}else{
					tab=tab.concat("\t");
					lineaActual=lector.readLine();
					if (!lineaActual.startsWith(tab+"<activos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.startsWith(tab+"</activos>")){
							tab=tab.concat("\t");
							LinkedList datosContrato=leerContrato(lineaActual,lector,tab);
							//sacamos los contratos y el codigo de ese cliente de la LinkedList 
							Vector multasAsociados=(Vector)datosContrato.removeLast();
							String codigoContrato=(String)datosContrato.removeFirst();
							Contrato nuevoContrato=new Contrato(codigoContrato,datosContrato);
							gcontratos.meteContrato(nuevoContrato);
							for (int i=0;i<multasAsociados.size();i++){
								gcontratos.asociaContratoMulta(codigoContrato,(String)multasAsociados.get(i));
							}
							lineaActual=lector.readLine();
							tab=tab.substring(1);
						}
						lineaActual=lector.readLine();
						if (!lineaActual.startsWith(tab+"<eliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.startsWith(tab+"</eliminados>")){
								tab=tab.concat("\t");
								LinkedList datosContrato=leerContrato(lineaActual,lector,tab);
								Vector multasAsociados=(Vector)datosContrato.removeLast();
								String codigoContrato=(String)datosContrato.removeFirst();
								Contrato nuevoContrato=new Contrato(codigoContrato,datosContrato);
								gcontratos.dameEstructuraContratos().insertarAEliminados(nuevoContrato);
								lineaActual=lector.readLine();
								tab=tab.substring(1);
							}
							tab=tab.substring(1);
							lineaActual=lector.readLine();
							if (!lineaActual.startsWith("</listaContratos>")){
								System.out.println("No hay cierre de etiqueta listaContratos");
							}else{
								lineaActual=lector.readLine();
								if(lineaActual!=null){
									System.out.println("Existen datos despues de la ultima etiqueta </listaContratos>" );
								}else return true;
						/*catch (IOException e) {
								return true;	
							}*/
							}
						}
					
					}
				}
			}
		}	
		return false;		
	}
	
	LinkedList leerContrato(String linea, BufferedReader lector, String tab) throws IOException{
		if (!linea.equals(tab+"<contrato>")){
			System.out.println("No se ha encontado un contrato");
		}else{
			LinkedList datosContrato=new LinkedList();
			String principio;
			String fin;
			String interior;
			
			tab=tab.concat("\t");
			linea=lector.readLine();
			
			principio="<codigo>";
			fin ="</codigo>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosContrato.add(interior);	
			linea=lector.readLine();
			
			principio="<codigocliente>";
			fin ="</codigocliente>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosContrato.add(interior);	
			linea=lector.readLine();
			
			principio="<matricula>";
			fin ="</matricula>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosContrato.add(interior);	
			linea=lector.readLine();
			
			principio="<fechaAlta>";
			fin ="</fechaAlta>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosContrato.add(interior);	
			linea=lector.readLine();
			
			
			principio="<fechaBaja>";
			fin ="</fechaBaja>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosContrato.add(interior);	
			linea=lector.readLine();
						
			if (linea.indexOf(tab+"<listacodigosmultas>")!=0){
				System.out.println("No se ha encontado la lista de codigos de multa");
			}else{
				Vector listaCodigosMultas=new Vector();
				linea=lector.readLine();
				while (linea.indexOf(tab+"</listacodigosmultas>")!=0){
					tab=tab.concat("\t");
					principio="<codigomulta>";
					fin ="</codigomulta>";
					interior=dameInteriorEtiquetas(tab,linea,principio,fin);
					listaCodigosMultas.add(interior);	
					linea=lector.readLine();
					tab=tab.substring(1);
				}
				datosContrato.add(listaCodigosMultas);
				linea=lector.readLine();
				tab=tab.substring(1);
				if (!linea.equals(tab+"</contrato>")){
					System.out.println("No se ha encontrado la etiqueta que cierra contrato");
				}else{
					return datosContrato;
				}
			}
		}
		return null;	
	}
		
	public void almacenarMultasXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("multas.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			escritor.println("<!DOCTYPE listaMultas>");
			EstructuraDatos multas=gmultas.dameEstructuraMultas();
			escritor.println("<listaMultas>");
			String tab="\t";
			escritor.println(tab+"<activos>");
			Vector multasActivos=multas.dameIndice(0).dameElementos();
			tab=tab.concat("\t");
			for(int i=0;i<multasActivos.size();i++){
				Multa multaActual=(Multa)multasActivos.get(i);
				escribirMulta(escritor,multaActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</activos>");
			escritor.println(tab+"<eliminados>");
			Vector multasEliminados=multas.dameEliminados();
			tab=tab.concat("\t");
			for(int i=0;i<multasEliminados.size();i++){
				Multa multaActual=(Multa)multasEliminados.get(i);
				escribirMulta(escritor,multaActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</eliminados>");
			escritor.println("</listaMultas>");
			escritor.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	void escribirMulta(PrintWriter escritor, Multa actual,String tab){
		escritor.println(tab+"<multa>");
		tab=tab.concat("\t");		
		escritor.println(tab+"<codigo>"+actual.dameCodigoMulta()+"</codigo>");
		escritor.println(tab+"<expediente>"+actual.dameExpediente()+"</expediente>");
		escritor.println(tab+"<boletin>"+actual.dameBoletin()+"</boletin>");
		escritor.println(tab+"<fechaDenuncia>"+actual.dameFechaDenuncia()+"</fechaDenuncia>");
		escritor.println(tab+"<infraccion>"+actual.dameInfraccion()+"</infraccion>");
		escritor.println(tab+"<descripcion>"+actual.dameDescripcion()+"</descripcion>");
		escritor.println(tab+"<codigoContrato>"+actual.dameCodigoContrato()+"</codigoContrato>");
			
		
		escritor.println(tab+"<listacodigosrecursos>");
		LinkedList codigosrecursos=actual.dameListaRecursos();
		tab=tab.concat("\t");
		for (int i=0;i<codigosrecursos.size();i++){
	 		escritor.println(tab+"<codigorecurso>"+(String) codigosrecursos.get(i)+"</codigorecurso>");
	 	}
		tab=tab.substring(1);
		escritor.println(tab+"</listacodigosrecursos>");
		tab=tab.substring(1);
		escritor.println(tab+"</multa>");
		}
	
	public boolean cargarMultasXML() throws IOException{	
		BufferedReader lector=new BufferedReader(new FileReader("multas.xml"));
		String lineaActual;
		String tab="";
		lineaActual=lector.readLine();
		if (!lineaActual.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
		System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.startsWith("<!DOCTYPE listaMultas>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.startsWith("<listaMultas>")){
					System.out.println("No hay etiqueta listaMultas");
				}else{
					tab=tab.concat("\t");
					lineaActual=lector.readLine();
					if (!lineaActual.startsWith(tab+"<activos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.startsWith(tab+"</activos>")){
							tab=tab.concat("\t");
							LinkedList datosMulta=leerMulta(lineaActual,lector,tab);
							//sacamos los contratos y el codigo de ese cliente de la LinkedList 
							Vector recursosAsociados=(Vector)datosMulta.removeLast();
							String codigoMulta=(String)datosMulta.removeFirst();
							Multa nuevoMulta=new Multa(codigoMulta,datosMulta);
							gmultas.meteMulta(nuevoMulta);
							tab=tab.concat("\t");
							for (int i=0;i<recursosAsociados.size();i++){
								gmultas.asociaMultaRecurso(codigoMulta,(String)recursosAsociados.get(i));
							}
							tab=tab.substring(1);
							lineaActual=lector.readLine();
							tab=tab.substring(1);
						}
						lineaActual=lector.readLine();
						if (!lineaActual.startsWith(tab+"<eliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.startsWith(tab+"</eliminados>")){
								tab=tab.concat("\t");
								
								LinkedList datosMulta=leerMulta(lineaActual,lector,tab);
								Vector recursosAsociados=(Vector)datosMulta.removeLast();
								String codigoMulta=(String)datosMulta.removeFirst();
								Multa nuevoMulta=new Multa(codigoMulta,datosMulta);
								gmultas.dameEstructuraMultas().insertarAEliminados(nuevoMulta);
						
								lineaActual=lector.readLine();
								tab=tab.substring(1);
							}
							tab=tab.substring(1);
							lineaActual=lector.readLine();
							if (!lineaActual.startsWith("</listaMultas>")){
								System.out.println("No hay cierre de etiqueta listaMultas");
							}else{
								lineaActual=lector.readLine();
								if(lineaActual!=null){
									System.out.println("Existen datos despues de la ultima etiqueta </listaMultas>" );
								}else return true;
						/*catch (IOException e) {
								return true;	
							}*/
							}
						}
					
					}
				}
			}
		}	
		return false;		
	}
	public LinkedList leerMulta(String linea, BufferedReader lector, String tab) throws IOException{
		if (!linea.equals(tab+"<multa>")){
			System.out.println("No se ha encontado una multa");
		}else{
			LinkedList datosMulta=new LinkedList();
			String principio;
			String fin;
			String interior;
			
			tab=tab.concat("\t");
			linea=lector.readLine();
			
			principio="<codigo>";
			fin ="</codigo>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
					
			principio="<expediente>";
			fin ="</expediente>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
			
			principio="<boletin>";
			fin ="</boletin>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
				
			principio="<fechaDenuncia>";
			fin ="</fechaDenuncia>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
						
			principio="<infraccion>";
			fin ="</infraccion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
			
			principio="<descripcion>";
			fin ="</descripcion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
			
			principio="<codigoContrato>";
			fin ="</codigoContrato>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosMulta.add(interior);	
			linea=lector.readLine();
			
			
			if (linea.indexOf(tab+"<listacodigosrecursos>")!=0){
				System.out.println("No se ha encontado la lista de codigos de los recursos");
			}else{
				Vector listaCodigosRecursos=new Vector();
				linea=lector.readLine();
				while (linea.indexOf(tab+"</listacodigosrecursos>")!=0){
					tab=tab.concat("\t");
					principio="<codigorecurso>";
					fin ="</codigorecurso>";
					interior=dameInteriorEtiquetas(tab,linea,principio,fin);
					listaCodigosRecursos.add(interior);	
					linea=lector.readLine();
					tab=tab.substring(1);
				}
				datosMulta.add(listaCodigosRecursos);
				linea=lector.readLine();
				tab=tab.substring(1);
				if (!linea.equals(tab+"</multa>")){
					System.out.println("No se ha encontrado la etiqueta que cierra multa");
				}else{
					return datosMulta;
				}
			}
		}
		return null;	
	}
		
	public void almacenarRecursosXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("recursos.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			escritor.println("<!DOCTYPE listaRecursos>");
			EstructuraDatos recursos=grecursos.dameEstructuraRecursos();
			escritor.println("<listaRecursos>");
			String tab="\t";
			escritor.println(tab+"<activos>");
			Vector recursosActivos=recursos.dameIndice(0).dameElementos();
			tab=tab.concat("\t");
			for(int i=0;i<recursosActivos.size();i++){
				Recurso recursoActual=(Recurso)recursosActivos.get(i);
				escribirRecurso(escritor,recursoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</activos>");
			escritor.println(tab+"<eliminados>");
			Vector recursosEliminados=recursos.dameEliminados();
			tab=tab.concat("\t");
			for(int i=0;i<recursosEliminados.size();i++){
				Recurso recursoActual=(Recurso)recursosEliminados.get(i);
				escribirRecurso(escritor,recursoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</eliminados>");
			escritor.println("</listaRecursos>");
			escritor.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void escribirRecurso(PrintWriter escritor, Recurso actual,String tab){
		escritor.println(tab+"<recurso>");
		tab=tab.concat("\t");
		
		escritor.println(tab+"<codigo>"+actual.dameCodigo()+"</codigo>");
		escritor.println(tab+"<fechaEmision>"+actual.dameFechaEmision()+"</fechaEmision>");
		escritor.println(tab+"<escritoRecibido>"+actual.dameEscritoRecibido()+"</escritoRecibido>");
		escritor.println(tab+"<escritoPresentado>"+actual.dameEscritoPresentado()+"</escritoPresentado>");
		escritor.println(tab+"<estado>"+actual.dameEstado()+"</estado>");
		escritor.println(tab+"<abogado>"+actual.dameAbogado()+"</abogado>");
		escritor.println(tab+"<descripcion>"+actual.dameDescripcion()+"</descripcion>");
		escritor.println(tab+"<codigoMulta>"+actual.dameCodigoMulta()+"</codigoMulta>");
		
		tab=tab.substring(1);
		escritor.println(tab+"</recurso>");}
	
	public boolean cargarRecursosXML() throws IOException{
		BufferedReader lector=new BufferedReader(new FileReader("recursos.xml"));
		String lineaActual;
		String tab="";
		lineaActual=lector.readLine();
		if (!lineaActual.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
		System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.startsWith("<!DOCTYPE listaRecursos>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.startsWith("<listaRecursos>")){
					System.out.println("No hay etiqueta listaRecursos");
				}else{
					tab=tab.concat("\t");
					lineaActual=lector.readLine();
					if (!lineaActual.startsWith(tab+"<activos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.startsWith(tab+"</activos>")){
							tab=tab.concat("\t");
							LinkedList datosRecurso=leerRecurso(lineaActual,lector,tab);
							String codigoRecurso=(String)datosRecurso.removeFirst();
							Recurso nuevoRecurso=new Recurso(codigoRecurso,datosRecurso);
							grecursos.meteRecurso(nuevoRecurso);
							lineaActual=lector.readLine();
							tab=tab.substring(1);
						}
						lineaActual=lector.readLine();
						if (!lineaActual.startsWith(tab+"<eliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.startsWith(tab+"</eliminados>")){
								tab=tab.concat("\t");
							
								LinkedList datosRecurso=leerRecurso(lineaActual,lector,tab);
								String codigoRecurso=(String)datosRecurso.removeFirst();
								Recurso nuevoRecurso=new Recurso(codigoRecurso,datosRecurso);
								grecursos.dameEstructuraRecursos().insertarAEliminados(nuevoRecurso);
								
								lineaActual=lector.readLine();
								tab=tab.substring(1);
							}
							tab=tab.substring(1);
							lineaActual=lector.readLine();
							if (!lineaActual.startsWith("</listaRecursos>")){
								System.out.println("No hay cierre de etiqueta listaRecursos");
							}else{
								lineaActual=lector.readLine();
								if(lineaActual!=null){
									System.out.println("Existen datos despues de la ultima etiqueta </listaRecursos>" );
								}else return true;
							}
						}
					
					}
				}
			}
		}	
		return false;		
	}
	
	
	public LinkedList leerRecurso(String linea, BufferedReader lector, String tab) throws IOException{
		if (!linea.equals(tab+"<recurso>")){
			System.out.println("No se ha encontado un contrato");
		}else{
			LinkedList datosRecurso=new LinkedList();
			String principio;
			String fin;
			String interior;
			
			tab=tab.concat("\t");
			linea=lector.readLine();
						
			principio="<codigo>";
			fin ="</codigo>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();
			
			principio="<fechaEmision>";
			fin ="</fechaEmision>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();
			
			principio="<escritoRecibido>";
			fin ="</escritoRecibido>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();
			
			principio="<escritoPresentado>";
			fin ="</escritoPresentado>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();
	
			principio="<estado>";
			fin ="</estado>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();

			principio="<abogado>";
			fin ="</abogado>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();

			principio="<descripcion>";
			fin ="</descripcion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();

			principio="<codigoMulta>";
			fin ="</codigoMulta>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosRecurso.add(interior);	
			linea=lector.readLine();
			tab=tab.substring(1);
			
			if (!linea.equals(tab+"</recurso>")){
					System.out.println("No se ha encontrado la etiqueta que cierra recurso");
				}else{
					return datosRecurso;
				}
			
		}
		return null;	
	}
	
	public void almacenarEmpleadosXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("empleados.xml")));
			escritor.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
			//System.out.println("Primera linea del archivo XML creada");
			escritor.println("<!DOCTYPE listaEmpleados>");
			EstructuraDatos empleados=gempleados.dameEstructuraEmpleados();
			escritor.println("<listaEmpleados>");
			String tab="\t";
			escritor.println(tab+"<activos>");
			Vector empleadosActivos=empleados.dameIndice(0).dameElementos();
			tab=tab.concat("\t");
			for(int i=0;i<empleadosActivos.size();i++){
				Empleado empleadoActual=(Empleado)empleadosActivos.get(i);
				escribirEmpleado(escritor,empleadoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</activos>");
			escritor.println(tab+"<eliminados>");
			Vector empleadosEliminados=empleados.dameEliminados();
			tab=tab.concat("\t");
			for(int i=0;i<empleadosEliminados.size();i++){
				Empleado empleadoActual=(Empleado)empleadosEliminados.get(i);
				escribirEmpleado(escritor,empleadoActual,tab);
			}
			tab=tab.substring(1);
			escritor.println(tab+"</eliminados>");
			escritor.println("</listaEmpleados>");
			escritor.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
	}

	void escribirEmpleado(PrintWriter escritor, Empleado actual, String tab){
		String perfil=actual.damePerfil();
		escritor.println(tab+"<empleado>");
		tab=tab.concat("\t");
		
		escritor.println(tab+"<codigo>"+actual.dameCodigo()+"</codigo>");
		escritor.println(tab+"<perfil>"+perfil+"</perfil>");
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
		escritor.println(tab+"<nomina>"+actual.dameNomina()+"</nomina>");
		if (!perfil.equals("Administrativo")){
			escritor.println(tab+"<listacodigosrecursos>");
			LinkedList codigosrecursos=((Abogado)actual).dameListaRecursos();
			tab=tab.concat("\t");
			for (int i=0;i<codigosrecursos.size();i++){
				escritor.println(tab+"<codigorecurso>"+(String) codigosrecursos.get(i)+"</codigorecurso>");
			}
			tab=tab.substring(1);
			escritor.println(tab+"</listacodigosrecursos>");
			
		}
		tab=tab.substring(1);
		escritor.println(tab+"</empleado>");
	}
	 
	 public boolean cargarEmpleadosXML() throws IOException{
		BufferedReader lector=new BufferedReader(new FileReader("empleados.xml"));
		String lineaActual;
		String tab="";
		lineaActual=lector.readLine();
		if (!lineaActual.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")){
			System.out.println("La primera linea es incorrecta");
		}else{
			lineaActual=lector.readLine();
			if (!lineaActual.startsWith("<!DOCTYPE listaEmpleados>")){
				System.out.println("La segunda linea es incorrecta");
			}else{
				lineaActual=lector.readLine();
				if (!lineaActual.startsWith("<listaEmpleados>")){
					System.out.println("No hay etiqueta listaEmpleados");
				}else{
					tab=tab.concat("\t");
					lineaActual=lector.readLine();
					if (!lineaActual.startsWith(tab+"<activos>")){
						System.out.println("No hay etiqueta activos");
					}else{
						lineaActual=lector.readLine();
						while (!lineaActual.startsWith(tab+"</activos>")){
							tab=tab.concat("\t");
							LinkedList datosEmpleado=leerEmpleado(lineaActual,lector,tab);
							String codigoEmpleado=(String)datosEmpleado.removeFirst();
							String perfilEmpleado=(String)datosEmpleado.removeFirst();
							Empleado nuevoEmpleado;
							if (perfilEmpleado.equals("Administrativo")){
								nuevoEmpleado=new Administrativo(codigoEmpleado,perfilEmpleado,datosEmpleado);
								gempleados.meteEmpleado(nuevoEmpleado);
							}else{
								Vector recursosAsociados=(Vector)datosEmpleado.removeLast();
								nuevoEmpleado=new Abogado(codigoEmpleado,perfilEmpleado,datosEmpleado);
								gempleados.meteEmpleado(nuevoEmpleado);
								for (int i=0;i<recursosAsociados.size();i++){
									gempleados.asociaAbogadoRecurso(codigoEmpleado,(String)recursosAsociados.get(i));
								}
							}
							lineaActual=lector.readLine();
							tab=tab.substring(1);
						}
						lineaActual=lector.readLine();
						if (!lineaActual.startsWith(tab+"<eliminados>")){
							System.out.println("No hay etiqueta eliminados");
						}else{
							lineaActual=lector.readLine();
							while (!lineaActual.startsWith(tab+"</eliminados>")){
								tab=tab.concat("\t");
								LinkedList datosEmpleado=leerEmpleado(lineaActual,lector,tab);
								String codigoEmpleado=(String)datosEmpleado.removeFirst();
								String perfilEmpleado=(String)datosEmpleado.removeFirst();
								Empleado nuevoEmpleado;
								if (perfilEmpleado.equals("Administrativo")){
									nuevoEmpleado=new Administrativo(codigoEmpleado,perfilEmpleado,datosEmpleado);
									gempleados.dameEstructuraEmpleados().insertarAEliminados(nuevoEmpleado);
								}else{
									datosEmpleado.removeLast();
									nuevoEmpleado=new Abogado(codigoEmpleado,perfilEmpleado,datosEmpleado);
									gempleados.dameEstructuraEmpleados().insertarAEliminados(nuevoEmpleado);
					
								}	
								lineaActual=lector.readLine();
								tab=tab.substring(1);
							}
							lineaActual=lector.readLine();
							if (!lineaActual.startsWith("</listaEmpleados>")){
								System.out.println("No hay cierre de etiqueta listaEmpleados");
							}else{
								lineaActual=lector.readLine();
								if(lineaActual!=null){
									System.out.println("Existen datos despues de la ultima etiqueta </listaEmpleados>");
								}else return true;
							/*catch (IOException e) {
									return true;	
								}*/
							}
						}
						
					}
				}
			}
		}
	 	return false;		
		
	}
 
	LinkedList leerEmpleado(String linea, BufferedReader lector,String tab) throws IOException{
		if (!linea.equals(tab+"<empleado>")){
			System.out.println("No se ha encontado un cliente");
		}else{
			LinkedList datosEmpleado=new LinkedList();
			String principio;
			String fin;
			String interior;
			
			tab=tab.concat("\t");
			linea=lector.readLine();
			
			principio="<codigo>";
			fin ="</codigo>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<perfil>";
			fin ="</perfil>";
			String perfil=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(perfil);	
			linea=lector.readLine();
			
			principio="<nombre>";
			fin ="</nombre>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<dni>";
			fin ="</dni>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			
			principio="<direccion>";
			fin ="</direccion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<cp>";
			fin ="</cp>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<poblacion>";
			fin ="</poblacion>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<provincia>";
			fin ="</provincia>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<telefono1>";
			fin ="</telefono1>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<telefono2>";
			fin ="</telefono2>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<movil>";
			fin ="</movil>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<email>";
			fin ="</email>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<fax>";
			fin ="</fax>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			principio="<nomina>";
			fin ="</nomina>";
			interior=dameInteriorEtiquetas(tab,linea,principio,fin);
			datosEmpleado.add(interior);	
			linea=lector.readLine();
			
			if (!perfil.equals("Administrativo")){
				if (!linea.startsWith(tab+"<listacodigosrecursos>")){
					System.out.println("No se ha encontado la lista de recursos del empleado");
				}else{
					Vector listaCodigosRecurso=new Vector();
					linea=lector.readLine();
					while (!linea.startsWith(tab+"</listacodigosrecursos>")){
						tab=tab.concat("\t");
						principio="<codigorecurso>";
						fin ="</codigorecurso>";
						interior=dameInteriorEtiquetas(tab,linea,principio,fin);
						listaCodigosRecurso.add(interior);	
						linea=lector.readLine();
						tab=tab.substring(1);
					}
					datosEmpleado.add(listaCodigosRecurso);
					
				}
				linea=lector.readLine();
			}		
			
			tab=tab.substring(1);
			if (!linea.startsWith(tab+"</empleado>")){
				System.out.println("No se ha encontrado la etiqueta que cierra empleado");
			}else{
				return datosEmpleado;
			}
			
		}
		return null;			
	}
	
	public void almacenarConfigIni()
	{
		try 
		{	PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("configsig.ini")));
			escritor.println("codcontrato="+gcontratos.dameCodigo());
			escritor.println("codcliente="+gclientes.dameCodigo());
			escritor.println("codmulta="+gmultas.dameCodigo());
			escritor.println("codrecurso="+grecursos.dameCodigo());
			escritor.println("codempleado="+gempleados.dameCodigo());
			escritor.println("ultimomesfac="+geconomia.dameUltimaMesFac());
			escritor.println("ultimomesgas="+geconomia.dameUltimaMesGas());
			escritor.println("ultimomesbal="+geconomia.dameUltimaMesBal());
			int[] fac=geconomia.dameVectorFacturacion();
			int[] gas=geconomia.dameVectorGastos();
			int[] bal=geconomia.dameVectorBalance();
			String linea="facturacion=";
			for (int i=0;i<12;i++)
			{	linea=linea+"+"+fac[i]+",";}
			escritor.println(linea);
			linea="gastos=";
			for (int i=0;i<12;i++)
			{	if (gas[i]==0) linea=linea+"-"+gas[i]+",";
				else linea=linea+gas[i]+",";
			}
			escritor.println(linea);
			linea="balance=";
			for (int i=0;i<12;i++)
			{	if (bal[i]<0) linea=linea+bal[i]+",";
				else linea=linea+"+"+bal[i]+",";
			}
			escritor.println(linea);
			escritor.close();
		}
		catch(IOException e) 
		{
			System.out.println("Error al crear el fichero configsig.ini"+e);
		}
	}
}
