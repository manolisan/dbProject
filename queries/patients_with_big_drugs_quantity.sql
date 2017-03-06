select Pa.FirstName, Pa.LastName, sum(Pr.Quantity)
from PATIENT as Pa, PRESCRIPTION as Pr
where Pa.PatientId = Pr.PatientId
group by Pa.PatientId
having sum(Pr.Quantity) > 5
order by sum(Pr.Quantity) Desc;
