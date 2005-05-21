<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  
  <head>
    <title>Ingenier�a del Software - SIGREM</title>
    <meta http-equiv="Content-Type" content= "text/html: charset=iso-8859-15">
    <link type="text/css" href="estilo_ayuda.css" rel="stylesheet" media="screen">
  </head>

  <body>

    <%@ include file="/cabecera.html"%>

    <h3><a name="m1"></a>1. Introducci�n</h3>
      <ul>
	<li><a class="enlace" href="#m1.1">1.1. Prop�sito</a></li>
	<li><a class="enlace" href="#m1.2">1.2. Alcance</a></li>
	<li><a class="enlace" href="#m1.3">1.3. Deficini�n, aberviaturas y acr�nimos</a></li>
	<li><a class="enlace" href="#m1.4">1.4. Referencias</a></li>
	<li><a class="enlace" href="#m1.5">1.5. Resumen</a></li>
      </ul>
      <h4><a name="m1.1"></a>1.1. Prop�sito</h4>
      <p>El objeto de la especificaci�n es definir de manera clara y precisa todos los requerimientos, funcionalidades y restricciones del
	sistema a construir. El documento tiene como audiencia al equipo de desarrollo, al cliente y a los usuarios finales del sistema.
        Ser� el canal de comunicaci�n entre las partes implicadas. Est� sujeta a revisiones por los desarrolladores y el cliente, que se
	recoger�n por medio de sucesivas versiones del documento, hasta alcanzar su aprobaci�n. Cuando eso ocurra, servir� de base al
	equipo de desarrollo para la construcci�n del nuevo sistema.</p>
      <h4><a name="m1.2"></a>1.2. Alcance</h4>	
	<p> El prop�sito del dise�o y desarrollo de SIGREM (Sistema Integral de Gesti�n de REcursos de Multas) es crear un producto que 
	satisfaga las necesidades de una empresa de gesti�n de recursos de multas de tr�fico, cuyo principal servicio ser� prestar
	asesoramiento jur�dico a sus clientes. �stos podr�n crear contratos con la empresa que har�n referencia a un veh�culo sobre el que
	pesa alguna multa, y a su vez podr�n solicitar un recurso para intentar anularla. La empresa asignar� entonces un abogado de su 
	plantilla a dicho recurso para intentar resolverlo favorablemente.</p>
      <p>La aplicaci�n desarrollada permitir�:</p>
      <ul>
	<li>Gestionar los contratos con los clientes, ya sea para crearlos, modificarlos o cancelarlos</li>
	<li>Gestionar la asignaci�n de tareas a los empleados
	<li>Gestionar la plantilla</li>
	<li>Gestionar la facturaci�n a los clientes</li>
	<li>Controlar la gesti�n de n�minas de los empleados</li>
	<li>Gestionar los datos de empleados y clientes</li>
	<li>Gestionar los contratos asociados a cada cliente</li>
	<li>Crear, consultar y modificar las multas asociadas a un contrato</li>
	<li> Crear, consultar y modificar los recursos asociados a las multas.</li>
      </ul>
      <p>La introducci�n de SIGREM facilitar� la gesti�n de la empresa, tanto en lo referente a la asignaci�n de tareas a los empleados,
	como en la relaci�n con los clientes, y en el control de la facturaci�n.<br>En la versi�n web de SIGREM tambi�n se permitir� a 
	los clientes y a los abogados de la empresa acceder, de manera inmediata y por medio de una conexi�n remota a trav�s de una
	p�gina web, a los datos relacionados con su perfil de usuario.</p>
      <h4><a name="m1.3"></a>1.3. Definiciones, abreviaturas y acr�nimos</h4>
      <ul>
	<li>SIGREM: Sistema Integral de Gesti�n de Recursos de Multas</li>
	<li>DTD: Definici�n del Tipo de Documento. Declaraci�n en un documento XML que especifica restricciones en la estructura del
	  mismo. Define los tipos de elementos, atributos y entidades permitidas, y puede expresar algunas limitaciones 
	  para combinarlos</li>
	<li>ERS: Especificaci�n de Requisitos Software</li>
	<li>Java: Lenguaje de programaci�n de Sun Microsystems. Se entiende que nos referimos a la versi�n 1.4 o superior</li>
	<li>JVM: Java Virtual Machine. M�quina Virtual Java de Sun Microsystems</li>
	<li>MySQL: Servidor de bases de datos relacional compatible, en gran parte, con el est�ndar ANSI SQL 99.
	  Suponemos que nos referimos a la versi�n 4 o superior</li>
	<li>Cliente: Persona f�sica o jur�dica que realiza un contrato con la empresa de gesti�n de recursos de multas para recurrir 
	  alguna multa</li>
	<li>Empleado: Abogado de la empresa de gesti�n de recursos de multas que representa a los clientes en los recursos</li>
	<li> Contrato: Acuerdo por el cual la empresa de gesti�n de recursos de multas se obliga a prestar un servicio a un cliente,
	  bajo dependencia o subordinaci�n y a cambio de una retribuci�n econ�mica</li>
	<li>Gestor: Empleado de la empresa que se encarga de la gesti�n global de la aplicaci�n y del control de la persistencia de 
	  los datos</li>
	<li>Recurso: Tr�mites realizados por los abogados empleados de la empresa en nombre de los clientes para intentar eliminar una
	  sanci�n</li>
      </ul>
      <h4><a name="m1.4"></a>1.4. Referencias</h4>
      <p>Para la redacci�n de este documento se han tenido en cuenta los siguientes documentos:</p>
      <ul>
	<li>IEEE Std 830-1994 IEEE Guide to Software Requeriments Specifications. IEEEStandards Board.</li>
	<li>Apuntes de la asignatura Ingenier�a del Software de Ingenier�a Inform�tica. Antonio Navarro, 2004. Web de la Facultad 
	  de Inform�tica de la UCM</li>
	<li>Roger S. Pressman. "Ingenier�a del Sotware. Un enfoque pr�ctico". 5� ed. 2002. McGraw-Hill</li>
      </ul>
      
      <h4><a name="m1.5"></a>1.5 Resumen</h4>
      <p>Este documento consta de tres secciones.</p>
      <ul>
	<li>Esta Secci�n 1 es la Introducci�n y proporciona una visi�n general de la ERS</li>
	<li>En la Secci�n 2, llamada Descripci�n General, se da una amplia visi�n general del sistema, con el fin de conocer las 
	  principales funciones que debe realizar, los datos asociados y los factores, restricciones, supuestos y dependencias que 
	  afectan al desarrollo, sin entrar en excesivos detalles.</li>
	<li>La Secci�n 3, Requisitos Espec�ficos, define detalladamente los requisitos que debe satisfacer el sistema, as� como
	  sus restricciones, y sus caracter�sticas m�s detalladas.</li>
      </ul>
    
    <hr>
 
    <p>
      <a href="http://validator.w3.org/check?uri=referer"><img class="logo"
          src="http://www.w3.org/Icons/valid-html401"
          alt="Valid HTML 4.01!" height="31" width="88"></a>
    </p>
  </body>
</html>
