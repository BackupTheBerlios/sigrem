package mmu;

import mco.*;

public class Multa
{
	Integer codigo;
	String expediente;
	String boletin;
	Contrato contrato;
	
  public Multa(Contrato con, Integer cod,String exp, String bol) {
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