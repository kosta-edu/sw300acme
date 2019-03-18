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

INSERT INTO `course` (`id`, `description`, `duration`, `max_enrollment`, `min_enrollment`, `title`, `unit_price`)
VALUES
(1, ' 글로벌 표준 및 베스트 프랙티스를 적용하여 End-to-end 실습 프로젝트를 Full-stack으로 개발하여 고객 가치 중심의 Executable System 구현', 40, 25, 8, 'SW300 Intensive', 1800000),
(2, '임베디드 SW 개발에서 요구되는 핵심역량에 대하여 기본 이론과 실습 능력을 체계적으로 교육함으로써 IoT 기반의\n   시스템 개발을 수행할 수 있는 임베디드 고급 인력을 양성', 300, 20, 12, 'SW300 임베디드/IoT', 20000000),
(3, '오픈소스 APM* 도구인 SCOUTER를 이용한 JAVA, WAS 시스템에 대한 모니터링 및 시스템 병목 현상을 파악하고, 품질을 개선할 수 있는 능력 배양', 8, 25, 8, '오픈소스 APM 스카우터(Scouter) 입문', 0),
(4, '본 과정은 리눅스 기반 서버 관리자를 대상으로 쉘의 기능을 활용하는 문법과 활용 방법을 십슬을 통하여 습득하고, 쉘 변수, 쉘 스크립트 제어 기법을 학습하며, 쉘 내에서 함수 작성 및 활용하는 과정임', 15, 20, 8, '리눅스 Shell 프로그래밍 ', 0),
(5, '4차 산업혁명 시대에 산업에 필요한 한 분야인 VR/AR 서비스 플랫폼 개발을 위한 전문가 양성을 목적으로 한다. VR/AR 성장기 단계의 분야로서 다양한 플랫폼에 대한 이해를 토대로 접근하여 기반 폭넓은 기술력을 근간으로 진화하는 VR/AR 개발환경에 적응력이 강한 전문가 양성을 목적으로 한다. 프로그래밍 기술 능력(C++, Java, C#)과 플랫폼 제작 엔진(Unity3D, Unreal, Processing) 기술 능력으로 산업에서 요구하는 VR/', 792, 20, 12, 'VR/AR 서비스 플랫폼 개발자 양성과정', 0);
