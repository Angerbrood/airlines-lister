-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table elte-airlines.airline: ~0 rows (approximately)
/*!40000 ALTER TABLE `airline` DISABLE KEYS */;
INSERT INTO `airline` (`AIRLINE_ID`, `ALIRLINE_NAME`) VALUES
	(1, 'Malev');
/*!40000 ALTER TABLE `airline` ENABLE KEYS */;

-- Dumping data for table elte-airlines.airline_flight: ~0 rows (approximately)
/*!40000 ALTER TABLE `airline_flight` DISABLE KEYS */;
INSERT INTO `airline_flight` (`Airline_AIRLINE_ID`, `flights_id`) VALUES
	(1, 1),
	(1, 2);
/*!40000 ALTER TABLE `airline_flight` ENABLE KEYS */;

-- Dumping data for table elte-airlines.app_user: ~0 rows (approximately)
/*!40000 ALTER TABLE `app_user` DISABLE KEYS */;
INSERT INTO `app_user` (`id`, `PASSWORD`, `SSO_ID`, `userPassengerData_id`) VALUES
	(1, 'petz', 'david', 1),
	(2, 'sinkovics', 'viki', 2),
	(3, 'cartman', 'eric', 3);
/*!40000 ALTER TABLE `app_user` ENABLE KEYS */;

-- Dumping data for table elte-airlines.app_user_user_profile: ~0 rows (approximately)
/*!40000 ALTER TABLE `app_user_user_profile` DISABLE KEYS */;
INSERT INTO `app_user_user_profile` (`USER_ID`, `USER_PROFILE_ID`) VALUES
	(1, 1),
	(2, 1),
	(1, 2),
	(2, 2),
	(3, 2);
/*!40000 ALTER TABLE `app_user_user_profile` ENABLE KEYS */;

-- Dumping data for table elte-airlines.flight: ~0 rows (approximately)
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` (`id`, `flightNumber`, `landingDate`, `startDate`, `ticketPrice`, `travelTime`, `destination_id`, `start_id`) VALUES
	(1, '12', '2017-12-11', '2017-12-10', 10000, 1000, 3, 2),
	(2, '13', '2017-12-10', '2017-12-10', 1000, 100, 2, 1);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;

-- Dumping data for table elte-airlines.flight_passenger: ~0 rows (approximately)
/*!40000 ALTER TABLE `flight_passenger` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_passenger` ENABLE KEYS */;

-- Dumping data for table elte-airlines.hibernate_sequence: ~4 rows (approximately)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(1),
	(1),
	(1),
	(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping data for table elte-airlines.location: ~0 rows (approximately)
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `country`, `name`) VALUES
	(1, 'Hungary', 'Budapest'),
	(2, 'United Kingdom', 'London'),
	(3, 'United States of America', 'New York');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

-- Dumping data for table elte-airlines.passenger: ~0 rows (approximately)
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` (`id`, `ACCOUNT_NUMBER`, `ADDRESS`, `AGE`, `BALANCE`, `DATE_OF_BIRTH`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`) VALUES
	(1, '1111', 'Budapest', 22, 1000, '1995-09-29', 'petzdavid@gmail.com', 'David', 'Petz'),
	(2, '2222', 'Budapest', 22, 2000, '1995-01-01', 'viki@viki.hu', 'Viktoria', 'Sinkovics'),
	(3, '3333', 'South Park', 20, 5000, '1997-08-13', 'eric.carman@southpark.com', 'Eric', 'Cartman');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;

-- Dumping data for table elte-airlines.persistent_logins: ~0 rows (approximately)
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;

-- Dumping data for table elte-airlines.user_profile: ~0 rows (approximately)
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`, `TYPE`) VALUES
	(1, 'ADMIN'),
	(2, 'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
