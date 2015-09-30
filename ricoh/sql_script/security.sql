DROP TABLE roles;
CREATE TABLE roles ( id int NOT NULL AUTO_INCREMENT, username varchar(45) NOT NULL, role_name varchar(45) NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into roles (id, username, role_name) values (1, 'may', 'ROLE_USER');
insert into roles (id, username, role_name) values (2, 'ple', 'ROLE_ADMIN');
DROP TABLE users;
CREATE TABLE users ( id int NOT NULL AUTO_INCREMENT, username varchar(45) NOT NULL, password varchar(45) NOT NULL, enabled tinyint DEFAULT '1' NOT NULL, created_date_time date, updated_date_time bigint, PRIMARY KEY (id), CONSTRAINT ix1 UNIQUE (username) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into users (id, username, password, enabled, created_date_time, updated_date_time) values (1, 'may', '123', 1, null, null);
insert into users (id, username, password, enabled, created_date_time, updated_date_time) values (2, 'ple', '123', 1, null, null);


CREATE TABLE `hibernate_sequences` (
  `sequence_name` varchar(255) default NULL,
  `sequence_next_hi_value` int(11) default NULL
);
INSERT INTO hibernate_sequences VALUES ('users.id', 0);
INSERT INTO hibernate_sequences VALUES ('roles.id', 0);