package com.master.springcloud.server.settings.controller.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminWebController")
@RequestMapping("/workbench/admin")
public class AdminController {

    @RequestMapping("/index")
    public String index() {
        return "workbench/admin/index";
    }

    @RequestMapping("/course")
    public String course() {
        return "workbench/admin/courseMsg";
    }

    @RequestMapping("/student")
    public String student() {
        return "workbench/admin/studentMsg";
    }

    @RequestMapping("/study")
    public String study() {
        return "workbench/admin/studyState";
    }

    @RequestMapping("/studentCourse")
    public String studentCourse() {
        return "workbench/admin/studentCourse";
    }

    @RequestMapping("/CourseStudent")
    public String CourseStudent() {
        return "workbench/admin/CourseStudent";
    }

}
