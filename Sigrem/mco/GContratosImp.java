package mco;

import med.*;
import interfaz.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class GContratosImp implements GContratos
{
	private EstructuraDatos listacontratos;
	
	private InterfazGrafica vista;
	
	private String codcontrato;
	
	private void incrementaCodigo()
	{
		String numero=codcontrato.substring(0,4);
		Character car=null;
		int num=car.digit(codcontrato.charAt(4),10);
		for (int i=5;i<codcontrato.length();i++)
		{	num=(num*10)+car.digit(codcontrato.charAt(i),10);}
		numero=numero+(num+1);
		codcontrato=numero;
	}
  
	public GContratosImp(InterfazGrafica vista,String codigo) 
	{
		codcontrato=codigo;
		listacontratos=new EstructuraDatosImp(2);
		this.vista=vista;
	}
	
	public String aņadirContrato(LinkedList datos)
	{
		Contrato nuevocontrato=new Contrato(codcontrato,datos);
		String[] claves=new String[2];
		claves[0]=codcontrato;
		claves[1]=(String)datos.get(1);
		listacontratos.insertar(claves,nuevocontrato);
		String codigoantiguo=codcontrato;
		incrementaCodigo();
		datos.addFirst(codigoantiguo);
		vista.actualizaVista(1,1,datos);
		return codigoantiguo;
	}
	
	public void eliminarContrato(boolean borrar, String codigo)
	{
		boolean eliminado=listacontratos.eliminar(codigo,0);
		if (eliminado) 
		{	vista.actualizaVistaMensaje("       Contrato "+codigo+" eliminado correctamente");
			if (borrar)
			{	vista.actualizaVista(1,1,null);
				vista.actualizaVista(1,2,null);				
			}
		}
		else vista.actualizaVistaMensaje("Error al eliminar el contrato "+codigo+". No se ha encontrado");
	}
	
	public void modificarContrato(String codigo,LinkedList datos)
	{
		vista.actualizaVista(1,1,datos);				
	}
	
	public String modificarFechaBaja(String codigo)
	{
		Object[] busqueda=listacontratos.buscar(codigo,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
			return null;			
		}
		else 
			if (busqueda[0]!=null)
			{	Contrato contrato=(Contrato)busqueda[0];
				Date hoy=new Date();
				SimpleDateFormat formato=new SimpleDateFormat("dd.MM.yyyy");
				contrato.setFechaBaja(formato.format(hoy));
				return contrato.getCodigoCliente();
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
				return null;
			}		
	}
	
	public String consultarContratoCodigo(boolean modificar,String codigo)
	{
		Object[] busqueda=listacontratos.buscar(codigo,0);
		if (busqueda.length==0)
		{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
			return null;			
		}
		else 
			if (busqueda[0]!=null)
			{	Contrato contrato=(Contrato)busqueda[0];
				if (modificar)
				{	LinkedList datos=new LinkedList();
					datos.add(contrato.getCodigoContrato());
					datos.add(contrato.getCodigoCliente());
					datos.add(contrato.getMatricula());
					datos.add(contrato.getFechaAlta());
					vista.actualizaVistaDatos(1,datos,false);
				}
				else
				{	vista.actualizaVista(1,1,contrato.getListaDatos());}
				return contrato.getCodigoCliente();
			}
			else
			{	vista.actualizaVistaMensaje("Error al buscar el contrato "+codigo+". No se ha encontrado");
			return null;
			}		
	}
	
	public void consultarContratoMatricula(String matricula)
	{
		
	}
	
	
	
/*
	public boolean aņadirContrato(Cliente cliente, Integer codigo,String matricula)
	{	//falta aņadir todos los parametros de contrato
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
	{ 	//falta aņadir todos los parametros de contrato
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