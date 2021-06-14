

insert into `tipo_negocio` (id, nombre, descripcion) values (1,'Grande','Grande establecimientos con diverso tipo de ropa y/o calzado');
insert into `tipo_negocio` (id, nombre, descripcion) values (2,'Mediano','Empresas enfocadas a una categoría de producto en particular');
insert into `tipo_negocio` (id, nombre, descripcion) values (3,'Pequeño','Emprendimientos pequeños, enfocados a un producto en particular');

insert into `usuario` (tipo, id, email, password, dni,first_name, last_name, username) values ('C',1, 'rosa@unmsm.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', 'kstrauss0', 'Rosa', 'Strauss', 'kstrauss0');
insert into `usuario` (tipo, id, email, password, dni,first_name, last_name, username) values ('C',2, 'cfeldstern1@ucoz.ru', '$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', 'ekornel3','Elliott', 'Kornel', 'ekornel3');
insert into `usuario` (tipo, id, email, password, ruc, nombre,direccion,imagen,puntuacion,id_tipo_negocio, username)  values ('N',3, 'administracion@gdm.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', '21604816111','Establecimiento GDM', "Av Marina 123",'gdm.jpg', 76,1,'gdm');
insert into `usuario` (tipo, id, email, password, ruc, nombre,direccion,imagen,puntuacion,id_tipo_negocio, username)  values ('N',4, 'mcastro2@utmo.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', '11604816111','Unidad Textil Maranga Oficial', "Calle Las Flores 33", 'ccc.jpg', 87,1,'maranga');
insert into `usuario` (tipo, id, email, password, ruc, nombre,direccion,imagen,puntuacion,id_tipo_negocio, username)  values ('N',5, 'osstern100@bing.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC','21604812111', 'Textiles Casimiro ', "Av Marina 445" ,'mnmcasim.jpg', 98,2,'casimiro');
insert into `usuario` (tipo, id, email, password, ruc, nombre,direccion,imagen,puntuacion,id_tipo_negocio, username)  values ('N',6, 'mariciell0@bing.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', '21654816121',' Textiles Mar y Cielo', "Av Marina 411" ,'bdmc.jpg', 67,2,'tindmari',);
insert into `usuario` (tipo, id, email, password, ruc, nombre,direccion,imagen,puntuacion,id_tipo_negocio, username)  values ('N',7, 'panaderia@bing.com','$2a$10$xBPpxqLBdUXblMGkCwadr.hsNVyJk04A3hb4Fcjn79YeYzAtYCZzC', '21654816551','Emprendimiento Rosita', "Av Escardó 450" ,'rosita.jpg', 65,3,'panrosita');


insert into `categoria` (id, nombre, descripcion) values (1,'Camisas F/I','Incluye: Camisa Formal o Informal, manga larga o corta');
insert into `categoria` (id, nombre, descripcion) values (2,'Calzado','Incluye: Zapatos, zapatillas, botines, etc');
insert into `categoria` (id, nombre, descripcion) values (3,'Pantalones','Inclye: Jeans o Pantalones informales');
insert into `categoria` (id, nombre, descripcion) values (4,'Accesorios','Incluye: ');

insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (1,'Camiseta Azul','BB', 35.00, 78,1,3 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (2,'Camisa Formal Azul ,'BB', 57.00, 75,1,3 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (3,'Pantalon Jean Clásico','BB', 70.00 , 68,3,3 );

insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (4,'Zapato de Vestir','XX', 53.50,  78,1,4 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (5,'Zapatilla Azul ','Naki', 45.00,  89,1,4 );

insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (6,'Shorts de Verano Verdes','Livi', 47.00,  87,3,3 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (7,'Shorts de Verano Azules','Livi', 59.99,  89,3,3 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (8,'Jean Clásico Slim','PP', 98.00 , 78,3,3 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (9,'Pantalon de Vestir','PP', 125.00 , 86,3,3 );

insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (10,'Sandalias','SS', 45.90,  84,2,4 );
insert into `producto` (id, nombre, marca,precio,puntuacion,id_categoria,id_negocio) values (11,'Pantalón corto','SS', 57.50 , 67,3,4 );
