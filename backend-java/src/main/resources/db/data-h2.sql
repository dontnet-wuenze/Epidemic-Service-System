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
DELETE FROM monitor;

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
(3190102303, 'Boris', '123456', 'undergraduate', 'user', '计算机科学与技术学院', '计算机科学与技术', '大三', '计科1901', '玉泉校区', '13333333333', '1', 'green', false, '已检测', '20220603');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
(3190102475, 'Lwb', '123456', 'undergraduate', 'user', '计算机科学与技术学院', '计算机科学与技术', '大三', '计科1901', '玉泉校区', '13333333333', '1', 'green', true, '已检测', '20220604');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
(111111, 'Yjw', '123456', 'fucking teacher', 'user', '计算机科学与技术学院', '计算机科学与技术', null, null, '玉泉校区', '13333333333', '1', 'red', false, '未检测', '20220503');

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