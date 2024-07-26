CREATE DATABASE vlsdb;

USE vlsdb;

CREATE TABLE login (
    id INT AUTO_INCREMENT PRIMARY KEY,
    loginId VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    duration INT NOT NULL,
    availability BOOLEAN NOT NULL
);
INSERT INTO login (loginId, password) VALUES ('banu','priya'),('guru','kumaran'),('bala','saranya');
SELECT * FROM login;
INSERT INTO courses (name, author, duration, availability) VALUES
('Introduction to Java', 'Telusko', 10, true),
('Metaverse Applications', 'Mark', 15, true),
('DSA Stack and Queue', 'Striver', 20, true),
('Python Applications', 'Harry', 12, false),
('GenAI', 'Subbu', 18, true);
SELECT * FROM courses;
CREATE TABLE  cart (
    courseId INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    duration INT NOT NULL,
    availability BOOLEAN NOT NULL,
    FOREIGN KEY (courseId) REFERENCES courses(id)
);
SELECT * FROM cart;
