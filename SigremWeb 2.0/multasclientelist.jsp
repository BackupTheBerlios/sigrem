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
        <th><bean:message key="app.codigom" /></th>
        <th><bean:message key="app.expediente" /></th>
        <th><bean:message key="app.boletin" /></th>
        <th><bean:message key="app.fechadenuncia" /></th>
        <th><bean:message key="app.infraccion" /></th>
        <th><bean:message key="app.descripcion" /></th>
        <th><bean:message key="app.codigoco" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="multa" name="multas">
	<tr align="center">
	  <td>
            <bean:write name="multa" property="codigoMulta" />
	  </td>
	  <td>
            <bean:write name="multa" property="expediente" />
	  </td>
	  <td>
            <bean:write name="multa" property="boletin" />
	  </td>
	  <td>
            <bean:write name="multa" property="fechaDenuncia" />
	  </td>
	  <td>
            <bean:write name="multa" property="infraccion" />
	  </td>
	  <td>
            <bean:write name="multa" property="descripcion" />
	  </td>
	  <td>
            <bean:write name="multa" property="codigoContrato" />
	  </td>
	  <td>
	    <a href="RecursosClienteList.do?codigomu=<bean:write name="multa"
	      property="codigoMulta" />">Ver recursos</a>
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
      <a href="ContratosClienteList.do">Volver atrás</a>
    </font>
  </body>
</html>
