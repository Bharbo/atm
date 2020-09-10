package ru.sbrf.course.atm.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbrf.course.atm.server.service.StartService;
import ru.sbrf.course.atm.server.support.Response;

@RestController
@RequestMapping("app")
public class StartController {

    StartService startService;

    @Autowired
    public StartController(StartService startService) {
        this.startService = startService;
    }

    @PostMapping("/card")
//вставка карты(клиент вставляет карту, с банкомата на сервер приходит НОМЕР КАРТЫ), response - статус выполнения запроса
    public ResponseEntity<Object> putCard(@RequestBody String cardNumber) {
        Response response = startService.checkCard(cardNumber);
        return response.isStatus() ?
                new ResponseEntity<>(response.getMessage(), HttpStatus.OK) :
                new ResponseEntity<>(response.getMessage(), HttpStatus.CREATED);//CREATED здесь - маркер, для обозначения того что получен отрицательный ответ
    }
}
