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
      <h3><img src="images/sigrem_acercade.gif" alt="" />  </h3> 
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
	Men&uacute; Recursos
	</div>
	<div id="sectionLinks">
	<a href="addrecurso.jsp">Añadir recurso</a>
    <a href="MultasList.do">Volver atrás</a>
    
 
	
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2><a href="administrador.html">P&aacute;gina Administrador</a> > <a href="ContratosList.do">Contratos</a> > <a href="MultasList.do">Ver Multas</a> > Ver recursos</h2>
	<h3>Datos generales de los recursos</h3><hr><br>


    <table>
      <tr>
        <th><bean:message key="app.codigor" /></th>
        <th><bean:message key="app.fechaemision" /></th>
        <th><bean:message key="app.estado" /></th>
	<th><bean:message key="app.codigoe" /></th>
        
	<th><bean:message key="app.codigom" /></th>
	<th colspan="2"></th>
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="recurso" name="recursos">
	<tr>
	  <td>
            <bean:write name="recurso" property="codigoRecurso" />
	  </td>
	  <td>
            <bean:write name="recurso" property="fechaEmision" />
	  </td>
	  
	  <td>
            <bean:write name="recurso" property="estado" />
	  </td>
	  <td>
            <bean:write name="recurso" property="abogado" />
	  </td>
	  
	  <td>
            <bean:write name="recurso" property="codigoMulta" />
	  </td>
	  <td>
            <a href="EditR.do?codigo=<bean:write name="recurso"
	      property="codigoRecurso" />"><img src="images/tick.gif" alt="Modificar recurso" /></a>
		  </td>
		  <td>
	    <a href="DeleteRecurso.do?codigo=<bean:write name="recurso"
	      property="codigoRecurso" />"><img src="images/del.gif" alt="Eliminar recurso" /></a>
	  </td>
	</tr>
      </logic:iterate>
    </table>

	</div>
	
	<div class="masdatos">
	<h3>Más datos</h3><hr><br>
    <table>
      <tr>
        <th><bean:message key="app.codigor" /></th>
        <th><bean:message key="app.escrec" /></th>
        <th><bean:message key="app.escpre" /></th>
        <th><bean:message key="app.descripcion" /></th>
		
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="recurso" name="recursos">
	<tr>
	  <td>
            <bean:write name="recurso" property="codigoRecurso" />
	  </td>
	
	  <td>
            <bean:write name="recurso" property="escritoRecibido" />
	  </td>
	  <td>
            <bean:write name="recurso" property="escritoPresentado" />
	  </td>
	  <td>
            <bean:write name="recurso" property="descripcion" />
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