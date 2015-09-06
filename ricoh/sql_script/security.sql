DROP TABLE role;
CREATE TABLE role ( id int NOT NULL AUTO_INCREMENT, username varchar(45) NOT NULL, role_name varchar(45) NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into role (id, username, role_name) values (1, 'may', 'ROLE_USER');
insert into role (id, username, role_name) values (2, 'ple', 'ROLE_ADMIN');
DROP TABLE user;
CREATE TABLE user ( id int NOT NULL AUTO_INCREMENT, username varchar(45) NOT NULL, password varchar(45) NOT NULL, enabled tinyint DEFAULT '1' NOT NULL, created_date_time date, updated_date_time bigint, PRIMARY KEY (id), CONSTRAINT ix1 UNIQUE (username) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into user (id, username, password, enabled, created_date_time, updated_date_time) values (1, 'may', '123', 1, null, null);
insert into user (id, username, password, enabled, created_date_time, updated_date_time) values (2, 'ple', '123', 1, null, null);
