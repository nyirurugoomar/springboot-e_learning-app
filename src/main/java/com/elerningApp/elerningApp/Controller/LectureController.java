package com.elerningApp.elerningApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elerningApp.elerningApp.Model.Lecture;
import com.elerningApp.elerningApp.Service.LectureService;

@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @PostMapping
    public ResponseEntity<String> createLecture(@RequestBody Lecture lecture){
    Lecture createdLecture = lectureService.createLecture(lecture);

    return ResponseEntity.ok("Lecture created successfully" + createdLecture);
    }

    @GetMapping
    public List<Lecture> getLectures(){
        return lectureService.getLectures();
    }
    
}
