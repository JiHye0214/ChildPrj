package com.project.childprj.controller;

import com.project.childprj.domain.Kindergarden;
import com.project.childprj.service.KindergardenService;
import jakarta.servlet.http.HttpServletRequest;
import com.project.childprj.util.U;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/protect")
public class ProtectController {

    @Autowired
    private KindergardenService kindergardenService;

    @GetMapping("/list")
    public void protectList(Integer page, String type, Model model, HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

//        String type = (String) U.getSession().getAttribute("type");
        if (type == null) type = "유치원";
        if (type.equals("유치원")) {
            kindergardenService.kindergardenList(page, type, model);
        }
    }

    @PostMapping("/typeSelect")
    public String typeSelect(String type, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("type", type);

        return "redirect:/protect/list";
    }

    @GetMapping("/list2")
    @ResponseBody
    public List<Kindergarden> protectList2(Model model, HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        List<Kindergarden> kindergarden = kindergardenService.getAllKindergarden();
        model.addAttribute("kindergarden", kindergarden);

        return kindergarden;
    }

    @GetMapping("/detail/{type}/{id}")
    public String protectDetail(@PathVariable String type, @PathVariable Long id, Model model, HttpServletRequest request){
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        if (type.equals("유치원")) {
            model.addAttribute("type", type);
            model.addAttribute("kindergarden", kindergardenService.getKindergarden(id));
        }

        return "protect/detail";
    }

}
