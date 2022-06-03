package com.master.springcloud.server.settings.service;

import com.master.springcloud.server.settings.domain.Course;
import com.master.springcloud.server.settings.domain.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "service-workbench")
public interface StudentService {

    @RequestMapping("/workbench/student/add")
    Boolean addStudent(@RequestBody Student student);

    @RequestMapping("/workbench/student/query")
    public Student queryStudent(@RequestBody Student student);

    @RequestMapping("/workbench/student/queryListByPage")
    public List<Student> queryStudentListByPage(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum);

    @RequestMapping("/workbench/student/queryNum")
    public int queryNum();

    @RequestMapping("/workbench/student/queryNumByCondition")
    public int queryNumByCondition(@RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName);

    @RequestMapping("/workbench/student/queryListByCondition")
    public List<Student> queryStudentListByCondition(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName);

    @RequestMapping("/workbench/student/queryCourseList")
    public List<Course> queryCourseList(@RequestParam("studentId") String studentId, @RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum);

    @RequestMapping("/workbench/student/queryCourseListNum")
    public Integer queryCourseListNum(@RequestParam("studentId") String studentId);

    @RequestMapping("/workbench/student/queryCourseListByCondition")
    public List<Course> queryCourseListByCondition(@RequestParam("studentId") String studentId,@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId);

    @RequestMapping("/workbench/student/queryCourseListNumByCondition")
    public Integer queryCourseListNumByCondition(@RequestParam("studentId") String studentId, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId);
}
