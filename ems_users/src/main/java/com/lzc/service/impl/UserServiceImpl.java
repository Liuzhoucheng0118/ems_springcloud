package com.lzc.service.impl;


import com.lzc.entity.User;
import com.lzc.mapper.UserMapper;
import com.lzc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 13:00
 * @Version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        if(!user.getUsername().isEmpty()) {
            User oldUser = findUserName(user.getUsername());
            if(oldUser!=null){
                throw new RuntimeException("用户已经存在");
            }
        }
        userMapper.save(user);
    }

    @Override
    public User findUserName(String username) {
        return userMapper.findUserName(username);
    }

    @Override
    public User login(User user) {
        User userDB = findUserName(user.getUsername());
        if(userDB.getPassword().equals(user.getPassword())){
            return userDB;
        }else{
            throw new RuntimeException("用户名或密码错误");
        }
    }
}
