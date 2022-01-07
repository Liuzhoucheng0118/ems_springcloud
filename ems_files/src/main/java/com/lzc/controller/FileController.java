package com.lzc.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 15:31
 * @Version 1.0
 */
@RestController
@Slf4j
public class FileController {

    @Value("${upload.dir}")
    private String realPath;

    @Value("${server.port}")
    private String port;

    /**
     * 下载到本地
     * @param photo
     * @return
     */
    @PostMapping("/file/upload")
    public Map<String,Object> uploadFile(MultipartFile photo){
        Map<String,Object> map= new HashMap<>();

        String originalFilename = photo.getOriginalFilename();
        log.info("文件名:{}",originalFilename);
        try {
            //设置新的文件名
            String ext = FilenameUtils.getExtension(originalFilename);
            String newFilename = UUID.randomUUID().toString()+"."+ext;
            //文件上传
            photo.transferTo(new File(realPath,newFilename));
            //传回访问路径
            String url = "http://localhost:"+port+"/"+newFilename;
            map.put("url",url);
            map.put("state",true);
        }catch (Exception e){
            map.put("msg","文件上传失败");
            map.put("state",false);
        }
        return map;
    }
}
