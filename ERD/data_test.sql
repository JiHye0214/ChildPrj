SELECT *
  FROM user;
 
SELECT *
  FROM post;
 
SELECT *
  FROM post_comment;
 
SELECT *
  FROM recommend;
 
SELECT Count(*)
  FROM recommend 
 WHERE postId = 3;

SELECT *
  FROM product;
 
SELECT *
  FROM product_comment;
 
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

SELECT p.id 		 "p_id"
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


 
 
 
 