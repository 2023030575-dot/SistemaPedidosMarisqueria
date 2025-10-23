USE proyecto;
DELIMITER //

DROP PROCEDURE IF EXISTS ADD_USER;
DROP PROCEDURE IF EXISTS ADD_CLIENT;
DROP PROCEDURE IF EXISTS ADD_DELIVER;
DROP PROCEDURE IF EXISTS DEACTIVATE_INACTIVE_USERS;

CREATE PROCEDURE ADD_USER(
	IN email VARCHAR(30),
    IN pass VARCHAR(50),
    IN tipo ENUM("administrador","repartidor","cliente")
)
BEGIN 
	INSERT INTO usuarios(correo,contrasena,tipo_cuenta,activo)
    VALUES (email,pass,tipo,"si");
END //

CREATE PROCEDURE ADD_CLIENT(
	IN namee VARCHAR(30),
    IN lastname VARCHAR(50),
    IN gender ENUM("H","M"),
    IN birthdate DATE,
    IN id INT
)
BEGIN 
	INSERT INTO clientes(nombre,apellidos,genero,fecha_nacimiento,id_usuario)
    VALUES (namee,lastname,gender,birthdate,id);
END //

CREATE PROCEDURE ADD_DELIVER(
	IN namee VARCHAR(30),
    IN lastname VARCHAR(50),
    IN gender ENUM("H","M"),
    IN rfcc VARCHAR(15),
    IN curpp VARCHAR(18),
    IN plate VARCHAR(10),
    IN id INT
)
BEGIN 
	INSERT INTO repartidores(nombre,apellidos,genero,rfc,curp,placa,id_usuario)
    VALUES (namee,lastname,gender,rfcc,curpp,plate,id);
END //

CREATE PROCEDURE ADD_ADMIN(
	IN namee VARCHAR(30),
    IN lastname VARCHAR(50),
    IN gender ENUM("H","M"),
    IN rfcc VARCHAR(15),
    IN curpp VARCHAR(18),
    IN id INT
)
BEGIN 
	INSERT INTO administrador(nombre,apellidos,genero,rfc,curp,id_usuario)
    VALUES (namee,lastname,gender,rfcc,curpp,id);
END //

CREATE PROCEDURE CHANGE_PASSWORD(
	IN pass VARCHAR(50),
    IN email VARCHAR(30)
)
BEGIN 
	UPDATE usuarios SET contrasena = pass WHERE correo = email;
END //

CREATE PROCEDURE ADD_CART(
	IN idC INT,
    IN idP INT,
    IN amount INT
)
BEGIN
	INSERT INTO carrito(id_cliente, id_platillo, cantidad) VALUES (idC,idP,amount);
END //
DROP PROCEDURE IF EXISTS CREATE_ORDER;
CREATE PROCEDURE CREATE_ORDER(
	IN idC INT,
    IN adress VARCHAR(150),
    IN datee DATE,
    IN timee TIME,
    IN totall DECIMAL(10,2),
    IN pay ENUM('efectivo','tarjeta','transferencia'),
    IN com TEXT,
    OUT id_generado INT
)
BEGIN
	INSERT INTO pedidos(id_cliente, id_repartidor, direccion, fecha, hora_realizacion, hora_entrega, total, metodo_pago,comentario)
    VALUES (idC, NULL, adress, datee, timee, NULL, totall, pay, com);
    SET id_generado = LAST_INSERT_ID();
END //

CREATE PROCEDURE DEACTIVATE_INACTIVE_USERS()
BEGIN
    UPDATE usuarios u
    JOIN clientes c ON u.id_usuario = c.id_usuario
    SET u.activo = 'no'
    WHERE u.activo = 'si'
      AND THREE_MONTH_INACTIVE(c.id_cliente);
      
    SELECT * FROM usuarios;
END //
DELIMITER ;

#CALL ADD_USER('usuario1@email.com', 'clave123', 'cliente');