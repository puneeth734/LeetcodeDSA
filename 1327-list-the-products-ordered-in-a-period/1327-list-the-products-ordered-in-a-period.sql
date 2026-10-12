# Write your MySQL query statement below
SELECT p.product_name AS product_name, sum(o.unit) AS unit 
FROM Products p
JOIN Orders o USING (product_id)
WHERE order_date LIKE '2020-02%'
GROUP BY p.product_id
HAVING SUM(o.unit)>=100

