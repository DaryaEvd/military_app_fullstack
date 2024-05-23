INSERT INTO soldier_type (name_of_type, type_rank)
VALUES
    ('Soldier', 0),
    ('Corporal', 1),
    ('Ensign', 2),
    ('Sergeant', 3),
    ('Foreman', 4),
    ('Lieutenant', 5),
    ('Captain', 6),
    ('Major', 7),
    ('Lieutenant Colonel', 8),
    ('Colonel', 9),
    ('General', 10);

INSERT INTO subdivision_type(name_of_type, type_rank)
VALUES
    ('Squad', 0),
    ('Platoon', 1),
    ('Rota', 2),
    ('Military Unit', 3),
    ('Corps', 4),
    ('Brigade', 4),
    ('Division', 4),
    ('Army', 5);

-- Inserting data into mas_type table
INSERT INTO mas_type (code_of_mas, name_of_mas) VALUES
    ('00201', 'Operation and repair of engineering vehicles'),
    ('01000', 'Medical service in ground forces (general practitioner)'),
    ('01001', 'Combat use of engineer-sapper units and formations'),
    ('021000', 'Commander of motorized rifle platoon or Combat use of motorized rifle units, formations, and associations'),
    ('021001', 'Combat use of motorized rifle units, parts on BMP'),
    ('021002', 'Combat use of motorized rifle units, military units, and formations on BTR (vehicles)'),
    ('021101', 'Combat use of medium tank units or Combat use of medium tank units, parts'),
    ('0300', 'Organization of food supply'),
    ('030403', 'Combat use of units and parts of regimental and divisional artillery. May hold positions: commander of fire platoon, commander of control platoon, commander of mortar platoon'),
    ('030404', 'Combat use of units and military units of anti-tank artillery'),
    ('030405', 'Combat use of mortar units, parts, and formations. May hold positions: commander of fire platoon, commander of control platoon, commander of mortar platoon'),
    ('037', 'Commander of BM Strela-10'),
    ('041800', 'Combat use of units and military units armed with short-range air defense systems (Strela-10)'),
    ('041900', 'Combat use of units and military units armed with short-range air defense systems (Igla)'),
    ('043203', 'Combat use of starting units of multi-channel medium-range air defense systems'),
    ('06008', 'Technical personnel'),
    ('062600', 'Flight personnel'),
    ('072301', 'Navigator of diesel submarines'),
    ('08600', 'Organization of humanitarian training'),
    ('093500', 'Psychological warfare officer (with knowledge of a foreign language)'),
    ('094001', 'Combat use of ground reconnaissance units'),
    ('097001', 'Combat use of artillery reconnaissance units'),
    ('10003', 'Commander of engineering and technical platoon'),
    ('100097', 'Deputy platoon commander'),
    ('100182', 'Commander of motorized rifle squad'),
    ('100415', 'Signalman of motorized rifle troops'),
    ('100868', 'Senior gunner'),
    ('10101', 'Assistant commander of a military unit for financial and economic work or Financial support and economics of combat and economic activities'),
    ('101001', 'Commander of engineer-sapper unit or combat use of engineer-sapper units and formations'),
    ('101002', 'Combat use of engineering barrier and obstruction units and military units'),
    ('101004', 'Use of engineering and camouflage units and military units'),
    ('10200', 'Field bank organization worker for emission-cash, accounting-operational, credit work, and foreign currency operations or similar work'),
    ('10201', 'Operation and repair of radiation and chemical reconnaissance means'),
    ('10203', 'Operation and repair of chemical protection and special treatment troops'),
    ('103061', 'Hand-held anti-tank grenade launcher gunner'),
    ('104182', 'Commander of MANPADS unit Igla'),
    ('106147', 'Commander of reconnaissance unit'),
    ('106182', 'Reconnaissance unit commander'),
    ('106097', 'Deputy commander of reconnaissance unit'),
    ('106646', 'Reconnaissance scout'),
    ('107654', 'Diver-scout of special purpose units reconnaissance'),
    ('107746', 'Senior instructor in tactical and special training of special purpose units'),
    ('107847', 'Senior scout of special purpose military units'),
    ('111000', 'Use of units, military units, and formations of CBRN defense'),
    ('113194', 'Medium tank specialist — tank commander'),
    ('121000', 'Use of communication units, military units, and formations'),
    ('121100', 'Use of aviation communication units and parts and RTA'),
    ('121202', 'Use of units and military units with radio devices and medium-power radio stations'),
    ('121203', 'Use of units with low-power radio stations'),
    ('121301', 'Use of units and military units with multi-channel radio relay communication means'),
    ('121282', 'BMP-1 operator-gunner'),
    ('121400', 'Use of units and military units with low-channel radio relay and tropospheric communication means'),
    ('121702', 'Use of units and military units for operating long-distance communication means and cross devices'),
    ('122144', 'Commander of BMP platoon');

