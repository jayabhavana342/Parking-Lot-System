DROP
    DATABASE parkinglot;
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
    card_No VARCHAR(16) NOT NULL,
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
) AUTO_INCREMENT = 1; -- First Level
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(121, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(122, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(123, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(124, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(125, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(126, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(127, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(128, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(129, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1210, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1211, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1212, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1213, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1214, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1215, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1216, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1217, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1218, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1219, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1220, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1221, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1222, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1223, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1224, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1225, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1226, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1227, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1228, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1229, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1230, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1231, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1232, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1233, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1234, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1235, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1236, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1237, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1238, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1239, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1240, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1241, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1242, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1243, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1244, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1245, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1246, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1247, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1248, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1251, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1252, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1253, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1254, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1255, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1256, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1257, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1258, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1259, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1260, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1261, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1262, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1263, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1264, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1265, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1266, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1267, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1268, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1269, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1270, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1271, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1272, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1273, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1274, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1275, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1276, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1277, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1278, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1279, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1280, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1281, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1282, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1283, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1284, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1285, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1286, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1287, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1288, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1291, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1292, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1293, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1294, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1295, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1296, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1297, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1298, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1299, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12100, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12101, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12102, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12103, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12104, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12105, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12106, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12107, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12108, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12111, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12112, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12113, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12114, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12115, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12116, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12117, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12118, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12119, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12120, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12121, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12122, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12123, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12124, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12125, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12126, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12127, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12128, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12131, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12132, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12133, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12134, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12135, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12136, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12137, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12138, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12139, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12140, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12141, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12142, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12143, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12144, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12145, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12146, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12147, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12148, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12151, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12152, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12153, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12154, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12155, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12156, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12157, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12158, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12159, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12160, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12161, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12162, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12163, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12164, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12165, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12166, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12167, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12168, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12171, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12172, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12173, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12174, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12175, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12176, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12177, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12178, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12179, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12180, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12181, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12182, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12183, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12184, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12185, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12186, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12187, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12188, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12191, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12192, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12193, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12194, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12195, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12196, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12197, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12198, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12199, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12200, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12201, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12202, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12203, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12204, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12205, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12206, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12207, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(12208, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(111, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(112, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(113, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(114, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(115, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(116, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(117, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(118, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(119, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1110, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1111, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1112, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1113, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1114, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1115, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1116, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1117, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1118, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1119, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1120, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1121, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1122, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1123, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1124, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1125, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1126, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1127, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1128, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1129, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1130, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1131, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1132, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1133, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1134, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1135, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1136, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1137, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1138, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1139, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(1140, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(131, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(132, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(133, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(134, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(135, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(136, 'BUS'); -- Second Level
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(221, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(222, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(223, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(224, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(225, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(226, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(227, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(228, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(229, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2210, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2211, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2212, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2213, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2214, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2215, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2216, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2217, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2218, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2219, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2220, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2221, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2222, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2223, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2224, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2225, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2226, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2227, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2228, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2229, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2230, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2231, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2232, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2233, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2234, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2235, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2236, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2237, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2238, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2239, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2240, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2241, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2242, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2243, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2244, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2245, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2246, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2247, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2248, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2251, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2252, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2253, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2254, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2255, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2256, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2257, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2258, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2259, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2260, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2261, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2262, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2263, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2264, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2265, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2266, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2267, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2268, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2269, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2270, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2271, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2272, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2273, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2274, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2275, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2276, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2277, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2278, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2279, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2280, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2281, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2282, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2283, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2284, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2285, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2286, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2287, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2288, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2291, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2292, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2293, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2294, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2295, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2296, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2297, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2298, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2299, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22100, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22101, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22102, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22103, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22104, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22105, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22106, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22107, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22108, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22111, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22112, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22113, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22114, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22115, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22116, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22117, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22118, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22119, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22120, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22121, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22122, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22123, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22124, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22125, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22126, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22127, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22128, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22131, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22132, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22133, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22134, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22135, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22136, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22137, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22138, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22139, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22140, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22141, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22142, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22143, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22144, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22145, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22146, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22147, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22148, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22151, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22152, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22153, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22154, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22155, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22156, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22157, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22158, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22159, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22160, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22161, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22162, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22163, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22164, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22165, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22166, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22167, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22168, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22171, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22172, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22173, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22174, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22175, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22176, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22177, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22178, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22179, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22180, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22181, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22182, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22183, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22184, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22185, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22186, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22187, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22188, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22191, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22192, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22193, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22194, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22195, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22196, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22197, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22198, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22199, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22200, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22201, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22202, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22203, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22204, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22205, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22206, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22207, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(22208, 'CAR');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(211, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(212, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(213, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(214, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(215, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(216, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(217, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(218, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(219, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2110, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2111, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2112, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2113, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2114, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2115, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2116, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2117, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2118, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2119, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2120, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2121, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2122, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2123, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2124, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2125, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2126, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2127, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2128, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2129, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2130, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2131, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2132, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2133, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2134, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2135, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2136, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2137, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2138, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2139, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(2140, 'MOTORCYCLE');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(231, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(232, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(233, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(234, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(235, 'BUS');
INSERT
INTO
    parking_levels_slots(id, slot_type)
VALUES(236, 'BUS');
SELECT
    *
FROM
    parking_levels_slots;
SELECT
    *
FROM
    card_details;
SELECT
    *
FROM
    time_details;