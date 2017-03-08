USE Prescriptions_R_X;

/*more_expensive_than_average_price_of totaldrugs*/


select distinct d.Name, Price
from SELL s INNER JOIN DRUG d 
ON d.DrugId=s.DrugId
where Price> (select avg(Price) from SELL);