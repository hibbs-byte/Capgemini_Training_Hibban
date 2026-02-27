CREATE TABLE Authors (
    author_id INT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    state VARCHAR(50)
);

CREATE TABLE Genres (
    genre_id INT PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author_id INT REFERENCES Authors(author_id),
    genre_id INT REFERENCES Genres(genre_id)
);

CREATE TABLE Users (
    user_id INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    phno VARCHAR(15),
    email VARCHAR(100)
);

CREATE TABLE Loans (
    loan_id INT PRIMARY KEY,
    user_id INT REFERENCES Users(user_id),
    book_id INT REFERENCES Books(book_id),
    borrowed_date DATE NOT NULL,
    returned_date DATE
);
