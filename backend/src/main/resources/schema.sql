CREATE TABLE conta_corrente ( 
   id BIGINT auto_increment NOT NULL, 
   agencia VARCHAR(255) NOT NULL, 
   codigo VARCHAR(255) NOT NULL, 
   cpf_titular VARCHAR(255) NOT NULL, 
   nome_titular VARCHAR(255) NOT NULL,
   saldo FLOAT NOT NULL DEFAULT 0.0,
   primary key(id)
);


CREATE TABLE saque ( 
   id BIGINT auto_increment NOT NULL, 
   conta_corrente_id BIGINT NOT NULL,
   valor FLOAT NOT NULL,
   data TIMESTAMP,
   primary key(id)
);


CREATE TABLE deposito (
  id BIGINT auto_increment NOT NULL, 
  cpf VARCHAR(11) NOT NULL,
  conta_corrente_id BIGINT NOT NULL,
  valor FLOAT NOT NULL,
  data TIMESTAMP, 
  primary key(id)
);