CREATE TABLE lancamento
(
    id bigint NOT NULL AUTO_INCREMENT UNIQUE,
    usuario_id bigint NOT NULL,
    descricao text NOT NULL,
    data datetime NOT NULL,
    valor decimal(10,2) NOT NULL,
    tipo ENUM('RECEITA','DESPESA'),
  	status ENUM('PENDENTE','CANCELADO','EFETIVADO'),
    
    PRIMARY KEY(id),
     
    CONSTRAINT fk_lancamento_usuario FOREIGN KEY (usuario_id) REFERENCES usuario (id)
);