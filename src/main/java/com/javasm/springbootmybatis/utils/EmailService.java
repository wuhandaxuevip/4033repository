package com.javasm.springbootmybatis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/6/30-16:14
 * @Since:jdk1.8
 */

@Component
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendEmail(String email) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(3);

        //耗时的操作
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("上课通知书");
        simpleMailMessage.setText("张春阳，赶紧过来上课====="+"666666");
        simpleMailMessage.setFrom("方老师<wuhandaxuevip@163.com>");
        simpleMailMessage.setTo(email);
        javaMailSender.send(simpleMailMessage);
    }
}
