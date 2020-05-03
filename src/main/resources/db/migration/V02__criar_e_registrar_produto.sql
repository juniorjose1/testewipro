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

INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('PC', 2431, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Playstation 4', 1254, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Mesa', 254, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Celular', 7654, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Pilha', 9754, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Jaqueta', 12, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Violão', 90, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Geladeira', 34, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Cadeira', 26.46, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Carro', 98.37, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Gameboy', 875.24, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Fliperama', 124, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Notebook', 298, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Telescópio', 987, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Bola de Futebol', 4412, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Espada', 965, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Escudo', 2767, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Vassoura', 12553, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Microscópio', 43.98, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Secador', 321, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Guarda Roupa', 2000, '2020-05-03', 0, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Espelho', 2345, '2020-05-03', 1, 1);
INSERT INTO produto (descricao, valor_unitario, data_criacao, status, usuario_id) VALUES ('Shampoo', 1678, '2020-05-03', 0, 1);
