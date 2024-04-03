# Write your MySQL query statement below
SELECT s.user_id, 
    ROUND(AVG(if(c.action="confirmed", 1, 0)), 2) as confirmation_rate
FROM signups s LEFT JOIN confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id;


#SELECT user_id, count(action) as confirmed
#FROM confirmations
#WHERE action = 'confirmed'
#GROUP BY user_id;

#SELECT user_id, count(action) as Action
#FROM confirmations
#GROUP BY user_id;