package com.master.springcloud.server.settings.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.settings.domain.CourseStudent;
import com.master.springcloud.server.settings.domain.StuCourse;
import com.master.springcloud.server.settings.domain.StudentCourse;
import com.master.springcloud.server.settings.domain.StudentState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service-workbench")
public interface StuCourseService {

    @RequestMapping("/workbench/stuCourse/save")
    public Boolean saveStuCourse(@RequestBody StuCourse stuCourse);

    @RequestMapping("/workbench/stuCourse/queryList")
    public List<StudentCourse> queryList(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("stuId") String stuId);

    @RequestMapping("/workbench/stuCourse/queryNum")
    public int queryNum(@RequestParam("stuId") String stuId);

    @RequestMapping("/workbench/stuCourse/queryListOK")
    public List<StudentCourse> queryListOK(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam("stuId") String stuId);

    @RequestMapping("/workbench/stuCourse/queryNumOK")
    public int queryNumOK(@RequestParam("stuId") String stuId);

    @RequestMapping("/workbench/stuCourse/delete")
    public Boolean deleteStuCourse(@RequestParam("id") String id);

    @GetMapping("/workbench/stuCourse/StudentState")
    public List<StudentState> getStudentState(@RequestParam int pageSize, @RequestParam int pageNum);

    @GetMapping("/workbench/stuCourse/StudentStateByCondition")
    public List<StudentState> getStudentStateByCondition(@RequestParam int pageSize, @RequestParam int pageNum,@RequestParam String studentId,@RequestParam String studentName);

    @GetMapping("/workbench/stuCourse/StudentStateById")
    public StudentState getStudentStateById(@RequestParam String studentId);

    @RequestMapping("/workbench/stuCourse/getCourseStudent")
    public List<CourseStudent> getCourseStudent(@RequestParam String courseId, @RequestParam int pageNum, @RequestParam int pageSize);

    @RequestMapping("/workbench/stuCourse/getCourseStudentOK")
    public List<CourseStudent> getCourseStudentOK(@RequestParam String courseId,@RequestParam int pageNum,@RequestParam int pageSize);

    @RequestMapping("/workbench/stuCourse/getCourseStudentNumOk")
    public Integer getCourseStudentNumOk(@RequestParam String courseId);

    @RequestMapping("/workbench/stuCourse/getCourseStudentNum")
    public Integer getCourseStudentNum(@RequestParam String courseId);

    @RequestMapping("/workbench/stuCourse/updateCourseStudent")
    public Boolean updateCourseStudent(@RequestParam String id,@RequestBody StuCourse stuCourse);

    @RequestMapping("/workbench/stuCourse/getCourseStudentById")
    public StuCourse getCourseStudentById(@RequestParam String id);

}
