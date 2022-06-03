package com.master.springcloud.server.settings.controller;

import cn.hutool.core.lang.UUID;
import com.master.springcloud.server.settings.commons.enity.Constant;
import com.master.springcloud.server.settings.commons.enity.ReturnObject;
import com.master.springcloud.server.settings.domain.Admin;
import com.master.springcloud.server.settings.domain.Course;
import com.master.springcloud.server.settings.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/workbench/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        Admin attribute = (Admin)session.getAttribute(Constant.SESSION_ADMIN);
        if(attribute!=null) {
            session.removeAttribute(Constant.SESSION_ADMIN);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/course/save")
    public Object saveAdmin(Course course) {
         ReturnObject returnObject = new ReturnObject();
         course.setId(UUID.randomUUID().toString(true));
        try {
            Boolean isSucceed = adminService.saveCourse(course);
            if (isSucceed) {
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("添加成功!");
                returnObject.setData(course);
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("系统繁忙，稍后再试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }


    @RequestMapping("/course/queryList")
    public Object queryCourseList(int pageSize,int pageNum){
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Course> courseList = adminService.queryCourseList(pageSize,pageNum);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功!");
            HashMap<String, Object> objectObjectHashMap = new HashMap<>(2);
            objectObjectHashMap.put("data",courseList);
            objectObjectHashMap.put("length",adminService.queryCourseNum());
            returnObject.setData(objectObjectHashMap);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }

    @RequestMapping("/course/queryListByCondition")
    public Object queryCourseListByCondition(int pageSize,int pageNum,String courseName,String courseId){
        ReturnObject returnObject = new ReturnObject();
        try {
            List<Course> courseList = adminService.queryCourseListByCondition(pageSize,pageNum,courseName,courseId);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功!");
            HashMap<String, Object> objectObjectHashMap = new HashMap<>(2);
            objectObjectHashMap.put("data",courseList);
            objectObjectHashMap.put("length",adminService.queryCourseNumByCondition(courseName,courseId));
            returnObject.setData(objectObjectHashMap);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }


    @RequestMapping("/course/queryById")
    public Object queryCourseById(String id){
        ReturnObject returnObject = new ReturnObject();
        try {
            Course course = adminService.queryCourseOne(id);
            returnObject.setCode(Constant.SUCCESS);
            returnObject.setMessage("查询成功!");
            returnObject.setData(course);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }

    @RequestMapping("/course/update")
    public Object updateCourse(Course course){
        ReturnObject returnObject = new ReturnObject();
        try {
            Boolean isSucceed = adminService.saveCourse(course);
            if (isSucceed) {
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("更新成功!");
                returnObject.setData(course);
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("系统繁忙，稍后再试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }

    @RequestMapping("/course/delete")
    public Object deleteCourse(String[] id){
        ReturnObject returnObject = new ReturnObject();
        try {
            Boolean isSucceed = adminService.deleteCourse(id);
            if (isSucceed) {
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("删除成功!");
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("系统繁忙，稍后再试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("系统繁忙，稍后再试！");
        }
        return returnObject;
    }


}
