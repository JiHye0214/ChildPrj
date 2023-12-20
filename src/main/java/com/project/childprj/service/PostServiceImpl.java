package com.project.childprj.service;

import com.project.childprj.domain.Post;
import com.project.childprj.repository.PostRepository;
import com.project.childprj.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Override
    public int write(Post post) {
        return 0;
    }

    @Override
    public Post postDetail(Long id) {
        return null;
    }

    @Override
    public int detailDelete(Long id) {
        return 0;
    }
}
