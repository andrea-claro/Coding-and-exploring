package com.example.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Secured("ROLE_GUEST")
    @RequestMapping("/list")
    public String list(){
        return "list posts...";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/draft")
    public String draft(){
        return "list drafts...";
    }

    @Secured({"ROLE_ADMIN", "ROLE_ADMIN"})
    @RequestMapping("/add")
    public String add(){
        foo();
        return "add posts...";
    }

    private void foo(){

    }
}
