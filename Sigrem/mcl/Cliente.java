package mcl;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */


public class Cliente {
  Integer codigo;
  Integer dni;
  String nombre;
  ListaClientes lista=null;

  public Cliente(Integer cod, Integer d, String nom, ListaClientes lis) {
    //Es importante que en el modulo de gestion de clientes controle lo siguiente:
    //Si al construir un cliente este tiene asociada la lista null
    //quiere decir que no se debe usar ese cliente por tener un valor
    //de codigo o dni ya utilizado por otro cliente
    //(Excepto que la lista inialmente estuviese vacia,
    //que indica que cualquier cliente es valido)

    codigo=cod;
    dni=d;
    nombre=nom;
    if (lista.tieneCodigo(cod) || lista.tieneDni(d)){
      System.out.println("La lista ya tiene un cliente con ese dni o codigo");
      lista=null;
    }else{
      codigo=cod;
      dni=d;
      nombre=nom;
      lista=lis;
    }
  }

  public Integer dameCodigo(){
    return codigo;
  }

  public Integer dameDni(){
    return dni;
  }

  public String dameNombre(){
    return nombre;
  }

  public boolean cambiaCodigo(Integer cod){
    if (lista.tieneCodigo(cod)){
      System.out.println("La lista ya tiene un cliente con ese codigo");
      return false;
    }else{
      codigo=cod;
      return true;
    }
  }

  public boolean cambiaDni(Integer d){
    if (lista.tieneDni(d)){
      System.out.println("La lista ya tiene un cliente con ese codigo");
      return false;
    }else{
      dni=d;
      return true;
    }
  }

  public boolean cambiaNombre(String nom){
    nombre=nom;
    return true;
  }

}