package org.emailUtility.service;

import org.emailUtility.dto.EmailUtilityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailUtilityService {

    Logger log = LoggerFactory.getLogger(EmailUtilityService.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public String sendSimpleMail(EmailUtilityDTO emailUtilityDTO){
    log.info("Inside sendSimple email method");
        try{
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            log.debug("Email from : "+emailFrom);
            simpleMailMessage.setFrom(emailFrom);
            log.debug("Email To: "+emailUtilityDTO.getToEmail());
            simpleMailMessage.setTo(emailUtilityDTO.getToEmail());
            log.debug("Email subject: "+emailUtilityDTO.getSubject());
            simpleMailMessage.setSubject(emailUtilityDTO.getSubject());
            log.debug("Email Body "+ emailUtilityDTO.getMessageBody());
            simpleMailMessage.setText(emailUtilityDTO.getMessageBody());
            javaMailSender.send(simpleMailMessage);
            log.info("Email sent successfully");
            return "mail sent successfully";
        }catch (Exception e){
            log.error(e.getMessage());
            return "Failed to send the email";
        }
    }
}
