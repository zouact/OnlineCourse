package com.master.springcloud.server.workbench.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.master.springcloud.server.workbench.domain.Student;
import com.master.springcloud.server.workbench.domain.StudentState;
import org.apache.ibatis.annotations.Param;

/**
* @author artmaster
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-05-30 10:29:51
* @Entity generator.domain.Student
*/
public interface StudentMapper extends BaseMapper<Student> {
    IPage<StudentState> getStudentStateList(Page<StudentState> page);
    IPage<StudentState> getStudentStateListByCondition(Page<StudentState> page, @Param("studentName") String studentName, @Param("studentId") String studentId);
    StudentState getStudentStateByStuId(@Param("studentId") String studentId);
}




