package com.lzc.mapper;

import com.lzc.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 12:48
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    void save(User user);

    User findUserName(String username);

}
