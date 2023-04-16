-- Active: 1674435687826@@127.0.0.1@3306@The Library



CREATE DATABASE IF NOT EXISTS `The Library`;

USE `The Library`;


CREATE USER
    IF NOT EXISTS 'librarian' @'localhost' IDENTIFIED BY 'Librarian123';


GRANT ALL PRIVILEGES ON `The Library`.* TO 'librarian'@'localhost';


CREATE TABLE
    IF NOT EXISTS `Book` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `copy` int(11) NOT NULL,
        `available` tinyint(1) NOT NULL,
        `title` varchar(255) NOT NULL,
        `genre` varchar(255) NOT NULL,
        `price` decimal(10, 2) NOT NULL,
        `year` int(11) NOT NULL,
        `author` varchar(255) NOT NULL,
        `condition` varchar(255) NOT NULL,
        `pages` int(11) NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE
    IF NOT EXISTS `CompactDisk` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `copy` int(11) NOT NULL,
        `available` tinyint(1) NOT NULL,
        `title` varchar(255) NOT NULL,
        `genre` varchar(255) NOT NULL,
        `price` decimal(10, 2) NOT NULL,
        `year` int(11) NOT NULL,
        `artist` varchar(255) NOT NULL,
        `tracks` int(11) NOT NULL,
        `ageRating` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE
    IF NOT EXISTS `Game` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `copy` int(11) NOT NULL,
        `available` tinyint(1) NOT NULL,
        `title` varchar(255) NOT NULL,
        `genre` varchar(255) NOT NULL,
        `price` decimal(10, 2) NOT NULL,
        `year` int(11) NOT NULL,
        `publisher` varchar(255) NOT NULL,
        `platform` varchar(255) NOT NULL,
        `playtime` int(11) NOT NULL,
        `ageRating` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


