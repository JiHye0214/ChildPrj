package com.project.childprj.repository;

import com.project.childprj.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    // from 부터 cnts 개 글 최신순 조회 (페이징 + 검색어)
    List<Product> selectFromCntOrderByDate(int from, int cnts, String searchTxt);

    // from 부터 cnts 개 글 가격순 조회 (페이징 + 검색어)
    List<Product> selectFromCntOrderByPrice(int from, int cnts, String searchTxt);

    // 글 개수 조회 (검색어)
    int selectCountAll(String searchTxt);

    // 글 작성
    int insert(Product product);

    // 특정 id 글 내용 읽어오기
    Product findProductById(Long id);

    // 특정 id 글 조회수 +1 증가시키기
    int incViewCnt(Long id);

    // 특정 글 삭제
    int detailDelete(Long id);

    // 글 수정
    int update(Product product);
}
