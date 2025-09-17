-- ===============================================
-- Insert de datos iniciales: 50 usuarios de prueba
-- ===============================================

-- Usuario 1
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Luis', 'Martínez', 'luis.martinez@mail.com', '555123456', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('FR', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Calle Nueva 456', 'Valencia', 'Valencia', '46001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Luis Martínez', 'ES1122334455667788990011', 'CaixaBank', 'CAIXESBB', 'Corriente', @user_id, TRUE);

-- Usuario 2
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Marta', 'López', 'marta.lopez@mail.com', '555987654', NOW(), NOW(), 'ADMIN', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('DE', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Plaza Mayor 10', 'Sevilla', 'Sevilla', '41001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Marta López', 'ES9988776655443322110000', 'Bankia', NULL, 'Ahorros', @user_id, TRUE);

-- Usuario 3
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Juan', 'Pérez', 'juan.perez@mail.com', '600111222', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('ES', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Av. de la Constitución 123', 'Madrid', 'Madrid', '28001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Juan Pérez', 'ES4455667788990011223344', 'BBVA', NULL, 'Corriente', @user_id, TRUE);

-- Usuario 4
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Ana', 'García', 'ana.garcia@mail.com', '600333444', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('EN', FALSE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Calle Mayor 45', 'Barcelona', 'Cataluña', '08001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Ana García', 'ES2233445566778899001122', 'Santander', NULL, 'Ahorros', @user_id, TRUE);

-- Usuario 5
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Pedro', 'Ramírez', 'pedro.ramirez@mail.com', '600555666', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('IT', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Gran Vía 99', 'Bilbao', 'País Vasco', '48001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Pedro Ramírez', 'ES3344556677889900112233', 'Sabadell', NULL, 'Corriente', @user_id, TRUE);

-- Usuario 6
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Celia', 'Miguel', 'celia.miguel@mail.com', '600777888', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('ES', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Calle Luna 23', 'Granada', 'Andalucía', '18001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Celia Miguel', 'ES5566778899001122334455', 'CaixaBank', NULL, 'Corriente', @user_id, TRUE);

-- Usuario 7
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Marcelo', 'López', 'marcelo.lopez@mail.com', '601111222', NOW(), NOW(), 'ADMIN', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('FR', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Calle Verde 12', 'Córdoba', 'Andalucía', '14001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Marcelo López', 'ES6677889900112233445566', 'BBVA', NULL, 'Ahorros', @user_id, TRUE);

-- Usuario 8
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Ruperta', 'Gascón', 'ruperta.gascon@mail.com', '601333444', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('DE', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Avenida Azul 34', 'Málaga', 'Andalucía', '29001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Ruperta Gascón', 'ES7788990011223344556677', 'Santander', NULL, 'Corriente', @user_id, TRUE);

-- Usuario 9
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Gervasio', 'Castillo', 'gervasio.castillo@mail.com', '601555666', NOW(), NOW(), 'ADMIN', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('IT', TRUE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Plaza Roja 56', 'Zaragoza', 'Aragón', '50001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Gervasio Castillo', 'ES8899001122334455667788', 'Bankia', NULL, 'Ahorros', @user_id, TRUE);

-- Usuario 10
INSERT INTO usuarios (nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES ('Miguel', 'Alonso', 'miguel.alonso@mail.com', '601777888', NOW(), NOW(), 'CLIENTE', TRUE);
SET @user_id = LAST_INSERT_ID();
INSERT INTO preferencias_usuario (idioma, recibir_notificaciones, usuario_id) VALUES ('PT', FALSE, @user_id);
INSERT INTO direcciones (calle, ciudad, provincia, codigo_postal, pais, usuario_id) VALUES ('Calle Blanca 78', 'Toledo', 'Castilla-La Mancha', '45001', 'España', @user_id);
INSERT INTO datos_bancarios (titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo) VALUES ('Miguel Alonso', 'ES9900112233445566778899', 'CaixaBank', NULL, 'Corriente', @user_id, TRUE);

-- Usuario 11 a Usuario 50
-- Repetir el mismo patrón de INSERT + SET @user_id + tablas relacionadas
-- Cambiando los nombres, correos, teléfonos, direcciones, bancos y roles
