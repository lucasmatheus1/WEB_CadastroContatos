# iSeries

Projeto da Disciplina Desenvolvimento de Sistemas para Web - Professor Danyllo Wagner Albuquerque

## 📌 Link do Site

https://iseriesapp.herokuapp.com/

## 🛠️ Construído com

* JAVA
* [Spring Boot](https://spring.io/projects/spring-boot) 
* [MySQL](https://www.mysql.com/) - Banco de Dados (DEV) 
* [PostgreSQL](https://www.google.com/search?q=postgree&oq=postgree&aqs=chrome..69i57j69i59j35i39j0i67j69i61j69i60l3.1328j0j4&sourceid=chrome&ie=UTF-8) - Banco de Dados (PROD)

## ✒️ Autores

* **Lucas Matheus**
* **Marcelo Filho**
* **Moabe Barbosa** 

## SQL

create table episodio (id bigint not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY, assistiu varchar(255), nome varchar(255), temporada_id bigint);
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );

create table serie (id bigint not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY, nome varchar(255), qtd_episodios integer not null, qtd_temporadas integer not null, user_id bigint);
create table temporada (id bigint not null GENERATED ALWAYS AS IDENTITY PRIMARY KEY, nome varchar(255), qtd_assistiu varchar(255), serie_id bigint);
create table usuario (id bigint not null, email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), primary key (id));

alter table episodio add constraint FKrka8e4faw0byyy7jd34lrn1fo foreign key (temporada_id) references temporada (id);
alter table serie add constraint FKba4lafvolxd330warswyujq0g foreign key (user_id) references usuario (id);
alter table temporada add constraint FKq4vf6k6yhta8xe3tiudj0a6eo foreign key (serie_id) references serie (id);
