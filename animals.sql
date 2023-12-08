
CREATE DATABASE IF NOT EXISTS `human_friends`;
USE human_friends;
CREATE TABLE Pets (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);

CREATE TABLE Pack_animals (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);

INSERT INTO Pets (name, command, birth_date) VALUES ('Собака1', 'Команда1','2022-01-01');
INSERT INTO Pets (name, command, birth_date) VALUES ('Кошка1', 'Команда2', '2022-02-01');
INSERT INTO Pack_animals (name, command, birth_date) VALUES ('Лошадь1', 'Команда3', '2022-03-01');
INSERT INTO Pack_animals (name, command, birth_date) VALUES ('Верблюд1', 'Команда4', '2022-04-01');
INSERT INTO Pack_animals (name, command, birth_date) VALUES ('Осел1', 'Команда5', '2022-05-01');
DELETE FROM Pack_animals WHERE id = 2;
CREATE TABLE Common AS SELECT * FROM Pets UNION SELECT * FROM Pack_animals;
CREATE TABLE Young AS SELECT * FROM Common WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) BETWEEN 1 AND 3;
CREATE TABLE All_animals AS SELECT * FROM Pets UNION SELECT * FROM Pack_animals;
