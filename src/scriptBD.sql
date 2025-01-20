CREATE DATABASE prova;
USE prova;
CREATE TABLE usuario(
			login VARCHAR(50) NOT NULL,
		    senha VARCHAR(45)  NOT NULL,
		    PRIMARY KEY (login)
);
            
CREATE TABLE pedidos (
    id_pedidos INT AUTO_INCREMENT,
    nomeCliente VARCHAR(145) NOT NULL,
    enderecoEntrega VARCHAR(200) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    descricao VARCHAR(300) NOT NULL,
    login VARCHAR(50) NOT NULL,
    
    PRIMARY KEY (id_pedidos),
    FOREIGN KEY (login) REFERENCES usuario(login) ON DELETE CASCADE
    ON UPDATE CASCADE
);

INSERT INTO usuario(login, senha) VALUES ('admin@outlook.com', 'admin');