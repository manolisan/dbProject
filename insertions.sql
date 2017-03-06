START TRANSACTION;
USE Prescriptions_R_X;

INSERT INTO DOCTOR(FirstName, LastName, Speciality, ExperianceYears)
VALUES
('Nikos', 'Nikolas', 'Cardiology', 10),
('Mitsos', 'Mitsakos', 'Opthalmology', 15),
('Mitsos', 'Mitsaras', 'Surgery', 35),
('Takis', 'Takopoulos', 'Nervology', 7),
('Kwstas', 'Kwnstantinou', 'Nervology' ,11),
('Giannis', 'Giannaros', 'Gynecologist' ,30),
('Maria', 'Maraki-Mario', 'Obstetrics' ,10),
('Xara', 'Xaroula', 'Cardiolody' ,20),
('Anastasia', 'Sia', 'Dermatology' ,23),
('Euagelia', 'Lia', 'Dermatology' ,27);

/* Add more patients. 30 in total! */
INSERT INTO PATIENT(FirstName, LastName, Town, StreetName, Number, PostalCode, Age, DoctorId)
VALUES
('Giannis', 'Giannaros', 'Athens', 'Ermoy', 23, 15772, 18, 1),
('Manolis', 'Anastasiou', 'Zografou', 'Papagou', 17, 15773, 21, 2),
('Startis', 'Tsirtsis', 'Zografou', 'Kousidou', 42, 15773, 21, 3),
('Rafaela', 'Katara', 'Athens', 'Karagiwrgh', 50, 15432, 21, 1),
('Nikolakis' ,'Familia', 'Athens', 'Solwnos', 117, 18902, 5, 4),
('Maraki' ,'Familia', 'Athens', 'Solwnos', 117, 18902, 6, 4),
('Giwrgakis' ,'Familia', 'Athens', 'Solwnos', 117, 18902, 5, 4),
('Iwannis' ,'Familia', 'Athens', 'Solwnos', 117, 18902, 34, 4),
('Ariadni', 'Familia', 'Athens', 'Solwnos', 117, 18902, 33, 4),
('Count', 'Dracula', 'Transylvania', 'Castle', 1, 6666, 66, 6),
('Tade', 'Tadopoulos', 'Space', 'Mars', 99, 9999, 100, 5),
('Giorgos', 'Giorgakis', 'Thessaloniki', 'Tsimiski', 107, 18378, 40, 3),
('Kwstas', 'Kwstakis' , 'Thessaloniki', 'Aristotelous' , 15, 18375, 37, 2),
('Marialena', 'Lena', 'Athens' , 'Praksitelous' , 17, 15732, 19, 1),
('Kwnstantina', 'Ntina', 'Patra', 'Riga Fereou', 87, 826783, 56, 2),
('Kwnstantinos', 'Ntinos', 'Patra', 'Riga Fereou', 87, 826783, 54, 2),
('Ilias', 'Kinezos', 'Zografou', 'Hrwwn Polytexneio', 78, 15772, 21, 5),
('Ilias', 'Liakos', 'Petroupoli', 'Diakrias', 56, 18356, 21, 5),
('Pavlos', 'Pavlidis', 'Athens', 'Kolokotrwni', 65, 15732, 28, 1),
('Timos', 'Timotheos', 'Zografou', 'Grigoriou Auksediou', 114, 15773, 20, 1);

/* Add more pharmacy */
INSERT INTO PHARMACY(Name, Town, StreetName, Number, PostalCode, PhoneNumber)
VALUES
('Drugstore', 'Athens', 'Papanikola', 13, 14234, 904),
('Coffeshop', 'Amsterdam', 'RedLightStreet' , 17 , 13244, 5435),
('ZografosPharmacy', 'Zografou', 'Papagou', 42 , 15773, 89572),
('PhanouriosPharmacy', 'Athens', 'Agiou Phanouriou', 105 , 13911, 17203),
('ReliefEstablisher' , 'Athens', 'Ermou', 120, 14235, 210301),
('RelaxedPharmacy', 'Thessaloniki', 'Tsimiski', 14, 18378,2403981);

INSERT INTO PHARMACEUTICALCOMPANY(Name, PhoneNumber)
VALUES
('DrugColosseum', 2104837),
('DrugProducer', 2104583),
('DrugSupplier', 2104837),
('ReliefProducer' , 210543),
('ΕuphoriaInductor', 21048327);


/* Add more drugs */
INSERT INTO DRUG(Name, Formula, PharmaceuticalCompanyId)
VALUES
('Depon', '15cc', 5),
('Panadol', '10cc', 5),
('Ponstan', '7cc', 3),
('Cilroton', '20cc', 3),
('Lasix', '34cc', 1),
('Tobrex', '34cc', 5),
('Augmentin', '13cc', 4),
('Betafusin', '21cc', 2),
('Tobradex', '8cc', 3),
('Mensulid', '43cc', 2),
('Lobivon', '9cc', 2);

INSERT INTO PRESCRIPTION(Date, Quantity, DoctorId, PatientId, DrugId)
VALUES
(DATE '2017-04-28', 5, 1, 1, 1),
(DATE '2017-03-15', 4, 1, 1, 2),
(DATE '2017-01-01', 3, 2, 3, 3),
(DATE '2017-01-07', 3, 3, 3, 2),
(DATE '2017-01-03', 1, 5, 3, 6),
(DATE '2017-01-10', 8, 5, 10, 8),
(DATE '2017-01-08', 3, 5, 10, 5),
(DATE '2017-01-08', 3, 2, 9, 2),
(DATE '2017-01-11', 4, 2, 8, 2),
(DATE '2017-01-15', 4, 2, 8, 4),
(DATE '2017-01-15', 4, 1, 4, 4),
(DATE '2017-01-15', 4, 1, 4, 1),
(DATE '2017-01-14', 2, 4, 7, 4),
(DATE '2017-01-14', 1, 2, 4, 4),
(DATE '2017-01-20', 5, 7, 2, 2),
(DATE '2017-01-23', 3, 1, 8, 2),
(DATE '2017-01-28', 1, 2, 2, 3);


/* Add much more rows in sell! */
INSERT INTO SELL(Price, PharmacyId, DrugId)
VALUES
(10, 1, 2),
(5, 1, 1);

/* Add more contracts.*/
INSERT INTO CONTRACT(StartDate, EndDate, Text, Supervisor, PharmacyId, PharmaceuticalCompanyId)
VALUES
(DATE '2000-01-29', DATE '2030-01-29', 'symfwnitiko synegasias', 'Mhtsaras', 1, 1),
(DATE '1997-08-15', DATE '2027-08-15', 'symvolaio me times', 'Nikolas',2 , 1);

COMMIT;
