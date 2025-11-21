package com.example.demo.model;

import java.time.LocalDateTime;

public class UserModel {
    public long user_id;
    public String full_name;
    public String email;
    public String password_hash;
    public String telephone_num;
    public UserRole role;
    public VerificationStatus verificationStatus;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public UserModel(long user_id, String full_name, String email, String password_hash, String telephone_num,
                     UserRole role, VerificationStatus verificationStatus, LocalDateTime created_at, LocalDateTime updated_at) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.email = email;
        this.password_hash = password_hash;
        this.telephone_num = telephone_num;
        this.role = role;
        this.verificationStatus = verificationStatus;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void updatePassword(String newHash) {
        this.password_hash = newHash;
    }

    public void updateInfo(String full_name, String telephone_num) {
        this.full_name = full_name;
        this.telephone_num = telephone_num;
    }

    public void submitForVerification() { }
    public void approveVerification() { }
    public void rejectVerification() { }
    public boolean isVerified() {
        return verificationStatus == VerificationStatus.VERIFIED;
    }
    public boolean isPending() {
        return verificationStatus == VerificationStatus.PENDING;
    }
    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

}
