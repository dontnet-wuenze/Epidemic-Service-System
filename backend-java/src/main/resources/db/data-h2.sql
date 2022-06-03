-- DROP TABLE IF EXISTS user;

-- CREATE TABLE user
-- (
--     id VARCHAR(20) NOT NULL COMMENT '主键ID-学工号',
--     name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
--     password VARCHAR(50) NOT NULL COMMENT '密码',
--     permission VARCHAR(30) NULL DEFAULT NULL COMMENT '权限身份',
--     department VARCHAR(100) NULL DEFAULT NULL COMMENT '学院',
--     major VARCHAR(100) NULL DEFAULT NULL COMMENT '专业',
--     administrativeClass VARCHAR(20) NULL DEFAULT NULL COMMENT '班级',
--     phone VARCHAR(20) NULL DEFAULT NULL COMMENT '电话号码',
--     PRIMARY KEY (id)
-- );

DELETE FROM user;
DELETE FROM people;
DELETE FROM monitor;

INSERT INTO user (id, name, password, permission, department, major, administrativeClass, campus, phone, code, attend) VALUES
(3190102303, 'Boris', '123456', 'user', '计算机科学与技术学院', '计算机科学与技术', '计科1901', '玉泉校区', '13333333333', '1', 'false');

INSERT INTO user (id, name, password, permission, department, major, administrativeClass, campus, phone, code, attend) VALUES
(3190102475, 'Lwb', '123456', 'user', '计算机科学与技术学院', '计算机科学与技术', '计科1902', '玉泉校区', '13949296182', '1', 'true');

INSERT INTO people (id, name, identity, grade, department, major, _class, phonenumber, nucleic, healthycode, campus, date) VALUES
(3190102475, 'Lwb', 'undergraduate', '大三', '计算机科学与技术学院', '计算机科学与技术', '计科1902', '13949296182', '已检测', 'green', '玉泉校区', '20220529');

INSERT INTO people (id, name, identity, grade, department, major, _class, phonenumber, nucleic, healthycode, campus, date) VALUES
(3190102303, 'Boris', 'undergraduate', '大三', '计算机科学与技术学院', '计算机科学与技术', '计科1901', '13333333333', '未检测', 'red', '玉泉校区', '20220528');

INSERT INTO people (id, name, identity, grade, department, major, _class, phonenumber, nucleic, healthycode, campus, date) VALUES
(3190103355, 'Zzy', 'undergraduate', '大三', '建筑工程学院', '建筑学', '建筑1902', '13999999999', '已检测', 'green', '紫金港校区', '20220529');

INSERT INTO people (id, name, identity, grade, department, major, _class, phonenumber, nucleic, healthycode, campus, date) VALUES
(123456, 'Yjw', 'fucking teacher', null, '摆烂学院', '摆烂学', null, '11111111111', '未检测', 'red', '玉泉校区', '20220522');

INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
(3190102475, 1, '今日未打卡', '2022-05-30 22:33:07', '请及时打卡', 'false');

INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
(3190102475, 2, '今日未打卡', '2022-05-29 22:33:07', '请及时打卡', 'true');

INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
(3190102303, 3, '今日未打卡', '2022-05-30 22:33:08', '请及时打卡', 'true');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
(3190102475, 'Lwb', '2022-06-01', '玉泉校区', '天津市，市辖区，南开区', 'false', '0', 'false', 'false', 'false', 'true');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
(3190102303, 'Boris', '2022-06-01', '玉泉校区', '天津市，市辖区，和平区', 'false', '0', 'false', 'false', 'false', 'false');