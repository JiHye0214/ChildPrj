package com.project.childprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protect")
public class ProtectController {

    @RequestMapping("/list")
    public void protectList(){
    }

    @RequestMapping("/detail")
    public void protectDetail(){
    }

}
