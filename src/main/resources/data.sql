INSERT INTO `user` (`id`, `name`)
VALUES
(1, '이성희'),
(2, '임태진'),
(3, '윤남권'),
(4, '이상동');

INSERT INTO `instructor` (`id`, `bank_account`, `email`, `first_name`, `highest_education`, `last_name`, `phone`, `class_day_id`)
VALUES
(1, '외환은행 258-38-392878-5', 'schwang@espressobook.com', '상철', '석사', '황', '+821033588772', NULL),
(2, '시티은행 258-38-392878-5', 'june.park.sangju@gmail.com', '준성', '박사', '박', '+821023455882', NULL),
(3, '우리은행 258-38-392878-5', 'bkseo74@gmail.com', '보국', '박사', '서', '+821023424998', NULL),
(4, '우리은행 258-38-392878-5', 'jyjang@uengine.org', '진영', '석사', '장', '+821023422398', NULL),
(5, '국민은행 258-38-392878-5', 'existmaster@gmail.com', '성열', '석사', '윤', '+821021133498', NULL);

INSERT INTO `venu` (`id`, `address`, `capacity`, `map`, `name`)
VALUES
(1, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 25, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실1'),
(2, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 25, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실2'),
(3, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 25, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실3'),
(4, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 20, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실4'),
(5, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 20, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실5'),
(6, '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', 30, 'https://goo.gl/maps/R61hudwMy2P2', '판교 강의실6');

INSERT INTO `topic` (`id`, `description`, `name`)
VALUES
(1, NULL, '경영/비즈니스'),
(2, NULL, '컨설팅/EA'),
(3, NULL, 'SW공학'),
(4, NULL, '비즈니스 분석(BA)'),
(5, NULL, 'SOA'),
(6, NULL, '설계'),
(7, NULL, 'DB'),
(8, NULL, '프로그래밍'),
(9, NULL, '모바일'),
(10, NULL, '임베디드'),
(11, NULL, 'IoT'),
(12, NULL, '클라우드'),
(13, NULL, '빅데이터'),
(14, NULL, '리눅스'),
(15, NULL, '인공지능(AI)'),
(16, NULL, 'SW테스트'),
(17, NULL, 'SW안전/보안'),
(18, NULL, '블록체인');
