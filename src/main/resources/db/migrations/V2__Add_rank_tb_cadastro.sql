-- V2: Migration para adicionar a coluna de ranking na tabela de cadastro (TB_CADASTRO)
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);