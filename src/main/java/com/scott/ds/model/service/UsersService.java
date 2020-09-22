package com.scott.ds.model.service;

import com.scott.ds.model.entity.Users;

import java.util.List;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :UsersService
 * @description :
 * @data :2020/9/22 0022 上午 9:55
 * @status : 编写
 **/
public interface UsersService {

    public List<Users> selectUsersMaster();

    public List<Users> selectUsersSlave();
}
