/*
Navicat MySQL Data Transfer

Source Server         : popidea
Source Server Version : 50726
Source Host           : 192.168.25.129:3306
Source Database       : stu

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-10-09 14:58:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
SET FOREIGN_KEY_CHECKS=1;
