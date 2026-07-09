-- Last updated: 7/9/2026, 3:07:09 PM
# Write your MySQL query statement below
SELECT player_id , min(event_date) as first_login from Activity group by player_id;