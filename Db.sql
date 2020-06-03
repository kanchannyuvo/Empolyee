-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.17 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for projects
CREATE DATABASE IF NOT EXISTS `projects` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projects`;

-- Dumping structure for table projects.division
CREATE TABLE IF NOT EXISTS `division` (
  `division_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `business` varchar(100) DEFAULT NULL,
  `head_id` int(11) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`division_id`),
  KEY `FKmavx0dt5xk3y82go3j7cqv65w` (`head_id`),
  CONSTRAINT `FKmavx0dt5xk3y82go3j7cqv65w` FOREIGN KEY (`head_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Employee Division';

-- Dumping data for table projects.division: ~0 rows (approximately)
DELETE FROM `division`;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` (`division_id`, `name`, `business`, `head_id`, `creation_date`) VALUES
	(1, 'Head', 'Head', 0, '2020-06-02 17:51:35'),
	(9, 'Tech', 'Technology', 8, '2020-06-02 10:27:36'),
	(11, 'Ops', 'Operation', 10, '2020-06-02 10:34:44'),
	(15, 'product', 'Product', 14, '2020-06-02 10:56:43'),
	(16, 'Business', 'Business', 14, '2020-06-02 10:58:11'),
	(20, 'Compliance', 'Compliance', 14, '2020-06-02 11:00:25'),
	(29, 'HR', 'Human Resource', 28, '2020-06-02 18:45:48'),
	(47, 'TestDivision', 'Testbuzz', 46, '2020-06-03 10:10:24'),
	(50, 'TestDivision0.30983851570668985', 'Testbuzz0.23011714798782001', 49, '2020-06-03 10:13:08'),
	(53, 'TestDivision0.4879939200631024', 'Testbuzz0.25147500354740393', 52, '2020-06-03 10:15:37'),
	(56, 'TestDivision0.30118546757813613', 'Testbuzz0.20433736330942653', 55, '2020-06-03 10:20:13'),
	(59, 'TestDivision0.825304169611973', 'Testbuzz0.09103471946482922', 58, '2020-06-03 10:28:24'),
	(62, 'TestDivision0.42573464713752995', 'Testbuzz0.49046527350523417', 61, '2020-06-03 10:32:57'),
	(65, 'TestDivision0.9817137280806574', 'Testbuzz0.6663902448670251', 64, '2020-06-03 10:39:32'),
	(68, 'TestDivision0.6432387126443444', 'Testbuzz0.5569088200145981', 67, '2020-06-03 10:46:29'),
	(71, 'TestDivision0.9622584647688325', 'Testbuzz0.19826652102167208', 70, '2020-06-03 10:48:20'),
	(74, 'TestDivision0.7418875148115622', 'Testbuzz0.3461742585462855', 73, '2020-06-03 10:50:19'),
	(77, 'TestDivision0.08730451750968937', 'Testbuzz0.4307714861005104', 76, '2020-06-03 10:52:38');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;

-- Dumping structure for table projects.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(100) DEFAULT NULL,
  `division_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT '0',
  `bank_acc_name` varchar(50) DEFAULT NULL,
  `salary` decimal(10,0) DEFAULT NULL,
  `creation_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`),
  KEY `FK_employee_division` (`division_id`),
  KEY `FKou6wbxug1d0qf9mabut3xqblo` (`manager_id`),
  CONSTRAINT `FK_employee_division` FOREIGN KEY (`division_id`) REFERENCES `division` (`division_id`),
  CONSTRAINT `FKou6wbxug1d0qf9mabut3xqblo` FOREIGN KEY (`manager_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table projects.employee: ~0 rows (approximately)
DELETE FROM `employee`;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`emp_id`, `emp_name`, `division_id`, `manager_id`, `bank_acc_name`, `salary`, `creation_date`) VALUES
	(0, 'CEO', 1, 0, 'testBank', 1000, '2020-06-02 10:17:20'),
	(8, 'Rana Rai', 9, 0, NULL, NULL, '2020-06-02 10:27:36'),
	(10, 'Rajesh', 11, 0, NULL, NULL, '2020-06-02 10:34:43'),
	(14, 'Achal Shah', 15, 0, NULL, NULL, '2020-06-02 10:56:43'),
	(21, 'Ajay', 9, 8, 'Test', 100000, '2020-06-02 11:31:01'),
	(22, 'Suraj', 9, 8, 'Test', 100000, '2020-06-02 11:31:33'),
	(23, 'Kanchan', 9, 22, 'Test', NULL, '2020-06-02 11:33:28'),
	(24, 'Ram', 9, 22, 'string', NULL, '2020-06-02 11:33:57'),
	(25, 'Raj', 9, 21, 'string', 100000, '2020-06-02 11:34:53'),
	(26, 'Rinku', 9, 21, 'string', 100000, '2020-06-02 11:37:39'),
	(27, 'Nita', 9, 21, 'string', 100000, '2020-06-02 11:38:18'),
	(28, 'Yash', 29, 0, NULL, NULL, '2020-06-02 18:45:48'),
	(30, 'Rohit', 29, 28, 'Rohit Test', 10000, '2020-06-02 18:47:24'),
	(31, 'Rohan', 29, 30, 'Rohit Test', 10000, '2020-06-02 18:48:17'),
	(32, 'Raj', 29, 30, 'Rohit Test', 10000, '2020-06-02 18:48:26'),
	(33, 'Jay', 29, 30, 'Rohit Test', 10000, '2020-06-02 18:48:44'),
	(46, 'TestHead', 47, 0, NULL, NULL, '2020-06-03 10:10:24'),
	(48, 'Kanchan', 29, 28, 'Test Bank', 100000, '2020-06-03 10:10:25'),
	(49, 'TestHead0.25324328940025254', 50, 0, NULL, NULL, '2020-06-03 10:13:07'),
	(51, 'Kanchan0.3367293355077803', 29, 28, 'Test Bank', 100000, '2020-06-03 10:13:08'),
	(52, 'TestHead0.5108771887716256', 53, 0, NULL, NULL, '2020-06-03 10:15:37'),
	(54, 'Kanchan0.0014886504849815907', 29, 28, 'Test Bank', 100000, '2020-06-03 10:15:37'),
	(55, 'TestHead0.22740630058495215', 56, 0, NULL, NULL, '2020-06-03 10:20:13'),
	(57, 'Kanchan0.9392326586304149', 29, 28, 'Test Bank', 100000, '2020-06-03 10:20:13'),
	(58, 'TestHead0.21770645963927238', 59, 0, NULL, NULL, '2020-06-03 10:28:24'),
	(60, 'Kanchan0.11047723880262939', 29, 28, 'Test Bank', 100000, '2020-06-03 10:28:25'),
	(61, 'TestHead0.8990531566785687', 62, 0, NULL, NULL, '2020-06-03 10:32:57'),
	(63, 'Kanchan0.19355039717456568', 29, 28, 'Test Bank', 100000, '2020-06-03 10:32:57'),
	(64, 'TestHead0.10202251974269616', 65, 0, NULL, NULL, '2020-06-03 10:39:32'),
	(66, 'Kanchan0.13610944810611225', 29, 28, 'Test Bank', 100000, '2020-06-03 10:39:33'),
	(67, 'TestHead0.01529281700373597', 68, 0, NULL, NULL, '2020-06-03 10:46:29'),
	(69, 'Kanchan0.423462989551184', 29, 28, 'Test Bank', 100000, '2020-06-03 10:46:30'),
	(70, 'TestHead0.8391608858583286', 71, 0, NULL, NULL, '2020-06-03 10:48:20'),
	(72, 'Kanchan0.9031862374014418', 29, 28, 'Test Bank', 100000, '2020-06-03 10:48:21'),
	(73, 'TestHead0.7802800675080142', 74, 0, NULL, NULL, '2020-06-03 10:50:19'),
	(75, 'Kanchan0.4733441792870209', 29, 28, 'Test Bank', 100000, '2020-06-03 10:50:19'),
	(76, 'TestHead0.7799320557817642', 77, 0, NULL, NULL, '2020-06-03 10:52:37'),
	(78, 'Kanchan0.8647848114085507', 29, 28, 'Test Bank', 100000, '2020-06-03 10:52:38');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table projects.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table projects.hibernate_sequence: 2 rows
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(79),
	(79);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
