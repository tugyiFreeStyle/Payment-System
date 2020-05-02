package com.notificationContext.notificationContext.listeners;


import com.notificationContext.notificationContext.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class AccountCreatedEventListener {

    private final EmailService emailService;

    @Autowired
    public AccountCreatedEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @StreamListener(target = Sink.INPUT)
    public void reciveMessage(String msg) throws Exception {
        //hata

        throw new Exception("error occured!");

      //  System.out.println("Messsage recieved  " + msg);

        //rabitmq dan consume edilir
        //emailService.sendEmail();
    }
}
