package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
import java.util.*;

public class IndiceImp implements Indice{
  EstructuraDatos estructura;
  Vector listaIndice;
  int numeroDeIndice;
  
  public IndiceImp(int numeroDeIndiceNuevo, EstructuraDatos estructuraNuevo) {
    estructura=estructuraNuevo;
  	listaIndice=new Vector();
  	numeroDeIndice=numeroDeIndiceNuevo;
  }

  public int dameTamaño(){
  	return this.listaIndice.size();    
  }
/* 
//metodo para cambiar el espacio del vector estatico;
  void cambiaEspacio(int nuevoTamaño){
    NodoIndiceImp[] nuevaListaIndice=new NodoIndiceImp[nuevoTamaño];
  	int tamaño=dameTamaño();
  	for (int i=0;i<tamaño;i++){
  		nuevaListaIndice[i]=listaIndice[i];
  	}
  	listaIndice=nuevaListaIndice;
  }
  */
  
//////////////////////////////////////////////////////////////////
//BUSQUEDA
  public Vector dameTodos(){
  	int numeroElementos=dameTamaño();
   	Vector todosElementos=new Vector(numeroElementos);
  	for(int i=0;i<numeroElementos;i++){
  		todosElementos.add(((NodoIndiceImp)this.listaIndice.get(i)).dameElemento());
  	}
  	return todosElementos;
  }
  
  
  
  public Object[] buscar(Comparable claveBuscada){
  	int posicion = damePosicion(claveBuscada);
  	Object[] elementosBuscados=new Object[dameTamaño()];
  	//comprueba si existe algun elemento con esa clave
  	if (posicion!=-1){
  		int i=0;
  		boolean seguir=true;
  		NodoIndiceImp nodoIndiceActual=(NodoIndiceImp)listaIndice.get(posicion);
  		//introduce lo distintos objetos con la misma clave en un array 
  		while (seguir){
  			elementosBuscados[i]=nodoIndiceActual.dameElemento();
  			i++;
  			seguir= posicion+i<dameTamaño();
  			//comprueba si el siguiente elemento tiene la misma clave
  			if (seguir){
  				nodoIndiceActual=(NodoIndiceImp)listaIndice.get(posicion+i);
  				seguir=nodoIndiceActual.claves[numeroDeIndice].equals(claveBuscada);
  			}
  		} 		
  	}
    return elementosBuscados;
  }


  //devuelve la posicion de una clave, si no esta devuelve -1
  int damePosicion(Comparable claveBuscada){
    int posicion = dondeIria(claveBuscada);
    if (posicion==-1 || posicion==dameTamaño()){
      return -1;
    }else if (!((NodoIndiceImp)listaIndice.get(posicion)).claves[numeroDeIndice].equals(claveBuscada)){
      return -1;
    }else{
      return posicion;
    }
  }

  //busca la posicion que le corresponderia en una lista del indice
  //(para insercion,eliminacion, busqueda), pero no asegura que este ahi
  int dondeIria(Comparable claveBuscada){
    return busquedaBinaria(claveBuscada,0,dameTamaño()-1);
  }

  //metodo recursivo para realizar la busqueda
  int busquedaBinaria(Comparable claveBuscada, int inicio, int fin){
    if (inicio>fin){
      return inicio;
    }else{
      int posicion=(inicio+fin)/2;
      NodoIndiceImp nodoActual=(NodoIndiceImp)listaIndice.get(posicion);
      Comparable claveActual=nodoActual.claves[numeroDeIndice];
      int comparacion=claveActual.compareTo(claveBuscada);
      if (comparacion==0){
        return posicion;
      } if (comparacion>0){
        return busquedaBinaria(claveBuscada,inicio,posicion-1);
      }else{
        return busquedaBinaria(claveBuscada,posicion+1,fin);
      }
    }
  }

//////////////////////////////////////////////////////////////////
//INSERCION

  //inserta en la lista del indice, pero no en la lista de elementos
  public void insertar(Comparable[] claves, Object elemento){
    //creamos un vector que contendra las posiciones donde se insertara
  	//el elemento en los distintos indices
  	int[] posiciones= new int[claves.length];
  	//creamos el nodo que relaciona a todos los indices
	NodoIndiceImp nodoIndice = new NodoIndiceImp(claves,elemento,posiciones,estructura);
  	//colocamos los indices del elemento y actualizamos las posiciones del nodoIndice
	for (int i=0;i<estructura.dameNumeroIndices();i++){
		posiciones[i]=dondeIria(claves[i]);
    	this.insertaPosicion(posiciones[i],nodoIndice);
  	}
	System.out.println("El elemento ha sido insertado");
  }

