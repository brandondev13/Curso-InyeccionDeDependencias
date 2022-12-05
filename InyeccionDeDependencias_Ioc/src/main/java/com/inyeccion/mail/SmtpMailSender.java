package com.inyeccion.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


public class SmtpMailSender implements MailSender{


    private Log Log = LogFactory.getLog(SmtpMailSender.class);

    private JavaMailSender javaMailSender;

    public SmtpMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String to, String subject, String body) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message, true); //true indica
        //Multipart message


        helper.setSubject(subject);
        helper.setTo(to);
        helper.setText(body, true);

        // continue using helper for more functionalities
        //like adding attachments, etc...

        javaMailSender.send(message);
    }
}
