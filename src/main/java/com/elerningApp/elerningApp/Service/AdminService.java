package com.elerningApp.elerningApp.Service;

import com.elerningApp.elerningApp.Model.Admin;
import com.elerningApp.elerningApp.Repository.AdminRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;

    // ✅ Constructor injection
    public AdminService(AdminRepo adminRepo, PasswordEncoder passwordEncoder) {
        this.adminRepo = adminRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin registerAdmin(Admin admin) {
        // Check if email already exists
        if (adminRepo.findByEmail(admin.getEmail()) != null) {
            throw new IllegalArgumentException("Email already in use");
        }

        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(hashedPassword);

        // Save to database
        return adminRepo.save(admin);
    }

    //login
    public Admin loginAdmin(String email, String password) {
        Admin admin = adminRepo.findByEmail(email);

        if (admin == null) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        // Verify password
        if (!passwordEncoder.matches(password, admin.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return admin; // Return the admin if login is successful
    }
}
