USE Prescriptions_R_X;

/* Most popular Company which makes many drugs */

select PHARMACEUTICALCOMPANY.Name, COUNT(DRUG.PharmaceuticalCompanyId)
from PHARMACEUTICALCOMPANY
RIGHT JOIN DRUG ON PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId = DRUG.PharmaceuticalCompanyId
group by PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId
order by COUNT(DRUG.PharmaceuticalCompanyId) DESC;