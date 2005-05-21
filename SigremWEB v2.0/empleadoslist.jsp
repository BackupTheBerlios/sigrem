<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- DW6 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
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
	Men&uacute; Empleados
	</div>
	<div id="sectionLinks">
    <a href="addempleado.jsp">Contratar empleado</a>
    <a href="administrador.html">Volver atrás</a>
    </div>
	
  </div> 

  <div id="content">     
	<div class="feature"> 
	<h2><a href="administrador.html">P&aacute;gina Administrador</a> > Empleados</h2>
	<h3>Datos generales de los empleados</h3><hr><br>
    <table>
	<tr>
        <th><bean:message key="app.codigoe" /></th>
        <th><bean:message key="app.nombre" /></th>
        <th><bean:message key="app.dni" /></th>
        <th><bean:message key="app.perfil" /></th>
        <th><bean:message key="app.nomina" /></th>
		<th><bean:message key="app.telefono1" /></th>
		<th><bean:message key="app.movil" /></th>
				<th><bean:message key="app.fax" /></th>  
        
		 <th colspan="2"></th>
      
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="empleado" name="empleados">
	<tr>
	  <td>
            <bean:write name="empleado" property="codigo" />
	  </td>
	  <td>
            <bean:write name="empleado" property="nombre" />
	  </td>
	  <td>
            <bean:write name="empleado" property="dni" />
	  </td>
	  <td>
            <bean:write name="empleado" property="perfil" />
	  </td>
	  <td>
            <bean:write name="empleado" property="nomina" />
	  </td>
	  <td>
            <bean:write name="empleado" property="telefono1" />
	  </td>
	  <td>
            <bean:write name="empleado" property="movil" />
	  </td>
	<td>
            <bean:write name="empleado" property="fax" />
	  </td>
	 
	  <td>
            <a href="Edit.do?codigo=<bean:write name="empleado"
	      property="codigo" />"><img alt="Modificar el empleado" src="images/tick.gif" /></a>
		</td>
		<td>
	    <a href="Delete.do?codigo=<bean:write name="empleado"
	      property="codigo" />"><img alt="Eliminar al empleado" src="images/del.gif" /></a>
	  </td>
	</tr>
      </logic:iterate>
    
    </table>
	

	</div>
	
	<div class="masdatos">
	<h3>Más datos</h3><hr><br>
	
	<table>
      <tr>
        <th><bean:message key="app.codigoe" /></th>
        <th><bean:message key="app.direccion" /></th>
        <th><bean:message key="app.cp" /></th>
        <th><bean:message key="app.poblacion" /></th>
        <th><bean:message key="app.provincia" /></th>
        
        <th><bean:message key="app.telefono2" /></th>
        
		<th><bean:message key="app.email" /></th>              

      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="empleado" name="empleados">
	<tr>
	  <td>
            <bean:write name="empleado" property="codigo" />
	  </td>
	  <td>
            <bean:write name="empleado" property="direccion" />
	  </td>
	  <td>
            <bean:write name="empleado" property="cp" />
	  </td>
	  <td>
            <bean:write name="empleado" property="poblacion" />
	  </td>
	  <td>
            <bean:write name="empleado" property="provincia" />
	  </td>
	  
	  <td>
            <bean:write name="empleado" property="telefono2" />
	  </td>
	    <td>
            <bean:write name="empleado" property="email" />
	  </td>
	   

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


