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

    <html:form action="/EditMulta"
      name="multaForm"
      type="mmu.MultaForm"
      scope="request" > 
      <table width="500" border="0">
	<tr>
          <td><bean:message key="app.codigom" />:</td>
          <td><html:text property="codigoMulta" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.expediente" />:</td>
          <td><html:text property="expediente" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.boletin" />:</td>
          <td><html:text property="boletin" /></td>
        </tr>
	</tr>
	  <td><bean:message key="app.fechadenuncia" />:</td>
          <td><html:text property="fechaDenuncia" /></td>
        </tr>
	<tr>
          <td><bean:message key="app.infraccion" />:</td>
          <td><html:text property="infraccion" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.descripcion" />:</td>
          <td><html:text property="descripcion" /></td>
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
