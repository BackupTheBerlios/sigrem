package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		//File archivo=new File("clientes.xml");
		//archivo.exists();
		if (!cargarXML()){
			System.out.println("La carga de XML no ha sido correcta");				
		}
	}
	
	public void almacenarXML(){
		almacenarClientesXML();
		almacenarContratosXML();
		almacenarMultasXML();
		almacenarRecursosXML();
	}
	
	public boolean cargarXML(){
		boolean bienCargado=true;
		try {
			cargarClientesXML();
			System.out.println("La carga de clientes se ha realizado correctamente");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Algun dato de gclientes es erroneo");
			bienCargado=false;
		} 
		try {
			cargarContratosXML();	
			System.out.println("La carga de contratos se ha realizado correctamente");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Algun dato de gcontratos es erroneo");
			bienCargado=false;
		}
		try {
			cargarMultasXML();
			System.out.println("La carga de multas se ha realizado correctamente");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("Algun dato de gmultas es erroneo");
			bienCargado=false;
		}
		try {	
			cargarRecursosXML();
			System.out.println("La carga de recursos se ha realizado correctamente");
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			System.out.println("Algun dato de grecursos es erroneo");
			bienCargado=false;
		}
		return bienCargado;
	}
	public void almacenarClientesXML(){
		try {
			PrintWriter escritor=new PrintWriter(new BufferedWriter(new FileWriter("clientes.xml")));
			escritor.println("<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\">");
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
		if (!lineaActual.startsWith("<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\">")){
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
								gclientes.asociaClienteContrato(codigoCliente,(String)contratosAsociados.get(i));
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
								gclientes.dameEstructuraClientes().insertarAEliminados(datosCliente);
								/*for (int i=0;i<contratosAsociados.size();i++){
									gclientes.asociaClienteContrato((String)datosCliente.getFirst(),(String)contratosAsociados.get(i));
								}
								//gclientes.eliminarCliente(false,datosCliente.g)
								//falta eliminar los clientes eliminados, se podr�a hacer en casacada eliminando exclusivamente los contratos
							*/	lineaActual=lector.readLine();
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
			//cuidado con los limites!!!
			//que pasa cuando no se encuentran???
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
			escritor.println("<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\">");
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
		escritor.println(tab+"<matricula>"+actual.dameMatricula()+"</matricula>");
		escritor.println(tab+"<fechaAlta>"+actual.dameFechaAlta()+"</fechaAlta>");
		escritor.println(tab+"<fechaBaja>"+actual.dameFechaBaja()+"</fechaBaja>");
		escritor.println(tab+"<codigocliente>"+actual.dameCodigoCliente()+"</codigocliente>");
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
	
	public boolean cargarContratosXML() throws IOException{BufferedReader lector=new BufferedReader(new FileReader("contratos.xml"));
	String lineaActual;
	String tab="";
	lineaActual=lector.readLine();
	if (!lineaActual.startsWith("<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\">")){
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
						tab=tab.concat("\t");
						for (int i=0;i<multasAsociados.size();i++){
							gcontratos.asociaContratoMulta(codigoContrato,(String)multasAsociados.get(i));
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
							LinkedList datosContrato=leerContrato(lineaActual,lector,tab);
							Vector contratosAsociados=(Vector)datosContrato.removeLast();
							gcontratos.dameEstructuraContratos().insertarAEliminados(datosContrato);
							/*for (int i=0;i<contratosAsociados.size();i++){
								gclientes.asociaClienteContrato((String)datosCliente.getFirst(),(String)contratosAsociados.get(i));
							}
							//gclientes.eliminarCliente(false,datosCliente.g)
							//falta eliminar los clientes eliminados, se podr�a hacer en casacada eliminando exclusivamente los contratos
						*/	lineaActual=lector.readLine();
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
			
			principio="<codigocliente>";
			fin ="</codigocliente>";
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
					principio="<codigoMulta>";
					fin ="</codigoMulta>";
					interior=dameInteriorEtiquetas(tab,linea,principio,fin);
					listaCodigosMultas.add(interior);	
					linea=lector.readLine();
					tab=tab.substring(1);
				}
				datosContrato.add(listaCodigosMultas);
				linea=lector.readLine();
				tab=tab.substring(1);
				if (!linea.equals(tab+"</contrato>")){
					System.out.println("No se ha encontrado la etiqueta que cierra cliente");
				}else{
					return datosContrato;
				}
			}
		}
		return null;	
	}
		
	public void almacenarMultasXML(){}
	void escribirMulta(PrintWriter escritor, Multa actual){}
	public boolean cargarMultasXML() throws IOException{	
		return true;
	}
	public LinkedList leerMulta(String linea, BufferedReader lector) throws IOException{
		return null;
	}
		
	public void almacenarRecursosXML(){}
	void escribirRecurso(PrintWriter escritor, Recurso actual){}
	public boolean cargarRecursosXML() throws IOException{
		return true;
	}
	public LinkedList leerRecurso(String linea, BufferedReader lector) throws IOException{
		return null;
	}
	
	public void almacenarEmpleadosXML(){}
	void escribirEmpleado(PrintWriter escritor, Empleado actual){}
	public boolean cargarEmpleadosXML() throws IOException{
		return true;
	}
	public LinkedList leerEmpleado(String linea, BufferedReader lector) throws IOException{
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
