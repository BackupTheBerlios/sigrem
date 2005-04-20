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
	
	public String getCodigo(){return codigo;}
	public String getNombre(){return nombre;}
	public String getDni(){return dni;}
	public String getDireccion(){return direccion;}
	public String getCp(){return cp;}
	public String getPoblacion(){return poblacion;}
	public String getProvincia(){return provincia;}
	public String getTelefono1(){return telefono1;}
	public String getTelefono2(){return telefono2;}
	public String getMovil(){return movil;}
	public String getEmail(){return email;}
	public String getFax(){return fax;}
	public String getNomina(){return nomina;}
	public String getPerfil(){return perfil;}
	
	public void setCodigo(String cod){this.codigo = cod;}
	public void setNombre(String nom){this.nombre = nom;}
	public void setDni(String dni){this.dni = dni;}
	public void setDireccion(String dir){this.direccion = dir;}
	public void setCp(String cp){this.cp = cp;}
	public void setPoblacion(String pob){this.poblacion = pob;}
	public void setProvincia(String pro){this.provincia = pro;}
	public void setTelefono1(String tel){this.telefono1 = tel;}
	public void setTelefono2(String tel){this.telefono2 = tel;}
	public void setMovil(String mov){this.movil = mov;}
	public void setEmail(String email){this.email = email;}
	public void setFax(String fax){this.fax = fax;}
	public void setNomina(String nomina){this.nomina = nomina;}
	public void setPerfil(String perfil){this.perfil = perfil;}
}