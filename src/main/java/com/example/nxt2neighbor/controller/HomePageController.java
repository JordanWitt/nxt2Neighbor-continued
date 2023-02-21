package com.example.nxt2neighbor.controller;


import com.example.nxt2neighbor.models.Users;
import com.example.nxt2neighbor.repositories.ListingRepository;
import com.example.nxt2neighbor.repositories.RoleRepository;
import com.example.nxt2neighbor.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    ListingRepository listDao;
    RoleRepository rolesDao;
    UserRepository userDao;
    @GetMapping("/")
    public String landingPage() {
        return "home/home";
    }

}
