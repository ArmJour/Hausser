package com.example.demo.controller;

import com.example.demo.model.UserModel;
import com.example.demo.model.enums.UserRole;
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

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "action", required = false) String action, Model model) {
        if ("signup".equals(action)) {
            model.addAttribute("showRoleSelection", true);
        }
        return "login-view";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("usernameInput") String email,
                            @RequestParam("passwordInput") String password,
                            Model model) {

        // logic: findByEmail now looks inside the JSON file
        UserModel user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/dashboard"; // Create a dashboard.html later
        } else {
            model.addAttribute("error", "Email atau Password salah!");
            return "login-view";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(@RequestParam(value = "role", required = false) String selectedRole, Model model) {
        String role = (selectedRole != null) ? selectedRole : "MAJIKAN";
        model.addAttribute("selectedRole", role);
        return "registrasi-view";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("namaInput") String nama,
                               @RequestParam("emailInput") String email,
                               @RequestParam("teleponInput") String telepon,
                               @RequestParam("alamatInput") String address, // Make sure HTML name matches this
                               @RequestParam("passInput") String password,
                               @RequestParam("confirmPassInput") String confirmPassword,
                               @RequestParam("roleInput") String roleStr,
                               Model model) {

        model.addAttribute("selectedRole", roleStr);

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Password tidak cocok!");
            return "registrasi-view";
        }

        try {
            UserRole peran = UserRole.valueOf(roleStr.toUpperCase());
            Long newId = System.currentTimeMillis();

            // Create user WITH ADDRESS
            UserModel newUser = new UserModel(newId, nama, email, password, telepon, address, peran);

            // This will trigger the JSON write
            userRepository.save(newUser);

            return "redirect:/login";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Gagal: " + e.getMessage());
            return "registrasi-view";
        }
    }
}