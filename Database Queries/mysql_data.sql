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
    

-- First Level
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
-- Second Level
INSERT INTO parking_levels_slots(id,slot_type) values(221,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(222,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(223,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(224,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(225,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(226,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(227,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(228,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(229,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2210,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2211,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2212,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2213,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2214,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2215,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2216,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2217,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2218,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2219,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2220,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2221,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2222,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2223,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2224,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2225,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2226,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2227,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2228,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2229,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2230,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2231,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2232,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2233,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2234,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2235,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2236,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2237,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2238,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2239,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2240,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2241,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2242,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2243,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2244,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2245,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2246,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2247,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2248,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2251,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2252,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2253,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2254,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2255,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2256,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2257,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2258,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2259,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2260,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2261,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2262,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2263,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2264,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2265,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2266,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2267,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2268,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2269,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2270,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2271,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2272,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2273,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2274,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2275,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2276,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2277,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2278,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2279,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2280,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2281,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2282,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2283,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2284,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2285,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2286,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2287,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2288,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2291,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2292,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2293,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2294,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2295,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2296,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2297,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2298,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(2299,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22100,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22101,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22102,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22103,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22104,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22105,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22106,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22107,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22108,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22111,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22112,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22113,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22114,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22115,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22116,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22117,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22118,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22119,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22120,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22121,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22122,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22123,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22124,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22125,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22126,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22127,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22128,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22131,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22132,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22133,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22134,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22135,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22136,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22137,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22138,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22139,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22140,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22141,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22142,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22143,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22144,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22145,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22146,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22147,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22148,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22151,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22152,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22153,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22154,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22155,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22156,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22157,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22158,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22159,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22160,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22161,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22162,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22163,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22164,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22165,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22166,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22167,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22168,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22171,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22172,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22173,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22174,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22175,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22176,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22177,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22178,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22179,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22180,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22181,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22182,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22183,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22184,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22185,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22186,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22187,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22188,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22191,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22192,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22193,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22194,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22195,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22196,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22197,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22198,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22199,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22200,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22201,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22202,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22203,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22204,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22205,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22206,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22207,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(22208,'CAR');
INSERT INTO parking_levels_slots(id,slot_type) values(211,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(212,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(213,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(214,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(215,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(216,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(217,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(218,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(219,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2110,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2111,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2112,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2113,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2114,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2115,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2116,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2117,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2118,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2119,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2120,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2121,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2122,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2123,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2124,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2125,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2126,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2127,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2128,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2129,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2130,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2131,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2132,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2133,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2134,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2135,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2136,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2137,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2138,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2139,'MOTORCYCLE');
INSERT INTO parking_levels_slots(id,slot_type) values(2140,'MOTORCYCLE');

INSERT INTO parking_levels_slots(id,slot_type) values(231,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(232,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(233,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(234,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(235,'BUS');
INSERT INTO parking_levels_slots(id,slot_type) values(236,'BUS');

SELECT * FROM parking_levels_slots;
SELECT * FROM card_details;
SELECT * FROM time_details;
