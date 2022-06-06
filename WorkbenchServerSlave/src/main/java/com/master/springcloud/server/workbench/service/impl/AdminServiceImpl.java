package com.master.springcloud.server.workbench.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.master.springcloud.server.workbench.domain.Admin;
import com.master.springcloud.server.workbench.mapper.AdminMapper;
import com.master.springcloud.server.workbench.service.AdminService;
import org.springframework.stereotype.Service;

/**
* @author artmaster
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-05-30 10:29:51
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService {

}




