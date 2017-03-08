 /* View all the Prescriptions sorted by date, and all patient names! */
 /* an thes prosthese kai farmako me to drug id */
 
 USE Prescriptions_R_X; 


CREATE VIEW vTest1 AS
SELECT  P.FirstName,P.LastName,PR.Date
FROM  PATIENT as P INNER JOIN PRESCRIPTION as PR
ON PR.PatientId=P.PatientId
order by PR.Date DESC;



SELECT * FROM vTest1;
