# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below

# delete table Person where id in ;
delete A from Person A, Person B where A.id > B.id and A.email=B.email;