package mmu;

import java.util.LinkedList;

public class Multa
{
	private String codigoMulta;
	
	private String expediente;
	
	private String boletin;
	
	private String fechaDenuncia;
	
	private String fechaResolucion;
	
	private String infraccion;
	
	private String descripcion;
	
	private String codigoContrato;
	
	private LinkedList listaRecursos;
	
	public Multa(String codmulta,LinkedList datos) 
	{
		codigoMulta=codmulta;
		codigoContrato=(String)datos.get(0);
		expediente=(String)datos.get(1);
		boletin=(String)datos.get(2);
		fechaDenuncia=(String)datos.get(3);
		fechaResolucion="";
		infraccion=(String)datos.get(4);
		descripcion=(String)datos.get(5);
		codigoContrato=(String)datos.get(6);
		listaRecursos=new LinkedList();		
	}
	
	public String dameCodigoMulta()
	{
		return codigoMulta;
	}
	
	public String dameExpediente()
	{
	 	return expediente;
	}
	
	public String dameBoletin()
	{
	 	return boletin;
	}
	
	public String dameCodigoContrato()
	{
		return codigoContrato;
	}
	
	public String dameFechaDenuncia()
	{
		return fechaDenuncia;
	}
	public String dameFechaResolucion()
	{
		return fechaResolucion;
	}
	public LinkedList dameListaRecursos()
	{
		return listaRecursos;
	}
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigoMulta);
		datos.add(expediente);
		datos.add(boletin);
		datos.add(fechaDenuncia);
		datos.add(fechaResolucion);
		datos.add(infraccion);
		datos.add(descripcion);
		datos.add(codigoContrato);
		datos.add(listaRecursos);
		return datos;
	}
	public void ponExpediente(String exp)
	{
		expediente=exp;
	}
	public void ponBoletin(String bol)
	{
		boletin=bol;
	}
	public void ponFechaDenuncia(String fecha)
	{
		fechaDenuncia=fecha;
	}
	public void ponFechaResolucion(String fecha)
	{
		fechaResolucion=fecha;
	}
	public void ponInfraccion(String infrac)
	{
		infraccion=infrac;
	}
	public void ponDescripcion(String descrip)
	{
		descripcion=descrip;		
	}
	public void ponListRecursos(LinkedList datos)
	{
		listaRecursos=datos;
	}
}