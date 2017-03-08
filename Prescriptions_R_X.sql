DROP DATABASE IF EXISTS Prescriptions_R_X;
CREATE DATABASE Prescriptions_R_X;
USE Prescriptions_R_X;


CREATE TABLE DOCTOR (

DoctorId   		 INT UNSIGNED NOT NULL AUTO_INCREMENT,
FirstName   	 VARCHAR(45) NOT NULL,
LastName    	 VARCHAR(45) NOT NULL,
Speciality  	 VARCHAR(45) NOT NULL,
ExperianceYears  INT UNSIGNED NOT NULL CHECK(ExperianceYears>=0),
UNIQUE KEY (DoctorId),
PRIMARY KEY (DoctorId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE PATIENT (

PatientId   INT UNSIGNED NOT NULL AUTO_INCREMENT,
FirstName   VARCHAR(15) NOT NULL,
LastName    VARCHAR(15) NOT NULL,
Town        VARCHAR(20) NOT NULL,
StreetName  VARCHAR(45) NOT NULL,
Number		INT UNSIGNED NOT NULL,
PostalCode  INT UNSIGNED NOT NULL,
Age         INT UNSIGNED NOT NULL CHECK(AGE>0),
DoctorId   	INT UNSIGNED NOT NULL,
UNIQUE KEY  (PatientId),
PRIMARY KEY (PatientId),
FOREIGN KEY (DoctorId) REFERENCES DOCTOR (DoctorID) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE PHARMACY (

PharmacyId   	 TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
Name  		   	 VARCHAR(20) NOT NULL,
Town		   	 VARCHAR(15) NOT NULL,
StreetName		 VARCHAR(20) NOT NULL,
Number			 INT UNSIGNED NOT NULL,
PostalCode  	 INT UNSIGNED NOT NULL,
PhoneNumber      INT UNSIGNED NOT NULL,
UNIQUE KEY  	 (PharmacyId),
PRIMARY KEY 	 (PharmacyId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE PHARMACEUTICALCOMPANY (

PharmaceuticalCompanyId  TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
Name		 	VARCHAR(45) NOT NULL,
PhoneNumber  	INT UNSIGNED NOT NULL,
UNIQUE KEY  (PharmaceuticalCompanyId),
PRIMARY KEY (PharmaceuticalCompanyId) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE DRUG (

DrugId   	INT UNSIGNED NOT NULL AUTO_INCREMENT,
Name		VARCHAR(15) NOT NULL,
Formula		VARCHAR(15) NOT NULL,
PharmaceuticalCompanyId  TINYINT UNSIGNED NOT NULL,
FOREIGN KEY (PharmaceuticalCompanyId) REFERENCES PHARMACEUTICALCOMPANY (PharmaceuticalCompanyId)  ON DELETE CASCADE ON UPDATE CASCADE,
UNIQUE KEY  (DrugId),
PRIMARY KEY (DrugId),
 UNIQUE		(Name)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE PRESCRIPTION (

Date	   DATETIME NOT NULL,
Quantity   INT UNSIGNED NOT NULL CHECK(Quantity>0),
DoctorId   	INT UNSIGNED NOT NULL ,
PatientId   INT UNSIGNED NOT NULL ,
DrugId   	INT UNSIGNED NOT NULL ,
UNIQUE KEY (DoctorId,PatientId,DrugId),
PRIMARY KEY (DoctorId,PatientId,DrugId),
FOREIGN KEY (DoctorId) REFERENCES DOCTOR (DoctorID)  ON DELETE CASCADE ON UPDATE CASCADE, 
FOREIGN KEY (PatientId) REFERENCES PATIENT (PatientId)  ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (DrugId) REFERENCES DRUG (DrugId)  ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 

 
CREATE TABLE SELL (

Price  		 INT UNSIGNED NOT NULL CHECK(Price>0),
PharmacyId   TINYINT UNSIGNED NOT NULL,
DrugId   	 INT UNSIGNED NOT NULL,
UNIQUE KEY (PharmacyId,DrugId),
PRIMARY KEY (PharmacyId,DrugId),
FOREIGN KEY (PharmacyId) REFERENCES PHARMACY (PharmacyId)  ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (DrugId) REFERENCES DRUG (DrugId)  ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE CONTRACT(

StartDate	DATETIME NOT NULL,
EndDate		DATETIME NOT NULL,
CHECK (start_date<end_date),
Text	  	TEXT,
Supervisor  VARCHAR(20) NOT NULL,
PharmacyId   TINYINT UNSIGNED NOT NULL,
PharmaceuticalCompanyId  TINYINT UNSIGNED NOT NULL,
UNIQUE KEY (PharmacyId,PharmaceuticalCompanyId),
PRIMARY KEY (PharmacyId,PharmaceuticalCompanyId),
FOREIGN KEY (PharmacyId) REFERENCES PHARMACY (PharmacyId)  ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (PharmaceuticalCompanyId) REFERENCES PHARMACEUTICALCOMPANY (PharmaceuticalCompanyId)  ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8; 
