USE Prescriptions_R_X;

/*select FirstName, LastName
from DOCTOR d
  INNER JOIN PATIENT p
		ON d.DrugId=(select p.DrugId
			         from (SELECT MAX(patients)   
							FROM (SELECT DoctorId,COUNT(distinct DoctorId) patients  
							FROM PATIENT   
							GROUP BY DoctorId)AS P) AS T);*/ 
               


/*SELECT MAX(patients)   
FROM (SELECT DoctorId,COUNT(distinct DoctorId) patients  
FROM PATIENT   
GROUP BY DoctorId) AS Plithos;*/

/*select distinct FirstName, LastName
from DOCTOR
where DoctorId=(select DoctorId
				from (select max(patients)
                
                
     
                
                
	
                
                
                
                
                
                
                */
                
                
                
 
      
 SELECT distinct FirstName,LastName
  from PATIENT
  group by DoctorId
  HAVING COUNT(DoctorId)=(SELECT max(NUM)
						  from (select count(DoctorId) NUM from PATIENT) AS P);
      
      
      
      
      
      