package com.master.springcloud.server.workbench.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.CourseStudent;
import com.master.springcloud.server.workbench.domain.StuCourse;
import com.master.springcloud.server.workbench.domain.StudentCourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author artmaster
* @description 针对表【stu_course】的数据库操作Mapper
* @createDate 2022-05-30 10:29:51
* @Entity generator.domain.StuCourse
*/
public interface StuCourseMapper extends BaseMapper<StuCourse> {
    public IPage<StudentCourse> getStudentCourse(@Param("stuId") String stuId, Page<StudentCourse> page);

    public IPage<StudentCourse> getStudentCourseOK(@Param("stuId") String stuId, Page<StudentCourse> page);

    public Map<String,Object> getCoursePassedCount(@Param("stuId") String stuId);

    public Long getCourseFailedCount(@Param("stuId") String stuId);

    public IPage<CourseStudent> getCourseStudent(@Param("courseId") String courseId, Page<CourseStudent> page);

    public IPage<CourseStudent> getCourseStudentOK(@Param("courseId") String courseId, Page<CourseStudent> page);

    public Boolean deleteStuCourseById(@Param("ids") List<String> ids);

}




