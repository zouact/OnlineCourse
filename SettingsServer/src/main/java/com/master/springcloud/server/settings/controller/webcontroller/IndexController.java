package com.master.springcloud.server.settings.controller.webcontroller;

import com.master.springcloud.server.settings.commons.enity.Constant;
import com.master.springcloud.server.settings.commons.enity.ReturnObject;
import com.master.springcloud.server.settings.domain.Admin;
import com.master.springcloud.server.settings.domain.Student;
import com.master.springcloud.server.settings.service.AdminService;
import com.master.springcloud.server.settings.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    final private StudentService studentService;
    final private AdminService adminService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "setting/index";
    }

    @RequestMapping("/admin/login")
    @ResponseBody
    public Object login(Admin admin, HttpSession session) {
        ReturnObject returnObject = new ReturnObject();
        try {
            Admin result = adminService.queryAdmin(admin);
            if (result != null) {
                session.setAttribute(Constant.SESSION_ADMIN, result);
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("登录成功!");
                returnObject.setData(result);
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("登录失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("登录失败！");
        }
        return returnObject;
    }

    @PostMapping("/student/register")
    @ResponseBody
    public Object addStudent(Student student) {
        ReturnObject returnObject = new ReturnObject();
        try {
            Boolean isSucceed = studentService.addStudent(student);
            if (isSucceed) {
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("添加成功");
                returnObject.setData(student);
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("添加失败");
        }
        return returnObject;
    }

    @PostMapping("/student/login")
    @ResponseBody
    public Object queryStudent(Student student,HttpSession session) {
        ReturnObject returnObject = new ReturnObject();
        try {
            Student result = studentService.queryStudent(student);
            if (result != null) {
                session.setAttribute(Constant.SESSION_STUDENT,result);
                returnObject.setCode(Constant.SUCCESS);
                returnObject.setMessage("登录成功!");
                returnObject.setData(result);
            } else {
                returnObject.setCode(Constant.FAIL);
                returnObject.setMessage("登录失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constant.FAIL);
            returnObject.setMessage("登录失败！");
        }
        return returnObject;
    }
}
