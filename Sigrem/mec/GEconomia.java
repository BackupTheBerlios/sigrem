package mec;

public interface GEconomia 
{
	//	Requisito 5.1
	public void facturacion(int [] vFacturacion, int nFacturacion, int ultMes);
	
	//	Requisito 5.2
	public void gastos(int [] vGastos, int nGastos, int ultMes);
	
	//Requisito 5.3
	public void balance(int [] vBalance, int nFacturacion, int nGastos, int nBalance, int ultMes);
		
}
