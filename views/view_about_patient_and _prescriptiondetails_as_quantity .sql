 USE Prescriptions_R_X; 


CREATE VIEW vTest1 AS
SELECT  P.FirstName,P.LastName,PR.Quantity 
FROM  PATIENT as P INNER JOIN PRESCRIPTION as PR
ON PR.PatientId=P.PatientId
order by PR.Quantity;



SELECT * FROM vTest1;



