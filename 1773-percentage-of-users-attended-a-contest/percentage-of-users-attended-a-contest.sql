# Write your MySQL query statement below
Select 
         r.contest_id,
         round(count( distinct r.user_id) * 100 /(select count(*) from users),2) as percentage
FROM register r
GROUP BY r.contest_id
ORDER BY percentage desc, r.contest_id;