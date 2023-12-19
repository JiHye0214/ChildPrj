package com.project.childprj.repository;

import com.project.childprj.domain.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {

    // 글쓰기
    int write(Product product);

    // 특정 id 글 내용 읽어오기
    Product findProductById(Long id);

    // 특정 id 글 조회수 +1 증가시키기
    int incViewCnt(Long id);

    // 특정 글 삭제
    int detailDelete(Long id);
}
