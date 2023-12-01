/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : course_design

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 15/06/2023 11:49:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for depart_need
-- ----------------------------
DROP TABLE IF EXISTS `depart_need`;
CREATE TABLE `depart_need`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `need_num` int NOT NULL DEFAULT 0,
  `start_date` date NOT NULL,
  `isCplt` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`device_id`, `depart_id`, `start_date`) USING BTREE,
  INDEX `depart_id`(`depart_id` ASC) USING BTREE,
  CONSTRAINT `depart_need_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `depart_need_ibfk_2` FOREIGN KEY (`depart_id`) REFERENCES `department` (`depart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depart_need
-- ----------------------------
INSERT INTO `depart_need` VALUES ('137g2v', '07002', 10, '2022-12-15', 0);
INSERT INTO `depart_need` VALUES ('137g2v', '94646', 10, '2022-12-01', 1);
INSERT INTO `depart_need` VALUES ('137g2v', '94646', 2, '2022-12-05', 1);
INSERT INTO `depart_need` VALUES ('137g2v', '94646', 2, '2022-12-06', 1);
INSERT INTO `depart_need` VALUES ('137g2v', '94646', 10, '2022-12-08', 1);
INSERT INTO `depart_need` VALUES ('4j0zmn', '37955', 6, '2004-04-30', 1);
INSERT INTO `depart_need` VALUES ('4j0zmn', '37955', 14, '2022-12-12', 1);
INSERT INTO `depart_need` VALUES ('7009vf', '42156', 7, '2010-09-26', 1);
INSERT INTO `depart_need` VALUES ('8qcwg8', '75638', 13, '2000-03-23', 1);
INSERT INTO `depart_need` VALUES ('8qcwg8', '75638', 10, '2022-12-14', 1);
INSERT INTO `depart_need` VALUES ('ac199t', '68308', 40, '2002-10-17', 1);
INSERT INTO `depart_need` VALUES ('ef1h1b', '11607', 39, '2004-02-05', 1);
INSERT INTO `depart_need` VALUES ('ef1h1b', '94646', 10, '2022-12-14', 1);
INSERT INTO `depart_need` VALUES ('ewacsl', '37955', 19, '2000-06-07', 1);
INSERT INTO `depart_need` VALUES ('hpeorj', '18209', 16, '2018-02-21', 1);
INSERT INTO `depart_need` VALUES ('jqe8zv', '07002', 26, '2013-06-06', 1);
INSERT INTO `depart_need` VALUES ('jrdb6d', '43843', 5, '2021-07-22', 1);
INSERT INTO `depart_need` VALUES ('m1d6qz', '07002', 18, '2019-08-16', 1);
INSERT INTO `depart_need` VALUES ('m1d6qz', '93985', 35, '2010-08-27', 1);
INSERT INTO `depart_need` VALUES ('m1d6qz', '94646', 10, '2022-12-14', 1);
INSERT INTO `depart_need` VALUES ('m9dbte', '75638', 13, '2019-07-03', 1);
INSERT INTO `depart_need` VALUES ('p8kpm3', '11052', 5, '2022-10-13', 1);
INSERT INTO `depart_need` VALUES ('p8kpm3', '15329', 11, '2008-06-30', 1);
INSERT INTO `depart_need` VALUES ('p8kpm3', '37955', 12, '2022-12-12', 1);
INSERT INTO `depart_need` VALUES ('p8kpm3', '43843', 9, '2022-12-08', 1);
INSERT INTO `depart_need` VALUES ('p8kpm3', '93985', 3, '2022-12-13', 1);
INSERT INTO `depart_need` VALUES ('tfrwqi', '07002', 20, '2012-11-03', 1);
INSERT INTO `depart_need` VALUES ('v48w7v', '93985', 33, '2010-10-14', 1);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `depart_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `depart_per` smallint NOT NULL DEFAULT 0,
  `depart_work` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `depart_info` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`depart_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('07002', '赵有限责任公司', 228, '饮食业', 'Sometimes you win, sometimes you learn. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another.');
