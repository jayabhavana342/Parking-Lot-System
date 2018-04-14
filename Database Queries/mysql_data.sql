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


CREATE TABLE `frequent_parking_users` (
  `id`         INT(11)        NOT NULL AUTO_INCREMENT,
  `last_name`  VARCHAR(64)    NOT NULL,
  `first_name` VARCHAR(64)    NOT NULL,
  `email`      VARCHAR(64)    NOT NULL,
  `address`    VARCHAR(100)   NOT NULL,
  `phone`      INT(10) UNIQUE NOT NULL,
  `license_id` VARCHAR(10)    NOT NULL,
  `rewards`    INT(10)                 DEFAULT 0,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (1, 'karupanan', 'Shivaranjani', 'shivaranjani.karupanan@foo.com', 'txstate rrc', '515515515', 'A123A123');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (2, 'Kommuru', 'Bhavana', 'bhavana.kommuru@foo.com', 'txstate rrc', '616616616', 'A000A000');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (3, 'Agarwal', 'Mehak', 'mehak.agarwal@foo.com', 'txstate rrc', '717717717', 'A111A111');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (4, 'Rana', 'Aishwarya', 'aishwarya.rana@foo.com', 'txstate rrc', '818818818', 'A222A222');

INSERT INTO `frequent_parking_users` (`id`, `last_name`, `first_name`, `email`, `address`, `phone`, `license_id`)
VALUES (5, 'Ndame', 'Micheal', 'mike.adam@foo.com', 'txstate rrc', '919919919', 'A333A33');
