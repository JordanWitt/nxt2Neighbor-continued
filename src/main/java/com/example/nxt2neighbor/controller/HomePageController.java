package com.example.nxt2neighbor.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
    @GetMapping("/")
    public String landingPage() {
        return "home/home";
    }
}
