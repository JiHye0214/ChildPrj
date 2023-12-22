package com.project.childprj.controller;

import com.project.childprj.service.KindergardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private KindergardenService kindergardenService;

//    @GetMapping("/home")
//    public void home() {
//    }

    @GetMapping("/home")
    public String home() {
        int startIndex = 1;
        int endIndex = 200;
        kindergardenService.saveKindergarden(startIndex, endIndex);

        return "home";
    }

    @GetMapping("/")
    public String home_() {
        return "redirect:/home";
    }

}
