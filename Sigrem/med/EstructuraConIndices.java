/*
 * Created on 14-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package med;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class EstructuraConIndices implements EstructuraDatos{
	  int tamaño=0;
	  Indice[] arrayIndices=null;

	  public EstructuraConIndices(int numeroDeIndices) {
	    if (numeroDeIndices<1){
	    	System.out.println("La lista tiene que tener por lo menos un indice");
	    }else{
	       	//crea los distintos indices que tendra la estructura
	    	for(int i=0;i<numeroDeIndices;i++){
	       		arrayIndices[i]=new IndiceImp(i,this);
	       	}
	    }
	  }

	  public int dameTamaño(){
	    return tamaño;
	  }

	  public int dameNumeroIndices(){
	  	return arrayIndices.length;
	  }
	  
//	BUSCAR
	  public boolean esta(Comparable clave, int indice){
	    return buscar(clave,indice)!=null;
	  }

	  
	  public Object[] buscar(Comparable clave, int indice){
	    return arrayIndices[indice].buscar(clave);
	  }

	  
//	INSERTAR
	  public void insertar(Comparable claves[], Object elemento){
	   this.insertar(claves,elemento);
	   tamaño++;
	  }
	  
	  
//	ELIMINAR
	  public boolean eliminar(Comparable clave,int indice){
	  	//eliminamos de los indices
	  	boolean eliminado=arrayIndices[indice].eliminar(clave);
	  	if(eliminado){
	  		tamaño--;
	  	}
	  	return eliminado;  
	  }

	 
//	CAMBIO
	  public boolean cambiarClaveDeIndice(Comparable clave, Comparable nuevaCla, int indice){
	    //Este metodo no cambia la clave dentro del objeto, solo lo cambia en el indice
	    return this.arrayIndices[indice].cambiar(clave,nuevaCla);
	  }
	}
