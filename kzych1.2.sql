/*
Navicat MySQL Data Transfer

Source Server         : ych
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : kzych

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-02-27 10:04:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for kz_ package
-- ----------------------------
DROP TABLE IF EXISTS `kz_ package`;
CREATE TABLE `kz_ package` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UUID` bigint(20) DEFAULT NULL,
  `CATEGORYID` bigint(20) DEFAULT NULL,
  `STATE` bigint(4) NOT NULL DEFAULT '1' COMMENT '1,??ʾδʹ?ã?2-??ʾ??ʹ?ã?3-??ʾ????',
  `MONEY` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_6` (`UUID`),
  KEY `FK_REFERENCE_7` (`CATEGORYID`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`UUID`) REFERENCES `kz_user` (`UUID`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`CATEGORYID`) REFERENCES `kz_package_category` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_ package
-- ----------------------------

-- ----------------------------
-- Table structure for kz_channel
-- ----------------------------
DROP TABLE IF EXISTS `kz_channel`;
CREATE TABLE `kz_channel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  `LINK` varchar(50) NOT NULL,
  `KEYWORD` varchar(50) DEFAULT NULL,
  `DESCRIPTION` text,
  `ISDELETE` int(11) NOT NULL DEFAULT '0' COMMENT '0:??ʾδɾ????1:??ʾ??ɾ??',
  `CREATETIME` datetime NOT NULL,
  `UPDATE` datetime DEFAULT NULL,
  `PARENTID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_channel
-- ----------------------------

-- ----------------------------
-- Table structure for kz_content
-- ----------------------------
DROP TABLE IF EXISTS `kz_content`;
CREATE TABLE `kz_content` (
  `ID` bigint(20) NOT NULL,
  `CHANNELID` bigint(20) DEFAULT NULL,
  `TITLE` varchar(50) DEFAULT NULL,
  `CONTENT` text,
  `AUTHOR` tinytext,
  `KEYWORD` text,
  `PUBLISHDATE` datetime DEFAULT NULL,
  `IMG` varchar(30) DEFAULT NULL,
  `HIT` bigint(30) DEFAULT NULL,
  `IS` int(11) DEFAULT NULL COMMENT '0????ʾ???ö???1????ʾ?ö?',
  `ISCOMMENT` int(11) DEFAULT NULL COMMENT '0??????1????',
  `COMEFROM` varchar(30) DEFAULT NULL,
  `STATICURL` text,
  `SOURCEURL` text,
  `ISDELETE` int(11) DEFAULT NULL COMMENT '0??δɾ????1????ɾ??',
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_8` (`CHANNELID`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`CHANNELID`) REFERENCES `kz_channel` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_content
-- ----------------------------

-- ----------------------------
-- Table structure for kz_major
-- ----------------------------
DROP TABLE IF EXISTS `kz_major`;
CREATE TABLE `kz_major` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MAJOR_CATEGORY_ID` bigint(20) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  `MAJOR_CODE` varchar(50) NOT NULL,
  `ISHOT` int(11) NOT NULL DEFAULT '2' COMMENT '????רҵ??1??ʾ????  2,??ʾ??????',
  `DESCRIPTION` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_11` (`MAJOR_CATEGORY_ID`),
  CONSTRAINT `FK_REFERENCE_11` FOREIGN KEY (`MAJOR_CATEGORY_ID`) REFERENCES `kz_major_category` (`MAJOR_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_major
-- ----------------------------
INSERT INTO `kz_major` VALUES ('1', '1', '土木工程', '001', '2', '好');
INSERT INTO `kz_major` VALUES ('2', '1', '环境工程', '002', '2', '好');
INSERT INTO `kz_major` VALUES ('3', '1', '计算机', '003', '2', '好');

-- ----------------------------
-- Table structure for kz_major_category
-- ----------------------------
DROP TABLE IF EXISTS `kz_major_category`;
CREATE TABLE `kz_major_category` (
  `MAJOR_CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MAJOR_CATEGORY_NAME` varchar(30) DEFAULT NULL,
  `CATEGORY_PARENT_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`MAJOR_CATEGORY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_major_category
-- ----------------------------
INSERT INTO `kz_major_category` VALUES ('1', '计算机类', null);

-- ----------------------------
-- Table structure for kz_order
-- ----------------------------
DROP TABLE IF EXISTS `kz_order`;
CREATE TABLE `kz_order` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `UUID` bigint(20) DEFAULT NULL COMMENT '用户id',
  `PAYMENT` decimal(20,2) DEFAULT NULL COMMENT '支付金额',
  `STATUS` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，',
  `PAYMENT_TYPE` int(4) DEFAULT NULL COMMENT '֧??????,1-????֧??,2-֧????,3-΢??֧??',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `END_TIME` datetime DEFAULT NULL COMMENT '交易完成时间',
  `CLOSE_TIME` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `PLAYMENT_TIME` datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_3` (`UUID`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`UUID`) REFERENCES `kz_user` (`UUID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_order
-- ----------------------------
INSERT INTO `kz_order` VALUES ('1', '1', '2000.99', '10', '10', null, null, null, null, null);

-- ----------------------------
-- Table structure for kz_orderdetail
-- ----------------------------
DROP TABLE IF EXISTS `kz_orderdetail`;
CREATE TABLE `kz_orderdetail` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单详情编号',
  `ORDERID` bigint(20) DEFAULT NULL COMMENT '订单id',
  `UNIVERSITY_ID` bigint(20) DEFAULT NULL COMMENT '学校专业编号',
  `major_id` bigint(20) DEFAULT NULL,
  `COST` decimal(20,2) DEFAULT NULL COMMENT '学费',
  `coupon` decimal(20,2) DEFAULT NULL COMMENT '优惠金额',
  `grants` decimal(20,2) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_4` (`ORDERID`),
  KEY `FK_REFERENCE_5` (`UNIVERSITY_ID`),
  KEY `FK_REFERENCE_6a` (`major_id`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`ORDERID`) REFERENCES `kz_order` (`ID`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `kz_university` (`ID`),
  CONSTRAINT `FK_REFERENCE_6a` FOREIGN KEY (`major_id`) REFERENCES `kz_major` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_orderdetail
-- ----------------------------
INSERT INTO `kz_orderdetail` VALUES ('1', '1', '1', '2', '2222.22', '3333.33', '1000.00');

-- ----------------------------
-- Table structure for kz_package_category
-- ----------------------------
DROP TABLE IF EXISTS `kz_package_category`;
CREATE TABLE `kz_package_category` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  `DESCRIPTION` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_package_category
-- ----------------------------

-- ----------------------------
-- Table structure for kz_pay_info
-- ----------------------------
DROP TABLE IF EXISTS `kz_pay_info`;
CREATE TABLE `kz_pay_info` (
  `ID` bigint(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `ORDER_ID` bigint(20) NOT NULL,
  `PAY_PLATFORM` int(10) DEFAULT NULL COMMENT '֧??ƽ̨:1-֧????,2-΢??',
  `PLATFORM_NUMBER` varchar(200) DEFAULT NULL COMMENT '֧????֧????ˮ??',
  `PLATFORM_STATUS` varchar(20) DEFAULT NULL COMMENT '֧????֧??״̬',
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_9` (`USER_ID`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`USER_ID`) REFERENCES `kz_order` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_pay_info
-- ----------------------------

-- ----------------------------
-- Table structure for kz_university
-- ----------------------------
DROP TABLE IF EXISTS `kz_university`;
CREATE TABLE `kz_university` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` text NOT NULL,
  `ADDRESS` text NOT NULL,
  `CODE` bigint(30) NOT NULL,
  `PROFILE` varchar(50) NOT NULL,
  `EMPLOYMENT_INFO` text NOT NULL,
  `BROCHURE` text NOT NULL,
  `AGREEMENTS` varchar(100) NOT NULL,
  `TELEPHONE` varchar(20) NOT NULL,
  `INTRODUCTION` text NOT NULL,
  `GRANTS` decimal(20,2) NOT NULL COMMENT '助学金',
  `coupon` decimal(20,2) NOT NULL COMMENT '代金券',
  `CATEGORYID` bigint(20) DEFAULT NULL COMMENT '1-???ƣ?2-???ƣ?3-??ר??4-??ѵѧУ',
  `PUBLISH_STATUS` int(11) DEFAULT NULL COMMENT '0-?ѷ?????1-δ????',
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_10` (`CATEGORYID`),
  CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`CATEGORYID`) REFERENCES `kz_university_category` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_university
-- ----------------------------
INSERT INTO `kz_university` VALUES ('1', '湖南大学', '湖南长沙', '1', '1.jpg', '好', '好', '好', '1991', '好', '1000.00', '2000.01', '1', '0');
INSERT INTO `kz_university` VALUES ('2', '长沙大学', '湖南长沙', '1', '1.jpg', '好', '还', '好', '1899', '好', '1000.00', '1500.01', '1', '0');
INSERT INTO `kz_university` VALUES ('3', '中南大学', '湖南长沙', '1', '1.jpg', '好', '好', '好', '199', '好', '500.00', '1000.01', '1', '0');

-- ----------------------------
-- Table structure for kz_university_category
-- ----------------------------
DROP TABLE IF EXISTS `kz_university_category`;
CREATE TABLE `kz_university_category` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(30) NOT NULL,
  `CATEGORY_INFO` varchar(50) DEFAULT NULL,
  `PARENTID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_university_category
-- ----------------------------
INSERT INTO `kz_university_category` VALUES ('1', '本科', '本科', null);
INSERT INTO `kz_university_category` VALUES ('2', '大专', '大专', null);
INSERT INTO `kz_university_category` VALUES ('3', '中专', '中专', null);
INSERT INTO `kz_university_category` VALUES ('4', '培训', '培训', null);

-- ----------------------------
-- Table structure for kz_university_major
-- ----------------------------
DROP TABLE IF EXISTS `kz_university_major`;
CREATE TABLE `kz_university_major` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UNIVERSITY_ID` bigint(20) DEFAULT NULL,
  `MAJOR_ID` bigint(20) DEFAULT NULL,
  `COST` decimal(20,2) NOT NULL,
  `MAJOR_MESSAGE` text NOT NULL,
  `COST_Constitution` text NOT NULL,
  `JOB_INFO` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERENCE_1` (`UNIVERSITY_ID`),
  KEY `FK_REFERENCE_2` (`MAJOR_ID`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `kz_university` (`ID`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`MAJOR_ID`) REFERENCES `kz_major` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_university_major
-- ----------------------------
INSERT INTO `kz_university_major` VALUES ('2', '1', '1', '7000.00', '好专业', '700+6800', '基本就业华为');
INSERT INTO `kz_university_major` VALUES ('3', '1', '2', '6000.00', '好专业', '888', '好就业');
INSERT INTO `kz_university_major` VALUES ('4', '1', '3', '39000.00', '好专业', '44', '好就业');

-- ----------------------------
-- Table structure for kz_user
-- ----------------------------
DROP TABLE IF EXISTS `kz_user`;
CREATE TABLE `kz_user` (
  `UUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(30) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  `CELLPHONE` varchar(20) DEFAULT NULL,
  `SEX` varchar(4) DEFAULT NULL,
  `IDCARD` varchar(20) DEFAULT NULL,
  `ORIGIN_PLACE` varchar(20) DEFAULT NULL,
  `SCHOOL` varchar(30) DEFAULT NULL,
  `SIGN_MESSAGE` varchar(100) DEFAULT NULL,
  `PROFILE` varchar(100) DEFAULT NULL,
  `USER_TYPE` int(11) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `LASTLOGIN_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE KEY `user_username_index` (`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kz_user
-- ----------------------------
INSERT INTO `kz_user` VALUES ('1', 'admin', 'A3A72035EBF006C81F257A5D66092898', '15616207641', '男', '430624188812148715', '湖南岳阳', '长沙大学', '我就是我。不一样的烟火222', null, '1', null, '2018-02-07 20:27:08');
INSERT INTO `kz_user` VALUES ('2', 'kate', '161E7302CD2840C46692EF9E520A96C7', '123456', null, null, null, null, null, null, '0', null, null);
