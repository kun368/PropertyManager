/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : propertymanage

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-20 11:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) NOT NULL,
  `adminPassword` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `index_admin_name` (`adminName`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin_1', '123456', 'admin_1@163.com');
INSERT INTO `adminuser` VALUES ('2', 'admin_2', '123123', 'admin_2@163.com');
INSERT INTO `adminuser` VALUES ('3', 'admin_3', '111111', 'admin_3@qq.com');

-- ----------------------------
-- Table structure for complanint
-- ----------------------------
DROP TABLE IF EXISTS `complanint`;
CREATE TABLE `complanint` (
  `complanintId` int(11) NOT NULL AUTO_INCREMENT,
  `propertorId` int(11) DEFAULT NULL,
  `comDetail` varchar(255) DEFAULT NULL,
  `comDate` datetime DEFAULT NULL,
  `solveState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`complanintId`),
  KEY `propertorId_complanint_propertor` (`propertorId`),
  CONSTRAINT `propertorId_complanint_propertor` FOREIGN KEY (`propertorId`) REFERENCES `propertor` (`propertorId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complanint
-- ----------------------------

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `houseId` int(11) NOT NULL AUTO_INCREMENT COMMENT '房间ID',
  `buildingNo` int(11) DEFAULT NULL COMMENT '楼号',
  `unitNo` int(11) DEFAULT NULL COMMENT '单元号',
  `houseNo` int(11) DEFAULT NULL COMMENT '房间编号（单元内部）',
  `prpertorId` int(11) DEFAULT NULL,
  `sealState` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `houseStyle` varchar(255) DEFAULT NULL COMMENT '户型',
  `houseArea` double(255,0) DEFAULT NULL COMMENT '房间面积',
  PRIMARY KEY (`houseId`),
  KEY `propertorID_house_propertor` (`prpertorId`),
  CONSTRAINT `propertorID_house_propertor` FOREIGN KEY (`prpertorId`) REFERENCES `propertor` (`propertorId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '1', '1', '101', '2', '已售', '两室一厅', '90');
INSERT INTO `house` VALUES ('2', '1', '1', '102', '1', '已售', '三室一厅', '120');
INSERT INTO `house` VALUES ('3', '1', '1', '103', null, '未售', '四室一厅', '150');
INSERT INTO `house` VALUES ('4', '1', '1', '104', '3', '已售', '三室一厅', '130');

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `houseId` int(11) NOT NULL,
  `payTypeId` int(11) NOT NULL,
  `payAmount` double DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `houseId_payment_house` (`houseId`),
  KEY `payTypeId_payment_paymentType` (`payTypeId`),
  CONSTRAINT `houseId_payment_house` FOREIGN KEY (`houseId`) REFERENCES `house` (`houseId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `paytypeId_payment_paymenttype` FOREIGN KEY (`payTypeId`) REFERENCES `paymenttype` (`payTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------

-- ----------------------------
-- Table structure for paymenttype
-- ----------------------------
DROP TABLE IF EXISTS `paymenttype`;
CREATE TABLE `paymenttype` (
  `payTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `payType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paymenttype
-- ----------------------------

-- ----------------------------
-- Table structure for propertor
-- ----------------------------
DROP TABLE IF EXISTS `propertor`;
CREATE TABLE `propertor` (
  `propertorId` int(11) NOT NULL AUTO_INCREMENT,
  `prName` varchar(255) NOT NULL,
  `prSex` varchar(255) DEFAULT NULL,
  `prPhone` varchar(255) DEFAULT NULL,
  `prIdNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`propertorId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of propertor
-- ----------------------------
INSERT INTO `propertor` VALUES ('1', '张三', '男', '18347851295', '130129198511052014');
INSERT INTO `propertor` VALUES ('2', '王静', '女', '15825568420', '125102198402156025');
INSERT INTO `propertor` VALUES ('3', '林杰', '男', '13925678452', '120325198701012015');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair` (
  `repairId` int(11) NOT NULL AUTO_INCREMENT,
  `houseId` int(11) NOT NULL,
  `repairdata` date DEFAULT NULL,
  `repairState` varchar(255) DEFAULT NULL,
  `repairManId` int(255) NOT NULL,
  `repairDetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`repairId`),
  KEY `houseId_repair_house` (`houseId`),
  CONSTRAINT `houseId_repair_house` FOREIGN KEY (`houseId`) REFERENCES `house` (`houseId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repair
-- ----------------------------
