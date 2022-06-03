package com.master.springcloud.server.workbench.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.CourseStudent;
import com.master.springcloud.server.workbench.domain.StuCourse;
import com.master.springcloud.server.workbench.domain.StudentCourse;
import com.master.springcloud.server.workbench.domain.StudentState;
import com.master.springcloud.server.workbench.service.StuCourseService;
import com.master.springcloud.server.workbench.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stuCourse")
@RequiredArgsConstructor
public class StudentCourseController {

    final private StuCourseService stuCourseService;
    final private StudentService studentService;

    @RequestMapping("/save")
    public Boolean saveStuCourse(@RequestBody StuCourse stuCourse) {
        return stuCourseService.save(stuCourse);
    }

    @RequestMapping("/queryList")
    public List<StudentCourse> queryList(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("stuId") String stuId) {
        Page<StudentCourse> studentCourseIPage=new Page<>();
        //设置每页条数
        studentCourseIPage.setSize(pageSize);
        //设置查询第几页
        studentCourseIPage.setCurrent(pageNum);
        return stuCourseService.getStudentCourse(stuId,studentCourseIPage).getRecords();
    }

    @RequestMapping("/queryListOK")
    public List<StudentCourse> queryListOK(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("stuId") String stuId) {
        Page<StudentCourse> studentCourseIPage=new Page<>();
        //设置每页条数
        studentCourseIPage.setSize(pageSize);
        //设置查询第几页
        studentCourseIPage.setCurrent(pageNum);
        return stuCourseService.getStudentCourseOK(stuId,studentCourseIPage).getRecords();
    }


    @RequestMapping("/queryNum")
    public int queryNum(@RequestParam("stuId") String stuId) {
        QueryWrapper<StuCourse> stuCourseQueryWrapper = new QueryWrapper<>();
        stuCourseQueryWrapper.eq("student_id", stuId);
        stuCourseQueryWrapper.isNull("score");
        stuCourseQueryWrapper.isNull("exam_date");
        return stuCourseService.count(stuCourseQueryWrapper);
    }

    @RequestMapping("/queryNumOK")
    public int queryNumOK(@RequestParam("stuId") String stuId) {
        QueryWrapper<StuCourse> stuCourseQueryWrapper = new QueryWrapper<>();
        stuCourseQueryWrapper.eq("student_id", stuId);
        stuCourseQueryWrapper.isNotNull("score");
        stuCourseQueryWrapper.isNotNull("exam_date");
        return stuCourseService.count(stuCourseQueryWrapper);
    }

    @RequestMapping("/delete")
    public Boolean deleteStuCourse(@RequestParam("id") String id) {
        QueryWrapper<StuCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return stuCourseService.remove(wrapper);
    }


    public List<StudentState> getStudentStateAll() {
        Page<StudentState> studentStatePage = new Page<>();
        studentStatePage.setSize(1000);
        studentStatePage.setCurrent(1);
        List<StudentState> studentStateList = studentService.getStudentStateList(studentStatePage).getRecords();
        int addNum=0;
        for(StudentState studentState : studentStateList) {
            Map<String, Object> coursePassedCount = stuCourseService.getCoursePassedCount(studentState.getId());
            if(coursePassedCount==null){
                studentState.setPassedCourseNum(0L);
                studentState.setTotalCredit(new BigDecimal(0));
            }else {
                studentState.setPassedCourseNum((Long) stuCourseService.getCoursePassedCount(studentState.getId()).get("passed_course_num"));
                studentState.setTotalCredit((BigDecimal) stuCourseService.getCoursePassedCount(studentState.getId()).get("total_credit"));
            }
            if (stuCourseService.getCourseFailedCount(studentState.getId()) == null) {
                studentState.setFailedCourseNum(0L);
            } else {
                studentState.setFailedCourseNum((Long) stuCourseService.getCourseFailedCount(studentState.getId()));
            }
            studentState.setNo(++addNum);
//            平均分保留小数点后两位
            studentState.setAverageScore(studentState.getAverageScore().setScale(2, RoundingMode.HALF_UP));
        }
        return studentStateList;
    }


    @GetMapping("/StudentState")
    public List<StudentState> getStudentState(@RequestParam int pageSize, @RequestParam int pageNum) {
        Page<StudentState> studentStatePage = new Page<>();
        studentStatePage.setSize(pageSize);
        studentStatePage.setCurrent(pageNum);
        List<StudentState> studentStateList = studentService.getStudentStateList(studentStatePage).getRecords();
        for(StudentState studentState : studentStateList) {
            Map<String, Object> coursePassedCount = stuCourseService.getCoursePassedCount(studentState.getId());
            if(coursePassedCount==null){
                studentState.setPassedCourseNum(0L);
                studentState.setTotalCredit(new BigDecimal(0));
            }else {
                studentState.setPassedCourseNum((Long) stuCourseService.getCoursePassedCount(studentState.getId()).get("passed_course_num"));
                studentState.setTotalCredit((BigDecimal) stuCourseService.getCoursePassedCount(studentState.getId()).get("total_credit"));
            }
            if (stuCourseService.getCourseFailedCount(studentState.getId()) == null) {
                studentState.setFailedCourseNum(0L);
            } else {
                studentState.setFailedCourseNum((Long) stuCourseService.getCourseFailedCount(studentState.getId()));
            }
            studentState.setNo(getNo(getStudentStateAll(),studentState.getId()));
//            平均分保留小数点后两位
            studentState.setAverageScore(studentState.getAverageScore().setScale(2, RoundingMode.HALF_UP));
        }
        return studentStateList;
    }

