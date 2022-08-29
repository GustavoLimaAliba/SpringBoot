INSERT INTO USUARIO(nome, email, senha) VALUES('Gustavo', 'aluno@email.com', '$2a$10$hAf2wgwr4Y.0A0fMldTWRec0QVklpQJvFZ1C.COo6xQ1Y/9BMx46W');


INSERT INTO EMPRESA(nome, categoria) VALUES('Burger King', 'Fast Food');
INSERT INTO EMPRESA(nome, categoria) VALUES('Mc Donalds', 'Fast Food');


INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, usuario_id, empresa_id) VALUES('Whopper', 'Sem cebola', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 2);
INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, usuario_id, empresa_id) VALUES('Big mac', 'Sem maionese', '2019-05-05 18:00:00', 'FECHADO', 1, 1);
INSERT INTO PEDIDO(titulo, mensagem, data_criacao, status, usuario_id, empresa_id) VALUES('Big mac', 'Sem maionese', '2019-05-05 18:00:00', 'FECHADO', 1, 1 );

INSERT INTO PRODUTO(nome, categoria) VALUES('laranja', 'Mercado');
INSERT INTO PRODUTO(nome, categoria) VALUES('uva', 'Feira');
INSERT INTO LOJA(data_de_entrega, status, tipo, titulo, produto_id) VALUES('2019-05-05 18:00:00', 'FECHADO', 'opa', 'Entrega de laranjas', 1);
