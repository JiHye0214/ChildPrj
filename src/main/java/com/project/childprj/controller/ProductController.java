package com.project.childprj.controller;

import com.project.childprj.domain.Product;
import com.project.childprj.domain.ProductComment;
import com.project.childprj.domain.User;
import com.project.childprj.service.ProductCommentService;
import com.project.childprj.service.ProductService;
import com.project.childprj.service.UserService;
import com.project.childprj.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCommentService productCommentService;

    @GetMapping("/write")
    public void marketWrite(){
    }

    @GetMapping("/update")
    public void marketUpdate(){
    }

    @GetMapping("/list")
    public void marketList(){
    }

    @GetMapping("/detail/{id}")
    public String marketDetail(@PathVariable(name = "id") Long id, Model model){

        List<ProductComment> list = productCommentService.cmtList(id);
        model.addAttribute("productCmt", list); // 특정 글의 댓글 모음
        model.addAttribute("product", productService.productDetail(id)); // 특정 글
        return "product/detail";
    }

    // 댓글 작성
    @PostMapping("/cmtWrite")
    public String marketCmtWrite(ProductComment productComment, Model model){

        Long productId = productComment.getProductId();
        Long userId = U.getLoggedUser().getId();  // 세션 너란 녀석...
        String content = productComment.getContent();

        model.addAttribute("change", productCommentService.cmtWrite(userId, productId, content));
        return "/product/success";
    }

    // 댓글 삭제
    @PostMapping("/cmtDelete")

    public String marketCmtDel(ProductComment productComment, Model model){
        Long cmtId = productComment.getId();
        model.addAttribute("change", productCommentService.cmtRemove(cmtId));
        return "/product/success";
    }

    // 글 삭제
    @PostMapping("/detailDelete")
    public String detailDelete(Product product, Model model){

        Long productId = product.getId();
        model.addAttribute("change", productService.detailDelete(productId));
        return "/product/success";
    }
}
