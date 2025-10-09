-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: student_management_db
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
use student_management_db;
--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS `departments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departments` (
  `dept_id` int NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(100) NOT NULL,
  `dept_code` varchar(10) NOT NULL,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `dept_name` (`dept_name`),
  UNIQUE KEY `dept_code` (`dept_code`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departments`
--

LOCK TABLES `departments` WRITE;
/*!40000 ALTER TABLE `departments` DISABLE KEYS */;
INSERT INTO `departments` VALUES (1,'Computer Science','CS'),(2,'Electrical Engineering','EE'),(3,'Mechanical Engineering','ME'),(4,'Civil Engineering','CE'),(5,'Business Administration','BA'),(6,'Data Science','DS'),(7,'Telecomunication','TC');
/*!40000 ALTER TABLE `departments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `age` int NOT NULL,
  `cnic` varchar(15) NOT NULL,
  `roll_number` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` enum('Male','Female','Other') NOT NULL,
  `dept_id` int NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `cnic` (`cnic`),
  UNIQUE KEY `roll_number` (`roll_number`),
  UNIQUE KEY `email` (`email`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `departments` (`dept_id`),
  CONSTRAINT `students_chk_1` CHECK (((`age` >= 16) and (`age` <= 60)))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'Ali Ahmed',20,'42101-1234567-1','CS-2023-001','ali.ahmed@university.edu','Male',1),(2,'Fatima Khan',21,'42101-2345678-2','EE-2023-002','fatima.khan@university.edu','Female',2),(3,'Usman Malik',22,'42101-3456789-3','ME-2023-003','usman.malik@university.edu','Male',3),(4,'Ayesha Raza',19,'42101-4567890-4','CE-2023-004','ayesha.raza@university.edu','Female',4),(5,'Bilal Hassan',20,'42101-5678901-5','BA-2023-005','bilal.hassan@university.edu','Male',5),(6,'wajid Hussain',21,'1383-7828872-9','133sw23','wajid@email.com','Male',2),(10,'wajid',22,'9831-123921-6','473muet7','wajid12@gmail.com','Male',5),(11,'jameel',25,'47392-09832-0','8768','jamel@gmail.com','Male',2),(12,'Shahid Hussain',30,'265351-215622-8','14se74','shad@gmail.com','Male',6),(14,'Wajid Hussain',20,'0418962349','134swew3','wajid23242@gmail.com','Male',6);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-23  0:07:17
