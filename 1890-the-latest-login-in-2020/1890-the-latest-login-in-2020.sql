# Write your MySQL query statement below
SELECT user_id, MAX(time_stamp) as last_stamp
from Logins
where time_stamp BETWEEN '2020-01-01 00:00:00' and '2020-12-31 23:59:59'
Group by user_id