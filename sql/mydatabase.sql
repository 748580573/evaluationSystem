/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : mydatabase

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-03-17 21:31:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
  `id` int(4) NOT NULL,
  `number` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `academicSystem` varchar(20) NOT NULL,
  `major` varchar(20) NOT NULL,
  `grade` varchar(20) NOT NULL,
  `orders` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`number`),
  KEY `number` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazz
-- ----------------------------
INSERT INTO `clazz` VALUES ('1', '03', '软件工程', '4', '软件工程', '15', '3');
INSERT INTO `clazz` VALUES ('2', '04', '软件工程', '4', '软件工程', '15', '4');

-- ----------------------------
-- Table structure for `clazzandteacher`
-- ----------------------------
DROP TABLE IF EXISTS `clazzandteacher`;
CREATE TABLE `clazzandteacher` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `clazzNumber` varchar(30) DEFAULT NULL,
  `teacherNumber` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clazzNumber` (`clazzNumber`),
  KEY `teacherNumber` (`teacherNumber`),
  CONSTRAINT `clazzandteacher_ibfk_1` FOREIGN KEY (`clazzNumber`) REFERENCES `clazz` (`number`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `clazzandteacher_ibfk_2` FOREIGN KEY (`teacherNumber`) REFERENCES `teacher` (`number`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clazzandteacher
-- ----------------------------
INSERT INTO `clazzandteacher` VALUES ('1', '03', '123654888');
INSERT INTO `clazzandteacher` VALUES ('2', '04', '123654888');
INSERT INTO `clazzandteacher` VALUES ('3', '04', '2018031701');
INSERT INTO `clazzandteacher` VALUES ('4', '04', '2018031603');

-- ----------------------------
-- Table structure for `schedule`
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `clazzNumber` varchar(30) NOT NULL,
  `courseNumber` varchar(20) NOT NULL,
  `clazzName` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `teacherNumber` varchar(30) NOT NULL,
  `teacher` varchar(20) NOT NULL,
  `period` varchar(20) NOT NULL,
  `credit` varchar(8) NOT NULL,
  `weeks` varchar(20) NOT NULL,
  `orders` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`clazzNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '04', '123456', '软件工程', '10508', '123654888', '李立', '1', '2', 'Mon', 'first', '必修');
INSERT INTO `schedule` VALUES ('2', '04', '654321', '计算机网络', '10408', '111222333', '张洪', '1', '3', 'Mon', 'thrid', '必修');
INSERT INTO `schedule` VALUES ('9', '05', '112233', '数据结构', '10518', '444555666', '胡德昆', '2', '3', 'Mon', 'first', '必修');
INSERT INTO `schedule` VALUES ('15', '04', '123654', '思想与品德', '08101', '2018031701', '叮当', '3', '3', 'Mon', 'second', '必修');
INSERT INTO `schedule` VALUES ('16', '04', '456666', '概念实训', '10518', '2018031603', '方方方', '3', '3', 'Mon', 'first', '必修');

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `courseNumber` varchar(30) NOT NULL,
  `clazzNumber` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `teacher` varchar(30) NOT NULL,
  `studentNumber` varchar(30) NOT NULL,
  `studentName` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `credit` varchar(20) NOT NULL,
  `score` varchar(20) DEFAULT '0',
  `period` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`courseNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('1', '112233', '04', '软件工程', '李立', '201510414410', '郭耀文', '专业课', '2.5', '55', '2');
INSERT INTO `score` VALUES ('2', '123456', '04', '软件工程', '李立', '123456789987', '恒吴', '必修', '2', '12', '1');
INSERT INTO `score` VALUES ('3', '123456', '04', '软件工程', '李立', '987654321123', '吴恒', '必修', '2', '2', '1');
INSERT INTO `score` VALUES ('4', '123456', '04', '软件工程', '李立', '201510414410', '郭耀文', '必修', '2', '85', '1');
INSERT INTO `score` VALUES ('5', '123654', '04', '思想与品德', '叮当', '987654321123', '吴恒', '必修', '3', '75', '3');
INSERT INTO `score` VALUES ('6', '123654', '04', '思想与品德', '叮当', '201510414410', '郭耀文', '必修', '3', '75', '3');
INSERT INTO `score` VALUES ('7', '456666', '04', '概念实训', '方方方', '987654321123', '吴恒', '必修', '3', '65', '3');
INSERT INTO `score` VALUES ('8', '456666', '04', '概念实训', '方方方', '201510414410', '郭耀文', '必修', '3', '65', '3');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `number` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `enthic` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `institution` varchar(20) NOT NULL,
  `major` varchar(20) NOT NULL,
  `grade` varchar(12) NOT NULL,
  `clazzNumber` varchar(20) NOT NULL,
  `fromSchool` varchar(50) NOT NULL,
  `phone` varchar(30) NOT NULL,
  PRIMARY KEY (`id`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '123456789987', '恒吴', '汉', '男', '信息科学与工程学院', '软件工程', '15', '04', '安岳中学', '18408219491');
INSERT INTO `student` VALUES ('5', '987654321123', '吴恒', '汉', '男', '信息科学与工程学院', '软件工程', '15', '04', '安岳中学', '18408219491');
INSERT INTO `student` VALUES ('6', '201510414410', '郭耀文', '汉', '男', '信息科学与工程学院', '软件工程', '15', '04', '安岳中学', '18408219491');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `number` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `major` varchar(20) DEFAULT NULL,
  `sex` varchar(2) NOT NULL,
  `institution` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  PRIMARY KEY (`id`,`number`),
  KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '123654888', '李立', '软工', '男', '信息科学与工程学院', '18784331450');
INSERT INTO `teacher` VALUES ('11', '2018031701', '叮当', '思想与品德', '男', '信息科学与工程学院', '18408219999');
INSERT INTO `teacher` VALUES ('12', '2018031603', '方方方', '概念实训', '男', '信息科学与工程学院', '18408216666');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `number` varchar(30) NOT NULL,
  `password` varchar(40) NOT NULL,
  `type` varchar(255) NOT NULL,
  `isExist` int(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`number`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '987654321123', '123456', '学生', '1');
INSERT INTO `user` VALUES ('2', '201510414410', '123456', '学生', '1');
INSERT INTO `user` VALUES ('3', '123654888', '123456', '教师', '1');
INSERT INTO `user` VALUES ('4', '111222333444', '123456', '教务处', '1');
INSERT INTO `user` VALUES ('5', '2018031701', '123456', '教师', '1');
INSERT INTO `user` VALUES ('6', '2018031603', '123456', '教师', '1');
