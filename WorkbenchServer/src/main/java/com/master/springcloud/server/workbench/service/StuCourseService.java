package com.master.springcloud.server.workbench.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.master.springcloud.server.workbench.domain.CourseStudent;
import com.master.springcloud.server.workbench.domain.StuCourse;
import com.master.springcloud.server.workbench.domain.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author artmaster
* @description 针对表【stu_course】的数据库操作Service
* @createDate 2022-05-30 10:29:51
*/
public interface StuCourseService extends IService<StuCourse> {

    /**
     * @description 根据学生id查询学生课程信息
     * @author artmaster
     * @date 2020/5/30
     * @param stuId
     * @return
     */
    IPage<StudentCourse> getStudentCourse(String stuId, Page<StudentCourse> page);

    IPage<StudentCourse> getStudentCourseOK(String stuId, Page<StudentCourse> page);


    public Map<String,Object> getCoursePassedCount(String stuId);

    public Long getCourseFailedCount(String stuId);

    public IPage<CourseStudent> getCourseStudent(String courseId, Page<CourseStudent> page);

    public IPage<CourseStudent> getCourseStudentOK(String courseId, Page<CourseStudent> page);
}
