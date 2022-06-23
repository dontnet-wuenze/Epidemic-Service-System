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
    (123456, '王奕飞', '123456', 'coordinator', 'admin', '计算机科学与技术学院', '计算机科学与技术', '大三', '', '玉泉校区', '13333333333', '0', 'green', false, '已检测', '20220603');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102000, '李博睿', '123456', 'undergraduate', 'student', '计算机科学与技术学院', '计算机科学与技术', '大三', '计科1901', '玉泉校区', '13333333333', '0', 'green', true, '已检测', '20220603');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102001, '刘文博', '123456', 'undergraduate', 'student', '计算机科学与技术学院', '软件工程', '大二', '计科1901', '玉泉校区', '13333333333', '0', 'green', false, '已检测', '20220604');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102002, '王晓', '123456', 'undergraduate', 'student', '计算机科学与技术学院', '计算机科学与技术', '大三', '计科1901', '玉泉校区', '13333333333', '0', 'yellow', false, '已检测', '20220604');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102003, '吴恩泽', '123456', 'undergraduate', 'student', '信息与电子工程学系', '信息工程', '大三', '计科1901', '玉泉校区', '13333333333', '0', 'green', false, '已检测', '20220604');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102004, '焦点', '123456', 'undergraduate', 'student', '数学系', '数学与应用数学', '大三', '计科1901', '玉泉校区', '13333333333', '0', 'green', false, '已检测', '20220604');

INSERT INTO user (id, name, password, identity, permission, department, major, grade, administrativeClass, campus, phone, code, healthycode, attend, nucleic, date) VALUES
    (3190102005, '谷爱凌', '123456', 'undergraduate', 'student', '人文学院', '古典文献学', '大三', '计科1901', '玉泉校区', '13333333333', '0', 'green', false, '已检测', '20220604');
--
-- INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
--     (3190102475, 1, '今日未打卡', '2022-05-30 22:33:07', '请及时打卡', 'false');
--
-- INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
--     (3190102475, 2, '今日未打卡', '2022-05-29 22:33:07', '请及时打卡', 'true');
--
-- INSERT INTO message (userid, msgid, title, date, detail, read) VALUES
--     (3190102303, 3, '今日未打卡', '2022-05-30 22:33:08', '请及时打卡', 'true');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102000, '李博睿', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102001, '刘文博', '2022-06-22', '玉泉校区', '天津市,市辖区,南开区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102002, '王晓', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102003, '吴恩泽', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102004, '焦点', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (3190102005, '谷爱凌', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO punch (id, name, date, campus, region, oncampus, codestatus, fever, control, contact, status) VALUES
    (123456, '王奕飞', '2022-06-22', '玉泉校区', '天津市,市辖区,和平区', 'false', '0', 'false', 'false', 'false', 'false');

INSERT INTO form (form_id, staff_id, audit_id, form_type, status, content, application_time) VALUES
    (11111111, 3190102303, 123456, 'stu_passphrase_form', '等待审核','{"name": "lingsing"}' ,'2022-7-10')