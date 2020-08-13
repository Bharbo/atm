package ru.sbrf.course.atm.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Session {

    Authorization auth;

    @Autowired
    public Session(Authorization auth) {
        this.auth = auth;
    }

    public void getSession() {
        // в реале эти данные должны прилетать в хост из банкомата
        String cardNumber = "1111-1111-1111-1111";
        String pin = "1234";

        Account account = auth.isAuthorized(cardNumber, pin);

    }
}
