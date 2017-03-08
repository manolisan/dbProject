/* ask? */

select distinct d.Name
from DRUG d
where d.DrugId in (select p.DrugId
from PRESCRIPTION p
where p.DoctorId in (select d.DoctorId from DOCTOR d where d.speciality = 'Cardiology') );
