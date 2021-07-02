package com.javasm.springbootmybatis.controller;

import com.javasm.springbootmybatis.utils.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/6/30-14:51
 * @Since:jdk1.8
 */
@RestController
public class PaggeJumpController {
  /*  @GetMapping("/")
    public String pageJump(){
        return "redirect:login.html";
    }*/

  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private EmailService emailService;

  @GetMapping("getEmailCode")
  public String getEmailCode(String email) throws InterruptedException {

    for (int i=0;i<100;i++){
      emailService.sendEmail(email);
    }

    stringRedisTemplate.opsForValue().set(email,"666666",5,TimeUnit.MINUTES);

    return "success";
  }

}
