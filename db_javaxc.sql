/*
Navicat MySQL Data Transfer

Source Server         : MySQL5.7
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : db_javaxc

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-11-07 21:13:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(66) DEFAULT NULL,
  `userPw` varchar(55) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a');
INSERT INTO `t_admin` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for t_doc
-- ----------------------------
DROP TABLE IF EXISTS `t_doc`;
CREATE TABLE `t_doc` (
  `id` int(11) NOT NULL,
  `mingcheng` varchar(66) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `fujianYuanshiming` varchar(55) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_doc
-- ----------------------------
INSERT INTO `t_doc` VALUES ('1', '第1章 Java语言简介（大纲）', '/upload/1323404877500.doc', '1323404877500.doc', '2015-04-08 02:23', 'no');
INSERT INTO `t_doc` VALUES ('2', '第2章 Java语言基础(大纲)', '/upload/1323404877500.doc', '1323404877500.doc', '2015-04-08 02:08', 'no');
INSERT INTO `t_doc` VALUES ('3', '第3章 Java程序结构(大纲)', '/upload/1323404877500.doc', '1323404877500.doc', '2015-04-08 04:05', 'no');

-- ----------------------------
-- Table structure for t_gonggao
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `gonggao_id` int(11) NOT NULL,
  `gonggao_title` varchar(55) DEFAULT NULL,
  `gonggao_content` varchar(5000) DEFAULT NULL,
  `gonggao_data` varchar(55) DEFAULT NULL,
  `gonggao_del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`gonggao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES ('1', '测试公告测试公告', '测试公告测试公告', '2015-04-08 02:08', null);
INSERT INTO `t_gonggao` VALUES ('2', '下周放假通知安排', '下周放假通知安排22', '2015-04-08 02:08', null);

-- ----------------------------
-- Table structure for t_liuyan
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan` (
  `id` int(11) NOT NULL,
  `neirong` varchar(2000) DEFAULT NULL,
  `liuyanshi` varchar(55) DEFAULT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `huifu` varchar(2000) DEFAULT NULL,
  `huifushi` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_liuyan
-- ----------------------------
INSERT INTO `t_liuyan` VALUES ('1', '怎么样才能把学习搞好呢，请指教', '2016-11-08 14:05', '1', '努力用功，刻苦实践', '2016-11-08 04:05');
INSERT INTO `t_liuyan` VALUES ('3', '测试问题测试问题测试问题测试问题测试问题测试问题', '2016-11-08 14:05', '1', 'Test', '2016-11-08 01:31');
INSERT INTO `t_liuyan` VALUES ('5', 'Java环境变量配置', '2016-11-08 14:05', '1', 'Java_home,Classpath,path', '2016-11-08 04:39');
INSERT INTO `t_liuyan` VALUES ('6', '如何手工编译Java程序', '2016-11-08 16:38', '1', '使用Javac命令', '2016-11-08 01:31');

-- ----------------------------
-- Table structure for t_shipin
-- ----------------------------
DROP TABLE IF EXISTS `t_shipin`;
CREATE TABLE `t_shipin` (
  `shipin_id` int(11) NOT NULL,
  `shipin_name` varchar(66) DEFAULT NULL,
  `shipin_jianjie` varchar(2000) DEFAULT NULL,
  `fujian` varchar(55) DEFAULT NULL,
  `fujianYuanshiming` varchar(2000) DEFAULT NULL,
  `shijian` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`shipin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shipin
-- ----------------------------
INSERT INTO `t_shipin` VALUES ('1', 'Java类', 'Java类教学视频', '/upload/1336462829368.avi', '1336462829368.avi', '2015-04-08 04:03', 'no');
INSERT INTO `t_shipin` VALUES ('2', 'Java图形编程', 'Java Swing编程', '/upload/1336462829368.avi', '1336462829368.avi', '2015-04-08 04:05', 'no');

-- ----------------------------
-- Table structure for t_stu
-- ----------------------------
DROP TABLE IF EXISTS `t_stu`;
CREATE TABLE `t_stu` (
  `stu_id` int(11) NOT NULL,
  `stu_xuehao` varchar(66) DEFAULT NULL,
  `stu_realname` varchar(50) DEFAULT NULL,
  `stu_sex` varchar(50) DEFAULT NULL,
  `stu_age` varchar(55) DEFAULT NULL,
  `login_pw` varchar(50) DEFAULT NULL,
  `zhuangtai` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_stu
-- ----------------------------
INSERT INTO `t_stu` VALUES ('1', '2016001', '赵成功', '男', '21', '000000', 'b', 'no');
INSERT INTO `t_stu` VALUES ('2', '2016002', '马华腾', '男', '21', '000000', 'b', 'no');
INSERT INTO `t_stu` VALUES ('3', '2016003', '钱多多', '男', '21', '000000', 'b', 'no');
INSERT INTO `t_stu` VALUES ('4', '2016004', '刘美丽', '女', '20', '000000', 'b', 'no');

-- ----------------------------
-- Table structure for t_tea
-- ----------------------------
DROP TABLE IF EXISTS `t_tea`;
CREATE TABLE `t_tea` (
  `tea_id` int(11) NOT NULL,
  `tea_bianhao` varchar(66) DEFAULT NULL,
  `tea_realname` varchar(55) DEFAULT NULL,
  `tea_sex` varchar(50) DEFAULT NULL,
  `tea_age` varchar(50) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `login_pw` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tea_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tea
-- ----------------------------
INSERT INTO `t_tea` VALUES ('1', '0001', '方老师', '男', '40', '0001', '000000', 'no');

-- ----------------------------
-- Table structure for t_zuoyes
-- ----------------------------
DROP TABLE IF EXISTS `t_zuoyes`;
CREATE TABLE `t_zuoyes` (
  `id` int(11) NOT NULL,
  `mingcheng` varchar(50) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `tijiaoshi` varchar(50) DEFAULT NULL,
  `stuId` int(11) DEFAULT NULL,
  `zuoyetId` int(11) DEFAULT NULL,
  `huifu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zuoyes
-- ----------------------------
INSERT INTO `t_zuoyes` VALUES ('2', 'java编写猫捉老鼠程序_赵成功作业', '/upload/1397758276279.doc', '2015-04-08 02:10', '1', '7', '22222222');

-- ----------------------------
-- Table structure for t_zuoyet
-- ----------------------------
DROP TABLE IF EXISTS `t_zuoyet`;
CREATE TABLE `t_zuoyet` (
  `id` int(11) NOT NULL,
  `mingcheng` varchar(50) DEFAULT NULL,
  `fujian` varchar(50) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  `fabushi` varchar(50) DEFAULT NULL,
  `tea_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zuoyet
-- ----------------------------
INSERT INTO `t_zuoyet` VALUES ('5', '分子量计算手动编写', '/upload/1323404877500.doc', '认真做', '2015-04-08 13:44', '1');
INSERT INTO `t_zuoyet` VALUES ('7', 'java编写猫捉老鼠程序', '/upload/1323404877500.doc', '好好做', '2015-04-08 13:46', '1');
