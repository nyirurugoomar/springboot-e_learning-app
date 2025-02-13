package com.elerningApp.elerningApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elerningApp.elerningApp.Model.Course;

public interface CourseRepo extends MongoRepository<Course,String> {
    
}
