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
	       		arrayIndices[i]=new IndiceImp(i,this);
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
	  
//	BUSCAR
	  public boolean esta(Comparable clave, int indice){
	    return buscar(clave,indice)!=null;
	  }

	  
	  public Object[] buscar(Comparable clave, int indice){
	    return arrayIndices[indice].buscar(clave);
	  }

	  
//	INSERTAR
	  public void insertar(Comparable[] claves, Object elemento){
	   this.arrayIndices[0].insertar(claves,elemento);	   
	  }
	  
	  
//	ELIMINAR
	  public boolean eliminar(Comparable clave,int indice){
	  	//eliminamos de los indices
	  	Object elementoEliminado=arrayIndices[indice].eliminar(clave);
	  	if(elementoEliminado!=null){
	  		vectorEliminados.add(elementoEliminado);
	  		return true;
	  	}
	  	return false;  
	  }

	 
//	CAMBIO
	  public boolean cambiarClaveDeIndice(Comparable clave, Comparable nuevaCla, int indice){
	    //Este metodo no cambia la clave dentro del objeto, solo lo cambia en el indice
	    return this.arrayIndices[indice].cambiar(clave,nuevaCla);
	  }
	  
//FUNCIONES PARA DEVOLVER TODOS LOS DATOS
	  public Vector dameDatosActuales(){
	  	return this.arrayIndices[0].dameTodos();
	  }
	  
	  
	  public Vector dameDatosPorIndice(int indice){
	  	Vector elementosOrdenados=new Vector();
	  	if (-1<indice && indice<this.dameNumeroIndices()){
	  		elementosOrdenados=this.arrayIndices[indice].dameTodos();
	  	}
	  	return elementosOrdenados;	
	  }
	  
	  
	  public Vector dameDatosEliminados(){
	  	return vectorEliminados; 
		
	  }
	  
	  	  
//MOSTRAR EN LA CONSOLA
	  public void mostrarDatosInteger(){
	  	Vector actuales=dameDatosActuales();
	  	System.out.println("Elementos actuales de la estructura de tamaño "+actuales.size());
	  	for (int i=0;i<actuales.size();i++){
	  		System.out.println(((Integer)actuales.get(i)).intValue());
	  	}	  		
	  	Vector eliminados=dameDatosEliminados();
	  	System.out.println("Elementos que fueron eliminados");
	  	for (int i=0;i<eliminados.size();i++){
			System.out.println(((Integer)eliminados.get(i)).intValue());
		}
	  }
	  
  
//MAIN PARA EJECUTAR PRUEBAS
		public static void main(String[] args) 
		{
			EstructuraDatosImp estructura=new EstructuraDatosImp(1);
			//prueba con un indice
			Integer[] enteros = new Integer[10];
			for (int i=0;i<10;i++){
				enteros[i]=new Integer(i);
			}
			System.out.println("--------------Elementos creados----------");
			for (int i=0;i<10;i++){
				Integer[] claves=new Integer[1];
				claves[0]=enteros[i];
				estructura.insertar(claves,enteros[i]);
				estructura.mostrarDatosInteger();
			}
			System.out.println("-----------Elementos insertados---");
			for (int i=0;i<10;i=i+2){
				estructura.eliminar(new Integer(i),0);
				estructura.mostrarDatosInteger();
			}
			
			Integer[] enteros2 = new Integer[10];
			for (int i=0;i<10;i++){
				enteros[i]=new Integer(i);
			}
			System.out.println("--------------Elementos creados----------");
			for (int i=0;i<10;i++){
				Integer[] claves=new Integer[1];
				claves[0]=enteros[i];
				estructura.insertar(claves,enteros[i]);
				estructura.mostrarDatosInteger();
			}
			estructura.cambiarClaveDeIndice(new Integer(2),new Integer(42),0);
			estructura.cambiarClaveDeIndice(new Integer(2),new Integer(43),0);
			estructura.cambiarClaveDeIndice(new Integer(5),new Integer(45),0);
			estructura.cambiarClaveDeIndice(new Integer(6),new Integer(46),0);
			estructura.mostrarDatosInteger();

			/*
			Integer[] enteros = new Integer[10];
			Integer[] valoracion= new Integer[10];
			for (int i=0;i<10;i++){
				enteros[i]=new Integer(i);
				valoracion[i]=new Integer((enteros[i].intValue()-5)*(enteros[i].intValue()-5));
			}
			System.out.println("--------------Elementos creados----------");
			for (int i=0;i<10;i++){
				Integer[] claves=new Integer[2];
				claves[0]=enteros[i];
				claves[1]=valoracion[i];
				estructura.insertar(claves,enteros[i]);
				estructura.mostrarDatosInteger();
			}
			System.out.println("-----------Elementos insertados---");
			for (int i=0;i<10;i=i+2){
				estructura.eliminar(new Integer(i),0);
				estructura.mostrarDatosInteger();
			}
			
			Integer[] enteros2 = new Integer[10];
			Integer[] valoracion2 = new Integer[10];
			for (int i=0;i<10;i++){
				enteros[i]=new Integer(i);
				valoracion[i]=new Integer((enteros[i].intValue()-3)*(enteros[i].intValue()-3));
			}
			System.out.println("--------------Elementos creados----------");
			for (int i=0;i<10;i++){
				Integer[] claves=new Integer[1];
				claves[0]=enteros[i];
				claves[1]=valoracion2[i];
				estructura.insertar(claves,enteros[i]);
				estructura.mostrarDatosInteger();
			}

			*/
		}
}