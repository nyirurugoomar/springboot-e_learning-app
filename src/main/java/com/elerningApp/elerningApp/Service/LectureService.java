package com.elerningApp.elerningApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elerningApp.elerningApp.Model.Lecture;
import com.elerningApp.elerningApp.Repository.LectureRepo;

@Service
public class LectureService {
    
    @Autowired
    private LectureRepo lectureRepo;

    public Lecture createLecture(Lecture lecture){
        return lectureRepo.save(lecture);
    }

    public List<Lecture> getLectures(){
        return lectureRepo.findAll();
    }

    public Optional<Lecture> getLectureById(String id){
        return lectureRepo.findById(id);
    }

    public ResponseEntity<Lecture> updateLecture(String id, Lecture updatedLecture){
        return lectureRepo.findById(id).map(existingLecture -> {
            existingLecture.setLectureName(updatedLecture.getLectureName());
            existingLecture.setLectureDescription(updatedLecture.getLectureDescription());
            existingLecture.setMaterialUrl(updatedLecture.getMaterialUrl());
            lectureRepo.save(existingLecture);
            return ResponseEntity.ok(existingLecture);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    public void deleteLecture(String id){
        lectureRepo.deleteById(id);
    }
}
