SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for 员工
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` char(32) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `mobile` char(11) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('1', '18674843959', 'liuhaipeng', '123456', '');

-- ----------------------------
-- Table structure for 产品分类
-- ----------------------------
DROP TABLE IF EXISTS `t_product_class`;
CREATE TABLE `t_product_class` (
  `id` char(32) NOT NULL,
  `code` varchar(64) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for 产品
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` char(32) NOT NULL,
  `code` varchar(64) DEFAULT NULL,
  `name` varchar(128) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `prd_class_id` char(32) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_product_product_class` (`prd_class_id`),
  CONSTRAINT `FK_product_product_class` FOREIGN KEY (`prd_class_id`) REFERENCES `t_product_class` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table 产品型号
-- ----------------------------
DROP TABLE IF EXISTS `t_product_model`;
CREATE TABLE `t_product_model` (
  `id` char(32) NOT NULL,
  `code` varchar(64) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_id` char(32) NOT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `discount_price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_prd_model_product_id` (`product_id`),
  CONSTRAINT `FK_prd_model_product_id` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table 用户
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` char(32) NOT NULL,
  `account` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `mobile` char(11) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table 用户收货地址
-- ----------------------------
DROP TABLE IF EXISTS `t_user_addr`;
CREATE TABLE `t_user_addr` (
  `id` char(32) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `consignee` varchar(64) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `default_addr` char(1) DEFAULT '0',
  `user_id` char(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_addr_user_id` (`user_id`),
  CONSTRAINT `FK_user_addr_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table 订单
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` char(32) NOT NULL,
  `code` varchar(32) DEFAULT NULL,
  `status` varchar(2) DEFAULT '0',
  `total_amount` decimal(8,2) DEFAULT NULL,
  `user_id` char(32) NOT NULL,
  `user_addr_id` char(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_user_id` (`user_id`),
  KEY `FK_order_user_addr` (`user_addr_id`),
  CONSTRAINT `FK_order_user_id` FOREIGN KEY (`user_addr_id`) REFERENCES `t_user_addr` (`id`),
  CONSTRAINT `FK_order_user_addr` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table 订单明细
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` char(32) NOT NULL,
  `order_id` char(32) NOT NULL,
  `product_model_id` char(32) NOT NULL,
  `number` int(8) DEFAULT NULL,
  `total_amount` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_item_order_id` (`order_id`),
  KEY `FK_order_item_prd_model_id` (`product_model_id`),
  CONSTRAINT `FK_order_item_order_id` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
  CONSTRAINT `FK_order_item_prd_model_id` FOREIGN KEY (`product_model_id`) REFERENCES `t_product_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
