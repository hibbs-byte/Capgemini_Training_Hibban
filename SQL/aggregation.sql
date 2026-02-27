SELECT MAX(sal) AS max_salary,
       MIN(sal) AS min_salary,
       AVG(sal) AS avg_salary
FROM emp
WHERE deptno = 20;

SELECT COUNT(*) AS total_employees,
       SUM(sal) AS total_salary
FROM emp
WHERE sal > 1700;
