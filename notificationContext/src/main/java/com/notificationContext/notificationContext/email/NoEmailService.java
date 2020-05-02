package com.notificationContext.notificationContext.email;


import org.springframework.stereotype.Service;

@Service
public class NoEmailService implements EmailService {

    @Override
    public void sendEmail(String email) {
        //
    }
}
