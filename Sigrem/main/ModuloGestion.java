package main;

public interface ModuloGestion 
{
// son todos los métodos void porque al ser un modelo activo, no devuelven nada al 
//	controlador, sino que son los módulos los que actualizan la vista
	public void añadir(String[] datos);
	public void eliminar(Integer codigo);
	public void modificar(String[] datos);
	public void consultarCodigo(Integer codigo);
}
