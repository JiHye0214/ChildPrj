SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS child_house;
DROP TABLE IF EXISTS kindergarden;
DROP TABLE IF EXISTS post_comment;
DROP TABLE IF EXISTS post_img;
DROP TABLE IF EXISTS recommend;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS product_comment;
DROP TABLE IF EXISTS product_img;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS zzim;
DROP TABLE IF EXISTS together;
DROP TABLE IF EXISTS user_authorities;
DROP TABLE IF EXISTS user_img;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_authority;




/* Create Tables */

CREATE TABLE child_house
(
	id int NOT NULL AUTO_INCREMENT,
	CRNAME varchar(255),
	CRTYPENAME varchar(255),
	CRADDR varchar(255),
	CRTELNO varchar(255),
	CRHOME varchar(1000),
	NRTRROOMCNT int,
	CRCAPAT int,
	CRCHCNT int,
	LA decimal(65,20),
	LO decimal(65,20),
	CRCARGBNAME varchar(255),
	PRIMARY KEY (id)
);


CREATE TABLE kindergarden
(
	id int NOT NULL AUTO_INCREMENT,
	KINDERNAME varchar(255),
	ESTABLISH varchar(255),
	LDGRNAME varchar(255),
	ODATE datetime,
	ADDR varchar(255),
	TELNO varchar(20),
	HPADDR varchar(1000),
	OPERTIME varchar(255),
	PRIMARY KEY (id)
);


CREATE TABLE post
(
	id int NOT NULL AUTO_INCREMENT,
	title varchar(50) NOT NULL,
	content longtext NOT NULL,
	viewCnt int DEFAULT 0 DEFAULT 0,
	recommendCnt int DEFAULT 0,
	createDate datetime DEFAULT now(),
	userId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE post_comment
(
	id int NOT NULL AUTO_INCREMENT,
	content text NOT NULL,
	createDate datetime DEFAULT now(),
	userId int NOT NULL,
	postId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE post_img
(
	id int NOT NULL AUTO_INCREMENT,
	sourceName varchar(100) NOT NULL,
	fileName varchar(100) NOT NULL,
	postId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE product
(
	id int NOT NULL AUTO_INCREMENT,
	productName varchar(50) NOT NULL,
	region varchar(50) NOT NULL,
	price int DEFAULT 0,
	content text NOT NULL,
	viewCnt int DEFAULT 0,
	createDate datetime DEFAULT now(),
	userId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE product_comment
(
	id int NOT NULL AUTO_INCREMENT,
	content text NOT NULL,
	createDate datetime DEFAULT now(),
	userId int NOT NULL,
	productId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE product_img
(
	id int NOT NULL AUTO_INCREMENT,
	sourceName varchar(100) NOT NULL,
	fileName varchar(100) NOT NULL,
	productId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE recommend
(
	userId int NOT NULL,
	postId int NOT NULL
);


CREATE TABLE together
(
	id int NOT NULL AUTO_INCREMENT,
	CODENAME varchar(255),
	GUNAME varchar(255),
	TITLE varchar(255),
	DATE varchar(255),
	PLACE varchar(255),
	ORG_NAME varchar(255),
	USE_TRGT varchar(255),
	USE_FEE varchar(255),
	ORG_LINK varchar(1000),
	MAIN_IMG varchar(255),
	STRTDATE varchar(255),
	END_DATE varchar(255),
	LOT double(65,20),
	LAT double(65,20),
	zzimCnt int DEFAULT 0,
	isZzimClicked varchar(10),
	PRIMARY KEY (id)
);


CREATE TABLE user
(
	id int NOT NULL AUTO_INCREMENT,
	loginId varchar(50) NOT NULL,
	password varchar(300) NOT NULL,
	nickName varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	email varchar(100) NOT NULL,
	createDate datetime DEFAULT now(),
	PRIMARY KEY (id),
	UNIQUE (loginId),
	UNIQUE (nickName),
	UNIQUE (email)
);


CREATE TABLE user_authorities
(
	userId int NOT NULL,
	authorityId int NOT NULL
);


CREATE TABLE user_authority
(
	id int NOT NULL AUTO_INCREMENT,
	authName varchar(50) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (authName)
);


CREATE TABLE user_img
(
	id int NOT NULL AUTO_INCREMENT,
	sourceName varchar(100) NOT NULL,
	fileName varchar(100) NOT NULL,
	userId int NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE zzim
(
	id int NOT NULL AUTO_INCREMENT,
-- 	title varchar(255) NOT NULL,
-- 	imgURL varchar(255),
-- 	period varchar(255) NOT NULL,
	userId int NOT NULL,
	togetherId int NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE post_comment
	ADD FOREIGN KEY (postId)
	REFERENCES post (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE post_img
	ADD FOREIGN KEY (postId)
	REFERENCES post (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE recommend
	ADD FOREIGN KEY (postId)
	REFERENCES post (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE product_comment
	ADD FOREIGN KEY (productId)
	REFERENCES product (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE product_img
	ADD FOREIGN KEY (productId)
	REFERENCES product (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE zzim
	ADD FOREIGN KEY (togetherId)
	REFERENCES together (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE post
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE post_comment
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE product
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE product_comment
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE recommend
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE user_authorities
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE user_img
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE zzim
	ADD FOREIGN KEY (userId)
	REFERENCES user (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE user_authorities
	ADD FOREIGN KEY (authorityId)
	REFERENCES user_authority (id)
	ON UPDATE RESTRICT
	ON DELETE CASCADE
;


ALTER TABLE kindergarden
ADD CONSTRAINT UC_kindergarden UNIQUE (KINDERNAME, LDGRNAME, ADDR);

ALTER TABLE child_house
ADD CONSTRAINT UC_child_house UNIQUE (CRNAME, CRADDR, CRTELNO);

ALTER TABLE together
ADD CONSTRAINT UC_together UNIQUE (TITLE, DATE, PLACE);




