-- Last updated: 7/9/2026, 3:07:11 PM

select customer_number from orders 
group by customer_number
order by count(customer_number) desc
limit 1;