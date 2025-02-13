package com.elerningApp.elerningApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.elerningApp.elerningApp.Model.Course;
import com.elerningApp.elerningApp.Repository.CourseRepo;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepo courseRepo;


    // Create Course
    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    // Get All Courses
    public List<Course>getAllCourses() {
        return courseRepo.findAll();
    }

    // Get Course By ID
    public Optional<Course> getCourseById(String id){
        return courseRepo.findById(id);
    }

    // Update Course
    public ResponseEntity<Course> updateCourse(String id, Course updatedCourse){
        return courseRepo.findById(id).map(existingCourse -> {
              existingCourse.setCourseName(updatedCourse.getCourseName());
              existingCourse.setCourseDescription(updatedCourse.getCourseDescription());
              existingCourse.setCourseDuration(updatedCourse.getCourseDuration());
              existingCourse.setCoursePrice(updatedCourse.getCoursePrice());
              courseRepo.save(existingCourse);
              return ResponseEntity.ok(existingCourse);

        }).orElseGet(() ->ResponseEntity.notFound().build());
    }

    //Delete a course

    public void deleteCourse(String id) {
        courseRepo.deleteById(id);
    }
}
