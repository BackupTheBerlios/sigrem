package mmu;

import java.util.LinkedList;

import interfaz.InterfazGrafica;
import med.*;

public class GMultasImp implements GMultas 
{
	private String codigoMulta;
	
	private EstructuraDatos listaMultas;
	
	private InterfazGrafica vista; 
	  
	public GMultasImp(InterfazGrafica vista,String codigo) 
	{
		this.codigoMulta=codigo;
		this.listaMultas=new EstructuraDatosImp(3);
	    this.vista=vista;
	}
	
	private void incrementaCodigo()
	{
		String numero=codigoMulta.substring(0,3);
		Character car=null;
		int num=car.digit(codigoMulta.charAt(3),10);
		for (int i=4;i<codigoMulta.length();i++)
		{	num=(num*10)+car.digit(codigoMulta.charAt(i),10);}
		numero=numero+(num+1);
		codigoMulta=numero;
	}
		
	//clave0=codigo  clave1=expediente  clave2=boletin
	public String añadirMulta(LinkedList datos)
	{
		Multa nuevamulta=new Multa(codigoMulta,datos);
		String[] claves=new String[3];
		claves[0]=codigoMulta;
		claves[1]=(String)datos.get(0);
		claves[2]=(String)datos.get(1);		
		listaMultas.insertar(claves,nuevamulta);
		String codigoantiguo=codigoMulta;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		LinkedList datosmultas=new LinkedList();
		datosmultas.add(datos);
		vista.actualizaVistaCajaMultas(datos);
		vista.actualizaVista(1,3,null);
		return codigoantiguo;
	}
	
	public void eliminarMulta(String codigo)
	{
		
	}

	public void modificarMulta(String codigo)
	{
		
	}

	public void consultarMultaCodigo(String codigo)
	{
		
	}

	public void consultarMultaExpediente(String expediente)
	{
		
	}

	public void consultarMultaBoletin(String boletin)
	{
		
	}
	
/*	public boolean añadirMulta(Contrato contrato, Integer codigo,String expediente, String boletin)
	{
		//falta añadir todos los parametros de contrato
		Multa nuevo=new Multa(contrato,codigo,expediente,boletin);
		Comparable[] claves=null;
		claves[0]= nuevo.dameCodigo();
		claves[1]= nuevo.dameExpediente();
		if (consultarMultaCodigo((Integer)claves[0])==null && consultarMultaExpediente((String)claves[1])==null){
			multas.insertar(claves,nuevo);
			//vista.actualizaMulta();
			//falta saber como se comunica con la interfaz
			return true;
		}
		return false;
	}

	public boolean eliminarMulta(Integer codigo)
	{
		boolean eliminado=multas.eliminar(codigo,0);
	  	if (eliminado) {
	  		//vista.actualizaMulta();
			//falta saber como se comunica con la interfaz
	  	}
	  	return eliminado; 
	    
	}


	public boolean modificarMulta(Integer codigoAntiguo,Contrato contrato, Integer codigoNuevo,String expedienteNuevo,String boletinNuevo)
	{
	  	//falta añadir todos los parametros de contrato
	  	Multa nuevo=new Multa(contrato,codigoNuevo,expedienteNuevo,boletinNuevo);
	  	Multa antiguo=this.consultarMultaCodigo(codigoAntiguo);
	  	if (antiguo!=null){
	  		String expedienteAntiguo=antiguo.dameExpediente();
	  		String boletinAntiguo=antiguo.dameBoletin();
	  		//controla TODAS las posibles combinaciones de cambios de indice de codigo y expediente no permitidas
	  		//SOLO CONTROLA CODIGO Y EXPEDIENTE---NO SE SI HACE FALTA BOLETIN
	  		if (codigoNuevo!=codigoAntiguo){
	  			if (expedienteNuevo!=expedienteAntiguo){
	  				if (consultarMultaCodigo(codigoNuevo)==null && this.consultarMultaExpediente(expedienteNuevo)==null){
	  					multas.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);  	
	  		  			multas.cambiarClaveDeIndice(expedienteAntiguo,expedienteNuevo,1);
	  				}else return false;
	  			}else{
	  				if (this.consultarMultaCodigo(codigoNuevo)==null){
	  					multas.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);
	  				}else return false;
	  			}
	  		}else{
	  			if (expedienteNuevo!=expedienteAntiguo){
	  				if (this.consultarMultaExpediente(expedienteNuevo)==null){
	  					multas.cambiarClaveDeIndice(expedienteAntiguo,expedienteNuevo,1);
	  				}else return false;
	  			}
	  		}
			multas.cambiarClaveDeIndice(boletinAntiguo,boletinNuevo,2);
	  		//vista.actualizaMultas();
			//falta saber como se comunica con la interfaz
	  		return true;
	  	}
	  	return false;
	}

	  
	public Multa consultarMultaCodigo(Integer codigo)
	{
	    return (Multa) this.multas.buscar(codigo,0);
	}

	public Multa consultarMultaExpediente(String expediente)
	{
	    return (Multa) this.multas.buscar(expediente,1);
	}
	  
	public Multa consultarMultasBoletin(String boletin)
	{
	    return (Multa) this.multas.buscar(boletin,2);

	}*/
}
