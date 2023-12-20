package com.project.childprj.controller;

import jakarta.servlet.http.HttpServletRequest;
import com.project.childprj.util.U;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protect")
public class ProtectController {

    @GetMapping("/list")
    public void protectList(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);
    }

    @GetMapping("/detail")
    public void protectDetail(HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);
    }

}
