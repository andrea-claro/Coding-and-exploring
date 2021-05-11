package com.example.testDI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Description {

    @Value("${test.description}")
    private String description;


    public Description(){

    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Description{" +
                "description='" + description + '\'' +
                '}';
    }
}
