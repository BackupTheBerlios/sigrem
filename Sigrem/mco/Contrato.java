package mco;

import mcl.Cliente;

public class Contrato
{
	Integer codigo;
	String matricula;
	Cliente cliente;
	
  public Contrato(Cliente cli, Integer cod,String mat) {
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