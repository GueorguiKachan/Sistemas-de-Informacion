

CREATE TABLE grupos(
  nombre VARCHAR(100) PRIMARY KEY,
  numEquipos INT
  );
 
 CREATE TABLE equipos(
  nombre VARCHAR(100) PRIMARY KEY,
  numJugadores INT,
  precioEnt INT,
  estadio VARCHAR(100),
  capacidad VARCHAR(100),
  tipoCesped VARCHAR(100),
  grupo VARCHAR(100),
  FOREIGN KEY (grupo) REFERENCES grupos(nombre)
  );

CREATE TABLE jugadores(
  id Bigint PRIMARY KEY,
  nombre VARCHAR(100),
  nacido INT NOT NULL,
  rojas INT,
  amarillas INT,
  pJugados INT,
  pTitular INT,
  goles INT,
  equipo VARCHAR(100),
  FOREIGN KEY (equipo) REFERENCES equipos (nombre)
  );
 
 CREATE TABLE usuarios(
  nombre VARCHAR(100) PRIMARY KEY,
  password VARCHAR(50),
esAdmin boolean
  );
 
  
 CREATE TABLE solicitudJugador(
  id INT PRIMARY KEY,
  campo VARCHAR(100),
  valor VARCHAR(500),
  nomUser VARCHAR(100),
  codJugador Bigint,
  FOREIGN KEY (nomUser) REFERENCES usuarios(nombre),
  FOREIGN KEY (codJugador) REFERENCES jugadores(id)
  );
  
 CREATE TABLE solicitudEquipo(
  id INT PRIMARY KEY,
  campo VARCHAR(100),
  valor VARCHAR(500),
  nomUser VARCHAR(100),
  codEquipo VARCHAR(100),
  FOREIGN KEY (nomUser) REFERENCES usuarios(nombre),
  FOREIGN KEY (codEquipo) REFERENCES equipos(nombre)
  );


insert into grupos values ('Grupo 2');
insert into grupos values ('Grupo 1');

insert into equipos values ('El Gancho C.F.','0','0','NUEVO RANILLAS-C.M.F.','','Artificial','Grupo 2');
insert into equipos values ('Helios C.N.','0','0','PEDRO SANCHO','','Natural','Grupo 1');

insert into jugadores values ('1','Ernesto Bielsa Gracia','2001','0','1','7','7','0','El Gancho C.F.');
insert into jugadores values ('2','Jorge Ramon','1999','2','2','9','9','1','Helios C.N.');

update equipos e1 set numJugadores = (select count(*) from jugadores where equipo= e1.nombre);

update grupos g1 set numEquipos = (select count(*) from equipos where grupo = g1.nombre);

insert into usuarios values ('Gueorgui Alexandrovitch Kachan','indefinido','true');
insert into usuarios values ('Pablo','sisinf2020','false');

insert into solicitudEquipo values ('1','capacidad','300','Gueorgui Alexandrovitch Kachan','El Gancho C.F.');

insert into solicitudJugador values ('1','goles','3','Gueorgui Alexandrovitch Kachan','1');
