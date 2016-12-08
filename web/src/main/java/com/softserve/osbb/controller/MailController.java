/*
 * Project “OSBB” – a web-application which is a godsend for condominium head, managers and 
 * residents. It offers a very easy way to manage accounting and residents, events and 
 * organizational issues. It represents a simple design and great functionality that is needed 
 * for managing. 
 */
package com.softserve.osbb.controller;

import com.softserve.osbb.model.Mail;
import com.softserve.osbb.model.Region;
import com.softserve.osbb.service.impl.MailSenderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.mail.MessagingException;

/**
 * Created by Anastasiia Fedorak on 8/13/16.
 */
@RestController
@CrossOrigin
@RequestMapping("/restful/mail")
public class MailController {
    
    private static final Logger logger = LoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailSenderImpl sender;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Mail> sendMail(@RequestBody Mail mail){
        if (mail == null) {
            logger.warn("void mail");
        }
        
        logger.info("sending mail to "+ mail.getTo());
        
        try {
            sender.send( mail.getTo(), mail.getSubject(), mail.getText());
            return new ResponseEntity<>(new Mail(mail.getTo(),mail.getText()), HttpStatus.OK);
        } catch (MessagingException e) {
            logger.error("cannot send message to" + mail.getTo());
            logger.info("subject: " + mail.getSubject());
            logger.info("text: " + mail.getText());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	
}