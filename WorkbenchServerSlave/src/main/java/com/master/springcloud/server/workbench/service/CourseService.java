package com.master.springcloud.server.workbench.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.master.springcloud.server.workbench.domain.Course;

/**
* @author artmaster
* @description 针对表【course】的数据库操作Service
* @createDate 2022-05-30 10:29:51
*/
public interface CourseService extends IService<Course> {
    IPage<Course> getCourseList(Page<Course> page,String studentId);
    IPage<Course> getCourseListByCondition(Page<Course> page,String studentId,String courseName,String courseId);
    Integer getCourseListNum(String studentId);
    Integer getCourseListNumByCondition(String studentId,String courseName,String courseId);
}
