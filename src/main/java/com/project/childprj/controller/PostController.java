package com.project.childprj.controller;

import com.project.childprj.domain.ProductComment;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/list")
    public void postList(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);
    }

    @GetMapping("/detail/{id}")
    public String marketDetail(@PathVariable(name = "id") Long id, Model model) {

        return "/post/detail";
    }

    @RequestMapping("/write")
    public void postWrite(){
    }

    @RequestMapping("/update")
    public void postUpdate(){
    }

}
