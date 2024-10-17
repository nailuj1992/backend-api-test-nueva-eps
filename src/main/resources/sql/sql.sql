-- Crear tabla Contrato
CREATE TABLE contracts (
    id_contract BIGINT AUTO_INCREMENT PRIMARY KEY,
    modality VARCHAR(50) NOT NULL,  -- Evento o Cápita
    consecutive_number BIGINT NOT NULL,  -- Número de contrato (solo numérico)
    regimen VARCHAR(50) NOT NULL,  -- Contributivo o Subsidiado
    id_file BIGINT NOT NULL, 
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear tabla Archivo
CREATE TABLE files (
    uuid BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL, 
    type VARCHAR(255) NOT NULL, 
    data LONGBLOB NOT NULL
);

-- Indexar el campo numero_contrato para mejorar la búsqueda
CREATE INDEX idx_consecutive_number ON contracts(consecutive_number);

alter table contracts 
add constraint fk_contract_file foreign key (id_file) references files(uuid);
