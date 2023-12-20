package com.project.childprj.controller;

import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/list")
    public void postList(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);
    }

    @RequestMapping("/detail")
    public void postDetail(){
    }

    @RequestMapping("/write")
    public void postWrite(){
    }

    @RequestMapping("/update")
    public void postUpdate(){
    }

}
