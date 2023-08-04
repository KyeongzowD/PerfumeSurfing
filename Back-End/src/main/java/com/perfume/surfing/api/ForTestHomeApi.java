package com.perfume.surfing.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForTestHomeApi {
    @GetMapping("/")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "home";
    }
}

