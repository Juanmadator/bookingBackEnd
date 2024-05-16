drop database if  exists bookingApp;

create database bookingApp;

use bookingApp;

	
SELECT * FROM building b WHERE b.id IN (select building_id FROM day_of_week,building WHERE building_id=building.id);
SELECT * FROM day_of_week;
select * from building b , place_type p WHERE b.place_type_id="2"; 
SELECT * FROM location;
SELECT * FROM building;
SELECT * FROM bookable;
SELECT * FROM service;
SELECT * FROM place_type ORDER BY 1;
SELECT * FROM place_type p ORDER BY p.id ;


use bookingapp;
SELECT * FROM building;

CREATE TABLE location (
    id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    latitude DECIMAL(9,6),
    longitude DECIMAL(9,6)
);

CREATE TABLE place_type (
    id INT AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255) unique
);

SELECT * FROM service;

CREATE TABLE building (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) unique NOT NULL,
    place_type_id INT NOT NULL,
    location_id INT NOT NULL,
    description TEXT,
    photo VARCHAR(255) NOT NULL,
    #one building has a location and a place type
    FOREIGN KEY (location_id) REFERENCES location(id),
    FOREIGN KEY(place_type_id) REFERENCES place_type(id)
);

CREATE TABLE bookable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255) ,
    slots INT,
    building_id INT,
    FOREIGN KEY(building_id) REFERENCES building(id)
);


CREATE TABLE day_of_week (
    id INT AUTO_INCREMENT PRIMARY KEY,
    day VARCHAR(30),
    is_closed BOOLEAN,
    opening_time time,
    closing_time time,
    building_id INT ,
    FOREIGN KEY(building_id)references building(id)
);

CREATE TABLE service (
    id INT AUTO_INCREMENT PRIMARY KEY,
    label VARCHAR(255),
    building_id INT,
    FOREIGN KEY(building_id) REFERENCES building(id)
);


CREATE TABLE booking(
	id int auto_increment primary key,
	name_building VARCHAR(255),
	name_bookable VARCHAR(255),
	day_of_month DATE,
	start_hour time,
	finish_hour time,
	duration int,
	reserved_slots int
);



-- Inserts para la tabla Location
INSERT INTO Location (address, latitude, longitude) VALUES 
('123 Main St', 40.7128, -74.0060),
('456 Elm St', 34.0522, -118.2437),
('789 Oak St', 51.5074, -0.1278);

INSERT INTO Location (address,latitude,longitude) VALUES
('Via Giuseppe Mazzini',60.2,12.12);

-- Inserts para la tabla PlaceType
INSERT INTO place_type (label) VALUES 
('Office'),
('Library'),
('Restaurant');


-- Inserts para la tabla Building
INSERT INTO Building (name, location_id, place_type_id, description, photo) VALUES 
('Building A', 1, 1, 'Modern office building', 'office.jpg'),
('Building B', 2, 2, 'Cozy library', 'library.jpg'),
('Building C', 3, 3, 'Popular restaurant', 'restaurant.jpg');




-- Inserts para la tabla Bookable
INSERT INTO bookable (label, slots,building_id) VALUES 
('Desk', 20,1),
('Meeting Room', 5,1),
('Private Office', 10,1);

-- Inserts para la tabla DayOfWeek
INSERT INTO day_of_week (day, is_closed, opening_time, closing_time,building_id) VALUES 
('MONDAY', false, '09:00:00', '18:00:00',1),
('TUESDAY', false, '09:00:00', '18:00:00',1),
('WEDNESDAY', false, '09:00:00', '18:00:00',1);




INSERT INTO day_of_week (day, is_closed, opening_time, closing_time,building_id) VALUES 
('MONDAY', false, '09:00:00', '18:00:00',1);
-- Inserts para la tabla Service
INSERT INTO service (label,building_id) VALUES 
('WiFi',1),
('Parking',1),
('Cafeteria',1);
