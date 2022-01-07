package com.lzc.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 15:30
 * @Version 1.0
 */
@FeignClient(value = "files")
public interface FileFeign {
    @PostMapping(value = "/file/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String,Object> uploadFile(@RequestPart("photo") MultipartFile photo);
}
