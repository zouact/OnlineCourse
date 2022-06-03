package com.master.springcloud.server.workbench.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName course
 */
@TableName(value ="course")
@Data
public class Course implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 课程编号
     */
    private String courseId;

    /**
     * 课程名
     */
    private String courseName;

    /**
     * 学分
     */
    private Integer credit;

    /**
     * 理论课时
     */
    private Integer theoryHour;

    /**
     * 实践课时
     */
    private String praticeHour;

    /**
     * 考核方式
     */
    private String examMode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getCredit() == null ? other.getCredit() == null : this.getCredit().equals(other.getCredit()))
            && (this.getTheoryHour() == null ? other.getTheoryHour() == null : this.getTheoryHour().equals(other.getTheoryHour()))
            && (this.getPraticeHour() == null ? other.getPraticeHour() == null : this.getPraticeHour().equals(other.getPraticeHour()))
            && (this.getExamMode() == null ? other.getExamMode() == null : this.getExamMode().equals(other.getExamMode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getCredit() == null) ? 0 : getCredit().hashCode());
        result = prime * result + ((getTheoryHour() == null) ? 0 : getTheoryHour().hashCode());
        result = prime * result + ((getPraticeHour() == null) ? 0 : getPraticeHour().hashCode());
        result = prime * result + ((getExamMode() == null) ? 0 : getExamMode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseId=").append(courseId);
        sb.append(", courseName=").append(courseName);
        sb.append(", credit=").append(credit);
        sb.append(", theoryHour=").append(theoryHour);
        sb.append(", praticeHour=").append(praticeHour);
        sb.append(", examMode=").append(examMode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}