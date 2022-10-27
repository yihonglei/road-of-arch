1、在ds0数据库中创建 user_0、user_2两张用户表
CREATE TABLE `user_0` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
   `age` int(11) NOT NULL  COMMENT '年龄',
   `address` varchar(128) COMMENT '地址',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `user_2` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
    `age` int(11) NOT NULL  COMMENT '年龄',
    `address` varchar(128) COMMENT '地址',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

2、在ds1数据库中创建 user_1、user_3两张用户表
CREATE TABLE `user_1` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
    `age` int(11) NOT NULL  COMMENT '年龄',
    `address` varchar(128) COMMENT '地址',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `user_3` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_name` varchar(128) NOT NULL DEFAULT '' COMMENT '用户名',
    `age` int(11) NOT NULL  COMMENT '年龄',
    `address` varchar(128) COMMENT '地址',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COMMENT='用户表';