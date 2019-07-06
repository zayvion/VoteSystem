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

 Date: 06/07/2019 15:53:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_join_vote
-- ----------------------------
BEGIN;
INSERT INTO `t_join_vote` VALUES (1, 1, 2, 4);
INSERT INTO `t_join_vote` VALUES (2, 1, 2, 6);
INSERT INTO `t_join_vote` VALUES (3, 1, 1, 2);
INSERT INTO `t_join_vote` VALUES (4, 2, 2, 5);
INSERT INTO `t_join_vote` VALUES (5, 2, 2, 7);
INSERT INTO `t_join_vote` VALUES (6, 2, 2, 8);
INSERT INTO `t_join_vote` VALUES (7, 2, 1, 2);
INSERT INTO `t_join_vote` VALUES (10, 10, 4, 13);
INSERT INTO `t_join_vote` VALUES (11, 10, 4, 14);
INSERT INTO `t_join_vote` VALUES (12, 10, 4, 15);
INSERT INTO `t_join_vote` VALUES (13, 1, 6, 21);
INSERT INTO `t_join_vote` VALUES (14, 1, 3, 9);
INSERT INTO `t_join_vote` VALUES (15, 1, 7, 25);
INSERT INTO `t_join_vote` VALUES (16, 1, 7, 26);
INSERT INTO `t_join_vote` VALUES (17, 2, 7, 24);
INSERT INTO `t_join_vote` VALUES (18, 2, 3, 10);
INSERT INTO `t_join_vote` VALUES (19, 11, 10, 33);
INSERT INTO `t_join_vote` VALUES (20, 1, 10, 33);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', 'admin', 'admin@admin.com', 0, 1);
INSERT INTO `t_user` VALUES (2, 'zayvion', 'zayvion', '123355@qq.com', 1, 1);
INSERT INTO `t_user` VALUES (3, 'superboy', 'superboy', 'superboooooy@126.com', 1, 1);
INSERT INTO `t_user` VALUES (10, 'test123', 'test123', 'tdhest123@qq.com', 1, 0);
INSERT INTO `t_user` VALUES (11, 'dengchao', 'dengchao', '89486043@qq.com', 1, 1);
INSERT INTO `t_user` VALUES (12, 'Bigboss', 'qwerasdf', 'Dhdkduje@foxmail.com', 1, 1);
INSERT INTO `t_user` VALUES (17, 'bigboy', 'bigboy', 'bigboy@qq.com', 1, 1);
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote_option
-- ----------------------------
BEGIN;
INSERT INTO `t_vote_option` VALUES (1, '迅雷', 1);
INSERT INTO `t_vote_option` VALUES (2, 'IDM', 1);
INSERT INTO `t_vote_option` VALUES (3, '使用浏览器直接下载', 1);
INSERT INTO `t_vote_option` VALUES (4, '《杀死一只知更鸟》', 2);
INSERT INTO `t_vote_option` VALUES (5, '《麦田里的守望者》', 2);
INSERT INTO `t_vote_option` VALUES (6, '《百年孤独》', 2);
INSERT INTO `t_vote_option` VALUES (7, '《圣诞颂歌》', 2);
INSERT INTO `t_vote_option` VALUES (8, '《安娜•卡列尼娜》', 2);
INSERT INTO `t_vote_option` VALUES (9, '周杰伦', 3);
INSERT INTO `t_vote_option` VALUES (10, '张杰', 3);
INSERT INTO `t_vote_option` VALUES (11, '古巨基', 3);
INSERT INTO `t_vote_option` VALUES (12, 'BootStrap', 4);
INSERT INTO `t_vote_option` VALUES (13, 'Vue.js', 4);
INSERT INTO `t_vote_option` VALUES (14, 'EasyUI', 4);
INSERT INTO `t_vote_option` VALUES (15, 'Node.js', 4);
INSERT INTO `t_vote_option` VALUES (20, '1851', 6);
INSERT INTO `t_vote_option` VALUES (21, '1949', 6);
INSERT INTO `t_vote_option` VALUES (22, '1931', 6);
INSERT INTO `t_vote_option` VALUES (23, '1997', 6);
INSERT INTO `t_vote_option` VALUES (24, '长沙', 7);
INSERT INTO `t_vote_option` VALUES (25, '北京', 7);
INSERT INTO `t_vote_option` VALUES (26, '上海', 7);
INSERT INTO `t_vote_option` VALUES (33, 'Eclipse', 10);
INSERT INTO `t_vote_option` VALUES (34, 'IDEA', 10);
INSERT INTO `t_vote_option` VALUES (35, 'MyEclipse', 10);
INSERT INTO `t_vote_option` VALUES (36, 'STS', 10);
COMMIT;

-- ----------------------------
-- Table structure for t_vote_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_vote_subject`;
CREATE TABLE `t_vote_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `type` int(1) NOT NULL,
  `oper_user` int(11) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_vote_subject
-- ----------------------------
BEGIN;
INSERT INTO `t_vote_subject` VALUES (1, '最喜欢的下载工具', 0, 2, '2019-07-01 03:43:00', NULL, '2018-07-05 07:42:45');
INSERT INTO `t_vote_subject` VALUES (2, '读过的名著', 1, 2, '2019-07-04 20:00:00', NULL, '2019-07-02 19:42:39');
INSERT INTO `t_vote_subject` VALUES (3, '最喜欢的歌手', 0, 1, '2019-07-02 14:21:26', NULL, '2019-07-08 19:42:35');
INSERT INTO `t_vote_subject` VALUES (4, '好用的前端框架', 1, 2, '2019-07-04 14:29:15', NULL, '2019-07-02 19:42:28');
INSERT INTO `t_vote_subject` VALUES (6, '新中国什么时候成立', 0, 2, '2019-07-04 19:15:19', NULL, '2019-07-07 09:00:00');
INSERT INTO `t_vote_subject` VALUES (7, '喜欢的城市', 1, 2, '2019-07-04 20:36:38', NULL, '2019-07-05 10:00:00');
INSERT INTO `t_vote_subject` VALUES (10, '好用的IDE', 1, 11, '2019-07-05 18:47:57', NULL, '2019-07-12 06:00:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
