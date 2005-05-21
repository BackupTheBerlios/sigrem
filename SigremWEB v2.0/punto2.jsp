<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingeniería del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>

    <%@ include file="/cabecera.html"%>    

    <h3><a name="m2">2. Descripción general</a></h3>
      <ul>
	<li><a class="enlace" href="#m2.1">2.1. Perspectiva del producto</a></li>
	<li><a class="enlace" href="#m2.2">2.2. Funciones del producto</a></li>
	<li><a class="enlace" href="#m2.3">2.3. Características del usuario</a></li>
	<li><a class="enlace" href="#m2.4">2.4. Restricciones</a></li>
	<li><a class="enlace" href="#m2.5">2.5. Supuestos y dependencias</a></li>
	<li><a class="enlace" href="#m2.6">2.6. Requisitos futuros</a></li>
      </ul>
      <h4><a name="m2.1"></a>2.1. Perspectiva del producto</h4>
      <p>El presente producto está pensado para ser implementado en dos fases:</p>
      <ul>
	<li> En una primera versión funcionará como una aplicación Java standalone monousuario y sin soporte de base de datos
	  externa. La persistencia de los datos se llevará a cabo mediante ficheros de texto en formato XML. Podrá funcionar
	   en cualquier equipo con una JVM 1.4 o superior.</li>
	<li>En una segunda versión se transformará en una aplicación web, utilizando JSP y servlets, y el servidor Tomcat 4. 
	  Será multiusuario y con soporte de base de datos MySQL.</li>
      </ul>
      <p>El producto en principio no interactuará con ningún otro sistema, aunque podrán exportarse sus datos a diferentes
	formatos electrónicos. Para ello se utilizará XML estándar. Tendrá una interfaz visual cómoda y fácil de utilizar
        por los usuarios.</p>
      <h4><a name="m2.2"></a>2.2. Funciones del producto</h4>      
      <p>Las funcionalidades prestadas por el producto desarrollado son las siguientes:</p>
      <ul>
	<li>Permitir la creación, modificación, consulta y cancelación de los contratos de los clientes</li>
	<li>Añadir, modificar, consultar y eliminar multas a los contratos</li>
	<li>Facilitar la asignacion de los abogados contratados por la empresa a los recursos interpuestos por los clientes 
	  sobre sus multas</li>
	<li>Añadir, consultar, modificar y eliminar recursos a las multas asociadas a los contratos de los clientes</li>
	<li>Agilizar el proceso de facturación de la empresa en relación a los contratos establecidos con los clientes</li>
	<li>Controlar la gestión de nóminas de los empleados</li>
	<li>Consultar y modificar los datos de los empleados de la empresa y de los clientes</li>
	<li>Gestionar la plantilla de la empresa</li>
      </ul>
      <h4><a name="m2.3"></a>2.3. Características del usuario</h4>      
      <p>Los usuarios del producto no necesitan tener ningún tipo de experiencia previa para poder utilizarlo correctamente.
	Sólo deberán saber interactuar adecuadamente con la interfaz gráfica, que a su vez será amigable y de fácil manejo.Dado que
	la primera versión del producto será monousuario, éste deberá tener un amplio conocimento del funcionamiento de la empresa
	para poder hacer uso de todas las funcionalidades de la aplicación.</p>
      <p>En la versión web del producto habrá tres tipos de usuarios, que podemos agrupar en dos clases:</p>
      <ul>
	<li>Administrador: tendrá acceso a todas las funcionalidades y a todos los datos de la aplicación. Deberá tener un amplio
	  conocimento del funcionamiento de la empresa.</li>
	<li>Clientes y Abogados: podrán acceder y modificar únicamente la parte de los datos relacionados con su perfil de
	  usuario. Las operaciones que podrán realizar en la aplicación estarán restringidas.</li>
      </ul>
      <p>La comunicación con la aplicación para cada uno de ellos será por medio de una interfaz gráfica de fácil manejo, y que
	restingirá las operaciones permitidas a cada tipo de usuario. </p>
      <h4><a name="m2.4"></a>2.4. Restricciones</h4>      
      <p>La aplicación está programada en lenguajes independientes de la plataforma hardware. Por tanto, sus restricciones en este
	sentido son mínimas.</p>
      <p>La persistencia de datos en formato XML permitirá que el producto desarrollado pueda comunicarse con
	otras aplicaciones, pero éstas en ningún caso impondrán restricciones adicionales a al ejecución de la propia aplicación.
	Se controlarán los intentos de acceso no autorizados a información sensible. </p>
      <h4><a name="m2.5"></a>2.5. Supuestos y dependencias</h4>   
      <p>Supondremos que los requisitos descritos en la ERS serán estables una vez que hayan sido aprobados por la empresa a la
	que va dirigida el producto. Cualquier petición de cambio en la ERS debe ser aprobada por todas las partes implicadas y
	gestionada por el grupo de desarrollo.</p>
      <p>La aplicación monousuario podrá funcionar en cualquier equipo con una JVM 1.4 o superior. Será, por tanto, casi totalmente
	independiente del sistema operativo en el que se ejecute. La versión web dependerá de un servidor Tomcat 4 y MySQL 4 para
	tener acceso a los datos. La parte cliente sólo necesitará un navegador compatible con el estándar XHTML 1.0. para poder
	acceder correctamente a la interfaz de la aplicación.</p>
      <h4><a name="m2.6"></a>2.6. Requisitos futuros</h4>
      <p>En la segunda versión del producto, al convertirse en una aplicación multiusuario, tendrá que garantizarse la correcta
	gestión de la concurrencia de usuarios. Además, exisitirán tres perfiles de usuario que podrán acceder a la aplicación:</p>
      <ul>
	<li>los abogados contratados por la empresa</li>
	<li>los clientes que soliciten los servicios de la empresa</li>
	<li>los administradores pertenecientes a la empresa</li>
      </ul>
      <p>Cada uno de ellos interactuará con el producto de una forma distinta, y tendrá únicamente acceso a la parte de
	la aplicación asociada con su perfil. Por lo tanto, sus interfaces de comunicación con el producto serán diferentes.</p>

    <hr>
  
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>
