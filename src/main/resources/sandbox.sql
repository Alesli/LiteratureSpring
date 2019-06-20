-- Adminer 4.6.3 MySQL dump

SET NAMES utf8;
SET foreign_key_checks = 0;

DROP DATABASE IF EXISTS `library`;
CREATE DATABASE `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `author_book`;
CREATE TABLE `author_book` (
  `author_id` bigint(20) NOT NULL,
  `book_id` bigint(20) NOT NULL,
  KEY `fk_author_to_book` (`author_id`),
  KEY `fk_book_to_author` (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `genre_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `date_creation` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_genre` (`genre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `genre`;
CREATE TABLE `genre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `genre` (`id`, `name`) VALUES
(1,	'IT'),
(2,	'Фантастика');

INSERT INTO `author` (`id`, `name`, `last_name`) VALUES
(1,	'Andrew',	'Norton'),
(2,	'Harry',	'Harrison');

INSERT INTO `book` (`id`, `genre_id`, `name`, `description`, `date_creation`) VALUES
(1,	2,	'Queen of Sun',	'Book about space ships',	2018),
(2,	2,	'Witches time',	'Witches, sorcerers, medieval, castles, wars, etc. etc.',	2018),
(3,	2,	'Ethical engineer',	'Книга про непримеримую войну долбозавра и норм поцана, I recommend it',	2018);

INSERT INTO `author_book` (`author_id`, `book_id`) VALUES
(1,	1),
(1,	2),
(2,	3);

SET foreign_key_checks = 1;

-- 2018-11-12 11:15:42