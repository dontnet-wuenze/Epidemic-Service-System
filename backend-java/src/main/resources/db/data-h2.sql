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

INSERT INTO people (id, name, grade, department, major, Class, phoneNumber, nucleic, healthyCode, campus, most_recent_date) VALUES
(3190102475, 'LWB', 3, 'CS', 'CS', 'CS1902', '13999999999', '已检测', 'green', '玉泉', '20220527');

INSERT INTO people (id, name, grade, department, major, Class, phoneNumber, nucleic, healthyCode, campus, most_recent_date) VALUES
(3190102303, 'LBR', 3, 'CS', 'CS', 'CS1901', '13333333333', '未检测', 'green', '玉泉', '20220525');