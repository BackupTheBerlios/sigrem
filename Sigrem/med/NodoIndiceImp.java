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
    
  public NodoIndiceImp(Comparable[] clavesInicio,Object elementoInicio,int[] posicionesInicio,EstructuraDatos estructuraInicio){
    claves=clavesInicio;	
    posiciones=posicionesInicio;
    elemento=elementoInicio;
    estructura=estructuraInicio;   
  }
  
   	
  public void cambiaClave(Comparable nuevaClave, int indice){
  	claves[indice]=nuevaClave;
  	
  }
  
  public void cambiaPosicion(int nuevaPosicion, int indice){
  	posiciones[indice]=nuevaPosicion;
  	
  }
  
  public Object dameElemento(){
  	return elemento;
  }
}