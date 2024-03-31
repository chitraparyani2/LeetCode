/* Write your T-SQL query statement below */
select unique_id, name
from Employees emp left join EmployeeUNI uni
on emp.id = uni.id