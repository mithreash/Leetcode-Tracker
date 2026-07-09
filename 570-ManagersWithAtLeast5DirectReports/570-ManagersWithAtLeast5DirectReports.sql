-- Last updated: 7/9/2026, 3:07:23 PM
select name from Employee 
where id in (select managerId from Employee group by managerId 
having count(managerId)>4);