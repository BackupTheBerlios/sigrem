package mcl;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

import med.*;

public class ListaClientes  {
  EstructuraDatos clientes;

  public ListaClientes() {
    clientes=new ListaConIndices(3);
  }

////////////////////////////////////////////////////
///FUNCIONES PARA OBSERVAR EL CONTENIDO DE LA LISTA


  public boolean tieneCodigo(Integer cod){
    return clientes.estaEnIndice(cod,1);
  }

  public boolean tieneDni(Integer d){
    return clientes.estaEnIndice(d,2);
  }

  public boolean tieneNombre(String nom){
    return clientes.estaEnIndice(nom,3);
  }



}