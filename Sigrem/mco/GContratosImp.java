package mco;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
import med.*;
import interfaz.*;
import mcl.*;


//esta clase esta aqui de prueba
class Sigrem{
}

public class GContratosImp {
  EstructuraDatos contratos;
  Sigrem controlador;
  InterfazGrafica vista; 
  
  public GContratosImp(Sigrem con, InterfazGrafica vis) {
    contratos=new ListaConIndices(2);
    controlador=con;
    vista=vis;
  }

  public boolean añadirContrato(Cliente cliente, Integer codigo,String matricula){
    //falta añadir todos los parametros de contrato
  	Contrato nuevo=new ContratoImp(cliente,codigo,matricula);
  	Comparable[] claves=null;
    claves[0]= nuevo.dameCodigo();
    claves[1]= nuevo.dameMatricula();
    if (consultarContratoCodigo((Integer)claves[0])==null && consultarContratoMatricula((String)claves[1])==null){
    	contratos.insertar(claves,nuevo);
    	//vista.actualizaContratos();
		//falta saber como se comunica con la interfaz
  	   	return true;
    }
    return false;
  }

  public boolean eliminarContrato(Integer codigo){
    boolean eliminado=contratos.eliminar(codigo,0);
  	if (eliminado) {
  		//vista.actualizaContratos();
		//falta saber como se comunica con la interfaz
  	}
  	return eliminado; 
    
  }


  public boolean modificarContrato(Integer codigoAntiguo,Cliente cliente, Integer codigoNuevo,String matriculaNuevo){
   	//falta añadir todos los parametros de contrato
  	Contrato nuevo=new ContratoImp(cliente,codigoNuevo,matriculaNuevo);
  	Contrato antiguo=this.consultarContratoCodigo(codigoAntiguo);
  	if (antiguo!=null){
  		String matriculaAntiguo=antiguo.dameMatricula(); 
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

  
  public Contrato consultarContratoCodigo(Integer codigo){
    return (Contrato) this.contratos.buscar(codigo,0);
  }

  
  public Contrato consultarContratoMatricula(String matricula){
    return (Contrato) this.contratos.buscar(matricula,1);

  }

}