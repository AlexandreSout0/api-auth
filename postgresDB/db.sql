-- Criação da tabela address
CREATE TABLE address (
    id_address SERIAL PRIMARY KEY,
    cep VARCHAR(10),
    address_line1 VARCHAR(100),
    number INT,
    address_line2 VARCHAR(100),
    city VARCHAR(50),
    country VARCHAR(50),
    state VARCHAR(50)
);

-- Criação da tabela user
CREATE TABLE client (
    id_client SERIAL PRIMARY KEY,
    id_address INT,
    name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(50),
    cpf VARCHAR(14),
    birthday DATE,
    FOREIGN KEY (id_address) REFERENCES address(id_address)
);