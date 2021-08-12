CREATE DATABASE jokenpo
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

CREATE TABLE jogador
(
	id INT NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(50) NOT NULL,
    vitorias INT,
    derrotas INT,
    empates INT,
    PRIMARY KEY (id)
)DEFAULT CHARSET = utf8;

use jokenpo;

select * from jogador;

describe jogador;

drop table jogador;