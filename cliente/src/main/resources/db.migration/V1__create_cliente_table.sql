CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,

    -- Campos embutidos de EnderecoEntity
    endereco_rua VARCHAR(255),
    endereco_numero VARCHAR(20),
    endereco_bairro VARCHAR(100),
    endereco_cidade VARCHAR(100),
    endereco_estado VARCHAR(50),
    endereco_cep VARCHAR(20)
);
