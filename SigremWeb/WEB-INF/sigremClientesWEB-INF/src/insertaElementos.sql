insert into contratos values("CO210", "MA-2245-WR", "10-3-2003", "no finalizado", "CL000");
insert into contratos values("CO211", "MA-4355-BR", "10-4-2003", "no finalizado", "CL001");
insert into contratos values("CO212", "MA-3345-TR", "10-5-2003", "no finalizado", "CL002");
insert into contratos values("CO213", "MA-7867-AA", "10-6-2003", "no finalizado", "CL003");
insert into contratos values("CO214", "MA-6276-WX", "10-7-2003", "no finalizado", "CL004");
insert into contratos values("CO215", "MA-3675-RC", "10-8-2003", "no finalizado", "CL005");

insert into multas values("MU110", "a1", "d1", "10-1-2005", "Velocidad", "muuuu chunga", "CO210");
insert into multas values("MU111", "a2", "d2", "10-1-2005", "Velocidad", "muuuu chunga", "CO211");
insert into multas values("MU112", "a3", "d3", "10-1-2005", "Velocidad", "muuuu chunga", "CO212");
insert into multas values("MU113", "a4", "d4", "10-1-2005", "Velocidad", "muuuu chunga", "CO210");


insert into recursos values("RE110", "10-1-2005", "10-2-2005", "tramite", "EM000", "va a mejor", "MU110");
insert into recursos values("RE111", "10-2-2005", "10-3-2005", "iniciando", "Sin Asignar", "sin remedio", "MU113");
insert into recursos values("RE112", "10-3-2005", "10-4-2005", "tramite", "EM002", "va a mejor", "MU111");
insert into recursos values("RE113", "10-4-2005", "10-5-2005", "finalizada", "EM002", "favorable", "MU111");


