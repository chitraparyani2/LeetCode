# Write your MySQL query statement below
SELECT DATE_FORMAT(trans_date, '%Y-%m') as month,
       country, count(state) as trans_count,
       sum(if(state='approved', 1, 0)) as approved_count,
       sum(amount) as trans_total_amount,
       sum(if(state='approved', amount, 0)) as approved_total_amount
FROM transactions
GROUP BY month, country;