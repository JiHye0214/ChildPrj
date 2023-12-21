package com.project.childprj.service;


import com.project.childprj.domain.Post;

public interface PostService {

    // 글 작성
    int write(Post post);

    // 특정 글 상세
    Post postDetail(Long id);

    // 글 삭제
    int detailDelete(Long id);

    // 추천 눌렀나?
    boolean clickCheck(Long userId, Long postId);

    // 추천수
    int recomCnt(Long postId);

    // 추천
    int recommend(Long userId, Long postId);

    // 비추천
    int opposite(Long userId, Long postId);
}
