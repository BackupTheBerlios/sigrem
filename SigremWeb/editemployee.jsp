<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
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

    <html:form action="/EditEmployee"
      name="empleadoForm"
      type="mem.EmpleadoForm"
      scope="request" > 
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.codigo" />:</td>
          <td><html:text property="codigo" /></td>
          <td><bean:message key="app.nombre" />:</td>
          <td><html:text property="nombre" /></td>
	  <td><bean:message key="app.dni" />:</td>
          <td><html:text property="dni" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.direccion" />:</td>
          <td><html:text property="direccion" /></td>
          <td><bean:message key="app.cp" />:</td>
          <td><html:text property="cp" /></td>
	  <td><bean:message key="app.poblacion" />:</td>
          <td><html:text property="poblacion" /></td>
	  <td><bean:message key="app.provincia" />:</td>
          <td><html:text property="provincia" /></td>
	  <td><bean:message key="app.telefono1" />:</td>
          <td><html:text property="telefono1" /></td>
	  <td><bean:message key="app.telefono2" />:</td>
          <td><html:text property="telefono2" /></td>
	  <td><bean:message key="app.movil" />:</td>
          <td><html:text property="movil" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>
          <td><bean:message key="app.fax" />:</td>
          <td><html:text property="fax" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.perfil" />:</td>
          <td><html:text property="perfil" /></td>
          <td><bean:message key="app.nomina" />:</td>
          <td><html:text property="nomina" /></td>
          <td colspan="2" align="center">
	    <html:submit />
	    <html:cancel />
	    <html:reset />
	  </td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
