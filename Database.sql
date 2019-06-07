-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: aquadis
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `attendeekoppel`
--

DROP TABLE IF EXISTS `attendeekoppel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendeekoppel` (
  `KoppelID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `EventID` int(11) NOT NULL,
  `userOrder` longtext,
  PRIMARY KEY (`KoppelID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendeekoppel`
--

LOCK TABLES `attendeekoppel` WRITE;
/*!40000 ALTER TABLE `attendeekoppel` DISABLE KEYS */;
INSERT INTO `attendeekoppel` VALUES (37,13,80,'...');
/*!40000 ALTER TABLE `attendeekoppel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dish` (
  `DishID` int(11) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Price` double DEFAULT NULL,
  PRIMARY KEY (`DishID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dishkoppel`
--

DROP TABLE IF EXISTS `dishkoppel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dishkoppel` (
  `RestaurantID` int(11) NOT NULL,
  `DishID` int(11) NOT NULL,
  PRIMARY KEY (`RestaurantID`,`DishID`),
  KEY `fk_Restaurant_has_Dish_Dish1_idx` (`DishID`),
  KEY `fk_Restaurant_has_Dish_Restaurant1_idx` (`RestaurantID`),
  CONSTRAINT `fk_Restaurant_has_Dish_Dish1` FOREIGN KEY (`DishID`) REFERENCES `dish` (`DishID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Restaurant_has_Dish_Restaurant1` FOREIGN KEY (`RestaurantID`) REFERENCES `restaurant` (`RestaurantID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dishkoppel`
--

LOCK TABLES `dishkoppel` WRITE;
/*!40000 ALTER TABLE `dishkoppel` DISABLE KEYS */;
/*!40000 ALTER TABLE `dishkoppel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `EventID` int(11) NOT NULL AUTO_INCREMENT,
  `EventDate` date DEFAULT NULL,
  `Descr` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `RestaurantID` int(11) DEFAULT NULL,
  `ManagerID` int(11) DEFAULT NULL,
  PRIMARY KEY (`EventID`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (80,'2019-06-21','description','VeganDay',22,13);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `RestaurantID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RestaurantID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (22,'Veganbar','healtyfood@veganbar.com','Vegan','Nice and healty food');
INSERT INTO `restaurant` VALUES (23,'kfc','info@kfc.com','Fastfood','Tasty chicken');
INSERT INTO `restaurant` VALUES (24,'italianpizza','info@italianpizza.com','Italian','Nice italian pizza');
INSERT INTO `restaurant` VALUES (25,'burgerking','info@burgerking.com','FastFood','A nice tasty burger');
INSERT INTO `restaurant` VALUES (26,'spanishbar','info@spanishbar.com','Spanish','Get nice gyros');
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Avatar` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Firstname` varchar(45) DEFAULT NULL,
  `Notifications` int(11) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Surname` varchar(45) DEFAULT NULL,
  `Role` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (13,NULL,'wouterverdegaal@aquadis.com','Wouter',0,'VGVzdHRlc3QxIQ==','Verdegaal',NULL),(14,NULL,'artjom@aquadis.com','Artjom',0,'VGVzdHRlc3QxIQ==','Cubleac',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-07 18:56:28
