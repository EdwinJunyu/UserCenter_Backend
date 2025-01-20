-- auto-generated definition
create table tag
(
    id         bigint auto_increment
        primary key,
    tagName    varchar(255)                       null comment '标签名称',
    userId     varchar(256)                       null comment '用户 id',
    parentId   bigint                             null comment '父标签',
    isParent   tinyint                            null comment '0-是父标签, 1-不是父标签',
    createTime datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete   tinyint  default 0                 null comment '是否删除',
    constraint uniIndex_tagName
        unique (tagName)
)
    comment '标签表';

create index idx_userId
    on tag (userId);

-- auto-generated definition
create table user
(
    id           bigint auto_increment
        primary key,
    username     varchar(256)                        null,
    userAccount  varchar(256)                        null,
    avatarUrl    varchar(1024)                       null comment '用户头像',
    tags         varchar(1024)                       null comment '标签 json列表',
    gender       tinyint                             null,
    userPassword varchar(512)                        not null,
    phone        varchar(128)                        null,
    email        varchar(512)                        null,
    userStatus   int       default 0                 not null comment '用户状态 0 - 正常',
    createTime   datetime                            null,
    updateTime   timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    isDelete     tinyint   default 0                 null,
    userRole     int       default 0                 not null comment '用户角色 0 - 普通用户 1 - 管理员',
    planetCode   varchar(512)                        null
)
    comment '用户';


