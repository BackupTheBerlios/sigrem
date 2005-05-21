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
	Men&uacute; Recursos <%=session.getAttribute("nombreusuario")%>
	</div>
	<div id="sectionLinks"> 
	<a href="MultasClienteList.do">Volver atrás</a>
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2><a href="ContratosClienteList.do"><%=session.getAttribute("nombreusuario")%></a> > <a href="MultasClienteList.do">Multas</a> > Recursos</h2>
	<h3>Lista de recursos</h3><hr><br>
	
	

    <table>
      <tr>
        <th><bean:message key="app.codigor" /></th>
        <th><bean:message key="app.fechaemision" /></th>
        <th><bean:message key="app.estado" /></th>
	<th><bean:message key="app.codigoe" /></th>

	<th><bean:message key="app.codigom" /></th>

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