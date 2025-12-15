package com.example.demo.model;

import com.example.demo.model.enums.UserRole;
import com.example.demo.model.enums.VerificationStatus;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserModel {
    private long user_Id;
    private String full_Name;
    private String email;
    private String password_hash;
    private String telephone_num;
    private String address; // Added field
    private UserRole role;
    private VerificationStatus verificationStatus;
    private String created_at;
    private String updated_at;

    public UserModel() {
    }

    // 2. Updated Constructor with Address
    public UserModel(long user_Id, String full_Name, String email, String password_hash, String telephone_num, String address, UserRole role) {
        this.user_Id = user_Id;
        this.full_Name = full_Name;
        this.email = email;
        this.password_hash = password_hash;
        this.telephone_num = telephone_num;
        this.address = address;
        this.role = role;
        this.verificationStatus = VerificationStatus.NOT_VERIFIED;
        this.created_at = LocalDateTime.now().toString();
        this.updated_at = LocalDateTime.now().toString();
    }

    // Getters and Setters
    public long getUser_Id() { return user_Id; }
    public void setUser_Id(long user_Id) { this.user_Id = user_Id; }

    public String getFull_Name() { return full_Name; }
    public void setFull_Name(String full_Name) { this.full_Name = full_Name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @JsonIgnore
    public String getPassword() {
        return password_hash;
    } // JSON usually looks for getPassword_hash, but we can map it
    public String getPassword_hash() { return password_hash; }
    public void setPassword_hash(String password_hash) { this.password_hash = password_hash; }

    public String getTelephone_num() { return telephone_num; }
    public void setTelephone_num(String telephone_num) { this.telephone_num = telephone_num; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }

    public VerificationStatus getVerificationStatus() { return verificationStatus; }
    public void setVerificationStatus(VerificationStatus verificationStatus) { this.verificationStatus = verificationStatus; }

    // Helper booleans
    @JsonIgnore
    public boolean isVerified() { return verificationStatus == VerificationStatus.VERIFIED; }
    @JsonIgnore
    public boolean isAdmin() { return role == UserRole.ADMIN; }
}