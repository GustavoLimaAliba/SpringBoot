INSERT INTO USUARIO(nome, email, senha) VALUES('Gustavo', 'aluno@email.com', '123456');
INSERT INTO USUARIO(nome, email, senha) VALUES('Jefe', 'aluno@email.com', '123456');
INSERT INTO USUARIO(nome, email, senha) VALUES('Yohan', 'aluno@email.com', '123456');
INSERT INTO USUARIO(nome, email, senha) VALUES('Yutacan', 'aluno@email.com', '123456');

INSERT INTO EMPRESA(nome, categoria) VALUES('Burger King', 'Fast Food');
INSERT INTO EMPRESA(nome, categoria) VALUES('Mc Donalds', 'Fast Food');


INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, pessoa_id, empresa_id) VALUES('Whopper', 'Sem cebola', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, pessoa_id, empresa_id) VALUES('Big mac', 'Sem maionese', '2019-05-05 18:00:00', 'FECHADO', 2, 2);
INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, pessoa_id, empresa_id) VALUES('Big mac', 'Sem maionese', '2019-05-05 18:00:00', 'FECHADO', 3, 2);
