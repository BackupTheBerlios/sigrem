package med;


import java.util.*;

public class EstructuraDatosImp implements EstructuraDatos{
	  Indice[] arrayIndices;
	  Vector vectorEliminados;

	  public EstructuraDatosImp(int numeroDeIndices) {
	  	arrayIndices=new Indice[numeroDeIndices];
	  	if (numeroDeIndices<1){
	    	System.out.println("La lista tiene que tener por lo menos un indice");
	    }else{
	       	//crea los distintos indices que tendra la estructura
	    	for(int i=0;i<numeroDeIndices;i++){
	       		arrayIndices[i]=new IndiceImp(this,i);
	       	}
	    	vectorEliminados=new Vector();
	    }
	  }

	  public int dameTamaño(){
	    return this.arrayIndices[0].dameTamaño();
	  }

	  public int dameNumeroIndices(){
	  	return arrayIndices.length;
	  }
	  
	  public Indice dameIndice(int indice){
	  	return arrayIndices[indice];
	  }
	  
	  public Vector dameEliminados(){
	  	return this.vectorEliminados;
	  }
	  
//	BUSCAR
	  public boolean esta(Comparable clave, int indice){
	    return buscar(clave,indice).size()!=0;
	  }

	  	  
	  public Vector buscar(Comparable clave, int indice){
	    return arrayIndices[indice].buscar(clave);
	  }

	  
//	INSERTAR
	  public void insertar(Comparable[] claves, Object elemento){
	   this.arrayIndices[0].insertar(claves,elemento);	   
	//   this.mostrarTodosIndices();
	  }
	  	  
	  public void insertarAEliminados(Object elemento){
	  	vectorEliminados.add(elemento);
	  }
	  	  
	  
	  
//	ELIMINAR
	  public boolean eliminar(Comparable clave,int indice){
	  	//eliminamos desde el "indice" con la "clave"
	  	Object elementoEliminado=arrayIndices[indice].eliminar(clave);
//	  	this.mostrarTodosIndices();
	  	if(elementoEliminado!=null){
	  		vectorEliminados.add(elementoEliminado);
	  		return true;
	  	}
	  	return false;  
	  }

	 
//	CAMBIO
	  public Object cambiarClaveDeIndice(Comparable clave, Comparable nuevaCla, int indice){
	    //Este metodo no cambia la clave dentro del objeto, solo lo cambia en el indice
	    return this.arrayIndices[indice].cambiar(clave,nuevaCla);
	  }
	  
//FUNCIONES PARA DEVOLVER TODOS LOS DATOS
	  public Vector dameDatosActuales(){
	  	return this.arrayIndices[0].dameElementos();
	  }
	  
	  
	  public Vector dameDatosOrdenadosPorIndice(int indice){
	  	Vector elementosOrdenados=new Vector();
	  	if (-1<indice && indice<this.dameNumeroIndices()){
	  		elementosOrdenados=this.arrayIndices[indice].dameElementos();
	  	}
	  	return elementosOrdenados;	
	  }
	  
	  
	  public Vector dameDatosEliminados(){
	  	return (Vector)vectorEliminados.clone(); 
		
	  }
}