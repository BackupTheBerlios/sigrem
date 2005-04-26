/////////////////////////////////////////////
//DAME CLIENTE POR CODIGO
SELECT *
FROM clientes
WHERE clientes.codigo=="CL000"

//DAME CLIENTE POR NOMBRE
SELECT *
FROM clientes
WHERE clientes.nombre=="nombre del individuo"

//DAME CLIENTE POR DNI
SELECT *
FROM clientes
WHERE clientes.dni=="dni del individuo"

//DAME CODIGOSCONTRATO DEL CLIENTE 
SELECT codigoContrato
FROM contratos
WHERE contratos.codigoCliente=="CL000"

/////////////////////////////////////////////////////

//DAME CONTRATO POR CODIGO
SELECT *
FROM contratos
WHERE contratos.codigoContrato=="CO000"

//DAME CONTRATO POR MATRICULA
SELECT *
FROM contratos
WHERE contratos.matricula=="matricula del contrato"

//DAME CODIGOSMULTA DEL CONTRATO 
SELECT codigoMulta
FROM multas
WHERE multas.codigoContrato=="CO000"


//////////////////////////////////////////////////
//DAME MULTA POR CODIGO
SELECT *
FROM multas
WHERE multas.codigoMulta=="MU000"

//DAME MULTA POR EXPEDIENTE
SELECT *
FROM multas
WHERE multas.expediente=="expediente de la multa"

//DAME MULTA POR BOLETIN
SELECT *
FROM multas
WHERE multas.boletin=="boletin de la mulata"


//DAME CODIGOSRECURSO DE LA MULTA 
SELECT codigoRecurso
FROM recursos
WHERE recursos.codigoMulta=="MU000"




////////////////////////////////////////////////
//DAME RECURSO POR CODIGO
SELECT *
FROM recursos
WHERE recursos.codigoRecurso=="RE000"

//DAME CODIGOEMPLEADO DEL CODIGORECURSO
SELECT codigoEmpleado
FROM asignadoRecursoEmpleado
WHERE asignadoRecursoEmpleado.codigoRecurso=="RE000"



////////////////////////////////////////////////////////
//CONSULTA DAME EMPLEADO POR CODIGO
SELECT *
FROM empleados
WHERE empleados.codigo=="EM000"

//CONSULTA DAME EMPLEADO POR NOMBRE
SELECT *
FROM empleados
WHERE empleados.nombre=="nombre del individuo"

//CONSULTA DAME EMPLEADO POR DNI
SELECT *
FROM empleados
WHERE empleados.dni=="dni del individuo"

//DAME CODIGORECURSO DEL CODIGOEMPLEADO
SELECT codigoRecurso
FROM asignadoEmpleadoRecurso
WHERE asignadoEmpleadoRecurso.codigoEmpleado=="EM000"


/////////////////////
//EJEMPLOS DEL CONTENIDO DELAS TABLAS
insert into clientes values("CL000", "Fonsi Nieto", "111110", "C\", "28000", "sur","madrid","91...1","91...2","6...","0@sigrem.org","91...fax");

insert into contratos values("CO005", "M-3675-RC", "10-8-2003", "no finalizado", "CL005");

insert into multas values("MU000", "e", "b", "10-1-2004", "Velocidad", "muuuu chunga", "CO000");

insert into recursos values("RE003", "10-4-2004", "10-5-2004", "finalizada", "EM002", "favorable", "MU001");

insert into empleados values("EM000", "abogado","Javi", "222220", "C\", "28000","sur","madrid","91...1","91...2","6...","20@sigrem.org","91...fax","1000");

insert into asignadoRecursoEmpleado values("RE000","EM000");

