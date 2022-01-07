package com.lzc.controller;

import com.lzc.entity.User;
import com.lzc.service.UserService;
import com.lzc.util.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 11:49
 * @Version 1.0
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        try{
            User userDB = userService.login(user);
            map.put("user",userDB);
            map.put("msg","登录成功");
            map.put("state",true);
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("state",false);
        }
        return map;
    }

    /**
     * 生成验证码
     */
    @GetMapping("/user/getCode")
    public Map<String,Object> getCodeImage(){
        Map<String,Object> map = new HashMap<>();
        //生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        log.info("验证码[{}]",code);
        //缓存
        String codeKey = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(codeKey,code,60, TimeUnit.SECONDS);
        //生成byte数组
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.generateVerifyCode(120,60,code, byteArrayOutputStream);
        String src ="data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
        //响应数据
        map.put("src",src);
        map.put("codeKey",codeKey);
        return map;
    }

    /**
     * 用户注册
     * @param user  用户实体
     * @param code  验证码
     * @param codeKey   验证码缓存key
     * @return
     */
    @PostMapping("/user/register")
    public Map<String,Object> registerUser(@RequestBody User user,String code,String codeKey){
        Map<String,Object> map = new HashMap<>();
        try {
            String oldCode = (String) redisTemplate.opsForValue().get(codeKey);
            if(oldCode.isEmpty()){
                throw new RuntimeException("验证码生效");
            }
            if(code.equalsIgnoreCase(oldCode)){
                user.setCreateDate(new Date());
                userService.save(user);

                map.put("msg","用户注册成功");
                map.put("state",true);
            }else{
                throw new RuntimeException(("输入的验证码不一致"));
            }
        }catch (Exception e){
            map.put("msg",e.getMessage());
            map.put("state",false);
        }
        return map;
    }
}
