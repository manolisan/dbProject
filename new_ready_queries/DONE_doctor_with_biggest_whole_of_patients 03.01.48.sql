USE Prescriptions_R_X;

select DOCTOR.FirstName,DOCTOR.LastName, COUNT(PATIENT.DoctorId)
from DOCTOR
RIGHT JOIN PATIENT ON DOCTOR.DoctorId = PATIENT.DoctorId
group by DOCTOR.DoctorId
order by COUNT(PATIENT.DoctorId) DESC;
                
     

                
                
		
