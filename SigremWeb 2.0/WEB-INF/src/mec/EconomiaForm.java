package mec;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EconomiaForm extends ActionForm
{
	protected int balance;
	protected int gastos;
	protected int facturacion;
	
	public void setBalance(int bal) {this.balance=bal;}
	public void setGastos(int gas) {this.gastos=gas;}
	public void setFacturacion(int fac) {this.facturacion=fac;}
	
	public int getBalance() {return balance;}
	public int getFacturacion() {return facturacion;}
	public int getGastos() {return gastos;}
	
    //Este método es llamado con cada petición. Resetea los atributos del Form
	//para poner los de la nueva petición
	public void reset(ActionMapping mapping, HttpServletRequest request) 
	{
		this.gastos=0;
	    this.balance=0;
	    this.facturacion=0;
	}
}
