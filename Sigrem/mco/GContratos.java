package mco;

//import mcl.Cliente;
import java.util.LinkedList;

public interface GContratos 
{
	//Requisito 2.1
	public String añadirContrato(LinkedList datos);
	//Requisito 2.2
	public void eliminarContrato(boolean borrar,String codigo);
	//Requisito 2.3
	public void modificarContrato(String codigo,LinkedList datos);
	//Requisito 2.4
	public String consultarContratoCodigo(boolean modificar,String codigo);
	//Requisito 2.5
	public String consultarContratoMatricula(String matricula);
	
	public String modificarFechaBaja(String codigo);
}