package com.master.springcloud.server.workbench.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.master.springcloud.server.workbench.domain.Student;
import com.master.springcloud.server.workbench.domain.StudentState;

/**
* @author artmaster
* @description 针对表【student】的数据库操作Service
* @createDate 2022-05-30 10:29:51
*/
public interface StudentService extends IService<Student> {

    IPage<StudentState> getStudentStateList(Page<StudentState> page);
    IPage<StudentState> getStudentStateListByCondition(Page<StudentState> page, String studentName,String studentId);
    StudentState getStudentStateByStuId(String studentId);
}
