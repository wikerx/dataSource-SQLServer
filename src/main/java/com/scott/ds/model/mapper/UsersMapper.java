package com.scott.ds.model.mapper;

import com.scott.ds.model.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :UsersMapper
 * @description :
 * @data :2020/9/22 0022 上午 9:53
 * @status : 编写
 **/
@Mapper
public interface UsersMapper {
    /**
     * 查询用户信息
     * @return
     */
    @Select("select * from users WITH(NOLOCK)")
    List<Users> selectUsers();

}
