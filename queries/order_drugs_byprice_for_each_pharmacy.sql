USE Prescriptions_R_X;

SELECT P.Name,D.Namedrug,S.Price
FROM SELL as S,PHARMACY AS P,DRUG as D
where P.PharmacyId=S.PharmacyId
	 and D.DrugId=S.DrugId
group by 
S.PharmacyId,
S.DrugId
order by Price;

