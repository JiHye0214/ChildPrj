package com.project.childprj.service;


import com.project.childprj.domain.Product;
import com.project.childprj.repository.ProductCommentRepository;
import com.project.childprj.repository.ProductRepository;
import com.project.childprj.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(SqlSession sqlSession) {
        productRepository = sqlSession.getMapper(ProductRepository.class);
    }

    // 특정 글 가져오기
    @Override
    public Product productDetail(Long id) {
        productRepository.incViewCnt(id);
        return productRepository.findProductById(id);
    }

    // 특정 글 삭제
    @Override
    public int detailDelete(Long id) {

        return productRepository.detailDelete(id);
    }
}




