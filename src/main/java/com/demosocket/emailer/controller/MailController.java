package com.demosocket.emailer.controller;

import com.demosocket.emailer.model.Mail;
import com.demosocket.emailer.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MailController {

    final private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public String getMailForm(){
        return "index";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Mail mail){
        mailService.send(mail);
        return "index";
    }
}
