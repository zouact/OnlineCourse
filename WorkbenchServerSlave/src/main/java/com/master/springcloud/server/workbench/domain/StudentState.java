package com.master.springcloud.server.workbench.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentState implements Serializable {
    private static final long serialVersionUID = -8790790790790790790L;
    private String id;
    private String studentId;
    private String studentName;
    private BigDecimal totalCredit;
    private Long passedCourseNum;
    private Long failedCourseNum;
    private BigDecimal averageScore;
    private Integer no;
}
