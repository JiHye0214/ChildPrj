package com.project.childprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/home")
    public void test(){
    }

    @RequestMapping("/together/togetherList")
    public void test1(){
    }
    @RequestMapping("/protect/protectList")
    public void test2(){
    }
    @RequestMapping("/community/communityList")
    public void test3(){
    }
    @RequestMapping("/community/communityDetail")
    public void test4(){
    }
    @RequestMapping("/community/communityWrite")
    public void test5(){
    }
    @RequestMapping("/community/communityUpdate")
    public void test6(){
    }
    @RequestMapping("/market/marketList")
    public void test7(){
    }
    @RequestMapping("/market/marketDetail")
    public void test77(){
    }

    @RequestMapping("/together/zzim")
    public void test8(){
    }
    @RequestMapping("/user/mypage")
    public void test9(){
    }
    @RequestMapping("/user/signIn")
    public void test10(){
    }
}
