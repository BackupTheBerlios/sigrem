package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ListaConIndices implements EstructuraDatos{
  int tamaño=0;
  NodoLista lista=null;
  Indice[] listaIndices=null;

  public ListaConIndices(int num) {
    if (num<1){
      System.out.println("La lista tiene que tener por lo menos un indice");
    }else{
      for(int i=0;i<num;i++){
        listaIndices[i]=new IndiceImp(this);
      }
    }
  }

  public int dameTamaño(){
    return tamaño;
  }

  public int dameNumeroIndices(){
  	return listaIndices.length;
  }
  
//BUSCAR
  public Object buscar(Comparable cla, int ind){
    return listaIndices[ind].buscar(cla).elemento;
  }

  
//INSERTAR
  public void insertar(Comparable claves[], Object ele){
   //Es una lista doblemente enlazada NO circular
   //en los extremos metemos null, si lista esta vacia apunta a null;
   NodoLista nuevoNodo = añadirNodo(ele);
   this.insertar(claves,nuevoNodo);
  }
  
  NodoLista añadirNodo(Object ele){
    NodoLista nuevoNodo= new NodoLista(ele,null,null);
  	if (lista!=null){
  	  lista.anterior=nuevoNodo;
    }
    lista=nuevoNodo;
    tamaño++;
    return nuevoNodo;
  }

//ELIMINAR
  public boolean eliminar(Comparable cla,int ind){
  	//eliminamos de los indices
  	NodoLista nodoLista=listaIndices[ind].eliminar(cla);
    if (nodoLista!=null){
    	//eliminamos de la lista
    	eliminarNodo(nodoLista);
    	return true;
    }
    return false;
  }

  void eliminarNodo(NodoLista nodo){
    if (nodo.siguiente!=null){
      nodo.siguiente.anterior=nodo.anterior;
    }
    if (nodo.anterior!=null){
      nodo.anterior.siguiente=nodo.siguiente;
    }else{
      lista=nodo.siguiente;
    }
    tamaño--;
  }

 
//CAMBIO
  public void cambiarClaveDeIndice(Comparable cla, Comparable nuevaCla, int ind){
    //Este metodo no cambia la clave dentro del objeto, solo lo cambia en el indice
    this.listaIndices[ind].cambiar(cla,nuevaCla);
  }
}