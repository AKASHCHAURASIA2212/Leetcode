# Write your MySQL query statement below

SELECT A.id FROM weather A, weather B
WHERE datediff(A.recordDate, B.recordDate)= 1
AND A.temperature > B.temperature;