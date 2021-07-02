package com.javasm.springbootmybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/7/2-15:09
 * @Since:jdk1.8
 */
@RestController
public class AdminController {

    @GetMapping("git")
    public String git(){
        return "git";
    }

}
