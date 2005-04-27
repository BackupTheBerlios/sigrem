<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
    <link type="text/css" href="estilo.css" rel="stylesheet" media="screen">
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
            <img src="images/sigrem.png">
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
        <th><bean:message key="app.codigocl" /></th>
        <th><bean:message key="app.nombre" /></th>
        <th><bean:message key="app.dni" /></th>
        <th><bean:message key="app.direccion" /></th>
        <th><bean:message key="app.cp" /></th>
        <th><bean:message key="app.poblacion" /></th>
        <th><bean:message key="app.provincia" /></th>
        <th><bean:message key="app.telefono1" /></th>
        <th><bean:message key="app.telefono2" /></th>
        <th><bean:message key="app.movil" /></th>
        <th><bean:message key="app.email" /></th>
        <th><bean:message key="app.fax" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="cliente" name="clientes">
	<tr align="center">
	  <td>
            <bean:write name="cliente" property="codigo" />
	  </td>
	  <td>
            <bean:write name="cliente" property="nombre" />
	  </td>
	  <td>
            <bean:write name="cliente" property="dni" />
	  </td>
	  <td>
            <bean:write name="cliente" property="direccion" />
	  </td>
	  <td>
            <bean:write name="cliente" property="cp" />
	  </td>
	  <td>
            <bean:write name="cliente" property="poblacion" />
	  </td>
	  <td>
            <bean:write name="cliente" property="provincia" />
	  </td>
	  <td>
            <bean:write name="cliente" property="telefono1" />
	  </td>
	  <td>
            <bean:write name="cliente" property="telefono2" />
	  </td>
	  <td>
            <bean:write name="cliente" property="movil" />
	  </td>
	  <td>
            <bean:write name="cliente" property="email" />
	  </td>
	  <td>
            <bean:write name="cliente" property="fax" />
	  </td>
	  <td>
            <a href="EditCl.do?codigo=<bean:write name="cliente"
	      property="codigo" />">Modificar</a>
	    <a href="DeleteCliente.do?codigo=<bean:write name="cliente"
	      property="codigo" />">Eliminar</a>
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
      <a href="addcliente.jsp">Añadir cliente</a>
    </font>

  </body>
</html>
