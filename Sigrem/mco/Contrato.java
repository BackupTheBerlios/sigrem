package mco;

import java.util.LinkedList;

public class Contrato
{
	private String codigocontrato;
	
	private String matricula;
	
	private String fechaalta;
	
	private String fechabaja;
	
	private String codigocliente;
	
	private LinkedList listamultas; 
	
	public Contrato(String codcontrato,LinkedList datos) 
	{
		codigocontrato=codcontrato;
		codigocliente=(String)datos.get(0);
		matricula=(String)datos.get(1);
		fechaalta=(String)datos.get(2);
		fechabaja="";
		listamultas=new LinkedList();
	}
	public String dameCodigoContrato()
	{
		return codigocontrato;
	}
	public String dameMatricula()
	{
		return matricula;
	}
	public String dameFechaAlta()
	{
		return fechaalta;
	}
	public String dameFechaBaja()
	{
		return fechabaja;
	}
	public String dameCodigoCliente()
	{
		return codigocliente;
	}
	public LinkedList dameListamultas()
	{
		return listamultas;
	}
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigocontrato);
		datos.add(codigocliente);
		datos.add(matricula);
		datos.add(fechaalta);
		datos.add(fechabaja);
		return datos;
	}
	
	public void ponFechaAlta(String fecha)
	{
		this.fechaalta=fecha;
	}
	
	public void ponFechaBaja(String fecha)
	{
		this.fechabaja=fecha;
	}
	public void ponCodigoCliente(String cod)
	{
		this.codigocliente=cod;
	}
	public void ponListaMultas(LinkedList lista)
	{
		this.listamultas=lista;
	}
	public void ponListaDatos(LinkedList datos)
	{
		codigocontrato=(String)datos.get(0);
		codigocliente=(String)datos.get(1);
		matricula=(String)datos.get(2);
		fechaalta=(String)datos.get(3);
		fechabaja=(String)datos.get(4);		
		listamultas=(LinkedList)datos.get(5);
	}
}