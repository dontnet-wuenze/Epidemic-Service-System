DELETE FROM user;

INSERT INTO user (id, name, password, department, phoneNumber, email, authorization, healthyCode) VALUES
(3190102303, 'Boris', '123456', '计算机科学与技术', '13333333333', 'test5@baomidou.com', 'student', 'green');

INSERT INTO user (id, name, password, department, phoneNumber, email, authorization, healthyCode) VALUES
(3190102475, 'Lwb', '1234567', '计算机科学与技术', '13333333334', 'test4@baomidou.com', 'student', 'green');

INSERT INTO user (id, name, password, department, phoneNumber, email, authorization, healthyCode) VALUES
(3190102297, 'Wez', '12345678', '计算机科学与技术', '13333333335', 'test3@baomidou.com', 'student', 'green');

INSERT INTO monitor (id, name, password, department, phoneNumber, authorization) VALUES
(111, 'Boss', '888888', '计算机科学与技术', '66666666666', 'monitor');

INSERT INTO monitor (id, name, password, department, phoneNumber, authorization) VALUES
(222, 'Boss', '666666', '建筑工程学院', '88888888888', 'monitor');