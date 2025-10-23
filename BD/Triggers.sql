DELIMITER //
DROP TRIGGER IF EXISTS TGR_DEACTIVATE_USER;
DROP TRIGGER IF EXISTS TGR_DIFFERENT_PASS;
CREATE TRIGGER TGR_DEACTIVATE_USER
BEFORE UPDATE ON usuarios
FOR EACH ROW
BEGIN
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
END;
//

CREATE TRIGGER TGR_DIFFERENT_PASS
BEFORE UPDATE ON usuarios
FOR EACH ROW
BEGIN
	IF NEW.contrasena <> OLD.contrasena THEN
		IF NEW.contrasena = OLD.contrasena THEN
			SIGNAL SQLSTATE '45000'
			SET MESSAGE_TEXT = 'La nueva contraseña debe ser distinta a la anterior';
		END IF;
	END IF;
END //
DELIMITER ;