    @GetMapping("/StudentStateByCondition")
    public List<StudentState> getStudentStateByCondition(@RequestParam int pageSize, @RequestParam int pageNum,@RequestParam String studentId,@RequestParam String studentName) {
        Page<StudentState> studentStatePage = new Page<>();
        studentStatePage.setSize(pageSize);
        studentStatePage.setCurrent(pageNum);
        List<StudentState> studentStateList = studentService.getStudentStateListByCondition(studentStatePage,studentName,studentId).getRecords();
        for(StudentState studentState : studentStateList) {
            Map<String, Object> coursePassedCount = stuCourseService.getCoursePassedCount(studentState.getId());
            if(coursePassedCount==null){
                studentState.setPassedCourseNum(0L);
                studentState.setTotalCredit(new BigDecimal(0));
            }else {
                studentState.setPassedCourseNum((Long) stuCourseService.getCoursePassedCount(studentState.getId()).get("passed_course_num"));
                studentState.setTotalCredit((BigDecimal) stuCourseService.getCoursePassedCount(studentState.getId()).get("total_credit"));
            }
            if (stuCourseService.getCourseFailedCount(studentState.getId()) == null) {
                studentState.setFailedCourseNum(0L);
            } else {
                studentState.setFailedCourseNum((Long) stuCourseService.getCourseFailedCount(studentState.getId()));
            }
            studentState.setNo(getNo(getStudentStateAll(),studentState.getId()));
//            平均分保留小数点后两位
            studentState.setAverageScore(studentState.getAverageScore().setScale(2, RoundingMode.HALF_UP));
        }
        return studentStateList;
    }



    @GetMapping("/StudentStateById")
    public StudentState getStudentStateById(@RequestParam String studentId) {
        StudentState studentState = studentService.getStudentStateByStuId(studentId);
        Map<String, Object> coursePassedCount = stuCourseService.getCoursePassedCount(studentState.getId());
        if(coursePassedCount==null){
            studentState.setPassedCourseNum(0L);
            studentState.setTotalCredit(new BigDecimal(0));
        }else {
            studentState.setPassedCourseNum((Long) stuCourseService.getCoursePassedCount(studentState.getId()).get("passed_course_num"));
            studentState.setTotalCredit((BigDecimal) stuCourseService.getCoursePassedCount(studentState.getId()).get("total_credit"));
        }
        if (stuCourseService.getCourseFailedCount(studentState.getId()) == null) {
            studentState.setFailedCourseNum(0L);
        } else {
            studentState.setFailedCourseNum((Long) stuCourseService.getCourseFailedCount(studentState.getId()));
        }
        studentState.setNo(getNo(getStudentStateAll(),studentState.getId()));
        studentState.setAverageScore(studentState.getAverageScore().setScale(2, RoundingMode.HALF_UP));
        return studentState;
    }


    protected int getNo(List<StudentState> list,String stuId){
        int no=0;
        for (StudentState studentState : list) {
            if (studentState.getId().equals(stuId)) {
                no=studentState.getNo();
            }
        }
        return no;
    }


    @RequestMapping("/deleteStuCourse")
    public Boolean deleteStuCourse(@RequestParam String studentId,@RequestParam String courseId){
        UpdateWrapper<StuCourse> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("student_id",studentId);
        updateWrapper.eq("course_id",courseId);
        return stuCourseService.remove(updateWrapper);
    }

    @RequestMapping("/getCourseStudent")
    public List<CourseStudent> getCourseStudent(@RequestParam String courseId,@RequestParam int pageNum,@RequestParam int pageSize){
        Page<CourseStudent> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return stuCourseService.getCourseStudent(courseId,page).getRecords();
    }

    @RequestMapping("/getCourseStudentOK")
    public List<CourseStudent> getCourseStudentOK(@RequestParam String courseId,@RequestParam int pageNum,@RequestParam int pageSize){
        Page<CourseStudent> page = new Page<>();
        page.setSize(pageSize);
        page.setCurrent(pageNum);
        return stuCourseService.getCourseStudentOK(courseId,page).getRecords();
    }

    @RequestMapping("/getCourseStudentNumOk")
    public Integer getCourseStudentNumOk(@RequestParam String courseId){
        QueryWrapper<StuCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.isNotNull("score");
        wrapper.isNotNull("exam_date");
        return stuCourseService.count(wrapper);
    }

    @RequestMapping("/getCourseStudentNum")
    public Integer getCourseStudentNum(@RequestParam String courseId){
        QueryWrapper<StuCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.isNull("score");
        wrapper.isNull("exam_date");
        return stuCourseService.count(wrapper);
    }

    @RequestMapping("/updateCourseStudent")
    public Boolean updateCourseStudent(@RequestParam String id,@RequestBody StuCourse stuCourse){
        UpdateWrapper<StuCourse> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        return stuCourseService.update(stuCourse,updateWrapper);
    }

    @RequestMapping("/getCourseStudentById")
    public StuCourse getCourseStudentById(@RequestParam String id){
        QueryWrapper<StuCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return stuCourseService.getOne(wrapper);
    }

}
