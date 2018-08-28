/*
Navicat MySQL Data Transfer

Source Server         : WinMySQL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : cmfz

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-08-28 21:27:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS User;
CREATE TABLE User (
  ID int(10) NOT NULL AUTO_INCREMENT,
  name varchar(10) DEFAULT NUL,
  photoImg varchar(30) DEFAULT NUL,
  dharamName varchar(10) DEFAULT NUL,
  sex varchar(1) DEFAULT NULL,
  province varchar(3) DEFAULT NULL,
  city varchar(5) DEFAULT NULL,
  sing varchar(40) DEFAULT NULL,
  phoneNum int(11) NOT NULL,
  password varchar(12) NOT NULL,
  salt varchar(4) DEFAULT NUL,
  status int(1) DEFAULT NUL,
  registDate datetime NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
