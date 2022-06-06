package com.master.springcloud.server.workbench.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.Course;
import org.apache.ibatis.annotations.Param;

/**
* @author artmaster
* @description 针对表【course】的数据库操作Mapper
* @createDate 2022-05-30 10:29:51
* @Entity generator.domain.Course
*/
public interface CourseMapper extends BaseMapper<Course> {
    IPage<Course> getCourseList(Page<Course> page, @Param("studentId") String studentId);
    IPage<Course> getCourseListByCondition(Page<Course> page, @Param("studentId") String studentId, @Param("courseName") String courseName, @Param("courseId") String courseId);
    Integer getCourseListNum(@Param("studentId") String studentId);
    Integer getCourseListNumByCondition(@Param("studentId") String studentId, @Param("courseName") String courseName, @Param("courseId") String courseId);
}




