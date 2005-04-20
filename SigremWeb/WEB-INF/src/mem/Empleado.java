package mem;

public class Empleado 
{
	protected String codigo;
	protected String perfil;
	protected String dni;
	protected String nombre;
	protected String direccion;
	protected String cp;
	protected String poblacion;
	protected String provincia;
	protected String telefono1;
	protected String telefono2;
	protected String movil;
	protected String email;
	protected String fax;
	protected String nomina;
	
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
	
	public void ponCodigo(String cod){this.codigo = cod;}
	public void ponNombre(String nom){this.nombre = nom;}
	public void ponDni(String dni){this.direccion = dni;}
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