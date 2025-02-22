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
public class Lecture {
    @Id
    private String id;
    
    private String lectureName;

    private String lectureDescription;

    private String materialUrl;
}
