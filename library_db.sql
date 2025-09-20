create database library_db;
USE library_db;

CREATE TABLE IF NOT EXISTS lib_admins (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
			-- Sample data
			INSERT INTO lib_admins (username, password) VALUES
			('admin', 'admin123'); -- Note: later hash password in real app

CREATE TABLE IF NOT EXISTS lib_categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL
);
-- Sample data
INSERT INTO lib_categories (category_name) VALUES
('Science'),
('Literature'),
('Technology'),
('History');

CREATE TABLE IF NOT EXISTS lib_books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50) NOT NULL,
    publisher VARCHAR(50),
    isbn VARCHAR(20) UNIQUE,
    category_id INT,
    quantity INT DEFAULT 1,
    FOREIGN KEY (category_id) REFERENCES lib_categories(category_id)
);

-- Sample data
INSERT INTO lib_books (title, author, publisher, isbn, category_id, quantity) VALUES
('Java Programming', 'John Doe', 'TechBooks', '1234567890', 3, 5),
('World History', 'Jane Smith', 'HistoryPress', '0987654321', 4, 3),
('Physics Fundamentals', 'Albert Newton', 'SciencePub', '1122334455', 1, 7);


CREATE TABLE IF NOT EXISTS lib_students (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    roll_number VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50),
    contact VARCHAR(15)
);

-- Sample data
INSERT INTO lib_students (name, roll_number, email, contact) VALUES
('Ali Khan', 'DS001', 'ali.khan@example.com', '03001234567'),
('Sara Ahmed', 'DS002', 'sara.ahmed@example.com', '03007654321');


CREATE TABLE IF NOT EXISTS lib_issued_books (
    issue_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    book_id INT,
    issue_date DATE,
    due_date DATE,
    return_date DATE,
    FOREIGN KEY (student_id) REFERENCES lib_students(student_id),
    FOREIGN KEY (book_id) REFERENCES lib_books(book_id)
);

-- Sample data
INSERT INTO lib_issued_books (student_id, book_id, issue_date, due_date, return_date) VALUES
(1, 1, '2025-08-20', '2025-09-05', NULL),
(2, 2, '2025-08-21', '2025-09-06', NULL);
