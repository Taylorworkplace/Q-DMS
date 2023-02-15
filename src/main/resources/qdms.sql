/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - qdms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qdms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `qdms`;

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `uid` int(11) DEFAULT NULL COMMENT '用户的id用于关联',
  `status` int(11) DEFAULT NULL COMMENT '1、登陆  2、登出',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `date` datetime DEFAULT NULL COMMENT '登陆登出时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log` */

insert  into `log`(`uid`,`status`,`ip`,`date`) values (2,1,'42.168.23.190','2022-06-04 22:11:00'),(2,2,'42.168.23.190','2022-06-04 22:12:00'),(2,1,'209.87.146.87','2022-06-04 22:12:00');

/*Table structure for table `rubbish` */

DROP TABLE IF EXISTS `rubbish`;

CREATE TABLE `rubbish` (
  `uid` int(11) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rubbish` */

/*Table structure for table `transport` */

DROP TABLE IF EXISTS `transport`;

CREATE TABLE `transport` (
  `uid` int(11) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `handler` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `goods` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transport` */

insert  into `transport`(`uid`,`status`,`handler`,`address`,`goods`) values (2,'运送中','张三','吉林','actor的商品0'),(2,'未发货','赵六','浙江','actor的商品1'),(2,'运送中','4k','四川','actor的商品2'),(2,'已送达','李四','山西','actor的商品3');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `passWord` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`passWord`) values (1,'admin','123'),(2,'actor','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
