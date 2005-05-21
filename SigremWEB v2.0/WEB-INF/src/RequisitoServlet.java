import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.ServletException;
import bean.Requisito;

public class RequisitoServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		doPost(req,res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession sesion=req.getSession();
		String numero=req.getParameter("requisito");
		if (numero!=null)
		{	Requisito requisito=new Requisito();
			requisito.setOrigen("operador consola");
			requisito.setDestino("sistema");
			if (numero.equals("1.1"))
			{	requisito.setFuncion("añadir cliente");
				requisito.setDescripcion("añade un nuevo cliente a la base de datos");
				requisito.setEntrada("nombre, dni, direccion, cp, poblacion, provincia, telefono1, telefono2, movil, email, fax");
				requisito.setSalida("código del cliente");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("no exista el cliente en la base de datos");
				requisito.setPostcondicion("cliente añadido a la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("1.2"))
			{	requisito.setFuncion("eliminar cliente");
				requisito.setDescripcion("elimina un cliente de la base de datos");
				requisito.setEntrada("código del cliente");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("exista el cliente en la base de datos");
				requisito.setPostcondicion("cliente eliminado de la base de datos");
				requisito.setEfectos("se archivan los contratos asociados al cliente y todos los datos que dependan de ellos");
			}
			else if (numero.equals("1.3"))
			{	requisito.setFuncion("modificar cliente");
				requisito.setDescripcion("modifica los datos de un cliente");
				requisito.setEntrada("código cliente");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("exista el cliente en la base de datos");
				requisito.setPostcondicion("cliente modificado y almacenado en la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("1.4"))
			{	requisito.setFuncion("consultar cliente por código");
				requisito.setDescripcion("consulta los datos de un cliente");
				requisito.setEntrada("código del cliente");
				requisito.setSalida("datos del cliente elegido");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("exista el cliente en la base de datos");
				requisito.setPostcondicion("mostrar datos del cliente");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("1.5"))
			{	requisito.setFuncion("consultar cliente por nombre");
				requisito.setDescripcion("consulta los datos de un cliente");
				requisito.setEntrada("nombre del cliente");
				requisito.setSalida("datos del cliente elegido");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("exista el cliente en la base de datos");
				requisito.setPostcondicion("mostrar datos del cliente");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("1.6"))
			{	requisito.setFuncion("consultar cliente por NIF/CIF");
				requisito.setDescripcion("consulta los datos de un cliente");
				requisito.setEntrada("NIF/CIF del cliente");
				requisito.setSalida("datos del cliente elegido");
				requisito.setNecesita("base de datos de clientes");
				requisito.setPrecondicion("exista el cliente en la base de datos");
				requisito.setPostcondicion("mostrar datos del cliente");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("2.1"))
			{	requisito.setFuncion("añadir contrato");
				requisito.setDescripcion("añade un nuevo contrato asociado a un cliente a la base de datos");
				requisito.setEntrada("código del cliente, datos del vehículo ");
				requisito.setSalida("código del contrato");
				requisito.setNecesita("nada");
				requisito.setPrecondicion("exista el cliente y no exista contrato asociado al vehículo ");
				requisito.setPostcondicion("contrato añadido a la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("2.2"))
			{	requisito.setFuncion("eliminar contrato");
				requisito.setDescripcion("elimina un contrato de la base de datos");
				requisito.setEntrada("código del contrato");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("exista el contrato en la base de datos");
				requisito.setPostcondicion("contrato eliminado de la base de datos");
				requisito.setEfectos("se archivan las multas asociadas al contrato");
			}
			else if (numero.equals("2.3"))
			{	requisito.setFuncion("modificar contrato");
				requisito.setDescripcion("modifica los datos de un contrato existente");
				requisito.setEntrada("código del contrato");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("exista el contrato en la base de datos");
				requisito.setPostcondicion("contrato modificado y almacenado en la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("2.4"))
			{	requisito.setFuncion("consultar contrato por código");
				requisito.setDescripcion("consulta un contrato de la base de datos");
				requisito.setEntrada("código del contrato");
				requisito.setSalida("datos del contrato buscado");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("exista el contrato en la base de datos");
				requisito.setPostcondicion("mostrar contrato");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("2.5"))
			{	requisito.setFuncion("consultar contrato por matrícula");
				requisito.setDescripcion("consulta un contrato de la base de datos");
				requisito.setEntrada("matrícula");
				requisito.setSalida("datos del contrato buscado");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("exista el contrato en la base de datos");
				requisito.setPostcondicion("mostrar contrato");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("3.1"))
			{	requisito.setFuncion("añadir multa");
				requisito.setDescripcion("añade una multa a la lista de multas");
				requisito.setEntrada("código del contrato, expediente, boletin, fechaDenuncia, infraccion, descripcion");
				requisito.setSalida("código de la multa");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("no exista la multa en la base de datos");
				requisito.setPostcondicion("multa añadida a la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("3.2"))
			{	requisito.setFuncion("eliminar multa");
				requisito.setDescripcion("elimina una multa");
				requisito.setEntrada("código de la multa");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa en la base de datos");
				requisito.setPostcondicion("multa eliminada de la base de datos");
				requisito.setEfectos("si hay recursos sobre esta multa se archivarán también");
			}
			else if (numero.equals("3.3"))
			{	requisito.setFuncion("modificar multa");
				requisito.setDescripcion("modifica los datos de una multa existente");
				requisito.setEntrada("código de la multa");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa en la base de datos");
				requisito.setPostcondicion("multa modificada y almacenada en la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("3.4"))
			{	requisito.setFuncion("consultar multa por código");
				requisito.setDescripcion("consulta una multa de la base de datos");
				requisito.setEntrada("código de la multa");
				requisito.setSalida("datos de la multa");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa en la base de datos");
				requisito.setPostcondicion("mostrar multa");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("3.5"))
			{	requisito.setFuncion("consultar multa por expediente");
				requisito.setDescripcion("consulta una multa de la base de datos");
				requisito.setEntrada("número de expediente");
				requisito.setSalida("datos de la multa");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa en la base de datos");
				requisito.setPostcondicion("mostrar multa");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("3.6"))
			{	requisito.setFuncion("consultar multa por boletín");
				requisito.setDescripcion("consulta una multa de la base de datos");
				requisito.setEntrada("número de boletín ");
				requisito.setSalida("datos de la multa");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa en la base de datos");
				requisito.setPostcondicion("mostrar multa");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("4.1"))
			{	requisito.setFuncion("añadir recurso");
				requisito.setDescripcion("añade un recurso a una multa ");
				requisito.setEntrada("código de la multa, fechaEmision, escritoRecibido, escritoPresentado, estado, abogado");
				requisito.setSalida("código del recurso");
				requisito.setNecesita("base de datos de multas");
				requisito.setPrecondicion("exista la multa");
				requisito.setPostcondicion("recurso añadido a la multa");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("4.2"))
			{	requisito.setFuncion("eliminar recurso");
				requisito.setDescripcion("elimina un recurso asociado a una multa");
				requisito.setEntrada("código del recurso");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("exista el contrato");
				requisito.setPostcondicion("recurso eliminado de la multa");
				requisito.setEfectos("elimina la asignación del recurso al abogado que lo tramita");
			}
			else if (numero.equals("4.3"))
			{	requisito.setFuncion("modificar recurso");
				requisito.setDescripcion("actualiza la situación de un recurso a una multa");
				requisito.setEntrada("código del recurso");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de recursos");
				requisito.setPrecondicion("exista el recurso");
				requisito.setPostcondicion("actualización de datos del recurso");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("4.4"))
			{	requisito.setFuncion("consultar recurso");
				requisito.setDescripcion("consulta la situación de un recurso");
				requisito.setEntrada("código del recurso");
				requisito.setSalida("datos del recurso elegido");
				requisito.setNecesita("base de datos de recursos");
				requisito.setPrecondicion("exista el recurso");
				requisito.setPostcondicion("mostrar situación del recurso");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("5.1"))
			{	requisito.setFuncion("facturar contratos");
				requisito.setDescripcion("calcula la facturación de la empresa");
				requisito.setEntrada("lista de contratos ");
				requisito.setSalida("facturación de la empresa");
				requisito.setNecesita("base de datos de contratos");
				requisito.setPrecondicion("ninguna");
				requisito.setPostcondicion("mostrar facturación");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("5.2"))
			{	requisito.setFuncion("calcular nóminas");
				requisito.setDescripcion("calcula los pagos a realizar a los empleados");
				requisito.setEntrada("lista de empleados, datos de pago de los empleados");
				requisito.setSalida("nóminas de la empresa");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("ninguna");
				requisito.setPostcondicion("mostrar nóminas");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("5.3"))
			{	requisito.setFuncion("gestión de balance");
				requisito.setDescripcion("calcula el balance de la empresa");
				requisito.setEntrada("datos de gastos, datos de cobros");
				requisito.setSalida("balance de la empresa");
				requisito.setNecesita("base de datos de gastos, base de datos de cobros");
				requisito.setPrecondicion("ninguna");
				requisito.setPostcondicion("mostrar balance");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("6.1"))
			{	requisito.setFuncion("contratar empleado");
				requisito.setDescripcion("contrata un nuevo empleado");
				requisito.setEntrada("perfil, dni, nombre, direccion, cp, poblacion, provincia, telefono1, telefono2, movil, email,fax, nomina ");
				requisito.setSalida("código del empleado");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("no exista el empleado en la base de datos");
				requisito.setPostcondicion("empleado añadido a la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("6.2"))
			{	requisito.setFuncion("despedir empleado");
				requisito.setDescripcion("despide a un empleado contratado");
				requisito.setEntrada("código del empleado");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("exista el empleado en la base de datos");
				requisito.setPostcondicion("empleado eliminado de la base de datos");
				requisito.setEfectos("si el empleado es un abogado y estaba asignado a alguna multa, se elimina la asignación y se requiere una nueva asignación de abogado");
			}
			else if (numero.equals("6.3"))
			{	requisito.setFuncion("modificar empleado");
				requisito.setDescripcion("modifica los datos de un empleado");
				requisito.setEntrada("código empleado");
				requisito.setSalida("ninguna");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("exista el empleado en la base de datos");
				requisito.setPostcondicion("empleado modificado y almacenado en la base de datos");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("6.4"))
			{	requisito.setFuncion("consultar empleado por código");
				requisito.setDescripcion("consulta los datos de un empleado");
				requisito.setEntrada("código empleado");
				requisito.setSalida("datos del empleado");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("exista el empleado en la base de datos");
				requisito.setPostcondicion("mostrar datos del empleado");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("6.5"))
			{	requisito.setFuncion("consultar empleado por nombre");
				requisito.setDescripcion("consulta los datos de un empleado");
				requisito.setEntrada("nombre del empleado");
				requisito.setSalida("datos del empleado");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("exista el empleado en la base de datos");
				requisito.setPostcondicion("mostrar datos del empleado");
				requisito.setEfectos("ninguno");
			}
			else if (numero.equals("6.6"))
			{	requisito.setFuncion("consultar empleado por NIF/CIF");
				requisito.setDescripcion("consulta los datos de un empleado");
				requisito.setEntrada("NIF/CIF");
				requisito.setSalida("datos del empleado");
				requisito.setNecesita("base de datos de empleados");
				requisito.setPrecondicion("exista el empleado en la base de datos");
				requisito.setPostcondicion("mostrar datos del empleado");
				requisito.setEfectos("ninguno");
			}
			sesion.setAttribute("requisito",requisito);
			sesion.setAttribute("numero",numero);
			res.sendRedirect("../requisito.jsp");
		}
		else
		{	res.sendRedirect("../error.jsp");}
	}
}