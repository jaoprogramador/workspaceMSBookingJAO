-- Insert usuarios
INSERT INTO usuarios (id, nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES
  (1, 'Juan', 'Pérez', 'juan.perez@mail.com', '123456789', NOW(), NOW(), 'ADMIN', TRUE),
  (2, 'Ana', 'García', 'ana.garcia@mail.com', '987654321', NOW(), NOW(), 'CLIENTE', TRUE);

-- Insert preferencias_usuario
INSERT INTO preferencias_usuario (id, idioma, recibir_notificaciones, usuario_id)
VALUES
  (1, 'ES', TRUE, 1),
  (2, 'EN', FALSE, 2);

-- Insert direcciones
INSERT INTO direcciones (id, calle, ciudad, provincia, codigo_postal, pais, usuario_id)
VALUES
  (1, 'Calle Falsa 123', 'Madrid', 'Madrid', '28080', 'España', 1),
  (2, 'Avenida Siempre Viva 742', 'Barcelona', 'Barcelona', '08010', 'España', 2);

-- Insert datos_bancarios
INSERT INTO datos_bancarios (id, titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo)
VALUES
  (1, 'Juan Pérez', 'ES7620770024003102575766', 'Banco Santander', 'BSCHESMM', 'Corriente', 1, TRUE),
  (2, 'Ana García', 'ES9121000418450200051332', 'BBVA', NULL, 'Ahorros', 2, TRUE);