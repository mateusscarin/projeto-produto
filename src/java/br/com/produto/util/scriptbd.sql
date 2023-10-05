/**
 * Author:  Mateus Scarin
 * Created: 25/09/2023
 */
create table produto(
    id serial not null,
    nome varchar(255) not null,
    descricao varchar(255),
    constraint pk_produto primary key (id)
);

