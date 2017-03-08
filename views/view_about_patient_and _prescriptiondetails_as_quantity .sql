
 USE Prescriptions_R_X; 


CREATE VIEW vTest1 AS
SELECT  P.FirstName,P.LastName,PR.Date, (select Name from DRUG where DRUG.DrugId = PR.DrugId)
FROM  PATIENT as P INNER JOIN PRESCRIPTION as PR
ON PR.PatientId=P.PatientId
order by PR.Date DESC;


/* test it */
SELECT * FROM vTest1;
