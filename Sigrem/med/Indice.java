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
  public NodoLista buscar(Comparable cla);
  //si no esta esa clave devuelve null
  
  public void insertar(Comparable[] cla, NodoLista nodo);
  //necesita recibir las claves para cada uno de sus indices
  
  public NodoLista eliminar(Comparable cla);
  //elimina todos sus indices y devuelve el nodo de la lista que debe ser eliminado
  
  public boolean cambiar(Comparable cla, Comparable nuevaCla);
  //este metodo cambia el indice pero no el valor interno del objeto
  //devuelve si ha podido o no hacer el cambio
}

