/*
 * Created on 14-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mmu;

import interfaz.InterfazGrafica;
import mco.Contrato;
import med.*;
import main.ModuloGestion;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class GMultasImp 
{
	private EstructuraDatos multas;
	private InterfazGrafica vista; 
	  
	public GMultasImp(InterfazGrafica vista) 
	{
		multas=new ListaConIndices(3);
	    this.vista=vista;
	}

	public boolean añadirMulta(Contrato contrato, Integer codigo,String expediente, String boletin)
	{
		//falta añadir todos los parametros de contrato
		Multa nuevo=new MultaImp(contrato,codigo,expediente,boletin);
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
	  	Multa nuevo=new MultaImp(contrato,codigoNuevo,expedienteNuevo,boletinNuevo);
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

	}
}
