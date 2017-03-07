USE Prescriptions_R_X;


select Namedrug
from DRUG d
where d.DrugId=(select DrugId
				from SELL 
				where Price>(select avg(Price) from SELL));




