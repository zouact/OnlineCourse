package com.master.springcloud.server.settings.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {
    private String id;
    private String courseId;
    private String courseName;
    private String studentId;
    private String studentName;
    private Integer score;
    private String examDate;
}
