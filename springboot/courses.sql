
create database if not exists `student`
    character set utf8mb4
    collate utf8mb4_unicode_ci;
use student;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `courseno` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '课程编号',
  `coursename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `credit` int NULL DEFAULT NULL COMMENT '学分',
  `credithour` int NULL DEFAULT NULL COMMENT '学时',
  `coursetype` int NULL DEFAULT NULL COMMENT '课程类型：1必修，2选修',
  `experimenttype` int NULL DEFAULT NULL COMMENT '实验方式：1单开实验，2课内实验',
  PRIMARY KEY (`courseno` DESC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES ('210731104001', '网络安全实验', 1, 22, 1, 1);
INSERT INTO `courses` VALUES ('210731100801', '程序设计基础实验', 1, 22, 1, 1);
INSERT INTO `courses` VALUES ('210731100802', '程序设计高级实验', 1, 22, 1, 1);
SET FOREIGN_KEY_CHECKS = 1;
