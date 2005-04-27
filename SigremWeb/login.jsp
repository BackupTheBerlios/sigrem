<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
    <link type="text/css" href="estilo.css" rel="stylesheet" media="screen">
  </head>

  <body>
    <table width="500"
      border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr> 
        <td height="68" width="48%">
          <div align="left">
            <img src="images/sigrem.png">
          </div>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <html:form action="/LoginUsuario"
      name="usuarioForm"
      type="login.UsuarioForm" >
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.nombreusuario" />:</td>
          <td><html:text property="nombreUsuario" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.password" />:</td>
          <td><html:text property="password" /></td>
        </tr>
	<tr>
          <td colspan="2" align="center">
            <html:submit />
	    <html:cancel />
          </td>
        </tr>
      </table>
    </html:form> 
    <hr>
    <font size="-1" face="arial">
      <a href="addusuario.jsp">Registrarse</a>
    </font>
  </body>
</html>
