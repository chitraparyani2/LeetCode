# Write your MySQL query statement below
SELECT w2.id
FROM weather w1, weather w2
WHERE DATEDIFF(w2.recorddate, w1.recorddate) = 1 
AND w2.temperature > w1.temperature;