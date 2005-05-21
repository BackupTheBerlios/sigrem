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
    <h2>P&aacute;gina Administrador </h2> 
  </div> 
  <div id="pageNav"> 
    <div id="sectionLinks"> 
    <a href="index.jsp">P&aacute;gina Principal</a><a href="login.jsp">Acceso Usuarios</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:sigremweb@gmail.com">Contacto</a>
	</div> 
	
    <div class="relatedLinks"> 
      <h3><img src="images/sigrem_acercade.gif" alt="" width="150" />  </h3> 
    </div> 
	<div id=admin>
	Men&uacute; Administrador
	</div>
	<div id="sectionLinks"> 
	<a href="EmpleadosList.do"/>Empleados</a>
	<a href="ContratosList.do"/>Contratos</a>
	<a href="ClientesList.do"/>Clientes</a>
	<a href="UsuariosList.do"/>Usuarios</a>
	<a href="GestionEconomica.do"/>Gestión Económica</a>
	</div>
	
	<div id=admin>
	Men&uacute; Contratos
	</div>
	<div id="sectionLinks">
    <a href="addcontrato.jsp">Crear contrato</a>
    <a href="administrador.html">Volver atrás</a>
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2><a href="administrador.html">P&aacute;gina Administrador</a> > Contratos</h2>
	<h3>Lista de contratos</h3><hr><br>

    <table>
      <tr>
        <th><bean:message key="app.codigoco" /></th>
        <th><bean:message key="app.matricula" /></th>
        <th><bean:message key="app.fechaalta" /></th>
        <th><bean:message key="app.codigocl" /></th>
		<th colspan="4"></th>
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
	  <td>
            <a href="EditCo.do?codigo=<bean:write name="contrato"
	      property="codigoContrato" />"><img src="images/tick.gif" alt="Modificar contrato" /></a>
		  </td><td>
	    <a href="DeleteContrato.do?codigo=<bean:write name="contrato"
	      property="codigoContrato" />"><img src="images/del.gif" alt="Eliminar contrato" /></a>
	  </td>
	  <td> 
	  <div id="boton">
	   <a href="ConsultarCliente.do?codigo=<bean:write name="contrato"
	      property="codigoCliente" />">Ver cliente</a></div>
	  </td>
	  <td>
	  	  <div id="boton">
	    <a href="MultasList.do?codigoco=<bean:write name="contrato"
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
