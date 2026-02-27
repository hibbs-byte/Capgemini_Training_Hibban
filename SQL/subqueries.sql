SELECT *
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename = 'ALLEN');

SELECT dname
FROM dept
WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'SMITH');

SELECT *
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE job = 'DEVELOPER');

SELECT *
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp);

SELECT *
FROM dept
WHERE deptno IN (SELECT deptno FROM emp WHERE sal = (SELECT MAX(sal) FROM emp));

SELECT ename, sal, job, hiredate
FROM emp
WHERE deptno IN (SELECT deptno FROM dept WHERE dname = 'SALES')
AND hiredate < (SELECT hiredate FROM emp WHERE ename = 'KING');

SELECT dname
FROM dept
WHERE deptno IN (
    SELECT deptno
    FROM emp
    GROUP BY deptno
    HAVING COUNT(*) >= 5
);

SELECT *
FROM emp
WHERE (deptno, sal) IN (
    SELECT deptno, sal
    FROM emp
    GROUP BY deptno, sal
    HAVING COUNT(*) > 1
);
