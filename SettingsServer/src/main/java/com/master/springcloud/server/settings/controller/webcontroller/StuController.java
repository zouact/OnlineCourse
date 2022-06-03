package com.master.springcloud.server.settings.controller.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/workbench/student")
public class StuController {

        @RequestMapping("/index")
        public String index() {
            return "workbench/stu/index";
        }

        @RequestMapping("/myCourse")
        public String myCourse() {
            return "workbench/stu/myCourse";
        }

        @RequestMapping("/onlineCourse")
        public String onlineCourse() {
            return "workbench/stu/onlineCourse";
        }

        @RequestMapping("/studentState")
        public String studentState() {
            return "workbench/stu/studentState";
        }

}
