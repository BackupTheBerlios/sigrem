package mec;

public interface GEconomia 
{
	//	Requisito 5.1
	public void facturacion(int nFacturacion);
	
	//	Requisito 5.2
	public void gastos(int [] vGastos,int nGastos);
	
	//Requisito 5.3
	public void balance(int nFacturacion, int nGastos, int nBalance);
	
	public int dameCuotaContrato();
		
}
