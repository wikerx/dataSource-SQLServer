package com.scott.ds.model.controller;

import com.alibaba.fastjson.JSON;
import com.scott.ds.model.entity.Users;
import com.scott.ds.model.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :TestController
 * @description :
 * @data :2020/9/22 0022 上午 9:57
 * @status : 编写
 **/
@RestController
@Slf4j
public class TestController {
    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "queryUsers")
    public Object queryUsers(){
        List<Users> listMaster = usersService.selectUsersMaster();
        List<Users> listSlave = usersService.selectUsersSlave();
        log.info("主节点用户：{}", JSON.toJSONString(listMaster));
        log.info("辅助点用户：{}", JSON.toJSONString(listSlave));
        return JSON.toJSONString(listMaster) + "\n\r" + JSON.toJSONString(listSlave);
    }

}
