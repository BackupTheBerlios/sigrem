package med;

import java.util.Vector;

//La estructura de datos tiene distintos indices para acceder a los elementos
//Para movernos por la estructura de datos nos hace falta la clave y el indice donde se busca la clave
public interface EstructuraDatos {
  public int dameTamaño();
  public int dameNumeroIndices();
  Indice dameIndice(int indice);
  public Vector dameEliminados();
  
  public boolean esta(Comparable clave, int indice);
  public Vector buscar(Comparable clave, int indice);
  //Si no esta esa clave devuelve null

  public void insertar(Comparable[] claves, Object elemento);
  public void insertarAEliminados(Object elemento);
  public boolean eliminar(Comparable clave, int indice);
  
  
  public Object cambiarClaveDeIndice(Comparable clave, Comparable nuevaCla, int indice);
  //cambiar no cambia "ele" (de eso se tiene que encargar otro modulo),
  //solamente cambia la clave del indice y reorganiza la lista del indice.
}