Use Prescriptions_R_X;

select DRUG.Namedrug,COUNT(PRESCRIPTION.DrugId)
from DRUG
RIGHT JOIN PRESCRIPTION ON DRUG.DrugId = PRESCRIPTION.DrugId
group by DRUG.DrugId
order by COUNT(PRESCRIPTION.DrugId) DESC;
                
     
