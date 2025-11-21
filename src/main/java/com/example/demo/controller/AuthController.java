package com.example.demo.controller;

import com.example.demo.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class AuthController {
    @GetMapping("/login")
    public String showLoginPage() {
        // Returns the HTML file name "login-view.html"
        return "login-view";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("usernameInput") String username,
                               @RequestParam("passwordInput") String password,
                               Model model) {

        // --- SIMULATION OF MODEL INTERACTION  ---
        // In a real app, you would call UserModel.checkDatabase(username, password) here.
        // For now, we hardcode it to test the flow.

        if ("admin".equals(username) && "1234".equals(password)) {
            // Login Success: Redirect to Dashboard
            // (Matches "DashboardController" in your doc )
            return "redirect:/dashboard";
        } else {
            // Login Failed: Stay on login page and show error
            model.addAttribute("error", "Username atau Password salah!");
            return "login-view";
        }
    }

    public void 
}
