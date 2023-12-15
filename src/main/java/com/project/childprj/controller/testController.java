package com.project.childprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community")
public class testController {

    @GetMapping("/communityList")
    public void test1() {
    }

    @GetMapping("/communityDetail")
    public void test2() {
    }

    @GetMapping("/communityWrite")
    public void test3() {
    }

    @GetMapping("/communityUpdate")
    public void test4() {
    }
}
