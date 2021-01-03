-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: aiwd1
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `datamodel`
--

DROP TABLE IF EXISTS `datamodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datamodel` (
  `id` bigint NOT NULL,
  `bomb_planted` float NOT NULL,
  `ct_armor` float NOT NULL,
  `ct_defuse_kits` float NOT NULL,
  `ct_grenade_decoygrenade` float NOT NULL,
  `ct_grenade_flashbang` float NOT NULL,
  `ct_grenade_hegrenade` float NOT NULL,
  `ct_grenade_incendiarygrenade` float NOT NULL,
  `ct_grenade_molotovgrenade` float NOT NULL,
  `ct_grenade_smokegrenade` float NOT NULL,
  `ct_health` float NOT NULL,
  `ct_helmets` float NOT NULL,
  `ct_money` float NOT NULL,
  `ct_players_alive` float NOT NULL,
  `ct_score` float NOT NULL,
  `ct_weapon_ak47` float NOT NULL,
  `ct_weapon_aug` float NOT NULL,
  `ct_weapon_awp` float NOT NULL,
  `ct_weapon_bizon` float NOT NULL,
  `ct_weapon_cz75auto` float NOT NULL,
  `ct_weapon_deagle` float NOT NULL,
  `ct_weapon_elite` float NOT NULL,
  `ct_weapon_famas` float NOT NULL,
  `ct_weapon_fiveseven` float NOT NULL,
  `ct_weapon_g3sg1` float NOT NULL,
  `ct_weapon_galilar` float NOT NULL,
  `ct_weapon_glock` float NOT NULL,
  `ct_weapon_m249` float NOT NULL,
  `ct_weapon_m4a1s` float NOT NULL,
  `ct_weapon_m4a4` float NOT NULL,
  `ct_weapon_mac10` float NOT NULL,
  `ct_weapon_mag7` float NOT NULL,
  `ct_weapon_mp5sd` float NOT NULL,
  `ct_weapon_mp7` float NOT NULL,
  `ct_weapon_mp9` float NOT NULL,
  `ct_weapon_negev` float NOT NULL,
  `ct_weapon_nova` float NOT NULL,
  `ct_weapon_p2000` float NOT NULL,
  `ct_weapon_p250` float NOT NULL,
  `ct_weapon_p90` float NOT NULL,
  `ct_weapon_r8revolver` float NOT NULL,
  `ct_weapon_sawedoff` float NOT NULL,
  `ct_weapon_scar20` float NOT NULL,
  `ct_weapon_sg553` float NOT NULL,
  `ct_weapon_ssg08` float NOT NULL,
  `ct_weapon_tec9` float NOT NULL,
  `ct_weapon_ump45` float NOT NULL,
  `ct_weapon_usps` float NOT NULL,
  `ct_weapon_xm1014` float NOT NULL,
  `map` float NOT NULL,
  `round_winner` float NOT NULL,
  `t_armor` float NOT NULL,
  `t_grenade_decoygrenade` float NOT NULL,
  `t_grenade_flashbang` float NOT NULL,
  `t_grenade_hegrenade` float NOT NULL,
  `t_grenade_incendiarygrenade` float NOT NULL,
  `t_grenade_molotovgrenade` float NOT NULL,
  `t_grenade_smokegrenade` float NOT NULL,
  `t_health` float NOT NULL,
  `t_helmets` float NOT NULL,
  `t_money` float NOT NULL,
  `t_players_alive` float NOT NULL,
  `t_score` float NOT NULL,
  `t_weapon_ak47` float NOT NULL,
  `t_weapon_aug` float NOT NULL,
  `t_weapon_awp` float NOT NULL,
  `t_weapon_bizon` float NOT NULL,
  `t_weapon_cz75auto` float NOT NULL,
  `t_weapon_deagle` float NOT NULL,
  `t_weapon_elite` float NOT NULL,
  `t_weapon_famas` float NOT NULL,
  `t_weapon_fiveseven` float NOT NULL,
  `t_weapon_g3sg1` float NOT NULL,
  `t_weapon_galilar` float NOT NULL,
  `t_weapon_glock` float NOT NULL,
  `t_weapon_m249` float NOT NULL,
  `t_weapon_m4a1s` float NOT NULL,
  `t_weapon_m4a4` float NOT NULL,
  `t_weapon_mac10` float NOT NULL,
  `t_weapon_mag7` float NOT NULL,
  `t_weapon_mp5sd` float NOT NULL,
  `t_weapon_mp7` float NOT NULL,
  `t_weapon_mp9` float NOT NULL,
  `t_weapon_negev` float NOT NULL,
  `t_weapon_nova` float NOT NULL,
  `t_weapon_p2000` float NOT NULL,
  `t_weapon_p250` float NOT NULL,
  `t_weapon_p90` float NOT NULL,
  `t_weapon_r8revolver` float NOT NULL,
  `t_weapon_sawedoff` float NOT NULL,
  `t_weapon_scar20` float NOT NULL,
  `t_weapon_sg553` float NOT NULL,
  `t_weapon_ssg08` float NOT NULL,
  `t_weapon_tec9` float NOT NULL,
  `t_weapon_ump45` float NOT NULL,
  `t_weapon_usps` float NOT NULL,
  `t_weapon_xm1014` float NOT NULL,
  `time_left` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datamodel`
--

LOCK TABLES `datamodel` WRITE;
/*!40000 ALTER TABLE `datamodel` DISABLE KEYS */;
INSERT INTO `datamodel` VALUES (1,12,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),(2,8,0,0,0,3,0,0,0,5,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,7,0,0,4,0,0,0,6,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
/*!40000 ALTER TABLE `datamodel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-19 17:15:27
