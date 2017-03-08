USE Prescriptions_R_X;

/* order_drugs_by_price */
SELECT Name,Price,(select Name from PHARMACY where PHARMACY.PharmacyId = s.PharmacyId)
FROM  DRUG d
  INNER JOIN SELL s
		ON d.DrugId=s.DrugId
order by Price desc;
 
