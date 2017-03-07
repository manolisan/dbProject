CREATE TRIGGER Patients_delete
BEFORE DELETE ON PATIENT            
FOR EACH ROW                        
  DELETE FROM PRESCRIPTION WHERE PatientId = OLD.PatientId;
