package mco;

//import mcl.Cliente;
import java.util.LinkedList;

public interface GContratos 
{
	//Requisito 2.1
	public String aņadirContrato(LinkedList datos);
	//Requisito 2.2
	public void eliminarContrato(boolean borrar,String codigo);
	//Requisito 2.3
	public String modificarContrato(String codigo);
	//Requisito 2.4
	public String consultarContratoCodigo(boolean modificar,String codigo);
	//Requisito 2.5
	public void consultarContratoMatricula(String matricula);
}