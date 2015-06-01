# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table authority (
  auth_id                   bigint not null,
  auth_name                 varchar(255),
  constraint pk_authority primary key (auth_id))
;

create table department (
  dep_id                    bigint not null,
  dep_name                  varchar(255),
  constraint pk_department primary key (dep_id))
;

create table employee (
  emp_id                    bigint not null,
  dep_id                    bigint,
  emp_name                  varchar(255),
  password                  varchar(255),
  auth_id                   bigint,
  constraint pk_employee primary key (emp_id))
;

create table help_category (
  helpcate_id               bigint not null,
  helpcate_name             varchar(255),
  constraint pk_help_category primary key (helpcate_id))
;

create table new (
  new_id                    integer not null,
  new_name                  varchar(255),
  constraint pk_new primary key (new_id))
;

create table read (
  read_id                   integer not null,
  read_name                 varchar(255),
  constraint pk_read primary key (read_id))
;

create table thanks_card (
  thanks_id                 bigint not null,
  send_dep                  bigint,
  send_id                   bigint,
  help_date                 timestamp,
  helpcate_id               bigint,
  help_said                 varchar(255),
  thanks_message            varchar(255),
  receive_dep               bigint,
  receive_id                bigint,
  send_date                 timestamp not null,
  constraint pk_thanks_card primary key (thanks_id))
;

create sequence authority_seq;

create sequence department_seq;

create sequence employee_seq;

create sequence help_category_seq;

create sequence new_seq;

create sequence read_seq;

create sequence thanks_card_seq;

alter table employee add constraint fk_employee_dep_id_1 foreign key (dep_id) references department (dep_id) on delete restrict on update restrict;
create index ix_employee_dep_id_1 on employee (dep_id);
alter table employee add constraint fk_employee_auth_id_2 foreign key (auth_id) references authority (auth_id) on delete restrict on update restrict;
create index ix_employee_auth_id_2 on employee (auth_id);
alter table thanks_card add constraint fk_thanks_card_send_dep_3 foreign key (send_dep) references department (dep_id) on delete restrict on update restrict;
create index ix_thanks_card_send_dep_3 on thanks_card (send_dep);
alter table thanks_card add constraint fk_thanks_card_send_id_4 foreign key (send_id) references employee (emp_id) on delete restrict on update restrict;
create index ix_thanks_card_send_id_4 on thanks_card (send_id);
alter table thanks_card add constraint fk_thanks_card_helpcate_id_5 foreign key (helpcate_id) references help_category (helpcate_id) on delete restrict on update restrict;
create index ix_thanks_card_helpcate_id_5 on thanks_card (helpcate_id);
alter table thanks_card add constraint fk_thanks_card_receive_dep_6 foreign key (receive_dep) references department (dep_id) on delete restrict on update restrict;
create index ix_thanks_card_receive_dep_6 on thanks_card (receive_dep);
alter table thanks_card add constraint fk_thanks_card_receive_id_7 foreign key (receive_id) references employee (emp_id) on delete restrict on update restrict;
create index ix_thanks_card_receive_id_7 on thanks_card (receive_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists authority;

drop table if exists department;

drop table if exists employee;

drop table if exists help_category;

drop table if exists new;

drop table if exists read;

drop table if exists thanks_card;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists authority_seq;

drop sequence if exists department_seq;

drop sequence if exists employee_seq;

drop sequence if exists help_category_seq;

drop sequence if exists new_seq;

drop sequence if exists read_seq;

drop sequence if exists thanks_card_seq;

