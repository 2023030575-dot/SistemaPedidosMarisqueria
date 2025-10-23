SELECT User, Host FROM mysql.user;
CREATE USER "Administrador"@"localhost" IDENTIFIED BY "ADMIN";
GRANT ALL ON proyecto.administrador TO "Administrador"@"localhost";
GRANT ALL ON proyecto.clientes TO "Administrador"@"localhost";
GRANT SELECT, UPDATE ON proyecto.pedidos TO "Administrador"@"localhost";
GRANT SELECT ON proyecto.platillos TO "Administrador"@"localhost";
GRANT SELECT ON proyecto.platillos_pedidos TO "Administrador"@"localhost";
GRANT ALL ON proyecto.repartidores TO "Administrador"@"localhost";
GRANT ALL ON proyecto.usuarios TO "Administrador"@"localhost";
GRANT EXECUTE ON FUNCTION THREE_MONTH_INACTIVE TO "Administrador"@"localhost";
GRANT EXECUTE ON PROCEDURE proyecto.ADD_USER TO 'Administrador'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.ADD_DELIVER TO 'Administrador'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.ADD_ADMIN TO 'Administrador'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.DEACTIVATE_INACTIVE_USERS TO 'Administrador'@'localhost';

CREATE USER "Repartidor"@"localhost" IDENTIFIED BY "REP";
GRANT UPDATE, SELECT ON proyecto.repartidores TO "Repartidor"@"localhost";
GRANT UPDATE, SELECT ON proyecto.usuarios TO "Repartidor"@"localhost";
GRANT SELECT ON proyecto.clientes TO "Repartidor"@"localhost";
GRANT SELECT, UPDATE ON proyecto.pedidos TO "Repartidor"@"localhost";
GRANT SELECT ON proyecto.platillos TO "Repartidor"@"localhost";
GRANT SELECT ON proyecto.platillos_pedidos TO "Repartidor"@"localhost";

#DROP USER "Cliente"@"localhost";
CREATE USER "Cliente"@"localhost" IDENTIFIED BY "CLIENT";
GRANT INSERT, UPDATE, SELECT ON proyecto.clientes TO "Cliente"@"localhost";
GRANT INSERT, UPDATE, SELECT ON proyecto.usuarios TO "Cliente"@"localhost";
GRANT SELECT ON proyecto.repartidores TO "Cliente"@"localhost";
GRANT SELECT, INSERT ON proyecto.pedidos TO "Cliente"@"localhost";
GRANT SELECT ON proyecto.platillos TO "Cliente"@"localhost";
GRANT SELECT, INSERT, DELETE ON proyecto.carrito TO "Cliente"@"localhost";
GRANT SELECT, INSERT ON proyecto.platillos_pedidos TO "Cliente"@"localhost";
GRANT EXECUTE ON PROCEDURE proyecto.ADD_USER TO 'Cliente'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.ADD_CLIENT TO 'Cliente'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.ADD_CART TO 'Cliente'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.CHANGE_PASSWORD TO 'Cliente'@'localhost';
GRANT EXECUTE ON PROCEDURE proyecto.CREATE_ORDER TO 'Cliente'@'localhost';