-- Inserting data into military_building_table
INSERT INTO military_building_table (can_use_for_dislocation, type_of_building, area_of_building, amount_of_rooms) VALUES
   (false, 'Administrative Facilities', 500, 20),
   (true, 'Ammunition Storage Facilities', 1000, 50),
   (true, 'Commissary Facilities', 300, 15),
   (true, 'Correctional Facilities', 200, 10),
   (true, 'Fortifications', 800, 30),
   (true, 'Hospitals', 1500, 100),
   (true, 'Housing', 1200, 60),
   (true, 'Containers,crates', 400, 10),
   (true, 'Military Intelligence Facilities', 600, 25),
   (true, 'POL (Petroleum, Oils, & Lubricants) Storage and Handling Facilities', 1000, 40),
   (true, 'Recreation Facilities', 900, 35),
   (true, 'Research Facilities', 700, 25),
   (false, 'Training Facilities', 800, 30),
   (true, 'Utility Structures', 500, 20),
   (true, 'Vehicle Repair, Maintenance, & Storage Facilities', 1000, 50),
   (true, 'Weapons and Ammunition Production Facilities', 1200, 60);


-- Inserting data into combat_equipment_table
INSERT INTO combat_equipment_table (name_of_equipment, experience_of_using, condition_of_vehicle, number_of_seats, name_of_vehicle) VALUES
    ('Tank', 5, 'Good', 4, 'T-72'),
    ('Anti-Tank Guided Missile Launcher', 6, 'Good', 0, 'FGM-148 Javelin'),
    ('Infantry Fighting Vehicle', 4, 'Fair', 9, 'Bradley Fighting Vehicle'),
    ('Helicopter', 7, 'Good', 6, 'AH-64 Apache'),
    ('Jet Fighter', 9, 'Excellent', 1, 'F-16 Fighting Falcon'),
    ('Unmanned Aerial Vehicle (UAV)', 2, 'Poor', 0, 'MQ-9 Reaper'),
    ('Artillery Rocket System', 6, 'Good', 0, 'M270 Multiple Launch Rocket System'),
    ('Submarine', 8, 'Excellent', 30, 'Los Angeles-class submarine'),
    ('Destroyer', 9, 'Excellent', 300, 'Arleigh Burke-class destroyer'),
    ('Aircraft Carrier', 10, 'Excellent', 5000, 'Nimitz-class aircraft carrier'),
    ('Attack Helicopter', 7, 'Good', 2, 'AH-1 Cobra'),
    ('Transport Helicopter', 5, 'Fair', 12, 'CH-47 Chinook'),
    ('Main Battle Tank', 8, 'Excellent', 4, 'Abrams M1A2'),
    ('Infantry Fighting Vehicle', 5, 'Good', 9, 'BMP-3'),
    ('Main Battle Tank', 9, 'Excellent', 4, 'Leopard 2'),
    ('Helicopter', 6, 'Good', 6, 'UH-60 Black Hawk'),
    ('Main Battle Tank', 7, 'Fair', 4, 'Challenger 2'),
    ('Infantry Fighting Vehicle', 4, 'Fair', 8, 'CV90'),
    ('Helicopter', 8, 'Excellent', 4, 'AH-1Z Viper'),
    ('Main Battle Tank', 6, 'Good', 3, 'T-90'),
    ('Infantry Fighting Vehicle', 8, 'Excellent', 8, 'Warrior'),
    ('Helicopter', 7, 'Good', 6, 'Mi-24 Hind'),
    ('Main Battle Tank', 5, 'Fair', 4, 'Type 99'),
    ('Infantry Fighting Vehicle', 9, 'Excellent', 7, 'Puma IFV'),
    ('Helicopter', 8, 'Excellent', 8, 'Boeing AH-64 Apache'),
    ('Main Battle Tank', 7, 'Good', 4, 'K2 Black Panther'),
    ('Infantry Fighting Vehicle', 6, 'Good', 10, 'BMD-4'),
    ('Helicopter', 8, 'Excellent', 8, 'Eurocopter Tiger');

-- Inserting data into the soldier_table
 INSERT INTO soldier_table (first_name, last_name, date_of_birth, military_card, date_of_issue_of_military_card, mas_id, soldier_type_id, is_commander)
VALUES
    ('John', 'Doe', '1990-05-15', 'ABC123', '2020-01-01', 1, 1, false),
    ('Jane', 'Smith', '1995-08-20', 'XYZ789', '2020-02-15', 2, 2, false),
    ('Michael', 'Johnson', '1988-11-10', 'DEF456', '2020-03-20', 1, 3, false),
    ('Emily', 'Williams', '1992-04-25', 'GHI789', '2020-04-30', 3, 4, false),
    ('Christopher', 'Brown', '1985-09-05', 'JKL012', '2020-05-10', 2, 5, false),
    ('Amanda', 'Davis', '1993-07-12', 'MNO345', '2020-06-20', 3, 6, false),
    ('Robert', 'Martinez', '1991-02-28', 'PQR678', '2020-07-25', 1, 7, false),
    ('Jennifer', 'Rodriguez', '1987-06-18', 'STU901', '2020-08-05', 2, 8, false),
    ('William', 'Hernandez', '1983-12-08', 'VWX234', '2020-09-15', 3, 9, false),
    ('Sarah', 'Garcia', '1990-03-22', 'YZA567', '2020-10-20', 1, 10, false);


-- Inserting data into the subdivision_table
INSERT INTO subdivision_table (name_of_subdivision, number_of_subdivision, dislocated, commander_id, type_of_subdivision_id)
VALUES
    ('Alpha Squad', 1, false, 1, 5),
    ('Bravo Platoon', 2, true, 2, 2),
    ('Charlie Krasniy', 3, false, 3, 3);

INSERT INTO subdivision_table (name_of_subdivision, number_of_subdivision, dislocated, commander_id, type_of_subdivision_id)
VALUES
    ('best team', 23, true, 7, 1);