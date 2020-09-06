//package ru.sbrf.course.atm.server.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ru.sbrf.course.atm.server.repository.UserRepository;
//import ru.sbrf.course.atm.server.support.Session;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//@Slf4j
//public class SessionService {
//
//    AuthService auth;
//    OperationService op;
//    UserRepository userRepository;
//    Session session;
//
//    @Autowired
//    public SessionService(AuthService auth, OperationService op, UserRepository userRepository) {
//        this.auth = auth;
//        this.op = op;
//        this.userRepository = userRepository;
//        session = null;
//    }
//
//    public void getSession(Map<String, String> authData) {
//
//        //authData прилетает из Atm, сервер отвечает ОК и происходит авторизация
//
//        if (session == null) {
//            session = auth.isAuthorized(authData);
//        } else {
//            log.error("Сессия открыта");
//        }
//    }
//}
