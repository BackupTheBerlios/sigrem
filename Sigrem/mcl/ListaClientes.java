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
    return clientes.buscar(cod,0)!=null;
  }

  public boolean tieneDni(Integer d){
    return clientes.buscar(d,1)!=null;
  }

  public boolean tieneNombre(String nom){
    return clientes.buscar(nom,2)!=null;
  }



}