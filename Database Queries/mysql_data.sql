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
INSERT INTO parking_levels_slots(id,slot_type) values(1251,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1252,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1253,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1254,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1255,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1256,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1257,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1258,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1259,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1260,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1261,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1262,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1263,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1264,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1265,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1266,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1267,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1268,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1269,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1270,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1271,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1272,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1273,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1274,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1275,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1276,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1277,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1278,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1279,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1280,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1281,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1282,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1283,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1284,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1285,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1286,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1287,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1288,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1291,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1292,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1293,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1294,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1295,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1296,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1297,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1298,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(1299,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12100,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12101,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12102,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12103,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12104,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12105,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12106,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12107,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12108,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12111,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12112,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12113,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12114,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12115,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12116,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12117,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12118,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12119,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12120,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12121,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12122,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12123,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12124,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12125,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12126,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12127,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12128,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12131,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12132,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12133,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12134,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12135,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12136,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12137,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12138,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12139,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12140,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12141,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12142,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12143,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12144,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12145,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12146,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12147,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12148,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12151,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12152,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12153,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12154,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12155,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12156,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12157,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12158,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12159,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12160,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12161,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12162,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12163,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12164,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12165,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12166,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12167,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12168,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12171,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12172,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12173,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12174,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12175,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12176,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12177,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12178,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12179,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12180,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12181,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12182,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12183,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12184,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12185,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12186,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12187,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12188,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12191,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12192,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12193,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12194,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12195,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12196,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12197,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12198,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12199,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12200,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12201,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12202,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12203,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12204,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12205,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12206,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12207,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(12208,'CAR');

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
INSERT INTO parking_levels_slots(id,slot_type) values(1121,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1122,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1123,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1124,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1125,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1126,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1127,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1128,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1129,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1130,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1131,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1132,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1133,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1134,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1135,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1136,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1137,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1138,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1139,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(1140,'MOTORCYCLE');

INSERT INTO parking_levels_slots(id,slot_type) values(131,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(132,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(133,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(134,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(135,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(136,'BUS');

SELECT * FROM parking_levels_slots;
SELECT * FROM card_details;
SELECT * FROM time_details;
