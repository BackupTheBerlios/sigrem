package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

//La estructura de datos tiene distintos indices (indicados por "ind"),
//Para movernos por la estructura de datos nos hace falta la clave y el indice donde se busca la clave
public interface EstructuraDatos {
  public boolean esta(Comparable clave, int ind);
  public Object buscar(Comparable clave, int ind);
  //Si no esta esa clave devuelve null

  public void insertar(Comparable claves[], Object ele);
  public boolean eliminar(Comparable cla, int ind);
  
  public boolean cambiarClaveDeIndice(Comparable cla, Comparable nuevaCla, int ind);
  //cambiar no cambia "ele" (de eso se tiene que encargar otro modulo),
  //solamente cambia la clave del indice y reorganiza la lista del indice.
}