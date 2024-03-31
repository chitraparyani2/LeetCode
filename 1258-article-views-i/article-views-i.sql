# Write your MySQL query statement below
SELECT distinct v1.author_id as id
FROM views v1, views v2
WHERE v1.author_id = v2.viewer_id
and v1.article_id = v2.article_id
order by id