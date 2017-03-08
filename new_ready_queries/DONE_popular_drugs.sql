Use Prescriptions_R_X;

select DRUG.Name,COUNT(PRESCRIPTION.DrugId)
from DRUG
RIGHT JOIN PRESCRIPTION ON DRUG.DrugId = PRESCRIPTION.DrugId
group by DRUG.DrugId
order by COUNT(PRESCRIPTION.DrugId) DESC;
               

/*
select d.Name,COUNT(d.Name)
from DRUG as d, PRESCRIPTION as p
where d.DrugId in (select DrugId from PRESCRIPTION as p where p.DrugId = d.DrugId)
group by d.DrugId
order by COUNT(p.DrugId) DESC;
*/
