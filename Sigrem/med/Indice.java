package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */




public interface Indice {
  public Object dameElemento(Comparable cla);

  public NodoIndiceImp insertarEnIndice(Comparable cla, NodoLista nodo);

  public NodoIndiceImp eliminaEnIndice(Comparable cla);
  public boolean eliminaPosicion(int posicion);

  public boolean cambioEnIndice(Comparable cla, Comparable nuevaCla);
}

