/*
 * Created on 14-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mmu;

import mco.*;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MultaImp implements Multa {
	Integer codigo;
	String expediente;
	String boletin;
	Contrato contrato;
	
  public MultaImp(Contrato con, Integer cod,String exp, String bol) {
  	codigo=cod;
  	expediente=exp;
  	boletin=bol;
  	contrato=con;
  }
  
  public Integer dameCodigo(){
  	return codigo;
  }
  
  public String dameExpediente(){
  	return expediente;
  }

  public String dameBoletin(){
  	return boletin;
  }
  
  public Contrato dameContrato(){
  	return contrato;
  }
}