  boolean insertaPosicion(int posicion,NodoIndiceImp nodoIndice){
    int tamaño=this.listaIndice.size();
  	if (posicion<=tamaño){
    	//En todos los NodoIndiceImp que estan por encima del elemento 
    	//que vamos a insertar aumentamos en 1 la posicion en ese indice 
    	//de ese elemento 
    	for (int i=posicion;i<tamaño;i++){
    		((NodoIndiceImp)listaIndice.get(i)).cambiaPosicion(numeroDeIndice,i+1);
    	}
    	listaIndice.add(posicion,nodoIndice);	
    	return true;
    }
    return false;
  }
  
//////////////////////////////////////////////////////////////////
//ELIMINACION
//elimina una clave del indice,
//pero no toca la lista, ni el resto de los indices


  public Object eliminar(Comparable clave){
    //solo elimina en uno de los indices,
    //con el valor devuelto se borrar los restantes
  	int posicion=damePosicion(clave);
  	boolean bienEliminado=(posicion!=-1);
  	NodoIndiceImp nodoIndice=null;
  	if (bienEliminado){
  		nodoIndice=(NodoIndiceImp)listaIndice.get(posicion);
    	for (int i=0;i<estructura.dameNumeroIndices();i++){
    		bienEliminado=bienEliminado && this.eliminaPosicion(nodoIndice.posiciones[i]);
    	}
    	System.out.println("Existe la clave ¿bien eliminado?"+bienEliminado);
    	return nodoIndice.dameElemento();
  	}else{
  		//la funcion elimina en los indices que puede y devuelve falso si no a podido eliminar alguno  	
  		System.out.println("No existe la clave");
  		return null;
  	}
  }

  boolean eliminaPosicion(int posicion){
    int tamaño=dameTamaño();
    //eliminamos solo si existe la clave
    if (-1<posicion && posicion<tamaño){
    	//En todos los NodoIndiceImp que estan por encima del elemento 
    	//que vamos a insertar disminuimos en 1 la posicion en ese indice 
    	//de ese elemento 
    	for (int i=posicion+1;i<tamaño;i++){
    		((NodoIndiceImp)listaIndice.get(i)).cambiaPosicion(numeroDeIndice,i-1);
    	}
    	listaIndice.remove(posicion);
    	return true;
    }else{
    	return false;
    }
  }
  
//////////////////////////////////////////////////////////////////
//CAMBIO
//cambia el valor de la clave de ese indice y reorganiza el indice,
//pero no cambia el valor del elemnto de la lista;
  public boolean cambiar(Comparable clave, Comparable nuevaClave){
  	int tamaño=dameTamaño();
  	int posicion=damePosicion(clave);
    if (-1<posicion && posicion<tamaño){
      NodoIndiceImp nodoIndice=(NodoIndiceImp)listaIndice.get(posicion);
      int nuevaPosicion=dondeIria(nuevaClave);
      cambiaPosicion(posicion,nuevaPosicion,nodoIndice);       
      System.out.println("Existe la clave antigua y ha sido cambiada por la nueva");
      return true;
      
    }else{
    	 System.out.println("No existe la clave antigua y no se ha realizado cambio");
    	return false;
    }
  }
  
  boolean cambiaPosicion(int posicion,int nuevaPosicion,NodoIndiceImp nodoIndice){
  	int tamaño=dameTamaño();
  	if (-1<posicion && posicion<tamaño && -1< nuevaPosicion && nuevaPosicion<=tamaño){	
  		//es importantante el orden entre insertar y eliminar, para que no varien las posiciones
  	  	if (posicion<nuevaPosicion){
  			insertaPosicion(nuevaPosicion,nodoIndice);
			eliminaPosicion(posicion);			 
  		}else{
  			eliminaPosicion(posicion);
  			insertaPosicion(nuevaPosicion,nodoIndice);
  		}
  		return true;
  	}
  	return false;
  }
  
}