DROP DATABASE IF EXISTS `spring_boot_server`;

CREATE DATABASE `spring_boot_server`;

USE `spring_boot_server`;

DROP TABLE  IF EXISTS `userinfo`;

CREATE TABLE `userinfo`(
  userid INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(64) NOT NULL ,
  password CHAR(32) NOT NULL ,
  addtime INT NOT NULL ,
  status INT NOT NULL ,
  PRIMARY KEY (userid)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE  IF EXISTS `userinfo_changelog`;

CREATE TABLE `userinfo_changelog`(
  pid INT  NOT NULL AUTO_INCREMENT,
  userid INT NOT NULL ,
  changetype INT NOT NULL ,
  changetime INT NOT NULL ,
  PRIMARY KEY (pid)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;