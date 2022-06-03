package com.master.springcloud.server.workbench.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.master.springcloud.server.workbench.domain.Course;
import com.master.springcloud.server.workbench.mapper.CourseMapper;
import com.master.springcloud.server.workbench.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author artmaster
* @description 针对表【course】的数据库操作Service实现
* @createDate 2022-05-30 10:29:51
*/
@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService {

    private final CourseMapper courseMapper;

    @Override
    public IPage<Course> getCourseList(Page<Course> page, String studentId) {
        return courseMapper.getCourseList(page, studentId);
    }

    @Override
    public IPage<Course> getCourseListByCondition(Page<Course> page, String studentId, String courseName, String courseId) {
        return courseMapper.getCourseListByCondition(page, studentId, courseName, courseId);
    }

    @Override
    public Integer getCourseListNum(String studentId) {
        return courseMapper.getCourseListNum(studentId);
    }

    @Override
    public Integer getCourseListNumByCondition(String studentId, String courseName, String courseId) {
        return courseMapper.getCourseListNumByCondition(studentId, courseName, courseId);
    }
}




