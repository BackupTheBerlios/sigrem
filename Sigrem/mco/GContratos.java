package mco;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public interface GContratos {
  //Requisito 2.1
  public void añadirContrato(Integer codigo,String matricula);
  //Requisito 2.2
  public void eliminarContrato(Integer codigo);
  //Requisito 2.3
  public void modificarContrato(Integer codigo);
  //Requisito 2.4
  public void consultarContratoCodigo(Integer codigo);
  //Requisito 2.5
  public void consultarContratoMatrícula(String matricula);
}