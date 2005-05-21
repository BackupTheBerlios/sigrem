<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingenier�a del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>

    <%@ include file="/cabecera.html"%>    

    <h3><a name="m2">2. Descripci�n general</a></h3>
      <ul>
	<li><a class="enlace" href="#m2.1">2.1. Perspectiva del producto</a></li>
	<li><a class="enlace" href="#m2.2">2.2. Funciones del producto</a></li>
	<li><a class="enlace" href="#m2.3">2.3. Caracter�sticas del usuario</a></li>
	<li><a class="enlace" href="#m2.4">2.4. Restricciones</a></li>
	<li><a class="enlace" href="#m2.5">2.5. Supuestos y dependencias</a></li>
	<li><a class="enlace" href="#m2.6">2.6. Requisitos futuros</a></li>
      </ul>
      <h4><a name="m2.1"></a>2.1. Perspectiva del producto</h4>
      <p>El presente producto est� pensado para ser implementado en dos fases:</p>
      <ul>
	<li> En una primera versi�n funcionar� como una aplicaci�n Java standalone monousuario y sin soporte de base de datos
	  externa. La persistencia de los datos se llevar� a cabo mediante ficheros de texto en formato XML. Podr� funcionar
	   en cualquier equipo con una JVM 1.4 o superior.</li>
	<li>En una segunda versi�n se transformar� en una aplicaci�n web, utilizando JSP y servlets, y el servidor Tomcat 4. 
	  Ser� multiusuario y con soporte de base de datos MySQL.</li>
      </ul>
      <p>El producto en principio no interactuar� con ning�n otro sistema, aunque podr�n exportarse sus datos a diferentes
	formatos electr�nicos. Para ello se utilizar� XML est�ndar. Tendr� una interfaz visual c�moda y f�cil de utilizar
        por los usuarios.</p>
      <h4><a name="m2.2"></a>2.2. Funciones del producto</h4>      
      <p>Las funcionalidades prestadas por el producto desarrollado son las siguientes:</p>
      <ul>
	<li>Permitir la creaci�n, modificaci�n, consulta y cancelaci�n de los contratos de los clientes</li>
	<li>A�adir, modificar, consultar y eliminar multas a los contratos</li>
	<li>Facilitar la asignacion de los abogados contratados por la empresa a los recursos interpuestos por los clientes 
	  sobre sus multas</li>
	<li>A�adir, consultar, modificar y eliminar recursos a las multas asociadas a los contratos de los clientes</li>
	<li>Agilizar el proceso de facturaci�n de la empresa en relaci�n a los contratos establecidos con los clientes</li>
	<li>Controlar la gesti�n de n�minas de los empleados</li>
	<li>Consultar y modificar los datos de los empleados de la empresa y de los clientes</li>
	<li>Gestionar la plantilla de la empresa</li>
      </ul>
      <h4><a name="m2.3"></a>2.3. Caracter�sticas del usuario</h4>      
      <p>Los usuarios del producto no necesitan tener ning�n tipo de experiencia previa para poder utilizarlo correctamente.
	S�lo deber�n saber interactuar adecuadamente con la interfaz gr�fica, que a su vez ser� amigable y de f�cil manejo.Dado que
	la primera versi�n del producto ser� monousuario, �ste deber� tener un amplio conocimento del funcionamiento de la empresa
	para poder hacer uso de todas las funcionalidades de la aplicaci�n.</p>
      <p>En la versi�n web del producto habr� tres tipos de usuarios, que podemos agrupar en dos clases:</p>
      <ul>
	<li>Administrador: tendr� acceso a todas las funcionalidades y a todos los datos de la aplicaci�n. Deber� tener un amplio
	  conocimento del funcionamiento de la empresa.</li>
	<li>Clientes y Abogados: podr�n acceder y modificar �nicamente la parte de los datos relacionados con su perfil de
	  usuario. Las operaciones que podr�n realizar en la aplicaci�n estar�n restringidas.</li>
      </ul>
      <p>La comunicaci�n con la aplicaci�n para cada uno de ellos ser� por medio de una interfaz gr�fica de f�cil manejo, y que
	restingir� las operaciones permitidas a cada tipo de usuario. </p>
      <h4><a name="m2.4"></a>2.4. Restricciones</h4>      
      <p>La aplicaci�n est� programada en lenguajes independientes de la plataforma hardware. Por tanto, sus restricciones en este
	sentido son m�nimas.</p>
      <p>La persistencia de datos en formato XML permitir� que el producto desarrollado pueda comunicarse con
	otras aplicaciones, pero �stas en ning�n caso impondr�n restricciones adicionales a al ejecuci�n de la propia aplicaci�n.
	Se controlar�n los intentos de acceso no autorizados a informaci�n sensible. </p>
      <h4><a name="m2.5"></a>2.5. Supuestos y dependencias</h4>   
      <p>Supondremos que los requisitos descritos en la ERS ser�n estables una vez que hayan sido aprobados por la empresa a la
	que va dirigida el producto. Cualquier petici�n de cambio en la ERS debe ser aprobada por todas las partes implicadas y
	gestionada por el grupo de desarrollo.</p>
      <p>La aplicaci�n monousuario podr� funcionar en cualquier equipo con una JVM 1.4 o superior. Ser�, por tanto, casi totalmente
	independiente del sistema operativo en el que se ejecute. La versi�n web depender� de un servidor Tomcat 4 y MySQL 4 para
	tener acceso a los datos. La parte cliente s�lo necesitar� un navegador compatible con el est�ndar XHTML 1.0. para poder
	acceder correctamente a la interfaz de la aplicaci�n.</p>
      <h4><a name="m2.6"></a>2.6. Requisitos futuros</h4>
      <p>En la segunda versi�n del producto, al convertirse en una aplicaci�n multiusuario, tendr� que garantizarse la correcta
	gesti�n de la concurrencia de usuarios. Adem�s, exisitir�n tres perfiles de usuario que podr�n acceder a la aplicaci�n:</p>
      <ul>
	<li>los abogados contratados por la empresa</li>
	<li>los clientes que soliciten los servicios de la empresa</li>
	<li>los administradores pertenecientes a la empresa</li>
      </ul>
      <p>Cada uno de ellos interactuar� con el producto de una forma distinta, y tendr� �nicamente acceso a la parte de
	la aplicaci�n asociada con su perfil. Por lo tanto, sus interfaces de comunicaci�n con el producto ser�n diferentes.</p>

    <hr>
  
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>
