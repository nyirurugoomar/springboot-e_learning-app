package com.elerningApp.elerningApp.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.elerningApp.elerningApp.Model.Admin;
import com.elerningApp.elerningApp.Service.AdminService;

@RestController
@RequestMapping("/auth")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // Register Admin
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin) {
        try {
            Admin savedAdmin = adminService.registerAdmin(admin);
            return ResponseEntity.ok(savedAdmin);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // Handle duplicate email
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering admin: " + e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin loginRequest) {
        try {
            Admin admin = adminService.loginAdmin(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(admin);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(e.getMessage()); // Unauthorized
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error logging in: " + e.getMessage());
        }
    }

}
