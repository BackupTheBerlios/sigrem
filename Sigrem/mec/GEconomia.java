package mec;

public interface GEconomia 
{
	//	Requisito 5.1
	public void facturacion(int nFacturacion);
	
	//	Requisito 5.2
	public void gastos(int nGastos);
	
	//Requisito 5.3
	public void balance(int nBalance);
	
	public int dameCuotaContrato();
	
	public int [] stringAVector (String s);
	
	public void calculaVector(int [] vect,int uMes,int uVal);
		
}
