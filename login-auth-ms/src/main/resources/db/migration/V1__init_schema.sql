-- V1__init_schema.sql
-- Crear tabla roles
CREATE TABLE IF NOT EXISTS roles (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255)
);

-- Crear tabla permissions
CREATE TABLE IF NOT EXISTS permissions (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255)
);

-- Tabla intermedia role_permission
CREATE TABLE IF NOT EXISTS role_permission (
    role_id BINARY(16) NOT NULL,
    permission_id BINARY(16) NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES roles(id),
    CONSTRAINT fk_permission FOREIGN KEY (permission_id) REFERENCES permissions(id)
);

-- Crear tabla users
CREATE TABLE IF NOT EXISTS users (
    id BINARY(16) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    salt VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at DATETIME,
    updated_at DATETIME
);

-- Tabla intermedia user_roles
CREATE TABLE IF NOT EXISTS user_roles (
    user_id BINARY(16) NOT NULL,
    role_id BINARY(16) NOT NULL,
    PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_role_user FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Tabla password_history
CREATE TABLE IF NOT EXISTS password_history (
    id BINARY(16) PRIMARY KEY,
    user_id BINARY(16) NOT NULL,
    old_password_hash VARCHAR(255) NOT NULL,
    changed_at DATETIME,
    CONSTRAINT fk_user_password FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tabla audit_logs
CREATE TABLE IF NOT EXISTS audit_logs (
    id BINARY(16) PRIMARY KEY,
    user_id BINARY(16),
    action VARCHAR(100) NOT NULL,
    timestamp DATETIME,
    ip_address VARCHAR(50),
    CONSTRAINT fk_user_audit FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insertar roles iniciales
INSERT INTO roles (id, name, description) VALUES
  (UUID_TO_BIN(UUID()), 'ADMIN', 'Administrador'),
  (UUID_TO_BIN(UUID()), 'USER', 'Usuario estándar');

-- Insertar permiso de ejemplo
INSERT INTO permissions (id, name, description) VALUES
  (UUID_TO_BIN(UUID()), 'CAN_UPDATE_PASSWORD', 'Permite actualizar la contraseña');
