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

public class IndiceImp implements Indice{
  EstructuraDatos estructura;
  Vector listaIndice;
  int numeroDeIndice;
  
  public IndiceImp(EstructuraDatos estructuraNuevo, int numeroDeIndiceNuevo) {
    estructura=estructuraNuevo;
  	listaIndice=new Vector();
  	numeroDeIndice=numeroDeIndiceNuevo;
  }

  public int dameTamaño(){
  	return this.listaIndice.size();    
  }

  
//////////////////////////////////////////////////////////////////
//BUSQUEDA
  
  public Vector dameElementos(){
  	Vector elementos=new Vector();
  	
  	return elementos;
  }
  
  
  public Vector buscar(Comparable claveBuscada){
  	int posicion = damePosicion(claveBuscada);
  	Vector elementosBuscados=new Vector();
  	//comprueba si existe algun elemento con esa clave
  	if (posicion!=-1){
  		int i=0;
  		boolean seguir=true;
  		NodoIndiceImp nodoIndiceActual=(NodoIndiceImp)listaIndice.get(posicion);
  		//introduce lo distintos objetos con la misma clave en un array 
  		while (seguir){
  			elementosBuscados.add(nodoIndiceActual.dameElemento());
  			i++;
  			seguir= posicion+i<dameTamaño();
  			//comprueba si el siguiente elemento tiene la misma clave
  			if (seguir){
  				nodoIndiceActual=(NodoIndiceImp)listaIndice.get(posicion+i);
  				seguir=nodoIndiceActual.claves[numeroDeIndice].equals(claveBuscada);
  			}
  		} 		
  	}
    return elementosBuscados;
  }


  //devuelve la posicion de una clave, si no esta devuelve -1
  int damePosicion(Comparable claveBuscada){
    int posicion = dondeIria(claveBuscada);
    if (posicion==-1 || posicion==dameTamaño()){
      return -1;
    }else if (!((NodoIndiceImp)listaIndice.get(posicion)).claves[numeroDeIndice].equals(claveBuscada)){
      return -1;
    }else{
      return posicion;
    }
  }

  //busca la posicion que le corresponderia en una lista del indice
  //(para insercion,eliminacion, busqueda), pero no asegura que este ahi
  public int dondeIria(Comparable claveBuscada){
    return busquedaBinaria(claveBuscada,0,dameTamaño()-1);
  }

  //metodo recursivo para realizar la busqueda
  int busquedaBinaria(Comparable claveBuscada, int inicio, int fin){
    if (inicio>fin){
      return inicio;
    }else{
      int posicion=(inicio+fin)/2;
      NodoIndiceImp nodoActual=(NodoIndiceImp)listaIndice.get(posicion);
      Comparable claveActual=nodoActual.claves[numeroDeIndice];
      int comparacion=claveActual.compareTo(claveBuscada);
      if (comparacion==0){
        return posicion;
      } if (comparacion>0){
        return busquedaBinaria(claveBuscada,inicio,posicion-1);
      }else{
        return busquedaBinaria(claveBuscada,posicion+1,fin);
      }
    }
  }

//////////////////////////////////////////////////////////////////
//INSERCION

  //inserta en toda la estructura asociada al indice 
  public void insertar(Comparable[] claves, Object elemento){
    //creamos un vector que contendra las posiciones donde se insertara
  	//el elemento en los distintos indices
  	int numeroDeIndices=estructura.dameNumeroIndices();
  	Indice[] todosLosIndices= new IndiceImp[numeroDeIndices];
  	int[] posiciones= new int[numeroDeIndices];
  	for (int i=0;i<numeroDeIndices;i++){
  		posiciones[i]=this.estructura.dameIndice(i).dondeIria(claves[i]);
  	}
  	Comparable[] clavesParaNodoIndice=(Comparable[])claves.clone();
  	//creamos el nodo que relaciona a todos los indices
	NodoIndiceImp nodoIndice = new NodoIndiceImp(clavesParaNodoIndice,elemento,posiciones,estructura);
	//añadimos el nodoIndice a los distintos indices de la estructura
	boolean bienInsertado=true;
	for (int i=0;i<numeroDeIndices;i++){
		bienInsertado=bienInsertado&&this.estructura.dameIndice(i).añadirNodoIndice(nodoIndice);
	}
  	if (bienInsertado){
  		System.out.println("El elemento ha sido insertado");
  	}else{
  		System.out.println("Ha habido algún problema en la inserción");
  	}
  }

  //el nodoIndice debe tener sus posiciones con los valores correctos
  public boolean añadirNodoIndice(NodoIndiceImp nodoIndice){
  	if (nodoIndice!=null){
  		return insertaPosicion(nodoIndice.posiciones[numeroDeIndice],nodoIndice);		
  	}
  	return false;
  }
  
