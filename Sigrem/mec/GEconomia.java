package mec;

public interface GEconomia 
{
	//	Requisito 5.1
	public void facturacion(int nFacturacion,int grafica);
	
	//	Requisito 5.2
	public void gastos(int nGastos,int grafica);
	
	//Requisito 5.3
	public void balance(int nBalance,int grafica);
	
	public int dameCuotaContrato();
	
	public int dameUltimaMesFac();
	
	public int dameUltimaMesGas();
	
	public int dameUltimaMesBal();
	
	public int[] dameVectorFacturacion();
	
	public int[] dameVectorGastos();
	
	public int[] dameVectorBalance();
}
