-- Migrations para adicionar coluna de rank na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR (255);