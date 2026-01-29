DELETE SCHEMA IF EXISTS dat109_o1 CASCADE;

CREATE SCHEMA dat109_o1;
SET search_path TO dat109_o1;

CREATE TABLE rute(
ruteID INTEGER PRIMARY KEY,
navn VARCHAR(10)
);

CREATE TABLE slange(
start INTEGER,
slutt INTEGER,
PRIMARY KEY (start, slutt),
FOREIGN KEY (start) REFERENCES rute(ruteID),
FOREIGN KEY (slutt) REFERENCES rute(ruteID));

CREATE TABLE stige(
start INTEGER,
slutt INTEGER,
PRIMARY KEY (start, slutt),
FOREIGN KEY (start) REFERENCES rute(ruteID),
FOREIGN KEY (slutt) REFERENCES TO rute(ruteID));

INSERT INTO rute
VALUES(0, 'fengsel'),(1,'start'),(100,'maal');

INSERT INTO rute(ruteID)
SELECT value FROM GENERATE_SERIES(2,99);