INSERT INTO `department` VALUES ('11052', '钱記发展贸易有限责任公司', 397, '贸易行业', 'I destroy my enemies when I make them my friends. The past has no power over the present moment. If the Show objects under schema in navigation pane option is checked at the Preferences window, all da');
INSERT INTO `department` VALUES ('11607', '向記电子有限责任公司', 283, '电子行业', 'A man is not old until regrets take the place of dreams. Sometimes you win, sometimes you learn. You cannot save people, you can just love them.');
INSERT INTO `department` VALUES ('15329', '云熙电脑有限责任公司', 881, '电子行业', 'I may not have gone where I intended to go, but I think I have ended up where I needed to be. Instead of wondering when your next vacation is, maybe you should set up a life you don’t need to escape');
INSERT INTO `department` VALUES ('16298', '睿食品有限责任公司', 335, '饮食业', 'To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. If you wait, all that happens is you get older.');
INSERT INTO `department` VALUES ('18209', '袁記贸易有限责任公司', 935, '金融服务业', 'SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections.');
INSERT INTO `department` VALUES ('30538', '嘉伦有限责任公司', 362, '饮食业', 'To get a secure connection, the first thing you need to do is to install OpenSSL Library and download Database Source.');
INSERT INTO `department` VALUES ('37955', '杰宏有限责任公司', 956, '咨询业', 'A query is used to extract data from the database in a readable format according to the user\'s request. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and ');
INSERT INTO `department` VALUES ('38857', '睿有限责任公司', 840, '工业', 'I may not have gone where I intended to go, but I think I have ended up where I needed to be. If it scares you, it might be a good thing to try.');
INSERT INTO `department` VALUES ('42156', '宇宁通讯有限责任公司', 204, '电讯業', 'If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane.');
INSERT INTO `department` VALUES ('43843', '杰宏玩具有限责任公司', 890, '制造业', 'In the middle of winter I at last discovered that there was in me an invincible summer. Creativity is intelligence having fun. I will greet this day with love in my heart.');
INSERT INTO `department` VALUES ('56730', '子异顾问有限责任公司', 789, '咨询业', 'Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly,');
INSERT INTO `department` VALUES ('65183', '子异有限责任公司', 814, '物流业', 'Anyone who has ever made anything of importance was disciplined. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database login information ');
INSERT INTO `department` VALUES ('68308', '高工业有限责任公司', 374, '工业', 'Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. A man’s best friends are his ten fingers. The reason why a great ');
INSERT INTO `department` VALUES ('70307', '璐物业代理有限责任公司', 830, '房地产业', 'In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. How we spend our days is, of course, how we spend our lives.');
INSERT INTO `department` VALUES ('75638', '詩涵有限责任公司', 910, '电子行业', 'Navicat is a multi-connections Database Administration tool allowing you to connect to MySQL, Oracle, PostgreSQL, SQLite, SQL Server, MariaDB and/or MongoDB databases, making database administration t');
INSERT INTO `department` VALUES ('76521', '江記顾问有限责任公司', 724, '咨询业', 'Genius is an infinite capacity for taking pains. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to');
INSERT INTO `department` VALUES ('80140', '詩涵有限责任公司', 649, '制造业', 'It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. What you get by achieving your goals is not as important as what you become by achieving your goal');
INSERT INTO `department` VALUES ('93985', '杰宏有限责任公司', 347, '资讯科技业', 'Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually.');
INSERT INTO `department` VALUES ('94646', '杰宏顾问有限责任公司', 609, '咨询业', 'Difficult circumstances serve as a textbook of life for people. Anyone who has never made a mistake has never tried anything new. HTTP Tunneling is a method for connecting to a server that uses the sa');

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `device_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `device_price` int NULL DEFAULT NULL,
  `device_info` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `vendor_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`device_id`) USING BTREE,
  INDEX `vendor_id`(`vendor_id` ASC) USING BTREE,
  CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`vendor_id`) REFERENCES `vendors` (`vendor_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devices
-- ----------------------------
INSERT INTO `devices` VALUES ('137g2v', 'aluots', 23, 'A man is not old until regrets take the place of dreams. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another.', '163579');
INSERT INTO `devices` VALUES ('1et3ar', 'Kiwi', 763, 'To connect to a database or schema, simply double-click it in the pane. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and GSSAPI authentication.', '096509');
INSERT INTO `devices` VALUES ('224i4s', 'Raspzerry elite', 70, 'A query is used to extract data from the database in a readable format according to the user\'s request. I will greet this day with love in my heart.', '253581');
INSERT INTO `devices` VALUES ('23d9bb', 'Cherry pro', 159, 'Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does.', '120258');
INSERT INTO `devices` VALUES ('2os2q7', 'Apple', 71, 'To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab. Champions keep playing until they get it right. After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and M', '096509');
INSERT INTO `devices` VALUES ('30gnnh', 'Apple', 126, 'It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored.', '148927');
INSERT INTO `devices` VALUES ('4er4ku', 'omni-Orange', 338, 'Genius is an infinite capacity for taking pains. It wasn’t raining when Noah built the ark. If the plan doesn’t work, change the plan, but never the goal. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being', '731273');
INSERT INTO `devices` VALUES ('4j0zmn', 'Grape se', 15, 'Import Wizard allows you to import data to tables/collections from CSV, TXT, XML, DBF and more. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information.', '037333');
INSERT INTO `devices` VALUES ('58y0nr', 'omni-Apple', 76, 'In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information.', '312824');
INSERT INTO `devices` VALUES ('5a1uof', 'Orsnge', 475, 'If it scares you, it might be a good thing to try. Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the database', '093139');
INSERT INTO `devices` VALUES ('5vqid3', 'Orange', 825, 'Difficult circumstances serve as a textbook of life for people. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your sessi', '093139');
INSERT INTO `devices` VALUES ('7009vf', 'Raypberry', 600, 'All the Navicat Cloud objects are located under different projects. You can share the project to other Navicat Cloud accounts for collaboration. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same', '253581');
INSERT INTO `devices` VALUES ('7mzbsu', 'Oradge pro', 250, 'Champions keep playing until they get it right. The first step is as good as half over. All journeys have secret destinations of which the traveler is unaware.', '163579');
INSERT INTO `devices` VALUES ('8qcwg8', 'Kiwi', 963, 'A query is used to extract data from the database in a readable format according to the user\'s request. Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and dat', '532641');
INSERT INTO `devices` VALUES ('8unqzc', 'aiwi mini', 597, 'It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server.', '781192');
INSERT INTO `devices` VALUES ('91gbob', 'aluots', 200, 'In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. Creativity is intelligence having fun.', '908689');
INSERT INTO `devices` VALUES ('ac199t', 'Raspborry', 430, 'Anyone who has ever made anything of importance was disciplined. You must be the change you wish to see in the world. Always keep your eyes open. Keep watching. Because whatever you see can inspire you. Optimism is the one quality more associated with success and happiness than any other.', '532641');
INSERT INTO `devices` VALUES ('atvvse', 'Raspbtrry', 343, 'Navicat Cloud provides a cloud service for synchronizing connections, queries, model files and virtual group information from Navicat, other Navicat family members, different machines and different platforms. How we spend our days is, of course, how we spend our lives.', '532641');
INSERT INTO `devices` VALUES ('b5pmmq', 'bpple', 295, 'If opportunity doesn’t knock, build a door. You must be the change you wish to see in the world. The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview.', '781192');
INSERT INTO `devices` VALUES ('by7sro', 'Mango', 553, 'The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview.', '307953');
INSERT INTO `devices` VALUES ('cta3gf', 'Apple air', 386, 'HTTP Tunneling is a method for connecting to a server that uses the same protocol (http://) and the same port (port 80) as a web server does. It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional de', '492177');
INSERT INTO `devices` VALUES ('dyn6on', 'iKiwi', 701, 'You must be the change you wish to see in the world. A man is not old until regrets take the place of dreams. Success consists of going from failure to failure without loss of enthusiasm. The first step is as good as half over. To start working with your server in Navicat, you should first establish', '096509');
INSERT INTO `devices` VALUES ('ef1h1b', 'Grape', 534, 'In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains the same information. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), a', '083093');
INSERT INTO `devices` VALUES ('ewacsl', 'Strawberly pro', 804, 'The Navigation pane employs tree structure which allows you to take action upon the database and their objects through their pop-up menus quickly and easily. You will succeed because most people are lazy.', '908689');
INSERT INTO `devices` VALUES ('g60y70', 'Appme pro', 252, 'The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored.', '781192');
INSERT INTO `devices` VALUES ('gdq820', 'lherry air', 462, 'To start working with your server in Navicat, you should first establish a connection or several connections using the Connection window. I will greet this day with love in my heart. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH)', '908689');
INSERT INTO `devices` VALUES ('h2xgmm', 'Grape core', 293, 'With its well-designed Graphical User Interface(GUI), Navicat lets you quickly and easily create, organize, access and share information in a secure and easy way.', '696756');
INSERT INTO `devices` VALUES ('hpeorj', 'Raspberty', 23, 'Navicat Cloud could not connect and access your databases. By which it means, it could only store your connection settings, queries, model files, and virtual group; your database passwords and data (e.g. tables, views, etc) will not be stored to Navicat Cloud.', '120258');
INSERT INTO `devices` VALUES ('ierv3d', 'Rambutan', 235, 'If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. Navicat authorizes you to make connection to remote servers running on different platforms (i.e. Windows, macOS, Linux and UNIX), and supports PAM and', '781192');
INSERT INTO `devices` VALUES ('jg2tb4', 'vrape', 239, 'Such sessions are also susceptible to session hijacking, where a malicious user takes over your session once you have authenticated. You must be the change you wish to see in the world.', '307953');
INSERT INTO `devices` VALUES ('jmy622', 'ambi-Apple', 928, 'In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. Navicat Monitor can be installed on any local computer or virtual machine and does not require any software installation on the servers being monitored.', '696756');
INSERT INTO `devices` VALUES ('jqe8zv', 'ultra-gluots', 450, 'Champions keep playing until they get it right. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats. Creativity is intelligence having fun. The On Startup feature allows you to control what tabs appear when you launch Navicat.', '532641');
INSERT INTO `devices` VALUES ('jrdb6d', 'Graae', 907, 'I destroy my enemies when I make them my friends. To clear or reload various internal caches, flush tables, or acquire locks, control-click your connection in the Navigation pane and select Flush and choose the flush option. You must have the reload privilege to use this feature.', '082519');
INSERT INTO `devices` VALUES ('kn1ds5', 'rherry elite', 623, 'If you wait, all that happens is you get older. In a Telnet session, all communications, including username and password, are transmitted in plain-text, allowing anyone to listen-in on your session and steal passwords and other information.', '163579');
INSERT INTO `devices` VALUES ('l635o1', 'niwi se', 435, 'A query is used to extract data from the database in a readable format according to the user\'s request. Sometimes you win, sometimes you learn. If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. Monitored ', '492177');
INSERT INTO `devices` VALUES ('m1d6qz', 'Graxe air', 256, 'After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections. SQL Editor allows you to create and edit SQL text, prepare and execute selected queries. To successfully establish a new connection to local/remote server - no matter via SS', '804876');
INSERT INTO `devices` VALUES ('m9dbte', 'ultra-Ogange', 425, 'It can also manage cloud databases such as Amazon Redshift, Amazon RDS, Alibaba Cloud. Features in Navicat are sophisticated enough to provide professional developers for all their specific needs, yet easy to learn for users who are new to database server.', '253581');
INSERT INTO `devices` VALUES ('nce4os', 'Orange', 922, 'If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed in the pane. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Clou', '696756');
INSERT INTO `devices` VALUES ('ofqc91', 'Mengo', 638, 'After logged in the Navicat Cloud feature, the Navigation pane will be divided into Navicat Cloud and My Connections sections.', '082519');
INSERT INTO `devices` VALUES ('p7tmzl', 'iCherry', 723, 'Navicat provides powerful tools for working with queries: Query Editor for editing the query text directly, and Query Builder, Find Builder or Aggregate Builder for building queries visually.', '037333');
INSERT INTO `devices` VALUES ('p8kpm3', 'Grape', 735, 'Creativity is intelligence having fun. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more.', '731273');
INSERT INTO `devices` VALUES ('plct4f', 'ultra-therry', 263, 'If your Internet Service Provider (ISP) does not provide direct access to its server, Secure Tunneling Protocol (SSH) / HTTP is another solution. The first step is as good as half over. To successfully establish a new connection to local/remote server - no matter via SSL, SSH or HTTP, set the databa', '492177');
INSERT INTO `devices` VALUES ('rxqqgu', 'hango', 287, 'If you wait, all that happens is you get older. It is used while your ISPs do not allow direct connections, but allows establishing HTTP connections. It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. Navicat is a multi-connections Database Admin', '892057');
INSERT INTO `devices` VALUES ('sbtqla', 'Raabutan', 797, 'If you wait, all that happens is you get older. A query is used to extract data from the database in a readable format according to the user\'s request. To successfully establish a new connection to local/remote server - no matter via SSL or SSH, set the database login information in the General tab.', '824007');
INSERT INTO `devices` VALUES ('tfrwqi', 'Mango', 598, 'How we spend our days is, of course, how we spend our lives. Actually it is just in an idea when feel oneself can achieve and cannot achieve.', '120258');
INSERT INTO `devices` VALUES ('tvq1rk', 'Kiwi', 744, 'The Information Pane shows the detailed object information, project activities, the DDL of database objects, object dependencies, membership of users/roles and preview. Navicat Data Modeler enables you to build high-quality conceptual, logical and physical data models for a wide variety of audiences', '824007');
INSERT INTO `devices` VALUES ('v11eqn', 'Strawberry', 273, 'The Main Window consists of several toolbars and panes for you to work on connections, database objects and advanced tools.', '908689');
INSERT INTO `devices` VALUES ('v48w7v', 'ambi-lpple', 20, 'The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance. The Synchronize to Database function will give you a full picture of all database differences.', '148927');
INSERT INTO `devices` VALUES ('xhqj0i', 'Pluots', 973, 'If you wait, all that happens is you get older. A query is used to extract data from the database in a readable format according to the user\'s request. In other words, Navicat provides the ability for data in different databases and/or schemas to be kept up-to-date so that each repository contains t', '731273');
INSERT INTO `devices` VALUES ('yzxpq8', 'Rambntan', 310, 'Navicat provides a wide range advanced features, such as compelling code editing capabilities, smart code-completion, SQL formatting, and more. Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to anot', '781192');

-- ----------------------------
-- Table structure for devices_back
-- ----------------------------
DROP TABLE IF EXISTS `devices_back`;
CREATE TABLE `devices_back`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `back_date` date NOT NULL,
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `back_num` int NOT NULL,
  `emp_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`device_id`, `back_date`, `depart_id`) USING BTREE,
  INDEX `depart_id`(`depart_id` ASC) USING BTREE,
  INDEX `emp_id`(`emp_id` ASC) USING BTREE,
  CONSTRAINT `devices_back_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices_out` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `devices_back_ibfk_2` FOREIGN KEY (`depart_id`) REFERENCES `devices_out` (`depart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `devices_back_ibfk_3` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devices_back
-- ----------------------------
INSERT INTO `devices_back` VALUES ('137g2v', '2022-12-08', '18209', 4, '287919');
INSERT INTO `devices_back` VALUES ('137g2v', '2022-12-10', '94646', 4, '049990');
INSERT INTO `devices_back` VALUES ('7009vf', '2022-12-05', '93985', 4, '275535');
INSERT INTO `devices_back` VALUES ('m1d6qz', '2022-12-16', '07002', 16, '049990');
INSERT INTO `devices_back` VALUES ('m1d6qz', '2022-12-16', '94646', 20, '051466');

-- ----------------------------
-- Table structure for devices_in
-- ----------------------------
DROP TABLE IF EXISTS `devices_in`;
CREATE TABLE `devices_in`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `in_date` date NOT NULL,
  `in_num` int NOT NULL,
  `emp_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`device_id`, `in_date`) USING BTREE,
  INDEX `emp_id`(`emp_id` ASC) USING BTREE,
  CONSTRAINT `devices_in_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `purchase_record` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `devices_in_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devices_in
