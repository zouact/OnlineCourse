package com.master.springcloud.server.workbench.controller;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.Course;
import com.master.springcloud.server.workbench.domain.Student;
import com.master.springcloud.server.workbench.service.CourseService;
import com.master.springcloud.server.workbench.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    final private StudentService studentService;
    private final CourseService courseService;

    @RequestMapping("/add")
    public Object addStudent(@RequestBody Student student) {
        student.setId(UUID.randomUUID().toString(true));
        return studentService.save(student);
    }

    @RequestMapping("/query")
    public Student queryStudent(@RequestBody Student student) {
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        wrapper.eq("account", student.getAccount());
        wrapper.eq("password", student.getPassword());
        return studentService.getOne(wrapper);
    }

    @RequestMapping("/queryNum")
    public int queryNum() {
        return studentService.count();
    }

    @RequestMapping("/queryListByPage")
    public List<Student> queryStudentListByPage(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        IPage<Student> studentIPage =new Page<>();
        studentIPage.setCurrent(pageNum);
        studentIPage.setSize(pageSize);
        return studentService.page(studentIPage).getRecords();
    }

    @RequestMapping("queryNumByCondition")
    public int queryNumByCondition(@RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        if (studentId != null && !"".equals(studentId)) {
            wrapper.like("student_id", studentId);
        }
        if (studentName != null && !"".equals(studentName)) {
            wrapper.like("student_name", studentName);
        }
        return studentService.count(wrapper);
    }

    @RequestMapping("/queryListByCondition")
    public List<Student> queryStudentListByCondition(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName) {
        IPage<Student> studentIPage =new Page<>();
        studentIPage.setCurrent(pageNum);
        studentIPage.setSize(pageSize);
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        if (studentId != null && !"".equals(studentId)) {
            wrapper.like("student_id", studentId);
        }
        if (studentName != null && !"".equals(studentName)) {
            wrapper.like("student_name", studentName);
        }
        return studentService.page(studentIPage, wrapper).getRecords();
    }

    @RequestMapping("/queryCourseList")
    public List<Course> queryCourseList(@RequestParam("studentId") String studentId,@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        Page<Course> courseIPage =new Page<>();
        courseIPage.setCurrent(pageNum);
        courseIPage.setSize(pageSize);
        return courseService.getCourseList(courseIPage, studentId).getRecords();
    }

    @RequestMapping("/queryCourseListNum")
    public Integer queryCourseListNum(@RequestParam("studentId") String studentId) {
        return courseService.getCourseListNum(studentId);
    }

    @RequestMapping("/queryCourseListByCondition")
    public List<Course> queryCourseListByCondition(@RequestParam("studentId") String studentId,@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId) {
        Page<Course> courseIPage =new Page<>();
        courseIPage.setCurrent(pageNum);
        courseIPage.setSize(pageSize);
        return courseService.getCourseListByCondition(courseIPage, studentId, courseName, courseId).getRecords();
    }

    @RequestMapping("/queryCourseListNumByCondition")
    public Integer queryCourseListNumByCondition(@RequestParam("studentId") String studentId, @RequestParam("courseName") String courseName, @RequestParam("courseId") String courseId) {
        return courseService.getCourseListNumByCondition(studentId, courseName, courseId);
    }



}
