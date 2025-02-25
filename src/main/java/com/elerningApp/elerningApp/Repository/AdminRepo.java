package com.elerningApp.elerningApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elerningApp.elerningApp.Model.Admin;

public interface AdminRepo extends MongoRepository<Admin,String> {

    Admin findByEmail(String email);
    
}
