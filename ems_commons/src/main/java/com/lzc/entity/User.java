package com.lzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;
import java.util.Date;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 12:16
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer Id;
    private String username;
    private String sex;
    private String password;
    private String name;
    private Integer age;
    private Date createDate;
}
