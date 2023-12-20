package com.project.childprj.repository;

public interface PostRecommendRepository {

    // 추천
    int recommend(Long userId, Long postId);

    // 추천 취소
    int opposite(Long userId, Long postId);
}
