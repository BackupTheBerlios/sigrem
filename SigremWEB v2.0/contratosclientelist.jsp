<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
    <link type="text/css" href="estilo.css" rel="stylesheet" media="screen">
  </head>
  <body>

  <div id="masthead"> 
  <h1 id="siteName">SigremWEB</h1> 
  <div id="globalNav"> 
    <img alt="" src="images/gblnav_left.gif" height="32" width="4" id="gnl"> <img alt="" src="images/glbnav_right.gif" height="32" width="4" id="gnr"> 
    <div id="globalLink"> 
    <a href="index.jsp" id="gl1" class="glink">P&aacute;gina Principal</a><a href="login.jsp" id="gl3" class="glink">Acceso Usuarios</a><a href="ayuda.jsp" id="gl4" class="glink" target="new">Ayuda</a><a href="mailto:sigremweb@gmail.com" id="gl5" class="glink">Contacto</a></div> 
    <!--end globalLinks--> 
  </div> 
  <!-- end globalNav --> 
  
</div> 
<!-- end masthead --> 
<div id="pagecell1"> 
  <!--pagecell1--> 
  <img alt="" src="images/tl_curve_white.gif" height="6" width="6" id="tl"> <img alt="" src="images/tr_curve_white.gif" height="6" width="6" id="tr"> 
  <div id="pageName"> 
    <h2>P&aacute;gina Clientes</h2> 
  </div> 
  <div id="pageNav"> 
    <div id="sectionLinks"> 
    <a href="index.jsp">P&aacute;gina Principal</a><a href="login.jsp">Acceso Usuarios</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:sigremweb@gmail.com">Contacto</a>
	</div> 
	
    <div class="relatedLinks"> 
      <h3><img src="images/sigrem_acercade.gif" alt="" width="150" />  </h3> 
    </div> 
	<div id=admin>
	Men&uacute; <%=session.getAttribute("nombreusuario")%>
	</div>
	<div id="sectionLinks"> 
	<a href="login.jsp">Volver atrás</a>
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2>¡¡¡ Bienvenido <%=session.getAttribute("nombreusuario")%> !!!</h2>
	<h3>Lista de contratos</h3><hr><br>

  <table>
      <tr>
        <th><bean:message key="app.codigoco" /></th>
        <th><bean:message key="app.matricula" /></th>
        <th><bean:message key="app.fechaalta" /></th>
        <th><bean:message key="app.codigocl" /></th>
		<th colspan="1"></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="contrato" name="contratos">
	<tr>
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
	  <td><div id="boton">
	    <a href="MultasClienteList.do?codigoco=<bean:write name="contrato"
	      property="codigoContrato" />">Ver multas</a></div>
	  </td>
	</tr>
      </logic:iterate>
      
    </table>
	
	
    </div>
	
  
  </div> 
   <div id="siteInfo"><a href="mailto:sigremweb@gmail.com">Contacto</a> | &copy;2005
  SigremWEB</div> 
</div> 
<!--end pagecell1--> 
<br> 

</body>
</html>
