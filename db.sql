/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST - 3309
Source Server Version : 50524
Source Host           : localhost:3309
Source Database       : kareteboot

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2018-01-06 14:41:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '0',
  `user_role` varchar(255) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('3', 'harry', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'harry', 'Support', 'harry@harry.com', 'SOUTH B', '254700000000', '1', 'ROLE_ADMIN');
