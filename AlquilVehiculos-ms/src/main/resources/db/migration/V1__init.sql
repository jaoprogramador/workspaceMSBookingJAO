CREATE TABLE IF NOT EXISTS sucursales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    pais VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS vehiculos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(255) NOT NULL,
    modelo VARCHAR(255) NOT NULL,
    año INT NOT NULL,
    sucursal_id BIGINT,
    disponible BOOLEAN NOT NULL,
    FOREIGN KEY (sucursal_id) REFERENCES sucursales(id)
);
