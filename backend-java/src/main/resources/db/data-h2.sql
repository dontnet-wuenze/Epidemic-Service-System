DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id VARCHAR(20) NOT NULL COMMENT '主键ID-学工号',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    password VARCHAR(50) NOT NULL COMMENT '密码',
    permission VARCHAR(30) NULL DEFAULT NULL COMMENT '权限身份',
    department VARCHAR(100) NULL DEFAULT NULL COMMENT '学院',
    major VARCHAR(100) NULL DEFAULT NULL COMMENT '专业',
    administrativeClass VARCHAR(20) NULL DEFAULT NULL COMMENT '班级',
    phone VARCHAR(20) NULL DEFAULT NULL COMMENT '电话号码',
    PRIMARY KEY (id)
);

DELETE FROM user;
DELETE FROM people;
DELETE FROM monitor;

INSERT INTO user (id, name, password, permission, department, major, administrativeClass, phone) VALUES
(3190102303, 'Boris', '123456', 'user', '计算机科学与技术学院', '计算机科学与技术', '计科1901', '13333333333');