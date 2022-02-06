/*
Navicat MySQL Data Transfer

Source Server         : SEVER 3305
Source Server Version : 50620
Source Host           : localhost:3305
Source Database       : chat_application

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2021-06-15 00:27:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
