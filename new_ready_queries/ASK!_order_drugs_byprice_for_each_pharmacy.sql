/* ask!! *? */

USE Prescriptions_R_X;

SELECT  D.Name,Price
FROM SELL as S ,PHARMACY as P ,DRUG as D 
where 
    S.DrugId=D.DrugId
    and
    S.PharmacyId=P.PharmacyId
    and
    D.Name='Panadol'
    order by Price; 

