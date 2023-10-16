package com.sku.awsdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping()
    public String showIndex() {
        System.out.println("HomeController.showIndex");
        return "index";
    }
}
