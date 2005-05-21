<jsp:useBean id="requisito" class="bean.Requisito" scope="session" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>

  <head>
    <title>Ingeniería del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>

    <%@ include file="/cabecera.html"%>

    <p>Datos del requisito funcional <%=session.getAttribute("numero")%>
    <ul>
	<li>Funcion: <jsp:getProperty name="requisito" property="funcion"/></li>
	<li>Descripcion: <jsp:getProperty name="requisito" property="descripcion"/></li>
	<li>Entrada: <jsp:getProperty name="requisito" property="entrada"/></li>
    	<li>Salida: <jsp:getProperty name="requisito" property="salida"/></li>
    	<li>Origen: <jsp:getProperty name="requisito" property="origen"/></li>
    	<li>Destino: <jsp:getProperty name="requisito" property="destino"/></li>
    	<li>Necesita: <jsp:getProperty name="requisito" property="necesita"/></li>
    	<li>Precondicion: <jsp:getProperty name="requisito" property="precondicion"/></li>
    	<li>Postcondicion: <jsp:getProperty name="requisito" property="postcondicion"/></li>
    	<li>Efectos laterales: <jsp:getProperty name="requisito" property="efectos"/></li>
    </ul>

    <hr>
  
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>