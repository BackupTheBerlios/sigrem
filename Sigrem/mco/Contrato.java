package mco;

import java.util.LinkedList;

public class Contrato
{
	private String codigoContrato;
	
	private String matricula;
	
	private String fechaAlta;
	
	private String fechaBaja;
	
	private String codigoCliente;
	
	private LinkedList listaMultas; 
	
	public Contrato(String codcontrato,LinkedList datos) 
	{
		codigoContrato=codcontrato;
		codigoCliente=(String)datos.get(0);
		matricula=(String)datos.get(1);
		fechaAlta=(String)datos.get(2);
		fechaBaja="";
		listaMultas=new LinkedList();
	}
	public String dameCodigoContrato()
	{
		return codigoContrato;
	}
	public String dameMatricula()
	{
		return matricula;
	}
	public String dameFechaAlta()
	{
		return fechaAlta;
	}
	public String dameFechaBaja()
	{
		return fechaBaja;
	}
	public String dameCodigoCliente()
	{
		return codigoCliente;
	}
	public LinkedList dameListamultas()
	{
		return listaMultas;
	}
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigoContrato);
		datos.add(codigoCliente);
		datos.add(matricula);
		datos.add(fechaAlta);
		datos.add(fechaBaja);
		return datos;
	}
	public void aņadeMulta(String codmulta)
	{
		listaMultas.add(codmulta);
	}
	public void ponFechaAlta(String fecha)
	{
		this.fechaAlta=fecha;
	}
	
	public void ponFechaBaja(String fecha)
	{
		this.fechaBaja=fecha;
	}
	public void ponCodigoCliente(String cod)
	{
		this.codigoCliente=cod;
	}
	public void ponListaMultas(LinkedList lista)
	{
		this.listaMultas=lista;
	}
}