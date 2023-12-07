DELETE FROM user;
DELETE FROM post;
DELETE FROM post_comment ;

ALTER TABLE user AUTO_INCREMENT = 1;
ALTER TABLE post AUTO_INCREMENT = 1;
ALTER TABLE post_comment AUTO_INCREMENT = 1;

-- 샘플 사용자
INSERT INTO user(loginId, nickname, name, password, email) VALUES
('apple1234', '말랑한고구마', '박사과', '$2a$10$6gVaMy7.lbezp8bGRlV2fOArmA3WAk2EHxSKxncnzs28/m3DXPyA2', 'apple@mail.com'),
('melon1234', '맑은아침햇살', '김멜론', '$2a$10$7LTnvLaczZbEL0gabgqgfezQPr.xOtTab2NAF/Yt4FrvTSi0Y29Xa', 'melon@mail.com'),
('cherry1234', '마라탕먹고싶다', '이체리', '$2a$10$53OEi/JukSMPr3z5RQBFH.z0TCYSUDPtxf1/8caRyRVdDNdHA9QHi', 'cherry@mail.com')
;

-- 샘플 게시글
INSERT INTO post(title, content, userId) VALUES
('게시글1', '게시글1 내용입니다.', 1),
('게시글2', '게시글2 내용입니다.', 2),
('게시글3', '게시글3 내용입니다.', 3),
('게시글4', '게시글4 내용입니다.', 1),
('게시글5', '게시글5 내용입니다.', 2),
('게시글6', '게시글6 내용입니다.', 3)
;

-- 샘플 게시글 댓글
INSERT INTO post_comment(content, userId, postId) VALUES
('유저1이(가) 게시글1에 작성한 댓글입니다.', 1, 1),
('유저1이(가) 게시글2에 작성한 댓글입니다.', 1, 2),
('유저1이(가) 게시글3에 작성한 댓글입니다.', 1, 3),
('유저2이(가) 게시글4에 작성한 댓글입니다.', 2, 4),
('유저2이(가) 게시글5에 작성한 댓글입니다.', 2, 5),
('유저2이(가) 게시글6에 작성한 댓글입니다.', 2, 6),
('유저3이(가) 게시글1에 작성한 댓글입니다.', 3, 1),
('유저3이(가) 게시글2에 작성한 댓글입니다.', 3, 2),
('유저3이(가) 게시글3에 작성한 댓글입니다.', 3, 3),
('유저3이(가) 게시글4에 작성한 댓글입니다.', 3, 4),
('유저3이(가) 게시글5에 작성한 댓글입니다.', 3, 5),
('유저3이(가) 게시글6에 작성한 댓글입니다.', 3, 6)
;
