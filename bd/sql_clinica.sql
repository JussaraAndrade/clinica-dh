create database clinica;

create table paciente(
	id_paciente int auto_increment primary key,
    nome varchar(100) not null,
    endereco varchar(100) not null,
    data_nascimento date not null,
    telefone varchar(15) not null,
    data_primeira_consulta date not null,
    email varchar(100) not null,
    peso double not null,
    altura double not null,
    cpf varchar(15) not null unique
);

create table consulta(
	id_consulta int auto_increment primary key,
    data_consulta date not null,
    valor double not null,
    descricao varchar (200) not null,
    medico varchar (50) not null,
    fk_id_paciente int,
	FOREIGN KEY(fk_id_paciente) REFERENCES paciente (id_paciente)

);

create table receita(
    id_receita int auto_increment primary key,
    descricao varchar(200) not null,
    tempo int not null,
    dosagem varchar(20) not null
);

