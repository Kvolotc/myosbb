package com.softserve.osbb.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softserve.osbb.model.Mail;
import com.softserve.osbb.service.impl.MailSenderImpl;

/**
 * Created by Anastasiia Fedorak on 8/13/16.
 */
@RestController
@CrossOrigin
@RequestMapping("/restful/mail")
public class MailController {
    private static Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailSenderImpl sender;

    @RequestMapping(method = RequestMethod.POST)
    public void sendMail(@RequestBody Mail mail){
        if (mail == null) logger.warn("void mail");
        logger.info("sending mail to "+ mail.getTo());
        try {
            sender.send(mail.getTo(), mail.getSubject(), mail.getText());
        } catch (MessagingException e) {
            logger.error("cannot send message to" + mail.getTo());
            logger.info("subject: " + mail.getSubject());
            logger.info("text: " + mail.getText());
        }
    }
}
