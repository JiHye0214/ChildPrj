package com.project.childprj.service;

import com.project.childprj.domain.Post;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

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
