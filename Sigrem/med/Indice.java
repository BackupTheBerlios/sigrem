package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

import java.util.Vector;

public interface Indice {
	public int dameTamaño();
	
	public Vector dameElementos();
	//devuelve todos los elementos a los que apunta este indice
	
	public int dondeIria(Comparable claveBuscada);		
	
	public Vector buscar(Comparable clave);
	//si no esta esa clave el vector estara vacio 
	//(pero existira por lo que es distinto de null)
	
	public void insertar(Comparable[] clave, Object elemento);
	//necesita recibir las claves para cada uno de sus indices
  
	public boolean añadirNodoIndice(NodoIndiceImp nodoIndice);
	//necesita que el nodo sea distinto de null y tenga una posicion valida
	
	public Object eliminar(Comparable clave);
	//elimina el PRIMER elemento con esa clave de todos los indices existentes
	//devuelve el elemento eliminado, si no existe devuelve null
	
	public boolean eliminaNodoIndice(NodoIndiceImp nodoIndice);
	
	public Object cambiar(Comparable clave, Comparable nuevaCla);
	//este metodo cambia el indice pero no el valor del elemento asociado a nodoIndice
	//devuelve el elemento cambiado, si no existe devuelve null

	public void mostrarClavesOrdenadas();
		
	
}
