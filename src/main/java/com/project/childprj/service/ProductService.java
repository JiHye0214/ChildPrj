package com.project.childprj.service;

import com.project.childprj.domain.Product;

public interface ProductService {

    // 특정 글 상세
    Product productDetail(Long id);

    // 글 삭제
    int detailDelete(Long id);

}
