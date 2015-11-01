-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 01, 2015 at 11:55 AM
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
  `retired` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `department`, `mobile`, `name`, `retired`) VALUES
(1, 'Promotions', 'aa', 'aaa', b'1'),
(2, 'Administration', '1111', 'Safrin', b'1'),
(3, 'Administration', '71', 'safr', b'1'),
(4, 'Administration', '12111', 'Tse333', b'1'),
(5, 'Administration', '1', 'saa', b'1'),
(6, 'Promotions', '23', 'ddd', b'1'),
(7, 'Administration', '4', '33543', b'1'),
(8, 'Promotions', '379', 'safri', b'0'),
(9, 'Administration', '32', 'sfdfq', b'0'),
(10, 'Sales', '5454', 'saff', b'0'),
(11, 'Administration', 'dddd555', 'dd', b'0'),
(12, 'Promotions', '2321111', 'sas', b'0'),
(13, 'Administration', 'dddr541', 'ddd', b'0'),
(14, 'Administration', 'ss', 'ss', b'0'),
(15, 'Administration', 'dsds', 'dsf', b'0'),
(16, 'Sales', 'asa', 'sas', b'0'),
(100, 'Promotions', '1111', '1sas', b'0');

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
IF (NEW.retired= OLD.retired) THEN
        INSERT INTO log 
            (`customerid`,`type` , `date`) 
        VALUES 
            (NEW.id,'updated', NOW());   
END IF;
IF (NEW.retired!= OLD.retired) THEN
        INSERT INTO log 
            (`customerid`,`type` , `date`) 
        VALUES 
            (NEW.id,'deleted', NOW());   
END IF;
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `type`, `customerid`, `date`) VALUES
(11, 'deleted', '7', '2015-11-01 17:24:46');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
