package com.lzc.service.impl;

import com.lzc.entity.Emp;
import com.lzc.mapper.EmpMapper;
import com.lzc.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 14:43
 * @Version 1.0
 */
@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> getEmpList() {
        return empMapper.getEmpList();
    }

    @Override
    public void save(Emp emp) {
        try{
            empMapper.save(emp);
        }catch (Exception e){
            throw new RuntimeException("实体类保存失败");
        }
    }
}
