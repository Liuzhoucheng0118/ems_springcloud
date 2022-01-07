package com.lzc.mapper;

import com.lzc.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 14:44
 * @Version 1.0
 */
@Mapper
public interface EmpMapper {

    List<Emp> getEmpList();

    void save(Emp emp);
}
