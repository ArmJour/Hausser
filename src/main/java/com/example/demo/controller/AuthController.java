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
    public String showLoginPage(@RequestParam(value = "action", required = false) String action,
                                Model model) {

        // Cek apakah user mengklik "Buat Akun" (action=signup)
        if ("signup".equals(action)) {
            // Beri sinyal ke HTML untuk menampilkan popup
            model.addAttribute("showRoleSelection", true);
        }

        return "login-view";
    }

    // --- 2. PROSES LOGIN ---
    @PostMapping("/login")
    public String loginUser(@RequestParam("usernameInput") String email,
                            @RequestParam("passwordInput") String password,
                            Model model) {

        UserModel user = userRepository.findByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Email atau Password salah!");
            return "login-view";
        }
    }

    @GetMapping("/register")
    public String showRegistrationPage(@RequestParam(value = "role", required = false) String selectedRole,
                                       Model model) {
        if (selectedRole != null) {
            model.addAttribute("selectedRole", selectedRole);
        }
        return "registrasi-view";
    }

    // --- 4. PROSES REGISTRASI ---
    @PostMapping("/register")
    public String registerUser(@RequestParam("namaInput") String nama,
                               @RequestParam("emailInput") String email,
                               @RequestParam("passInput") String password,
                               @RequestParam("teleponInput") String telepon,
                               @RequestParam("roleInput") String roleStr,
                               Model model) {
        try {
            UserRole peran = UserRole.valueOf(roleStr.toUpperCase());
            Long newId = System.currentTimeMillis();
            UserModel newUser = new UserModel(newId, nama, email, password, telepon, peran);
            userRepository.save(newUser);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Registrasi Gagal: " + e.getMessage());
            return "registrasi-view";
        }
    }
}