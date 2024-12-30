package com.TenantMate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BasicController {

    @GetMapping("/")
    public String home(){
        return "this is deployed to aws ec2 and s3 bucket";
    }
}
