# Write your MySQL query statement below
SELECT product_name, year, price
FROM sales INNER JOIN product
WHERE sales.product_id = product.product_id;