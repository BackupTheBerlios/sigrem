package med;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class IndiceImp implements Indice{
  ListaConIndices lista;
  NodoIndiceImp listaIndice[];

  public IndiceImp(ListaConIndices lis) {
    lista=lis;
    //no recuerdo como se crea un vector
  }

  int dameTamaño(){
    return lista.dameTamaño();
  }

  void divideEspacio(){
    //metodo para dividir el espacio del vector estatico;
  }


  void duplicaEspacio(){
    //metodo para duplicar el espacio del vector estatico;
  }


//////////////////////////////////////////////////////////////////
//BUSQUEDA
  public Object dameElemento(Comparable cla){
    NodoLista nodo=dameNodoLista(cla);
    if (nodo==null)
      return null;
    else
      return nodo.elemento;
  }


  //da un Nodo de la lista, si no esta devuelve null
  public NodoLista dameNodoLista(Comparable cla){
    NodoIndiceImp nodoIndice=dameNodoIndice(cla);
    if (nodoIndice==null)
      return null;
    else
      return nodoIndice.nodo;
  }

  //da el Nodo del Indice que tiene esa clave
  public NodoIndiceImp dameNodoIndice(Comparable cla){
    int posicion = estaClave(cla);
    if (posicion!=-1){
      return listaIndice[posicion];
    }else{
      return null;
    }
  }


  //devuelve la posicion de una clave, si no esta devuelve -1
  int estaClave(Comparable cla){
    int posicion = dondeIria(cla);
    if (posicion==-1){
      return -1;
    }else if (listaIndice[posicion]==null){
      return -1;
    }else if (listaIndice[posicion].clave.equals(cla)){
      return -1;
    }else{
      return posicion;
    }
  }

  //busca la posicion que le corresponderia en una lista del indice
  //(para insercion,eliminacion, busqueda), pero no asegura que este ahi
  int dondeIria(Comparable cla){
    return busquedaBinaria(cla,0,lista.dameTamaño());
  }

  //metodo recursivo para realizar la busqueda
  int busquedaBinaria(Comparable cla, int ini, int fin){
    if (ini>fin){
      return ini;
    }else{
      int posicion=ini+fin/2;
      NodoIndiceImp nodoActual=listaIndice[posicion];
      Comparable claveActual=nodoActual.clave;
      int comparacion=claveActual.compareTo(cla);
      if (comparacion==0){
        return posicion;
      } if (comparacion>0){
        return busquedaBinaria(cla,ini,posicion-1);
      }else{
        return busquedaBinaria(cla,posicion+1,fin);
      }
    }
  }

//////////////////////////////////////////////////////////////////
//INSERCION

  //inserta en la lista del indice, pero no en la lista de elementos
  public NodoIndiceImp insertarEnIndice(Comparable cla, NodoLista nodo){
    if (lista.dameTamaño()==listaIndice.length){
      duplicaEspacio();
    }
    int posicion=dondeIria(cla);
    for (int i=lista.dameTamaño();i>=posicion;i--){
      listaIndice[i+1]=listaIndice[i];
    }
    NodoIndiceImp nuevoNodoIndice=new NodoIndiceImp(cla,nodo,null,posicion);
    listaIndice[posicion]=nuevoNodoIndice;
    return nuevoNodoIndice;
  }

//////////////////////////////////////////////////////////////////
//ELIMINACION
//elimina una clave del indice,
//pero no toca la lista, ni el resto de los indices


  public NodoIndiceImp eliminaEnIndice(Comparable cla){
    //solo elimina en uno de los indices,
    //con el valor devuelto se borrar los restantes
    int posicion=estaClave(cla);
    int tamaño=dameTamaño();
    if (posicion!=-1){
      eliminaPosicion(posicion);
      if (2*tamaño<listaIndice.length){
        //aqui reduce el tamaño del array
        divideEspacio();
      }
      return listaIndice[posicion];
    }
    return null;
  }

  public boolean eliminaPosicion(int posicion){
    int tamaño=dameTamaño();
    if (posicion<tamaño){
      for (int i=posicion;i<tamaño;i++){
        listaIndice[i]=listaIndice[i+1];
      }
      return true;
    }else return false;
  }
  /*  public boolean eliminaEnIndice(Comparable cla, Object ele){
  int posicion=estaClave(cla);
  int tamaño=dameTamaño();
  if (posicion!=-1){
        NodoIndice nodoActual=listaIndice[posicion];
        Object elementoActual=nodoActual.elemento;
        boolean continuar=!elementoActual.equals(ele);
        while (continuar && posicion+1<tamaño){
          posicion++;
          nodoActual = listaIndice[posicion];
          elementoActual = nodoActual.elemento;
          continuar = nodoActual.clave.compareTo(cla)==0 && !elementoActual.equals(ele);
        }
        if (elementoActual.equals(ele)){
          for (int i=posicion; i<tamaño-1; i++){
            listaIndice[i]=listaIndice[i+1];
          }
          if (2*tamaño<listaIndice.length){
            //aqui reduce el tamaño del array
            divideEspacio();
          }
          return true;
        }
      }
      return false;
    }
  */

//////////////////////////////////////////////////////////////////
//CAMBIO
//cambia el valor de la clave de ese indice y reorganiza el indice,
//pero no cambia el valor del elemnto de la lista;
  public boolean cambioEnIndice(Comparable cla, Comparable nuevaCla){
    int posicion=estaClave(cla);
    if (posicion!=-1){
      NodoIndiceImp nodoIndiceActual=this.listaIndice[posicion];
      int nuevaPosicion=dondeIria(nuevaCla);
      if (posicion<nuevaPosicion){
        for (int i=posicion;i<nuevaPosicion-1;i++){
          listaIndice[i]=listaIndice[i+1];
        }
        listaIndice[nuevaPosicion]= nodoIndiceActual;
      }else if (posicion>nuevaPosicion){
        for (int i=posicion;i>nuevaPosicion;i--){
          listaIndice[i]=listaIndice[i-1];
        }
        listaIndice[nuevaPosicion]= nodoIndiceActual;
      }
      nodoIndiceActual.clave=nuevaCla;
      //esto solo cambia de la clave del indice,
      //pero no cambia el valor dentro del objeto por no poder acceder a él
      //(por ser Object)
      return true;
    }
    return false;
  }

  /*  public boolean cambioEnIndice(Comparable cla, Comparable nuevaCla, Object ele){
        int posicion=estaClave(cla);
        if (this.listaIndice[posicion].elemento.equals(ele)){
        int nuevaPosicion=dondeIria(nuevaCla);
        if (posicion<nuevaPosicion){
          for (int i=posicion;i<nuevaPosicion;i++){
            listaIndice[i]=listaIndice[i+1];
          }
        }else if (posicion>nuevaPosicion){
          for (int i=posicion;i>nuevaPosicion;i--){
            listaIndice[i]=listaIndice[i-1];
          }
        }

        listaIndice[nuevaPosicion]=new NodoIndice(nuevaCla,nodo);
        //esto solo cambia de la clave del indice,
        //pero no cambia el valor dentro del objeto por no poder acceder a él
        //(por ser Object)
        return true;
      }
      return false;
    }
  */
  }
