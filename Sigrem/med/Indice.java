package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

import java.util.*;

public interface Indice {
	public int dameTamaño();
	
	public Vector dameTodos();
	
	public Object[] buscar(Comparable clave);
	//si no esta esa clave devuelve null
  
	public void insertar(Comparable[] clave, Object elemento);
	//necesita recibir las claves para cada uno de sus indices
  
	public Object eliminar(Comparable clave);
	//elimina el PRIMER elemento con esa clave de todos los indices existentes
  
	public boolean cambiar(Comparable clave, Comparable nuevaCla);
	//este metodo cambia el indice pero no el valor interno del objeto
	//devuelve si ha podido o no hacer el cambio
}
