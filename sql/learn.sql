-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        10.1.16-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 hao.learn 的数据库结构
CREATE DATABASE IF NOT EXISTS `hao.learn` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hao.learn`;


-- 导出  表 hao.learn.function_info 结构
CREATE TABLE IF NOT EXISTS `function_info` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) NOT NULL,
  `is_menu` tinyint(1) NOT NULL DEFAULT '0',
  `parent_id` bigint(20) DEFAULT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hao.learn.function_info 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `function_info` DISABLE KEYS */;
INSERT INTO `function_info` (`id`, `name`, `is_menu`, `parent_id`, `remark`) VALUES
	(6317038017294897152, '根据登录名查询用户', 0, NULL, NULL),
	(6317038017294901248, '新增单个用户', 0, NULL, NULL),
	(6317038017294905344, '批量新增用户', 0, NULL, NULL),
	(6317038017299103744, '更新用户', 0, NULL, NULL),
	(6317038017299107840, '删除单个用户', 0, NULL, NULL),
	(6317038017299111936, '批量删除用户', 0, NULL, NULL);
/*!40000 ALTER TABLE `function_info` ENABLE KEYS */;


-- 导出  表 hao.learn.role_function 结构
CREATE TABLE IF NOT EXISTS `role_function` (
  `role_id` bigint(20) DEFAULT NULL,
  `function_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hao.learn.role_function 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `role_function` DISABLE KEYS */;
INSERT INTO `role_function` (`role_id`, `function_id`) VALUES
	(6317038017299095552, 6317038017294897152);
/*!40000 ALTER TABLE `role_function` ENABLE KEYS */;


-- 导出  表 hao.learn.role_info 结构
CREATE TABLE IF NOT EXISTS `role_info` (
  `id` bigint(20) NOT NULL,
  `name` varchar(32) NOT NULL,
  `remark` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hao.learn.role_info 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `role_info` DISABLE KEYS */;
INSERT INTO `role_info` (`id`, `name`, `remark`) VALUES
	(6317038017299091456, '普通用户', NULL),
	(6317038017299095552, '系统管理员', NULL);
/*!40000 ALTER TABLE `role_info` ENABLE KEYS */;


-- 导出  表 hao.learn.user_info 结构
CREATE TABLE IF NOT EXISTS `user_info` (
  `ID` bigint(20) NOT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `LOGIN_NAME` varchar(255) NOT NULL,
  `LOGIN_PASSWORD` varchar(255) DEFAULT NULL,
  `LAST_LOGIN_DATE` datetime DEFAULT NULL,
  `LAST_LOGIN_IP` varchar(255) DEFAULT NULL,
  `STATUS` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_LOGIN_NAME` (`LOGIN_NAME`) USING BTREE,
  UNIQUE KEY `UK_EMAIL` (`EMAIL`) USING BTREE,
  UNIQUE KEY `UK_PHONE` (`PHONE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hao.learn.user_info 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`ID`, `FIRST_NAME`, `LAST_NAME`, `EMAIL`, `PHONE`, `LOGIN_NAME`, `LOGIN_PASSWORD`, `LAST_LOGIN_DATE`, `LAST_LOGIN_IP`, `STATUS`) VALUES
	(6308316580291813376, 'Ding', 'Hao', 'dinghao@163.com', '13000000000', 'Hao', NULL, '2017-09-04 23:56:21', '192.168.1.1', 1),
	(6308947494508171264, 'Tian', 'Xize', 'mt@hotmail.com', '13100000001', 'maintk', NULL, NULL, '192.168.2.1', 5);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;


-- 导出  表 hao.learn.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  hao.learn.user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	(6308316580291813376, 6317038017299095552);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
