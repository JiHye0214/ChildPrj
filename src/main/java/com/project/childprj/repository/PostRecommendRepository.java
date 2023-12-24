package com.project.childprj.repository;

import com.project.childprj.domain.PostRecommend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRecommendRepository {

    // 내가 눌렀나?
    PostRecommend clickCheck(Long userId, Long postId);

    // 추천
    int recommend(Long userId, Long postId);

    // 추천 취소
    int opposite(Long userId, Long postId);
}
