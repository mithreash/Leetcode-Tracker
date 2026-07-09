-- Last updated: 7/9/2026, 3:07:19 PM
select lt.name as name,rt.bonus as bonus 
from Employee as lt
left join Bonus as rt
on lt.empId=rt.empId
where rt.bonus is null or rt.bonus<1000;