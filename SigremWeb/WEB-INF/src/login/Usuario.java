package login;

public class Usuario 
{
	protected String nombreUsuario;
	
	protected String password;
	
	protected String tipoUsuario;
	
	public String getNombreUsuario()
	{
		return nombreUsuario;
	}

	public String getPassword()
	{
		return password;
	}
	public String getTipoUsuario()
	{
		return tipoUsuario;
	}
	
	public void setPassword(String pass)
	{
		this.password=pass;
	}
	public void setNombreUsuario(String nombre)
	{
		this.nombreUsuario=nombre;
	}
	public void setTipoUsuario(String tipo)
	{
		this.tipoUsuario=tipo;
	}
}