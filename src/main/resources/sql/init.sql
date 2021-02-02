/*Table structure for table `elfinder_file` */

DROP TABLE IF EXISTS `elfinder_file`;

CREATE TABLE `elfinder_file` (
                                 `id` INT(7) UNSIGNED NOT NULL AUTO_INCREMENT,
                                 `parent_id` INT(7) UNSIGNED NOT NULL,
                                 `name` VARCHAR(256) NOT NULL,
                                 `content` LONGBLOB NOT NULL,
                                 `size` INT(10) UNSIGNED NOT NULL DEFAULT '0',
                                 `mtime` INT(10) UNSIGNED NOT NULL DEFAULT '0',
                                 `mime` VARCHAR(256) NOT NULL DEFAULT 'unknown',
                                 `read` ENUM('1','0') NOT NULL DEFAULT '1',
                                 `write` ENUM('1','0') NOT NULL DEFAULT '1',
                                 `locked` ENUM('1','0') NOT NULL DEFAULT '0',
                                 `hidden` ENUM('1','0') NOT NULL DEFAULT '0',
                                 `width` INT(5) NOT NULL DEFAULT '0',
                                 `height` INT(5) NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`),
                                 UNIQUE KEY `parent_name` (`parent_id`,`name`),
                                 KEY `parent_id` (`parent_id`)
) ENGINE=MYISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `elfinder_file` */

INSERT  INTO `elfinder_file`(`id`,`parent_id`,`name`,`content`,`size`,`mtime`,`mime`,`read`,`write`,`locked`,`hidden`,`width`,`height`) VALUES (1,0,'DATABASE','',0,0,'directory','1','1','0','0',0,0);

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
                            `id` INT(11) NOT NULL AUTO_INCREMENT,
                            `username` VARCHAR(255) NOT NULL,
                            `password` VARCHAR(255) NOT NULL,
                            `email` VARCHAR(255) NOT NULL,
                            `role_code` VARCHAR(255) NOT NULL,
                            `role_name` VARCHAR(255) NOT NULL,
                            `gmt_create` DATETIME NOT NULL,
                            `gmt_update` DATETIME NOT NULL,
                            `nickname` VARCHAR(255) DEFAULT NULL,
                            `user_create` INT(11) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

INSERT  INTO `sys_user`(`id`,`username`,`password`,`email`,`role_code`,`role_name`,`gmt_create`,`gmt_update`,`nickname`,`user_create`) VALUES (1,'admin','23f90100463d27633c61a711a8bf8ea5072710952454d509','345849402@qq.com','admin','管理员','2019-03-21 14:30:57','2019-03-21 14:30:57','admin',1);