  boolean insertaPosicion(int posicion,NodoIndiceImp nodoIndice){
    int tamaño=this.dameTamaño();
  	if (posicion<=tamaño){
  		//En todos los NodoIndiceImp que estan por encima del elemento 
    	//que vamos a insertar aumentamos en 1 la posicion en ese indice 
    	//de ese elemento 
    	for (int i=posicion;i<tamaño;i++){
    		((NodoIndiceImp)listaIndice.get(i)).cambiaPosicion(i+1,numeroDeIndice);
    	}
    	listaIndice.add(posicion,nodoIndice);	
    	return true;
    }
  	return false;
  }
  
//////////////////////////////////////////////////////////////////
//ELIMINACION
//elimina todos los accesos desde los distintos indices al NodoIndiceImp 
//que tenga igual la clave correspondiente a este indice
//devuelve el objeto que estaba asociado al nodoIndice
  
  public Object eliminar(Comparable clave){
    //con el valor devuelto se borrar los restantes
  	int posicion=damePosicion(clave);
  	boolean bienEliminado=(posicion!=-1);
  	if (bienEliminado){
  		NodoIndiceImp nodoIndice=(NodoIndiceImp)listaIndice.get(posicion);
  		Object elementoAEliminar=nodoIndice.dameElemento();
  		for (int i=0;i<this.estructura.dameNumeroIndices();i++){
  			bienEliminado=bienEliminado && this.estructura.dameIndice(i).eliminaNodoIndice(nodoIndice);		
  	  	}
  		System.out.println("Existe la clave ¿bien eliminado?"+bienEliminado);
    	return elementoAEliminar;
  	}else{
  		//la funcion elimina en los indices que puede y devuelve falso si no a podido eliminar alguno  	
  		System.out.println("No existe la clave");
  		return null;
  	}
  }

  public boolean eliminaNodoIndice(NodoIndiceImp nodoIndice){
  	if (nodoIndice!=null){
  		//Object elementoAEliminar=nodoIndice.dameElemento();
  		int posicionAEliminar=nodoIndice.posiciones[numeroDeIndice];
  		if (this.listaIndice.get(posicionAEliminar).equals(nodoIndice)){
  			return eliminaPosicion(posicionAEliminar);	
  		}else{
  			return false;
  		}
  	}else{
  		return false;
  	}
  }
  
  boolean eliminaPosicion(int posicion){
    int tamaño=dameTamaño();
    //eliminamos solo si existe la clave
    if (-1<posicion && posicion<tamaño){
    	//En todos los NodoIndiceImp que estan por encima del elemento 
    	//que vamos a insertar disminuimos en 1 la posicion en ese indice 
    	//de ese elemento 
    	for (int i=posicion+1;i<tamaño;i++){
    		((NodoIndiceImp)listaIndice.get(i)).cambiaPosicion(i-1, numeroDeIndice);
    	}
    	listaIndice.remove(posicion);
    	return true;
    }else{
    	
    	return false;
    }
  }
  
//////////////////////////////////////////////////////////////////
//CAMBIO
//cambia el valor de la clave de ese indice y reorganiza el indice,
//pero no cambia el valor del elemento asociado al NodoIndiceImp de la lista
//devuelve el elemnto cambiado, si no existe devuelve null;  
  
  public Object cambiar(Comparable clave, Comparable nuevaClave){
  	int tamaño=dameTamaño();
  	int posicion=damePosicion(clave);
  	if (-1<posicion && posicion<tamaño){
      NodoIndiceImp nodoIndice=(NodoIndiceImp)listaIndice.get(posicion);
      int nuevaPosicion=dondeIria(nuevaClave);
      Object elementoCambiado=cambiaPosicion(posicion,nuevaPosicion,nodoIndice);       
      System.out.println("Existe la clave antigua y ha sido cambiada por la nueva");         
      return elementoCambiado;
  	}else{
    	 System.out.println("No existe la clave antigua y no se ha realizado cambio");
    	return null;
    }
  }
  
  Object cambiaPosicion(int posicion,int nuevaPosicion,NodoIndiceImp nodoIndice){
  	int tamaño=dameTamaño();
  	if (-1<posicion && posicion<tamaño && -1< nuevaPosicion && nuevaPosicion<=tamaño){	
  		Object elementoCambiado=((NodoIndiceImp)listaIndice.get(posicion)).dameElemento();
  		//es importantante el orden entre insertar y eliminar, para que no varien las posiciones
  	  	boolean bienCambiado=true;
  		if (posicion<nuevaPosicion){
  			insertaPosicion(nuevaPosicion,nodoIndice);
			bienCambiado=eliminaPosicion(posicion);			 
  		}
  		if (posicion<nuevaPosicion){
  			eliminaPosicion(posicion);
  			bienCambiado=insertaPosicion(nuevaPosicion,nodoIndice);
  		}
  		
  		if (!bienCambiado){
  			System.out.println("Problema al cambiar la clave en el cambio de posición de los indices");
  		}
  	  	return elementoCambiado;
  	}
  	return null;
  }
  
  //MOSTRAR
  
  public void mostrarClavesOrdenadas(){
  	System.out.print("claves ordenadas por el indice "+this.numeroDeIndice+": ");
  	for (int i=0;i<listaIndice.size();i++){
  		NodoIndiceImp nodoIndiceActual=((NodoIndiceImp)listaIndice.get(i));
  		System.out.print(nodoIndiceActual.claves[numeroDeIndice]+ " -> " );
  	}
  	System.out.println();
  }
  
  
}