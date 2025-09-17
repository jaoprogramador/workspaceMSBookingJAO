-- ===============================================
-- Insert de datos de prueba: 10 registros por tabla
-- ===============================================

-- ===============================================
-- Tabla ordenes
-- ===============================================
INSERT INTO ordenes (orderCode, usuarioId, fechaCreacion, estado, montoTotal, pagoId)
VALUES 
('ORD001', 1, NOW(), 'CREADA', 1500.00, 'PAY001'),
('ORD002', 2, NOW(), 'PENDIENTE', 2300.50, 'PAY002'),
('ORD003', 3, NOW(), 'PAGADA', 800.75, 'PAY003'),
('ORD004', 4, NOW(), 'CANCELADA', 1200.00, 'PAY004'),
('ORD005', 5, NOW(), 'CREADA', 450.00, 'PAY005'),
('ORD006', 6, NOW(), 'PENDIENTE', 600.00, 'PAY006'),
('ORD007', 7, NOW(), 'PAGADA', 980.25, 'PAY007'),
('ORD008', 8, NOW(), 'CREADA', 150.00, 'PAY008'),
('ORD009', 9, NOW(), 'PAGADA', 2000.00, 'PAY009'),
('ORD010', 10, NOW(), 'CANCELADA', 750.50, 'PAY010');

-- ===============================================
-- Tabla reservas
-- ===============================================
INSERT INTO reservas (usuarioId, fechaCreacion, fechaModificacion, estado, total, vueloId, hotelId, vehiculoId, actividadId, pagoId)
VALUES
(1, NOW(), NOW(), 'PENDIENTE', 500.00, 'V001', 'H001', 'VE001', 'A001', 'PAY001'),
(2, NOW(), NOW(), 'CONFIRMADA', 1200.50, 'V002', 'H002', 'VE002', 'A002', 'PAY002'),
(3, NOW(), NOW(), 'CANCELADA', 300.75, 'V003', 'H003', 'VE003', 'A003', 'PAY003'),
(4, NOW(), NOW(), 'CONFIRMADA', 800.00, 'V004', 'H004', 'VE004', 'A004', 'PAY004'),
(5, NOW(), NOW(), 'PENDIENTE', 450.00, 'V005', 'H005', 'VE005', 'A005', 'PAY005'),
(6, NOW(), NOW(), 'CONFIRMADA', 600.00, 'V006', 'H006', 'VE006', 'A006', 'PAY006'),
(7, NOW(), NOW(), 'PENDIENTE', 980.25, 'V007', 'H007', 'VE007', 'A007', 'PAY007'),
(8, NOW(), NOW(), 'CONFIRMADA', 150.00, 'V008', 'H008', 'VE008', 'A008', 'PAY008'),
(9, NOW(), NOW(), 'PAGADA', 2000.00, 'V009', 'H009', 'VE009', 'A009', 'PAY009'),
(10, NOW(), NOW(), 'CANCELADA', 750.50, 'V010', 'H010', 'VE010', 'A010', 'PAY010');

-- ===============================================
-- Tabla orden_items
-- ===============================================
INSERT INTO orden_items (orden_id, tipo, referenciaReservaId, precio, descripcion)
VALUES
(1, 'VUELO', 'V001', 200.00, 'Vuelo Madrid-Paris'),
(1, 'HOTEL', 'H001', 150.00, 'Hotel Paris Center'),
(1, 'VEHICULO', 'VE001', 100.00, 'Coche alquiler'),
(1, 'ACTIVIDAD', 'A001', 50.00, 'Tour Torre Eiffel'),

(2, 'VUELO', 'V002', 400.00, 'Vuelo Barcelona-Roma'),
(2, 'HOTEL', 'H002', 500.50, 'Hotel Roma Centro'),
(2, 'VEHICULO', 'VE002', 200.00, 'Coche alquiler'),
(2, 'ACTIVIDAD', 'A002', 100.00, 'Tour Coliseo'),

(3, 'VUELO', 'V003', 150.00, 'Vuelo Valencia-Londres'),
(3, 'HOTEL', 'H003', 150.75, 'Hotel Londres Centro');

-- Nota: Cada orden puede tener más items, este script inserta 10 registros iniciales.
