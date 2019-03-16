-- MySQL dump 10.13  Distrib 5.5.27, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.5.27

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
-- Table structure for table `army_info`
--

DROP TABLE IF EXISTS `army_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `army_info` (
  `army_id` int(11) NOT NULL AUTO_INCREMENT,
  `platoon_id` int(11) DEFAULT NULL,
  `army_name` varchar(32) NOT NULL,
  `army_people` int(11) DEFAULT NULL,
  PRIMARY KEY (`army_id`),
  KEY `platoon_id` (`platoon_id`),
  CONSTRAINT `army_info_ibfk_1` FOREIGN KEY (`platoon_id`) REFERENCES `platoon_info` (`platoon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `army_info`
--

LOCK TABLES `army_info` WRITE;
/*!40000 ALTER TABLE `army_info` DISABLE KEYS */;
INSERT INTO `army_info` VALUES (1,1,'一营',1000),(2,1,'二营',1000),(3,1,'三营',1000),(4,2,'一营',1100),(5,2,'二营',1010),(6,2,'三营',1010);
/*!40000 ALTER TABLE `army_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_info`
--

DROP TABLE IF EXISTS `category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_info` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) NOT NULL,
  `category_type` varchar(16) NOT NULL,
  `category_unit` varchar(16) NOT NULL,
  `category_comment` varchar(255) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_info`
--

LOCK TABLES `category_info` WRITE;
/*!40000 ALTER TABLE `category_info` DISABLE KEYS */;
INSERT INTO `category_info` VALUES (1,'保障类','protect','辆','保障装备'),(2,'维修类','repair','辆','维修装备'),(3,'备件类','spare','辆','装备备件'),(4,'测试类','test','辆','测试弹筒'),(5,'运输类','transport','辆','运输设备'),(6,'作战类','action','辆','作战装备');
/*!40000 ALTER TABLE `category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department_info`
--

DROP TABLE IF EXISTS `department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department_info` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(32) NOT NULL,
  `people_max_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department_info`
--

LOCK TABLES `department_info` WRITE;
/*!40000 ALTER TABLE `department_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `department_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element_info`
--

DROP TABLE IF EXISTS `element_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `element_info` (
  `element_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `element_name` varchar(32) DEFAULT NULL,
  `element_type` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`element_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `element_info_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_info` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element_info`
--

LOCK TABLES `element_info` WRITE;
/*!40000 ALTER TABLE `element_info` DISABLE KEYS */;
INSERT INTO `element_info` VALUES (1,6,'支腿','1'),(2,6,'发射架','1'),(3,6,'轮胎','1');
/*!40000 ALTER TABLE `element_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `element_maintain_info`
--

DROP TABLE IF EXISTS `element_maintain_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `element_maintain_info` (
  `element_maintain_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_element_id` int(11) DEFAULT NULL,
  `spare_part_id` int(11) DEFAULT NULL,
  `maintain_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `malfunction_description` varchar(2048) DEFAULT NULL,
  `reason_description` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`element_maintain_id`),
  KEY `equipment_element_id` (`equipment_element_id`),
  KEY `spare_part_id` (`spare_part_id`),
  CONSTRAINT `element_maintain_info_ibfk_1` FOREIGN KEY (`equipment_element_id`) REFERENCES `equipment_element_info` (`equipment_element_id`),
  CONSTRAINT `element_maintain_info_ibfk_2` FOREIGN KEY (`spare_part_id`) REFERENCES `spare_part_info` (`spare_part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `element_maintain_info`
--

LOCK TABLES `element_maintain_info` WRITE;
/*!40000 ALTER TABLE `element_maintain_info` DISABLE KEYS */;
INSERT INTO `element_maintain_info` VALUES (1,1,1,'2018-02-02 16:00:00','不平衡','支腿损坏');
/*!40000 ALTER TABLE `element_maintain_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `environment_info`
--

DROP TABLE IF EXISTS `environment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `environment_info` (
  `environment_id` int(11) NOT NULL AUTO_INCREMENT,
  `location_id` int(11) NOT NULL,
  `month_time` int(11) NOT NULL,
  `temperature` decimal(8,2) NOT NULL,
  `rainfall` decimal(8,2) NOT NULL,
  `snowfall` decimal(8,2) NOT NULL,
  `sunshine` decimal(8,2) NOT NULL,
  `wind_level` decimal(8,2) NOT NULL,
  `pressure` decimal(8,2) NOT NULL,
  `corrosion` decimal(8,2) NOT NULL,
  PRIMARY KEY (`environment_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `environment_info_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location_info` (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `environment_info`
--

LOCK TABLES `environment_info` WRITE;
/*!40000 ALTER TABLE `environment_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `environment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_element_info`
--

DROP TABLE IF EXISTS `equipment_element_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_element_info` (
  `equipment_element_id` int(11) NOT NULL AUTO_INCREMENT,
  `equipment_id` int(11) DEFAULT NULL,
  `element_id` int(11) DEFAULT NULL,
  `work_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`equipment_element_id`),
  KEY `equipment_id` (`equipment_id`),
  KEY `element_id` (`element_id`),
  CONSTRAINT `equipment_element_info_ibfk_1` FOREIGN KEY (`equipment_id`) REFERENCES `equipment_info` (`equipment_id`),
  CONSTRAINT `equipment_element_info_ibfk_2` FOREIGN KEY (`element_id`) REFERENCES `element_info` (`element_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_element_info`
--

LOCK TABLES `equipment_element_info` WRITE;
/*!40000 ALTER TABLE `equipment_element_info` DISABLE KEYS */;
INSERT INTO `equipment_element_info` VALUES (1,1,1,100),(2,1,2,100),(3,1,3,100);
/*!40000 ALTER TABLE `equipment_element_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment_info`
--

DROP TABLE IF EXISTS `equipment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment_info` (
  `equipment_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `equipment_name` varchar(32) NOT NULL,
  `equipment_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `army_id` int(11) NOT NULL,
  `platoon_id` int(11) NOT NULL,
  PRIMARY KEY (`equipment_id`),
  KEY `category_id` (`category_id`),
  KEY `army_id` (`army_id`),
  CONSTRAINT `equipment_info_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_info` (`category_id`),
  CONSTRAINT `equipment_info_ibfk_2` FOREIGN KEY (`army_id`) REFERENCES `army_info` (`army_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment_info`
--

LOCK TABLES `equipment_info` WRITE;
/*!40000 ALTER TABLE `equipment_info` DISABLE KEYS */;
INSERT INTO `equipment_info` VALUES (1,6,'筒弹','2019-03-15 15:08:17',1,1),(2,6,'红缨六发射','2019-03-15 15:11:08',2,1),(3,6,'红缨六导弹','2019-03-15 15:08:17',1,1),(4,1,'指挥车','2019-03-15 15:10:12',2,1),(5,1,'机械维修车','2019-03-15 15:10:12',2,1),(6,2,'100M示波器','2019-03-15 15:10:12',3,1),(7,2,'微波频率计数器','2019-03-15 15:11:08',1,1),(8,3,'机械备件车','2019-03-15 15:17:27',2,1),(9,3,'电子备件车','2019-03-15 15:11:08',3,1),(10,4,'便携式防空导弹检测车','2019-03-15 15:11:08',1,1),(11,4,'筒弹测试车','2019-03-15 15:11:08',2,1),(12,4,'雷达测试仪','2019-03-15 15:11:08',3,1),(13,5,'50KW工频电源车','2019-03-15 15:11:08',1,1),(14,5,'运输车','2019-03-15 15:11:08',2,1),(15,5,'野战器材储运车','2019-03-15 15:11:08',3,1);
/*!40000 ALTER TABLE `equipment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_info`
--

DROP TABLE IF EXISTS `group_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_info` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `scheme_id` int(11) NOT NULL,
  `group_name` varchar(32) NOT NULL,
  `group_type` varchar(32) NOT NULL,
  PRIMARY KEY (`group_id`),
  KEY `scheme_id` (`scheme_id`),
  CONSTRAINT `group_info_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `scheme_info` (`scheme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_info`
--

LOCK TABLES `group_info` WRITE;
/*!40000 ALTER TABLE `group_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location_info`
--

DROP TABLE IF EXISTS `location_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location_info` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `longitude` decimal(8,3) NOT NULL,
  `latitude` decimal(8,3) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location_info`
--

LOCK TABLES `location_info` WRITE;
/*!40000 ALTER TABLE `location_info` DISABLE KEYS */;
INSERT INTO `location_info` VALUES (1,90.500,30.300),(2,91.500,29.300),(3,89.000,39.000),(4,89.000,29.000),(5,116.000,29.000),(6,89.000,13.000);
/*!40000 ALTER TABLE `location_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platoon_info`
--

DROP TABLE IF EXISTS `platoon_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platoon_info` (
  `platoon_id` int(11) NOT NULL AUTO_INCREMENT,
  `platoon_name` varchar(32) NOT NULL,
  PRIMARY KEY (`platoon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platoon_info`
--

LOCK TABLES `platoon_info` WRITE;
/*!40000 ALTER TABLE `platoon_info` DISABLE KEYS */;
INSERT INTO `platoon_info` VALUES (1,'1旅'),(2,'2旅');
/*!40000 ALTER TABLE `platoon_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheme_army_info`
--

DROP TABLE IF EXISTS `scheme_army_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheme_army_info` (
  `scheme_id` int(11) NOT NULL,
  `army_id` int(11) NOT NULL,
  `army_people` int(11) NOT NULL,
  PRIMARY KEY (`scheme_id`,`army_id`),
  KEY `army_id` (`army_id`),
  CONSTRAINT `scheme_army_info_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `scheme_info` (`scheme_id`),
  CONSTRAINT `scheme_army_info_ibfk_2` FOREIGN KEY (`army_id`) REFERENCES `army_info` (`army_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheme_army_info`
--

LOCK TABLES `scheme_army_info` WRITE;
/*!40000 ALTER TABLE `scheme_army_info` DISABLE KEYS */;
INSERT INTO `scheme_army_info` VALUES (4,1,1000),(4,2,1000),(5,1,1000),(5,2,1000),(6,1,1000),(6,2,1000),(7,1,1000),(8,1,20),(8,2,1000),(8,3,1000),(9,1,1000),(9,2,1000),(10,1,1000),(10,2,1000),(10,3,1000),(11,1,1000),(11,2,1000),(12,1,1000),(12,2,1000),(13,1,1000),(13,2,1000),(14,1,1000),(14,2,1000),(15,1,10),(15,2,1000),(16,1,1000),(16,2,1000),(17,1,1000),(17,2,1000);
/*!40000 ALTER TABLE `scheme_army_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheme_equipment_info`
--

DROP TABLE IF EXISTS `scheme_equipment_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheme_equipment_info` (
  `scheme_id` int(11) NOT NULL DEFAULT '0',
  `equipment_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`scheme_id`,`equipment_id`),
  KEY `equipment_id` (`equipment_id`),
  CONSTRAINT `scheme_equipment_info_ibfk_1` FOREIGN KEY (`scheme_id`) REFERENCES `scheme_info` (`scheme_id`),
  CONSTRAINT `scheme_equipment_info_ibfk_2` FOREIGN KEY (`equipment_id`) REFERENCES `equipment_info` (`equipment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheme_equipment_info`
--

LOCK TABLES `scheme_equipment_info` WRITE;
/*!40000 ALTER TABLE `scheme_equipment_info` DISABLE KEYS */;
INSERT INTO `scheme_equipment_info` VALUES (17,1),(17,2);
/*!40000 ALTER TABLE `scheme_equipment_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scheme_info`
--

DROP TABLE IF EXISTS `scheme_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheme_info` (
  `scheme_id` int(11) NOT NULL AUTO_INCREMENT,
  `scheme_name` varchar(32) NOT NULL,
  `scheme_code` varchar(32) NOT NULL,
  `location_id` int(11) NOT NULL,
  `combat_direction` varchar(32) NOT NULL,
  `safeguard_mode` varchar(32) NOT NULL,
  `carry_method` varchar(32) NOT NULL,
  `scheme_type` varchar(32) NOT NULL,
  `scheme_begin_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `scheme_end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`scheme_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `scheme_info_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location_info` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheme_info`
--

LOCK TABLES `scheme_info` WRITE;
/*!40000 ALTER TABLE `scheme_info` DISABLE KEYS */;
INSERT INTO `scheme_info` VALUES (1,'方案','432',3,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(2,'方案','24',4,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(3,'方案','1',5,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(4,'方案','2',4,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(5,'方案','3',4,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(6,'方案','4',5,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(7,'方案','5',3,'3',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(8,'方案','6',4,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(9,'方案','7',3,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(10,'方案','8',4,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(11,'方案','9',3,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(12,'方案','10',5,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(13,'方案','11',5,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(14,'方案','112',5,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(15,'方案','12',5,'1',' 自主保障',' 全装','1','2019-02-24 16:00:00','2019-03-18 16:00:00'),(16,'方案','13',6,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00'),(17,'方案','14',6,'1',' 自主保障',' 全装','1','2019-03-04 16:00:00','2019-03-11 16:00:00');
/*!40000 ALTER TABLE `scheme_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spare_part_info`
--

DROP TABLE IF EXISTS `spare_part_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spare_part_info` (
  `spare_part_id` int(11) NOT NULL,
  `element_id` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `spare_part_name` varchar(64) DEFAULT NULL,
  `spare_part_model` varchar(64) DEFAULT NULL,
  `spare_part_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`spare_part_id`),
  KEY `element_id` (`element_id`),
  KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `spare_part_info_ibfk_1` FOREIGN KEY (`element_id`) REFERENCES `element_info` (`element_id`),
  CONSTRAINT `spare_part_info_ibfk_2` FOREIGN KEY (`supplier_id`) REFERENCES `supplier_info` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spare_part_info`
--

LOCK TABLES `spare_part_info` WRITE;
/*!40000 ALTER TABLE `spare_part_info` DISABLE KEYS */;
INSERT INTO `spare_part_info` VALUES (1,1,1,'支腿部件','x001',10);
/*!40000 ALTER TABLE `spare_part_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `special_case_info`
--

DROP TABLE IF EXISTS `special_case_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `special_case_info` (
  `case_id` int(11) NOT NULL AUTO_INCREMENT,
  `case_position` varchar(64) NOT NULL,
  `case_type` varchar(8) NOT NULL,
  `month_time` int(11) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`case_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `special_case_info`
--

LOCK TABLES `special_case_info` WRITE;
/*!40000 ALTER TABLE `special_case_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `special_case_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `special_solve_info`
--

DROP TABLE IF EXISTS `special_solve_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `special_solve_info` (
  `special_case_id` int(11) NOT NULL DEFAULT '0',
  `special_solve_number` int(11) NOT NULL DEFAULT '0',
  `special_solve_body` varchar(255) NOT NULL,
  PRIMARY KEY (`special_case_id`,`special_solve_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `special_solve_info`
--

LOCK TABLES `special_solve_info` WRITE;
/*!40000 ALTER TABLE `special_solve_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `special_solve_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier_info`
--

DROP TABLE IF EXISTS `supplier_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier_info` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT,
  `location_id` int(11) DEFAULT NULL,
  `supplier_name` varchar(32) NOT NULL,
  `supplier_head` varchar(64) DEFAULT NULL,
  `supplier_phone` varchar(32) DEFAULT NULL,
  `case_position` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `location_id` (`location_id`),
  CONSTRAINT `supplier_info_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `location_info` (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier_info`
--

LOCK TABLES `supplier_info` WRITE;
/*!40000 ALTER TABLE `supplier_info` DISABLE KEYS */;
INSERT INTO `supplier_info` VALUES (1,1,'test1','001','12345678','3'),(2,2,'test2','002','87654321','3');
/*!40000 ALTER TABLE `supplier_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_category_info`
--

DROP TABLE IF EXISTS `team_category_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_category_info` (
  `team_id` int(11) NOT NULL DEFAULT '0',
  `category_id` int(11) NOT NULL DEFAULT '0',
  `category_number` int(11) DEFAULT NULL,
  PRIMARY KEY (`team_id`,`category_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `team_category_info_ibfk_1` FOREIGN KEY (`team_id`) REFERENCES `team_info` (`team_id`),
  CONSTRAINT `team_category_info_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category_info` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_category_info`
--

LOCK TABLES `team_category_info` WRITE;
/*!40000 ALTER TABLE `team_category_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_category_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_department_info`
--

DROP TABLE IF EXISTS `team_department_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_department_info` (
  `team_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `department_people` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_department_info`
--

LOCK TABLES `team_department_info` WRITE;
/*!40000 ALTER TABLE `team_department_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_department_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_info`
--

DROP TABLE IF EXISTS `team_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_info` (
  `team_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `team_name` varchar(32) NOT NULL,
  `army_id` int(11) NOT NULL,
  PRIMARY KEY (`team_id`),
  KEY `group_id` (`group_id`),
  KEY `army_id` (`army_id`),
  CONSTRAINT `team_info_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group_info` (`group_id`),
  CONSTRAINT `team_info_ibfk_2` FOREIGN KEY (`army_id`) REFERENCES `army_info` (`army_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_info`
--

LOCK TABLES `team_info` WRITE;
/*!40000 ALTER TABLE `team_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `team_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-16 15:28:41
