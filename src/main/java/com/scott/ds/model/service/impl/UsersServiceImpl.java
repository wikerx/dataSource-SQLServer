package com.scott.ds.model.service.impl;

import com.scott.ds.dataSource.annotation.DataSource;
import com.scott.ds.model.entity.Users;
import com.scott.ds.model.mapper.UsersMapper;
import com.scott.ds.model.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :UsersServiceImpl
 * @description :
 * @data :2020/9/22 0022 上午 9:56
 * @status : 编写
 **/
@Service
@Slf4j
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 主节点
     * @return
     */
    @Override
    @DataSource
    public List<Users> selectUsersMaster() {
        return usersMapper.selectUsers();
    }

    /**
     * 辅助接点
     * @return
     */
    @Override
    @DataSource("slave1")
    public List<Users> selectUsersSlave() {
        return usersMapper.selectUsers();
    }


}
