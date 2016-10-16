DROP DATABASE IF EXISTS buildings01;
CREATE DATABASE buildings01;
USE buildings01;

DROP USER IF EXISTS 'javapopulater';
CREATE USER 'javapopulater' IDENTIFIED BY 'dejligtlangt$82verylong';
GRANT ALL ON buildings01.* TO 'javapopulater';

CREATE TABLE room (
  id int(11) NOT NULL AUTO_INCREMENT,
  floor int(11) ,
  roomNo int(11) ,
  noWindows int(11),
  area int(11) ,
  fkBuilding int(11) ,
  PRIMARY KEY (id)
);

CREATE TABLE building (
  id int(11) ,
  street text,
  contactName varchar(100) ,
  zip int(11) ,
  city varchar(100) ,
  contactPhone varchar(10),
  PRIMARY KEY (id)
);