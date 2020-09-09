package ru.sbrf.course.atm.server.controller;

import org.springframework.web.bind.annotation.*;
import ru.sbrf.course.atm.server.service.OperationService;

import java.math.BigDecimal;

@RestController
@RequestMapping("operation")
public class OperationController {

    OperationService operationService;

    @GetMapping("/balance")//account number, response = (status, сумма на счете)
    public BigDecimal runOperation() {
        return operationService.balanceRequest();
    }

}
