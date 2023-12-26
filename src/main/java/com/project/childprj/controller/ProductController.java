package com.project.childprj.controller;

import com.project.childprj.domain.Product;
import com.project.childprj.domain.ProductComment;
import com.project.childprj.domain.User;
import com.project.childprj.domain.UserImg;
import com.project.childprj.service.ProductCommentService;
import com.project.childprj.service.ProductService;
import com.project.childprj.service.UserService;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCommentService productCommentService;

    // 글 목록
    @GetMapping("/list")
    public void list(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                     @RequestParam(name = "sq", required = false, defaultValue = "") String sq,
                     @RequestParam(name = "productOrderWay", required = false, defaultValue = "최신순") String productOrderWay,
                     Model model,
                     HttpServletRequest request
    ) {
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        productService.list(page, sq, productOrderWay, model);
    }

    // 글 상세
    @GetMapping("/detail/{id}")
    public String marketDetail(@PathVariable(name = "id") Long id, Model model) {

        // 일단 얘가 null이면 나머지가 전달 안 됨 --> 글만 먼저 전달해야 unleaa/if가 작동하네 깐깐한 자식
        model.addAttribute("product", productService.productDetail(id)); // 특정 글
        productService.incViewCnt(id);

        if(productService.productDetail(id) != null){
            List<ProductComment> list = productCommentService.cmtList(id);
            model.addAttribute("productCmt", list); // 특정 글의 댓글 모음
            model.addAttribute("writerImg", userService.findUserImg(productService.productDetail(id).getUser().getId())); // 글 작성자 img
            model.addAttribute("cmtWriterImg", userService.findUserImg(U.getLoggedUser().getId())); // 댓글 쓸 사람 img
        }

        return "product/detail";
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public void write(Model model) {
        model.addAttribute("writerImg", userService.findUserImg(U.getLoggedUser().getId())); // 작성자 img
    }

    // 글 수정 페이지
    @GetMapping("/update/{id}")
    public String update(@PathVariable(name = "id") Long id, Model model) {
        Product product = productService.productDetail(id);
        product.setProductImg(productService.findByProduct(id));
        model.addAttribute("product", product);
        model.addAttribute("writerImg", userService.findUserImg(productService.productDetail(id).getUser().getId())); // 글 작성자 img

        model.addAttribute("cmtWriterImg", userService.findUserImg(U.getLoggedUser().getId())); // 댓글 쓸 사람 img
        return "product/update";
    }

    // 글 목록 - 정렬
    @PostMapping("/orderWay")
    public String orderWay(
            @RequestParam(name = "productOrderWay", required = false, defaultValue = "최신순") String productOrderWay
            , @RequestParam(name = "sq", required = false, defaultValue = "") String sq
            , RedirectAttributes redirectAttrs
    ) {
        redirectAttrs.addAttribute("productOrderWay", productOrderWay);
        redirectAttrs.addAttribute("sq", sq);

        return "redirect:/product/list";
    }

    // 글 목록 - 검색
    @PostMapping("/search")
    public String search(@RequestParam(name = "productOrderWay", required = false, defaultValue = "최신순") String productOrderWay,
                         @RequestParam(name = "sq", required = false, defaultValue = "") String sq,
                         RedirectAttributes redirectAttrs
    ) {
        redirectAttrs.addAttribute("productOrderWay", productOrderWay);
        redirectAttrs.addAttribute("sq", sq);

        return "redirect:/product/list";
    }

    // 글 작성
    @PostMapping("/write")
    public String writeOk(
            Product product
            , BindingResult result
            , Model model
            , RedirectAttributes redirectAttrs
            ,@RequestParam Map<String, MultipartFile> file
    ) {

//        if (result.hasErrors()) {
//            redirectAttrs.addFlashAttribute("price", product.getPrice());
//            redirectAttrs.addFlashAttribute("productName", product.getProductName());
//            redirectAttrs.addFlashAttribute("region", product.getRegion());
//            redirectAttrs.addFlashAttribute("content", product.getContent());
//
//            return "redirect:/product/write";
//        }

        model.addAttribute("result", productService.write(product));
        model.addAttribute("insert", productService.imgInsert(file, product.getId()));
        return "product/writeOk";
    }

    // 글 수정
    @PostMapping("/update")
    public String updateOk(
            Product product
            , BindingResult result
            , Model model
            , RedirectAttributes redirectAttrs
            ,@RequestParam Map<String, MultipartFile> file
    ) {
//        if (result.hasErrors()) {
//            redirectAttrs.addFlashAttribute("price", product.getPrice());
//            redirectAttrs.addFlashAttribute("productName", product.getProductName());
//            redirectAttrs.addFlashAttribute("region", product.getRegion());
//            redirectAttrs.addFlashAttribute("content", product.getContent());
//
//            return "redirect:/product/update/" + product.getId();
//        }

        model.addAttribute("result", productService.update(product));
        model.addAttribute("insert", productService.imgInsert(file, product.getId()));
        return "product/updateOk";
    }

    // 댓글 작성
    @PostMapping("/cmtWrite")
    public String marketCmtWrite(ProductComment productComment, Model model) {
        Long productId = productComment.getProductId();
        Long userId = U.getLoggedUser().getId();  // 세션 너란 녀석...
        String content = productComment.getContent();

        model.addAttribute("change", productCommentService.cmtWrite(userId, productId, content));
        return "/product/success";
    }

    // 댓글 삭제
    @PostMapping("/cmtDelete")
    public String marketCmtDel(ProductComment productComment, Model model) {
        Long cmtId = productComment.getId();
        model.addAttribute("change", productCommentService.cmtRemove(cmtId));
        return "/product/success";
    }

    // 글 삭제
    @PostMapping("/detailDelete")
    public String detailDelete(Product product, Model model) {
        Long productId = product.getId();
        model.addAttribute("delete", productService.detailDelete(productId));
        return "/product/deleteOk";
    }

}
