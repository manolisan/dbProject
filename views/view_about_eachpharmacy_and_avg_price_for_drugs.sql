 USE Prescriptions_R_X; 


CREATE VIEW vTest2 AS
SELECT distinct P.Name,avg(Price)
FROM SELL as S ,PHARMACY as P ,DRUG as D 
where 
    S.DrugId=D.DrugId
    and
    S.PharmacyId=P.PharmacyId
    group by P.Name; 





/* test it */
SELECT * FROM vTest2;