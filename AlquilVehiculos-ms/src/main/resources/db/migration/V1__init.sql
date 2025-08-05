-- Insertar 3 sucursales
INSERT INTO sucursales (nombre, direccion, ciudad, pais) VALUES
('Sucursal Centro', 'Calle Mayor 1', 'Madrid', 'España'),
('Sucursal Norte', 'Avenida Europa 100', 'Barcelona', 'España'),
('Sucursal Sur', 'Plaza del Sol 5', 'Sevilla', 'España');

-- Insertar 50 vehículos distribuidos entre sucursales
INSERT INTO vehiculos (marca, modelo, tipo, matricula, disponible, sucursal_id) VALUES
('Toyota', 'Corolla', 'SEDAN', '0001-AAA', true, 1),
('Renault', 'Clio', 'HATCHBACK', '0002-BBB', true, 1),
('Ford', 'Focus', 'SEDAN', '0003-CCC', true, 1),
('Volkswagen', 'Golf', 'HATCHBACK', '0004-DDD', true, 1),
('Seat', 'Ibiza', 'HATCHBACK', '0005-EEE', true, 1),
('Hyundai', 'Tucson', 'SUV', '0006-FFF', true, 1),
('Kia', 'Sportage', 'SUV', '0007-GGG', true, 1),
('Nissan', 'Juke', 'SUV', '0008-HHH', true, 1),
('Peugeot', '208', 'HATCHBACK', '0009-III', true, 1),
('Opel', 'Astra', 'SEDAN', '0010-JJJ', true, 1),

('Toyota', 'Yaris', 'HATCHBACK', '0011-KKK', true, 2),
('Ford', 'Kuga', 'SUV', '0012-LLL', true, 2),
('Renault', 'Megane', 'SEDAN', '0013-MMM', true, 2),
('Volkswagen', 'Passat', 'SEDAN', '0014-NNN', true, 2),
('Seat', 'Leon', 'HATCHBACK', '0015-OOO', true, 2),
('Hyundai', 'i30', 'HATCHBACK', '0016-PPP', true, 2),
('Kia', 'Ceed', 'HATCHBACK', '0017-QQQ', true, 2),
('Nissan', 'Qashqai', 'SUV', '0018-RRR', true, 2),
('Peugeot', '308', 'HATCHBACK', '0019-SSS', true, 2),
('Opel', 'Corsa', 'HATCHBACK', '0020-TTT', true, 2),

('Toyota', 'Camry', 'SEDAN', '0021-UUU', true, 3),
('Ford', 'Fiesta', 'HATCHBACK', '0022-VVV', true, 3),
('Renault', 'Kadjar', 'SUV', '0023-WWW', true, 3),
('Volkswagen', 'Tiguan', 'SUV', '0024-XXX', true, 3),
('Seat', 'Ateca', 'SUV', '0025-YYY', true, 3),
('Hyundai', 'Santa Fe', 'SUV', '0026-ZZZ', true, 3),
('Kia', 'Rio', 'HATCHBACK', '0027-AAA', true, 3),
('Nissan', 'Micra', 'HATCHBACK', '0028-BBB', true, 3),
('Peugeot', '2008', 'SUV', '0029-CCC', true, 3),
('Opel', 'Grandland', 'SUV', '0030-DDD', true, 3),

-- 20 vehículos adicionales, alternando entre sucursales
('Toyota', 'Hilux', 'PICKUP', '0031-EEE', true, 1),
('Ford', 'Ranger', 'PICKUP', '0032-FFF', true, 2),
('Renault', 'Twingo', 'HATCHBACK', '0033-GGG', true, 3),
('Volkswagen', 'Polo', 'HATCHBACK', '0034-HHH', true, 1),
('Seat', 'Toledo', 'SEDAN', '0035-III', true, 2),
('Hyundai', 'Accent', 'SEDAN', '0036-JJJ', true, 3),
('Kia', 'Picanto', 'HATCHBACK', '0037-KKK', true, 1),
('Nissan', 'Note', 'HATCHBACK', '0038-LLL', true, 2),
('Peugeot', '5008', 'SUV', '0039-MMM', true, 3),
('Opel', 'Mokka', 'SUV', '0040-NNN', true, 1),

('Toyota', 'RAV4', 'SUV', '0041-OOO', true, 2),
('Ford', 'EcoSport', 'SUV', '0042-PPP', true, 3),
('Renault', 'Captur', 'SUV', '0043-QQQ', true, 1),
('Volkswagen', 'Arteon', 'SEDAN', '0044-RRR', true, 2),
('Seat', 'Alhambra', 'MPV', '0045-SSS', true, 3),
('Hyundai', 'Kona', 'SUV', '0046-TTT', true, 1),
('Kia', 'Niro', 'SUV', '0047-UUU', true, 2),
('Nissan', 'X-Trail', 'SUV', '0048-VVV', true, 3),
('Peugeot', '301', 'SEDAN', '0049-WWW', true, 1),
('Opel', 'Zafira', 'MPV', '0050-XXX', true, 2);