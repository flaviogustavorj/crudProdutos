USE dbprodutos;

CREATE TABLE produtos (
  id SERIAL PRIMARY KEY,
  nome varchar(255) NOT NULL,
  preco decimal(10,2) NOT NULL,
  quantidade int NOT NULL,
  dataHoraCadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);