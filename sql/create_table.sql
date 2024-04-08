-- 创建库
create database if not exists web_db;

-- 切换库
use web_db;

-- 用户表
create table user
(
    uid      bigint auto_increment comment 'id' primary key,
    username varchar(256)  not null comment '账号',
    password varchar(512)  not null comment '密码',
    email    varchar(256)  not null comment '邮箱',
    age      int           not null comment '年龄',
    flag     int default 1 not null comment '用户角色：1-用户/0-管理员'
) comment '用户' collate = utf8mb4_unicode_ci;

insert into user(`username`, `password`, `email`, `age`, `flag`)
    value (null, 'web_admin', 'web_admin', 'web_admin@email', 20, 0);

-- 文章表
create table article
(
    artid      bigint auto_increment comment 'id' primary key,
    title      varchar(512) null comment '标题',
    content    text         null comment '内容',
    uid        bigint       not null comment '创建用户 id',
    publicTime datetime default CURRENT_TIMESTAMP comment '创建时间'
) comment '文章' collate = utf8mb4_unicode_ci;

insert into article(`title`, `content`, `uid`)
    value ('text_title', 'text_content', 1);
insert into article(`title`, `content`, `uid`)
    value ('linux常用命令', '-help\n-man\nls\ncd\ntouch\n', 1);
insert into article(`title`, `content`, `uid`)
    value ('String, StringBuffer 和 StringBuilder区别',
           '1. 可变性 \n (1)String 不可变 \n (2) StringBuffer 和 StringBuilder 可变 \n 2. 线程安全 \n (1) String 不可变，因此是线程安全的 \n (2) StringBuilder 不是线程安全的 \n (3) StringBuffer 是线程安全的，内部使用 synchronized 进行同步',
           1);
insert into article(`title`, `content`, `uid`)
    value ('JAVA String 类的常用方法有哪些？',
           'indexOf()：返回指定字符的索引。 \n charAt()：返回指定索引处的字符。 \n replace()：字符串替换。 \n trim()：去除字符串两端空白。 \n split()：分割字符串，返回一个分割后的字符串数组。 \n getBytes()：返回字符串的 byte 类型数组。 \n length()：返回字符串长度。 \n toLowerCase()：将字符串转成小写字母。 \n toUpperCase()：将字符串转成大写字符。 \n substring()：截取字符串。 \n equals()：字符串比较。',
           1);
