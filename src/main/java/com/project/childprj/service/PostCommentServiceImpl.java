package com.project.childprj.service;

import com.project.childprj.domain.PostComment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentServiceImpl implements PostCommentService{

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
