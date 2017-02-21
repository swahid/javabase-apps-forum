-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema forum
--

CREATE DATABASE IF NOT EXISTS forum;
USE forum;

--
-- Definition of table `comment`
--

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL auto_increment,
  `comment_description` varchar(255) NOT NULL,
  `comment_flag` varchar(10) default NULL,
  `comment_title` varchar(100) NOT NULL,
  `create_date` datetime default NULL,
  `create_user` varchar(30) default NULL,
  `update_date` datetime default NULL,
  `update_user` varchar(45) default NULL,
  `thread_id` int(11) NOT NULL,
  PRIMARY KEY  (`comment_id`),
  KEY `FK_nt0ldu5pkawp6ry4976ddapb6` (`thread_id`),
  CONSTRAINT `FK_nt0ldu5pkawp6ry4976ddapb6` FOREIGN KEY (`thread_id`) REFERENCES `thread` (`thread_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;


--
-- Definition of table `thread`
--

DROP TABLE IF EXISTS `thread`;
CREATE TABLE `thread` (
  `thread_id` int(11) NOT NULL auto_increment,
  `create_date` datetime default NULL,
  `create_user` varchar(45) default NULL,
  `thread_description` longtext NOT NULL,
  `thread_flag` varchar(10) default NULL,
  `thread_image` varchar(50) default NULL,
  `thread_title` varchar(100) default NULL,
  `update_date` datetime default NULL,
  `update_user` varchar(45) default NULL,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`thread_id`),
  KEY `FK_ono187ut9v1pay3iby5712kbr` (`topic_id`),
  KEY `FK_979cq0kryuidamlp1c7v1tn09` (`user_id`),
  CONSTRAINT `FK_979cq0kryuidamlp1c7v1tn09` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_ono187ut9v1pay3iby5712kbr` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `thread`
--

/*!40000 ALTER TABLE `thread` DISABLE KEYS */;
/*!40000 ALTER TABLE `thread` ENABLE KEYS */;


--
-- Definition of table `topic`
--

DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL auto_increment,
  `create_date` datetime default NULL,
  `create_user` varchar(50) default NULL,
  `topic_description` varchar(255) default NULL,
  `topic_flag` varchar(10) default NULL,
  `topic_image` varchar(50) default NULL,
  `topic_name` varchar(50) NOT NULL,
  `update_date` datetime default NULL,
  `update_user` varchar(50) default NULL,
  PRIMARY KEY  (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `topic`
--

/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL auto_increment,
  `account_active` bit(1) default NULL,
  `expire_date` datetime default NULL,
  `first_name` varchar(45) default NULL,
  `last_name` varchar(45) default NULL,
  `non_expired` bit(1) default NULL,
  `non_locked` bit(1) default NULL,
  `password` varchar(200) NOT NULL,
  `registration_date` datetime default NULL,
  `user_email` varchar(45) default NULL,
  `user_image` varchar(45) default NULL,
  `user_phone` varchar(45) default NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
