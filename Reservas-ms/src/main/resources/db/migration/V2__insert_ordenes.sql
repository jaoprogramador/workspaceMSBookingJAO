-- ===============================================
-- Insert de datos de prueba: 10 registros por tabla
-- ===============================================

-- ===============================================
-- Tabla ordenes
-- ===============================================
INSERT INTO ordenes (order_code, usuario_id, fecha_creacion, estado, monto_total, pago_id)
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
