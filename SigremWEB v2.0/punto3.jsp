<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingenier�a del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>
 
    <%@ include file="/cabecera.html"%>

    <h3><a name="m3">3. Requisitos espec�ficos</a></h3> 
      <ul>
	<li><a class="enlace" href="#m3.1">3.1. Interfaces externas</a></li>
	<li><a class="enlace" href="#m3.2">3.2. Requisitos funcionales</a></li>
	<li><a class="enlace" href="#m3.3">3.3. Requisitos de rendimiento</a></li>
	<li><a class="enlace" href="#m3.4">3.4. Requisitos de base de datos l�gica</a></li>
	<li><a class="enlace" href="#m3.5">3.5. Restricciones de dise�o</a></li>
	<li><a class="enlace" href="#m3.6">3.6. Atributos de sistema software</a></li>
      </ul>
      <h4><a name="m3.1">3.1. Interfaces externas</a></h4>      
      <ol>
	<li>Interfaz de Usuario<br><br>
	  En una primera versi�n nuestra aplicaci�n funcionar� bajo un entorno de ventanas, y dentro de �ste,
	  la interfaz de comunicaci�n con el usuario se mostrar� en forma de formularios con ventanas para introducir datos en
	  los respectivos campos. A todo ello se tendr� acceso mediante el uso de teclado y rat�n.<br><br>
	  En una segunda versi�n se convertir� en una aplicaci�n cliente/servidor con salida web. De modo que los usuarios podr�n
	  acceder a ella mediante un navegador compatible con el est�ndar XHTML 1.0<br><br></li>
	<li>Interfaz del Hardware<br><br>No se ha definido.<br><br></li>
	<li>Interfaz del Software<br><br>En esta versi�n no se ha definido.<br><br></li>
	<li>Interfaces de Comunicaciones<br><br>En esta versi�n no se ha definido.<br></li>
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
      <p>En la versi�n monousuario del producto, habr� un �nico terminal de comunicaci�n con la aplicaci�n, y un �nico usuario
	interactuando con ella. Adem�s, la persistencia de los datos ser� consistente y fiable, al tiempo que se garantizar� su
	seguridad y confidencialidad. La respuesta de la aplicaci�n a las peticiones del usuario ser� inmediata.</p>
      <p>En la versi�n web:</p>
      <ul>
	<li>El sistema deber� soportar la carga simult�nea generada por un porcentaje de usuarios estimado en su momento por la
	  empresa gestora, que depender� del n�mero de clientes y de los casos que lleve cada d�a.</li>
	<li>El sistema completo deber� correr sobre un servidor de caracter�sticas medias.</li>
      </ul>
      <h4><a name="m3.4">3.4. Requisitos de base de datos l�gica</a></h4> 
      <ul>
	<li>En la primera versi�n del producto se dise�ar�n e implementar�n las estructuras de datos que dar�n soporte al 
	almacenamiento de los datos. Adem�s, se utilizar� un conjunto de ficheros XML para la persistencia de datos. Se definir�
	 un DTD adecuado para representar la informaci�n manejada por el software: datos de clientes, contratos, multas, recursos,
	  empleados, etc. Los ficheros tendr�n que ser por tanto XML v�lidos seg�n nuestro DTD</li>
	<li>La segunda versi�n del proyecto utilizar� una base de datos basada en SQL cuyo dise�o seguir� el modelo entidad-relaci�n</li>
      </ul>
      <h4><a name="m3.5">3.5. Restricciones de dise�o</a></h4>      
      <p>En la versi�n web el sistema basar� sus comunicaciones en protocolos est�ndar de Internet y los servidores deben ser
	capaces de atender consultas concurrentemente.Los distintos subsistemas deber�n tener un dise�o e implementaci�n sencillos,
	independientes de la plataforma o el lenguaje de programaci�n.</p>
      <h4><a name="m3.6">3.6. Atributos de sistema software</a></h4> 
      <ol>
	<li>Fiabilidad<br><br>
	  El sistema debe ser muy fiable en lo referente a la gesti�n de datos de la empresa, de tal modo que se garantice su
	  correcto almacenamiento y su persistencia. Debe proporcionar mecanismos de copia de seguridad para facilitar la 
	  recuperaci�n en caso de fallo, y un sistema de verificaci�n de datos para evitar trabajar con valores err�neos.<br><br></li>
	<li>Disponibilidad<br><br>
	  El sistema debe estar disponible en un r�gimen de 24 horas al d�a, todos los d�as del a�o. Con tiempos m�nimos de inicio y
	  recuperaci�n.<br><br></li>
	<li>Seguridad<br><br>
	  El sistema debe tener mecanismos de protecci�n adecuados para evitar el acceso a los datos a usuarios ajenos al entorno
	  de la aplicaci�n. Tambi�n se deben utilizar mecanismos para verificar la integridad de los datos. Todos los accesos a los
	  datos se archivar�n en un hist�rico de acceso, para verificar la legitimidad. En la versi�n web del producto se utilizar�n
	  mecanismos de cifrado de la informaci�n transmitida para proteger la confidencialidad. Adem�s, se establecer�n diferentes
	  niveles de acceso a los datos para los distintos usuarios que podr�n acceder a la aplicaci�n, as� como se restringir�n
	  las funcionalidades que cada uno de ellos podr�n realizar.<br><br></li>
	<li>Mantenibilidad<br><br>
	  El sistema estar� dividido en m�dulos de forma que se facilite el mantenimiento del software. Se adjuntar� tambi�n
	  documentaci�n sobre el proceso de desarrollo de la aplicaci�n y del modo en que est� construida.<br><br></li>
	<li>Portabilidad<br><br>
	  El sistema ser� una aplicaci�n Java est�ndar, por lo que podr� ser portada a todas las plataformas en las que est�
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
