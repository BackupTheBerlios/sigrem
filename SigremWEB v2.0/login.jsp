<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title><bean:message key="app.title" /></title>
    <link type="text/css" href="estilo.css" rel="stylesheet" media="screen">
		
  </head>

<body OnLoad="history.go(+1);"> 
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
    <h2>P&aacute;gina Usuarios </h2> 
  </div> 
  <div id="pageNav"> 
    <div id="sectionLinks"> 
    <a href="index.jsp">P&aacute;gina Principal</a><a href="login.jsp">Acceso Usuarios</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:sigremweb@gmail.com">Contacto</a></div> 
    <div class="relatedLinks"> 
      <h3><img src="images/sigrem_acercade.gif" alt="" width="150" />  </h3> 
    </div> 
	
	<div id="entrar">

	<html:form action="/LoginUsuario" name="usuarioForm" type="login.UsuarioForm" >
    <h3>Entrar</h3>
	<p>
	<bean:message key="app.nombreusuario" />
	</p>
	<p>
	<html:text property="nombreUsuario" />
	</p>
	<p>
	<bean:message key="app.password" />
	</p>
	<p>
	<html:password property="password" />
	</p>
	<p> <html:submit value="Entrar"/></p>
	<p><a href="addusuario.jsp">¿Nuevo usuario?</a></p>
	</html:form> 
	</div>
	<div id="error">
	<html:errors />
	</div>
  </div> 
  <div id="content"> 
    <div class="feature"> 
      <img src="images/sigrem.jpg" alt="Logo Sigrem" width="250"> 
      <h3>&iquest;Qu&eacute; es SigremWEB?</h3> 
      <p>
       	Producto que satisface las necesidades de una empresa de 
		gestión de recursos de multas de tráfico,cuyo principal 
		servicio será prestar asesoramiento jurídico a sus
		clientes. Éstos podrán crear contratos con la empresa que
		harán referencia a un vehículo sobre el que pesa alguna
		multa,y a su vez podrán solicitar un recurso para intentar
		anularla. La empresa asignará entonces un abogado de su
		plantilla a dicho recurso para intentar resolverlo
		favorablemente.
      </p> 
    </div> 
    <div class="story"> 
      <h3>Nuestros servicios </h3> 
      <p>
       	La aplicación desarrollada nos permite: <br>
		<br>
		• Gestionar los contratos con los clientes, ya sea para
		  crearlos, modificarlos o cancelarlos. <br>
		• Gestionar la asignación de tareas a los empleados. <br>
		• Gestionar la plantilla. <br>
		• Gestionar la facturación a los clientes. <br>
		• Controlar la gestión de nóminas de los empleados. <br>
		• Gestionar los datos de empleados y clientes. <br>
		• Gestionar los contratos asociados a cada cliente. <br>
		• Crear, consultar y modificar las multas asociadas a un
		  contrato. <br>
		• Crear, consultar y modificar los recursos asociados a
		  las multas. <br>
      </p> 
      <p>
       	La introducción de SIGREM facilitará la gestión de la 
		empresa, tanto en lo referente a la asignación de tareas 
		a los empleados, como en la relación con los clientes, y 
		en el control de la facturación.<br>
		Y a clientes y empleados acceder a datos propos de su perfil
		de manera online.
      </p> 
    </div> 
  
  </div> 
   <div id="siteInfo"><a href="mailto:sigremweb@gmail.com">Contacto</a> | &copy;2005
  SigremWEB</div> 
</div> 
<!--end pagecell1--> 
<br> 

    
  </body>
</html>
