package com.project.childprj.controller;

import com.project.childprj.domain.Together;
import com.project.childprj.service.TogetherService;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/together")
public class TogetherController {

    @Autowired
    private TogetherService togetherService;

    @GetMapping("/list")
    public String togetherList(Integer page
            , String type
            , Model model
            , HttpServletRequest request
            , RedirectAttributes redirectAttrs
    ) {
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        if (type == null) type = "체험";

        if (type.equals("체험") || type.equals("축제") || type.equals("공연ㆍ예술")) {
            togetherService.togetherList(page, type, model);
            return "together/list";
        } else {
            redirectAttrs.addAttribute("type", "체험");
            return "redirect:/together/list";
        }
    }

    @PostMapping("/typeSelect")
    public String typeSelect(String type, RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("type", type);

        return "redirect:/together/list";
    }

    @GetMapping("/detail/{type}/{id}")
    public String protectDetail(
            @PathVariable String type
            , @PathVariable Long id
            , Model model
            , HttpServletRequest request
            , RedirectAttributes redirectAttrs
    ) {
        String uri = U.getRequest().getRequestURI();
        request.getSession().setAttribute("prevPage", uri);

        if (type.equals("체험") || type.equals("축제") || type.equals("공연ㆍ예술")) {
            model.addAttribute("type", type);
            model.addAttribute("together", togetherService.getTogether(id));

        } else {
            redirectAttrs.addAttribute("type", "체험");
            return "redirect:/together/list";
        }

        return "together/detail";
    }


}
