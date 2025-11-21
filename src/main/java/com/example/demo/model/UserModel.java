package com.example.demo.model;

import java.time.LocalDateTime;

public class UserModel {
    private long user_Id;
    private String full_Name;
    private String email;
    private String password_hash;
    private String telephone_num;
    private UserRole role;
    private VerificationStatus verificationStatus;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public UserModel(long user_Id, String Full_name, String email, String password_hash, String telephone_num,
                     UserRole role) {
        this.user_Id = user_Id;
        this.full_Name = full_Name;
        this.email = email;
        this.password_hash = password_hash;
        this.telephone_num = telephone_num;
        this.role = role;
        this.verificationStatus = VerificationStatus.NOT_VERIFIED;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public void updatePassword(String newHash) {
        this.password_hash = newHash;
        this.updated_at = LocalDateTime.now();
    }

    public void updateInfo(String full_Name, String telephone_num) {
        this.full_Name = full_Name;
        this.telephone_num = telephone_num;
        this.updated_at = LocalDateTime.now();
    }

    public void submitForVerification() {
       this.verificationStatus = VerificationStatus.PENDING;
       this.updated_at = LocalDateTime.now();
    }
    public void approveVerification() {
        this.verificationStatus = VerificationStatus.VERIFIED;
        this.updated_at = LocalDateTime.now();
    }
    public void rejectVerification() {
        this.verificationStatus = VerificationStatus.REJECTED;
        this.updated_at = LocalDateTime.now();
    }
    public boolean isVerified() {
        return verificationStatus == VerificationStatus.VERIFIED;
    }
    public boolean isPending() {
        return verificationStatus == VerificationStatus.PENDING;
    }
    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

    public Long getUserId() { return user_Id; }
    public String getFull_Name() { return full_Name; }
    public String getEmail() { return email; }
    public String getPassword() { return password_hash; }
    public String getTelephone_num() { return telephone_num; }
    public UserRole getRole() { return role; }
    public VerificationStatus getVerificationStatus() { return verificationStatus; }

}
