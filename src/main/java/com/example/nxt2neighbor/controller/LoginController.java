package com.example.nxt2neighbor.controller;

import com.example.nxt2neighbor.models.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(Model model) {
        Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        // Add other profile information as needed
        if (user.getRole().getId() == 1) {
            return "profiles/seller";
        } else if (user.getRole().getId() == 2) {
            return "profiles/buyer";
        } else if (user.getRole().getId() == 3) {
            return "profiles/neighbor";
        }
        return "home/home";
    }
}

