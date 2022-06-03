package com.master.springcloud.server.workbench.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.master.springcloud.server.workbench.domain.Student;
import com.master.springcloud.server.workbench.domain.StudentState;
import com.master.springcloud.server.workbench.mapper.StudentMapper;
import com.master.springcloud.server.workbench.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
* @author artmaster
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-05-30 10:29:51
*/
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService {

    private final StudentMapper studentMapper;

    @Override
    public IPage<StudentState> getStudentStateList(Page<StudentState> page) {
        return studentMapper.getStudentStateList(page);
    }

    @Override
    public IPage<StudentState> getStudentStateListByCondition(Page<StudentState> page, String studentName, String studentId) {
        return studentMapper.getStudentStateListByCondition(page, studentName, studentId);
    }

    @Override
    public StudentState getStudentStateByStuId(String studentId) {
        return studentMapper.getStudentStateByStuId(studentId);
    }
}




