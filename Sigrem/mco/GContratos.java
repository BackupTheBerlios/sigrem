package mco;

//import mcl.Cliente;
import java.util.LinkedList;

public interface GContratos 
{
	//Requisito 2.1
	public String añadirContrato(LinkedList datos);
	//Requisito 2.2
	public void eliminarContrato(Integer codigo);
	//Requisito 2.3
	public void modificarContrato(Integer codigo);
	//Requisito 2.4
	public void consultarContratoCodigo(Integer codigo);
	//Requisito 2.5
	public void consultarContratoMatrícula(String matricula);
}