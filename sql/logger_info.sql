/*
 Navicat Premium Data Transfer

 Source Server         : 阿里远程
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : ipav.vip
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : utf-8

 Date: 06/25/2018 16:02:44 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `logger_info`
-- ----------------------------
DROP TABLE IF EXISTS `logger_info`;
CREATE TABLE `logger_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `thread_name` varchar(255) DEFAULT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `method_name` varchar(255) DEFAULT NULL,
  `beginTime` timestamp NULL DEFAULT NULL,
  `logger_level` varchar(255) DEFAULT NULL,
  `logger_name` varchar(255) DEFAULT NULL,
  `logger_message` varchar(255) DEFAULT NULL,
  `logger_throwable` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=gb2312;

SET FOREIGN_KEY_CHECKS = 1;
