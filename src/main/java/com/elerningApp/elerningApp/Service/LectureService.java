package com.elerningApp.elerningApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
}
