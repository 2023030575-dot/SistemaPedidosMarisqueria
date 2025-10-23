-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
  `id_administrador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `genero` enum('H','M') NOT NULL,
  `rfc` varchar(15) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_administrador`),
  UNIQUE KEY `rfc` (`rfc`),
  UNIQUE KEY `curp` (`curp`),
  UNIQUE KEY `id_usuario_2` (`id_usuario`),
  UNIQUE KEY `id_usuario_3` (`id_usuario`),
  UNIQUE KEY `id_usuario_4` (`id_usuario`),
  UNIQUE KEY `id_usuario_5` (`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (3,'Jefte Alejandro','Delgadillo Quevedo','H','RFC','DEQJ051201HSLLVFA0',10);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrito` (
  `id_carrito` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int DEFAULT NULL,
  `id_platillo` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_carrito`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_platillo` (`id_platillo`),
  CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `carrito_ibfk_2` FOREIGN KEY (`id_platillo`) REFERENCES `platillos` (`id_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
INSERT INTO `carrito` VALUES (22,3,1,2);
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `genero` enum('H','M') NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_usuario_2` (`id_usuario`),
  UNIQUE KEY `id_usuario_3` (`id_usuario`),
  UNIQUE KEY `id_usuario_4` (`id_usuario`),
  UNIQUE KEY `id_usuario_5` (`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Jefte Alejandro','Delgadillo Quevedo','H','2001-01-01',1),(2,'Ramiro','Garcia Lucas','H','2001-01-01',2),(3,'Alan Refugio','Cabrales','H','2001-01-01',5),(4,'Mairim','Vizcarra Ibarra','M','2001-01-01',6),(9,'Sebas','Troll','H','2001-01-01',12),(12,'Jefte','Delgadillo','H','2001-01-01',26),(13,'Jefte','Delgadillo','H','2001-01-01',27),(15,'Mikkel Gilberto','Mendoza Quevedo','H','2006-09-06',30);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_repartidor` int DEFAULT NULL,
  `direccion` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `hora_realizacion` time NOT NULL,
  `hora_entrega` time DEFAULT NULL,
  `total` decimal(10,2) NOT NULL,
  `metodo_pago` enum('efectivo','tarjeta','transferencia') DEFAULT NULL,
  `comentario` text,
  PRIMARY KEY (`id_pedido`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_repartidor` (`id_repartidor`),
  CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`id_repartidor`) REFERENCES `repartidores` (`id_repartidor`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (6,3,9,'direccion','2025-07-08','17:44:21','09:25:30',401.50,'efectivo',NULL),(9,4,NULL,'mi casa','2025-07-08','18:38:29',NULL,425.50,'transferencia',NULL),(10,3,1,'Entregelo aca en la upsin','2025-07-10','11:37:39','11:39:13',351.00,'efectivo',NULL),(11,15,9,'Villas del Rey, Mayorca 16324','2025-07-10','20:04:48','20:15:51',500.00,'tarjeta',NULL),(12,4,1,'La casa de Ari','2025-07-11','09:58:48','09:59:32',340.00,'tarjeta',NULL),(13,3,9,'Entrada de upsin','2025-07-11','10:10:40','10:12:10',195.00,'efectivo',NULL),(14,3,1,'UPSIN','2025-07-14','11:59:00','12:02:12',440.00,'tarjeta',NULL),(16,1,9,'Villas del Rey, Mayorca 16324','2025-07-17','15:27:17',NULL,1025.50,'transferencia','Todos los platillos sin cebolla, porfavor.'),(20,9,NULL,'Av. Ejemplo #123','2025-03-15','10:30:00',NULL,299.99,'tarjeta','Pedido de prueba con fecha antigua');
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillos`
--

DROP TABLE IF EXISTS `platillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillos` (
  `id_platillo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `descripcion` text,
  `costo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillos`
--

LOCK TABLES `platillos` WRITE;
/*!40000 ALTER TABLE `platillos` DISABLE KEYS */;
INSERT INTO `platillos` VALUES (1,'1L Ceviche de Sierra','Ceviche con zanahoria, pepino, cebolla y sierra',50.50),(2,'Aguachile','Incluye camarones frescos, jugo de limón, chiles , cebolla morada y pepino',125.00),(3,'Papa de Camaron','Deliciosa papa de camaron a la mexicana',150.00),(4,'Ceviche de Dorado','Un exquisito ceviche de Dorado y salsa de la casa',170.00),(5,'Limonada','Deliciosa y fresca',50.00),(6,'Cerveza','Excelente para acompañar el marisco',45.00),(7,'Papa de Pulpo','Deliciosa papa de pulpo',180.00),(8,'Taco Anaheim','Un taco con chile Anaheim',110.00),(9,'Ceviche de Pulpo','Un ceviche fresco de pulpo acompañado con salsa de la casa',145.00);
/*!40000 ALTER TABLE `platillos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platillos_pedidos`
--

DROP TABLE IF EXISTS `platillos_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platillos_pedidos` (
  `id_registro` int NOT NULL AUTO_INCREMENT,
  `id_pedido` int DEFAULT NULL,
  `id_platillo` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  PRIMARY KEY (`id_registro`),
  KEY `id_pedido` (`id_pedido`),
  KEY `id_platillo` (`id_platillo`),
  CONSTRAINT `platillos_pedidos_ibfk_1` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id_pedido`),
  CONSTRAINT `platillos_pedidos_ibfk_2` FOREIGN KEY (`id_platillo`) REFERENCES `platillos` (`id_platillo`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platillos_pedidos`
--

LOCK TABLES `platillos_pedidos` WRITE;
/*!40000 ALTER TABLE `platillos_pedidos` DISABLE KEYS */;
INSERT INTO `platillos_pedidos` VALUES (1,6,1,3),(2,6,2,2),(7,9,1,1),(8,9,2,3),(9,10,1,2),(10,10,2,2),(11,11,2,4),(12,12,5,1),(13,12,9,2),(14,13,3,1),(15,13,6,1),(16,14,4,2),(17,14,5,2),(27,16,1,1),(28,16,2,1),(29,16,3,1),(30,16,4,1),(31,16,5,1),(32,16,6,1),(33,16,7,1),(34,16,8,1),(35,16,9,1);
/*!40000 ALTER TABLE `platillos_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repartidores`
--

DROP TABLE IF EXISTS `repartidores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repartidores` (
  `id_repartidor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `genero` enum('H','M') NOT NULL,
  `rfc` varchar(15) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `placa` varchar(10) NOT NULL,
  `id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_repartidor`),
  UNIQUE KEY `rfc` (`rfc`),
  UNIQUE KEY `curp` (`curp`),
  UNIQUE KEY `placa` (`placa`),
  UNIQUE KEY `id_usuario_2` (`id_usuario`),
  UNIQUE KEY `id_usuario_3` (`id_usuario`),
  UNIQUE KEY `id_usuario_4` (`id_usuario`),
  UNIQUE KEY `id_usuario_5` (`id_usuario`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `repartidores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repartidores`
--

LOCK TABLES `repartidores` WRITE;
/*!40000 ALTER TABLE `repartidores` DISABLE KEYS */;
INSERT INTO `repartidores` VALUES (1,'Jose','Olais','H','rfc','curp','placa',11),(4,'Juan','Perez','H','234','567','123',19),(9,'Ramiro','Garcia Lucas','H','101010','123456','12344324',28);
/*!40000 ALTER TABLE `repartidores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(50) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `tipo_cuenta` enum('administrador','repartidor','cliente') NOT NULL,
  `activo` enum('si','no') DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jeff123_','jef275832@gmail.com','cliente','si'),(2,'balatro','ramirogarcia@gmail.com','cliente','si'),(5,'123','alan@gmail.com','cliente','si'),(6,'ari','mairim@gmail.com','cliente','si'),(10,'1','alx275832@gmail.com','administrador','si'),(11,'rep','rep@gmail.com','repartidor','si'),(12,'sebas','sebas@gmail.com','cliente','no'),(19,'JPL','juan@gmail.com','repartidor','si'),(26,'12345','jeff@gmailcom','cliente','si'),(27,'12345','jeff@gmail.com','cliente','si'),(28,'ramix','ramix@gmail.com','repartidor','si'),(30,'mikkel-6','mikkel@gmail.com','cliente','si');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `TGR_DEACTIVATE_USER` BEFORE UPDATE ON `usuarios` FOR EACH ROW BEGIN
    DECLARE cliente_id INT;
    IF OLD.activo <> NEW.activo THEN
        SELECT id_cliente
        INTO cliente_id
        FROM clientes
        WHERE id_usuario = OLD.id_usuario
        LIMIT 1;
        IF cliente_id IS NOT NULL THEN
            IF NOT THREE_MONTH_INACTIVE(cliente_id) THEN
                SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'No se puede cambiar el estado del usuario: su cliente relacionado no ha estado inactivo por 3 meses o más';
            END IF;
        END IF;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'proyecto'
--

--
-- Dumping routines for database 'proyecto'
--
/*!50003 DROP FUNCTION IF EXISTS `THREE_MONTH_INACTIVE` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `THREE_MONTH_INACTIVE`(cliente_id INT) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
    DECLARE ultima_fecha DATE;

    SELECT MAX(DATE(fecha))
    INTO ultima_fecha
    FROM pedidos
    WHERE id_cliente = cliente_id;
    IF ultima_fecha IS NULL THEN
        RETURN FALSE;
    END IF;
    IF ultima_fecha <= DATE_SUB(CURDATE(), INTERVAL 3 MONTH) THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ADD_ADMIN` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_ADMIN`(
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ADD_CART` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_CART`(
	IN idC INT,
    IN idP INT,
    IN amount INT
)
BEGIN
	INSERT INTO carrito(id_cliente, id_platillo, cantidad) VALUES (idC,idP,amount);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `ADD_USER` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ADD_USER`(
	IN email VARCHAR(30),
    IN pass VARCHAR(50),
    IN tipo ENUM("administrador","repartidor","cliente")
)
BEGIN 
	INSERT INTO usuarios(correo,contrasena,tipo_cuenta,activo)
    VALUES (email,pass,tipo,"si");
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CHANGE_PASSWORD` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CHANGE_PASSWORD`(
	IN pass VARCHAR(50),
    IN email VARCHAR(30)
)
BEGIN 
	UPDATE usuarios SET contrasena = pass WHERE correo = email;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `CREATE_ORDER` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `CREATE_ORDER`(
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
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `DEACTIVATE_INACTIVE_USERS` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `DEACTIVATE_INACTIVE_USERS`()
BEGIN
    UPDATE usuarios u
    JOIN clientes c ON u.id_usuario = c.id_usuario
    SET u.activo = 'no'
    WHERE u.activo = 'si'
      AND THREE_MONTH_INACTIVE(c.id_cliente);
      
    SELECT * FROM usuarios;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-20 11:45:53
