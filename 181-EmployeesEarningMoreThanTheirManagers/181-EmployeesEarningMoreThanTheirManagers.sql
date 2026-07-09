-- Last updated: 7/9/2026, 3:07:34 PM
SELECT e.name AS Employee
FROM Employee e
INNER JOIN Employee m
    ON e.managerId = m.id
WHERE e.salary > m.salary;