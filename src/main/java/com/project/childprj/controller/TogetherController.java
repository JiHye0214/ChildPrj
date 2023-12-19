package com.project.childprj.controller;

import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/together")
public class TogetherController {

    @GetMapping("/list")
    public String test1(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        return "/together/list";
    }
    @RequestMapping("/detail")
    public void test2(){
    }

    @RequestMapping("/zzim")
    public void test13(){
    }

}
