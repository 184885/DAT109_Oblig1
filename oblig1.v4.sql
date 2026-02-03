DROP SCHEMA IF EXISTS dat109_o1 CASCADE;

CREATE SCHEMA dat109_o1;
SET search_path TO dat109_o1;

CREATE TABLE brett(
  id SERIAL PRIMARY KEY,
  navn  VARCHAR(15) UNIQUE
);

CREATE TABLE dtype(
    id INT PRIMARY KEY,
    navn VARCHAR(15) UNIQUE);

CREATE TABLE rute(
    ruteID INT PRIMARY KEY,
    brettID INT NOT NULL DEFAULT 1,
    rute_type INT NOT NULL DEFAULT 1,
    FOREIGN KEY (brettID) REFERENCES brett(id),
    FOREIGN KEY (rute_type) REFERENCES dtype(id));

INSERT INTO brett
VALUES(1, 'hovudbrett');

INSERT INTO dtype
VALUES(1,'vanlig'),
(2,'start'),
(3,'maal');

INSERT INTO rute(ruteID, rute_type)
VALUES(1,2),
(100,3);

INSERT INTO rute(ruteID)
SELECT *
FROM GENERATE_SERIES(2,99);


