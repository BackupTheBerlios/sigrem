package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class NodoIndiceImp {
  int posicion;
  Comparable clave;
  NodoLista nodo;
  NodoIndiceImp indices[];
  public NodoIndiceImp(Comparable cla,NodoLista nod,NodoIndiceImp[] inds,int pos){
    clave=cla;
    nodo=nod;
    indices=inds;
    posicion=pos;
  }
}