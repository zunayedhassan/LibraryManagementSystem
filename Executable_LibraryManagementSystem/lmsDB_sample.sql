-- lmsDB
-- ========================================================================
CREATE DATABASE IF NOT EXISTS lmsDB;
-- -------------------------------------------------------------------------
USE lmsDB;
-- -------------------------------------------------------------------------

-- user_info
-- ========================================================================
CREATE TABLE user_info (
	user_id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	user_name_first VARCHAR (25) NOT NULL,
	user_name_middle VARCHAR(15),
	user_name_last VARCHAR(25) NOT NULL,
	user_type ENUM('Administrator', 'Member') NOT NULL,
	user_password VARCHAR(10) NOT NULL,
	gender ENUM('Male', 'Female') NOT NULL,
	date_of_birth DATE NOT NULL,
	phone VARCHAR(20) NOT NULL,
	email VARCHAR(50) NOT NULL,
	address_house_no VARCHAR(12) NOT NULL,
	address_street VARCHAR(80) NOT NULL,
	address_city VARCHAR(15) NOT NULL,
	address_zip INT(4) NOT NULL,
	country VARCHAR (15) NOT NULL
) ENGINE = INNODB;
-- ------------------------------------------------------------------------
INSERT INTO user_info(user_name_first, user_name_middle, user_name_last, user_type, user_password, gender, date_of_birth, phone, email, address_house_no, address_street, address_city, address_zip, country) VALUES('Mohammad', 'Zunayed', 'Hassan', 'Administrator', '12345', 'Male', '1989-05-28', '01741284439', 'zunayedhassan88@gmail.com', 'DMC 342/2', 'South Kafrul, Dhaka Cantonment', 'Dhaka', 1206, 'Bangladesh');
-- ------------------------------------------------------------------------
INSERT INTO user_info(user_name_first, user_name_middle, user_name_last, user_type, user_password, gender, date_of_birth, phone, email, address_house_no, address_street, address_city, address_zip, country) VALUES('Abdullah', 'Al', 'Mamun', 'Member', 'asdfg', 'Male', '1989-01-03', '01712345678', 'almamun@yahoo.com', 'DMC 201/A', 'East Kafrul, Dhaka Cantonment', 'Dhaka', 1206, 'Bangladesh');
-- ------------------------------------------------------------------------
INSERT INTO user_info(user_name_first, user_name_middle, user_name_last, user_type, user_password, gender, date_of_birth, phone, email, address_house_no, address_street, address_city, address_zip, country) VALUES('Tarek', 'Aziz', 'Jiko', 'Member', 'zxcvb', 'Male', '1987-04-18', '01642042089', 'taziz87@yahoo.com', '395/A', 'Shamoli, Mirpur', 'Dhaka', 1000, 'Bangladesh');
-- ------------------------------------------------------------------------

-- book_info
-- ========================================================================
CREATE TABLE book_info (
	isbn VARCHAR(16) NOT NULL PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	author VARCHAR(100) NOT NULL,
	publisher VARCHAR(50) NOT NULL,
	publication_year DATE NOT NULL,
	pages INT NOT NULL,
	genre VARCHAR(24)
) ENGINE = INNODB;
-- ------------------------------------------------------------------------
INSERT INTO book_info VALUES('0-07-038001-5', 'Data Structures', 'Seymour Lipschutz', 'Tata McGraw-Hill Publishing Company Ltd', '2004-01-01', 344, 'Computer Science');
-- ------------------------------------------------------------------------
INSERT INTO book_info VALUES('978-007-124474-9', 'Discrete Mathematics and Its Applications', 'Kenneth H. Rosen', 'McGraw-Hill Publication', '2007-00-00', 843, 'Mathematics');
-- ------------------------------------------------------------------------
INSERT INTO book_info VALUES('978-0471-98019-3', 'Accouting Principles', 'Donald E. Kieso', 'John Wiley & Sons, Inc', '2007-00-00', 1172, 'Accounting');
-- ------------------------------------------------------------------------
INSERT INTO book_info VALUES('81-7515-257-5', 'Fundamentals of Algorithms', 'Ellis Horowitz', 'Galgotia Publications Pvt. Ltd', '1998-00-00', 769, 'Computer Science');
-- ------------------------------------------------------------------------
INSERT INTO book_info VALUES('0-07-882311-0', 'Teach Yourself C', 'Herbert Schildt', 'McGraw-Hill', '2004-00-00', 640, 'Computer Programming');
-- ------------------------------------------------------------------------

-- issue
-- ========================================================================
CREATE TABLE issue (
	user_id INT,
	isbn VARCHAR(16),
	issue_date DATE,
	due_date DATE,
	
	FOREIGN KEY (user_id) REFERENCES user_info(user_id) ON DELETE RESTRICT,
	FOREIGN KEY (isbn) REFERENCES book_info(isbn) ON DELETE RESTRICT
) ENGINE = INNODB;
-- ------------------------------------------------------------------------
INSERT INTO issue VALUES (2, '978-007-124474-9', curdate(), date_add(curdate(), INTERVAL 3 DAY)
);
-- ------------------------------------------------------------------------
SELECT user_info.user_name_first, user_info.user_name_middle, user_info.user_name_last, user_info.user_id, issue.isbn, book_info.title, book_info.author, issue.issue_date, issue.due_date FROM user_info, issue, book_info WHERE user_info.user_id = issue.user_id AND issue.isbn = book_info.isbn;
-- ------------------------------------------------------------------------
