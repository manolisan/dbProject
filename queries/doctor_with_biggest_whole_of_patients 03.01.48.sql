USE Prescriptions_R_X;

					

select DOCTOR.FirstName,DOCTOR.LastName
from DOCTOR
RIGHT JOIN PATIENT ON DOCTOR.DoctorId = PATIENT.DoctorId
group by DOCTOR.DoctorId
order by COUNT(PATIENT.DoctorId) DESC;
                
     

                
                
		