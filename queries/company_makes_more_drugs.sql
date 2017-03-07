USE Prescriptions_R_X;

/* Most popular Company which makes many drugs */

select PHARMACEUTICALCOMPANY.Name, COUNT(PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId)
from PHARMACEUTICALCOMPANY
RIGHT JOIN MAKE ON PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId = MAKE.PharmaceuticalCompanyId
group by PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId
order by COUNT(PHARMACEUTICALCOMPANY.PharmaceuticalCompanyId) DESC;