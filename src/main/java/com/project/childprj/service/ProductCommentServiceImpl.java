package com.project.childprj.service;

import com.project.childprj.domain.ProductComment;
import com.project.childprj.repository.ProductCommentRepository;
import com.project.childprj.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCommentServiceImpl implements ProductCommentService{

    private UserRepository userRepository;
    private ProductCommentRepository productCommentRepository;

    @Autowired // 근데 이걸 하는 이유가 머지
    public ProductCommentServiceImpl(SqlSession sqlSession){
        productCommentRepository = sqlSession.getMapper(ProductCommentRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    // 특정 글의 댓글 목록
    @Override
    public List<ProductComment> cmtList(Long productId) {
        return productCommentRepository.findCommentById(productId);
    }

    // 댓글 작성
    @Override
    public int cmtWrite(Long userId, Long productId, String content) {
        return productCommentRepository.cmtWrite(userId, productId, content);
    }

    // 댓글 삭제
    @Override
    public int cmtRemove(Long commentId) {

        return productCommentRepository.cmtRemove(commentId);
    }
}
