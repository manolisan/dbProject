USE Prescriptions_R_X;

/*more_expensive_than_average_price_of totaldrugs*/
select Namedrug
from DRUG d
where d.DrugId= ANY (select DrugId
				from SELL 
				where Price>(select avg(Price) from SELL));