package mco;

import med.*;
import interfaz.*;
import java.util.LinkedList;

//import mcl.*;

public class GContratosImp implements GContratos
{
	private EstructuraDatos listacontratos;
	
	private InterfazGrafica vista;
	
	private String codcontrato;
  
	public GContratosImp(InterfazGrafica vista,String codigo) 
	{
		codcontrato=codigo;
		listacontratos=new EstructuraDatosImp(2);
		this.vista=vista;
	}
	
	public String añadirContrato(LinkedList datos)
	{
		Contrato nuevocontrato=new Contrato(codcontrato,datos);
		//incfrementar codigo en 1
		String[] claves=new String[2];
		claves[0]=codcontrato;
		claves[1]=(String)datos.get(1);
		listacontratos.insertar(claves,nuevocontrato);
		//vista.actualizaVista(1,datos);
		return codcontrato;
	}
	
	public void eliminarContrato(Integer codigo)
	{
		
	}

	public void modificarContrato(Integer codigo)
	{
		
	}
	
	public void consultarContratoCodigo(Integer codigo)
	{
		
	}
	
	public void consultarContratoMatrícula(String matricula)
	{
		
	}
	
	
	
/*
	public boolean añadirContrato(Cliente cliente, Integer codigo,String matricula)
	{	//falta añadir todos los parametros de contrato
		Contrato nuevo=new Contrato(cliente,codigo,matricula);
		Comparable[] claves=null;
		claves[0]= nuevo.dameCodigo();
		claves[1]= nuevo.dameMatricula();
		if (consultarContratoCodigo((Integer)claves[0])==null && consultarContratoMatricula((String)claves[1])==null)
		{	contratos.insertar(claves,nuevo);
			//vista.actualizaContratos();
			//falta saber como se comunica con la interfaz
  	   		return true;
		}
		return false;
	}

	public boolean eliminarContrato(Integer codigo)
	{
		boolean eliminado=contratos.eliminar(codigo,0);
		if (eliminado) 
		{	//vista.actualizaContratos();
			//	falta saber como se comunica con la interfaz
		}
		return eliminado; 
	}


	public boolean modificarContrato(Integer codigoAntiguo,Cliente cliente, Integer codigoNuevo,String matriculaNuevo)
	{ 	//falta añadir todos los parametros de contrato
		Contrato nuevo=new Contrato(cliente,codigoNuevo,matriculaNuevo);
		Contrato antiguo=this.consultarContratoCodigo(codigoAntiguo);
		if (antiguo!=null)
		{	String matriculaAntiguo=antiguo.dameMatricula(); 
			//controla TODAS las posibles combinaciones de cambios de indice de codigo y matricula no permitidas
  			if (codigoNuevo!=codigoAntiguo){
  				if (matriculaNuevo!=matriculaAntiguo){
  					if (consultarContratoCodigo(codigoNuevo)==null && this.consultarContratoMatricula(matriculaNuevo)==null){
  						contratos.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);  	
  						contratos.cambiarClaveDeIndice(matriculaAntiguo,matriculaNuevo,1);
  					}else return false;
  				}else{
  					if (this.consultarContratoCodigo(codigoNuevo)==null){
  						contratos.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);
  					}else return false;
  				}
  			}else{
  				if (matriculaNuevo!=matriculaAntiguo){
  					if (this.consultarContratoMatricula(matriculaNuevo)==null){
  						contratos.cambiarClaveDeIndice(matriculaAntiguo,matriculaNuevo,1);
  					}else return false;
  				}
  			}
  			//vista.actualizaContratos();
  			//falta saber como se comunica con la interfaz
  			return true;
		}
		return false;
	}
  
	public Contrato consultarContratoCodigo(Integer codigo)
	{
		return (Contrato) this.contratos.buscar(codigo,0);
	}

  	public Contrato consultarContratoMatricula(String matricula)
  	{
  		return (Contrato) this.contratos.buscar(matricula,1);
  	}*/
  }