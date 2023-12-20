package com.project.childprj.repository;

import com.project.childprj.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository {

    // 특정 id 글 내용 읽어오기
    Post findPostById(Long id);

    // 특정 id 글 조회수 +1
    int incViewCnt(Long id);

    // 특정 글 삭제
    int detailDelete(Long id);
}
