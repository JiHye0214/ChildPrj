package com.project.childprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/home")
    public void home() {

    }

    @RequestMapping("/")
    public String home_() {
        return "redirect:/home";
    }

}
