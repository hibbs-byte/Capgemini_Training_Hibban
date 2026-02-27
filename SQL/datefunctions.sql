SELECT COUNT(*) 
FROM emp 
WHERE TO_CHAR(hiredate,'YYYY') = '1981';

SELECT COUNT(*) 
FROM emp 
WHERE TO_CHAR(hiredate,'MM') = '12';

SELECT COUNT(*) 
FROM emp 
WHERE TO_CHAR(hiredate,'MON') = 'DEC';

SELECT COUNT(*) 
FROM emp 
WHERE AGE(CURRENT_DATE, hiredate) > INTERVAL '10 years';

SELECT *
FROM emp
WHERE TO_CHAR(hiredate,'YYYY') = '1981'
AND TO_CHAR(hiredate,'MM') IN ('02','04','12')
AND TO_CHAR(hiredate,'DY') IN ('WED','FRI');

SELECT NOW() - INTERVAL '2 years';
