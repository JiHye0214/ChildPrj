package com.project.childprj.service;

import com.project.childprj.domain.PostComment;
import com.project.childprj.repository.PostCommentRepository;
import com.project.childprj.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService{

    private UserRepository userRepository;
    private PostCommentRepository postCommentRepository;

    @Override
    public List<PostComment> cmtList(Long postId) {
        return null;
    }

    @Override
    public int cmtWrite(Long userId, Long postId, String content) {
        return 0;
    }

    @Override
    public int cmtRemove(Long commentId) {
        return 0;
    }
}
