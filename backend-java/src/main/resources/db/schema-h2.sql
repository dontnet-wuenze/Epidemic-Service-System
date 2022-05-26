DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID-学工号',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    password VARCHAR(50) NOT NULL COMMENT '密码',
    department VARCHAR(100) NULL DEFAULT NULL COMMENT '学院',
    phoneNumber VARCHAR(30) NULL DEFAULT NULL COMMENT '电话号码',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    authorization VARCHAR(30) NULL DEFAULT NULL COMMENT '权限身份',
    healthyCode VARCHAR(100) NULL DEFAULT NULL COMMENT '健康码',
    PRIMARY KEY (id)
);

CREATE TABLE monitor
(
    id BIGINT(20) NOT NULL COMMENT '主键ID-学工号',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    password VARCHAR(50) NOT NULL COMMENT '密码',
    department VARCHAR(100) NULL DEFAULT NULL COMMENT '学院',
    phoneNumber VARCHAR(30) NULL DEFAULT NULL COMMENT '电话号码',
    authorization VARCHAR(30) NULL DEFAULT NULL COMMENT '权限身份',
    PRIMARY KEY (id)
)

-- CREATE TABLE people
-- (
--     id
--     name
--     grade
--     department
--     major
--     class
--     phoneNumber
--     nucleic
--     healthyCode
--     campus
--     most_recent_date
-- )

-- CREATE TABLE student
-- (
--
-- )