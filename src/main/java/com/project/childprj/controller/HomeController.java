package com.project.childprj.controller;

import com.project.childprj.service.ChildCenterService;
import com.project.childprj.service.ChildHouseService;
import com.project.childprj.service.KindergardenService;
import com.project.childprj.service.TogetherService;
import com.project.childprj.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private TogetherService togetherService;

    @Autowired
    private KindergardenService kindergardenService;

    @Autowired
    private ChildHouseService childHouseService;

    @Autowired
    private ChildCenterService childCenterService;

    @GetMapping("/home")
    public String home() {
        int startIndex = 1;
        int endIndex = 200;

        togetherService.saveTogether(startIndex, 500);
        kindergardenService.saveKindergarden(startIndex, endIndex);
        childHouseService.saveChildHouse(startIndex, endIndex);
        U.getSession().setAttribute("childCenter", childCenterService.getChildCenter(startIndex, endIndex));

        return "home";
    }

    @GetMapping("/")
    public String home_() {
        return "redirect:/home";
    }

}
