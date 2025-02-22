package com.elerningApp.elerningApp.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Lecture> getLectureById(@PathVariable String id){
        Optional<Lecture> lecture = lectureService.getLectureById(id);
        return lecture.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecture> updateLecture(@PathVariable String id, @RequestBody Lecture lecture){
        return lectureService.updateLecture(id , lecture);
    }

    @DeleteMapping("/{id}")
    public void deleteLecture(@PathVariable String id){
        lectureService.deleteLecture(id);
    }
    
}
