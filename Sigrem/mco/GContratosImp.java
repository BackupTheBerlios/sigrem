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

  public GContratosImp() {
    contratos=new ListaConIndices(2);
  }


  public void añadirContrato(Integer codigo,String matricula){
    Comparable claves[]=null;
    for(int i=0;i<2;i++){
    	claves[i]= new Integer(i);
    }
    claves[0]=codigo;
    claves[1]=matricula;
    Contrato contrato=controlador.ventanaAñadirContrato(codigo,matricula);
    contratos.insertar(claves,contrato);
  }

  public void eliminarContrato(Integer codigo){
    contratos.eliminar(codigo,0);
  }

  public void modificarContrato(Integer codigo){
    controlador.ventanaModificarContrato();
    //falta saber como se comunica con la interfaz

  }

  public Contrato consultarContratoCodigo(Integer codigo){
    return (Contrato) this.contratos.buscar(codigo,0);
  }

  public Contrato consultarContratoMatrícula(String matricula){
    return (Contrato) this.contratos.buscar(matricula,1);

  }

}