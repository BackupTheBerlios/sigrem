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
  int numeroIndices=0;
  int tamaño=0;
  NodoLista lista=null;
  Indice listaIndices[]=null;

  public ListaConIndices(int num) {
    if (num<1){
      System.out.println("La lista tiene que tener por lo menos un indice");
    }else{
      numeroIndices=num;
      for(int i=0;i<numeroIndices;i++){
        listaIndices[i]=new IndiceImp(this);
      }
    }
  }

  public int dameTamaño(){
    return tamaño;
  }


//BUSCAR
  public Object buscar(Comparable cla, int ind){
    return listaIndices[ind].dameElemento(cla);
  }

  public boolean estaEnIndice(Comparable cla, int ind){
    return listaIndices[ind].dameElemento(cla)!=null;
  }



//INSERTAR
  public void insertar(Comparable claves[], Object ele){
   //Es una lista doblemente enlazada NO circular
   //en los extremos metemos null, si lista esta vacia apunta a null;
   NodoLista nuevoNodo = new NodoLista(ele,null,lista);
   if (tamaño==0){
     lista=nuevoNodo;
   }else{
     lista.anterior=nuevoNodo;
     lista=nuevoNodo;
   }
   for (int i=0;i<numeroIndices;i++){
     listaIndices[i].insertarEnIndice(claves[i],nuevoNodo);
   }
   tamaño++;
  }

//ELIMINAR
  public boolean eliminar(Comparable cla,int ind){
    //eliminamos del indice indicado
    NodoIndiceImp nodoIndice=listaIndices[ind].eliminaEnIndice(cla);
    if (nodoIndice!=null){
      for (int i=0;i<this.listaIndices.length;i++){
        if (i!=ind){
          //eliminamos del resto de indices
          this.listaIndices[i].eliminaPosicion(nodoIndice.indices[i].posicion);
        }
      }
      //eliminamos de la lista
      eliminarNodo(nodoIndice.nodo);
      tamaño--;
      return true;
    }
    return false;
  }

  public void eliminarNodo(NodoLista nodo){
    if (nodo.siguiente!=null){
      nodo.siguiente.anterior=nodo.anterior;
    }
    if (nodo.anterior!=null){
      nodo.anterior.siguiente=nodo.siguiente;
    }else{
      lista=nodo.siguiente;
    }
  }

 /*
  public boolean eliminar(Comparable cla,int ind){
    NodoIndice nodoActual;
    boolean eliminado=false;
    for (int i=0;i<numeroIndices;i++){
      eliminado=eliminado && listaIndices[ind].eliminaEnIndice(cla,ele);
    }
    tamaño--;
    return eliminado;
  }
*/

//CAMBIO
  public void cambiarClaveIndice(Comparable cla, Comparable nuevaCla, int ind){
    //Este metodo no cambia la clave dentro del objeto, solo lo cambia en el indice
    this.listaIndices[ind].cambioEnIndice(cla,nuevaCla);
  }
}