package main;

public interface ModuloGestion 
{
// son todos los m�todos void porque al ser un modelo activo, no devuelven nada al 
//	controlador, sino que son los m�dulos los que actualizan la vista
	public void a�adir(String[] datos);
	public void eliminar(Integer codigo);
	public void modificar(String[] datos);
	public void consultarCodigo(Integer codigo);
}
