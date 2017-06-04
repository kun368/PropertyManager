/*
Navicat MySQL Data Transfer

Source Server         : 数据库课程设计
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : propertymanage

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-04 14:58:22
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
  `userType` int(2) NOT NULL DEFAULT '1' COMMENT '1为普通用户，0为管理员',
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin_1', '123456', 'admin_1@163.com', '0');
INSERT INTO `adminuser` VALUES ('2', 'admin_2', '123123', 'admin_2@163.com', '1');
INSERT INTO `adminuser` VALUES ('3', 'zzk123456', '123456', '985691039@qq.com', '1');
INSERT INTO `adminuser` VALUES ('4', 'admin_1', '112344', '985691333@qq.com', '1');

-- ----------------------------
-- Table structure for complanint
-- ----------------------------
DROP TABLE IF EXISTS `complanint`;
CREATE TABLE `complanint` (
  `complanintId` int(11) NOT NULL,
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
  `houseId` int(11) NOT NULL COMMENT '房间ID',
  `buildingNo` int(11) DEFAULT NULL COMMENT '楼号',
  `unitNo` int(11) DEFAULT NULL COMMENT '单元号',
  `houseNo` int(11) DEFAULT NULL COMMENT '房间编号（单元内部）',
  `propertorId` int(11) DEFAULT NULL,
  `sealState` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `houseStyle` varchar(255) DEFAULT NULL COMMENT '户型',
  `houseArea` double(255,0) DEFAULT NULL COMMENT '房间面积',
  PRIMARY KEY (`houseId`),
  UNIQUE KEY `houseID` (`houseId`) USING BTREE,
  KEY `propertorId_propertor_house` (`propertorId`),
  CONSTRAINT `propertorId_propertor_house` FOREIGN KEY (`propertorId`) REFERENCES `propertor` (`propertorId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------
INSERT INTO `house` VALUES ('1', '1', '1', '101', '1', '已售', '两室一厅', '90');
INSERT INTO `house` VALUES ('2', '1', '1', '102', '2', '已售', '三室一厅', '120');
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
  `payAmount` decimal(11,0) DEFAULT NULL,
  `payDate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`paymentId`),
  KEY `houseId_payment_house` (`houseId`),
  KEY `payTypeId_payment_paymentType` (`payTypeId`),
  CONSTRAINT `houseId_payment_house` FOREIGN KEY (`houseId`) REFERENCES `house` (`houseId`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `paymentId_payment_paymentType` FOREIGN KEY (`payTypeId`) REFERENCES `paymenttype` (`payTypeId`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '1', '1', '11', '2017-06-04 11:55:25.000000');
INSERT INTO `payment` VALUES ('2', '2', '1', '11', null);

-- ----------------------------
-- Table structure for paymenttype
-- ----------------------------
DROP TABLE IF EXISTS `paymenttype`;
CREATE TABLE `paymenttype` (
  `payTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `payType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`payTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paymenttype
-- ----------------------------
INSERT INTO `paymenttype` VALUES ('1', '水费');
INSERT INTO `paymenttype` VALUES ('2', '电费');

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
  PRIMARY KEY (`propertorId`),
  UNIQUE KEY `propertorID` (`propertorId`) USING BTREE
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
  `repairId` int(11) NOT NULL,
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

-- ----------------------------
-- View structure for house_view
-- ----------------------------
DROP VIEW IF EXISTS `house_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `house_view` AS select `house`.`buildingNo` AS `buildingNo`,`house`.`unitNo` AS `unitNo`,`house`.`houseNo` AS `houseNo` from `house` ;

-- ----------------------------
-- View structure for paymentview
-- ----------------------------
DROP VIEW IF EXISTS `paymentview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `paymentview` AS select `propertor`.`prName` AS `姓名`,`house`.`buildingNo` AS `楼宇号`,`house`.`unitNo` AS `单元号`,`house`.`houseNo` AS `房间号`,`payment`.`payAmount` AS `金额`,`payment`.`payDate` AS `时间`,`paymenttype`.`payType` AS `缴费类型` from (((`propertor` join `house` on((`house`.`propertorId` = `propertor`.`propertorId`))) join `payment` on((`payment`.`houseId` = `house`.`houseId`))) join `paymenttype` on((`payment`.`payTypeId` = `paymenttype`.`payTypeId`))) ;
DROP TRIGGER IF EXISTS `adminNameUni`;
DELIMITER ;;
CREATE TRIGGER `adminNameUni` BEFORE INSERT ON `adminuser` FOR EACH ROW begin
       if not exists(SELECT adminName FROM adminuser WHERE adminuser.adminName=NEW.adminName)
      then
      INSERT INTO adminuser (adminName,adminPassword,email) VALUES(NEW.adminName,NEW.adminPassword,NEW.email);
      end if;
end
;;
DELIMITER ;
