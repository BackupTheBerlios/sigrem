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
  ListaConIndices lista;
  NodoIndiceImp[] listaIndice;

  public IndiceImp(ListaConIndices lis) {
    //lis tiene que ser una lista vacia
  	lista=lis;
    listaIndice=null;
  }

  int dameTamaño(){
    return lista.dameTamaño();
  }
 
  void cambiaEspacio(int nuevoTamaño){
    //metodo para cambiar el espacio del vector estatico;
  	NodoIndiceImp[] nuevaListaIndice=new NodoIndiceImp[nuevoTamaño];
  	int tamaño=dameTamaño();
  	for (int i=0;i<tamaño;i++){
  		nuevaListaIndice[i]=listaIndice[i];
  	}
  	listaIndice=nuevaListaIndice;
  }
  
//////////////////////////////////////////////////////////////////
//BUSQUEDA
  public NodoLista buscar(Comparable cla){
    NodoIndiceImp nodoIndice=dameNodoIndice(cla);
    return nodoIndice.nodo;
  }

  //da el Nodo del Indice que tiene esa clave
  NodoIndiceImp dameNodoIndice(Comparable cla){
    int posicion = damePosicion(cla);
    if (posicion!=-1){
      return listaIndice[posicion];
    }else{
      return null;
    }
  }

  //devuelve la posicion de una clave, si no esta devuelve -1
  int damePosicion(Comparable cla){
    int posicion = dondeIria(cla);
    if (posicion==-1){
      return -1;
    }else if (listaIndice[posicion]==null){
      return -1;
    }else if (listaIndice[posicion].clave.equals(cla)){
      return -1;
    }else{
      return posicion;
    }
  }

  //busca la posicion que le corresponderia en una lista del indice
  //(para insercion,eliminacion, busqueda), pero no asegura que este ahi
  int dondeIria(Comparable cla){
    return busquedaBinaria(cla,0,lista.dameTamaño());
  }

  //metodo recursivo para realizar la busqueda
  int busquedaBinaria(Comparable cla, int ini, int fin){
    if (ini>fin){
      return ini;
    }else{
      int posicion=ini+fin/2;
      NodoIndiceImp nodoActual=listaIndice[posicion];
      Comparable claveActual=nodoActual.clave;
      int comparacion=claveActual.compareTo(cla);
      if (comparacion==0){
        return posicion;
      } if (comparacion>0){
        return busquedaBinaria(cla,ini,posicion-1);
      }else{
        return busquedaBinaria(cla,posicion+1,fin);
      }
    }
  }

//////////////////////////////////////////////////////////////////
//INSERCION

  //inserta en la lista del indice, pero no en la lista de elementos
  public void insertar(Comparable[] cla, NodoLista nodo){
    int[] posiciones= new int[cla.length];
  	NodoIndiceImp[] todosNodosIndice=new NodoIndiceImp[cla.length];
  	for (int i=0;i<lista.dameNumeroIndices();i++){
    	posiciones[i]=dondeIria(cla[i]);
    	todosNodosIndice[i]=new NodoIndiceImp(cla[i],nodo,todosNodosIndice,posiciones[i]);
    	this.insertaPosicion(posiciones[i],todosNodosIndice[i]);
  	}   
  }

  boolean insertaPosicion(int posicion,NodoIndiceImp nodoIndice){
    int tamaño=dameTamaño();
    if (posicion<=tamaño){
    	if (tamaño==listaIndice.length){
    		//aqui amplia el tamaño del array
    		cambiaEspacio(tamaño*2);
    	}
    	for (int i=tamaño;i>=posicion;i--){
    		listaIndice[i].posicion=listaIndice[i].posicion+1;
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


  public NodoLista eliminar(Comparable cla){
    //solo elimina en uno de los indices,
    //con el valor devuelto se borrar los restantes
  	int posicion=damePosicion(cla);
  	NodoLista nodoAEliminar=null;
  	boolean bienEliminado=(posicion!=-1);
  	if (bienEliminado){
  		NodoIndiceImp nodoIndice=listaIndice[posicion];
    	nodoAEliminar=nodoIndice.nodo;
        eliminaPosicion(posicion);	
    	for (int i=0;i<lista.dameNumeroIndices();i++){
    		bienEliminado=bienEliminado && this.eliminaPosicion(nodoIndice.indices[i].posicion);
    		
    	}
    }
    return nodoAEliminar;
  }

  boolean eliminaPosicion(int posicion){
    int tamaño=dameTamaño();
    if (-1<posicion && posicion<tamaño){
    	if (2*tamaño<listaIndice.length){
    		//aqui reduce el tamaño del array
    		cambiaEspacio(tamaño/2);
    	}
    	for (int i=posicion;i<tamaño;i++){
    		listaIndice[i+1].posicion=listaIndice[i+1].posicion-1;
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
  public boolean cambiar(Comparable cla, Comparable nuevaCla){
    int posicion=damePosicion(cla);
    if (posicion!=-1){
      NodoIndiceImp nodoIndice=this.listaIndice[posicion];
      int nuevaPosicion=dondeIria(nuevaCla);
      cambiaPosicion(posicion,nuevaPosicion,nodoIndice);       
      return true;
    }
    return false;
  }
  
  boolean cambiaPosicion(int pos,int nuevaPos,NodoIndiceImp nodoIndice){
  	int tamaño=dameTamaño();
  	if (-1<pos && pos<tamaño && -1< nuevaPos && nuevaPos<=tamaño){	
  		//es importantante el orden entre insertar y eliminar, para que no varien las posiciones
  	  	if (pos<nuevaPos){
  			insertaPosicion(nuevaPos,nodoIndice);
			eliminaPosicion(pos);			 
  		}else{
  			eliminaPosicion(pos);
  			insertaPosicion(nuevaPos,nodoIndice);
  		}
  		return true;
  	}
  	return false;
  }
  
}
