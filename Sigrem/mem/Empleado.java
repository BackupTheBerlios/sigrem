package mem;

import java.util.LinkedList;

public abstract class Empleado 
{
	private String codigo;
	private String perfil;
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
	private String nomina;
	
	// Constructor
	public Empleado(String codigoEmpleado,String perfilEmpleado,LinkedList listaEmpleado) 
	{
		codigo = 	codigoEmpleado;
		perfil =	perfilEmpleado;
		nombre = 	(String)listaEmpleado.get(0);
		dni = 		(String)listaEmpleado.get(1);
		direccion = (String)listaEmpleado.get(2);
		cp = 		(String)listaEmpleado.get(3);
		poblacion = (String)listaEmpleado.get(4);
		provincia = (String)listaEmpleado.get(5);
		telefono1 = (String)listaEmpleado.get(6);
		telefono2 = (String)listaEmpleado.get(7);
		movil = 	(String)listaEmpleado.get(8);
		email = 	(String)listaEmpleado.get(9);
		fax = 		(String)listaEmpleado.get(10);
		nomina =	(String)listaEmpleado.get(11);
	}
	// métodos accesores
	public String dameCodigo(){return codigo;}
	public String dameNombre(){return nombre;}
	public String dameDni(){return dni;}
	public String dameDireccion(){return direccion;}
	public String dameCp(){return cp;}
	public String damePoblacion(){return poblacion;}
	public String dameProvincia(){return provincia;}
	public String dameTelefono1(){return telefono1;}
	public String dameTelefono2(){return telefono2;}
	public String dameMovil(){return movil;}
	public String dameEmail(){return email;}
	public String dameFax(){return fax;}
	public String dameNomina(){return nomina;}
	public String damePerfil(){return perfil;}
	
	// Método que devuelve una LinkedList con todos los datos del objeto con un cierto orden
	public LinkedList dameListaDatos()
	{
		LinkedList datos=new LinkedList();
		datos.add(codigo);
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
		datos.add(nomina);
		return datos;
	}
	
	// Métodos mutadores
	public void ponDireccion(String dir){this.direccion = dir;}
	public void ponCp(String cp){this.cp = cp;}
	public void ponPoblacion(String pob){this.poblacion = pob;}
	public void ponProvincia(String pro){this.provincia = pro;}
	public void ponTelefono1(String tel){this.telefono1 = tel;}
	public void ponTelefono2(String tel){this.telefono2 = tel;}
	public void ponMovil(String mov){this.movil = mov;}
	public void ponEmail(String email){this.email = email;}
	public void ponFax(String fax){this.fax = fax;}
	public void ponNomina(String nomina){this.nomina = nomina;}
	public void ponPerfil(String perfil){this.perfil = perfil;}
}
