package ru.sbrf.course.atm.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sbrf.course.atm.server.model.Account;
import ru.sbrf.course.atm.server.model.Operation;
import ru.sbrf.course.atm.server.repository.UserRepository;
import ru.sbrf.course.atm.server.support.Session;
import ru.sbrf.course.atm.types.OpType;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SessionService {

    AuthorizationService auth;
    OperationService op;
    UserRepository userRepository;
    Session session;

    private static final Logger log = LoggerFactory.getLogger(SessionService.class);

    @Autowired
    public SessionService(AuthorizationService auth, OperationService op, UserRepository userRepository) {
        this.auth = auth;
        this.op = op;
        this.userRepository = userRepository;
        session = null;
    }

    public void getSession() {

        //authData прилетает в get запросе из Atm, сервер отвечает ОК и происходит авторизация
        Map<String, String> authData = new HashMap<>();
        authData.put("number", "1111222233334444encode");//номер карты
        authData.put("pass", "1234encode");//пароль
        authData.put("passType", "JustPass");//способ аутентификации

        if (session == null) {
            session = auth.isAuthorized(authData);
        } else {
            log.error("Сессия уже открыта");
        }

//        //operation прилетает в post запросе из Atm
//        Date date = new Date(2048, Calendar.SEPTEMBER, 16, 22, 59, 59);
//        Operation operation = new Operation(account, OpType.BALANCE, date);
//        //
//
//        BigDecimal balance = op.balanceRequestWithCard(operation);

    }
}
