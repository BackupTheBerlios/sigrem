<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingeniería del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>
 
    <%@ include file="/cabecera.html"%>

    <h3><a name="m3">3. Requisitos específicos</a></h3> 
      <ul>
	<li><a class="enlace" href="#m3.1">3.1. Interfaces externas</a></li>
	<li><a class="enlace" href="#m3.2">3.2. Requisitos funcionales</a></li>
	<li><a class="enlace" href="#m3.3">3.3. Requisitos de rendimiento</a></li>
	<li><a class="enlace" href="#m3.4">3.4. Requisitos de base de datos lógica</a></li>
	<li><a class="enlace" href="#m3.5">3.5. Restricciones de diseño</a></li>
	<li><a class="enlace" href="#m3.6">3.6. Atributos de sistema software</a></li>
      </ul>
      <h4><a name="m3.1">3.1. Interfaces externas</a></h4>      
      <ol>
	<li>Interfaz de Usuario<br><br>
	  En una primera versión nuestra aplicación funcionará bajo un entorno de ventanas, y dentro de éste,
	  la interfaz de comunicación con el usuario se mostrará en forma de formularios con ventanas para introducir datos en
	  los respectivos campos. A todo ello se tendrá acceso mediante el uso de teclado y ratón.<br><br>
	  En una segunda versión se convertirá en una aplicación cliente/servidor con salida web. De modo que los usuarios podrán
	  acceder a ella mediante un navegador compatible con el estándar XHTML 1.0<br><br></li>
	<li>Interfaz del Hardware<br><br>No se ha definido.<br><br></li>
	<li>Interfaz del Software<br><br>En esta versión no se ha definido.<br><br></li>
	<li>Interfaces de Comunicaciones<br><br>En esta versión no se ha definido.<br></li>
      </ol>
      <h4><a name="m3.2">3.2. Requisitos funcionales</a></h4>
      <p>Selecciona un requisito para consultar:</p>
      <form method="post" action="servlet/RequisitoServlet">
	<p><select name="requisito" size="4">
		<option>1.1<option>1.2<option>1.3<option>1.4<option>1.5<option>1.6
		<option>2.1<option>2.2<option>2.3<option>2.4<option>2.5
		<option>3.1<option>3.2<option>3.3<option>3.4<option>3.5<option>3.6
		<option>4.1<option>4.2<option>4.3<option>4.4
		<option>5.1<option>5.2<option>5.3
		<option>6.1<option>6.2<option>6.3<option>6.4<option>6.5<option>6.6
	</select></p>
	<p><input type="submit" value="Consultar"></p>
      </form>
      <h4><a name="m3.3">3.3. Requisitos de rendimiento</a></h4>
      <p>En la versión monousuario del producto, habrá un único terminal de comunicación con la aplicación, y un único usuario
	interactuando con ella. Además, la persistencia de los datos será consistente y fiable, al tiempo que se garantizará su
	seguridad y confidencialidad. La respuesta de la aplicación a las peticiones del usuario será inmediata.</p>
      <p>En la versión web:</p>
      <ul>
	<li>El sistema deberá soportar la carga simultánea generada por un porcentaje de usuarios estimado en su momento por la
	  empresa gestora, que dependerá del número de clientes y de los casos que lleve cada día.</li>
	<li>El sistema completo deberá correr sobre un servidor de características medias.</li>
      </ul>
      <h4><a name="m3.4">3.4. Requisitos de base de datos lógica</a></h4> 
      <ul>
	<li>En la primera versión del producto se diseñarán e implementarán las estructuras de datos que darán soporte al 
	almacenamiento de los datos. Además, se utilizará un conjunto de ficheros XML para la persistencia de datos. Se definirá
	 un DTD adecuado para representar la información manejada por el software: datos de clientes, contratos, multas, recursos,
	  empleados, etc. Los ficheros tendrán que ser por tanto XML válidos según nuestro DTD</li>
	<li>La segunda versión del proyecto utilizará una base de datos basada en SQL cuyo diseño seguirá el modelo entidad-relación</li>
      </ul>
      <h4><a name="m3.5">3.5. Restricciones de diseño</a></h4>      
      <p>En la versión web el sistema basará sus comunicaciones en protocolos estándar de Internet y los servidores deben ser
	capaces de atender consultas concurrentemente.Los distintos subsistemas deberán tener un diseño e implementación sencillos,
	independientes de la plataforma o el lenguaje de programación.</p>
      <h4><a name="m3.6">3.6. Atributos de sistema software</a></h4> 
      <ol>
	<li>Fiabilidad<br><br>
	  El sistema debe ser muy fiable en lo referente a la gestión de datos de la empresa, de tal modo que se garantice su
	  correcto almacenamiento y su persistencia. Debe proporcionar mecanismos de copia de seguridad para facilitar la 
	  recuperación en caso de fallo, y un sistema de verificación de datos para evitar trabajar con valores erróneos.<br><br></li>
	<li>Disponibilidad<br><br>
	  El sistema debe estar disponible en un régimen de 24 horas al día, todos los días del año. Con tiempos mínimos de inicio y
	  recuperación.<br><br></li>
	<li>Seguridad<br><br>
	  El sistema debe tener mecanismos de protección adecuados para evitar el acceso a los datos a usuarios ajenos al entorno
	  de la aplicación. También se deben utilizar mecanismos para verificar la integridad de los datos. Todos los accesos a los
	  datos se archivarán en un histórico de acceso, para verificar la legitimidad. En la versión web del producto se utilizarán
	  mecanismos de cifrado de la información transmitida para proteger la confidencialidad. Además, se establecerán diferentes
	  niveles de acceso a los datos para los distintos usuarios que podrán acceder a la aplicación, así como se restringirán
	  las funcionalidades que cada uno de ellos podrán realizar.<br><br></li>
	<li>Mantenibilidad<br><br>
	  El sistema estará dividido en módulos de forma que se facilite el mantenimiento del software. Se adjuntará también
	  documentación sobre el proceso de desarrollo de la aplicación y del modo en que está construida.<br><br></li>
	<li>Portabilidad<br><br>
	  El sistema será una aplicación Java estándar, por lo que podrá ser portada a todas las plataformas en las que esté
	  disponible una JVM 1.4<br></li>
      </ol>
    <hr>
 
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>
