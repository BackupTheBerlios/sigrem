<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
    <link type="text/css" href="estilo.css" rel="stylesheet" media="screen">
  </head>

  <body>
    <table width="650"
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

    <html:form action="/EditarCliente"
      name="clienteForm"
      type="mcl.ClienteForm"
      scope="request" > 
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.codigo" />:</td>
          <td><html:text property="codigo" /></td>
        </tr>
        <tr>
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
        </tr>
	<tr>
          <td><bean:message key="app.poblacion" />:</td>
          <td><html:text property="poblacion" /></td>
          <td><bean:message key="app.provincia" />:</td>
          <td><html:text property="provincia" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.movil" />:</td>
          <td><html:text property="movil" /></td>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>      
          </td>
        </tr>
        <tr>
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
