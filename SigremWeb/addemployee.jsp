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
            <img src="imagenes/sigrem.png">
          </div>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <html:form action="/Add"
      name="empleadoForm"
      type="mem.EmpleadoForm" >
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.codigo" />:</td>
          <td><html:text property="codigo" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.nombre" />:</td>
          <td><html:text property="nombre" /></td>
	</tr>
	  <td><bean:message key="app.dni" />:</td>
          <td><html:text property="dni" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.direccion" />:</td>
          <td><html:text property="direccion" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.cp" />:</td>
          <td><html:text property="cp" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.poblacion" />:</td>
          <td><html:text property="poblacion" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.provincia" />:</td>
          <td><html:text property="provincia" /></td>
        </tr>
        <tr>
	  <td><bean:message key="app.telefono1" />:</td>
          <td><html:text property="telefono1" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.telefono2" />:</td>
          <td><html:text property="telefono2" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.movil" />:</td>
          <td><html:text property="movil" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.fax" />:</td>
          <td><html:text property="fax" /></td>
	</tr>
        <tr>
          <td><bean:message key="app.perfil" />:</td>
          <td><html:text property="perfil" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.nomina" />:</td>
          <td><html:text property="nomina" /></td>
	</tr>
	<tr>
          <td colspan="2" align="center">
            <html:submit /><html:cancel /><html:reset />
          </td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
