package com.master.springcloud.server.settings.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String courseId;
    private String courseName;
    private Integer credit;
    private Integer theoryHour;
    private Integer praticeHour;
    private String examMode;
    private String score;
    private String examDate;
}
