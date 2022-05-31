/*
SQLyog Enterprise - MySQL GUI v6.56
MySQL - 5.5.5-10.1.13-MariaDB : Database - untrustcloud
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`untrustcloud` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `untrustcloud`;

/*Table structure for table `keywords` */

DROP TABLE IF EXISTS `keywords`;

CREATE TABLE `keywords` (
  `id` int(50) unsigned NOT NULL AUTO_INCREMENT,
  `encfilename` varchar(250) DEFAULT NULL,
  `keywords` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `keywords` */

insert  into `keywords`(`id`,`encfilename`,`keywords`) values (1,'1652858810519testtxt.jpg','world'),(2,'1652858810519testtxt.jpg','hello'),(3,'1652858894021balayyatxt.jpg','world'),(4,'1652858894021balayyatxt.jpg','hello');

/*Table structure for table `req` */

DROP TABLE IF EXISTS `req`;

CREATE TABLE `req` (
  `fid` varchar(100) DEFAULT NULL,
  `oid` varchar(100) DEFAULT NULL,
  `uid` varchar(100) DEFAULT NULL,
  `reid` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(100) DEFAULT 'pending',
  PRIMARY KEY (`reid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `req` */

insert  into `req`(`fid`,`oid`,`uid`,`reid`,`status`) values ('1','1','2',1,'accepted');

/*Table structure for table `upload` */

DROP TABLE IF EXISTS `upload`;

CREATE TABLE `upload` (
  `fid` int(100) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(250) DEFAULT NULL,
  `actualfname` varchar(250) DEFAULT NULL,
  `encryptedfilename` varchar(250) DEFAULT NULL,
  `skeygenerated` varchar(250) DEFAULT NULL,
  `skeyownergenerated` varchar(250) DEFAULT NULL,
  `uid` varchar(100) DEFAULT NULL,
  `share` varchar(100) DEFAULT '0',
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `upload` */

insert  into `upload`(`fid`,`fname`,`actualfname`,`encryptedfilename`,`skeygenerated`,`skeyownergenerated`,`uid`,`share`) values (1,'vamsi.txt','test.txt','1652858810519testtxt.jpg','pVesa+B352gAmBegBNnABA==','4444','1','0'),(2,'balayya','balayya.txt','1652858894021balayyatxt.jpg','orf53ir2kqUMskUZd/PKMA==','5555','2','0');

/*Table structure for table `userreg` */

DROP TABLE IF EXISTS `userreg`;

CREATE TABLE `userreg` (
  `uid` int(50) unsigned NOT NULL AUTO_INCREMENT,
  `uname` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `gen` varchar(100) DEFAULT NULL,
  `aname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `userreg` */

insert  into `userreg`(`uid`,`uname`,`password`,`email`,`phone`,`gen`,`aname`) values (1,'vamsi','vamsi','vmskonakanchi@gmail.com','9705920956','male','hyderabad'),(2,'balayya','balayya','balayya@gmail.com','9705920956','male','hyderabad');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
