USE Prescriptions_R_X;

INSERT INTO DOCTOR
VALUES
(1, 'Nikos', 'Nikolas', 'Cardiology', 10);

INSERT INTO PATIENT
VALUES
(1, 'Takis', 'Takopoulos', 'Athens', 'Ermoy', 23, 15772, 18, 1);

INSERT INTO PHARMACY
VALUES
(1, 'Drugstore', 'Athens', 'Papanikola', 13, 14234, 904),
(2, 'Coffeshop', 'Amsterdam', 'RedLightStreet' , 17 , 13244, 5435);

INSERT INTO PHARMACEUTICALCOMPANY
VALUES
(1, 'CompanyName', 21019843),
(2, 'CompetitiveCompany', 342423);


INSERT INTO DRUG
VALUES
(1, 'Depon', '15cc', 1),
(2, 'Panadol', '10cc', 2);

INSERT INTO PRESCRIPTION
VALUES
(DATE '2017-04-28', 5, 1 , 1, 1),
(DATE '2017-03-15', 4, 1 , 1, 2);


INSERT INTO SELL
VALUES
(10, 1, 2),
(5, 1, 1);

INSERT INTO CONTRACT
VALUES
(DATE '2000-01-29', DATE '2030-01-29', 'symfwnitiko synegasias', 'Mhtsaras', 1, 1),
(DATE '1997-08-15', DATE '2027-08-15', 'symvolaio me times', 'Nikolas',2 , 1);
