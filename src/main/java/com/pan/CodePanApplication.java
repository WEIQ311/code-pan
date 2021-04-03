package com.pan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于Spring-boot和elFinder的打造在线文件管理系统，可以用于网盘、云盘
 *
 * @author weiqiang
 * @date 2019/11/25
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.pan", "cn.ablxyw"})
public class CodePanApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodePanApplication.class, args);
    }
}
