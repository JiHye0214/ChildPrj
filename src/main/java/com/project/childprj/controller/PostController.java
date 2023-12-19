package com.project.childprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @RequestMapping("/list")
    public void postList(){
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