CREATE TABLE
    IF NOT EXISTS `Movie` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `copy` int(11) NOT NULL,
        `available` tinyint(1) NOT NULL,
        `title` varchar(255) NOT NULL,
        `genre` varchar(255) NOT NULL,
        `price` decimal(10, 2) NOT NULL,
        `year` int(11) NOT NULL,
        `director` varchar(255) NOT NULL,
        `runtime` int(11) NOT NULL,
        `ageRating` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE
    IF NOT EXISTS `User`(
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `username` varchar(255) NOT NULL,
        `email` varchar(255) NOT NULL,
        `address` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;

CREATE TABLE
    IF NOT EXISTS `Lending`(
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `userID` int(11) NOT NULL,
        `itemID` int(11) NOT NULL,
        `type` varchar(255) NOT NULL,
        `lendDate` date NOT NULL,
        `returnDate` date NOT NULL,
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8;


INSERT INTO `Book` (`copy`, `available`, `title`, `genre`, `price`, `year`, `author`, `condition`, `pages`) VALUES
(1, 1, 'The Hobbit', 'Fantasy', 100.00, 1937, 'J.R.R. Tolkien', 'Good', 310),
(2, 1, 'The Hobbit', 'Fantasy', 100.00, 1937, 'J.R.R. Tolkien', 'Poor', 310),
(3, 1, 'The Hobbit', 'Fantasy', 100.00, 1937, 'J.R.R. Tolkien', 'Good', 310),
(4, 1, 'The Hobbit', 'Fantasy', 100.00, 1937, 'J.R.R. Tolkien', 'Good', 310),
(5, 0, 'The Hobbit', 'Fantasy', 100.00, 1937, 'J.R.R. Tolkien', 'Excellent', 310),

(1, 1, 'The Lord of the Rings', 'Fantasy', 200.00, 1954, 'J.R.R. Tolkien', 'Poor', 1216),
(2, 0, 'The Lord of the Rings', 'Fantasy', 200.00, 1954, 'J.R.R. Tolkien', 'Good', 1216),
(3, 1, 'The Lord of the Rings', 'Fantasy', 200.00, 1954, 'J.R.R. Tolkien', 'Excellent', 1216),
(4, 1, 'The Lord of the Rings', 'Fantasy', 200.00, 1954, 'J.R.R. Tolkien', 'Good', 1216),

(1, 1, 'The Silmarillion', 'Fantasy', 300.00, 1977, 'J.R.R. Tolkien', 'Good', 488),
(2, 1, 'The Silmarillion', 'Fantasy', 300.00, 1977, 'J.R.R. Tolkien', 'Excellent', 488),
(3, 1, 'The Silmarillion', 'Fantasy', 300.00, 1977, 'J.R.R. Tolkien', 'Good', 488),

(1, 1, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 400.00, 1979, 'Douglas Adams', 'Good', 224),
(2, 0, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 400.00, 1979, 'Douglas Adams', 'Poor', 224),

(1, 1, 'The Restaurant at the End of the Universe', 'Science Fiction', 500.00, 1980, 'Douglas Adams', 'Good', 224),
(2, 1, 'The Restaurant at the End of the Universe', 'Science Fiction', 500.00, 1980, 'Douglas Adams', 'Poor', 224),
(3, 1, 'The Restaurant at the End of the Universe', 'Science Fiction', 500.00, 1980, 'Douglas Adams', 'Good', 224),


(1, 1, 'Life, the Universe and Everything', 'Science Fiction', 600.00, 1982, 'Douglas Adams', 'Good', 224),
(2, 0, 'Life, the Universe and Everything', 'Science Fiction', 600.00, 1982, 'Douglas Adams', 'Good', 224),
(3, 1, 'Life, the Universe and Everything', 'Science Fiction', 600.00, 1982, 'Douglas Adams', 'Poor', 224),
(4, 1, 'Life, the Universe and Everything', 'Science Fiction', 600.00, 1982, 'Douglas Adams', 'Good', 224),

(1, 1, 'So Long, and Thanks for All the Fish', 'Science Fiction', 700.00, 1984, 'Douglas Adams', 'Good', 224),
(2, 1, 'So Long, and Thanks for All the Fish', 'Science Fiction', 700.00, 1984, 'Douglas Adams', 'Good', 224),
(3, 1, 'So Long, and Thanks for All the Fish', 'Science Fiction', 700.00, 1984, 'Douglas Adams', 'Poor', 224),

(1, 1, 'Harry Potter and the Philosopher''s Stone', 'Fantasy', 100.00, 1997, 'J.K. Rowling', 'Good', 223),
(2, 1, 'Harry Potter and the Philosopher''s Stone', 'Fantasy', 100.00, 1997, 'J.K. Rowling', 'Poor', 223),
(3, 1, 'Harry Potter and the Philosopher''s Stone', 'Fantasy', 100.00, 1997, 'J.K. Rowling', 'Good', 223),
(4, 1, 'Harry Potter and the Philosopher''s Stone', 'Fantasy', 100.00, 1997, 'J.K. Rowling', 'Good', 223),

(1, 1, 'Harry Potter and the Chamber of Secrets', 'Fantasy', 200.00, 1998, 'J.K. Rowling', 'Poor', 251),
(2, 1, 'Harry Potter and the Chamber of Secrets', 'Fantasy', 200.00, 1998, 'J.K. Rowling', 'Good', 251),
(3, 1, 'Harry Potter and the Chamber of Secrets', 'Fantasy', 200.00, 1998, 'J.K. Rowling', 'Good', 251),
(4, 1, 'Harry Potter and the Chamber of Secrets', 'Fantasy', 200.00, 1998, 'J.K. Rowling', 'Good', 251),

(1, 1, 'Harry Potter and the Prisoner of Azkaban', 'Fantasy', 300.00, 1999, 'J.K. Rowling', 'Good', 317),
(2, 1, 'Harry Potter and the Prisoner of Azkaban', 'Fantasy', 300.00, 1999, 'J.K. Rowling', 'Excellent', 317);

INSERT INTO CompactDisk (`copy`, `available`, `title`, `genre`, `price`, `year`, `artist`, `tracks`, `ageRating`) VALUES
(1, 1, 'The Dark Side of the Moon', 'Rock', 100.00, 1973, 'Pink Floyd', 8, 'PG'),
(2, 0, 'The Dark Side of the Moon', 'Rock', 100.00, 1973, 'Pink Floyd', 8, 'PG'),
(3, 1, 'The Dark Side of the Moon', 'Rock', 100.00, 1973, 'Pink Floyd', 8, 'PG'),
(4, 1, 'The Dark Side of the Moon', 'Rock', 100.00, 1973, 'Pink Floyd', 8, 'PG'),
(5, 1, 'The Dark Side of the Moon', 'Rock', 100.00, 1973, 'Pink Floyd', 8, 'PG'),

(1, 0, 'The Wall', 'Rock', 200.00, 1979, 'Pink Floyd', 26, 'PG'),
(2, 1, 'The Wall', 'Rock', 200.00, 1979, 'Pink Floyd', 26, 'PG'),
(3, 1, 'The Wall', 'Rock', 200.00, 1979, 'Pink Floyd', 26, 'PG'),
(4, 1, 'The Wall', 'Rock', 200.00, 1979, 'Pink Floyd', 26, 'PG'),

(1, 1, 'The Division Bell', 'Rock', 300.00, 1994, 'Pink Floyd', 6, 'PG'),
(2, 1, 'The Division Bell', 'Rock', 300.00, 1994, 'Pink Floyd', 6, 'PG'),
(3, 1, 'The Division Bell', 'Rock', 300.00, 1994, 'Pink Floyd', 6, 'PG'),

(1, 1, 'The Piper at the Gates of Dawn', 'Rock', 400.00, 1967, 'Pink Floyd', 7, 'PG'),
(2, 1, 'The Piper at the Gates of Dawn', 'Rock', 400.00, 1967, 'Pink Floyd', 7, 'PG'),

(1, 1, 'The Final Cut', 'Rock', 500.00, 1983, 'Pink Floyd', 5, 'PG'),
(2, 1, 'The Final Cut', 'Rock', 500.00, 1983, 'Pink Floyd', 5, 'PG'),
(3, 1, 'The Final Cut', 'Rock', 500.00, 1983, 'Pink Floyd', 5, 'PG'),
(4, 1, 'The Final Cut', 'Rock', 500.00, 1983, 'Pink Floyd', 5, 'PG'),
(5, 1, 'The Final Cut', 'Rock', 500.00, 1983, 'Pink Floyd', 5, 'PG'),

(1, 1, 'Arise', 'Metal', 200.00, 1989, 'Sepultura', 10, 'R'),
(2, 1, 'Arise', 'Metal', 200.00, 1989, 'Sepultura', 10, 'R'),
(3, 1, 'Arise', 'Metal', 200.00, 1989, 'Sepultura', 10, 'R'),
(4, 1, 'Arise', 'Metal', 200.00, 1989, 'Sepultura', 10, 'R'),

(1, 1, 'Roots', 'Metal', 300.00, 1996, 'Sepultura', 11, 'R'),
(2, 1, 'Roots', 'Metal', 300.00, 1996, 'Sepultura', 11, 'R'),
(3, 0, 'Roots', 'Metal', 300.00, 1996, 'Sepultura', 11, 'R'),

(1, 1, 'Chaos A.D.', 'Metal', 400.00, 1993, 'Sepultura', 10, 'R'),
(2, 1, 'Chaos A.D.', 'Metal', 400.00, 1993, 'Sepultura', 10, 'R'),

(1, 1, 'Against', 'Metal', 500.00, 1998, 'Sepultura', 10, 'R'),
(2, 1, 'Against', 'Metal', 500.00, 1998, 'Sepultura', 10, 'R'),
(3, 1, 'Against', 'Metal', 500.00, 1998, 'Sepultura', 10, 'R'),
(4, 1, 'Against', 'Metal', 500.00, 1998, 'Sepultura', 10, 'R'),
(5, 1, 'Against', 'Metal', 500.00, 1998, 'Sepultura', 10, 'R'),

(1, 1, 'Nation', 'Metal', 600.00, 2004, 'Sepultura', 10, 'R'),
(2, 1, 'Nation', 'Metal', 600.00, 2004, 'Sepultura', 10, 'R'),
(3, 1, 'Nation', 'Metal', 600.00, 2004, 'Sepultura', 10, 'R');


INSERT INTO Game (`copy`, `available`, `title`, `genre`, `price`, `year`, `publisher`, `platform`, `playtime`, `ageRating`) VALUES
(1, 0, 'Grand Theft Auto V', 'Action', 100.00, 2013, 'Rockstar Games', 'Xbox 360', 20, 'R'),
(2, 1, 'Grand Theft Auto V', 'Action', 100.00, 2013, 'Rockstar Games', 'Xbox 360', 20, 'R'),
(3, 1, 'Grand Theft Auto V', 'Action', 100.00, 2013, 'Rockstar Games', 'Xbox 360', 20, 'R'),
(4, 1, 'Grand Theft Auto V', 'Action', 100.00, 2013, 'Rockstar Games', 'Xbox 360', 20, 'R'),
(5, 1, 'Grand Theft Auto V', 'Action', 100.00, 2013, 'Rockstar Games', 'Xbox 360', 20, 'R'),

(1, 1, 'Grand Theft Auto V', 'Action', 200.00, 2013, 'Rockstar Games', 'Playstation 3', 20, 'R'),
(2, 1, 'Grand Theft Auto V', 'Action', 200.00, 2013, 'Rockstar Games', 'Playstation 3', 20, 'R'),
(3, 1, 'Grand Theft Auto V', 'Action', 200.00, 2013, 'Rockstar Games', 'Playstation 3', 20, 'R'),
(4, 1, 'Grand Theft Auto V', 'Action', 200.00, 2013, 'Rockstar Games', 'Playstation 3', 20, 'R'),

(1, 1, 'Grand Theft Auto V', 'Action', 300.00, 2013, 'Rockstar Games', 'PC', 20, 'R'),
(2, 1, 'Grand Theft Auto V', 'Action', 300.00, 2013, 'Rockstar Games', 'PC', 20, 'R'),
(3, 1, 'Grand Theft Auto V', 'Action', 300.00, 2013, 'Rockstar Games', 'PC', 20, 'R'),

(1, 1, 'Battlefield 1', 'Action', 100.00, 2016, 'Electronic Arts', 'Xbox 360', 20, 'R'),
(2, 1, 'Battlefield 1', 'Action', 100.00, 2016, 'Electronic Arts', 'Xbox 360', 20, 'R'),

(1, 1, 'Battlefield 1', 'Action', 200.00, 2016, 'Electronic Arts', 'Playstation 3', 20, 'R'),
(2, 1, 'Battlefield 1', 'Action', 200.00, 2016, 'Electronic Arts', 'Playstation 3', 20, 'R'),
(3, 1, 'Battlefield 1', 'Action', 200.00, 2016, 'Electronic Arts', 'Playstation 3', 20, 'R'),

(1, 1, 'Battlefield 1', 'Action', 300.00, 2016, 'Electronic Arts', 'PC', 20, 'R'),
(2, 0, 'Battlefield 1', 'Action', 300.00, 2016, 'Electronic Arts', 'PC', 20, 'R'),
(3, 1, 'Battlefield 1', 'Action', 300.00, 2016, 'Electronic Arts', 'PC', 20, 'R'),

(1, 1, 'Battlefield V', 'Action', 100.00, 2018, 'Electronic Arts', 'Xbox 360', 20, 'R'),
(2, 1, 'Battlefield V', 'Action', 100.00, 2018, 'Electronic Arts', 'Xbox 360', 20, 'R'),
(3, 1, 'Battlefield V', 'Action', 100.00, 2018, 'Electronic Arts', 'Xbox 360', 20, 'R'),
(4, 1, 'Battlefield V', 'Action', 100.00, 2018, 'Electronic Arts', 'Xbox 360', 20, 'R'),

(1, 0, 'Battlefield V', 'Action', 200.00, 2018, 'Electronic Arts', 'Playstation 3', 20, 'R'),
(2, 1, 'Battlefield V', 'Action', 200.00, 2018, 'Electronic Arts', 'Playstation 3', 20, 'R'),

(1, 1, 'Battlefield V', 'Action', 300.00, 2018, 'Electronic Arts', 'PC', 20, 'R'),
(2, 1, 'Battlefield V', 'Action', 300.00, 2018, 'Electronic Arts', 'PC', 20, 'R'),
(3, 1, 'Battlefield V', 'Action', 300.00, 2018, 'Electronic Arts', 'PC', 20, 'R');

INSERT INTO Movie (`copy`, `available`, `title`, `genre`, `price`, `year`, `director`, `runtime`, `ageRating`) VALUES
(1, 1, 'The Dark Knight', 'Action', 100.00, 2008, 'Christopher Nolan', 152, 'R'),
(2, 1, 'The Dark Knight', 'Action', 100.00, 2008, 'Christopher Nolan', 152, 'R'),
(3, 1, 'The Dark Knight', 'Action', 100.00, 2008, 'Christopher Nolan', 152, 'R'),

(1, 1, 'The Dark Knight Rises', 'Action', 100.00, 2012, 'Christopher Nolan', 164, 'R'),
(2, 0, 'The Dark Knight Rises', 'Action', 100.00, 2012, 'Christopher Nolan', 164, 'R'),

(1, 0, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 150.00, 2005, 'Garth Jennings', 109, 'PG'),
(2, 1, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 150.00, 2005, 'Garth Jennings', 109, 'PG'),
(3, 1, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 150.00, 2005, 'Garth Jennings', 109, 'PG'),
(4, 1, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 150.00, 2005, 'Garth Jennings', 109, 'PG'),
(5, 1, 'The Hitchhikers Guide to the Galaxy', 'Science Fiction', 150.00, 2005, 'Garth Jennings', 109, 'PG'),

(1, 1, 'The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', 100.00, 2001, 'Peter Jackson', 178, 'PG-13'),
(2, 1, 'The Lord of the Rings: The Fellowship of the Ring', 'Fantasy', 100.00, 2001, 'Peter Jackson', 178, 'PG-13'),

(1, 1, 'Titanic', 'Drama', 100.00, 1997, 'James Cameron', 194, 'PG-13'),
(2, 1, 'Titanic', 'Drama', 100.00, 1997, 'James Cameron', 194, 'PG-13'),
(3, 0, 'Titanic', 'Drama', 100.00, 1997, 'James Cameron', 194, 'PG-13'),
(4, 1, 'Titanic', 'Drama', 100.00, 1997, 'James Cameron', 194, 'PG-13'),
(5, 1, 'Titanic', 'Drama', 100.00, 1997, 'James Cameron', 194, 'PG-13'),

(1, 1, 'The Lord of the Rings: The Return of the King', 'Fantasy', 100.00, 2003, 'Peter Jackson', 201, 'PG-13'),
(2, 1, 'The Lord of the Rings: The Return of the King', 'Fantasy', 100.00, 2003, 'Peter Jackson', 201, 'PG-13'),
(3, 1, 'The Lord of the Rings: The Return of the King', 'Fantasy', 100.00, 2003, 'Peter Jackson', 201, 'PG-13'),

(1, 1, 'The Lord of the Rings: The Two Towers', 'Fantasy', 100.00, 2002, 'Peter Jackson', 179, 'PG-13'),
(2, 1, 'The Lord of the Rings: The Two Towers', 'Fantasy', 100.00, 2002, 'Peter Jackson', 179, 'PG-13'),
(3, 1, 'The Lord of the Rings: The Two Towers', 'Fantasy', 100.00, 2002, 'Peter Jackson', 179, 'PG-13'),
(4, 1, 'The Lord of the Rings: The Two Towers', 'Fantasy', 100.00, 2002, 'Peter Jackson', 179, 'PG-13'),

(1, 1, 'The Matrix', 'Action', 100.00, 1999, 'The Wachowski Brothers', 136, 'R'),

(1, 1, 'John Wick', 'Action', 100.00, 2014, 'Chad Stahels', 136, 'R'),
(2, 1, 'John Wick', 'Action', 100.00, 2014, 'Chad Stahels', 136, 'R'),

(1, 1, 'John Wick 2', 'Action', 100.00, 2017, 'Chad Stahels', 136, 'R'),
(2, 1, 'John Wick 2', 'Action', 100.00, 2017, 'Chad Stahels', 136, 'R'),
(3, 1, 'John Wick 2', 'Action', 100.00, 2017, 'Chad Stahels', 136, 'R');

INSERT INTO User (`username`, `email`, `address`) VALUES
('Alex Roman', 'alex@roman.com', 'Street 1'),
('John Smith', 'john@smith.com', 'Street 2'),
('Jane Doe', 'jane@doe.com', 'Street 3'),
('John Doe', 'john@doe', 'Street 4'),
('Jane Smith', 'jane@smith.com', 'Street 5'),
('Alex Smith', 'alex@smith.com', 'Street 6'),
('John Johnson', 'john@johnson.gov', 'Street 7'),
('Janine Castro', 'janine@castro.br', 'Street 8'),
('Alex Doe', 'alex@doe.se', 'Street 9'),
('Joe Doe', 'joe@doe.se', 'Street 10');

INSERT INTO `Lending` (`userID`, `itemID`, `Type`, `lendDate`, `returnDate`) VALUES 
(1, 5, 'Book', '2023-01-01', '2023-02-01'),
(2, 7, 'Book', '2023-01-01', '2023-02-01'),
(3, 14, 'Book', '2023-01-01', '2023-02-01'),
(4, 19, 'Book', '2023-01-01', '2023-02-01'),
(5, 2, 'CD', '2022-12-01', '2022-12-31'),
(6, 6, 'CD', '2022-12-01', '2022-12-31'),
(7, 26, 'CD', '2022-12-01', '2022-12-31'),
(8, 1, 'Game', '2023-01-15', '2023-03-15'),
(9, 19, 'Game', '2023-01-15', '2023-03-15'),
(10, 25, 'Game', '2023-01-15', '2023-03-15'),
(1, 5, 'Movie', "2023-01-01", "2023-02-01"),
(2, 6, 'Movie', "2023-01-01", "2023-02-01"),
(3, 15, 'Movie', "2023-01-01", "2023-02-01");


-- Add Views

CREATE VIEW `RentedView` AS SELECT title AS Loaned FROM `Book` WHERE available = 0 UNION SELECT title AS Loaned FROM `CompactDisk` WHERE available = 0 UNION SELECT title AS Loaned FROM `Game` WHERE available = 0 UNION SELECT title AS Loaned FROM `Movie` WHERE available = 0;

CREATE VIEW `Available` AS SELECT title, copy FROM `Book` WHERE available = 1 UNION SELECT title, copy FROM `CompactDisk` WHERE available = 1 UNION SELECT title, copy FROM `Game` WHERE available = 1 UNION SELECT title, copy FROM `Movie` WHERE available = 1;

CREATE VIEW `Lent` AS SELECT title, copy FROM `Book` WHERE available = 0 UNION SELECT title, copy FROM `CompactDisk` WHERE available = 0 UNION SELECT title, copy FROM `Game` WHERE available = 0 UNION SELECT title, copy FROM `Movie` WHERE available = 0;

CREATE VIEW `Total` AS SELECT SUM(price) AS amount FROM `Book` UNION SELECT SUM(price) AS amount FROM `CompactDisk` UNION SELECT SUM(price) AS amount FROM `Game` UNION SELECT SUM(price) AS amount FROM `Movie`;

CREATE VIEW `TotalPerType` AS SELECT 'Books' AS Type, SUM(price) AS amount FROM `Book` UNION SELECT 'CompactDisks' AS Type, SUM(price) AS amount FROM `CompactDisk` UNION SELECT 'Games' AS Type, SUM(price) AS amount FROM `Game` UNION SELECT 'Movies' AS Type, SUM(price) AS amount FROM `Movie`;

CREATE VIEW `TotalLibraryValue` AS SELECT CONCAT('Total library value: ', SUM(amount), ' SEK') AS `total` FROM `Total`;

CREATE VIEW `AvailableAmount` AS SELECT title, COUNT(title) AS amount FROM `Available` GROUP BY title;

CREATE VIEW `TableNames` AS SELECT TABLE_NAME AS 'Table' FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'The Library' AND TABLE_TYPE = 'BASE TABLE';

CREATE VIEW `MovieRuntime` AS SELECT DISTINCT title, runtime FROM `Movie`;

CREATE VIEW `CompactDiskTracks` AS SELECT DISTINCT title, tracks FROM `CompactDisk`;

CREATE VIEW `GameAgeRating` AS SELECT DISTINCT title, ageRating FROM `Game`;

CREATE VIEW `Leases` AS SELECT `User`.`username`, `Lending`.`Type`, `Lending`.`returnDate` FROM `User` INNER JOIN `Lending` ON `User`.`id` = `Lending`.`userID`;

CREATE VIEW `ExpiredLeases` AS SELECT * FROM `Leases` WHERE `returnDate` < CURDATE();

CREATE VIEW `Remainders` AS SELECT `ExpiredLeases`.`username`, `ExpiredLeases`.`Type`, `ExpiredLeases`.`returnDate`, `User`.`email`, `User`.`address` FROM `ExpiredLeases` INNER JOIN `User` ON `ExpiredLeases`.`username` = `User`.`username`;


