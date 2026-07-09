-- Last updated: 7/9/2026, 3:07:32 PM
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;