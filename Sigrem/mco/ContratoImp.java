package mco;

import mcl.Cliente;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ContratoImp implements Contrato{
	Integer codigo;
	String matricula;
	Cliente cliente;
	
  public ContratoImp(Cliente cli, Integer cod,String mat) {
  	codigo=cod;
  	matricula=mat;
  	cliente=cli;
  }
  
  public Integer dameCodigo(){
  	return codigo;
  }
  
  public String dameMatricula(){
  	return matricula;
  }
  
  public Cliente dameCliente(){
  	return cliente;
  }
}