package com.project.childprj.service;

import com.project.childprj.domain.Post;
import com.project.childprj.domain.PostRecommend;
import com.project.childprj.repository.PostRecommendRepository;
import com.project.childprj.repository.PostRepository;
import com.project.childprj.repository.ProductRepository;
import com.project.childprj.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private UserRepository userRepository;
    private PostRepository postRepository;
    private PostRecommendRepository postRecommendRepository;

    @Autowired
    public PostServiceImpl(SqlSession sqlSession) {
        postRecommendRepository = sqlSession.getMapper(PostRecommendRepository.class);
        postRepository = sqlSession.getMapper(PostRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    @Override
    public int write(Post post) {

        return 0;
    }

    // 특정 글 가져오기
    @Override
    public Post postDetail(Long id) {
        postRepository.incViewCnt(id);
        return postRepository.findPostById(id);
    }

    // 특정 글 삭제
    @Override
    public int detailDelete(Long id) { return postRepository.detailDelete(id); }

    // 추천 눌렀나?
    @Override
    public boolean clickCheck(Long userId, Long postId) {
        PostRecommend postRecommend = postRecommendRepository.clickCheck(userId, postId);
        return (postRecommend != null);
    }

    // 추천수
    @Override
    public int recomCnt(Long postId) {
        return postRecommendRepository.recomCnt(postId);
    }

    // 추천
    @Override
    public int recommend(Long userId, Long postId) {
        return postRecommendRepository.recommend(userId, postId);
    }

    // 비추천
    @Override
    public int opposite(Long userId, Long postId) {
        return postRecommendRepository.opposite(userId, postId);
    }
}
