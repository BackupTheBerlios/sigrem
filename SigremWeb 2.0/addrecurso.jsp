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

    <html:form action="/AddRecurso"
      name="recursoForm"
      type="mre.RecursoForm" >
      <table width="500" border="0">
     	<tr>
	  <td><bean:message key="app.fechaemision" />:</td>
          <td><html:text property="fechaEmision" /></td>
	</tr>
     	<tr>
	  <td><bean:message key="app.escrec" />:</td>
          <td><html:text property="escritoRecibido" /></td>
	</tr>
     	<tr>
	  <td><bean:message key="app.escpre" />:</td>
          <td><html:text property="escritoPresentado" /></td>
	</tr>
     	<tr>
	  <td><bean:message key="app.estado" />:</td>
          <td><html:text property="estado" /></td>
	</tr>
        <tr>
	  <td><bean:message key="app.descripcion" />:</td>
          <td><html:text property="descripcion" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.abogado" />:</td>
          <td><html:text property="abogado" /></td>
        </tr>
	<tr>
          <td colspan="2" align="center">
            <html:submit />
	    <html:cancel />
          </td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
