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
    parking_levels;
DROP TABLE IF EXISTS
    parking_slots;
DROP TABLE IF EXISTS
    parking_levels_slots;
    
CREATE TABLE parking_levels(
	level_id INT(11) PRIMARY KEY auto_increment,
	level_name varchar(50) NOT NULL
)
auto_increment = 1;

INSERT INTO parking_levels(level_name) values ('L1');
INSERT INTO parking_levels(level_name) values ('L2');

CREATE TABLE parking_slots(
	slot_id INT(11) PRIMARY KEY auto_increment,
	slot_name VARCHAR(11) NOT NULL,
	slot_type ENUM('Car','Bus')
)
auto_increment = 1;

INSERT INTO parking_slots(slot_name, slot_type) values('S1', 'Car');
INSERT INTO parking_slots(slot_name, slot_type) values('S2', 'Bus');

CREATE TABLE parking_levels_slots(
	id INT(11) PRIMARY KEY auto_increment,
	slot_id INT(11) NOT NULL,
	level_id INT(11) NOT NULL,
	is_ocupied BOOLEAN DEFAULT 0 
)
auto_increment = 1;


insert into parking_levels_slots(level_id,slot_id)
select a.level_id, b.slot_id 
from parking_levels a cross join parking_slots b;
    
    
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
    `phone` INT(10) UNIQUE NOT NULL,
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
    id INT(11) auto_increment,
    vehicle_No VARCHAR(10) UNIQUE,
    vehicle_Type ENUM('Car','Bus'),
    slot_level_id INT(11),
    PRIMARY KEY(id),
    FOREIGN KEY(slot_level_id) REFERENCES parking_levels_slots(id)
) AUTO_INCREMENT = 1;

CREATE TABLE card_details(
	id INT(11) PRIMARY KEY auto_increment,
    vehicle_ID INT(11),
    card_No VARCHAR(10) NOT NULL,
    cvv INT(3) NOT NULL,
    name_on_card VARCHAR(50) NOT NULL,
    FOREIGN KEY(vehicle_ID) REFERENCES vehicle_details(id)
) AUTO_INCREMENT = 1;


CREATE TABLE time_details(
	id INT(11) PRIMARY KEY auto_increment,
    vehicle_ID INT(11),
    In_Time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    Out_Time TIMESTAMP,
    noOfDays INT(5) DEFAULT 1,
    FOREIGN KEY(vehicle_ID) REFERENCES vehicle_details(id)
) AUTO_INCREMENT = 1;


create table parking_vehicle_amount(
	id INT(11) PRIMARY KEY auto_increment,
	vehicle_ID INT(11) NOT NULL,
    frequent_parker_id INT(11),
    original_amount float NOT NULL,
    bill_amount float NOT NULL,
    FOREIGN KEY (vehicle_ID) REFERENCES vehicle_details(id),
    FOREIGN KEY(frequent_parker_id) REFERENCES frequent_parking_users(id)
)
auto_increment = 1;



-- CHECK IN HOME PAGE
-- To fetch Current Parking rate
SELECT * FROM `parking_rates` WHERE is_active = 1;

-- check if there are any empty slots or not
SELECT
    IF(COUNT(*) > 0,
    'true',
    'false') AS hasEmptySlots
FROM
    parking_levels_slots
WHERE
    (is_ocupied = 0)

-- to fetch the number of empty car slots
SELECT
    COUNT(*) AS carSlotsAvailable
FROM
    parking_levels_slots
WHERE
    (
        (is_ocupied = 0) AND(
        SELECT
            IF(slot_type = 'Car', 1, 0)
        FROM
            parking_slots
        WHERE
            parking_levels_slots.slot_id = parking_slots.slot_id
    )
    )
    
-- to fetch the number of empty bus slots
SELECT
    COUNT(*) AS busSlotsAvailable
FROM
    parking_levels_slots
WHERE
    (
        (is_ocupied = 0) AND(
        SELECT
            IF(slot_type = 'Bus', 1, 0)
        FROM
            parking_slots
        WHERE
            parking_levels_slots.slot_id = parking_slots.slot_id
    )
    )
    
-- SEARCH FOR FREQUENT PARKER
SELECT
    *
FROM
    `frequent_parking_users`
WHERE
    CONCAT(
        first_name,
        last_name,
        email,
        address,
        phone,
        license_id
    ) LIKE '%aish%'
    
-- --------
-- CUSTOMER USE REWARDS OR CHECKOUT
-- SHOW name,id,fullname if yes
SELECT
    id,
    rewards,
    CONCAT(last_name, " ", first_name) AS fullname
FROM
    `frequent_parking_users`
WHERE
    phone = 717717717

-- Update if they want to use the rewards
UPDATE
    frequent_parking_users
SET
    rewards = 1
WHERE
    id = 3  
    
-- --------

    
-- INSERT 
INSERT
INTO
    `vehicle_details`(`vehicle_No`, `Vehicle_Type`)
VALUES('12342131235', 'CAR');

INSERT INTO card_details ( vehicle_ID, card_No,cvv,name_on_card ) 
VALUES(LAST_INSERT_ID(), '12','12','abc')