START TRANSACTION;
USE Prescriptions_R_X;

/* order_drugs_by_price */
SELECT d.DrugId,Name,Price
FROM  DRUG d
  INNER JOIN SELL s
		ON d.DrugId=s.DrugId
order by Price asc;

 





COMMIT;
 