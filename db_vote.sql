/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : db_vote

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 10/07/2019 16:49:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `sid` int(11) NOT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `publish_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
BEGIN;
INSERT INTO `t_comment` VALUES (14, 1, 40, 'admin', '这么简单的题目～', '2019-07-10');
INSERT INTO `t_comment` VALUES (15, 2, 40, 'zayvion', '哈哈 ，这个我知道', '2019-07-10');
INSERT INTO `t_comment` VALUES (16, 2, 42, 'zayvion', '最好用的还是Idea了，但是要钱。', '2019-07-10');
INSERT INTO `t_comment` VALUES (17, 2, 43, 'zayvion', 'PHP是最好的语言', '2019-07-10');
INSERT INTO `t_comment` VALUES (18, 3, 41, 'superboy', '壮哉我大移动', '2019-07-10');
INSERT INTO `t_comment` VALUES (19, 3, 42, 'superboy', 'Eclipse仍是主流', '2019-07-10');
INSERT INTO `t_comment` VALUES (20, 4, 42, '我的滑板鞋', 'STS省事', '2019-07-10');
INSERT INTO `t_comment` VALUES (21, 4, 43, '我的滑板鞋', '果断java不解释', '2019-07-10');
INSERT INTO `t_comment` VALUES (22, 4, 40, '我的滑板鞋', '手滑点错了', '2019-07-10');
INSERT INTO `t_comment` VALUES (23, 5, 42, '张文峰丑八怪', 'idea强大的提示功能，很舒服', '2019-07-10');
COMMIT;

-- ----------------------------
-- Table structure for t_join_vote
-- ----------------------------
DROP TABLE IF EXISTS `t_join_vote`;
CREATE TABLE `t_join_vote` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) DEFAULT NULL,
  `s_id` int(11) DEFAULT NULL,
  `o_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_join_vote
-- ----------------------------
BEGIN;
INSERT INTO `t_join_vote` VALUES (27, 2, 40, 107);
INSERT INTO `t_join_vote` VALUES (28, 2, 42, 112);
INSERT INTO `t_join_vote` VALUES (29, 2, 42, 113);
INSERT INTO `t_join_vote` VALUES (30, 2, 43, 119);
INSERT INTO `t_join_vote` VALUES (31, 3, 43, 117);
INSERT INTO `t_join_vote` VALUES (32, 3, 41, 109);
INSERT INTO `t_join_vote` VALUES (33, 3, 40, 107);
INSERT INTO `t_join_vote` VALUES (34, 3, 42, 112);
INSERT INTO `t_join_vote` VALUES (35, 3, 42, 115);
INSERT INTO `t_join_vote` VALUES (36, 4, 42, 114);
INSERT INTO `t_join_vote` VALUES (37, 4, 43, 117);
INSERT INTO `t_join_vote` VALUES (38, 4, 40, 106);
INSERT INTO `t_join_vote` VALUES (39, 4, 41, 108);
INSERT INTO `t_join_vote` VALUES (40, 4, 41, 109);
INSERT INTO `t_join_vote` VALUES (41, 5, 43, 117);
INSERT INTO `t_join_vote` VALUES (42, 5, 42, 113);
INSERT INTO `t_join_vote` VALUES (43, 5, 42, 116);
INSERT INTO `t_join_vote` VALUES (44, 5, 40, 107);
INSERT INTO `t_join_vote` VALUES (45, 5, 41, 109);
INSERT INTO `t_join_vote` VALUES (46, 5, 41, 110);
INSERT INTO `t_join_vote` VALUES (47, 2, 44, 120);
INSERT INTO `t_join_vote` VALUES (48, 2, 44, 121);
INSERT INTO `t_join_vote` VALUES (49, 2, 44, 122);
INSERT INTO `t_join_vote` VALUES (50, 2, 44, 123);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', '56748930@qq.com', 1, 1);
INSERT INTO `t_user` VALUES (2, 'zayvion', 'zayvion', '47923396@qq.com', 1, 1);
INSERT INTO `t_user` VALUES (3, 'superboy', 'superboy', 'superboy@foxmail.com', 1, 1);
INSERT INTO `t_user` VALUES (4, '我的滑板鞋', 'jiusui', 'jiusui@qq.com', 1, 1);
INSERT INTO `t_user` VALUES (5, '张文峰丑八怪', 'zhangwenfeng', 'zwf98976@gmail.com', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for t_vote_option
-- ----------------------------
DROP TABLE IF EXISTS `t_vote_option`;
CREATE TABLE `t_vote_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `option` varchar(50) NOT NULL,
  `s_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote_option
-- ----------------------------
BEGIN;
INSERT INTO `t_vote_option` VALUES (106, '1997年', 40);
INSERT INTO `t_vote_option` VALUES (107, '1949年', 40);
INSERT INTO `t_vote_option` VALUES (108, '中国联通', 41);
INSERT INTO `t_vote_option` VALUES (109, '中国移动', 41);
INSERT INTO `t_vote_option` VALUES (110, '中国电信', 41);
INSERT INTO `t_vote_option` VALUES (111, '其他虚拟运营商', 41);
INSERT INTO `t_vote_option` VALUES (112, 'Eclipse', 42);
INSERT INTO `t_vote_option` VALUES (113, 'IDEA', 42);
INSERT INTO `t_vote_option` VALUES (114, 'STS', 42);
INSERT INTO `t_vote_option` VALUES (115, 'MyEclipse', 42);
INSERT INTO `t_vote_option` VALUES (116, '我用记事本', 42);
INSERT INTO `t_vote_option` VALUES (117, 'java', 43);
INSERT INTO `t_vote_option` VALUES (118, 'C++', 43);
INSERT INTO `t_vote_option` VALUES (119, 'PHP', 43);
INSERT INTO `t_vote_option` VALUES (120, '抽象', 44);
INSERT INTO `t_vote_option` VALUES (121, '继承', 44);
INSERT INTO `t_vote_option` VALUES (122, '封装', 44);
INSERT INTO `t_vote_option` VALUES (123, '多态', 44);
COMMIT;

-- ----------------------------
-- Table structure for t_vote_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_vote_subject`;
CREATE TABLE `t_vote_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `type` int(1) NOT NULL,
  `oper_user` int(11) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote_subject
-- ----------------------------
BEGIN;
INSERT INTO `t_vote_subject` VALUES (40, '新中国什么时候成立', 0, 1, '2019-07-10 10:54:00', '2019-07-10 10:54:30', '2019-07-10 17:00:00');
INSERT INTO `t_vote_subject` VALUES (41, '什么运营商信号好', 1, 1, '2019-07-10 10:55:34', NULL, '2019-07-12 13:00:00');
INSERT INTO `t_vote_subject` VALUES (42, 'JavaIDE有哪些是比较好用的', 1, 1, '2019-07-10 11:14:35', NULL, '2019-07-16 09:00:00');
INSERT INTO `t_vote_subject` VALUES (43, '最好的程序语言', 0, 1, '2019-07-10 11:24:25', NULL, '2019-07-15 00:00:00');
INSERT INTO `t_vote_subject` VALUES (44, '下面是java的特性的是', 1, 2, '2019-07-10 11:52:01', NULL, '2019-07-17 04:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
