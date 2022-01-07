package com.lzc.service;

import com.lzc.entity.Emp;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 14:43
 * @Version 1.0
 */
public interface EmpService {
    List<Emp> getEmpList();

    void save(Emp emp);
}
