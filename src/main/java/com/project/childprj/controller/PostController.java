package com.project.childprj.controller;

import com.project.childprj.domain.*;
import com.project.childprj.repository.PostRecommendRepository;
import com.project.childprj.service.PostCommentService;
import com.project.childprj.service.PostService;
import com.project.childprj.service.UserService;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private PostCommentService postCommentService;

    // 글 목록
    @GetMapping("/list")
    public void postList(Integer page, String sq, Model model, HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        postService.list(page, sq, model);
    }

    // 글 상세
    @GetMapping("/detail/{id}")
    public String marketDetail(@PathVariable(name = "id") Long id, Model model) {

        // 일단 얘가 null이면 나머지가 전달 안 됨 --> 글만 먼저 전달해야 unleaa/if가 작동하네 깐깐한 자식
        model.addAttribute("post", postService.postDetail(id)); // 특정 글

        if(postService.postDetail(id) != null){
            List<PostComment> list = postCommentService.cmtList(id);
            boolean check = postService.clickCheck(U.getLoggedUser().getId(), id);

            model.addAttribute("check", check); // 추천 눌렀나?
            model.addAttribute("postCmt", list); // 특정 글의 댓글 모음
            model.addAttribute("writerImg", userService.findUserImg(postService.postDetail(id).getUser().getId())); // 글 작성자 img
            model.addAttribute("cmtWriterImg", userService.findUserImg(U.getLoggedUser().getId())); // 댓글 쓸 사람 img
        }

        return "post/detail";
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public void postWrite(Model model){
        model.addAttribute("writerImg", userService.findUserImg(U.getLoggedUser().getId())); // 작성자 img
    }

    // 글 수정 페이지
    @GetMapping("/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model) {
        Post post = postService.postDetail(id);
        model.addAttribute("post", post);
        model.addAttribute("writerImg", userService.findUserImg(U.getLoggedUser().getId())); // 작성자 img
        return "post/update";
    }

    // 글 목록 - 정렬
    @PostMapping("/orderWay")
    public String orderWay(String postOrderWay, String sq, RedirectAttributes redirectAttrs) {
        U.getSession().setAttribute("postOrderWay", postOrderWay);
        redirectAttrs.addAttribute("sq", sq);

        return "redirect:/post/list";
    }

    // 글 목록 - 검색
    @PostMapping("/search")
    public String search(String sq, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("sq", sq);

        return "redirect:/post/list";
    }

    // 글 작성
    @PostMapping("/write")
    public String postWriteOk(
            Post post
            , BindingResult result
            , Model model
            , RedirectAttributes redirectAttrs
    ) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("title", post.getTitle());
            redirectAttrs.addFlashAttribute("content", post.getContent());

            return "redirect:/post/write";
        }

        model.addAttribute("result", postService.write(post));
        return "/post/writeOk";
    }

    // 글 수정
    @PostMapping("/update")
    public String postUpdateOk(
            Post post
            , BindingResult result
            , Model model
            , RedirectAttributes redirectAttrs
    ) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("title", post.getTitle());
            redirectAttrs.addFlashAttribute("content", post.getContent());

            return "redirect:/post/update/" + post.getId();
        }

        model.addAttribute("result", postService.update(post));
        return "post/updateOk";
    }

    // 댓글 작성
    @PostMapping("/cmtWrite")
    public String marketCmtWrite(PostComment postComment, Model model) {
        Long postId = postComment.getPostId();
        Long userId = U.getLoggedUser().getId();  // 세션 너란 녀석...
        String content = postComment.getContent();

        model.addAttribute("change", postCommentService.cmtWrite(userId, postId, content));
        return "/post/success";
    }

    // 댓글 삭제
    @PostMapping("/cmtDelete")
    public String marketCmtDel(PostComment postComment, Model model) {
        Long cmtId = postComment.getId();
        model.addAttribute("change", postCommentService.cmtRemove(cmtId));
        return "/post/success";
    }

    // 글 삭제
    @PostMapping("/detailDelete")
    public String detailDelete(Post post, Model model) {
        Long postId = post.getId();
        model.addAttribute("delete", postService.detailDelete(postId));
        return "/post/deleteOk";
    }

    // 추천
    @PostMapping("/recommend")
    public String recommend(Post post, Model model){
        Long postId = post.getId();
        Long userId = U.getLoggedUser().getId();
        postService.recommend(userId, postId);
        return "/post/success";
    }

    // 비추천
    @PostMapping("/opposite")
    public String opposite(Post post, Model model){
        Long postId = post.getId();
        Long userId = U.getLoggedUser().getId();
        postService.opposite(userId, postId);
        return "/post/success";
    }

}
