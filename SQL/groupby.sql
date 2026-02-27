SELECT deptno, COUNT(*) 
FROM emp 
WHERE sal > 2000 
GROUP BY deptno;

SELECT job, MAX(sal) 
FROM emp 
GROUP BY job;

SELECT job, AVG(sal) 
FROM emp 
GROUP BY job;

SELECT deptno, COUNT(*) 
FROM emp 
GROUP BY deptno 
HAVING COUNT(*) >= 4;

SELECT deptno, COUNT(*) 
FROM emp 
WHERE ename LIKE '%A%' OR ename LIKE '%S%' 
GROUP BY deptno 
HAVING COUNT(*) >= 2;

SELECT sal, COUNT(*) 
FROM emp 
GROUP BY sal 
HAVING COUNT(*) > 1;

SELECT job, SUM(sal) 
FROM emp 
GROUP BY job 
HAVING SUM(sal) > 8000;

SELECT AVG(sal) 
FROM emp 
HAVING AVG(sal) > 55000;
