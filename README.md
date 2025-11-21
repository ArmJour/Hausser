# Hausser - Domestic Worker Placement Information System
Hausser is a web-based application designed to facilitate the recruitment and management of Domestic Workers (ART). It connects Employers (Majikan) with Workers (ART) through a secure platform that handles profile verification, contract negotiation, and dispute resolution.

This project was developed as a Laboratory Assignment for Analisis dan Perancangan Sistem (APS) at Universitas Brawijaya.

![Sign-In](https://github.com/user-attachments/assets/9cf2db4d-1e93-4b5a-8b1b-c5fec365c161)

## 🏗️ System Architecture
This project follows the Monolithic MVC (Model-View-Controller) architecture pattern, ensuring a clean separation of concerns as defined in the SOLID principles.

View Layer: HTML5 + Thymeleaf (Server-Side Rendering) & CSS3.

Controller Layer: Spring Boot Controllers managing HTTP requests and flow.

Model Layer: Java Objects representing business entities (User, Contract, Dispute).

Data Access: In-Memory Repository (Simulating database interactions for development).

## ✨ Key Features
The application includes:

Authentication: User Registration & Login (Employers, ART, Admin) with role-based access.

Profile Management: Management of user details, skills (Keahlian), and work history.

Search & Match: Employers can search for ART based on specific criteria.

Contract System: Digital contract drafting, negotiation, and signing.

Dispute Resolution: A reporting system for conflicts mediated by Administrators.

Admin Dashboard: Tools for user verification and system health monitoring.

## ⚠️ Note 
This project is still a work in porgress.