-- ----------------------------
INSERT INTO `devices_in` VALUES ('137g2v', '2022-12-03', 10, '066044');
INSERT INTO `devices_in` VALUES ('137g2v', '2022-12-08', 4, '123634');
INSERT INTO `devices_in` VALUES ('137g2v', '2022-12-09', 10, '049990');
INSERT INTO `devices_in` VALUES ('4j0zmn', '2022-12-14', 20, '051466');
INSERT INTO `devices_in` VALUES ('7009vf', '2010-09-26', 7, '595736');
INSERT INTO `devices_in` VALUES ('8qcwg8', '2000-03-23', 13, '049990');
INSERT INTO `devices_in` VALUES ('8qcwg8', '2022-12-15', 10, '314211');
INSERT INTO `devices_in` VALUES ('ac199t', '2002-10-17', 40, '436261');
INSERT INTO `devices_in` VALUES ('ef1h1b', '2004-02-05', 39, '083784');
INSERT INTO `devices_in` VALUES ('ef1h1b', '2022-12-16', 10, '049990');
INSERT INTO `devices_in` VALUES ('ewacsl', '2000-06-07', 19, '783134');
INSERT INTO `devices_in` VALUES ('hpeorj', '2018-02-21', 16, '157703');
INSERT INTO `devices_in` VALUES ('jqe8zv', '2013-06-06', 26, '397534');
INSERT INTO `devices_in` VALUES ('jrdb6d', '2021-07-22', 5, '051466');
INSERT INTO `devices_in` VALUES ('m1d6qz', '2010-08-27', 35, '314211');
INSERT INTO `devices_in` VALUES ('m1d6qz', '2019-08-16', 18, '365654');
INSERT INTO `devices_in` VALUES ('m1d6qz', '2022-12-15', 10, '051466');
INSERT INTO `devices_in` VALUES ('m9dbte', '2019-07-03', 13, '603139');
INSERT INTO `devices_in` VALUES ('p8kpm3', '2008-06-30', 11, '436261');
INSERT INTO `devices_in` VALUES ('p8kpm3', '2022-10-13', 5, '049990');
INSERT INTO `devices_in` VALUES ('p8kpm3', '2022-12-08', 9, '049990');
INSERT INTO `devices_in` VALUES ('p8kpm3', '2022-12-12', 12, '049990');
INSERT INTO `devices_in` VALUES ('p8kpm3', '2022-12-13', 3, '049990');
INSERT INTO `devices_in` VALUES ('tfrwqi', '2012-11-03', 20, '379488');
INSERT INTO `devices_in` VALUES ('v48w7v', '2010-10-14', 33, '328129');

