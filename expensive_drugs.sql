START TRANSACTION;
USE Prescriptions_R_X;


select Name
from DRUG d
where d.DrugId=(select DrugId
				from SELL 
				where Price>(select avg(Price) from SELL));


/*SELECT *
FROM PATIENT ;

*/