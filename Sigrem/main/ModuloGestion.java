package main;

import java.util.LinkedList;

public interface ModuloGestion 
{
	public boolean añadir(LinkedList datos);
	public boolean eliminar(Integer codigo);
	public Object modificar();
	public Object consultarCodigo(Integer codigo);
}
