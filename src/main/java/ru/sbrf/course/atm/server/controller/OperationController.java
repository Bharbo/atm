package ru.sbrf.course.atm.server.controller;

import org.springframework.web.bind.annotation.*;
import ru.sbrf.course.atm.server.service.OperationService;

import java.math.BigDecimal;

@RestController
@RequestMapping("operation")
public class OperationController {

    OperationService operationService;

    @GetMapping("/balance")//account number, response = (status, сумма на счете)
    public String runOperation() {
        BigDecimal balance = operationService.balanceRequest();
        if (balance.equals(new BigDecimal(0)))
            return "Ваша казна пуста, Милорд ;(";
        else
            return "На вашем счету " + balance + " монет";
    }
}
