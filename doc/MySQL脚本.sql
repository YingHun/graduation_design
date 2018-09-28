/*
 Navicat Premium Data Transfer

 Source Server         : 172.16.30.55
 Source Server Type    : MySQL
 Source Server Version : 50173
 Source Host           : 172.16.30.55:3306
 Source Schema         : graduation_design

 Target Server Type    : MySQL
 Target Server Version : 50173
 File Encoding         : 65001

 Date: 28/09/2018 15:43:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_category_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_category_info`;
CREATE TABLE `tb_category_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `code` varchar(2) NOT NULL COMMENT ''分类标识'',
  `name` varchar(20) NOT NULL COMMENT ''分类名称'',
  `status` varchar(10) NOT NULL DEFAULT ''0'' COMMENT ''状态：0-有效、1-无效'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`,`code`),
  UNIQUE KEY `category_index` (`code`,`name`) USING BTREE,
  KEY `code` (`code`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT=''商品分类信息'';

-- ----------------------------
-- Records of tb_category_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_category_info` VALUES (1, ''10'', ''手机'', ''0'', ''2018-09-18 16:14:24'', ''2018-09-18 16:14:28'');
INSERT INTO `tb_category_info` VALUES (2, ''11'', ''家用电器'', ''0'', ''2018-09-18 16:15:30'', ''2018-09-18 16:15:34'');
INSERT INTO `tb_category_info` VALUES (3, ''12'', ''数码'', ''0'', ''2018-09-18 16:16:02'', ''2018-09-18 16:15:55'');
INSERT INTO `tb_category_info` VALUES (4, ''13'', ''家居家装'', ''0'', ''2018-09-18 16:16:13'', ''2018-09-18 16:16:17'');
INSERT INTO `tb_category_info` VALUES (5, ''14'', ''电脑办公'', ''0'', ''2018-09-18 16:16:35'', ''2018-09-18 16:16:39'');
INSERT INTO `tb_category_info` VALUES (6, ''15'', ''礼品箱包'', ''0'', ''2018-09-18 16:17:01'', ''2018-09-18 16:17:03'');
INSERT INTO `tb_category_info` VALUES (7, ''16'', ''食品饮料'', ''0'', ''2018-09-18 16:17:23'', ''2018-09-18 16:17:26'');
INSERT INTO `tb_category_info` VALUES (8, ''17'', ''汽车用品'', ''0'', ''2018-09-18 16:17:52'', ''2018-09-18 16:17:56'');
INSERT INTO `tb_category_info` VALUES (9, ''18'', ''服装鞋靴'', ''0'', ''2018-09-18 16:18:19'', ''2018-09-18 16:18:24'');
INSERT INTO `tb_category_info` VALUES (10, ''19'', ''玩具乐器'', ''0'', ''2018-09-18 16:18:43'', ''2018-09-18 16:18:45'');
COMMIT;

-- ----------------------------
-- Table structure for tb_invoicing_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_invoicing_info`;
CREATE TABLE `tb_invoicing_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `category` varchar(2) NOT NULL COMMENT ''分类标识'',
  `code` varchar(20) NOT NULL COMMENT ''商品编码'',
  `contact` varchar(20) NOT NULL COMMENT ''进出货联系人'',
  `telephone` varchar(11) NOT NULL COMMENT ''联系电话'',
  `address` varchar(50) NOT NULL COMMENT ''进出货地址'',
  `quantity` int(11) NOT NULL COMMENT ''进出货数量'',
  `unit_price` decimal(8,2) NOT NULL COMMENT ''进出货单价'',
  `discount` decimal(5,2) NOT NULL DEFAULT ''0.00'' COMMENT ''折扣率'',
  `discounted_price` decimal(8,2) NOT NULL DEFAULT ''0.00'' COMMENT ''折扣金额'',
  `total_price` decimal(12,2) NOT NULL COMMENT ''总价'',
  `type` varchar(3) NOT NULL COMMENT ''类型：in-进货、out-出货'',
  `status` varchar(10) NOT NULL DEFAULT ''0'' COMMENT ''状态：0-有效、1-无效'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT=''商品进货详情'';

-- ----------------------------
-- Records of tb_invoicing_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_invoicing_info` VALUES (31, ''10'', ''1000000001'', ''乔布斯'', ''18980809090'', ''苹果中心'', 30000, 8000.00, 0.00, 0.00, 240000000.00, ''in'', ''0'', ''2018-09-28 15:32:43'', ''2018-09-28 15:32:43'');
INSERT INTO `tb_invoicing_info` VALUES (32, ''10'', ''1000000002'', ''雷军'', ''18923039456'', ''中国杭州'', 20000, 2500.00, 0.00, 0.00, 500000000.00, ''in'', ''0'', ''2018-09-28 15:33:49'', ''2018-09-28 15:33:49'');
INSERT INTO `tb_invoicing_info` VALUES (33, ''10'', ''1000000003'', ''金三胖'', ''18923503632'', ''韩国'', 15000, 6000.00, 0.00, 0.00, 90000000.00, ''in'', ''0'', ''2018-09-28 15:34:32'', ''2018-09-28 15:34:32'');
INSERT INTO `tb_invoicing_info` VALUES (34, ''11'', ''1100000001'', ''董明珠'', ''18900923509'', ''中国广东'', 5000, 3000.00, 0.00, 0.00, 15000000.00, ''in'', ''0'', ''2018-09-28 15:37:56'', ''2018-09-28 15:37:56'');
INSERT INTO `tb_invoicing_info` VALUES (35, ''11'', ''1100000004'', ''海信'', ''18902935236'', ''中国广东'', 6000, 3000.00, 0.00, 0.00, 18000000.00, ''in'', ''0'', ''2018-09-28 15:38:37'', ''2018-09-28 15:38:37'');
INSERT INTO `tb_invoicing_info` VALUES (36, ''11'', ''1100000005'', ''海尔兄弟'', ''18932536233'', ''中国深圳'', 10000, 2000.00, 0.00, 0.00, 20000000.00, ''in'', ''0'', ''2018-09-28 15:39:09'', ''2018-09-28 15:39:09'');
INSERT INTO `tb_invoicing_info` VALUES (37, ''13'', ''1300000001'', ''艾珀'', ''13823623633'', ''中国深圳'', 5500, 4000.00, 0.00, 0.00, 22000000.00, ''in'', ''0'', ''2018-09-28 15:39:56'', ''2018-09-28 15:39:56'');
INSERT INTO `tb_invoicing_info` VALUES (38, ''10'', ''1000000001'', ''刘德华'', ''18909235623'', ''中国香港'', 1, 8999.00, 0.00, 0.00, 8999.00, ''out'', ''0'', ''2018-09-27 15:40:40'', ''2018-09-28 15:40:40'');
INSERT INTO `tb_invoicing_info` VALUES (39, ''10'', ''1000000002'', ''梁朝伟'', ''18909235235'', ''中国香港'', 2, 3000.00, 0.00, 1000.00, 5000.00, ''out'', ''0'', ''2018-09-28 15:41:20'', ''2018-09-28 15:41:20'');
COMMIT;

-- ----------------------------
-- Table structure for tb_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu_info`;
CREATE TABLE `tb_menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `menu_name` varchar(20) NOT NULL COMMENT ''菜单名称'',
  `icon` varchar(40) NOT NULL COMMENT ''图标'',
  `url` varchar(50) NOT NULL COMMENT ''连接地址'',
  `status` varchar(10) NOT NULL DEFAULT ''0'' COMMENT ''状态：0-有效、1-无效'',
  `sort` int(2) NOT NULL COMMENT ''顺序'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`),
  UNIQUE KEY `menu_index` (`id`,`menu_name`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT=''菜单表'';

-- ----------------------------
-- Records of tb_menu_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_menu_info` VALUES (1, ''商品分类'', ''layui-icon layui-icon-app'', ''category/view'', ''0'', 1, ''2018-09-19 15:54:36'', ''2018-09-19 15:54:40'');
INSERT INTO `tb_menu_info` VALUES (2, ''商品库存'', ''layui-icon layui-icon-template-1'', ''stock/view'', ''0'', 2, ''2018-09-19 15:56:26'', ''2018-09-19 15:56:30'');
INSERT INTO `tb_menu_info` VALUES (3, ''商品进货'', ''layui-icon layui-icon-note'', ''goods/inbound'', ''0'', 3, ''2018-09-19 15:59:11'', ''2018-09-19 15:59:15'');
INSERT INTO `tb_menu_info` VALUES (5, ''销售报表'', ''layui-icon layui-icon-chart'', ''goods/report'', ''0'', 5, ''2018-09-19 15:59:44'', ''2018-09-19 15:59:48'');
INSERT INTO `tb_menu_info` VALUES (6, ''基本信息'', ''layui-icon layui-icon-username'', ''user/info'', ''0'', 6, ''2018-09-19 16:00:13'', ''2018-09-19 16:00:17'');
INSERT INTO `tb_menu_info` VALUES (4, ''商品出货'', ''layui-icon layui-icon-tree'', ''goods/outbound'', ''0'', 4, ''2018-09-27 11:15:11'', ''2018-09-27 11:15:16'');
COMMIT;

-- ----------------------------
-- Table structure for tb_stock_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_stock_info`;
CREATE TABLE `tb_stock_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `category` varchar(2) NOT NULL COMMENT ''分类标识'',
  `code` varchar(20) NOT NULL COMMENT ''商品编码'',
  `name` varchar(20) NOT NULL COMMENT ''分类名称'',
  `stock` int(10) NOT NULL DEFAULT ''0'' COMMENT ''剩余库存'',
  `sold_quantity` int(10) NOT NULL DEFAULT ''0'' COMMENT ''已销售数量'',
  `unit_price` decimal(8,2) NOT NULL COMMENT ''商品单价'',
  `status` varchar(10) NOT NULL DEFAULT ''0'' COMMENT ''状态：0-已上架、1-已下架、2-缺货'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `code_name_index` (`code`,`name`) USING BTREE,
  KEY `pk_category` (`category`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT=''商品库存信息'';

-- ----------------------------
-- Records of tb_stock_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_stock_info` VALUES (1, ''10'', ''1000000001'', ''iphone6 Plus'', 29999, 1, 5899.00, ''0'', ''2018-09-26 09:47:31'', ''2018-09-28 15:40:40'');
INSERT INTO `tb_stock_info` VALUES (2, ''10'', ''1000000002'', ''小米8手机'', 19998, 2, 2999.00, ''0'', ''2018-09-26 09:48:32'', ''2018-09-28 15:41:20'');
INSERT INTO `tb_stock_info` VALUES (3, ''11'', ''1100000001'', ''格力空调'', 5000, 0, 3499.00, ''0'', ''2018-09-26 09:49:16'', ''2018-09-28 15:37:56'');
INSERT INTO `tb_stock_info` VALUES (4, ''11'', ''1100000002'', ''美的冰箱'', 0, 0, 1999.00, ''2'', ''2018-09-26 09:49:53'', ''2018-09-26 09:49:55'');
INSERT INTO `tb_stock_info` VALUES (5, ''11'', ''1100000003'', ''美的空调'', 0, 0, 3199.00, ''2'', ''2018-09-26 09:50:25'', ''2018-09-26 09:50:29'');
INSERT INTO `tb_stock_info` VALUES (6, ''11'', ''1100000004'', ''海信电视'', 6000, 0, 4399.00, ''0'', ''2018-09-26 09:51:07'', ''2018-09-28 15:38:37'');
INSERT INTO `tb_stock_info` VALUES (7, ''11'', ''1100000005'', ''海尔洗衣机'', 10000, 0, 2299.00, ''0'', ''2018-09-26 09:52:16'', ''2018-09-28 15:39:09'');
INSERT INTO `tb_stock_info` VALUES (8, ''12'', ''1200000001'', ''尼康单反相机'', 0, 0, 8900.00, ''2'', ''2018-09-26 09:53:03'', ''2018-09-28 15:24:13'');
INSERT INTO `tb_stock_info` VALUES (9, ''13'', ''1300000001'', ''艾珀家私'', 5500, 0, 12999.00, ''0'', ''2018-09-26 09:53:40'', ''2018-09-28 15:39:56'');
INSERT INTO `tb_stock_info` VALUES (10, ''14'', ''1400000001'', ''联想Y560'', 0, 0, 5499.00, ''2'', ''2018-09-26 09:54:29'', ''2018-09-26 09:54:33'');
INSERT INTO `tb_stock_info` VALUES (11, ''14'', ''1400000002'', ''MacBook Air'', 0, 0, 8999.00, ''2'', ''2018-09-26 09:55:12'', ''2018-09-26 09:55:16'');
INSERT INTO `tb_stock_info` VALUES (12, ''16'', ''1600000001'', ''雪碧'', 0, 0, 2.50, ''2'', ''2018-09-26 13:37:04'', ''2018-09-26 13:37:08'');
INSERT INTO `tb_stock_info` VALUES (13, ''16'', ''1600000002'', ''可口可乐'', 0, 0, 2.50, ''2'', ''2018-09-26 13:37:41'', ''2018-09-26 13:37:45'');
INSERT INTO `tb_stock_info` VALUES (14, ''17'', ''1700000001'', ''导航仪'', 0, 0, 399.00, ''2'', ''2018-09-26 13:38:15'', ''2018-09-26 13:38:19'');
INSERT INTO `tb_stock_info` VALUES (15, ''17'', ''1700000002'', ''汽车抱枕'', 0, 0, 29.99, ''2'', ''2018-09-26 13:38:53'', ''2018-09-26 13:38:57'');
INSERT INTO `tb_stock_info` VALUES (16, ''17'', ''1700000003'', ''车载香水'', 0, 0, 19.99, ''2'', ''2018-09-26 13:39:22'', ''2018-09-26 13:39:26'');
INSERT INTO `tb_stock_info` VALUES (17, ''10'', ''1000000003'', ''SAMSUNG S9'', 15000, 0, 6999.00, ''0'', ''2018-09-28 13:26:21'', ''2018-09-28 15:34:32'');
COMMIT;

-- ----------------------------
-- Table structure for tb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_info`;
CREATE TABLE `tb_user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT ''序号'',
  `account` varchar(10) CHARACTER SET latin1 NOT NULL COMMENT ''账号'',
  `username` varchar(20) NOT NULL COMMENT ''姓名'',
  `gender` varchar(4) NOT NULL DEFAULT ''2'' COMMENT ''性别：0-女、1-男、2-未知'',
  `birthday` varchar(12) NOT NULL COMMENT ''出生日期'',
  `telephone` varchar(11) NOT NULL COMMENT ''联系电话'',
  `email` varchar(30) NOT NULL COMMENT ''电子邮箱'',
  `address` varchar(50) NOT NULL COMMENT ''家庭住址'',
  `postcode` varchar(6) NOT NULL COMMENT ''邮政编码'',
  `password` varchar(20) NOT NULL COMMENT ''密码'',
  `header` varchar(50) DEFAULT NULL COMMENT ''头像地址'',
  `status` varchar(10) NOT NULL DEFAULT ''0'' COMMENT ''状态：0-有效、1-已注销'',
  `create_time` datetime NOT NULL COMMENT ''创建时间'',
  `update_time` datetime DEFAULT NULL COMMENT ''更新时间'',
  PRIMARY KEY (`id`,`account`) USING BTREE,
  UNIQUE KEY `account_username_index` (`account`,`username`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT=''用户基本资料'';

-- ----------------------------
-- Records of tb_user_info
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_info` VALUES (1, ''admin001'', ''李伦'', ''1'', ''1989-09-09'', ''13923265421'', ''lilun@gmail.com'', ''四川省康定市'', ''236236'', ''123456'', NULL, ''0'', ''2018-09-18 15:56:27'', ''2018-09-18 15:56:32'');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
