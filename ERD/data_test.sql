SELECT *
  FROM user;

SELECT *
  FROM user_authority;

SELECT *
  FROM user_authorities;

SELECT *
  FROM user_img;
 
SELECT *
  FROM user_authority;

SELECT *
 FROM user_authorities;

SELECT *
  FROM together;

SELECT *
  FROM zzim;

SELECT *
  FROM kindergarden;

SELECT *
  FROM child_house;

SELECT *
  FROM post;

SELECT *
  FROM post_comment;

SELECT *
  FROM post_img;

SELECT *
  FROM product;
 
SELECT *
  FROM product_img ;

SELECT *
  FROM product_comment;

SELECT *
  FROM recommend;

-- ----------------------------------------

-- 상품 글(product) 조회
 
SELECT *
  FROM product
 ORDER BY createDate DESC;

SELECT *
  FROM product
 ORDER BY price;

SELECT *
  FROM product
 LIMIT 0, 8;

SELECT *
  FROM product
 WHERE productName LIKE "%아기%";

SELECT *
  FROM product
 WHERE productName LIKE "%%"
    OR region LIKE "%%"
--  ORDER BY createDate DESC;
 ORDER BY price;

SELECT *
  FROM product 
 WHERE 1 = 1
   AND productName LIKE concat('%', "", '%')
    OR region LIKE concat('%', "", '%')
 ORDER BY createDate DESC
 LIMIT 0, 8;

SELECT Count(*)
  FROM product 
 WHERE productName LIKE concat('%', "강", '%')
    OR region LIKE concat('%', "강", '%');

SELECT p.id          "p_id"
     , p.productName "p_productName"
     , p.region      "p_region"
     , p.price       "p_price"
     , p.content     "p_content"
     , p.viewCnt     "p_viewCnt"
     , p.createDate  "p_createDate"
     , p.userId      "p_userId"
     , u.id          "u_id"
     , u.loginId     "u_loginId"
     , u.password    "u_password"
     , u.nickName    "u_nickName"
     , u.name        "u_name"
     , u.email       "u_email"
     , u.createDate  "u_createDate"
  FROM product p
     , user u
 WHERE p.userId = u.id
   AND (p.productName LIKE concat('%', "", '%')
    OR p.region LIKE concat('%', "", '%'))
 ORDER BY p.createDate DESC
 LIMIT 0, 8;

SELECT COUNT(*)
  FROM product p
     , user u
 WHERE p.userId = u.id
   AND (p.productName LIKE concat('%', "", '%')
    OR p.region LIKE concat('%', "", '%'));

-- ----------------------------------------

-- 커뮤니티 글(post) 조회

SELECT *
  FROM post;

SELECT *
  FROM recommend;

SELECT p.id         "p_id"
     , p.title        "p_title"
     , p.content      "p_content"
     , p.viewCnt      "p_viewCnt"
     , p.createDate   "p_createDate"
     , u.id           "u_id"
     , u.loginId      "u_loginId"
     , u.password     "u_password"
     , u.name         "u_name"
     , u.nickName     "u_nickName"
     , u.email        "u_email"
     , u.createDate   "u_createDate"
  FROM post p
     , user u
 WHERE p.userId = u.id
   AND (p.title LIKE concat('%', "", '%')
    OR u.nickName LIKE concat('%', "", '%'))
 ORDER BY p.createDate DESC;
 LIMIT 0, 5;

SELECT COUNT(*)
  FROM post p
     , user u
 WHERE p.userId = u.id
   AND (p.title LIKE concat('%', "", '%')
    OR u.nickName LIKE concat('%', "", '%'));

SELECT p.id "p_id", COUNT(*) "p_recommendCnt"
  FROM post p
     , recommend r
 WHERE r.postId = p.id
 GROUP BY p.id;

SELECT p.id         "p_id"
     , p.title        "p_title"
     , p.content      "p_content"
     , p.viewCnt      "p_viewCnt"
     , p.createDate   "p_createDate"
     , u.id           "u_id"
     , u.loginId      "u_loginId"
     , u.password     "u_password"
     , u.name         "u_name"
     , u.nickName     "u_nickName"
     , u.email        "u_email"
     , u.createDate   "u_createDate"
     , ifnull(r.p_recommendCnt, 0) "p_recommendCnt"
  FROM post p
        LEFT JOIN
           (SELECT p.id "p_id", COUNT(*) "p_recommendCnt"
           FROM post p
              , recommend r
          WHERE r.postId = p.id
          GROUP BY p.id) r
      ON r.p_id = p.id
      LEFT JOIN user u
      ON p.userId = u.id
 WHERE p.userId = u.id
   AND (p.title LIKE concat('%', "", '%')
    OR u.nickName LIKE concat('%', "", '%'))
 ORDER BY r.p_recommendCnt DESC
 LIMIT 0, 5;

-- ----------------------------------------

-- together 조회

SELECT *
  FROM together;

SELECT COUNT(*)
  FROM together;

SELECT *
  FROM together
 WHERE CODENAME LIKE '%체험%';

SELECT COUNT(*)
  FROM together
 WHERE CODENAME LIKE '%체험%';

SELECT *
  FROM together
 WHERE CODENAME LIKE '%축제%';

SELECT COUNT(*)
  FROM together
 WHERE CODENAME LIKE '%축제%';

SELECT *
  FROM together
 WHERE CODENAME NOT LIKE '%체험%'
   AND CODENAME NOT LIKE '%축제%';

SELECT COUNT(*)
  FROM together
 WHERE CODENAME NOT LIKE '%체험%'
   AND CODENAME NOT LIKE '%축제%';

-- ----------------------------------------

-- kindergarden, child_house 조회
 
SELECT *
  FROM kindergarden;

SELECT COUNT(*)
  FROM kindergarden;

SELECT *
  FROM child_house;

SELECT COUNT(*)
  FROM child_house;




