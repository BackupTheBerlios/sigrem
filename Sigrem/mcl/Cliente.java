package mcl;

import java.util.LinkedList;

public class Cliente
{
	private String codigo;
	
	private String dni;
	
	private String nombre;
	
	private String direccion;
	
	private String cp;
	
	private String poblacion;
	
	private String provincia;
	
	private String telefono1;
	
	private String telefono2;
	
	private String movil;
	
	private String email;
	
	private String fax;
	
	private LinkedList listaContratos;

	public Cliente(String codcliente,LinkedList datos) 
	{
		codigo=codcliente;
		nombre=(String)datos.get(0);
		dni=(String)datos.get(1);
		direccion=(String)datos.get(2);
		cp=(String)datos.get(3);
		poblacion=(String)datos.get(4);
		provincia=(String)datos.get(5);
		telefono1=(String)datos.get(6);
		telefono2=(String)datos.get(7);
		movil=(String)datos.get(8);
		email=(String)datos.get(9);
		fax=(String)datos.get(10);
		listaContratos=new LinkedList();
	}

	public String dameCodigo()
	{
		return codigo;
	}

	public String dameNombre()
	{
		return nombre;
	}
	
	public String dameDni()
	{
		return dni;
	}
	
	public String dameDireccion()
	{
		return direccion;
	}
	public String dameCp()
	{
		return cp;
	}
	public String damePoblacion()
	{
		return poblacion;
	}
	public String dameProvincia()
	{
		return provincia;
	}
	public String dameTelefono1()
	{
		return telefono1;
	}
	public String dameTelefono2()
	{
		return telefono2;
	}
	public String dameMovil()
	{
		return movil;
	}
	public String dameEmail()
	{
		return email;
	}
	public String dameFax()
	{
		return fax;
	}
	public LinkedList dameListaContratos()
	{
		return listaContratos;
	}
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(nombre);
		datos.add(dni);
		datos.add(direccion);
		datos.add(cp);
		datos.add(poblacion);
		datos.add(provincia);
		datos.add(telefono1);
		datos.add(telefono2);
		datos.add(movil);
		datos.add(email);
		datos.add(fax);
		datos.add(listaContratos);
		return datos;
	}
	
	public void añadeContrato(String codigo)
	{
		listaContratos.add(codigo);		
	}
	
	public void eliminaContrato(String codigo)
	{
		int i=0;
		boolean esta=false;
		while ((!esta) && (i<listaContratos.size()))
		{	esta=codigo.equals((String)listaContratos.get(i));
			i++;			
		}
		if (esta)listaContratos.remove(i-1);		
	}
	
	public int dameNumeroContratos()
	{
		return listaContratos.size();
	}
	
	public void ponDireccion(String dir)
	{
		this.direccion=dir;
	}
	public void ponCp(String cp)
	{
		this.cp=cp;
	}
	public void ponPoblacion(String pob)
	{
		this.poblacion=pob;
	}
	public void ponProvincia(String pro)
	{
		this.provincia=pro;
	}
	public void ponTelefono1(String tel)
	{
		this.telefono1=tel;
	}
	public void ponTelefono2(String tel)
	{
		this.telefono2=tel;
	}
	public void ponMovil(String mov)
	{
		this.movil=mov;
	}
	public void ponEmail(String email)
	{
		this.email=email;
	}
	public void ponFax(String fax)
	{
		this.fax=fax;
	}
	public void ponListaContratos(LinkedList lista)
	{
		this.listaContratos=lista;
	}
}