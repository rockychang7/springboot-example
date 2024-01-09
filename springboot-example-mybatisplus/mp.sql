CREATE DATABASE IF NOT EXISTS `mp`;
USE `mp`;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '密码',
  `phone` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '注册手机号',
  `info` json NOT NULL COMMENT '详细信息',
  `status` int NULL DEFAULT 1 COMMENT '使用状态（1正常 2冻结）',
  `balance` int NULL DEFAULT NULL COMMENT '账户余额',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jack', '123', '16546465424', '{\"age\": 20, \"intro\": \"学生\", \"gender\": \"male\"}', 1, 1600, '2024-01-09 20:50:21', '2024-01-09 20:50:21');
INSERT INTO `user` VALUES (2, 'Rose', '123', '17156655653', '{\"age\": 19, \"intro\": \"教师\", \"gender\": \"female\"}', 1, 600, '2024-01-09 20:50:21', '2024-01-09 20:50:21');
INSERT INTO `user` VALUES (3, 'Hope', '123', '13915545442', '{\"age\": 25, \"intro\": \"校长\", \"gender\": \"male\"}', 1, 100000, '2024-01-09 20:50:21', '2024-01-09 20:50:21');
INSERT INTO `user` VALUES (4, 'Thomas', '123', '1773695848', '{\"age\": 29, \"intro\": \"副校长\", \"gender\": \"male\"}', 1, 800, '2024-01-09 20:50:21', '2024-01-09 20:50:21');

SET FOREIGN_KEY_CHECKS = 1;
