package com.example.Eidiko.Mail.Sender.controller;


import com.example.Eidiko.Mail.Sender.model.Info;
import com.example.Eidiko.Mail.Sender.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class InfoController {

    @Autowired
    private InfoService infoService;


    @PostMapping("/register")
    public Info register(@RequestBody Info info){
        return infoService.register(info);
    }

    @PostMapping("/login")
    public String login(@RequestBody Info info){
        return infoService.verify(info);
    }

}