-- ----------------------------
-- Table structure for devices_out
-- ----------------------------
DROP TABLE IF EXISTS `devices_out`;
CREATE TABLE `devices_out`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `out_date` date NOT NULL,
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `out_num` int NOT NULL,
  `isBack` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`device_id`, `out_date`, `depart_id`) USING BTREE,
  INDEX `depart_id`(`depart_id` ASC) USING BTREE,
  CONSTRAINT `devices_out_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices_in` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `devices_out_ibfk_2` FOREIGN KEY (`depart_id`) REFERENCES `department` (`depart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devices_out
-- ----------------------------
INSERT INTO `devices_out` VALUES ('137g2v', '2022-12-08', '18209', 4, 1);
INSERT INTO `devices_out` VALUES ('137g2v', '2022-12-09', '94646', 4, 1);
INSERT INTO `devices_out` VALUES ('7009vf', '2022-12-04', '93985', 4, 1);
INSERT INTO `devices_out` VALUES ('m1d6qz', '2022-12-15', '94646', 20, 1);
INSERT INTO `devices_out` VALUES ('m1d6qz', '2022-12-16', '07002', 16, 1);

-- ----------------------------
-- Table structure for devices_remain
-- ----------------------------
DROP TABLE IF EXISTS `devices_remain`;
CREATE TABLE `devices_remain`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rema_num` int NOT NULL DEFAULT 0,
  `all_num` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`device_id`) USING BTREE,
  CONSTRAINT `devices_remain_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of devices_remain
-- ----------------------------
INSERT INTO `devices_remain` VALUES ('137g2v', 24, 24);
INSERT INTO `devices_remain` VALUES ('1et3ar', 0, 0);
INSERT INTO `devices_remain` VALUES ('224i4s', 0, 0);
INSERT INTO `devices_remain` VALUES ('23d9bb', 0, 0);
INSERT INTO `devices_remain` VALUES ('2os2q7', 0, 0);
INSERT INTO `devices_remain` VALUES ('30gnnh', 0, 0);
INSERT INTO `devices_remain` VALUES ('4er4ku', 0, 0);
INSERT INTO `devices_remain` VALUES ('4j0zmn', 40, 40);
INSERT INTO `devices_remain` VALUES ('58y0nr', 0, 0);
INSERT INTO `devices_remain` VALUES ('5a1uof', 0, 0);
INSERT INTO `devices_remain` VALUES ('5vqid3', 0, 0);
INSERT INTO `devices_remain` VALUES ('7009vf', 14, 14);
INSERT INTO `devices_remain` VALUES ('7mzbsu', 0, 0);
INSERT INTO `devices_remain` VALUES ('8qcwg8', 36, 36);
INSERT INTO `devices_remain` VALUES ('8unqzc', 0, 0);
INSERT INTO `devices_remain` VALUES ('91gbob', 0, 0);
INSERT INTO `devices_remain` VALUES ('ac199t', 80, 80);
INSERT INTO `devices_remain` VALUES ('atvvse', 0, 0);
INSERT INTO `devices_remain` VALUES ('b5pmmq', 0, 0);
INSERT INTO `devices_remain` VALUES ('by7sro', 0, 0);
INSERT INTO `devices_remain` VALUES ('cta3gf', 0, 0);
INSERT INTO `devices_remain` VALUES ('dyn6on', 0, 0);
INSERT INTO `devices_remain` VALUES ('ef1h1b', 88, 88);
INSERT INTO `devices_remain` VALUES ('ewacsl', 38, 38);
INSERT INTO `devices_remain` VALUES ('g60y70', 0, 0);
INSERT INTO `devices_remain` VALUES ('gdq820', 0, 0);
INSERT INTO `devices_remain` VALUES ('h2xgmm', 0, 0);
INSERT INTO `devices_remain` VALUES ('hpeorj', 32, 32);
INSERT INTO `devices_remain` VALUES ('ierv3d', 0, 0);
INSERT INTO `devices_remain` VALUES ('jg2tb4', 0, 0);
INSERT INTO `devices_remain` VALUES ('jmy622', 0, 0);
INSERT INTO `devices_remain` VALUES ('jqe8zv', 52, 52);
INSERT INTO `devices_remain` VALUES ('jrdb6d', 10, 10);
INSERT INTO `devices_remain` VALUES ('kn1ds5', 0, 0);
INSERT INTO `devices_remain` VALUES ('l635o1', 0, 0);
INSERT INTO `devices_remain` VALUES ('m1d6qz', 116, 116);
INSERT INTO `devices_remain` VALUES ('m9dbte', 26, 26);
INSERT INTO `devices_remain` VALUES ('nce4os', 0, 0);
INSERT INTO `devices_remain` VALUES ('ofqc91', 0, 0);
INSERT INTO `devices_remain` VALUES ('p7tmzl', 0, 0);
INSERT INTO `devices_remain` VALUES ('p8kpm3', 80, 80);
INSERT INTO `devices_remain` VALUES ('plct4f', 0, 0);
INSERT INTO `devices_remain` VALUES ('rxqqgu', 0, 0);
INSERT INTO `devices_remain` VALUES ('sbtqla', 0, 0);
INSERT INTO `devices_remain` VALUES ('tfrwqi', 40, 40);
INSERT INTO `devices_remain` VALUES ('tvq1rk', 0, 0);
INSERT INTO `devices_remain` VALUES ('v11eqn', 0, 0);
INSERT INTO `devices_remain` VALUES ('v48w7v', 66, 66);
INSERT INTO `devices_remain` VALUES ('xhqj0i', 0, 0);
INSERT INTO `devices_remain` VALUES ('yzxpq8', 0, 0);

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `emp_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `emp_phone` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE,
  INDEX `depart_id`(`depart_id` ASC) USING BTREE,
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`depart_id`) REFERENCES `department` (`depart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('049990', '史宇宁', '12345678989', '37955');
INSERT INTO `employee` VALUES ('051466', '王璐', '12345678900', '37955');
INSERT INTO `employee` VALUES ('066044', '金安琪', '6014785910', '37955');
INSERT INTO `employee` VALUES ('083784', '许晓明', '9349192701', '56730');
INSERT INTO `employee` VALUES ('123634', '尹嘉伦', '5741804698', '76521');
INSERT INTO `employee` VALUES ('128272', '程安琪', '2708232260', '65183');
INSERT INTO `employee` VALUES ('157703', '韩璐', '8158837731', '30538');
INSERT INTO `employee` VALUES ('255345', '谭安琪', '8026592494', '42156');
INSERT INTO `employee` VALUES ('275535', '叶云熙', '4410126619', '94646');
INSERT INTO `employee` VALUES ('287919', '马詩涵', '1648282395', '15329');
INSERT INTO `employee` VALUES ('314211', '罗宇宁', '5320803609', '68308');
INSERT INTO `employee` VALUES ('328129', '汤震南', '0652340055', '11607');
INSERT INTO `employee` VALUES ('328550', '范璐', '6623331066', '93985');
INSERT INTO `employee` VALUES ('339135', '史晓明', '8825161987', '11052');
INSERT INTO `employee` VALUES ('346376', '王晓明', '5121060896', '15329');
INSERT INTO `employee` VALUES ('356702', '吕秀英', '6448427655', '42156');
INSERT INTO `employee` VALUES ('365654', '谭震南', '1639417502', '16298');
INSERT INTO `employee` VALUES ('379488', '邵晓明', '9943278402', '43843');
INSERT INTO `employee` VALUES ('382624', '程云熙', '7363649056', '15329');
INSERT INTO `employee` VALUES ('397534', '毛秀英', '3437152516', '75638');
INSERT INTO `employee` VALUES ('436261', '姚嘉伦', '0678695957', '37955');
INSERT INTO `employee` VALUES ('458881', '郑詩涵', '2670905973', '07002');
INSERT INTO `employee` VALUES ('466634', '邓震南', '7941395125', '94646');
INSERT INTO `employee` VALUES ('504313', '程璐', '6542548413', '75638');
INSERT INTO `employee` VALUES ('541373', '赵子异', '9570687982', '94646');
INSERT INTO `employee` VALUES ('554494', '何云熙', '6238755801', '93985');
INSERT INTO `employee` VALUES ('556469', '薛秀英', '8239465378', '93985');
INSERT INTO `employee` VALUES ('566845', '夏致远', '5458734566', '11052');
INSERT INTO `employee` VALUES ('595736', '魏云熙', '8937995617', '65183');
INSERT INTO `employee` VALUES ('596794', '丁云熙', '0852844637', '75638');
INSERT INTO `employee` VALUES ('603139', '钱岚', '5093770541', '93985');
INSERT INTO `employee` VALUES ('606210', '黎秀英', '6170158869', '30538');
INSERT INTO `employee` VALUES ('689750', '叶子韬', '8116747045', '16298');
INSERT INTO `employee` VALUES ('708554', '杨晓明', '9194880743', '65183');
INSERT INTO `employee` VALUES ('723495', '钱云熙', '5050103585', '76521');
INSERT INTO `employee` VALUES ('763174', '谭子异', '9115989961', '18209');
INSERT INTO `employee` VALUES ('776682', '韩岚', '9911978561', '68308');
INSERT INTO `employee` VALUES ('778912', '梁致远', '9145320909', '30538');
INSERT INTO `employee` VALUES ('783134', '金子韬', '6699087720', '76521');
INSERT INTO `employee` VALUES ('791048', '钱嘉伦', '3969334056', '94646');
INSERT INTO `employee` VALUES ('799235', '魏秀英', '6435348522', '11052');
INSERT INTO `employee` VALUES ('800973', '陆震南', '0094625013', '65183');
INSERT INTO `employee` VALUES ('805794', '金安琪', '9796657865', '18209');
INSERT INTO `employee` VALUES ('847424', '段杰宏', '9061129837', '11607');
INSERT INTO `employee` VALUES ('847476', '彭秀英', '4118088536', '16298');
INSERT INTO `employee` VALUES ('859948', '钱子韬', '5643730957', '37955');
INSERT INTO `employee` VALUES ('876165', '沈睿', '1860215318', '43843');
INSERT INTO `employee` VALUES ('876459', '袁睿', '1743079202', '75638');
INSERT INTO `employee` VALUES ('960117', '龚宇宁', '8790023148', '07002');
INSERT INTO `employee` VALUES ('994474', '程嘉伦', '7849029119', '43843');

-- ----------------------------
-- Table structure for purchase_record
-- ----------------------------
DROP TABLE IF EXISTS `purchase_record`;
CREATE TABLE `purchase_record`  (
  `device_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `depart_id` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `purchase_date` date NOT NULL,
  `purchase_num` int NOT NULL DEFAULT 0,
  `purchase_emp` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `isInStock` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`device_id`, `depart_id`, `purchase_date`) USING BTREE,
  INDEX `depart_id`(`depart_id` ASC) USING BTREE,
  INDEX `purchase_emp`(`purchase_emp` ASC) USING BTREE,
  CONSTRAINT `purchase_record_ibfk_1` FOREIGN KEY (`device_id`) REFERENCES `devices` (`device_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `purchase_record_ibfk_2` FOREIGN KEY (`depart_id`) REFERENCES `department` (`depart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `purchase_record_ibfk_3` FOREIGN KEY (`purchase_emp`) REFERENCES `employee` (`emp_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase_record
-- ----------------------------
INSERT INTO `purchase_record` VALUES ('137g2v', '37955', '2022-12-07', 4, '123634', 1);
INSERT INTO `purchase_record` VALUES ('137g2v', '94646', '2022-01-08', 10, '049990', 1);
INSERT INTO `purchase_record` VALUES ('137g2v', '94646', '2022-12-02', 10, '051466', 1);
INSERT INTO `purchase_record` VALUES ('4j0zmn', '37955', '2004-04-30', 6, '051466', 1);
INSERT INTO `purchase_record` VALUES ('4j0zmn', '37955', '2022-12-12', 14, '595736', 1);
INSERT INTO `purchase_record` VALUES ('7009vf', '42156', '2010-09-26', 7, '049990', 1);
INSERT INTO `purchase_record` VALUES ('8qcwg8', '75638', '2000-03-23', 13, '436261', 1);
INSERT INTO `purchase_record` VALUES ('8qcwg8', '75638', '2022-12-15', 10, '049990', 1);
INSERT INTO `purchase_record` VALUES ('ac199t', '68308', '2002-10-17', 40, '083784', 1);
INSERT INTO `purchase_record` VALUES ('ef1h1b', '11607', '2004-02-05', 39, '783134', 1);
INSERT INTO `purchase_record` VALUES ('ef1h1b', '94646', '2022-12-15', 10, '049990', 1);
INSERT INTO `purchase_record` VALUES ('ewacsl', '37955', '2000-06-07', 19, '157703', 1);
INSERT INTO `purchase_record` VALUES ('hpeorj', '18209', '2018-02-21', 16, '397534', 1);
INSERT INTO `purchase_record` VALUES ('jqe8zv', '07002', '2013-06-06', 26, '051466', 1);
INSERT INTO `purchase_record` VALUES ('jrdb6d', '43843', '2021-07-22', 5, '314211', 1);
INSERT INTO `purchase_record` VALUES ('m1d6qz', '07002', '2019-08-16', 18, '365654', 1);
INSERT INTO `purchase_record` VALUES ('m1d6qz', '93985', '2010-08-27', 35, '603139', 1);
INSERT INTO `purchase_record` VALUES ('m1d6qz', '94646', '2022-12-14', 10, '051466', 1);
INSERT INTO `purchase_record` VALUES ('m9dbte', '75638', '2019-07-03', 13, '436261', 1);
INSERT INTO `purchase_record` VALUES ('p8kpm3', '11052', '2022-10-13', 5, '049990', 1);
INSERT INTO `purchase_record` VALUES ('p8kpm3', '15329', '2008-06-30', 11, '049990', 1);
INSERT INTO `purchase_record` VALUES ('p8kpm3', '37955', '2022-12-12', 12, '049990', 1);
INSERT INTO `purchase_record` VALUES ('p8kpm3', '43843', '2022-12-08', 9, '049990', 1);
INSERT INTO `purchase_record` VALUES ('p8kpm3', '93985', '2022-12-13', 3, '379488', 1);
INSERT INTO `purchase_record` VALUES ('tfrwqi', '07002', '2012-11-03', 20, '328129', 1);
INSERT INTO `purchase_record` VALUES ('v48w7v', '93985', '2010-10-14', 33, '994474', 1);

-- ----------------------------
-- Table structure for vendors
-- ----------------------------
DROP TABLE IF EXISTS `vendors`;
CREATE TABLE `vendors`  (
  `vendor_id` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `vendor_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `vendor_address` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `vendor_country` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`vendor_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendors
-- ----------------------------
INSERT INTO `vendors` VALUES ('037333', '华为有限责任公司', '深圳', '英国');
INSERT INTO `vendors` VALUES ('082519', '宇宁系统有限责任公司', '24 Broadway', '美国');
INSERT INTO `vendors` VALUES ('083093', '严記玩具有限责任公司', '成华区二仙桥东三路311号', '中国');
INSERT INTO `vendors` VALUES ('093139', '震南玩具有限责任公司', '984 Canal Street', '美国');
INSERT INTO `vendors` VALUES ('096509', '段記有限责任公司', '345 North Michigan Ave', '美国');
INSERT INTO `vendors` VALUES ('120258', '嘉伦制药有限责任公司', '681 Maddox Street', '英国');
INSERT INTO `vendors` VALUES ('148927', '秀英电讯有限责任公司', '105 Cyril St, Braunstone Town', '英国');
INSERT INTO `vendors` VALUES ('163579', '子韬有限责任公司', '220 Cannon Street', '英国');
INSERT INTO `vendors` VALUES ('253581', '秀英工程有限责任公司', '79 Fern Street', '美国');
INSERT INTO `vendors` VALUES ('307953', '江記有限责任公司', '938 Rush Street', '美国');
INSERT INTO `vendors` VALUES ('312824', '陈記电脑有限责任公司', '紫马岭商圈中山五路175号', '中国');
INSERT INTO `vendors` VALUES ('492177', '致远顾问有限责任公司', '罗湖区蔡屋围深南东路141号', '中国');
INSERT INTO `vendors` VALUES ('532641', '岚工程有限责任公司', '193 39 William IV St, Charing Cross', '英国');
INSERT INTO `vendors` VALUES ('696756', '曾記物业代理有限责任公司', '669 Hanover St', '英国');
INSERT INTO `vendors` VALUES ('731273', '林記玩具有限责任公司', '黄浦区淮海中路188号', '中国');
INSERT INTO `vendors` VALUES ('781192', '孔記有限责任公司', '769 Wyngate Dr', '英国');
INSERT INTO `vendors` VALUES ('804876', '晓明有限责任公司', '815 Aigburth Rd, Aigburth', '英国');
INSERT INTO `vendors` VALUES ('824007', '的撒发生', '369 Abingdon Rd, Cumnor', '英国');
INSERT INTO `vendors` VALUES ('892057', '曾記有限责任公司', '京华商圈华夏街30号', '中国');
INSERT INTO `vendors` VALUES ('908689', '唐記制药有限责任公司', '闵行区宾川路401号', '中国');

-- ----------------------------
-- View structure for allinfoofdev
-- ----------------------------
DROP VIEW IF EXISTS `allinfoofdev`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `allinfoofdev` AS select `devices`.`device_id` AS `device_id`,`devices`.`device_name` AS `device_name`,`devices_remain`.`rema_num` AS `rema_num`,`devices_remain`.`all_num` AS `all_num`,`depart_need`.`need_num` AS `need_num` from ((`devices` join `devices_remain` on((`devices`.`device_id` = `devices_remain`.`device_id`))) left join `depart_need` on(((`devices_remain`.`device_id` = `depart_need`.`device_id`) and (`depart_need`.`isCplt` = false))));

-- ----------------------------
-- View structure for backdevinfo
-- ----------------------------
DROP VIEW IF EXISTS `backdevinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `backdevinfo` AS select `devices`.`device_id` AS `device_id`,`devices`.`device_name` AS `device_name`,`devices_back`.`back_date` AS `back_date`,`devices_back`.`back_num` AS `back_num`,`devices_back`.`depart_id` AS `depart_id`,`department`.`depart_name` AS `depart_name`,`department`.`depart_per` AS `depart_per`,`department`.`depart_work` AS `depart_work` from ((`devices` join `devices_back`) join `department`) where ((`devices`.`device_id` = `devices_back`.`device_id`) and (`devices_back`.`depart_id` = `department`.`depart_id`));

-- ----------------------------
-- View structure for devandvend
-- ----------------------------
DROP VIEW IF EXISTS `devandvend`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `devandvend` AS select `devices`.`device_id` AS `device_id`,`devices`.`device_name` AS `device_name`,`devices`.`device_price` AS `device_price`,`devices`.`vendor_id` AS `vendor_id`,`vendors`.`vendor_name` AS `vendor_name`,`vendors`.`vendor_address` AS `vendor_address`,`vendors`.`vendor_country` AS `vendor_country` from (`devices` join `vendors`) where (`devices`.`vendor_id` = `vendors`.`vendor_id`);

-- ----------------------------
-- View structure for devinandrem
-- ----------------------------
DROP VIEW IF EXISTS `devinandrem`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `devinandrem` AS select `devices_in`.`device_id` AS `device_id`,`devices_in`.`in_num` AS `in_num`,`devices_in`.`in_date` AS `in_date`,`devices_remain`.`rema_num` AS `rema_num`,`devices_remain`.`all_num` AS `all_num` from (`devices_in` join `devices_remain` on((`devices_in`.`device_id` = `devices_remain`.`device_id`)));

-- ----------------------------
-- View structure for indevinfo
-- ----------------------------
DROP VIEW IF EXISTS `indevinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `indevinfo` AS select `devices`.`device_id` AS `device_id`,`devices`.`device_name` AS `device_name`,`devices_in`.`in_date` AS `in_date`,`devices_in`.`in_num` AS `in_num`,`devices_in`.`emp_id` AS `emp_id`,`employee`.`emp_name` AS `emp_name`,`employee`.`emp_phone` AS `emp_phone`,`employee`.`depart_id` AS `depart_id` from ((`devices` join `devices_in`) join `employee`) where ((`devices`.`device_id` = `devices_in`.`device_id`) and (`devices_in`.`emp_id` = `employee`.`emp_id`));

-- ----------------------------
-- View structure for outdevinfo
-- ----------------------------
DROP VIEW IF EXISTS `outdevinfo`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `outdevinfo` AS select `devices`.`device_id` AS `device_id`,`devices`.`device_name` AS `device_name`,`devices_out`.`out_date` AS `out_date`,`devices_out`.`out_num` AS `out_num`,`devices_out`.`depart_id` AS `depart_id`,`department`.`depart_name` AS `depart_name`,`department`.`depart_per` AS `depart_per`,`department`.`depart_work` AS `depart_work` from ((`devices` join `devices_out`) join `department`) where ((`devices`.`device_id` = `devices_out`.`device_id`) and (`devices_out`.`depart_id` = `department`.`depart_id`));

-- ----------------------------
-- Procedure structure for backStock
-- ----------------------------
DROP PROCEDURE IF EXISTS `backStock`;
delimiter ;;
CREATE PROCEDURE `backStock`(IN devId CHAR(6),IN departId CHAR(5),IN backDate DATE,IN empId CHAR(6),OUT isBack boolean)
BEGIN
	# 还库操作
	DECLARE num INT;
	SET num = 0;
	
	# 看是否存在出库记录
	SELECT SUM(out_num) INTO num 
	FROM devices_out
	WHERE device_id = devId
	AND   depart_id = departId;
	
	IF num = 0 THEN
	  SET isBack = FALSE;
	ELSE
	  INSERT INTO devices_back(device_id,back_date,back_num,depart_id,emp_id)
		VALUES(devId,backDate,num,departId,empId);
		SET isBack = TRUE;
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for delNeed
-- ----------------------------
DROP PROCEDURE IF EXISTS `delNeed`;
delimiter ;;
CREATE PROCEDURE `delNeed`(IN devId CHAR(6),IN depId CHAR(5),IN startDate DATE,OUT isCpt INT)
BEGIN
	#需求注销
	SET isCpt = -1;
	
	SELECT isCplt INTO isCpt
	FROM depart_need
	WHERE device_id = devId
	AND   depart_id = depId
	AND   start_date = startDate;
	
	IF isCpt = 0 THEN
	  DELETE FROM depart_need
		WHERE device_id = devId
		AND   depart_id = depId
		AND   start_date = startDate;
	END IF;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for demo2
-- ----------------------------
DROP PROCEDURE IF EXISTS `demo2`;
delimiter ;;
CREATE PROCEDURE `demo2`(IN Cid1 INT ,OUT avgvalue INT)
BEGIN
SELECT AVG(Cvalue) INTO avgvalue
FROM value1
WHERE Cid = Cid1;
		SELECT avgvalue;
	END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for inStock
-- ----------------------------
DROP PROCEDURE IF EXISTS `inStock`;
delimiter ;;
CREATE PROCEDURE `inStock`(IN devId CHAR(6),IN inDate DATE,IN empId CHAR(6),OUT isIn boolean)
BEGIN	
	#进行入库操作并更新库存信息
	DECLARE inNum INT;
	SET inNum = 0;
	
	-- 看是否已经采购
	SELECT SUM(purchase_num) INTO inNum
	FROM purchase_record
	WHERE device_id = devId
	AND   isInStock = FALSE;
	
	IF inNum = 0 THEN
	  SET isIn = FALSE;
	ELSE
	  SET isIn = TRUE;
		INSERT INTO devices_in(device_id,in_date,in_num,emp_id)
		VALUES(devId,inDate,inNum,empId);
	END IF;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for needRecord
-- ----------------------------
DROP PROCEDURE IF EXISTS `needRecord`;
delimiter ;;
CREATE PROCEDURE `needRecord`(IN devId CHAR(6),IN departId CHAR(5),IN needNum INT,IN startDate DATE,OUT isSuc boolean)
BEGIN
	#需求登记
	SET isSuc = FALSE;
	INSERT INTO depart_need(device_id,depart_id,need_num,start_date)
	VALUES(devId,departId,needNum,startDate);	
	SET isSuc = TRUE;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for onceupdate_aft_in
-- ----------------------------
DROP PROCEDURE IF EXISTS `onceupdate_aft_in`;
delimiter ;;
CREATE PROCEDURE `onceupdate_aft_in`()
BEGIN
  # 设备成功入库后进行库存更新（初始入库）
	DECLARE done Boolean DEFAULT(0);
	DECLARE id CHAR(6);
	DECLARE num1 INT;
	DECLARE num2 INT;
	
	DECLARE cursor_inUpdate CURSOR
	FOR 
	SELECT device_id,(in_num+rema_num) AS newRm_num,(in_num+all_num) AS newAllNum
	FROM devinandrem;
	
	DECLARE CONTINUE HANDLER FOR SQLSTATE '02000'  SET done =1;
	
	OPEN cursor_inUpdate;
	
	REPEAT
	   FETCH cursor_inUpdate INTO id,num1,num2;
		 UPDATE devices_remain
		 SET rema_num = num1,
		     all_num = num2
		 WHERE device_id = id;
UNTIL done END REPEAT;
  CLOSE cursor_inUpdate;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for outStock
-- ----------------------------
DROP PROCEDURE IF EXISTS `outStock`;
delimiter ;;
CREATE PROCEDURE `outStock`(IN devId CHAR(6),IN departId CHAR(5),IN outNum INT,IN outDate DATE,OUT isOut BOOLEAN)
BEGIN
	#进行出库操作
	DECLARE rmNum INT;
	SET rmNum = 0;
	
	SELECT rema_num INTO rmNum
	FROM devices_remain
	WHERE device_id = devId;
	
	IF rmNum < outNum THEN
	   SET isOut = FALSE;
	 ELSE
	   INSERT INTO devices_out(device_id,out_date,out_num,depart_id)
		 VALUES(devId,outDate,outNum,departId);
		 SET isOut = TRUE;
	 END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for purchaseDev
-- ----------------------------
DROP PROCEDURE IF EXISTS `purchaseDev`;
delimiter ;;
CREATE PROCEDURE `purchaseDev`(IN devId CHAR(6),IN departId CHAR(5),IN date DATE,IN empId CHAR(6),OUT isSuc boolean)
BEGIN
	#将需求表中的某一设备进行采购
	DECLARE num INT;
	SET num = 0;
	SET isSuc = FALSE;
	
	#查看部门是否有需求
	SELECT SUM(need_num) INTO num
	FROM depart_need
	WHERE device_id = devId
	AND   isCplt = FALSE;
	
	IF num != 0 THEN
	  INSERT INTO purchase_record(device_id,depart_id,purchase_date,purchase_num,purchase_emp)
		VALUES(devId,departId,date,num,empId);
		SET isSuc = TRUE;
	END IF;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for statisGet
-- ----------------------------
DROP PROCEDURE IF EXISTS `statisGet`;
delimiter ;;
CREATE PROCEDURE `statisGet`(OUT devNum INT,OUT devTypeNum INT,OUT depNum INT,OUT vedNum INT)
BEGIN
	#信息统计
	SELECT SUM(rema_num),COUNT(rema_num)INTO devNum,devTypeNum
	FROM devices_remain
	WHERE rema_num != 0;
	
	SELECT COUNT(depart_id) INTO depNum
	FROM department;
	
	SELECT COUNT(vendor_id) INTO vedNum
	FROM vendors;	

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_after_back
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_after_back`;
delimiter ;;
CREATE PROCEDURE `update_after_back`(IN devId CHAR(6),IN backNum INT,IN departId CHAR(5))
BEGIN
	#还库后对库存和出库表进行更新
	DECLARE newNum1 INT;
	
	SELECT rema_num INTO newNum1
	FROM devices_remain
	WHERE device_id = devId;
	
	SET newNum1 = newNum1 + backNum;
	
	-- 库存表更新
	UPDATE devices_remain
	SET rema_num = newNum1
	WHERE device_id = devId;
	
	-- 出库表更新
	UPDATE devices_out
	SET isBack = TRUE
	WHERE device_id = devId 
	AND   depart_id = departId;
	
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_aft_in
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_aft_in`;
delimiter ;;
CREATE PROCEDURE `update_aft_in`(IN dev_id CHAR(6),IN inNum INT)
BEGIN
  # 单次入库操作后更新库存
	DECLARE num1 INT;
	DECLARE num2 INT;
	
	SELECT rema_num,all_num INTO num1,num2
	FROM devices_remain
	WHERE device_id = dev_id;	
	
	-- 更新库存
	SET num1 = num1 + inNum;
	SET num2 = num2 + inNum;
	UPDATE devices_remain
	SET rema_num = num1,
		  all_num = num2
	WHERE device_id = dev_id;
	
	-- 更新采购表
	UPDATE purchase_record
	SET isInStock = TRUE
	WHERE device_id = dev_id;

END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_aft_out
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_aft_out`;
delimiter ;;
CREATE PROCEDURE `update_aft_out`(IN devId CHAR(6),IN outNum INT)
BEGIN
	# 出库后库存更新
	DECLARE num1 INT;

	SELECT rema_num INTO num1
	FROM devices_remain
	WHERE device_id = devId;
	
	SET num1 = num1 - outNum;
	
	UPDATE devices_remain
	SET rema_num = num1
	WHERE device_id = devId;
	
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_aft_pc
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_aft_pc`;
delimiter ;;
CREATE PROCEDURE `update_aft_pc`(IN devId CHAR(6))
BEGIN
	#采购后进行需求表更新
	UPDATE depart_need
	SET isCplt = TRUE
	WHERE device_id = devId;

END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table devices_back
-- ----------------------------
DROP TRIGGER IF EXISTS `devBackUpdate`;
delimiter ;;
CREATE TRIGGER `devBackUpdate` AFTER INSERT ON `devices_back` FOR EACH ROW BEGIN
	#还库后对库存和出库表进行更新
	DECLARE num INT;
	
	SELECT rema_num INTO num
	FROM devices_remain
	WHERE device_id = NEW.device_id;
	
	SET num = num + NEW.back_num;
	
	-- 库存更新
	UPDATE devices_remain
	SET rema_num = num
	WHERE device_id = NEW.device_id;
	
	-- 出库表更新
	UPDATE devices_out
	SET isBack = TRUE
	WHERE device_id = NEW.device_id 
	AND   depart_id = NEW.depart_id;
	
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table devices_in
-- ----------------------------
DROP TRIGGER IF EXISTS `devInUpdate`;
delimiter ;;
CREATE TRIGGER `devInUpdate` AFTER INSERT ON `devices_in` FOR EACH ROW BEGIN
  # 单次入库操作后更新库存
	DECLARE num1 INT;
	DECLARE num2 INT;
	
	SELECT rema_num,all_num INTO num1,num2
	FROM devices_remain
	WHERE device_id = NEW.device_id;	
	
	-- 更新库存
	SET num1 = num1 + NEW.in_num;
	SET num2 = num2 + NEW.in_num;
	
	UPDATE devices_remain
	SET rema_num = num1,
		  all_num = num2
	WHERE device_id = NEW.device_id;
	
	-- 更新采购表
	UPDATE purchase_record
	SET isInStock = TRUE
	WHERE device_id = NEW.device_id;

END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table devices_out
-- ----------------------------
DROP TRIGGER IF EXISTS `devOutUpdate`;
delimiter ;;
CREATE TRIGGER `devOutUpdate` AFTER INSERT ON `devices_out` FOR EACH ROW BEGIN
	# 出库后库存更新
	DECLARE num1 INT;

	SELECT rema_num INTO num1
	FROM devices_remain
	WHERE device_id = NEW.device_id;
	
	SET num1 = num1 - NEW.out_num;
	
	UPDATE devices_remain
	SET rema_num = num1
	WHERE device_id = NEW.device_id;
	
END
;;
delimiter ;

-- ----------------------------
-- Triggers structure for table purchase_record
-- ----------------------------
DROP TRIGGER IF EXISTS `devPcUpdate`;
delimiter ;;
CREATE TRIGGER `devPcUpdate` AFTER INSERT ON `purchase_record` FOR EACH ROW BEGIN
	#采购后进行需求表更新
	UPDATE depart_need
	SET isCplt = TRUE
	WHERE device_id = NEW.device_id;

END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
