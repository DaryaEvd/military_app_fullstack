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

INSERT INTO subdivision_type(name_of_type, subdivision_rank)
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
    ('043203', 'Combat use of starting units of multi-channel medium-range air defense systems'),
    ('06008', 'Technical personnel'),
    ('062600', 'Flight personnel'),
    ('072301', 'Navigator of diesel submarines'),
    ('08600', 'Organization of humanitarian training'),
    ('093500', 'Psychological warfare officer (with knowledge of a foreign language)'),
    ('106147', 'Commander of reconnaissance unit'),
    ('106182', 'Reconnaissance unit commander'),
    ('106097', 'Deputy commander of reconnaissance unit'),
    ('106646', 'Reconnaissance scout');


-- Inserting data into the subdivision_table
INSERT INTO subdivision_table (name_of_subdivision, number_of_subdivision, dislocated, type_of_subdivision_id)
VALUES
    ('Alpha Squad', 1, false,  5),
    ('Bravo Platoon', 2, true,   2),
    ('best team', 23, true,  1),
    ('vzvod by Pirogov', 234, true, 4),
    ('best team', 23, true,  1),
    ('bbeveest team', 654, false,  3),
    ('pupupu Krasniy', 3, false, 3);


INSERT INTO soldier_table (first_name, last_name, date_of_birth, military_card, date_of_issue_of_military_card, mas_id, soldier_type_id, subdivision_id, is_commander)
VALUES
    ('Seva', 'Nosov', '1980-05-15', 'hahaha123', '2010-01-01', 3, (SELECT id FROM soldier_type WHERE type_rank = 0 LIMIT 1), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Platoon' LIMIT 1), false),
    ('kirill', 'kirillov', '1980-03-22', 'YZAdgfd567', '2010-10-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 0 LIMIT 1), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Squad' LIMIT 1), false),
    ('Jane', 'Smith', '1995-08-20', 'XYZ789', '2020-02-15', 2, (SELECT id FROM soldier_type WHERE type_rank = 2), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Rota' LIMIT 1), false),
    ('Michael', 'Johnson', '1988-11-10', 'DEF456', '2020-03-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 3), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Military Unit' LIMIT 1), false),
    ('Emily', 'Williams', '1992-04-25', 'GHI789', '2020-04-30', 3, (SELECT id FROM soldier_type WHERE type_rank = 4), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Corps' LIMIT 1), false),
    ('Christopher', 'Brown', '1985-09-05', 'JKL012', '2020-05-10', 2, (SELECT id FROM soldier_type WHERE type_rank = 5), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Brigade' LIMIT 1), false),
    ('Amanda', 'Davis', '1993-07-12', 'MNO345', '2020-06-20', 3, (SELECT id FROM soldier_type WHERE type_rank = 6), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Division' LIMIT 1), false),
    ('Robert', 'Martinez', '1991-02-28', 'PQR678', '2020-07-25', 1, (SELECT id FROM soldier_type WHERE type_rank = 7), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Army' LIMIT 1), false),
    ('Jennifer', 'Rodriguez', '1987-06-18', 'STU901', '2020-08-05', 2, (SELECT id FROM soldier_type WHERE type_rank = 8), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Corps' LIMIT 1), false),
    ('William', 'Hernandez', '1983-12-08', 'VWX234', '2020-09-15', 3, (SELECT id FROM soldier_type WHERE type_rank = 9), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Brigade' LIMIT 1), false),
    ('Sarah', 'Garcia', '1990-03-22', 'YZA567', '2020-10-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 10), (SELECT id FROM subdivision_table WHERE name_of_subdivision = 'Brigade' LIMIT 1), false);

-- Inserting data into the soldier_table
-- INSERT INTO soldier_table (first_name, last_name, date_of_birth, military_card, date_of_issue_of_military_card, mas_id, soldier_type_id, subdivision_id, is_commander)
-- VALUES
--     ('Seva', 'Nosov', '1980-05-15', 'hahaha123', '2010-01-01', 3, (SELECT id FROM soldier_type WHERE type_rank = 0), (SELECT id FROM subdivision_type WHERE subdivision_rank = 2), false),
--     -- Insert other rows here
--     ('kirill', 'kirillov', '1980-03-22', 'YZAdgfd567', '2010-10-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 0), (SELECT id FROM subdivision_type WHERE subdivision_rank = 0), false);
--
-- INSERT INTO soldier_table (first_name, last_name, date_of_birth, military_card, date_of_issue_of_military_card, mas_id, soldier_type_id, subdivision_id, is_commander)
-- VALUES
--     ('Seva', 'Nosov', '1980-05-15', 'hahaha123', '2010-01-01', 3, (SELECT id FROM soldier_type WHERE type_rank = 0), 2, false),
--     ('John', 'Doe', '1990-05-15', 'ABC123', '2020-01-01', 1, (SELECT id FROM soldier_type WHERE type_rank = 1), 2, false),
--     ('Jane', 'Smith', '1995-08-20', 'XYZ789', '2020-02-15', 2, (SELECT id FROM soldier_type WHERE type_rank = 2), 7, false),
--     ('Michael', 'Johnson', '1988-11-10', 'DEF456', '2020-03-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 3), 2, false),
--     ('Emily', 'Williams', '1992-04-25', 'GHI789', '2020-04-30', 3, (SELECT id FROM soldier_type WHERE type_rank = 4), 5, false),
--     ('Christopher', 'Brown', '1985-09-05', 'JKL012', '2020-05-10', 2, (SELECT id FROM soldier_type WHERE type_rank = 5), 4, false),
--     ('Amanda', 'Davis', '1993-07-12', 'MNO345', '2020-06-20', 3, (SELECT id FROM soldier_type WHERE type_rank = 6), 5, false),
--     ('Robert', 'Martinez', '1991-02-28', 'PQR678', '2020-07-25', 1, (SELECT id FROM soldier_type WHERE type_rank = 7), 5, false),
--     ('Jennifer', 'Rodriguez', '1987-06-18', 'STU901', '2020-08-05', 2, (SELECT id FROM soldier_type WHERE type_rank = 8), 6, false),
--     ('William', 'Hernandez', '1983-12-08', 'VWX234', '2020-09-15', 3, (SELECT id FROM soldier_type WHERE type_rank = 9), 2, false),
--     ('Sarah', 'Garcia', '1990-03-22', 'YZA567', '2020-10-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 10), 1, false),
--     ('kirill', 'kirillov', '1980-03-22', 'YZAdgfd567', '2010-10-20', 1, (SELECT id FROM soldier_type WHERE type_rank = 0), 0, false);

-- Inserting data into combat_equipment_table
INSERT INTO combat_equipment_table (name_of_equipment, experience_of_using, condition_of_vehicle, number_of_seats, name_of_vehicle, subdivision_id)
VALUES
  ('Anti-Tank Guided Missile Launcher', 6, 'Good', 0, 'FGM-148 Javelin', 1),
  ('Infantry Fighting Vehicle', 4, 'Fair', 9, 'Bradley Fighting Vehicle', 5),
  ('Helicopter', 7, 'Good', 6, 'AH-64 Apache', 3),
  ('Jet Fighter', 9, 'Excellent', 1, 'F-16 Fighting Falcon', 3),
  ('Unmanned Aerial Vehicle (UAV)', 2, 'Poor', 0, 'MQ-9 Reaper', 2),
  ('Artillery Rocket System', 6, 'Good', 0, 'M270 Multiple Launch Rocket System', 1),
  ('Submarine', 8, 'Excellent', 30, 'Los Angeles-class submarine', 4),
  ('Destroyer', 9, 'Excellent', 300, 'Arleigh Burke-class destroyer', 5),
  ('Aircraft Carrier', 10, 'Excellent', 5000, 'Nimitz-class aircraft carrier', 2),
  ('Attack Helicopter', 7, 'Good', 2, 'AH-1 Cobra', 1 ),
  ('Transport Helicopter', 5, 'Fair', 12, 'CH-47 Chinook', 4),
  ('Main Battle Tank', 8, 'Excellent', 4, 'Abrams M1A2', 3),
  ('Infantry Fighting Vehicle', 5, 'Good', 9, 'BMP-3', 4),
  ('Main Battle Tank', 9, 'Excellent', 4, 'Leopard 2', 2),
  ('Helicopter', 6, 'Good', 6, 'UH-60 Black Hawk', 4),
  ('Main Battle Tank', 7, 'Fair', 4, 'Challenger 2', 5),
  ('Infantry Fighting Vehicle', 4, 'Fair', 8, 'CV90', 3),
  ('Helicopter', 8, 'Excellent', 4, 'AH-1Z Viper', 2),
  ('Main Battle Tank', 6, 'Good', 3, 'T-90', 1),
  ('Infantry Fighting Vehicle', 8, 'Excellent', 8, 'Warrior', 2),
  ('Helicopter', 7, 'Good', 6, 'Mi-24 Hind', 4),
  ('Main Battle Tank', 5, 'Fair', 4, 'Type 99', 3),
  ('Infantry Fighting Vehicle', 9, 'Excellent', 7, 'Puma IFV', 5),
  ('Helicopter', 8, 'Excellent', 8, 'Boeing AH-64 Apache', 1),
  ('Main Battle Tank', 7, 'Good', 4, 'K2 Black Panther', 6),
  ('Infantry Fighting Vehicle', 6, 'Good', 10, 'BMD-4', 5),
  ('Helicopter', 8, 'Excellent', 8, 'Eurocopter Tiger', 2);


