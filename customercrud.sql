-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 01, 2015 at 04:41 PM
-- Server version: 5.5.20
-- PHP Version: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `customercrud`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL,
  `department` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `department`, `mobile`, `name`) VALUES
(5, 'Administration', '1', 'saa'),
(6, 'Promotions', '23', 'ddd'),
(7, 'Administration', '4', '33543'),
(8, 'Promotions', '379', 'safri'),
(9, 'Administration', '32', 'sfdfq'),
(10, 'Engineering', '5454', 'saff'),
(11, 'Administration', 'dddd555', 'dd'),
(12, 'Promotions', '2321111', 'sas'),
(13, 'Administration', 'dddr541', 'ddd'),
(14, 'Administration', 'ss', 'ss'),
(15, 'Administration', 'dsds', 'dsf'),
(16, 'Sales', 'asa', 'sas'),
(100, 'Promotions', '1111', '1sas');

--
-- Triggers `customer`
--
DROP TRIGGER IF EXISTS `insert_log`;
DELIMITER //
CREATE TRIGGER `insert_log` AFTER INSERT ON `customer`
 FOR EACH ROW BEGIN  
        INSERT INTO log 
            (`customerid`,`type` , `date`) 
        VALUES 
            (NEW.id,'added', NOW());   
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `update_log`;
DELIMITER //
CREATE TRIGGER `update_log` AFTER UPDATE ON `customer`
 FOR EACH ROW BEGIN  
        INSERT INTO log 
            (`customerid`,`type` , `date`) 
        VALUES 
            (NEW.id,'updated', NOW());  
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `delete_log`;
DELIMITER //
CREATE TRIGGER `delete_log` AFTER DELETE ON `customer`
 FOR EACH ROW BEGIN  
        INSERT INTO log 
            (`customerid`,`type` , `date`) 
        VALUES 
            (OLD.id,'deleted', NOW());   

END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  `customerid` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `type`, `customerid`, `date`) VALUES
(11, 'deleted', '7', '2015-11-01 17:24:46'),
(12, 'deleted', '100', '2015-11-01 17:56:21'),
(13, 'deleted', '16', '2015-11-01 17:56:24'),
(14, 'updated', '10', '2015-11-01 17:56:46'),
(15, 'updated', '3', '2015-11-01 21:48:55'),
(16, 'updated', '3', '2015-11-01 21:49:08'),
(17, 'updated', '4', '2015-11-01 21:50:44');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
