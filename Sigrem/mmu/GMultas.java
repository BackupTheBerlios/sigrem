/*
 * Created on 14-mar-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package mmu;

import mco.*;

/**
 * @author frank
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public interface GMultas {
	//Requisito 3.1
	public void añadirMultas(Contrato contrato, Integer codigo,String matricula);
	//Requisito 3.2
	public void eliminarMultas(Integer codigo);
	//Requisito 3.3
	public void modificarMultas(Integer codigo);
	//Requisito 3.4
	public void consultarMultas(Integer codigo);
	//Requisito 3.5
	public void consultarMultasExpediente(String expediente);
	//Requisito 3.6
	public void consultarMultasBoletin(String boletin);	


}
