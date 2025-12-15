package com.example.demo.repository;

import com.example.demo.model.UserModel;
import com.example.demo.model.enums.UserRole;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<UserModel> userTable = new ArrayList<>();
    private final String FILE_PATH = "users.json"; // File will be created in project root
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserRepository() {
        // Load existing users from JSON file on startup
        loadDataFromFile();

        if (userTable.isEmpty()) {
            System.out.println("No users found. Creating default Admin...");
            UserModel admin = new UserModel(1L, "System Admin", "admin", "1234", "08123456789", "Admin Office", UserRole.ADMIN);
            admin.setVerificationStatus(com.example.demo.model.enums.VerificationStatus.VERIFIED);
            save(admin);
        }

        System.out.println("Saving data to: " + new File(FILE_PATH).getAbsolutePath());
    }

    // --- JSON FILE HANDLING ---
    private void loadDataFromFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try {
                userTable = objectMapper.readValue(file, new TypeReference<List<UserModel>>() {});
                System.out.println("Users loaded successfully: " + userTable.size());
            } catch (IOException e) {
                throw new RuntimeException("CRITICAL: Failed to load users.json. Fix the file or delete it manually.", e);
            }
        }
    }

    private void saveDataToFile() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), userTable);
            System.out.println("Users saved to " + FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error saving user file: " + e.getMessage());
        }
    }
    // ---------------------------

    public UserModel findByEmail(String email) {
        // Always refresh data from file before checking login to be safe
        loadDataFromFile();
        for (UserModel user : userTable) {
            if (user.getEmail() != null && user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public void save(UserModel user) {
        userTable.removeIf(u -> u.getUser_Id() == user.getUser_Id());

        userTable.add(user);
        saveDataToFile();
    }

    public List<UserModel> findAll() {
        loadDataFromFile();
        return userTable;
    }
}