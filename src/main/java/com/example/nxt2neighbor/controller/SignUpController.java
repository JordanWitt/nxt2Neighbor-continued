package com.example.nxt2neighbor.controller;

import com.example.nxt2neighbor.models.Roles;
import com.example.nxt2neighbor.models.Users;
import com.example.nxt2neighbor.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public SignUpController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/join")
    public String signUp(){
        return "home/signUp";
    }
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String handle(@ModelAttribute Users user, BindingResult result, RedirectAttributes redirectAttrs, @ModelAttribute Roles roles) {
        if (result.hasErrors()) {
            return "home/signUp";
        }
        redirectAttrs.addAttribute("id", user.getId()).addFlashAttribute("message", "Account created!");
        String hash = passwordEncoder.encode(user.getPassword());
        roles.setUser_role("buyer");
        user.setPassword(hash);
        userDao.save(user);

        return "redirect:/home";
    }
}
