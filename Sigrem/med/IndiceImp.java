package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class IndiceImp implements Indice{
  EstructuraDatos estructura;
  NodoIndiceImp[] listaIndice;
  int numeroDeIndice;
  
  public IndiceImp(int numeroDeIndiceNuevo, EstructuraDatos estructuraNuevo) {
    estructura=estructuraNuevo;
  	listaIndice=null;
  	numeroDeIndice=numeroDeIndiceNuevo;
  }

  int dameTama�o(){
    return estructura.dameTama�o();
  }
 
//metodo para cambiar el espacio del vector estatico;
  void cambiaEspacio(int nuevoTama�o){
    NodoIndiceImp[] nuevaListaIndice=new NodoIndiceImp[nuevoTama�o];
  	int tama�o=dameTama�o();
  	for (int i=0;i<tama�o;i++){
  		nuevaListaIndice[i]=listaIndice[i];
  	}
  	listaIndice=nuevaListaIndice;
  }
  
//////////////////////////////////////////////////////////////////
//BUSQUEDA
  public Object[] buscar(Comparable claveBuscada){
  	int posicion = damePosicion(claveBuscada);
  	Object[] elementosBuscados=new Object[dameTama�o()];
  	//comprueba si existe algun elemento con esa clave
  	if (posicion!=-1){
  		int i=0;
  		boolean seguir=true;
  		NodoIndiceImp nodoIndiceActual=listaIndice[posicion];
  		//introduce lo distintos objetos con la misma clave en un array 
  		while (seguir){
  			elementosBuscados[i]=nodoIndiceActual.elemento;
  			i++;
  			seguir= posicion+i<dameTama�o();
  			//comprueba si el siguiente elemento tiene la misma clave
  			if (seguir){
  				nodoIndiceActual=listaIndice[posicion+i];
  				seguir=nodoIndiceActual.claves[numeroDeIndice].equals(claveBuscada);
  			}
  		} 		
  	}
    return elementosBuscados;
  }


  //devuelve la posicion de una clave, si no esta devuelve -1
  int damePosicion(Comparable claveBuscada){
    int posicion = dondeIria(claveBuscada);
    if (posicion==-1){
      return -1;
    }else if (listaIndice[posicion]==null){
      return -1;
    }else if (!listaIndice[posicion].claves[numeroDeIndice].equals(claveBuscada)){
      return -1;
    }else{
      return posicion;
    }
  }

  //busca la posicion que le corresponderia en una lista del indice
  //(para insercion,eliminacion, busqueda), pero no asegura que este ahi
  int dondeIria(Comparable claveBuscada){
    return busquedaBinaria(claveBuscada,0,dameTama�o());
  }

  //metodo recursivo para realizar la busqueda
  int busquedaBinaria(Comparable claveBuscada, int inicio, int fin){
    if (inicio>fin){
      return inicio;
    }else{
      int posicion=inicio+fin/2;
      NodoIndiceImp nodoActual=listaIndice[posicion];
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
  }

  boolean insertaPosicion(int posicion,NodoIndiceImp nodoIndice){
    int tama�o=dameTama�o();
    if (posicion<=tama�o){
    	if (tama�o==listaIndice.length){
    		//aqui amplia el tama�o del array
    		cambiaEspacio(tama�o*2);
    	}
    	//recolocamos todos los valores del indice avanzandolos una posicion 
    	//por encima del nuevo valor 
    	for (int i=tama�o;i>=posicion;i--){
    		listaIndice[i].posiciones[numeroDeIndice]=listaIndice[i].posiciones[numeroDeIndice]+1;
    		listaIndice[i+1]=listaIndice[i];
    	}
    	listaIndice[posicion]=nodoIndice;	
    	return true;
    }
    return false;
  }
  
//////////////////////////////////////////////////////////////////
//ELIMINACION
//elimina una clave del indice,
//pero no toca la lista, ni el resto de los indices


  public boolean eliminar(Comparable clave){
    //solo elimina en uno de los indices,
    //con el valor devuelto se borrar los restantes
  	int posicion=damePosicion(clave);
  	boolean bienEliminado=(posicion!=-1);
  	if (bienEliminado){
  		NodoIndiceImp nodoIndice=listaIndice[posicion];
    	for (int i=0;i<estructura.dameNumeroIndices();i++){
    		bienEliminado=bienEliminado && this.eliminaPosicion(nodoIndice.posiciones[i]);
    	}
    }
    //la funcion elimina en los indices que puede y devuelve falso si no a podido eliminar alguno  	
  	return bienEliminado;
  }

  boolean eliminaPosicion(int posicion){
    int tama�o=dameTama�o();
    //eliminamos solo si existe la clave
    if (-1<posicion && posicion<tama�o){
    	if (2*tama�o<listaIndice.length){
    		//aqui reduce el tama�o del array
    		cambiaEspacio(tama�o/2);
    	}
    	//recolocamos todos los valores del indice que esten por encima del valor eliminado
    	for (int i=posicion;i<tama�o;i++){
    		listaIndice[i+1].posiciones[numeroDeIndice]=listaIndice[i+1].posiciones[numeroDeIndice]-1;
    		listaIndice[i]=listaIndice[i+1];
    	}
    	return true;
    }
    return false;
  }
  
//////////////////////////////////////////////////////////////////
//CAMBIO
//cambia el valor de la clave de ese indice y reorganiza el indice,
//pero no cambia el valor del elemnto de la lista;
  public boolean cambiar(Comparable clave, Comparable nuevaClave){
  	int tama�o=dameTama�o();
  	int posicion=damePosicion(clave);
    if (-1<posicion && posicion<tama�o){
      NodoIndiceImp nodoIndice=this.listaIndice[posicion];
      int nuevaPosicion=dondeIria(nuevaClave);
      cambiaPosicion(posicion,nuevaPosicion,nodoIndice);       
      return true;
    }
    return false;
  }
  
  boolean cambiaPosicion(int posicion,int nuevaPosicion,NodoIndiceImp nodoIndice){
  	int tama�o=dameTama�o();
  	if (-1<posicion && posicion<tama�o && -1< nuevaPosicion && nuevaPosicion<=tama�o){	
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
