DROP SCHEMA IF EXISTS weso;
CREATE SCHEMA weso;

DROP USER 'WesoApp'@'localhost';
CREATE USER 'WesoApp'@'localhost' IDENTIFIED BY 'weso#34';
FLUSH PRIVILEGES;

GRANT select, insert, update, delete, create, drop on weso.* to 'WesoApp'@'localhost';
