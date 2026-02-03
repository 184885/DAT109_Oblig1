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
    brettID INT NOT NULL,
    rute_type INT NOT NULL DEFAULT 1,
    FOREIGN KEY (brettID) REFERENCESbrett(id) DEFAULT 1,
    FOREIGN KEY (rute_type) REFERENCES dtype(id));

CREATE TABLE flytt(
    start INT PRIMARY KEY,
    slutt INT NOT NULL,
    flytt_type INT NOT NULL DEFAULT 8,
    FOREIGN KEY (start) REFERENCES rute(ruteID),
    FOREIGN KEY (slutt) REFERENCES rute(ruteID),
    FOREIGN KEY (flytt_type) REFERENCES dtype(id)
    );

INSERT INTO brettID
VALUES(1,'hovudbrett');

INSERT INTO dtype
VALUES(1,'vanlig'),
(2,'start'),
(3,'fengsel'),
(4,'maal'),
(5,'flytt_start'),
(6,'flytt_slutt'),
(7,'slange'),
(8,'stige');

INSERT INTO rute(ruteID, rute_type)
VALUES(0, 3),
(1,2),
(100,4);

INSERT INTO rute(ruteID)
SELECT *
FROM GENERATE_SERIES(2,99);

INSERT INTO flytt(start,slutt)
VALUES(3,10),
(55,72),
(44,65);

INSERT INTO flytt
VALUES(99,1,7),
(56,43,7),
(70,65,7);

UPDATE rute
SET rute_type = 5
WHERE rute.ruteID IN 
(SELECT flytt.start FROM flytt);

UPDATE rute
SET rute_type = 6
WHERE rute.ruteID IN 
(SELECT flytt.slutt FROM flytt);
