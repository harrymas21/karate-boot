/*
Navicat MySQL Data Transfer

Source Server         : LOCALHOST - 3309
Source Server Version : 50524
Source Host           : localhost:3309
Source Database       : kareteboot

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2018-01-23 00:27:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(1000) NOT NULL,
  `date` datetime NOT NULL,
  `title` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `version` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4v4ymc0irlkpq9aowljw4mdrs` (`author_id`),
  CONSTRAINT `FK4v4ymc0irlkpq9aowljw4mdrs` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'Massa tellus dolor neque morbi ultricies nonummy sed sit. Sit odio fermentum suspendisse in id. Morbi urna integer velit nam adipiscing. Mus a sunt metus ipsum volutpat. Suspendisse a pretium. Velit ornare a at etiam fermentum. Posuere elit sed porta eget', '2018-01-10 00:00:00', 'TEST ONE', '3', '0');
INSERT INTO `blog` VALUES ('2', 'Massa tellus dolor neque morbi ultricies nonummy sed sit. Sit odio fermentum suspendisse in id. Morbi urna integer velit nam adipiscing. Mus a sunt metus ipsum volutpat. Suspendisse a pretium. Velit ornare a at etiam fermentum. Posuere elit sed porta eget', '2018-01-11 00:00:00', 'TEST TWO', '3', '0');
INSERT INTO `blog` VALUES ('3', 'ggggggggggggggggg', '2018-01-22 21:37:51', 'ggg5555555555', '7', '1');
INSERT INTO `blog` VALUES ('4', 'ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp', '2018-01-22 01:32:56', 'pppppppppppppppp', '3', '0');
INSERT INTO `blog` VALUES ('5', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', '2018-01-22 01:51:42', 'w', '3', '0');
INSERT INTO `blog` VALUES ('6', 'Massa tellus dolor neque morbi ultricies nonummy sed sit. Sit odio fermentum suspendisse in id. Morbi urna integer velit nam adipiscing. Mus a sunt metus ipsum volutpat. Suspendisse a pretium. Velit ornare a at etiam fermentum. Posuere elit sed porta eget', '2018-01-22 13:50:37', 'TEST EDITED THREE TIMES', '3', '1');
INSERT INTO `blog` VALUES ('7', 'yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy', '2018-01-22 14:25:45', 'one', '3', '0');
INSERT INTO `blog` VALUES ('8', 'Let’s begin with the picture on the front cover. You may have observed that the\r\nportrait of Alan Turing is constructed from a number of pictures (“tiles”) of great\r\ncomputer scientists and mathematicians.\r\nSuppose you were asked in an interview to design a program that takes an\r\nimage and a collection of s × s-sized tiles and produce a mosaic from the tiles that\r\nresembles the image. A good way to begin may be to partition the image into s × ssized squares, compute the average color of each such image square, and then find\r\nthe tile that is closest to it in the color space.', '2018-01-22 14:32:37', 'giberrish', '3', '0');
INSERT INTO `blog` VALUES ('9', 'pol', '2018-01-22 21:31:53', 'pol', '7', '0');
INSERT INTO `blog` VALUES ('10', 'ddddddddddddd', '2018-01-22 22:27:10', 'dddddddddd', '3', '0');

-- ----------------------------
-- Table structure for `clubs`
-- ----------------------------
DROP TABLE IF EXISTS `clubs`;
CREATE TABLE `clubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `location` varchar(100) NOT NULL,
  `style` varchar(50) NOT NULL,
  `county` varchar(50) NOT NULL,
  `nearestTown` varchar(11) NOT NULL,
  `version` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clubs
-- ----------------------------
INSERT INTO `clubs` VALUES ('1', 'SEAL TEAM', 'KISUMU SOCIAL HALL', 'SHOTOKAN', 'KISUMU', 'KISUMU CBD', '1');
INSERT INTO `clubs` VALUES ('2', 'TUK', 'CBD', 'GOJU RYU', 'NAIROBI', 'NAIROBI', '0');
INSERT INTO `clubs` VALUES ('3', 'JKUAT', 'JUJA', 'SHOTOKAN', 'NAIROBI', 'JUJA', '0');
INSERT INTO `clubs` VALUES ('4', 'MMUST', 'KAKAMEGA', 'SHOTOKAN', 'KAKAMEGA', 'KAKAMEGA', '0');
INSERT INTO `clubs` VALUES ('5', 'no test', 'test', 'test', 'test', 'test', '0');

-- ----------------------------
-- Table structure for `clubstatements`
-- ----------------------------
DROP TABLE IF EXISTS `clubstatements`;
CREATE TABLE `clubstatements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `balance` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `body` varchar(255) NOT NULL,
  `paid` int(11) NOT NULL,
  `club_id` int(11) NOT NULL,
  `updated_by` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhao5t4ehrllmpfv0xe9p0sl3e` (`club_id`),
  KEY `FKiwo6a6ykunlg7p1ey6t1no8mx` (`updated_by`),
  CONSTRAINT `FKiwo6a6ykunlg7p1ey6t1no8mx` FOREIGN KEY (`updated_by`) REFERENCES `users` (`id`),
  CONSTRAINT `FKhao5t4ehrllmpfv0xe9p0sl3e` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of clubstatements
-- ----------------------------

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `author_id` int(11) NOT NULL,
  `blog_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn2na60ukhs76ibtpt9burkm27` (`author_id`),
  KEY `FKdbueb2umo93l6hbt66d8ueo2l` (`blog_id`),
  CONSTRAINT `FKdbueb2umo93l6hbt66d8ueo2l` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`id`),
  CONSTRAINT `FKn2na60ukhs76ibtpt9burkm27` FOREIGN KEY (`author_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', 'cool', '2018-01-08 00:00:00', '7', '1');
INSERT INTO `comments` VALUES ('2', 'pretty cool', '2018-01-09 00:00:00', '7', '1');
INSERT INTO `comments` VALUES ('3', 'bullshit', '2018-01-10 00:00:00', '7', '1');
INSERT INTO `comments` VALUES ('4', '111111111111111111', '2018-01-22 02:36:02', '3', '3');
INSERT INTO `comments` VALUES ('5', 'woowwwwwww', '2018-01-22 02:36:32', '3', '1');
INSERT INTO `comments` VALUES ('6', 'shit', '2018-01-22 10:20:47', '3', '6');
INSERT INTO `comments` VALUES ('7', 'what is this?', '2018-01-22 14:02:27', '3', '4');
INSERT INTO `comments` VALUES ('8', 'first comment', '2018-01-22 14:32:56', '3', '8');

-- ----------------------------
-- Table structure for `eventregister`
-- ----------------------------
DROP TABLE IF EXISTS `eventregister`;
CREATE TABLE `eventregister` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `points` int(11) NOT NULL,
  `result` varchar(255) NOT NULL,
  `eventid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKge0mjp9o14j8ukd4ycs2iebrq` (`eventid`),
  KEY `FKsu3607p2f05h1ly6ds4vg2bsq` (`userid`),
  CONSTRAINT `FKsu3607p2f05h1ly6ds4vg2bsq` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `FKge0mjp9o14j8ukd4ycs2iebrq` FOREIGN KEY (`eventid`) REFERENCES `events` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of eventregister
-- ----------------------------
INSERT INTO `eventregister` VALUES ('6', 'KATA AND KUMITE', '2018-01-22 10:11:50', '0', 'PARTICIPATION', '1', '3');
INSERT INTO `eventregister` VALUES ('7', 'KATA', '2018-01-22 10:21:15', '0', 'PARTICIPATION', '4', '3');
INSERT INTO `eventregister` VALUES ('8', 'KATA AND KUMITE', '2018-01-22 10:31:00', '0', 'PARTICIPATION', '1', '2');
INSERT INTO `eventregister` VALUES ('9', 'KATA AND KUMITE', '2018-01-22 10:58:33', '0', 'PARTICIPATION', '3', '3');

-- ----------------------------
-- Table structure for `events`
-- ----------------------------
DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(512) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `location` varchar(100) NOT NULL,
  `type` varchar(15) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of events
-- ----------------------------
INSERT INTO `events` VALUES ('1', '0', 'FURSA OPEN', '2018-02-24', 'NAIROBI KASARANI', 'TOURNAMENT', '1000');
INSERT INTO `events` VALUES ('2', '1', 'KENYA OPEN', '2018-01-30', 'test', 'test', '1000');
INSERT INTO `events` VALUES ('3', '2', 'NAIROBI OPEN', '2018-01-24', 'test 2', 'test 2', '2300');
INSERT INTO `events` VALUES ('4', '1', 'YOUTH SOLIDARITY GAMES', '2018-01-31', 'kkkkkkkkkkkkk', 'kkkkkkkkkkkkkk', '7000');
INSERT INTO `events` VALUES ('5', '1', 'NATIONAL GRADING KKF', '2018-02-01', 'qqqqqqqqqqqqq', 'qqqqqqqqqq', '780');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `userrole` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `enabled` smallint(6) DEFAULT NULL,
  `clubid` int(11) DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `FKhe3mwp13wbxa0khempwhn7i3t` (`clubid`),
  CONSTRAINT `FKhe3mwp13wbxa0khempwhn7i3t` FOREIGN KEY (`clubid`) REFERENCES `clubs` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'CAROL', 'ROLE_USER', 'Sales', 'carol', 'ROBI', 'robi@robi.com', 'KAYOLE', '254705222569', '0', '2');
INSERT INTO `users` VALUES ('2', 'David', 'ROLE_USER', 'Administrator', 'david', 'Mwavali', 'david@davie.com', 'LAVINGTON', '254700000000', '0', '2');
INSERT INTO `users` VALUES ('3', 'harry', 'ROLE_ADMIN', '$2a$10$N0eqNiuikWCy9ETQ1rdau.XEELcyEO7kukkfoiNISk/9F7gw6eB0W', 'harry', 'Support', 'harry@gmail.com', 'SOUTH B', '254705222568', '1', '2');
INSERT INTO `users` VALUES ('4', 'PETER', 'ROLE_USER', 'Supervisor', 'peter', 'WANYAMA', 'wanyama@wanyama.com', 'WESTLANDS', '254721656100', '0', '2');
INSERT INTO `users` VALUES ('5', 'Super', 'ROLE_USER', 'Super Administrator', 'super', 'Administrator', 'admin@admin.com', 'EASTLEIGH', '254705222568', '0', '2');
INSERT INTO `users` VALUES ('6', 'System', 'ROLE_USER', 'Executive', 'system', 'Executive', 'system@admin.com', 'KOMAROCK', '254897542116', '0', '2');
INSERT INTO `users` VALUES ('7', 'gabby', 'ROLE_USER', '$2a$10$/0GrhURSoL/qwgiYmqAiyO2TTighRiaxkSDENkQvnfWyIu5h19ZNy', 'gabby', 'gabby', 'gabby@gabby.com', 'sabatia', '254700000000', '1', '2');
