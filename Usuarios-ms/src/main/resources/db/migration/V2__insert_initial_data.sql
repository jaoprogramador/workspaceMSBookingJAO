-- Insert usuarios
INSERT INTO usuarios (id, nombre, apellido, email, telefono, fecha_registro, ultima_modificacion, rol, activo)
VALUES
  (3, 'Luis', 'Martínez', 'luis.martinez@mail.com', '555123456', NOW(), NOW(), 'CLIENTE', TRUE),
  (4, 'Marta', 'López', 'marta.lopez@mail.com', '555987654', NOW(), NOW(), 'ADMIN', TRUE);

-- Insert preferencias_usuario
INSERT INTO preferencias_usuario (id, idioma, recibir_notificaciones, usuario_id)
VALUES
  (3, 'FR', TRUE, 3),
  (4, 'DE', TRUE, 4);

-- Insert direcciones
INSERT INTO direcciones (id, calle, ciudad, provincia, codigo_postal, pais, usuario_id)
VALUES
  (3, 'Calle Nueva 456', 'Valencia', 'Valencia', '46001', 'España', 3),
  (4, 'Plaza Mayor 10', 'Sevilla', 'Sevilla', '41001', 'España', 4);

-- Insert datos_bancarios
INSERT INTO datos_bancarios (id, titular, numero_cuenta, banco, swift_bic, tipo_cuenta, usuario_id, activo)
VALUES
  (3, 'Luis Martínez', 'ES1122334455667788990011', 'CaixaBank', 'CAIXESBB', 'Corriente', 3, TRUE),
  (4, 'Marta López', 'ES9988776655443322110000', 'Bankia', NULL, 'Ahorros', 4, TRUE);
