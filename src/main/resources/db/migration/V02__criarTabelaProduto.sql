CREATE TABLE IF NOT EXISTS produto(
codigo BIGINT(20) AUTO_INCREMENT NOT NULL,
descricao VARCHAR(255) NOT NULL,
valor_unitario DOUBLE(20) NOT NULL,
data_criacao DATE NOT NULL,
status BIT(1) NOT NULL,
usuario_id BIGINT(20) NOT NULL,
PRIMARY KEY (codigo),
FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);