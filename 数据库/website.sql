-- MySQL Script generated by MySQL Workbench
-- 10/27/16 10:13:41
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema website
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `website` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `website` ;

-- -----------------------------------------------------
-- Table `website`.`job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`job` (
  `job_id` INT NOT NULL COMMENT '工作代码',
  `job_name` VARCHAR(20) NOT NULL COMMENT '对应的代码的工作名称',
  PRIMARY KEY (`job_id`),
  UNIQUE INDEX `job_name_UNIQUE` (`job_name` ASC))
ENGINE = InnoDB
COMMENT = '程序员细分代码表,分为安卓工程师，ios工程师，前端工程师，数据库工程师，后端工程师，运维工程师，其他';


-- -----------------------------------------------------
-- Table `website`.`user_basic_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`user_basic_information` (
  `user_basic_information_id` INT NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_basic_information_birthday` DATE NULL COMMENT '用户生日',
  `user_basic_information_gender` TINYINT(1) NULL COMMENT '用户性别',
  `user_basic_information_address` VARCHAR(45) NULL COMMENT '用户住址',
  `user_basic_information_register_time` DATETIME NOT NULL COMMENT '注册时间',
  `job_id` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_basic_information_id`),
  INDEX `fk_user_basic_information_job_idx` (`job_id` ASC),
  UNIQUE INDEX `job_id_UNIQUE` (`job_id` ASC),
  CONSTRAINT `fk_user_basic_information_job`
    FOREIGN KEY (`job_id`)
    REFERENCES `website`.`job` (`job_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '用户基本信息表';


-- -----------------------------------------------------
-- Table `website`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`account` (
  `account_user_name` VARCHAR(20) NOT NULL COMMENT '注册用户名',
  `account_password` VARCHAR(20) NOT NULL COMMENT '注册密码',
  `account_isonline` TINYINT(1) NOT NULL COMMENT '是否在线',
  `user_basic_information_job_id` INT NOT NULL,
  PRIMARY KEY (`user_basic_information_job_id`),
  INDEX `fk_account_user_basic_information1_idx` (`user_basic_information_job_id` ASC),
  CONSTRAINT `fk_account_user_basic_information1`
    FOREIGN KEY (`user_basic_information_job_id`)
    REFERENCES `website`.`user_basic_information` (`job_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '账户表，包含用户名和密码';


-- -----------------------------------------------------
-- Table `website`.`user_analyze_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`user_analyze_information` (
  `user_extra_information_ip` CHAR(16) NOT NULL COMMENT '用户ip地址',
  `user_extra_information_agent` VARCHAR(20) NOT NULL COMMENT '用户客户端',
  `user_extra_information_refer` VARCHAR(20) NOT NULL COMMENT '从什么页面链接过来的',
  `user_analyze_information_login_time` DATETIME NOT NULL COMMENT '用户登录时间',
  `user_analyze_information_logout_time` DATETIME NOT NULL COMMENT '用户离开时间',
  `user_basic_information_id` INT NOT NULL,
  INDEX `fk_user_extra_information_user_basic_information1_idx` (`user_basic_information_id` ASC),
  CONSTRAINT `fk_user_extra_information_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '用户统计信息表，不需要用户填写，用于统计信息';


-- -----------------------------------------------------
-- Table `website`.`user_contact_information`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`user_contact_information` (
  `user_contact_information_qq` VARCHAR(20) NULL COMMENT 'QQ',
  `user_contact_information_weixin` VARCHAR(20) NULL COMMENT '微信',
  `user_contact_information_weibo` VARCHAR(20) NULL COMMENT '微博',
  `user_contact_information_email` VARCHAR(30) NULL COMMENT '邮箱',
  `user_contact_information_phone` CHAR(11) NULL COMMENT '电话',
  `user_contact_information_github` VARCHAR(45) NULL COMMENT 'github地址',
  `user_contact_information_blog` VARCHAR(45) NULL COMMENT '博客地址',
  `user_contact_information_other` VARCHAR(100) NULL COMMENT '其他信息',
  `user_basic_information_id` INT NOT NULL,
  PRIMARY KEY (`user_basic_information_id`),
  CONSTRAINT `fk_user_contact_information_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '用户联系信息表，包括邮箱，电话，QQ，微信，微博';


-- -----------------------------------------------------
-- Table `website`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`role` (
  `role_id` INT NOT NULL COMMENT '角色id',
  `role_name` VARCHAR(45) NULL COMMENT '角色名称',
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
COMMENT = '角色表,分为游客，注册用户，会员，管理员，高级管理员';


-- -----------------------------------------------------
-- Table `website`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`user_role` (
  `role_id` INT NOT NULL,
  `user_basic_information_id` INT NOT NULL,
  INDEX `fk_user_role_role1_idx` (`role_id` ASC),
  PRIMARY KEY (`user_basic_information_id`, `role_id`),
  CONSTRAINT `fk_user_role_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `website`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `website`.`permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`permission` (
  `permission_id` INT NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `permission_name` VARCHAR(20) NOT NULL COMMENT '权限的名字',
  `permission_url` VARCHAR(45) NOT NULL COMMENT '权限控制的url',
  PRIMARY KEY (`permission_id`))
ENGINE = InnoDB
COMMENT = '用户权限表';


-- -----------------------------------------------------
-- Table `website`.`role_permission`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`role_permission` (
  `role_id` INT NOT NULL,
  `permission_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`),
  INDEX `fk_role_permission_permission1_idx` (`permission_id` ASC),
  CONSTRAINT `fk_role_permission_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `website`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_permission1`
    FOREIGN KEY (`permission_id`)
    REFERENCES `website`.`permission` (`permission_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `website`.`blog_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`blog_type` (
  `blog_type_id` INT NOT NULL COMMENT '类型id',
  `blog_type_name` VARCHAR(10) NOT NULL COMMENT '类型名称',
  PRIMARY KEY (`blog_type_id`))
ENGINE = InnoDB
COMMENT = '博客类别，包括原创，翻译，转载';


-- -----------------------------------------------------
-- Table `website`.`blog_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`blog_category` (
  `blog_category_id` INT NOT NULL COMMENT '自增id',
  `blog_category_name` VARCHAR(45) NOT NULL COMMENT '内容类型的名字',
  PRIMARY KEY (`blog_category_id`))
ENGINE = InnoDB
COMMENT = '博客的内容类型,包括java编程思想,scrapy,mysql,cocos2d,Spring boot等等';


-- -----------------------------------------------------
-- Table `website`.`blog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`blog` (
  `blog_id` INT NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `blog_title` VARCHAR(45) NOT NULL COMMENT '博客题目',
  `blog_content` VARCHAR(45) NOT NULL COMMENT '博客url',
  `blog_subcontent` VARCHAR(200) NOT NULL COMMENT '博客摘要',
  `blog_read_count` INT NOT NULL COMMENT '博客的阅读量',
  `blog_publish_time` DATETIME NOT NULL COMMENT '博客首次上线时间',
  `blog_modify_time` DATETIME NOT NULL COMMENT '博客修改时间',
  `blog_poor_comment` INT NOT NULL DEFAULT 0 COMMENT '文章差评数',
  `blog_good_cpmment` INT NOT NULL DEFAULT 0 COMMENT '文章好评',
  `blog_publisher` VARCHAR(20) NOT NULL DEFAULT 'admin' COMMENT 'blog的发布者,默认是管理员',
  `blog_type_id` INT NOT NULL,
  `blog_category_blog_category_id` INT NOT NULL,
  PRIMARY KEY (`blog_id`),
  INDEX `fk_blog_blog_type1_idx` (`blog_type_id` ASC),
  INDEX `fk_blog_blog_category1_idx` (`blog_category_blog_category_id` ASC),
  CONSTRAINT `fk_blog_blog_type1`
    FOREIGN KEY (`blog_type_id`)
    REFERENCES `website`.`blog_type` (`blog_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_blog_category1`
    FOREIGN KEY (`blog_category_blog_category_id`)
    REFERENCES `website`.`blog_category` (`blog_category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '博客';


-- -----------------------------------------------------
-- Table `website`.`news_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`news_type` (
  `news_type_id` INT NOT NULL AUTO_INCREMENT COMMENT '新闻类型id',
  `news_type_name` VARCHAR(10) NOT NULL COMMENT '新闻类型名称',
  PRIMARY KEY (`news_type_id`))
ENGINE = InnoDB
COMMENT = '新闻类型，包括原创，转载，爬取';


-- -----------------------------------------------------
-- Table `website`.`news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`news` (
  `news_id` INT NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `news_title` VARCHAR(45) NOT NULL COMMENT '新闻题目',
  `news_content` VARCHAR(45) NOT NULL COMMENT '新闻url',
  `news_publish_time` DATETIME NOT NULL COMMENT '新闻发布时间',
  `news_modify_time` DATETIME NOT NULL COMMENT '新闻修改时间',
  `news_url` VARCHAR(45) NULL COMMENT '爬取的新闻的地址',
  `news_type_id` INT NOT NULL,
  PRIMARY KEY (`news_id`),
  INDEX `fk_news_news_type1_idx` (`news_type_id` ASC),
  CONSTRAINT `fk_news_news_type1`
    FOREIGN KEY (`news_type_id`)
    REFERENCES `website`.`news_type` (`news_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '新闻，用爬虫去爬取，或者自己写';


-- -----------------------------------------------------
-- Table `website`.`blog_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`blog_comment` (
  `blog_comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '评论的id',
  `blog_comment_response_id` INT NULL COMMENT '为空时候是回复文章，代表回复的评论的id',
  `blog_comment_content` INT NOT NULL COMMENT '评论的内容',
  `blog_comment_send_time` DATETIME NOT NULL COMMENT '评论的时间',
  `user_basic_information_id` INT NOT NULL,
  `blog_id` INT NOT NULL,
  INDEX `fk_blog_comment_blog1_idx` (`blog_id` ASC),
  PRIMARY KEY (`blog_comment_id`),
  CONSTRAINT `fk_blog_comment_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_comment_blog1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `website`.`blog` (`blog_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '博客评论表';


-- -----------------------------------------------------
-- Table `website`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`message` (
  `message_id` INT NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `message_titie` VARCHAR(20) NOT NULL COMMENT '消息题目',
  `message_content` VARCHAR(100) NOT NULL COMMENT '消息内容',
  `message_send_time` DATETIME NOT NULL COMMENT '发布时间',
  `message_isread` INT NOT NULL COMMENT '消息是否阅读,0代表未读,1代表读,默认为0',
  `user_basic_information_id` INT NOT NULL,
  PRIMARY KEY (`message_id`),
  INDEX `fk_message_user_basic_information1_idx` (`user_basic_information_id` ASC),
  CONSTRAINT `fk_message_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '通知用户的消息表,个性化的通知用户的时候用到';


-- -----------------------------------------------------
-- Table `website`.`userful_url`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`userful_url` (
  `userful_url_link` VARCHAR(45) NOT NULL COMMENT '网址链接',
  `userful_url_name` VARCHAR(20) NOT NULL COMMENT '网址的名称',
  `userful_url_desc` VARCHAR(45) NULL COMMENT '网址的作用描述',
  PRIMARY KEY (`userful_url_link`))
ENGINE = InnoDB
COMMENT = '有用的网址,友情链接,实现SEO等等';


-- -----------------------------------------------------
-- Table `website`.`userful_file`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`userful_file` (
  `userful_file_source_link` VARCHAR(50) NOT NULL COMMENT '文件的官方链接',
  `userful_file_local_link` VARCHAR(45) NULL COMMENT '文件的本地链接',
  `userful_file_name` VARCHAR(20) NOT NULL COMMENT '文件名称',
  `userful_file_desc` VARCHAR(45) NULL COMMENT '文件作用描述',
  PRIMARY KEY (`userful_file_source_link`))
ENGINE = InnoDB
COMMENT = '有用的文件链接,文件存在百度云上';


-- -----------------------------------------------------
-- Table `website`.`guestbook`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `website`.`guestbook` (
  `guestbook_content` INT NOT NULL COMMENT '留言内容',
  `guestbook_time` DATETIME NOT NULL COMMENT '留言时间',
  `user_basic_information_id` INT NOT NULL,
  CONSTRAINT `fk_guestbook_user_basic_information1`
    FOREIGN KEY (`user_basic_information_id`)
    REFERENCES `website`.`user_basic_information` (`user_basic_information_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '留言板';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `website`.`job`
-- -----------------------------------------------------
START TRANSACTION;
USE `website`;
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (0, '安卓攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (1, 'ios攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (2, '前端攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (3, '数据库攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (4, '后端攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (5, '运维攻城狮');
INSERT INTO `website`.`job` (`job_id`, `job_name`) VALUES (6, '其他');

COMMIT;


-- -----------------------------------------------------
-- Data for table `website`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `website`;
INSERT INTO `website`.`role` (`role_id`, `role_name`) VALUES (0, '游客');
INSERT INTO `website`.`role` (`role_id`, `role_name`) VALUES (1, '注册用户');
INSERT INTO `website`.`role` (`role_id`, `role_name`) VALUES (2, '会员');
INSERT INTO `website`.`role` (`role_id`, `role_name`) VALUES (3, '管理员');
INSERT INTO `website`.`role` (`role_id`, `role_name`) VALUES (4, '高级管理员');

COMMIT;


-- -----------------------------------------------------
-- Data for table `website`.`blog_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `website`;
INSERT INTO `website`.`blog_type` (`blog_type_id`, `blog_type_name`) VALUES (0, '原创');
INSERT INTO `website`.`blog_type` (`blog_type_id`, `blog_type_name`) VALUES (1, '翻译');
INSERT INTO `website`.`blog_type` (`blog_type_id`, `blog_type_name`) VALUES (2, '转载');

COMMIT;


-- -----------------------------------------------------
-- Data for table `website`.`blog_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `website`;
INSERT INTO `website`.`blog_category` (`blog_category_id`, `blog_category_name`) VALUES (0, 'java编程思想');
INSERT INTO `website`.`blog_category` (`blog_category_id`, `blog_category_name`) VALUES (1, 'scrapy教程');
INSERT INTO `website`.`blog_category` (`blog_category_id`, `blog_category_name`) VALUES (2, 'mysql');
INSERT INTO `website`.`blog_category` (`blog_category_id`, `blog_category_name`) VALUES (3, 'cocos creator实践');
INSERT INTO `website`.`blog_category` (`blog_category_id`, `blog_category_name`) VALUES (4, 'Spring boot');

COMMIT;


-- -----------------------------------------------------
-- Data for table `website`.`news_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `website`;
INSERT INTO `website`.`news_type` (`news_type_id`, `news_type_name`) VALUES (0, '原创');
INSERT INTO `website`.`news_type` (`news_type_id`, `news_type_name`) VALUES (1, '转载');
INSERT INTO `website`.`news_type` (`news_type_id`, `news_type_name`) VALUES (2, '爬取');

COMMIT;

