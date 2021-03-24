-- 创建配置表，单表，不分表
CREATE TABLE `boot_common_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `common_type` varchar(32) DEFAULT NULL COMMENT '类型',
  `common_key` varchar(32) DEFAULT NULL COMMENT 'key',
  `common_value` varchar(32) DEFAULT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置表';

-- 创建商品库存表，单表，不分表
CREATE TABLE `boot_goods_stock_info` (
 `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
 `goods_code` varchar(32) DEFAULT NULL COMMENT '商品码',
 `goods_name` varchar(32) DEFAULT NULL COMMENT '商品名称',
 `goods_price` INT DEFAULT NULL COMMENT '商品单价',
 `goods_total_num` INT DEFAULT NULL COMMENT '商品总量',
 `goods_remain_num` INT DEFAULT NULL COMMENT '商品余量',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品库存表';