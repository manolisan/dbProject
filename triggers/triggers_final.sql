DELIMITER //

CREATE TRIGGER Unexperienced_doctor
BEFORE INSERT ON DOCTOR            
FOR EACH ROW
BEGIN
	IF NEW.ExperianceYears < 5 THEN SET NEW.Speciality = 'Unexperienced' ; END IF;
END //

delimiter ;


DELIMITER //

CREATE TRIGGER Check_doctor_experience
BEFORE UPDATE ON DOCTOR            
FOR EACH ROW
BEGIN
	IF NEW.ExperianceYears < 5 THEN SET NEW.Speciality = 'Unexperienced' ; END IF;
END //

delimiter ;


DELIMITER //

CREATE TRIGGER Drugs_limit
BEFORE INSERT ON DRUG 
FOR EACH ROW 
BEGIN 
	IF (select COUNT(*) from DRUG) >= 20 THEN 
	SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Prescription_R_X doesn't accept more than 20 different drugs!!! ";
    END IF;

END //

delimiter ;
    
/* Dystuxws den vgainei to parakatw. Thelei procedure


 Den petame ta palia farmaka prin eksantlithoun! Oikonomiaaaa! Ta diagrafoume otan poulhthoun! 
	Oxi otan aplws vgei kainourgio.. 
    
    
CREATE TRIGGER Reserve_old_drug_storage
BEFORE UPDATE ON DRUG            
FOR EACH ROW
INSERT INTO DRUG(Name, Formula, PharmaceuticalCompanyId)
VALUES
(OLD.NAME, OLD.Formula, OLD.PharmaceuticalCompanyId);
*/
