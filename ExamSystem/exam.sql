/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50723
Source Host           : 120.79.174.105:3306
Source Database       : exam

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-12-11 15:22:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` varchar(100) NOT NULL,
  `stuname` varchar(100) NOT NULL,
  `stuclass` varchar(100) NOT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `file` varchar(100) DEFAULT NULL,
  `filesize` varchar(100) DEFAULT NULL,
  `upload` varchar(100) DEFAULT NULL,
  `testid` int(11) DEFAULT NULL,
  KEY `testid` (`testid`),
  KEY `stuid` (`stuid`),
  CONSTRAINT `testid` FOREIGN KEY (`testid`) REFERENCES `test` (`testid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for stuupfiles
-- ----------------------------
DROP TABLE IF EXISTS `stuupfiles`;
CREATE TABLE `stuupfiles` (
  `filesize` varchar(255) DEFAULT NULL,
  `fileuptime` varchar(100) DEFAULT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `stuid` varchar(255) NOT NULL,
  `testid` int(100) NOT NULL,
  KEY `sacadsvc` (`stuid`),
  KEY `xascacadsvcv` (`testid`),
  CONSTRAINT `sacadsvc` FOREIGN KEY (`stuid`) REFERENCES `student` (`stuid`),
  CONSTRAINT `xascacadsvcv` FOREIGN KEY (`testid`) REFERENCES `test` (`testid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stuupfiles
-- ----------------------------

-- ----------------------------
-- Table structure for system
-- ----------------------------
DROP TABLE IF EXISTS `system`;
CREATE TABLE `system` (
  `time_interval` varchar(20) NOT NULL,
  `page_record` int(20) NOT NULL,
  `test_maxtime` int(10) NOT NULL,
  `file_minsize` bigint(100) NOT NULL,
  `file_maxsize` bigint(255) NOT NULL,
  `teacher_right` varchar(10) NOT NULL,
  `clear` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system
-- ----------------------------
INSERT INTO `system` VALUES ('30', '30', '15', '512', '131572', '1', '0');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `tname` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `admin` varchar(1) NOT NULL DEFAULT '\0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tname` (`tname`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teainfos
-- ----------------------------
DROP TABLE IF EXISTS `teainfos`;
CREATE TABLE `teainfos` (
  `info` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teainfos
-- ----------------------------

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `testid` int(100) NOT NULL AUTO_INCREMENT,
  `testname` varchar(100) NOT NULL,
  `starttime` datetime NOT NULL,
  `auto_begin` int(1) DEFAULT NULL,
  `tea_id` int(100) NOT NULL,
  `test_signal` int(1) DEFAULT '0',
  `submit` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`testid`),
  UNIQUE KEY `name` (`testname`),
  KEY `tea_id` (`tea_id`),
  CONSTRAINT `tea_id` FOREIGN KEY (`tea_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
