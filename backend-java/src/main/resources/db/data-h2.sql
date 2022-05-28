DELETE FROM user;
DELETE FROM people;
DELETE FROM monitor;

INSERT INTO user (id, name, password, department, phoneNumber, email, authorization, healthyCode) VALUES
(3190102303, 'Boris', '123456', '计算机科学与技术', '13333333333', 'test5@baomidou.com', 'student', 'green');

INSERT INTO user (id, name, password, department, phoneNumber, email, authorization, healthyCode) VALUES
(3190102475, 'Lwb', '1234567', '计算机科学与技术', '13333333334', 'test4@baomidou.com', 'student', 'green');

INSERT INTO monitor (id, name, password, department, phoneNumber, authorization) VALUES
(111, 'Boss', '888888', '计算机科学与技术', '66666666666', 'monitor');

INSERT INTO monitor (id, name, password, department, phoneNumber, authorization) VALUES
(222, 'Boss', '666666', '建筑工程学院', '88888888888', 'monitor');

INSERT INTO people (id, name, grade, department, major, _class, phoneNumber, nucleic, healthyCode, campus, date) VALUES
(3190102475, 'LWB', 3, '计算机科学与技术学院', '计算机科学与技术', 'CS1902', '13999999999', '未检测', 'green', '玉泉校区', '2022-05-25');

INSERT INTO people (id, name, grade, department, major, _class, phoneNumber, nucleic, healthyCode, campus, date) VALUES
(3190102303, 'LBR', 3, '计算机科学与技术学院', '计算机科学与技术', 'CS1901', '13333333333', '未检测', 'green', '玉泉校区', '2022-05-25');

INSERT INTO people (id, name, grade, department, major, _class, phoneNumber, nucleic, healthyCode, campus, date) VALUES
(3190103355, 'ZZY', 3, '建筑工程学院', '建筑学', '1902', '13999999999', '已检测', 'green', '紫金港校区', '2022-05-27');