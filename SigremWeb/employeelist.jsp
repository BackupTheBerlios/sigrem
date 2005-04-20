<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>
  <body>

    <table width="650"
      border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td colspan="7">&nbsp;</td>
      </tr>
      <tr> 
	<td height="68" width="48%"> 
          <div align="left">
            <img src="imagenes/sigrem.png">
          </div>
        </td>
      </tr>
      <tr>
        <td colspan="7">&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <table width="700"
      border="0" cellspacing="0" cellpadding="0">
      <tr align="left">
        <th><bean:message key="app.codigo" /></th>
        <th><bean:message key="app.nombre" /></th>
        <th><bean:message key="app.dni" /></th>
        <th><bean:message key="app.perfil" /></th>
        <th><bean:message key="app.direccion" /></th>
        <th><bean:message key="app.cp" /></th>
        <th><bean:message key="app.poblacion" /></th>
        <th><bean:message key="app.provincia" /></th>
        <th><bean:message key="app.telefono1" /></th>
        <th><bean:message key="app.telefono2" /></th>
        <th><bean:message key="app.movil" /></th>
        <th><bean:message key="app.email" /></th>
        <th><bean:message key="app.fax" /></th>
        <th><bean:message key="app.nomina" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="empleado" name="empleados">
	<tr align="left">
	  <td>
            <bean:write name="empleado" property="codigo" />
	  </td>
	  <td>
            <bean:write name="empleado" property="nombre" />
	  </td>
	  <td>
            <bean:write name="empleado" property="dni" />
	  </td>
	  <td>
            <bean:write name="empleado" property="perfil" />
	  </td>
	  <td>
            <bean:write name="empleado" property="direccion" />
	  </td>
	  <td>
            <bean:write name="empleado" property="cp" />
	  </td>
	  <td>
            <bean:write name="empleado" property="poblacion" />
	  </td>
	  <td>
            <bean:write name="empleado" property="provincia" />
	  </td>
	  <td>
            <bean:write name="empleado" property="telefono1" />
	  </td>
	  <td>
            <bean:write name="empleado" property="telefono2" />
	  </td>
	  <td>
            <bean:write name="empleado" property="movil" />
	  </td>
	  <td>
            <bean:write name="empleado" property="email" />
	  </td>
	  <td>
            <bean:write name="empleado" property="fax" />
	  </td>
	  <td>
            <bean:write name="empleado" property="nomina" />
	  </td>
	  <td>
        <a href="Edit.do?username=<bean:write name="empleado"
	      property="codigo" />">Edit</a>
	    <a href="Delete.do?username=<bean:write name="empleado"
	      property="codigo" />">Delete</a>
	  </td>
	</tr>
      </logic:iterate>
      <tr>
        <td colspan="7">
	  <hr>
	</td>
      </tr>
    </table>
    <font size="-1" face="arial">
      <a href="addemployee.jsp">Contratar empleado</a>
    </font>

  </body>
</html>
