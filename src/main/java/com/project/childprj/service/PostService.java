package com.project.childprj.service;


import com.project.childprj.domain.Post;

public interface PostService {

    // 글 작성
    int write(Post post);

    // 특정 글 상세
    Post postDetail(Long id);

    // 글 삭제
    int detailDelete(Long id);
}
