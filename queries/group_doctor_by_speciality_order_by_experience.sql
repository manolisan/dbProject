USE Prescriptions_R_X;

select COUNT(Speciality) , Speciality, AVG(ExperianceYears)
from DOCTOR
group by Speciality
order by AVG(ExperianceYears) DESC;
