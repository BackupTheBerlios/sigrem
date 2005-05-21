<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

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
	Añadir Multa
	</div>
	<div id="sectionLinks">
    <a href="MultasList.do">Volver atrás</a>	
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2><a href="administrador.html">P&aacute;gina Administrador</a> > <a href="ContratosList.do">Contratos</a> > <a href="MultasList.do">Ver Multas</a> > Añadir Multa</h2>
	<h3>Datos del empleado</h3><hr><br>
	
    <html:form action="/AddMulta"
      name="multaForm"
      type="mmu.MultaForm" >
	  
	    <div id="datos">
	  
      <table>
        <tr>
          <td><bean:message key="app.expediente" />:</td>
          <td><html:text property="expediente" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.boletin" />:</td>
          <td><html:text property="boletin" /></td>
        </tr>
        <tr>
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
	
      </table>
</div>
<hr>
<div id="datos">
<html:submit value="Hecho" /> &nbsp;<html:cancel value="Cancelar" />
	  </div>
    </html:form> 

  </div>

	
  
  </div> 
   <div id="siteInfo"><a href="mailto:sigremweb@gmail.com">Contacto</a> | &copy;2005
  SigremWEB</div> 
</div> 
<!--end pagecell1--> 
<br> 

</body>
</html>
