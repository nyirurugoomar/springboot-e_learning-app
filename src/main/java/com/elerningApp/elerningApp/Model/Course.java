package com.elerningApp.elerningApp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String id;

    private String courseName;

    private String courseDescription;

    private Number courseDuration;

    private Number coursePrice;

    

}
