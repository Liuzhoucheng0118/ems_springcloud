package com.lzc.service;

import com.lzc.entity.User;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 12:59
 * @Version 1.0
 */
public interface UserService {
    void save(User user);

    User findUserName(String username);

    User login(User user);
}
