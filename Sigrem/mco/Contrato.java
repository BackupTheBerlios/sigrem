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
		matricula=(String)datos.get(0);
		fechaalta=(String)datos.get(1);
		fechabaja="";
		codigocliente=(String)datos.get(2);
		listamultas=new LinkedList();
	}
	public String getCodigoContrato()
	{
		return codigocontrato;
	}
	public String getMatricula()
	{
		return matricula;
	}
	public String getFechaAlta()
	{
		return fechaalta;
	}
	public String getFechaBaja()
	{
		return fechabaja;
	}
	public String getCodigoCliente()
	{
		return codigocliente;
	}
	public LinkedList getListamultas()
	{
		return listamultas;
	}
	public LinkedList getListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigocontrato);
		datos.add(matricula);
		datos.add(fechaalta);
		datos.add(fechabaja);
		datos.add(codigocliente);
		datos.add(listamultas);
		return datos;
	}
	
	public void setCodigoContrato(String cod)
	{
		this.codigocontrato=cod;
	}

	public void setMatricula(String mac)
	{
		this.matricula=mac;
	}
	
	public void setFechaAlta(String fecha)
	{
		this.fechaalta=fecha;
	}
	
	public void setFechaBaja(String fecha)
	{
		this.fechabaja=fecha;
	}
	public void setCodigoCliente(String cod)
	{
		this.codigocliente=cod;
	}
	public void setListaMultas(LinkedList lista)
	{
		this.listamultas=lista;
	}
	public void setListaDatos(LinkedList datos)
	{
		codigocontrato=(String)datos.get(0);
		matricula=(String)datos.get(1);
		fechaalta=(String)datos.get(2);
		fechabaja=(String)datos.get(3);
		codigocliente=(String)datos.get(4);
		listamultas=(LinkedList)datos.get(5);
	}
}