package com.example.Beans.DI;

import org.springframework.stereotype.Service;

@Service("userNotificationService")
public class NotificationService {

    public NotificationService(){

    }

    public void send(){

    }

    public void sendAsync(){

    }

    @Override
    public String toString(){
        return "NotificationService{}";
    }
}
