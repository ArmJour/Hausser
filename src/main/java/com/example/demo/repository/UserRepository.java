package com.example.demo.repository;

import com.example.demo.model.UserModel;
import com.example.demo.model.UserRole;
import com.example.demo.model.VerificationStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<UserModel> userTable = new ArrayList<>();

    public UserRepository() {
        UserModel admin = new UserModel(1L, "System Admin", "admin", "1234", "08123456789", UserRole.ADMIN);
        admin.approveVerification();
        userTable.add(admin);

        UserModel majikan = new UserModel(2L, "Budi Santoso", "budi@email.com", "sandi123", "0811111111", UserRole.MAJIKAN);
        userTable.add(majikan);
    }

    public UserModel findById(Long id) {
        for (UserModel user: userTable) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public UserModel findByEmail(String email) {
        for (UserModel user: userTable) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }

    public void save(UserModel user) {
        UserModel existingUser = findById(user.getUserId());

        if (existingUser != null) {
            userTable.remove(existingUser);
        }

        userTable.add(user);
    }

    public void delete(Long id) {
        UserModel userToDelete = findById(id);
        if (userToDelete != null) {
            userTable.remove(userToDelete);
        }
    }

    public List<UserModel> findAll() {
        return userTable;
    }   
}
