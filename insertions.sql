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





INSERT INTO PATIENT(FirstName, LastName, Town, StreetName, Number, PostalCode, Age, DoctorId)
VALUES
('Giannis', 'Giannaros', 'Athens', 'Ermoy', 23, 15772, 18, 1),
('Manolis', 'Anastasiou', 'Zografou', 'Papagou', 17, 15773, 21, 2),
('Startis', 'Tsirtsis', 'Zografou', 'Kousidou', 42, 15773, 21, 3),
('Rafaela', 'Katara', 'Athens', 'Karagiwrgh', 50, 15432, 21, 1),
('Nikolakis' 'Familia', 'Athens', 'Solwnos', 117, 18902, 5, 4),
('Maraki' 'Familia', 'Athens', 'Solwnos', 117, 18902, 6, 4),
('Giwrgakis' 'Familia', 'Athens', 'Solwnos', 117, 18902, 5, 4),
('Iwannis' 'Familia', 'Athens', 'Solwnos', 117, 18902, 34, 4),
('Ariadni' 'Familia', 'Athens', 'Solwnos', 117, 18902, 33, 4),
('Count', 'Dracula', 'Transylvania', 'Castle', 1, 6666, 66, 6),
('Tade', 'Tadopoulos', 'Space', 'Mars', 99, 9999, 100, 5),

INSERT INTO PHARMACY(Name, Town, StreetName, Number, PostalCode, PhoneNumber)
VALUES
('Drugstore', 'Athens', 'Papanikola', 13, 14234, 904),
('Coffeshop', 'Amsterdam', 'RedLightStreet' , 17 , 13244, 5435),
('ZografosPharmacy', 'Zografou', 'Papagou', 42 , 15773, 89572),
('PhanouriosPharmacy', 'Athens', 'Agiou Phanouriou', 105 , 13911, 17203);

INSERT INTO PHARMACEUTICALCOMPANY(Name, PhoneNumber)
VALUES
('DrugColosseum', 2104837),
('DrugProducer', 2104583),
('DrugSupplier', 2104837),
('ReliefProducer' , 210543),
('ΕuphoriaInductor', 21048327);



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
(DATE '2017-04-28', 5, 1 , 1, 1),
(DATE '2017-03-15', 4, 1 , 1, 2);


INSERT INTO SELL(Price, PharmacyId, DrugId)
VALUES
(10, 1, 2),
(5, 1, 1);

INSERT INTO CONTRACT(StartDate, EndDate, Text, Supervisor, PharmacyId, PharmaceuticalCompanyId)
VALUES
(DATE '2000-01-29', DATE '2030-01-29', 'symfwnitiko synegasias', 'Mhtsaras', 1, 1),
(DATE '1997-08-15', DATE '2027-08-15', 'symvolaio me times', 'Nikolas',2 , 1);

COMMIT;
