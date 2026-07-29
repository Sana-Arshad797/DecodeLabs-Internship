-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: banksystem
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `formno` varchar(30) DEFAULT NULL,
  `cardNum` varchar(30) DEFAULT NULL,
  `pinNum` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (' 2212','5636224488733166','1128'),(' 8090','2042540974795418','4372'),(' 4878','4302577380434682','1506'),('','9257176451224157','4307'),('','2507490899588944','1451'),(' 5892','1673827758290162','3802'),(' 2674','9167747941043030','4432'),(' 1020','7523170259101069','9853');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `formno` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `dob` varchar(30) DEFAULT NULL,
  `gender` varchar(30) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `marital` varchar(30) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `pincode` varchar(30) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES (' 6635','sana ','arshad','Sep 11, 2007','Female','sanaarshad@gmail.com','Unmarried','Lahore','Lahore','3478','Punjab'),(' 5406','Rana Arshad','M.Arshad','Aug 23, 2005','Female','ranasb123@gmail.com','Unmarried','TTS','TTS','4578','Punjab'),(' 2212','Asfia Arshad','Muhammad Arshad','Sep 22, 2002','Female','asfiaarshad@gmail.com','Unmarried','TTS','TTS','6786','Punjab'),(' 8090','Sana Arshad','Muhammad Arshad','Sep 11, 2007','Female','sana@gmail.com','Unmarried','TTS','TTS','5676','Punjab'),(' 4878','xyz','abc','May 18, 1988','Male','szff@yahoo.com','Other','sadgfgf','hyd','644','sindh'),(' 1514','hehe','haha','Jun 14, 2005','Male','hahahha@gmail.com','Married','nothing','nothinggg','4768','KPK'),(' 6356','SANA','ARSHAD','Sep 11, 2007','Female','sana@gmail.com','Unmarried','TTS','TTS','5687','Punjab'),(' 5892','no','nothing','Jun 24, 2007','Male','xyz@gmail.com','Married','lhr','lhr','6798','kpk'),(' 2674','John','James','Jun 10, 1996','Male','john@gmail.com','Married','Karachi','Karachi','5634','Sindh'),(' 1020','David','John','May 12, 1986','Male','david@gmail.com','Married','Karachi','Karachi','4587','Sindh');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signupthree`
--

DROP TABLE IF EXISTS `signupthree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signupthree` (
  `formno` varchar(30) DEFAULT NULL,
  `atype` varchar(50) DEFAULT NULL,
  `cardNum` varchar(50) DEFAULT NULL,
  `pinNum` varchar(50) DEFAULT NULL,
  `services` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signupthree`
--

