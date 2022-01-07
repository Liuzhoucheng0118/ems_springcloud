package com.lzc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author liuzhoucheng
 * @Date 2022/1/7 12:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
   private Integer Id;
   private String name;
   private Integer age;
   private String path;
   private Double salary;
}
