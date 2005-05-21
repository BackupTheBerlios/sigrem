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
	Contratar Empleado
	</div>
	<div id="sectionLinks">
    <a href="EmpleadosList.do">Volver atrás</a>	
    </div>
	<div id="error">
	<html:errors />
	</div>
    </div> 
  <div id="content">     
	<div class="feature"> 
	<h2><a href="administrador.html">P&aacute;gina Administrador</a> > <a href="EmpleadosList.do">Empleados</a> > Contratar Empleado</h2>
	<h3>Datos del empleado</h3><hr><br>
  
  
    <html:form action="/Add"
      name="empleadoForm"
      type="mem.EmpleadoForm" ><br>
	  <div id="datos">
      <table>
        <tr>
          <td><bean:message key="app.nombre" />:</td>
          <td><html:text property="nombre" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.dni" />:</td>
          <td><html:text property="dni" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.direccion" />:</td>
          <td><html:text property="direccion" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.cp" />:</td>
          <td><html:text property="cp" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.poblacion" />:</td>
          <td><html:text property="poblacion" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.provincia" />:</td>
          <td><html:text property="provincia" /></td>
        </tr>
        <tr>
	  <td><bean:message key="app.telefono1" />:</td>
          <td><html:text property="telefono1" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.telefono2" />:</td>
          <td><html:text property="telefono2" /></td>
	</tr>
	<tr>
	  <td><bean:message key="app.movil" />:</td>
          <td><html:text property="movil" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>
	</tr>
	<tr>
          <td><bean:message key="app.fax" />:</td>
          <td><html:text property="fax" /></td>
	</tr>
        <tr>
          <td><bean:message key="app.perfil" />:</td>
          <td>
	    <html:select property="perfil" size="1">
              <html:option value="Administrativo">
	        <bean:message key="app.administrativo" />
	      </html:option>
              <html:option value="Abogado">
	        <bean:message key="app.abogado" />
	      </html:option>
            </html:select>
          </td>
	</tr>
	<tr>
          <td><bean:message key="app.nomina" />:</td>
          <td><html:text property="nomina" /></td>
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
