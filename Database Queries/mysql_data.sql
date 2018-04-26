DROP database parkinglot;

CREATE DATABASE IF NOT EXISTS parkinglot;

USE
    parkinglot;
DROP TABLE IF EXISTS
    admin_users;
DROP TABLE IF EXISTS
    parking_rates;
DROP TABLE IF EXISTS
    card_details;
DROP TABLE IF EXISTS
    time_details;
DROP TABLE IF EXISTS
    parking_vehicle_amount;
DROP TABLE IF EXISTS
    frequent_parking_users;
DROP TABLE IF EXISTS
    vehicle_details;
DROP TABLE IF EXISTS
    parking_levels_slots;
    
CREATE TABLE parking_levels_slots(
    id INT PRIMARY KEY,
    slot_type ENUM('CAR', 'BUS', 'MOTORCYCLE'),
    is_ocupied BOOLEAN DEFAULT 0
);

CREATE TABLE `admin_users`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(64) DEFAULT NULL,
    `first_name` VARCHAR(64) DEFAULT NULL,
    `email` VARCHAR(64) NOT NULL,
    `password` VARCHAR(256) NOT NULL,
    PRIMARY KEY(`id`)
) AUTO_INCREMENT = 1;

INSERT
INTO
    `admin_users`(
        `last_name`,
        `first_name`,
        `email`,
        `password`
    )
VALUES(
    'Alpha',
    'Joe',
    'joe.alpha@foo.com',
    'admin'
);

CREATE TABLE `parking_rates`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `date` TIMESTAMP NOT NULL,
    `rate` FLOAT(11) NOT NULL,
    `is_active` BOOLEAN NOT NULL,
    PRIMARY KEY(`id`)
) AUTO_INCREMENT = 1;

INSERT
INTO
    `parking_rates`
VALUES(
    1,
    TIMESTAMP '2005-05-13 07:15:31.123456789',
    5.00,
    1
);

CREATE TABLE `frequent_parking_users`(
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `last_name` VARCHAR(64) NOT NULL,
    `first_name` VARCHAR(64) NOT NULL,
    `email` VARCHAR(64) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `phone` VARCHAR(10) UNIQUE NOT NULL,
    `license_id` VARCHAR(10) NOT NULL,
    `rewards` FLOAT(10) DEFAULT 2,
    PRIMARY KEY(`id`)
) AUTO_INCREMENT = 1;

INSERT
INTO
    `frequent_parking_users`(
        `id`,
        `last_name`,
        `first_name`,
        `email`,
        `address`,
        `phone`,
        `license_id`
    )
VALUES(
    1,
    'karupanan',
    'Shivaranjani',
    'shivaranjani.karupanan@foo.com',
    'txstate rrc',
    '515515515',
    'A123A123'
);
INSERT
INTO
    `frequent_parking_users`(
        `id`,
        `last_name`,
        `first_name`,
        `email`,
        `address`,
        `phone`,
        `license_id`
    )
VALUES(
    2,
    'Kommuru',
    'Bhavana',
    'bhavana.kommuru@foo.com',
    'txstate rrc',
    '616616616',
    'A000A000'
);
INSERT
INTO
    `frequent_parking_users`(
        `id`,
        `last_name`,
        `first_name`,
        `email`,
        `address`,
        `phone`,
        `license_id`
    )
VALUES(
    3,
    'Agarwal',
    'Mehak',
    'mehak.agarwal@foo.com',
    'txstate rrc',
    '717717717',
    'A111A111'
);
INSERT
INTO
    `frequent_parking_users`(
        `id`,
        `last_name`,
        `first_name`,
        `email`,
        `address`,
        `phone`,
        `license_id`
    )
VALUES(
    4,
    'Rana',
    'Aishwarya',
    'aishwarya.rana@foo.com',
    'txstate rrc',
    '818818818',
    'A222A222'
);
INSERT
INTO
    `frequent_parking_users`(
        `id`,
        `last_name`,
        `first_name`,
        `email`,
        `address`,
        `phone`,
        `license_id`
    )
VALUES(
    5,
    'Ndame',
    'Micheal',
    'mike.adam@foo.com',
    'txstate rrc',
    '919919919',
    'A333A33'
);

CREATE TABLE vehicle_details(
    id INT(11) AUTO_INCREMENT,
    vehicle_No VARCHAR(10) UNIQUE,
    vehicle_Type ENUM('Car', 'Bus', 'MOTORCYCLE'),
    PRIMARY KEY(id)
) AUTO_INCREMENT = 1;

CREATE TABLE card_details(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    vehicle_ID INT(11),
    card_No VARCHAR(10) NOT NULL,
    cvv INT(3) NOT NULL,
    name_on_card VARCHAR(50) NOT NULL,
    FOREIGN KEY(vehicle_ID) REFERENCES vehicle_details(id)
) AUTO_INCREMENT = 1;

CREATE TABLE time_details(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    vehicle_ID INT(11),
    In_Time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Out_Time TIMESTAMP,
    noOfDays INT(5) DEFAULT 1,
    slot_level_id INT(11),
    check_in_rate FLOAT NOT NULL,
    FOREIGN KEY(vehicle_ID) REFERENCES vehicle_details(id),
    FOREIGN KEY(slot_level_id) REFERENCES parking_levels_slots(id)
) AUTO_INCREMENT = 1;

CREATE TABLE parking_vehicle_amount(
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    vehicle_ID INT(11) NOT NULL,
    frequent_parker_id INT(11),
    bill_amount FLOAT NOT NULL,
    checkout_amount FLOAT NOT NULL,
    FOREIGN KEY(vehicle_ID) REFERENCES vehicle_details(id),
    FOREIGN KEY(frequent_parker_id) REFERENCES frequent_parking_users(id)
) AUTO_INCREMENT = 1;
    
INSERT INTO parking_levels_slots(id,slot_type) values(121,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(122,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(123,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(124,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(125,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(126,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(127,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(128,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(129,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1210,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1211,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1212,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1213,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1214,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1215,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1216,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1217,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1218,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1219,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1220,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1221,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1222,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1223,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1224,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1225,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1226,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1227,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1228,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1229,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1230,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1231,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1232,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1233,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1234,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1235,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1236,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1237,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1238,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1239,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1240,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1241,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1242,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1243,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1244,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1245,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1246,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1247,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1248,'CAR');
    
INSERT INTO parking_levels_slots(id,slot_type) values(111,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(112,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(113,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(114,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(115,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(116,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(117,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(118,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(119,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1110,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1111,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1112,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1113,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1114,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1115,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1116,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1117,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1118,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1119,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1120,'MOTORCYCLE');

INSERT INTO parking_levels_slots(id,slot_type) values(131,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(132,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(133,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(134,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(135,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(136,'BUS');

SELECT * FROM parking_levels_slots;
