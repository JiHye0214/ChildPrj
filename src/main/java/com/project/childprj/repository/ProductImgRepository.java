package com.project.childprj.repository;

import com.project.childprj.domain.ProductImg;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRepository {

    // 글의 대표사진 조회
    ProductImg findByProduct(Long productId);

    // 대표 사진 등록
    int imgInsert(ProductImg productImg);

    // 이전 사진 삭제
    int imgDelete(Long productId);
}
