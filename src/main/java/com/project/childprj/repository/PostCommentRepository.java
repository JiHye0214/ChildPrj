package com.project.childprj.repository;

import com.project.childprj.domain.PostComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostCommentRepository {

    // 특정 글의 댓글 목록
    List<PostComment> findCommentById(Long postId);

    // 특정 글의 특정 댓글
    PostComment findOneCmtById(Long commentId);

    // 댓글 작성하기
    int cmtWrite(Long userId, Long postId, String content);

    // 댓글 삭제하기
    int cmtRemove(Long commentId);
}
