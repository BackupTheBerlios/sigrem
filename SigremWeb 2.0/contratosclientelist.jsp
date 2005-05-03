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
	<td>
	    Bienvenido <%=session.getAttribute("nombreusuario")%>
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
        <th><bean:message key="app.codigoco" /></th>
        <th><bean:message key="app.matricula" /></th>
        <th><bean:message key="app.fechaalta" /></th>
        <th><bean:message key="app.codigocl" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="contrato" name="contratos">
	<tr align="center">
	  <td>
            <bean:write name="contrato" property="codigoContrato" />
	  </td>
	  <td>
            <bean:write name="contrato" property="matricula" />
	  </td>
	  <td>
            <bean:write name="contrato" property="fechaAlta" />
	  </td>
	  <td>
            <bean:write name="contrato" property="codigoCliente" />
	  </td>
	  <td>
	    <a href="MultasClienteList.do?codigoco=<bean:write name="contrato"
	      property="codigoContrato" />">Ver multas</a>
	  </td>
	</tr>
      </logic:iterate>
      <tr>
        <td colspan="7">
	  <hr>
	</td>
      </tr>
    </table>

  </body>
</html>
