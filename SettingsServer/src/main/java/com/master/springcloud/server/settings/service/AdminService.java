package com.master.springcloud.server.settings.service;

import com.master.springcloud.server.settings.domain.Admin;
import com.master.springcloud.server.settings.domain.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-workbench")
public interface AdminService {

    @PostMapping("/workbench/admin/query")
    public Admin queryAdmin(@RequestBody Admin admin);

    @RequestMapping("/workbench/admin/course/save")
    public Boolean saveCourse(@RequestBody Course course);

    @RequestMapping("/workbench/admin/course/queryList")
    public List<Course> queryCourseList(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum);

    @RequestMapping("/workbench/admin/course/queryNum")
    public Integer queryCourseNum();

    @RequestMapping("/workbench/admin/course/queryListByCondition")
    public List<Course> queryCourseListByCondition(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId);

    @RequestMapping("/workbench/admin/course/queryNumByCondition")
    public Integer queryCourseNumByCondition(@RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId);

    @RequestMapping("/workbench/admin/course/queryOne")
    public Course queryCourseOne(@RequestParam("id") String id);

    @RequestMapping("/workbench/admin/course/delete")
    public Boolean deleteCourse(@RequestParam("id") String[] id);
}
