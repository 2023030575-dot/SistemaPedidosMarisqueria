use proyecto;
CREATE TABLE carrito (
    id_carrito INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_platillo INT,
    cantidad INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
    FOREIGN KEY (id_platillo) REFERENCES platillos(id_platillo)
);
show tables;
describe usuarios;
describe clientes;
describe administrador;
describe repartidores;
describe pedidos;
describe platillos;
describe platillos_pedidos;
describe carrito;
insert into usuarios(usuario, contrasena, correo, telefono,tipo_cuenta) 
values ("Jeff","12345","jef275832@gmail.com","6691001257","cliente");
insert into clientes(nombre,apellidos,genero,fecha_nacimiento,id_usuario) 
values ("Ramiro", "Garcia Lucas", "H", "2005-2-12",1);

insert into usuarios(contrasena, correo,tipo_cuenta) 
values ("@Adm1n1str4d0r","alx275832@gmail.com","administrador");
insert into administrador(nombre,apellidos,genero,rfc,curp,id_usuario) 
values ("Jefte Alejandro","Delgadillo Quevedo","H","RFC","DEQJ051201HSLLVFA0",10);
select * from administrador;
select * from usuarios;
delete from usuarios where id_usuario=29;
select * from clientes;
select * from repartidores;
select * from pedidos;
select * from carrito;
update pedidos set id_repartidor = null where id_pedido = 6;
delete from pedidos where id_pedido = 8;
select * from platillos;
select * from platillos_pedidos;
delete from platillos_pedidos where id_pedido = 8;
select * from carrito;
ALTER TABLE	usuarios DROP COLUMN usuario;
ALTER TABLE	usuarios ADD COLUMN activo ENUM("si","no");
ALTER TABLE	usuarios DROP COLUMN telefono;
ALTER TABLE clientes MODIFY id_usuario INT UNIQUE;
ALTER TABLE repartidores MODIFY id_usuario INT UNIQUE;
ALTER TABLE administrador MODIFY id_usuario INT UNIQUE;
ALTER TABLE	platillos_pedidos ADD COLUMN cantidad INT;
ALTER TABLE pedidos MODIFY metodo_pago ENUM('efectivo','tarjeta','transferencia');
ALTER TABLE pedidos MODIFY id_repartidor INT NULL;
ALTER TABLE repartidores DROP COLUMN estado;
ALTER TABLE pedidos ADD COLUMN comentario TEXT;
DELETE FROM usuarios where id_usuario = 4;
DELETE FROM pedidos where id_pedido=19;
UPDATE clientes SET id_usuario=2 WHERE nombre="Ramiro";
SELECT tipo_cuenta FROM usuarios WHERE id_usuario = 6;
UPDATE usuarios SET contrasena = "1" WHERE id_usuario = 10;
UPDATE usuarios SET activo="si" WHERE id_usuario=11;
INSERT INTO pedidos (id_cliente,id_repartidor,direccion,fecha,hora_realizacion,hora_entrega,total,metodo_pago) VALUES (4,1,'Av. Siempre Viva 742, Springfield','2025-01-10','14:30:00','15:15:00',299.99,'tarjeta');
INSERT INTO usuarios (contrasena, correo, tipo_cuenta, activo) VALUES ("rep","rep@gmail.com","repartidor","si");
INSERT INTO repartidores(nombre,apellidos,genero,rfc,curp,placa,estado,id_usuario) VALUES ("Jose","Olais","H","rfc","curp","placa","inactivo","11");
INSERT INTO pedidos (id_cliente, id_repartidor, direccion, fecha, hora_realizacion, hora_entrega, total, metodo_pago,comentario ) VALUES ( 9, NULL, 'Av. Ejemplo #123', '2025-03-15', '10:30:00', NULL, 299.99, 'tarjeta', 'Pedido de prueba con fecha antigua' );
DELETE FROM usuarios WHERE contrasena="1";
DELETE FROM pedidos WHERE id_pedido=18;
SELECT r.nombre, r.apellidos, r.rfc, r.curp, r.genero, r.placa, u.correo FROM repartidores r JOIN usuarios u ON r.id_usuario = u.id_usuario WHERE r.id_usuario = 11;
SELECT rfc FROM administrador UNION ALL SELECT rfc FROM repartidores;
SELECT correo FROM usuarios;
INSERT INTO platillos(nombre,descripcion,costo) VALUES ("Aguachile", "Incluye camarones frescos, jugo de limón, chiles , cebolla morada y pepino", 125.0);
SELECT c.id_carrito, c.id_cliente, c.id_platillo, c.cantidad, p.nombre,p.costo FROM carrito c JOIN platillos p ON c.id_platillo = p.id_platillo WHERE c.id_cliente = 3;
SELECT r.id_repartidor, r.nombre, r.apellidos, r.genero, r.rfc, r.curp, r.placa, r.estado FROM repartidores r JOIN usuarios u USING (id_usuario) WHERE u.activo = 'si';
insert into platillos (nombre,descripcion,costo) VALUES ('Papa de Camaron', 'Deliciosa papa de camaron a la mexicana',150);
insert into platillos (nombre,descripcion,costo) VALUES ('Ceviche de Dorado', 'Un exquisito ceviche de Dorado y salsa de la casa',170);
insert into platillos (nombre,descripcion,costo) VALUES ('Limonada', 'Deliciosa y fresca','50');
insert into platillos (nombre,descripcion,costo) VALUES ('Cerveza', 'Excelente para acompañar el marisco',45);
insert into platillos (nombre,descripcion,costo) VALUES ('Papa de Pulpo', 'Deliciosa papa de pulpo',180);
insert into platillos (nombre,descripcion,costo) VALUES ('Taco Anaheim', 'Un taco con chile Anaheim',110);
insert into platillos (nombre,descripcion,costo) VALUES ('Ceviche de Pulpo', 'Un ceviche fresco de pulpo acompañado con salsa de la casa',145);