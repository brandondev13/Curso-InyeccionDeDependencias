package com.inyeccion.mail;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("smtp")
public class SmtpMailSender implements MailSender{


    private Log Log = LogFactory.getLog(SmtpMailSender.class);

    @Override
    public void send(String to, String subject, String body) {

        Log.info("Sending SMTP mail to " + to);
        Log.info("with subject " + subject);
        Log.info("and body " + body);
    }
}
