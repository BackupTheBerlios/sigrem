package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class NodoLista{
  Object elemento;
  NodoLista anterior;
  NodoLista siguiente;
  public NodoLista(Object ele, NodoLista ant, NodoLista sig){
    //La insercion crea nodos
    //Nunca debe crearse un nodo con un elemento no valido
    //(la explicacion de valido se entiende en la constructora de cliente,
    //el modulo de gestion de clientes debe encargarse evitar este problema)
    elemento=ele;
    anterior=ant;
    siguiente=sig;
  }
  
}