create schema if not exists anotacao;

use anotacao;

create user if not exists 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on anotacao.* to user@'localhost';

create table if not exists usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(150) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

insert into usr_usuario(usr_nome,usr_senha) values("admin","senha123");

drop table if exists ant_anotacao;

create table if not exists ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_texto varchar(256) not null,
  ant_data_hora datetime not null default current_timestamp,
  ant_usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
); 

insert into ant_anotacao(ant_texto, ant_usr_id) values ('Teste', 1);