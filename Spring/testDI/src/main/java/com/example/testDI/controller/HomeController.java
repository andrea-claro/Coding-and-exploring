package com.example.testDI.controller;

import com.example.testDI.service.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${test.name}")
    private String testName;

    private Description description;

    @RequestMapping("/testname")
    public String test(){
        String temp = this.testName;
        return temp;
    }

    @RequestMapping("/classname")
    public String cls(){
        String temp = this.getClass().getName();
        return temp;
    }

    @RequestMapping("/description")
    public String desc(){
        String temp = description.toString();
        return temp;
    }

    @Autowired
    public void setDescription(Description description){
        this.description = description;
    }
}
