USE Prescriptions_R_X;

select distinct FirstName,LastName,ExperianceYears
from DOCTOR
group by DoctorId
having ExperianceYears>10
order by ExperianceYears desc;