-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP SCHEMA IF EXISTS sep3;
CREATE SCHEMA sep3;

USE sep3;

-- -- -- User Table -- -- --

DROP TABLE IF EXISTS Users CASCADE;
CREATE TABLE Users (
                       users_ID SERIAL,
                       manager_ID int NOT NULL,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       firstName VARCHAR(255) NOT NULL,
                       lastName VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL,
                       status VARCHAR(30),
                       accessLevel VARCHAR(255) NOT NULL,
                       dayEmployment int,
                       monthEmployment int,
                       yearEmployment int,
                       PRIMARY KEY (Users_ID)
);

-- Test purposes, can be deleted at anytime
INSERT INTO Users (username, manager_ID, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('admin', 0, '92668751', 'admin', 'admin', 'admin@gmail.com', 'ACTIVE', 'MANAGER', 16, 03, 2020  );

INSERT INTO Users (username, manager_ID, password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Anders', 3, '1509442', 'Anders', 'Sonderby', '264247@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, manager_ID,  password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('David', 1, '3556498', 'David', 'Nguyen', '251771@via.dk', 'Active', 'MANAGER', 16, 03, 2020  );

INSERT INTO Users (username, manager_ID,  password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Niklas', 3, '549190650', 'Niklas', 'Krogh', '281335@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

INSERT INTO Users (username, manager_ID,  password, firstName, lastName, email, status, accessLevel, dayEmployment, monthEmployment, yearEmployment)
    VALUE('Rokas', 3, '92668751', 'Rokas', 'Barasa', '285047@via.dk', 'ACTIVE', 'EMPLOYEE', 16, 03, 2020  );

SELECT * FROM Users;



-- Test end here...

SELECT Users_ID, username FROM Users WHERE username = 'Niklas';

SELECT username, password, accessLevel FROM Users
WHERE accessLevel = 'employee';

-- -- -- Shift Table -- -- --

DROP TABLE IF EXISTS Shift CASCADE;
CREATE TABLE Shift (
                        Shift_ID SERIAL,
                        Users_ID INTEGER REFERENCES Users(Users_ID),
                        Manager_ID INTEGER REFERENCES Users(Users_ID),
                        description VARCHAR(10000),
                        day int NOT NULL,
                        month int NOT NULL,
                        year int NOT NULL,
                        PRIMARY KEY(Shift_ID)

);

-- Test purposes, can be deleted at anytime

INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3, 'This is a shift description',   04, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (3, 3,'This is a shift description',   05, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (4, 3, 'This is a shift description',   06, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a shift description',   07, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3, 'This is a shift description',   08, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (3, 3,'This is a shift description',   11, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (4, 3, 'This is a shift description',   12, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (5, 3,'This is a shift description',   14, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (2, 3, 'This is a shift description',   13, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (3, 3,'This is a shift description',   29, 05, 2020);
INSERT INTO Shift (Users_ID, Manager_ID, description, day, month, year)
    VALUE (4, 3,'This is a shift description',   06, 05, 2020);

-- -- -- Update Shift Testing -- -- --

SELECT Users_ID, Manager_ID, description, day, month, year FROM Shift
WHERE Shift_ID = 11;

UPDATE Shift
SET
    description = 'does UPDATE work??',
    day = 01,
    month = 01,
    year = 2022
WHERE Shift_ID = 11;

-- -- -- End here -- -- --

SELECT * FROM Shift;
