create sequence hibernate_sequence start 1 increment 1
create table Race (id int8 not null, team_name varchar(255), primary key (id))
create sequence hibernate_sequence start 1 increment 1
create table Race (id int8 not null, team_name varchar(255), primary key (id))
create table Race (id  bigserial not null, race_date timestamp, team_name varchar(255), primary key (id))
create table Team (id  bigserial not null, primary key (id))
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, team_name varchar(255), primary key (id))
create table Team (id  bigserial not null, primary key (id))
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, team_name varchar(255), primary key (id))
create table Team (id  bigserial not null, race_id int8, primary key (id))
alter table Team add constraint FK632pjv4vt283ta5hksthha6od foreign key (race_id) references Race
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, team_name varchar(255), primary key (id))
create table Team (id  bigserial not null, race_id int8, primary key (id))
alter table Team add constraint FK632pjv4vt283ta5hksthha6od foreign key (race_id) references Race
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, primary key (id))
create table Team (id  bigserial not null, team_name varchar(255), race_id int8, primary key (id))
alter table Team add constraint FK632pjv4vt283ta5hksthha6od foreign key (race_id) references Race
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, primary key (id))
create table Team (id  bigserial not null, team_name varchar(255), race_id int8, primary key (id))
alter table Team add constraint FK632pjv4vt283ta5hksthha6od foreign key (race_id) references Race
create table Member (id  bigserial not null, address varchar(255), first_name varchar(255), last_name varchar(255), primary key (id))
create table Race (id  bigserial not null, location varchar(255), race_date timestamp, primary key (id))
create table Team (id  bigserial not null, team_name varchar(255), race_id int8, primary key (id))
alter table Team add constraint FK632pjv4vt283ta5hksthha6od foreign key (race_id) references Race
