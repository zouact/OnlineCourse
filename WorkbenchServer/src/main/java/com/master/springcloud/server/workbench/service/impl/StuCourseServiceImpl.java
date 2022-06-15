package com.master.springcloud.server.workbench.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.master.springcloud.server.workbench.domain.CourseStudent;
import com.master.springcloud.server.workbench.domain.StuCourse;
import com.master.springcloud.server.workbench.domain.StudentCourse;
import com.master.springcloud.server.workbench.mapper.StuCourseMapper;
import com.master.springcloud.server.workbench.service.StuCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author artmaster
* @description 针对表【stu_course】的数据库操作Service实现
* @createDate 2022-05-30 10:29:51
*/
@Service
@RequiredArgsConstructor
public class StuCourseServiceImpl extends ServiceImpl<StuCourseMapper, StuCourse>
    implements StuCourseService {

    final private StuCourseMapper stuCourseMapper;


    @Override
    public IPage<StudentCourse> getStudentCourse(String stuId, Page<StudentCourse> page) {
        return stuCourseMapper.getStudentCourse(stuId, page);
    }

    @Override
    public IPage<StudentCourse> getStudentCourseOK(String stuId, Page<StudentCourse> page) {
        return stuCourseMapper.getStudentCourseOK(stuId, page);
    }


    @Override
    public Map<String, Object> getCoursePassedCount(String stuId) {
        return stuCourseMapper.getCoursePassedCount(stuId);
    }

    @Override
    public Long getCourseFailedCount(String stuId) {
        return stuCourseMapper.getCourseFailedCount(stuId);
    }

    @Override
    public IPage<CourseStudent> getCourseStudent(String courseId, Page<CourseStudent> page) {
        return stuCourseMapper.getCourseStudent(courseId, page);
    }

    @Override
    public IPage<CourseStudent> getCourseStudentOK(String courseId, Page<CourseStudent> page) {
        return stuCourseMapper.getCourseStudentOK(courseId, page);
    }

    @Override
    public Boolean deleteStuCourseById(List<String> ids) {
        return stuCourseMapper.deleteStuCourseById(ids);
    }
}




