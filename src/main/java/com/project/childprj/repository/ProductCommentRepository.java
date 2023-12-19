package com.project.childprj.repository;

import com.project.childprj.domain.ProductComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository {

    // 특정 글의 댓글 목록
    List<ProductComment> findCommentById(Long productId);

    // 특정 글의 특정 댓글
    ProductComment findOneCmtById(Long commentId);

    // 댓글 작성하기
    int cmtWrite(Long userId, Long productId, String content);

    // 댓글 삭제하기
    int cmtRemove(Long commentId);

}
