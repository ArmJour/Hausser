package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.model.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration-view";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("usernameInput") String email, // Using email as username
                            @RequestParam("passwordInput") String password,
                            Model model) {

        UserModel user = userRepository.findByEmail(email); // You need to add findByEmail to Repo

        if (user != null && user.getPassword().equals(password)) {
            // Login Success
            return "redirect:/dashboard";
        } else {
            // Login Failed
            model.addAttribute("error", "Email atau Password salah!");
            return "login-view";
        }
    }
}
