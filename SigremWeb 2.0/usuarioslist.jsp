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
        <th><bean:message key="app.nombreusuario" /></th>
        <th><bean:message key="app.password" /></th>
        <th><bean:message key="app.tipousuario" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="usuario" name="usuarios">
	<tr align="center">
	  <td>
            <bean:write name="usuario" property="nombreUsuario" />
	  </td>
	  <td>
            <bean:write name="usuario" property="password" />
	  </td>
	  <td>
            <bean:write name="usuario" property="tipoUsuario" />
	  </td>
	  <td>
            <a href="EditU.do?nombre=<bean:write name="usuario"
	      property="nombreUsuario" />">Modificar</a>
	    <a href="DeleteUsuario.do?nombre=<bean:write name="usuario"
	      property="nombreUsuario" />">Eliminar</a>
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
      <a href="administrador.html">Volver atr�s</a>
    </font>
  </body>
</html>
