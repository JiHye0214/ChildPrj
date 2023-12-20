package com.project.childprj.service;

import com.project.childprj.domain.Post;
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

    @Autowired
    public PostServiceImpl(SqlSession sqlSession) {
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
    public int detailDelete(Long id) {
        return 0;
    }
}
