-- ===============================================
-- Tabla orden_items
-- ===============================================
INSERT INTO orden_items (orden_id, tipo, referencia_reserva_id, precio, descripcion)
VALUES
(71, 'VUELO', 'V001', 200.00, 'Vuelo Madrid-Paris'),
(71, 'HOTEL', 'H001', 150.00, 'Hotel Paris Center'),
(71, 'VEHICULO', 'VE001', 100.00, 'Coche alquiler'),
(71, 'ACTIVIDAD', 'A001', 50.00, 'Tour Torre Eiffel'),

(72, 'VUELO', 'V002', 400.00, 'Vuelo Barcelona-Roma'),
(72, 'HOTEL', 'H002', 500.50, 'Hotel Roma Centro'),
(72, 'VEHICULO', 'VE002', 200.00, 'Coche alquiler'),
(72, 'ACTIVIDAD', 'A002', 100.00, 'Tour Coliseo'),

(73, 'VUELO', 'V003', 150.00, 'Vuelo Valencia-Londres'),
(73, 'HOTEL', 'H003', 150.75, 'Hotel Londres Centro');

-- Nota: Cada orden puede tener más items, este script inserta 10 registros iniciales.