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

//esta clase esta aqui de prueba
class Sigrem{
  Contrato ventanaAñadirContrato(Integer codigo, String matricula){
    return null;
  }
  void ventanaModificarContrato(){

  }
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

  public boolean añadirContrato(Contrato nuevo){
  //public void añadirContrato(Integer codigo,String matricula){
    Comparable[] claves=null;
    claves[0]= nuevo.dameCodigo();
    claves[1]= nuevo.dameMatricula();
    if (consultarContratoCodigo((Integer)claves[0])==null && consultarContratoMatricula((String)claves[1])==null){
    	contratos.insertar(claves,nuevo);
    	return true;
    }
    return false;
  }

  public boolean eliminarContrato(Integer codigo){
    return contratos.eliminar(codigo,0);
  }

  public boolean modificarContrato(Integer codigoAntiguo,Contrato nuevo){
    Contrato antiguo=this.consultarContratoCodigo(codigoAntiguo);
  	if (antiguo!=null){
  		String matriculaAntiguo=antiguo.dameMatricula(); 
  		Integer codigoNuevo=nuevo.dameCodigo();
  		String matriculaNuevo=nuevo.dameMatricula();
  		if (consultarContratoCodigo(codigoNuevo)==null && this.consultarContratoMatricula(matriculaNuevo)==null){
  			contratos.cambiarClaveDeIndice(codigoAntiguo,codigoNuevo,0);  	
  			contratos.cambiarClaveDeIndice(matriculaAntiguo,matriculaNuevo,1);
  			return true;
  		}
  		//vista.actualizaContratos();
		//falta saber como se comunica con la interfaz
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