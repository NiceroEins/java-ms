CREATE TABLE `j_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `title` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `description` varchar(500) NOT NULL DEFAULT '' COMMENT '商品描述',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '商品销量',
  `img_url` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '' COMMENT '商品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `j_item_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL DEFAULT '0',
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `j_order_info` (
  `id` varchar(32) NOT NULL COMMENT '订单id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `item_price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `amount` int(11) NOT NULL COMMENT '商品数量',
  `order_price` decimal(10,2) NOT NULL COMMENT '订单价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `j_sequence_info` (
  `name` varchar(255) NOT NULL,
  `current_value` int(11) NOT NULL DEFAULT '0',
  `step` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `j_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `gender` tinyint(1) NOT NULL DEFAULT '0' COMMENT '1 男 2 女 0 未知',
  `age` int(11) NOT NULL DEFAULT '0',
  `telephone` varchar(255) NOT NULL DEFAULT '',
  `register_mode` varchar(255) NOT NULL DEFAULT '' COMMENT 'byphone,bywechat,byalipay',
  `third_party_id` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `telephone_unique_index` (`telephone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `j_user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `encrpt_password` varchar(128) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;