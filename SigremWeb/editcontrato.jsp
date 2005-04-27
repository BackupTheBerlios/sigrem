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

    <html:form action="/EditContrato"
      name="contratoForm"
      type="mco.ContratoForm"
      scope="request" > 
      <table width="500" border="0">
	<tr>
          <td><bean:message key="app.codigoco" />:</td>
          <td><html:text property="codigoContrato" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.matricula" />:</td>
          <td><html:text property="matricula" /></td>
	</tr>
	  <td><bean:message key="app.fechaalta" />:</td>
          <td><html:text property="fechaAlta" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.fechabaja" />:</td>
          <td><html:text property="fechaBaja" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.codigocl" />:</td>
          <td><html:text property="codigoCliente" /></td>
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
