-- 创建库
create database if not exists web_db;

-- 切换库
use web_db;

-- 用户表
create table web_db.user
(
    uid      bigint auto_increment comment 'id' primary key,
    username varchar(256)  not null comment '账号',
    password varchar(512)  not null comment '密码',
    email    varchar(256)  not null comment '邮箱',
    age      int           not null comment '年龄',
    flag     int default 1 not null comment '用户角色：1-用户/0-管理员'
) comment '用户' collate = utf8mb4_unicode_ci;


-- 文章表
create table article
(
    artid      bigint auto_increment comment 'id' primary key,
    title      varchar(512)                       null comment '标题',
    content    text                               null comment '内容',
    thumbNum   int      default 0                 not null comment '点赞数',
    favourNum  int      default 0                 not null comment '收藏数',
    uid        bigint                             not null comment '创建用户 id',
    publicTime datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    isDelete   tinyint  default 0                 not null comment '是否删除'
) comment '文章' collate = utf8mb4_unicode_ci;

