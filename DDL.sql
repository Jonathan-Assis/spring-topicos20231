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
/* 
create table if not exists ant_anotacoes (
  ant_id int not null auto_increment,
  ant_anotacao not null varchar(256),
  ant_data_criado not null datetime DEFAULT CURRENT_TIMESTAMP,
  ant_data_atualizado datetime DEFAULT CURRENT_TIMESTAMP,
  usr_id bigint unsigned not null,
  constraint usr_usuario_anotacoes foreign key (usr_id) references usr_usuario(usr_id)
); */