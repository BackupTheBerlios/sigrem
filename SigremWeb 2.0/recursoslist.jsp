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
        <th><bean:message key="app.codigor" /></th>
        <th><bean:message key="app.fechaemision" /></th>
        <th><bean:message key="app.escrec" /></th>
        <th><bean:message key="app.escpre" /></th>
        <th><bean:message key="app.estado" /></th>
	<th><bean:message key="app.codigoe" /></th>
        <th><bean:message key="app.descripcion" /></th>
	<th><bean:message key="app.codigom" /></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="recurso" name="recursos">
	<tr align="center">
	  <td>
            <bean:write name="recurso" property="codigoRecurso" />
	  </td>
	  <td>
            <bean:write name="recurso" property="fechaEmision" />
	  </td>
	  <td>
            <bean:write name="recurso" property="escritoRecibido" />
	  </td>
	  <td>
            <bean:write name="recurso" property="escritoPresentado" />
	  </td>
	  <td>
            <bean:write name="recurso" property="estado" />
	  </td>
	  <td>
            <bean:write name="recurso" property="abogado" />
	  </td>
	  <td>
            <bean:write name="recurso" property="descripcion" />
	  </td>
	  <td>
            <bean:write name="recurso" property="codigoMulta" />
	  </td>
	  <td>
            <a href="EditR.do?codigo=<bean:write name="recurso"
	      property="codigoRecurso" />">Modificar</a>
	    <a href="DeleteRecurso.do?codigo=<bean:write name="recurso"
	      property="codigoRecurso" />">Eliminar</a>
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
      <a href="addrecurso.jsp">Añadir recurso</a>
    </font>
    <font size="-1" face="arial">
      <a href="MultasList.do">Volver atrás</a>
    </font>
  </body>
</html>
