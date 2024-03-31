# Write your MySQL query statement below
SELECT distinct v1.author_id as id
FROM views v1
WHERE v1.author_id in (select viewer_id from views
where article_id = v1.article_id)
order by id