/*
Navicat MySQL Data Transfer

Source Server         : text
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : db_crm

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2017-06-07 13:00:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `id` varchar(40) NOT NULL,
  `khno` varchar(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `area` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `level` varchar(30) DEFAULT NULL,
  `myd` varchar(30) DEFAULT NULL,
  `xyd` varchar(30) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `postCode` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `webSite` varchar(20) DEFAULT NULL,
  `yyzzzch` varchar(50) DEFAULT NULL,
  `fr` varchar(20) DEFAULT NULL,
  `zczj` varchar(20) DEFAULT NULL,
  `nyye` varchar(20) DEFAULT NULL,
  `khyh` varchar(50) DEFAULT NULL,
  `khzh` varchar(50) DEFAULT NULL,
  `dsdjh` varchar(50) DEFAULT NULL,
  `gsdjh` varchar(50) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('0E630A21C817484ABDD43036E5FBDF0B', 'KH20170405065539', '北京大牛科技', '南京', '小黑', '大客户', '☆☆☆☆', '☆☆☆☆', '北京海淀区双榆树东里15号', '333122', '312368654', '010-62263393', 'www.daniu.com', '1223457900', '大牛', '55555', '44444', '招商', '6225231243641', '83747482907', '245280978945', '1');
INSERT INTO `t_customer` VALUES ('29', 'KH20170328040046', '北京老牛公司', '北京', '小白', '重点开发客户', '☆☆☆☆', '☆☆☆☆', '北京海淀区', '100027', '321321', '010-62263393', 'www.daniu.com', '420103000057404', '老牛', '1000', '1111', '工商银行', '6225231243641', '4422214321321', '4104322332', '0');

-- ----------------------------
-- Table structure for t_customer_contact
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_contact`;
CREATE TABLE `t_customer_contact` (
  `id` varchar(40) NOT NULL,
  `cusId` varchar(40) DEFAULT NULL,
  `contactTime` date DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `overview` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_contact
-- ----------------------------
INSERT INTO `t_customer_contact` VALUES ('6', '29', '2017-03-29', '北京最牛酒店', '吃喝拉撒睡');
INSERT INTO `t_customer_contact` VALUES ('7', '29', '2017-03-28', '22', '22');
INSERT INTO `t_customer_contact` VALUES ('DA93F7E7B7104507A25666ADC47FC02B', '0E630A21C817484ABDD43036E5FBDF0B', '2017-04-10', '北京恒牛酒店', '吃喝拉撒');

-- ----------------------------
-- Table structure for t_customer_linkman
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_linkman`;
CREATE TABLE `t_customer_linkman` (
  `id` varchar(40) NOT NULL,
  `cusId` varchar(40) DEFAULT NULL,
  `linkName` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `zhiwei` varchar(50) DEFAULT NULL,
  `officePhone` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_linkman
-- ----------------------------
INSERT INTO `t_customer_linkman` VALUES ('12', '29', '老牛', '男', 'CEO', '012-345566', '1257908444');
INSERT INTO `t_customer_linkman` VALUES ('13', '29', 'vv', '女', 'vv', 'vv', 'vvv');
INSERT INTO `t_customer_linkman` VALUES ('40B7DD2CB9C6479AB80210357D55A2E3', '0E630A21C817484ABDD43036E5FBDF0B', 'dd', '女', 'dd', 'dd', 'dd');
INSERT INTO `t_customer_linkman` VALUES ('E3A300F4C8B34337B506EA3397E341F8', '0E630A21C817484ABDD43036E5FBDF0B', '大牛', '男', 'CEO', '1234566', '12345666');

-- ----------------------------
-- Table structure for t_customer_loss
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_loss`;
CREATE TABLE `t_customer_loss` (
  `id` varchar(40) NOT NULL,
  `cusNo` varchar(40) DEFAULT NULL,
  `cusName` varchar(20) DEFAULT NULL,
  `cusManager` varchar(20) DEFAULT NULL,
  `lastOrderTime` date DEFAULT NULL,
  `confirmLossTime` int(20) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `cusOrderId` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_loss
-- ----------------------------
INSERT INTO `t_customer_loss` VALUES ('717C39C207254028B2B405F4B7263607', 'KH20170405065539', '北京大牛科技', '小黑', '2016-12-05', '181', '1', '0E630A21C817484ABDD43036E5FBDF0B');

-- ----------------------------
-- Table structure for t_customer_order
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_order`;
CREATE TABLE `t_customer_order` (
  `id` varchar(40) NOT NULL,
  `cusId` varchar(40) DEFAULT NULL,
  `orderLinkman` varchar(100) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `orderDate` date DEFAULT NULL COMMENT '最后一次订单日期',
  `overview` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_order
-- ----------------------------
INSERT INTO `t_customer_order` VALUES ('36686A3ABCC04D0EAA452A801037B93A', '29', '11', '11', '2017-06-01', '11');
INSERT INTO `t_customer_order` VALUES ('528FCE35BF2F4427B64AAC749930F066', 'AA30C2C3521D4E29BAACD7295E3B1C6D', '小牛', '23435', '2017-04-04', '33333');
INSERT INTO `t_customer_order` VALUES ('C9230F5E5DE84D5EBB7B566B54642B18', '0E630A21C817484ABDD43036E5FBDF0B', '到牛', '1234567', '2016-12-05', '34565');

-- ----------------------------
-- Table structure for t_customer_reprieve
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_reprieve`;
CREATE TABLE `t_customer_reprieve` (
  `id` varchar(40) NOT NULL,
  `lossId` int(11) DEFAULT NULL,
  `measure` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_reprieve
-- ----------------------------

-- ----------------------------
-- Table structure for t_customer_service
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_service`;
CREATE TABLE `t_customer_service` (
  `id` varchar(40) NOT NULL,
  `serveType` varchar(30) DEFAULT NULL,
  `overview` varchar(500) DEFAULT NULL,
  `customer` varchar(30) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `servicerequest` varchar(500) DEFAULT NULL,
  `createPeople` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assigner` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `serviceProce` varchar(500) DEFAULT NULL,
  `serviceProcePeople` varchar(20) DEFAULT NULL,
  `serviceProceTime` datetime DEFAULT NULL,
  `serviceProceResult` varchar(500) DEFAULT NULL,
  `myd` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_customer_service
-- ----------------------------
INSERT INTO `t_customer_service` VALUES ('0B9C4B36C4744340BB075B2537FA8571', '建议', '建议有问题', '大牛', 'AlreadyDeal', '吃饭太快', '李龙华', '2017-04-24 00:00:00', '小白', '2017-04-24 00:00:00', '以后吃慢些', '李龙华', '2017-04-24 00:00:00', null, null);
INSERT INTO `t_customer_service` VALUES ('17', '咨询', '关于产品', '北京老牛公司', 'Archived', '产品咨询', 'Jack', '2017-03-28 00:00:00', '小黑', '2017-03-28 00:00:00', '回答完美', 'Jack', '2017-03-28 00:00:00', '好', '☆☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('425B41A26ABA4CFA8647A741884CE216', '建议', '加量不加价', '北京老牛公司', 'Distribution', '多给少要', '李龙华', '2017-04-05 00:00:00', '小黑', '2017-05-24 00:00:00', null, null, null, null, null);
INSERT INTO `t_customer_service` VALUES ('62642504603F47C2A91543838DFEA71B', '投诉', '33', 'beij', 'Archived', '333', '李龙华', '2017-05-10 00:00:00', '小黑', '2017-05-10 00:00:00', 'fff', '李龙华', '2017-05-10 00:00:00', 'sss', '☆☆☆');
INSERT INTO `t_customer_service` VALUES ('68611905E46E4EC7871628E88CAC1D96', '投诉', '关于产品', '北京狐狸公司', 'AlreadyDeal', '产品质量不合格', '李龙华', '2017-04-24 00:00:00', '小黑', '2017-04-24 00:00:00', 'ddd', '李龙华', '2017-06-05 00:00:00', null, null);
INSERT INTO `t_customer_service` VALUES ('69BF5CF28EDB4872A049098529C1FB7A', '建议', 'dd', 'dd', 'Archived', 'dd', '李龙华', null, '小黑', '2017-05-10 00:00:00', 'ddd', '李龙华', '2017-05-10 00:00:00', '走人', '☆☆☆☆');
INSERT INTO `t_customer_service` VALUES ('A0968D16CB194F70915975C205F8309C', '建议', 'ww', 'ww', 'Archived', 'ww', '李龙华', '2017-06-04 00:00:00', '小黑', '2017-06-04 00:00:00', 'www', '李龙华', '2017-06-04 00:00:00', 'ww', '☆☆☆☆');

-- ----------------------------
-- Table structure for t_cus_dev_plan
-- ----------------------------
DROP TABLE IF EXISTS `t_cus_dev_plan`;
CREATE TABLE `t_cus_dev_plan` (
  `id` varchar(40) NOT NULL,
  `saleChanceId` varchar(40) DEFAULT NULL,
  `planItem` varchar(100) DEFAULT NULL,
  `planDate` date DEFAULT NULL,
  `exeAffect` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cus_dev_plan
-- ----------------------------
INSERT INTO `t_cus_dev_plan` VALUES ('6C0C596084FA44B9943D25A6055EF456', '15', '22', '2017-04-06', '22');
INSERT INTO `t_cus_dev_plan` VALUES ('D7A231AC487542FD9C5A615F6FA046A8', 'C6520723A2BF4707A5E9B9D3E7BC2349', '33', '2017-04-18', '33');

-- ----------------------------
-- Table structure for t_datadic
-- ----------------------------
DROP TABLE IF EXISTS `t_datadic`;
CREATE TABLE `t_datadic` (
  `id` varchar(40) NOT NULL,
  `dataDicName` varchar(50) DEFAULT NULL,
  `dataDicValue` varchar(50) DEFAULT NULL,
  `createPer` varchar(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updatePer` varchar(11) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_datadic` (`dataDicValue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_datadic
-- ----------------------------
INSERT INTO `t_datadic` VALUES ('1', '客户等级', '普通客户', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('2', '客户等级', '重点开发客户', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('3', '客户等级', '大客户', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('4', '客户等级', '合作伙伴', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('5', '客户等级', '战略合作伙伴', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('6', '服务类型', '咨询', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('7', '服务类型', '建议', null, null, null, null);
INSERT INTO `t_datadic` VALUES ('8', '服务类型', '投诉', null, null, null, null);

-- ----------------------------
-- Table structure for t_sale_chance
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_chance`;
CREATE TABLE `t_sale_chance` (
  `id` varchar(40) NOT NULL,
  `chanceSource` varchar(300) DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `cgjl` int(11) DEFAULT NULL,
  `overview` varchar(300) DEFAULT NULL,
  `linkMan` varchar(100) DEFAULT NULL,
  `linkPhone` varchar(100) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `createMan` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `assignMan` varchar(100) DEFAULT NULL,
  `assignTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `devResult` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sale_chance
-- ----------------------------
INSERT INTO `t_sale_chance` VALUES ('1', '熟人介绍', '北京鲨鱼科技公司', '45', '鲨鱼制品', '鲨鱼', '12345612345', '可以尝试', '李龙华', '2017-05-10 11:24:00', '小白', '2017-05-10 13:13:00', '1', '3');
INSERT INTO `t_sale_chance` VALUES ('12CAB2DE256E47DE9263A22D3BD0E280', '熟人介绍', '北京飞禽科技公司', '45', '鸟毛制品', '大雁', '12345612345', '可以尝试', '李龙华', '2017-05-10 12:51:00', '小黑', null, '1', '2');
INSERT INTO `t_sale_chance` VALUES ('3E6BEE525C2D4411A72DE0B852803455', 'www', 'www', '22', '', 'ww', '', '', '李龙华', '2017-06-04 09:29:00', '小黑', '2017-06-04 09:30:01', '1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(50) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `trueName` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `roleName` varchar(20) DEFAULT NULL,
  `isVal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'javaweb', '123', 'Jack', 'javaweb@qq.com', '123456789', '系统管理员', '0');
INSERT INTO `t_user` VALUES ('10', 'lilonghua', '123', '李龙华', 'lilonghua@qq.com', '1234567890', '系统管理员', '0');
INSERT INTO `t_user` VALUES ('11', 'lifei', '123', '李飞', 'lifei@qq.com', '09876543211', '销售主管', '1');
INSERT INTO `t_user` VALUES ('12', 'lihua', '123', '李华', 'lihua@qq.com', '12345678900', '高管', '1');
INSERT INTO `t_user` VALUES ('13', 'xiaohei', '123', '小黑', 'xiaohei@qq.com', '23455433', '客户经理', '1');
INSERT INTO `t_user` VALUES ('14', 'xiaobai', '123', '小白', 'xiaobai1@qq.com', '010-62263393', '客户经理', '1');
