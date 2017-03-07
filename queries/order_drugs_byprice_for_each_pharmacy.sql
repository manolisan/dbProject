USE Prescriptions_R_X;

SELECT  Name,Namedrug,Price
FROM SELL as S ,PHARMACY as P ,DRUG as D 
where 
    S.DrugId=D.DrugId
    and
    S.PharmacyId=P.PharmacyId
    and
    D.Namedrug=?
    order by Price; 

