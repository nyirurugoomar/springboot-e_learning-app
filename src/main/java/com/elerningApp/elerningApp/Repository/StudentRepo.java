package com.elerningApp.elerningApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elerningApp.elerningApp.Model.Student;

public interface StudentRepo extends MongoRepository<Student,String>{
    
}