LOCK TABLES `signupthree` WRITE;
/*!40000 ALTER TABLE `signupthree` DISABLE KEYS */;
INSERT INTO `signupthree` VALUES (' 2212','Current Account','5636224488733166','1128','ATM Card Internet Banking Mobile Banking SMS Alerts Cheque Book E-Statement '),(' 8090','Current Account','2042540974795418','4372','ATM Card Internet Banking Mobile Banking SMS Alerts E-Statement '),(' 4878','Current Account','4302577380434682','1506','ATM Card Internet Banking Mobile Banking SMS Alerts E-Statement '),('','Current Account','9257176451224157','4307','ATM Card SMS Alerts E-Statement '),('','Business Account','2507490899588944','1451','ATM Card E-Statement '),(' 5892','Savings Account','1673827758290162','3802','ATM Card Internet Banking Mobile Banking SMS Alerts Cheque Book E-Statement '),(' 2674','Current Account','9167747941043030','4432','ATM Card Internet Banking Mobile Banking Cheque Book E-Statement '),(' 1020','Current Account','7523170259101069','9853','ATM Card Internet Banking Mobile Banking Cheque Book E-Statement ');
/*!40000 ALTER TABLE `signupthree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signuptwo`
--

DROP TABLE IF EXISTS `signuptwo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signuptwo` (
  `formno` varchar(30) DEFAULT NULL,
  `income` varchar(30) DEFAULT NULL,
  `education` varchar(30) DEFAULT NULL,
  `occupation` varchar(30) DEFAULT NULL,
  `cnic` varchar(30) DEFAULT NULL,
  `senior` varchar(30) DEFAULT NULL,
  `existing` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signuptwo`
--

LOCK TABLES `signuptwo` WRITE;
/*!40000 ALTER TABLE `signuptwo` DISABLE KEYS */;
INSERT INTO `signuptwo` VALUES (' 6635','Salary','Graduate','Student','33346743898','No','Yes'),(' 5406','Business','Graduate','Business Owner','3330367238906','No','No'),(' 2212','Salary','Post Graduate','Salaried','4678067875674','No','No'),(' 8090','Other','Graduate','Student','3330367897658','No','No'),(' 4878','Other','Matric','Unemployed','12345566777899','Yes','No'),(' 6356','No Income','Intermediate','Student','3330378679870','No','No'),(' 5892','No Income','Matric','Student','576689698609709','Yes','No'),(' 2674','Business','Graduate','Business Owner','4356734655675','No','No'),(' 1020','Freelance','Post Graduate','Self Employed','5683467674537','Yes','No');
/*!40000 ALTER TABLE `signuptwo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `withdraw1`
--

DROP TABLE IF EXISTS `withdraw1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `withdraw1` (
  `pin` varchar(30) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `withdraw1`
--

LOCK TABLES `withdraw1` WRITE;
/*!40000 ALTER TABLE `withdraw1` DISABLE KEYS */;
INSERT INTO `withdraw1` VALUES ('1128','Fri Jun 26 20:55:40 PKT 2026','Deposit','20000'),('4372','Fri Jun 26 21:03:11 PKT 2026','Deposit','20000000'),('4372','Fri Jun 26 21:04:50 PKT 2026','Withdrawl','5000'),('4372','Fri Jun 26 21:08:27 PKT 2026','Withdrawl','2000'),('4372','Fri Jun 26 21:08:43 PKT 2026','Deposit','500'),('4372','Fri Jun 26 21:16:24 PKT 2026','Withdrawl','5000'),('4372','Fri Jun 26 21:17:04 PKT 2026','Withdrawl','20000'),('4372','Fri Jun 26 21:17:15 PKT 2026','Withdrawl','5000'),('4372','Fri Jun 26 21:17:30 PKT 2026','Deposit','4500'),('4372','Fri Jun 26 21:17:37 PKT 2026','Withdrawl','2000'),('1506','Fri Jun 26 21:22:37 PKT 2026','Deposit','20'),('1506','Fri Jun 26 21:25:13 PKT 2026','Withdrawl','2'),('1506','Fri Jun 26 21:25:52 PKT 2026','Deposit','100000000'),('1506','Fri Jun 26 21:26:07 PKT 2026','Withdrawl','10000'),('1506','Sat Jun 27 12:16:29 PKT 2026','Deposit','20000'),('1506','Sat Jun 27 12:17:17 PKT 2026','Withdrawl','100'),('1506','Sat Jun 27 12:25:07 PKT 2026','Withdrawal','100'),('1451','Sun Jun 28 00:29:24 PKT 2026','Deposit','200'),('4432','Sun Jun 28 01:26:34 PKT 2026','Deposit','35000'),('4432','Sun Jun 28 01:26:46 PKT 2026','Withdrawal','500'),('4432','Sun Jun 28 01:27:04 PKT 2026','Withdrawl','7500'),('4432','Sun Jun 28 01:27:19 PKT 2026','Withdrawl','25000'),('9853','Sun Jun 28 01:31:22 PKT 2026','Deposit','4500'),('9853','Sun Jun 28 01:31:37 PKT 2026','Withdrawl','200'),('9853','Sun Jun 28 01:31:50 PKT 2026','Withdrawal','2000'),('9853','Sun Jun 28 01:34:24 PKT 2026','Deposit','5400');
/*!40000 ALTER TABLE `withdraw1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `withdrawl`
--

DROP TABLE IF EXISTS `withdrawl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `withdrawl` (
  `pin` varchar(30) DEFAULT NULL,
  `date` varchar(50) DEFAULT NULL,
  `amount` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `withdrawl`
--

LOCK TABLES `withdrawl` WRITE;
/*!40000 ALTER TABLE `withdrawl` DISABLE KEYS */;
/*!40000 ALTER TABLE `withdrawl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-28  1:55:56
