package org.emailUtility.controller;

import org.emailUtility.dto.EmailUtilityDTO;
import org.emailUtility.service.EmailUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailUtilityController {

    @Autowired
    private EmailUtilityService emailUtilityService;

    @GetMapping
    public String test(){
        return "running";
    }

    @PostMapping("/simpleEmail")
    public String sendSimpleEmail(@RequestBody EmailUtilityDTO emailUtilityDTO){

       return  emailUtilityService.sendSimpleMail(emailUtilityDTO);

    }
}
