package com.elerningApp.elerningApp.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elerningApp.elerningApp.Model.Lecture;

public interface LectureRepo extends MongoRepository<Lecture,String>{
    
    
}
