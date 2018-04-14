CREATE DATABASE IF NOT EXISTS parkinglot;

USE parkinglot;

DROP TABLE IF EXISTS admin_users;

CREATE TABLE `admin_users` (
  `id`         INT(11)      NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)           DEFAULT NULL,
  `first_name` VARCHAR(64)           DEFAULT NULL,
  `email`      VARCHAR(64)  NOT NULL,
  `password`   VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `admin_users` (`last_name`, `first_name`, `email`, `password`)
VALUES ('Alpha', 'Joe', 'joe.alpha@foo.com', 'admin');

CREATE TABLE `parking_rates` (
  `id`   INT(11)   NOT NULL AUTO_INCREMENT,
  `date` TIMESTAMP NOT NULL,
  `rate` INT(11)   NOT NULL,
  `is_active` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `parking_rates` VALUES (1, TIMESTAMP '2005-05-13 07:15:31.123456789',5 , 1);