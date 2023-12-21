package com.project.childprj.repository;

import com.project.childprj.domain.Post;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public interface PostRepository {
    // from 부터 cnts 개 글 최신순 조회 (페이징 + 검색어)
    List<Post> selectFromCntOrderByDate(int from, int cnts, String sq);

    // from 부터 cnts 개 글 가격순 조회 (페이징 + 검색어)
    List<Post> selectFromCntOrderByRcmCnt(int from, int cnts, String sq);

    // 글 개수 조회 (검색어)
    int selectCountAll(String sq);

    // 글 작성
    int insert(Post post);

    // 특정 id 글 내용 읽어오기
    Post findPostById(Long id);

    // 특정 id 글 조회수 +1
    int incViewCnt(Long id);

    // 특정 글 삭제
    int detailDelete(Long id);

    // 글 수정
    int update(Post post);
}
