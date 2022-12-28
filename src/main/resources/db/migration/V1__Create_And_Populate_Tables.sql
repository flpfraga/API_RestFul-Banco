CREATE TABLE IF NOT EXISTS `conta` (
    `id_conta` int NOT NULL AUTO_INCREMENT,
    `nome_responsavel` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id_conta`)
);


CREATE TABLE IF NOT EXISTS `transferencia`
(
    `id` int NOT NULL AUTO_INCREMENT,
    `data_transferencia` timestamp NOT NULL,
    `valor` decimal (20,2) NOT NULL,
    `tipo` VARCHAR(15) NOT NULL,
    `nome_operador_transacao` VARCHAR (50),
    `conta_id` INT NOT NULL,
	PRIMARY KEY (`id`),
    CONSTRAINT `fk_conta` FOREIGN KEY (`conta_id`) REFERENCES `conta` (`id_conta`)
);

INSERT INTO `conta` (`id_conta`, `nome_responsavel`) VALUES 
	(1,'Fulano'),
	(2,'Sicrano');

INSERT INTO `transferencia` (`id`,`data_transferencia`, `valor`, `tipo`, `nome_operador_transacao`, `conta_id`) VALUES 
	(1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1),
	(2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2),
	(3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1),
	(4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2),
	(5,'2020-06-08 10:15:01+03',3241.23,'TRANSFERENCIA', 'Beltrano',1),
	(6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2)
