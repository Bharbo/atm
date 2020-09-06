package ru.sbrf.course.atm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.course.atm.server.service.AuthService;
import ru.sbrf.course.atm.server.support.Response;

@RestController
@RequestMapping("app")
public class AuthController {

    protected final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/card")
//вставка карты(клиент вставляет карту, с банкомата на сервер приходит НОМЕР КАРТЫ), response - статус выполнения запроса
    public ResponseEntity<Object> putCard(@RequestBody String cardNumber) {
        Response response = authService.checkCard(cardNumber);
        return response.isStatus() ?
                new ResponseEntity<>(response.getMessage(), HttpStatus.OK) :
                new ResponseEntity<>(response.getMessage(), HttpStatus.CREATED);//CREATED здесь - маркер, для обозначения того что получен отрицательный ответ
    }

    @PostMapping("/login")//ввод пароля от карты, response - статус выполнения запроса
    public ResponseEntity<Object> logIn(@RequestBody String pass) {
        Response response = authService.checkPass(pass);
        return response.isStatus() ?
                new ResponseEntity<>(response.getMessage(), HttpStatus.OK) :
                new ResponseEntity<>(response.getMessage(), HttpStatus.CREATED);
    }
}
