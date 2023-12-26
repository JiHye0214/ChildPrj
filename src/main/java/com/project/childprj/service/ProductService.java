package com.project.childprj.service;

import com.project.childprj.domain.Product;
import com.project.childprj.domain.ProductImg;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProductService {
    // 글 목록 조회 (페이징 + 검색어)
    List<Product> list(Integer page, String sq, String productOrderWay, Model model);

    // 글 작성
    int write(Product product);

    // 특정 글 상세
    Product productDetail(Long id);

    // 조회수 올리기
    void incViewCnt(Long id);

    // 글 삭제
    int detailDelete(Long id);

    // 글 수정
    int update(Product product);

    // 사진 불러오기
    ProductImg findByProduct (Long productId);

    // 대표사진 등록 (동시 삭제)
    boolean imgInsert(Map<String, MultipartFile> file, Long productId);

    // home -- hot five
    List<Product> selectFive();
}
