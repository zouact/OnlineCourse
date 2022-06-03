package com.master.springcloud.server.workbench.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.Admin;
import com.master.springcloud.server.workbench.domain.Course;
import com.master.springcloud.server.workbench.service.AdminService;
import com.master.springcloud.server.workbench.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    final private AdminService adminService;
    final private CourseService courseService;

    @PostMapping("/query")
    public Admin queryAdmin(@RequestBody Admin admin) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<Admin>();
        adminQueryWrapper.eq("account", admin.getAccount());
        adminQueryWrapper.eq("password", admin.getPassword());
        return adminService.getOne(adminQueryWrapper);
    }

    @RequestMapping("/course/save")
    public Boolean saveCourse(@RequestBody Course course) {
        return courseService.saveOrUpdate(course);
    }

    @RequestMapping("/course/queryList")
    public List<Course> queryCourseList(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        IPage<Course> page = new Page<>();
        //设置每页条数
        page.setSize(pageSize);
        //设置查询第几页
        page.setCurrent(pageNum);
        courseService.page(page);
        return page.getRecords();
    }

    @RequestMapping("/course/queryNum")
    public Integer queryCourseNum(){
        return courseService.count();
    }

    @RequestMapping("/course/queryListByCondition")
    public List<Course> queryCourseListByCondition(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId) {
        IPage<Course> page = new Page<>();
        //设置每页条数
        page.setSize(pageSize);
        //设置查询第几页
        page.setCurrent(pageNum);

        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<Course>();
        if (courseName != null && !"".equals(courseName)) {
            courseQueryWrapper.like("course_name", courseName);
        }
        if (courseId != null && !"".equals(courseId)) {
            courseQueryWrapper.like("course_id", courseId);
        }
        courseService.page(page, courseQueryWrapper);
        return page.getRecords();
    }

    @RequestMapping("/course/queryNumByCondition")
    public Integer queryCourseNumByCondition(@RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        if (courseName != null && !"".equals(courseName)) {
            courseQueryWrapper.like("course_name", courseName);
        }
        if (courseId != null && !"".equals(courseId)) {
            courseQueryWrapper.like("course_id", courseId);
        }
        return courseService.count(courseQueryWrapper);
    }

    @RequestMapping("/course/queryOne")
    public Course queryCourseOne(@RequestParam("id") String id) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.eq("id", id);
        return courseService.getOne(courseQueryWrapper);
    }

    @RequestMapping("/course/delete")
    public Boolean deleteCourse(@RequestParam("id") String[] id) {
//        数组转为集合
        List<String> idList = java.util.Arrays.asList(id);
        return courseService.removeByIds(idList);
    }

}
