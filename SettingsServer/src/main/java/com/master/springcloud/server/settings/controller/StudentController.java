package com.master.springcloud.server.settings.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.master.springcloud.server.settings.commons.enity.Constant;
import com.master.springcloud.server.settings.commons.enity.ReturnObject;
import com.master.springcloud.server.settings.domain.Course;
import com.master.springcloud.server.settings.domain.StuCourse;
import com.master.springcloud.server.settings.domain.Student;
import com.master.springcloud.server.settings.service.StuCourseService;
import com.master.springcloud.server.settings.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/workbench/student")
public class StudentController {

    private final StudentService studentService;
    private final StuCourseService stuCourseService;

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = (Student) session.getAttribute(Constant.SESSION_STUDENT);
        if (student != null) {
            session.removeAttribute(Constant.SESSION_STUDENT);
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/queryByPage")
    public Object queryStudentListByPage(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Student> students = studentService.queryStudentListByPage(pageSize, pageNum);
            int length = studentService.queryNum();
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("students", students);
            map.put("length", length);
            returnObject.setData(map);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试");
        }
        return returnObject;
    }

    @RequestMapping("/queryByCondition")
    public Object queryStudentListByCondition(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("studentId") String studentId, @RequestParam("studentName") String studentName) {
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Student> students = studentService.queryStudentListByCondition(pageSize, pageNum, studentId, studentName);
            int length = studentService.queryNumByCondition(studentId, studentName);
            HashMap<String, Object> map = new HashMap<>(2);
            map.put("students", students);
            map.put("length", length);
            returnObject.setData(map);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试");
        }
        return returnObject;
    }

    @RequestMapping("/getCourseList")
    public Object getCourseList(@RequestParam("studentId") String studentId, @RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum) {
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Course> courses = studentService.queryCourseList(studentId, pageSize, pageNum);
            Integer length = studentService.queryCourseListNum(studentId);
            Map<String, Object> map = new HashMap<>(2);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功");
            map.put("data", courses);
            map.put("length", length);
            returnObject.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试");
        }
        return returnObject;
    }

    @RequestMapping("/getCourseListByCondition")
    public Object getCourseListByCondition(@RequestParam("studentId") String studentId, @RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("courseId") String courseId, @RequestParam("courseName") String courseName) {
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Course> courses = studentService.queryCourseListByCondition(studentId, pageSize, pageNum, courseName, courseId);
            Integer length = studentService.queryCourseListNumByCondition(studentId, courseName, courseId);
            Map<String, Object> map = new HashMap<>(2);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功");
            map.put("data", courses);
            map.put("length", length);
            returnObject.setData(map);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试");
        }
        return returnObject;
    }

    @RequestMapping("/addStuCourse")
    public Object addStuCourse(@RequestParam("studentId") String studentId, @RequestParam("courseId") String courseId) {
        ReturnObject returnObject = new ReturnObject();
        try {
            StuCourse stuCourse = new StuCourse();
            stuCourse.setStudentId(studentId);
            stuCourse.setCourseId(courseId);
            stuCourse.setId(UUID.randomUUID().toString(true));
            stuCourseService.saveStuCourse(stuCourse);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，请稍后再试");
        }
        return returnObject;
    }


}
