package com.lzc.controller;

import com.lzc.clients.FileFeign;
import com.lzc.entity.Emp;
import com.lzc.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 14:42
 * @Version 1.0
 */
@RestController
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private FileFeign fileFeign;

    @GetMapping("/emp/findAll")
    public List<Emp> getEmp(){
        List<Emp> empList = empService.getEmpList();
        return empList;
    }

    @PostMapping("/emp/save")
    public Map<String,Object> save(Emp emp, MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        try{
            //文件上传
            Map<String, Object> result = fileFeign.uploadFile(file);
            if(result.get("state").equals(false)) throw new RuntimeException("文件上传失败");

            //保存实体类
            emp.setPath((String)result.get("url"));
            empService.save(emp);

            map.put("msg","保存成功");
            map.put("state",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg",e.getMessage());
            map.put("state",false);
        }
        return map;
    }
}
