package com.inyeccion.controller;

import com.inyeccion.mail.MailSender;
import com.inyeccion.mail.MockMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailSender mailSender;

    @RequestMapping("/mail")
    public String mail() {
        mailSender.send("mail@example.com", "A test mail", "Body of the test mail");
        return "Mail sent";
    }



}
