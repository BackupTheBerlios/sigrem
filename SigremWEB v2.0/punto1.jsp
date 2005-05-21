<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingeniería del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>

    <%@ include file="/cabecera.html"%>

    <h3><a name="m1"></a>1. Introducción</h3>
      <ul>
	<li><a class="enlace" href="#m1.1">1.1. Propósito</a></li>
	<li><a class="enlace" href="#m1.2">1.2. Alcance</a></li>
	<li><a class="enlace" href="#m1.3">1.3. Deficinión, aberviaturas y acrónimos</a></li>
	<li><a class="enlace" href="#m1.4">1.4. Referencias</a></li>
	<li><a class="enlace" href="#m1.5">1.5. Resumen</a></li>
      </ul>
      <h4><a name="m1.1"></a>1.1. Propósito</h4>
      <p>El objeto de la especificación es definir de manera clara y precisa todos los requerimientos, funcionalidades y restricciones del
	sistema a construir. El documento tiene como audiencia al equipo de desarrollo, al cliente y a los usuarios finales del sistema.
        Será el canal de comunicación entre las partes implicadas. Está sujeta a revisiones por los desarrolladores y el cliente, que se
	recogerán por medio de sucesivas versiones del documento, hasta alcanzar su aprobación. Cuando eso ocurra, servirá de base al
	equipo de desarrollo para la construcción del nuevo sistema.</p>
      <h4><a name="m1.2"></a>1.2. Alcance</h4>	
	<p> El propósito del diseño y desarrollo de SIGREM (Sistema Integral de Gestión de REcursos de Multas) es crear un producto que 
	satisfaga las necesidades de una empresa de gestión de recursos de multas de tráfico, cuyo principal servicio será prestar
	asesoramiento jurídico a sus clientes. Éstos podrán crear contratos con la empresa que harán referencia a un vehículo sobre el que
	pesa alguna multa, y a su vez podrán solicitar un recurso para intentar anularla. La empresa asignará entonces un abogado de su 
	plantilla a dicho recurso para intentar resolverlo favorablemente.</p>
      <p>La aplicación desarrollada permitirá:</p>
      <ul>
	<li>Gestionar los contratos con los clientes, ya sea para crearlos, modificarlos o cancelarlos</li>
	<li>Gestionar la asignación de tareas a los empleados
	<li>Gestionar la plantilla</li>
	<li>Gestionar la facturación a los clientes</li>
	<li>Controlar la gestión de nóminas de los empleados</li>
	<li>Gestionar los datos de empleados y clientes</li>
	<li>Gestionar los contratos asociados a cada cliente</li>
	<li>Crear, consultar y modificar las multas asociadas a un contrato</li>
	<li> Crear, consultar y modificar los recursos asociados a las multas.</li>
      </ul>
      <p>La introducción de SIGREM facilitará la gestión de la empresa, tanto en lo referente a la asignación de tareas a los empleados,
	como en la relación con los clientes, y en el control de la facturación.<br>En la versión web de SIGREM también se permitirá a 
	los clientes y a los abogados de la empresa acceder, de manera inmediata y por medio de una conexión remota a través de una
	página web, a los datos relacionados con su perfil de usuario.</p>
      <h4><a name="m1.3"></a>1.3. Definiciones, abreviaturas y acrónimos</h4>
      <ul>
	<li>SIGREM: Sistema Integral de Gestión de Recursos de Multas</li>
	<li>DTD: Definición del Tipo de Documento. Declaración en un documento XML que especifica restricciones en la estructura del
	  mismo. Define los tipos de elementos, atributos y entidades permitidas, y puede expresar algunas limitaciones 
	  para combinarlos</li>
	<li>ERS: Especificación de Requisitos Software</li>
	<li>Java: Lenguaje de programación de Sun Microsystems. Se entiende que nos referimos a la versión 1.4 o superior</li>
	<li>JVM: Java Virtual Machine. Máquina Virtual Java de Sun Microsystems</li>
	<li>MySQL: Servidor de bases de datos relacional compatible, en gran parte, con el estándar ANSI SQL 99.
	  Suponemos que nos referimos a la versión 4 o superior</li>
	<li>Cliente: Persona física o jurídica que realiza un contrato con la empresa de gestión de recursos de multas para recurrir 
	  alguna multa</li>
	<li>Empleado: Abogado de la empresa de gestión de recursos de multas que representa a los clientes en los recursos</li>
	<li> Contrato: Acuerdo por el cual la empresa de gestión de recursos de multas se obliga a prestar un servicio a un cliente,
	  bajo dependencia o subordinación y a cambio de una retribución económica</li>
	<li>Gestor: Empleado de la empresa que se encarga de la gestión global de la aplicación y del control de la persistencia de 
	  los datos</li>
	<li>Recurso: Trámites realizados por los abogados empleados de la empresa en nombre de los clientes para intentar eliminar una
	  sanción</li>
      </ul>
      <h4><a name="m1.4"></a>1.4. Referencias</h4>
      <p>Para la redacción de este documento se han tenido en cuenta los siguientes documentos:</p>
      <ul>
	<li>IEEE Std 830-1994 IEEE Guide to Software Requeriments Specifications. IEEEStandards Board.</li>
	<li>Apuntes de la asignatura Ingeniería del Software de Ingeniería Informática. Antonio Navarro, 2004. Web de la Facultad 
	  de Informática de la UCM</li>
	<li>Roger S. Pressman. "Ingeniería del Sotware. Un enfoque práctico". 5ª ed. 2002. McGraw-Hill</li>
      </ul>
      
      <h4><a name="m1.5"></a>1.5 Resumen</h4>
      <p>Este documento consta de tres secciones.</p>
      <ul>
	<li>Esta Sección 1 es la Introducción y proporciona una visión general de la ERS</li>
	<li>En la Sección 2, llamada Descripción General, se da una amplia visión general del sistema, con el fin de conocer las 
	  principales funciones que debe realizar, los datos asociados y los factores, restricciones, supuestos y dependencias que 
	  afectan al desarrollo, sin entrar en excesivos detalles.</li>
	<li>La Sección 3, Requisitos Específicos, define detalladamente los requisitos que debe satisfacer el sistema, así como
	  sus restricciones, y sus características más detalladas.</li>
      </ul>
    
    <hr>
 
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>
