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
	
	private LinkedList listacontratos;

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
		listacontratos=new LinkedList();
	}

	public String getCodigo()
	{
		return codigo;
	}

	public String getNombre()
	{
		return nombre;
	}
	
	public String getDni()
	{
		return dni;
	}
	
	public String getDireccion()
	{
		return direccion;
	}
	public String getCp()
	{
		return cp;
	}
	public String getPoblacion()
	{
		return poblacion;
	}
	public String getProvincia()
	{
		return provincia;
	}
	public String getTelefono1()
	{
		return telefono1;
	}
	public String getTelefono2()
	{
		return telefono2;
	}
	public String getMovil()
	{
		return movil;
	}
	public String getEmail()
	{
		return email;
	}
	public String getFax()
	{
		return fax;
	}
	public LinkedList getListaContratos()
	{
		return listacontratos;
	}
	public LinkedList getListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(dni);
		datos.add(nombre);
		datos.add(direccion);
		datos.add(cp);
		datos.add(poblacion);
		datos.add(provincia);
		datos.add(telefono1);
		datos.add(telefono2);
		datos.add(movil);
		datos.add(email);
		datos.add(fax);
		return datos;
	}
	
	public void añadeContrato(String codigo)
	{
		listacontratos.add(codigo);		
	}
	
	public void eliminaContrato(String codigo)
	{
		int i=0;
		boolean esta=false;
		while ((!esta) && (i<listacontratos.size()))
		{	esta=codigo.equals((String)listacontratos.get(i));
			i++;			
		}
		if (esta)listacontratos.remove(i-1);		
	}
	
	public int getNumeroContratos()
	{
		return listacontratos.size();
	}
	
	public void setCodigo(String cod)
	{
		this.codigo=cod;
	}

	public void setNombre(String nom)
	{
		this.nombre=nom;
	}
	
	public void setDni(String dni)
	{
		this.dni=dni;
	}
	
	public void setDireccion(String dir)
	{
		this.direccion=dir;
	}
	public void setCp(String cp)
	{
		this.cp=cp;
	}
	public void setPoblacion(String pob)
	{
		this.poblacion=pob;
	}
	public void setProvincia(String pro)
	{
		this.provincia=pro;
	}
	public void setTelefono1(String tel)
	{
		this.telefono1=tel;
	}
	public void setTelefono2(String tel)
	{
		this.telefono2=tel;
	}
	public void setMovil(String mov)
	{
		this.movil=mov;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setFax(String fax)
	{
		this.fax=fax;
	}
	public void setListaContratos(LinkedList lista)
	{
		this.listacontratos=lista;
	}
	public void setListaDatos(LinkedList datos)
	{
		dni=(String)datos.get(0);
		nombre=(String)datos.get(1);
		direccion=(String)datos.get(2);
		cp=(String)datos.get(3);
		poblacion=(String)datos.get(4);
		provincia=(String)datos.get(5);
		telefono1=(String)datos.get(6);
		telefono2=(String)datos.get(7);
		movil=(String)datos.get(8);
		email=(String)datos.get(9);
		fax=(String)datos.get(10);
		listacontratos=(LinkedList)datos.get(11);
	}
}