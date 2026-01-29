DELETE SCHEMA IF EXISTS dat109_o1 CASCADE;

CREATE SCHEMA dat109_o1;
SET search_path TO dat109_o1;

CREATE TABLE typer(
    id INT PRIMARY KEY,
    navn VARCHAR(15) UNIQUE);

CREATE TABLE ruter(
    ruteID INT PRIMARY KEY,
    type INT NOT NULL DEFAULT 1
    FOREIGN KEY (type) REFERENCES typer(id));

CREATE TABLE flytt(
    start INT,
    slutt INT,
    type INT NOT NULL DEFAULT 8,
    PRIMARY KEY (start, slutt),
    FOREIGN KEY (start) REFERENCES ruter(ruteID),
    FOREIGN KEY (slutt) REFERENCES ruter(ruteID),
    FOREIGN KEY (type) REFERENCES typer(id)
    );

INSERT INTO type
VALUES(1,'vanlig'),
(2,'start'),
(3,'fengsel'),
(4,'maal'),
(5,'flytt_start'),
(6,'flytt_slutt'),
(7,'slange'),
(8,'stige');

INSERT INTO ruter
VALUES(0, 3),
(1,2),
(100,4);

INSERT INTO ruter(ruteID)
SELECT value
FROM GENERATE_SERIES(2,99);

INSERT INTO flytt(start,slutt)
VALUES(3,10),
(55,72),
(44,65);

INSERT INTO flytt
VALUES(99,1,7),
(56,43,7),
(70,65,7);