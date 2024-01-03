
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for experimentitems
-- ----------------------------
DROP TABLE IF EXISTS `experimentitems`;
CREATE TABLE `experimentitems`  (
  `itemno` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '实验项目编号，由课程代码后10位+2位课程内序号组成',
  `itemname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '实验项目名称',
  `courseno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程编号',
  `itemhour` int NULL DEFAULT NULL COMMENT '实验学时',
  `itemtype` int NULL DEFAULT NULL COMMENT '实验类型：1演示、2验证、3综合、4设计研究',
  `iscompulsory` int NULL DEFAULT NULL COMMENT '是否必做：1必做，0选做',
  PRIMARY KEY (`itemno` DESC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of experimentitems
-- ----------------------------
INSERT INTO `experimentitems` VALUES ('073110400111', '流量管制', '210731100801', 2, 4, 1);
INSERT INTO `experimentitems` VALUES ('073110400110', '策略路由项', '210731100801', 2,  4, 1);
INSERT INTO `experimentitems` VALUES ('073110400109', '入侵检测系统', '210731100801', 2,  3, 1);
# INSERT INTO `experimentitems` VALUES ('073110400108', '钓鱼网站', '210731100801', 2, 3, 1);
# INSERT INTO `experimentitems` VALUES ('073110400107', 'OSPF路由项欺骗攻击和防御', '210731100801', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110400106', 'VLAN防MAC地址欺骗攻击', '210731100801', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110400105', '防生成树欺骗攻击', '210731100801', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110400104', '防DHCP欺骗攻击', '210731100801', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110400103', 'RIP路由项欺骗攻击', '210731100801', 2,  1, 1);
# INSERT INTO `experimentitems` VALUES ('073110400102', 'Smurf攻击', '210731100801', 2,  1, 1);
# INSERT INTO `experimentitems` VALUES ('073110400101', 'MAC地址欺骗攻击', '210731100801', 2,  1, 1);
# INSERT INTO `experimentitems` VALUES ('073110080114', '程序设计思维', '210731104001', 2,  4, 0);
# INSERT INTO `experimentitems` VALUES ('073110080113', '问题求解策略2', '210731104001', 2,  4, 0);
# INSERT INTO `experimentitems` VALUES ('073110080112', '问题求解策略', '210731104001', 2,  4, 0);
# INSERT INTO `experimentitems` VALUES ('073110080111', '组织复杂数据', '210731104001', 2,  4, 1);
# INSERT INTO `experimentitems` VALUES ('073110080110', '数据存储与程序组织结构', '210731104001', 2,  3, 1);
# INSERT INTO `experimentitems` VALUES ('073110080109', '数据的顺序组织', '210731104001', 2,  3, 1);
# INSERT INTO `experimentitems` VALUES ('073110080108', '数据间接访问', '210731104001', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080107', 'C语言字符串', '210731104001', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080106', 'C语言数组', '210731104001', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080105', '简单问题求解的程序设计', '210731104001', 2,  3, 1);
# INSERT INTO `experimentitems` VALUES ('073110080104', '程序流程控制2', '210731104001', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080103', '程序流程控制1', '210731104001', 2,  2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080102', '数据存储与表示', '210731104001', 2, 2, 1);
# INSERT INTO `experimentitems` VALUES ('073110080101', 'C语言基础', '210731104001', 2, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
