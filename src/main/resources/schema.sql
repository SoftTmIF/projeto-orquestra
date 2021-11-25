CREATE DATABASE ORQUESTRA;
use orquestra;

CREATE TABLE `projeto` (
  `id_projeto` int NOT NULL AUTO_INCREMENT,
  `item_task` int DEFAULT NULL,
  `nome_projeto` varchar(45) NOT NULL,
  PRIMARY KEY (`id_projeto`),
  UNIQUE KEY `id_projeto_UNIQUE` (`id_projeto`)
) ENGINE=InnoDB AUTO_INCREMENT=2;

CREATE TABLE `task` (
  `id_task` int NOT NULL AUTO_INCREMENT,
  `data_de_execucao` date NOT NULL,
  `total_de_horas` decimal(4,0) NOT NULL,
  `tipo_natureza` varchar(1) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `id_usuario` int NOT NULL,
  `projeto` int NOT NULL,
  PRIMARY KEY (`id_task`),
  UNIQUE KEY `item_UNIQUE` (`id_task`),
  KEY `id_usuario_idx` (`id_usuario`),
  KEY `projeto_idx` (`projeto`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `projeto` FOREIGN KEY (`projeto`) REFERENCES `projeto` (`id_projeto`)
) ENGINE=InnoDB;

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `senha` varchar(12) NOT NULL,
  `nome_usuario` varchar(60) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `id_UNIQUE` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5;

CREATE TABLE `usuario_projeto` (
  `id_usuario_projeto` int NOT NULL AUTO_INCREMENT,
  `usuario_r` int NOT NULL,
  `projeto_r` int NOT NULL,
  PRIMARY KEY (`id_usuario_projeto`),
  UNIQUE KEY `id_usuario_projeto_UNIQUE` (`id_usuario_projeto`),
  KEY `projeto_r_idx` (`projeto_r`),
  KEY `usuario_r_idx` (`usuario_r`),
  CONSTRAINT `projeto_r` FOREIGN KEY (`projeto_r`) REFERENCES `projeto` (`id_projeto`),
  CONSTRAINT `usuario_r` FOREIGN KEY (`usuario_r`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB;

select * from usuario_projeto;
select * from task;
select * from usuario;