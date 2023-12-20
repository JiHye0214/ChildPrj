package com.project.childprj.controller;

import com.project.childprj.domain.PostComment;
import com.project.childprj.service.PostCommentService;
import com.project.childprj.service.PostService;
import com.project.childprj.service.UserService;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/list")
    public void postList(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);
    }

    @GetMapping("/detail/{id}")
    public String marketDetail(@PathVariable(name = "id") Long id, Model model) {
        List<PostComment> list = postCommentService.cmtList(id);
        model.addAttribute("postCmt", list); // 특정 글의 댓글
        model.addAttribute("post", postService.postDetail(id));
        return "post/detail";
    }

    @GetMapping("/write")
    public void postWrite(){
    }

    @GetMapping("/update")
    public void postUpdate(){
    }

}
