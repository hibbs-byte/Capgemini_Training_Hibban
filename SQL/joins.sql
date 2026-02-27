SELECT a.author_name, b.title
FROM Authors a
INNER JOIN Books b ON a.author_id = b.author_id;

SELECT a.author_name
FROM Authors a
LEFT JOIN Books b ON a.author_id = b.author_id
WHERE b.book_id IS NULL;

SELECT b.title, g.genre_name
FROM Books b
INNER JOIN Genres g ON b.genre_id = g.genre_id;

SELECT u.user_name, COUNT(l.book_id) AS books_borrowed
FROM Users u
LEFT JOIN Loans l ON u.user_id = l.user_id
GROUP BY u.user_name;

SELECT b.title, COUNT(l.book_id) AS borrow_count
FROM Books b
LEFT JOIN Loans l ON b.book_id = l.book_id
GROUP BY b.title
ORDER BY borrow_count DESC;
