package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

//Existe un NodoIndiceImp por cada elemento de cada estructura
//y son referenciados desde los distintos indices
public class NodoIndiceImp {
  Comparable[] claves;
  int[] posiciones;
  Object elemento;
  EstructuraDatos estructura;
    
  public NodoIndiceImp(Comparable[] clavesNuevo,Object elementoNuevo,int[] posicionesNuevo,EstructuraDatos estructuraNuevo){
    claves=clavesNuevo;
    posiciones=posicionesNuevo;
    elemento=elementoNuevo;
    estructura=estructuraNuevo;
  }
  
  
  public void cambiaClave(int indice, Comparable nuevaClave){
  	claves[indice]=nuevaClave;
  	
  }
  
  public void cambiaPosicion(int indice, int nuevaPosicion){
  	posiciones[indice]=nuevaPosicion;
  	
  }
  
  public Object dameElemento(){
  	return elemento;
  }
}