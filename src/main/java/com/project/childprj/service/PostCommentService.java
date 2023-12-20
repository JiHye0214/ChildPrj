package com.project.childprj.service;

import com.project.childprj.domain.PostComment;
import com.project.childprj.domain.ProductComment;

import java.util.List;

public interface PostCommentService {

    // 특정 글의 댓글 목록
    List<PostComment> cmtList(Long postId);

    // 특정 글에 특정 사용자가 댓글 작성
    int cmtWrite(Long userId, Long postId, String content);

    // 특정 댓글 삭제
    int cmtRemove(Long commentId);
}
