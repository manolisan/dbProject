USE Prescriptions_R_X;

/* order_drugs_by_price */
SELECT Name,Price
FROM  DRUG d
  INNER JOIN SELL s
		ON d.DrugId=s.DrugId
order by Price desc;
 