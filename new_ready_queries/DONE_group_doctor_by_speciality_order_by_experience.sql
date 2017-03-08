USE Prescriptions_R_X;

select Speciality, COUNT(Speciality), AVG(ExperianceYears)
from DOCTOR
group by Speciality
order by AVG(ExperianceYears) DESC;
