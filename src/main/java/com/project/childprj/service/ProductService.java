package com.project.childprj.service;

import com.project.childprj.domain.Product;
import org.springframework.ui.Model;

import java.util.List;

public interface ProductService {
    // 글 목록 조회 (페이징 + 검색어)
    List<Product> list(Integer page, String searchTxt, Model model);

    // 글 작성
    int write(Product product);

    // 특정 글 상세
    Product productDetail(Long id);

    // 글 삭제
    int detailDelete(Long id);

    // 글 수정
    int update(Product product);
}
